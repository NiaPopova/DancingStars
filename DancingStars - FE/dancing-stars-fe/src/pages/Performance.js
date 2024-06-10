import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../styles/performance.scss';
import { formatDate } from '../utils/dateUtils';

const Performance = () => {
  const [performances, setPerfomances] = useState([]);
  const [selectedPerformance, setSelectedPerformance] = useState(null);
  const [episodes, setEpisodes] = useState([]);
  const [juryScores, setJuryScores] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/performances/details')
      .then(response => {
        setPerfomances(response.data);
        filterEpisodes(response.data);
      })
      .catch(error => console.error('Error fetching episodes:', error));

    getJuryScores();
  }, []);

  const handlePerformanceSelect = (episodeDate) => {
    const performanceToSet = performances.find(p => p.episodeDate === episodeDate);
    setSelectedPerformance(performanceToSet);
  };

  const filterEpisodes = (performances) => {
    const episodes = [];

    performances.forEach(p => {
      if (episodes.findIndex(e => e.episodeTheme === p.episodeTheme) < 0)
        episodes.push(p)
    });

    setEpisodes(episodes);
  };

  const getJuryScores = async () => {
    axios.get('http://localhost:8080/performances/jury-scores')
      .then(response => {
        setJuryScores(response.data)
      })
      .catch(error => console.error('Error fetching jury scores:', error));
  }

  return (
    <div className="performance-container">
      <div className="performance-header">Performances</div>
      <div className="form-group">
        <label htmlFor="episode-select">Select Episode:</label>
        <select disabled={episodes.length < 1} id="episode-select" className="form-control" onChange={(e) => handlePerformanceSelect(e.target.value)}>
          <option value="">Select...</option>
          {episodes.map((episode, index) => (
            <option key={index} value={episode.episodeDate}>{episode.episodeTheme}</option>
          ))}
        </select>
      </div>
      {selectedPerformance && (
        <div className="episode-details">
          <h2>{selectedPerformance.episodeTheme}</h2>
          <p>Date: {formatDate(selectedPerformance.episodeDate)}</p>
          <div className="teams-dances">
            {performances && performances.filter((p) => p.episodeDate === selectedPerformance.episodeDate).map((team, index) => (
              <div key={index} className="team-dance">
                {team.photo && (
                  <img src={require(`../assets/${team.photo}`)} className="card-img-top" alt={team.participantName} />
                )}
                <h3>{team.participantName} & {team.professionalName}</h3>
                <p>Dance: {team.danceName}</p>
                <p>Jury Score: {team.totalScore}</p>

                {
                  juryScores &&
                  (<p>Average Jury Score: {juryScores.find(sc => sc.performanceId === team.performanceId).averageJuryScore}</p>)
                }

                <p>Audience Score: {team.audienceScore}</p>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default Performance;
