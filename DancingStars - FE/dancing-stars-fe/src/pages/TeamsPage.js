import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar as faSolidStar } from '@fortawesome/free-solid-svg-icons';
import { faStar as faRegularStar } from '@fortawesome/free-regular-svg-icons';
import { useAuth } from '../authentication/auth'; // Ensure you have the useAuth hook
import '../styles/teams.scss';

const TeamsPage = () => {
  const { isAuthenticated, user } = useAuth();
  const [teams, setTeams] = useState([]);
  const [selectedTeam, setSelectedTeam] = useState(null);
  const [favoriteTeam, setFavoriteTeam] = useState(null);

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

  useEffect(() => {
    if (isAuthenticated && user) {
      // Fetch favorite team data from your API
      axios.get(`http://localhost:8080/user/favorite_team?email=${user.email}`) // Replace with your actual API endpoint
        .then(response => {
          setFavoriteTeam(response.data);
        })
        .catch(error => {
          console.error('There was an error fetching the favorite team!', error);
        });
    }
  }, [isAuthenticated, user]);

  const handleTeamChange = (event) => {
    const teamId = event.target.value;
    const team = teams.find(t => t.sms === teamId);
    setSelectedTeam(team);
  };

  const handleFavoriteClick = () => {
    if (!isAuthenticated || !selectedTeam) return;

    if (favoriteTeam && favoriteTeam.sms === selectedTeam.sms) {
      // Remove from favorites
      axios.put(`http://localhost:8080/user/favorite_team/remove`, null, {
        params: {
          email: user.email,
          sms: selectedTeam.sms
        }
      })
        .then(() => {
          setFavoriteTeam(null);
        })
        .catch(error => {
          console.error('There was an error removing the team from favorites!', error);
        });
    } else {
      // Add to favorites
      axios.put(`http://localhost:8080/user/favorite_team/add`, null, {
        params: {
          email: user.email,
          sms: selectedTeam.sms
        }
      })
        .then(() => {
          setFavoriteTeam(selectedTeam);
        })
        .catch(error => {
          console.error('There was an error adding the team to favorites!', error);
        });
    }
  };

  const isFavorite = selectedTeam && favoriteTeam && favoriteTeam.sms === selectedTeam.sms;

  return (
    <div className="container teams-container">
      <main className="teams-main">
        <h2 className="teams-header">Select Your Favorite Team</h2>
        <div className="form-group team-dropdown">
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
            {selectedTeam.photo && (
              <img src={require(`${selectedTeam.photo}`)} className="card-img-top" alt={selectedTeam.name} />
            )}
            <p><strong>Participant:</strong> {selectedTeam.participantName}</p>
            <p><strong>Professional:</strong> {selectedTeam.professionalName}</p>
            <p><strong>Participant Profession:</strong> {selectedTeam.participantProfession}</p>
            <p><strong>Final Position:</strong> {selectedTeam.finalPosition}</p>
            {isAuthenticated && (
              <button className="favorite-button" onClick={handleFavoriteClick}>
                <FontAwesomeIcon icon={isFavorite ? faSolidStar : faRegularStar} />
                {isFavorite ? 'Favorited' : 'Favorite'}
              </button>
            )}
          </div>
        )}
      </main>
    </div>
  );
};

export default TeamsPage;
