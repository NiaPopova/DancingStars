import React from 'react';
import './styles/home.scss';

const HomePage = () => {
  // Dummy user data for demonstration
  const user = {
    email: 'user@example.com',
    favouriteTeam: 'Team A',
    teamScore: '100'
  };

  return (
    <div className="container home-container">
      <main className="home-main">
        <div className="row">
          <div className="col-12">
            <h3>Favourite Team: {user.favouriteTeam}</h3>
          </div>
        </div>
        <div className="row">
          <div className="col-12">
            <h3>Team Score: {user.teamScore}</h3>
          </div>
        </div>
      </main>
    </div>
  );
};

export default HomePage;