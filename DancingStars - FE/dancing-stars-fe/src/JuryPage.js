import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './styles/jury.scss';

const JuryPage = () => {
  const [juryMembers, setJuryMembers] = useState([]);
  const [expandedJury, setExpandedJury] = useState(null);

  useEffect(() => {
    // Fetch jury members data from your API
    axios.get('http://localhost:8080/jury') // Replace with your actual API endpoint
      .then(response => {
        setJuryMembers(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the jury members!', error);
      });
  }, []);

  const toggleExpand = (name) => {
    setExpandedJury(expandedJury === name ? null : name);
  };

  return (
    <div className="container jury-container">
      <header className="home-header">
        <div className="user-info">
          <i className="bi bi-person-circle user-icon"></i>
          <span className="user-email">user@example.com</span>
        </div>
      </header>

      <main className="jury-main">
        <div className="row">
          {juryMembers.map(member => (
            <div className="col-md-3" key={member.name}>
              <div className={`card jury-card ${expandedJury === member.name ? 'expanded' : ''}`} onClick={() => toggleExpand(member.name)}>
                <img src={member.image} className="card-img-top" alt={member.name} />
                <div className="card-body">
                  <h5 className="card-title">{member.name}</h5>
                  {expandedJury === member.name && (
                    <>
                      <h6 className="card-subtitle mb-2 text-muted">{member.profession}</h6>
                      <p className="card-text">{member.info}</p>
                    </>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
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

export default JuryPage;