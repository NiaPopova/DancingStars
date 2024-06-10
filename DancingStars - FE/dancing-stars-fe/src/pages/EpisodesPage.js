import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/episodes.scss';
import EpisodeTemplate from '../components/EpisodeTemplate';

const EpisodesPage = () => {
  const [episodes, setEpisodes] = useState([]);
  const [selectedEpisode, setSelectedEpisode] = useState(null);

  useEffect(() => {
    // Fetch episodes data from your API
    axios.get('http://localhost:8080/episodes') // Replace with your actual API endpoint
      .then(response => {
        setEpisodes(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the episodes!', error);
      });
  }, []);

  const handleEpisodeChange = (event) => {
    const episodeDate = event.target.value;
    const episode = episodes.find(e => e.date === episodeDate);
    setSelectedEpisode(episode);
  };

  return (
    <div className="container episodes-container">
      <main className="episodes-main">
        <div className="form-group">
          <label htmlFor="episodeSelect">Select an Episode:</label>
          <select className="form-control" id="episodeSelect" onChange={handleEpisodeChange}>
            <option value="0">Select an episode</option>
            {episodes.map(episode => (
              <option key={episode.date} value={episode.winnerTeamSMS}>{episode.date}</option>
            ))}
          </select>
        </div>

        {selectedEpisode && <EpisodeTemplate episode={selectedEpisode} />}
      </main>
    </div>
  );
};

export default EpisodesPage;