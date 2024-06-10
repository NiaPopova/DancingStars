import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/jury.scss';

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
      <main className="jury-main">
        <div className="row">
          {juryMembers.map(member => (
            <div className="col-6" key={member.name}>
              <div className={`card jury-card ${expandedJury === member.name ? 'expanded' : ''}`} onClick={() => toggleExpand(member.name)}>
                {member.photo && (
                  <img src={require(`${member.photo}`)} className="card-img-top" alt={member.name} />
                )}
                <div className="card-body">
                  <h5 className="card-title">{member.name}</h5>
                  {expandedJury === member.name && (
                    <>
                      <h6 className="card-subtitle mb-2 text-muted">{member.profession.charAt(0).toUpperCase() + member.profession.slice(1)}</h6>
                      <p className="card-text">{member.info}</p>
                    </>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
};

export default JuryPage;