import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './styles/performance.scss';
import { formatDate } from './utils/dateUtils';

const Performance = () => {
  const [performances, setPerfomances] = useState([]);
  const [selectedPerformance, setSelectedPerformance] = useState(null);
  const [episodes, setEpisodes] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/performances')
      .then(response => {
        console.log(response.data)
        setPerfomances(response.data);
        filterEpisodes(response.data);
      })
      .catch(error => console.error('Error fetching episodes:', error));
  }, []);

  const handlePerformanceSelect = (episodeDate) => {
    const performanceToSet = performances.find(p => p.episode.date === episodeDate);
    setSelectedPerformance(performanceToSet);
    console.log(performanceToSet);
    console.log(performances.filter((p) => p.episode.date === performanceToSet.episode.date))
  };

  const filterEpisodes = (performances) => {
    const episodes = [];

    performances.forEach(p => {
      if (episodes.findIndex(e => e.theme === p.episode.theme) < 0)
        episodes.push(p.episode)
    });

    setEpisodes(episodes);
  };

  const calculateAverage = (scores) => {
    if (!scores || scores.length === 0) return 0;
    const sum = scores.reduce((a, b) => a + b, 0);
    return (sum / scores.length).toFixed(2);
  };

  return (
    <div className="performance-container">
      <div className="performance-header">Performances</div>
      <div className="form-group">
        <label htmlFor="episode-select">Select Episode:</label>
        <select disabled={episodes.length < 1} id="episode-select" className="form-control" onChange={(e) => handlePerformanceSelect(e.target.value)}>
          <option value="">Select...</option>
          {episodes.map((episode, index) => (
            <option key={index} value={episode.date}>{episode.theme}</option>
          ))}
        </select>
      </div>
      {selectedPerformance && (
        <div className="episode-details">
          <h2>{selectedPerformance.episode.theme}</h2>
          <p>Date: {formatDate(selectedPerformance.episode.date)}</p>
          <div className="teams-dances">
            {performances && performances.filter((p) => p.episode.date === selectedPerformance.episode.date).map((team, index) => (
              <div key={index} className="team-dance">
                {/* {team.episode.winnerTeam.photo && (
                  <img src={require(`${team.episode.winnerTeam.photo}`)} className="card-img-top" alt={team.episode.winnerTeam.name} />
                )} */}
                <h3>{team.episode.winnerTeam.participantName} & {team.episode.winnerTeam.professionalName}</h3>
                <p>Dance: {team.dance.name}</p>
                <p>Average Jury Score: {calculateAverage(team.juryScores)}</p>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default Performance;
