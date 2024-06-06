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
      <header className="home-header">
        <div className="user-info">
          <i className="bi bi-person-circle user-icon"></i>
          <span className="user-email">{user.email}</span>
        </div>
      </header>
      
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

      <footer className="home-footer">
        <div className="footer-menu">
          <div className="footer-cell">Teams</div>
          <div className="footer-cell">Dances</div>
          <div className="footer-cell">Jury</div>
          <div className="footer-cell">Episodes</div>
        </div>
      </footer>
    </div>
  );
};

export default HomePage;