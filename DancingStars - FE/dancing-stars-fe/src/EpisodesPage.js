import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './styles/episodes.scss';

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
    const episodeId = event.target.value;
    const episode = episodes.find(e => e.winnerTeamSMS === episodeId);
    setSelectedEpisode(episode);
  };

  return (
    <div className="container episodes-container">
      <header className="home-header">
        <div className="user-info">
          <i className="bi bi-person-circle user-icon"></i>
          <span className="user-email">user@example.com</span>
        </div>
      </header>

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

        {selectedEpisode && (
          <div className="episode-details">
            <h1>{selectedEpisode.date}</h1>
            <p><strong>Dance of the Week:</strong> {selectedEpisode.theme}</p>
            {/* <div className="teams-scores">
              {selectedEpisode.scores.map((score, index) => (
                <div key={score.teamId} className="team-score">
                  <h4>{index + 1}. {score.teamName}</h4>
                  <p>Score: {score.score}</p>
                </div>
              ))}
            </div> */}
          </div>
        )}
      </main>

      <footer className="home-footer">
        <div className="footer-menu">
          <div className="footer-cell">Teams</div>
          <div className="footer-cell">Dances</div>
          <div className="footer-cell">Jury</div>
          <div className="footer-cell">Episodes</div>
          <div className="footer-cell">Score</div>
        </div>
      </footer>
    </div>
  );
};

export default EpisodesPage;