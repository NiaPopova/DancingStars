import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './styles/teams.scss';

const TeamsPage = () => {
  const [teams, setTeams] = useState([]);
  const [selectedTeam, setSelectedTeam] = useState(null);

  useEffect(() => {
    // Fetch teams data from your API
    axios.get('http://localhost:8080/teams') // Replace with your actual API endpoint
      .then(response => {
        setTeams(response.data.filter(t => t.participantName));
      })
      .catch(error => {
        console.error('There was an error fetching the teams!', error);
      });
  }, []);

  const handleTeamChange = (event) => {
    const teamId = event.target.value;
    const team = teams.find(t => t.sms === teamId);
    setSelectedTeam(team);
  };

  return (
    <div className="container teams-container">
      <header className="home-header">
        <div className="user-info">
          <i className="bi bi-person-circle user-icon"></i>
          <span className="user-email">user@example.com</span>
        </div>
      </header>

      <main className="teams-main">
        <div className="form-group">
          <label htmlFor="teamSelect">Select a Team:</label>
          <select className="form-control" id="teamSelect" onChange={handleTeamChange}>
            <option value="0">Select a team</option>
            {teams.map(team => (
              <option key={team.sms} value={team.sms}>{team.participantName} - {team.professionalName}</option>
            ))}
          </select>
        </div>

        {selectedTeam && (
          <div className="team-details">
            <h3>{selectedTeam.name}</h3>
            <p><strong>Participant:</strong> {selectedTeam.participantName}</p>
            <p><strong>Professional:</strong> {selectedTeam.professionalName}</p>
            <p><strong>Participant Profession:</strong> {selectedTeam.participantProfession}</p>
            <p><strong>Final Position:</strong> {selectedTeam.finalPosition}</p>
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

export default TeamsPage;