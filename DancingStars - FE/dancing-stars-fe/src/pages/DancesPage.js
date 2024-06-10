import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../styles/dances.scss';

const DancesPage = () => {
    const [dances, setDances] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/dances')
            .then(response => {
                setDances(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the dances!', error);
            });
    }, []);

    return (
        <div className="container">
            <h2 className="text-center my-4">Dances</h2>
            <div className="row">
                {dances.map((dance, i) => (
                    <div className="col-md-4" key={i}>
                        <div className="card mb-4">
                            {dance.photo && (
                                <img src={require(`${dance.photo}`)} className="card-img-top" alt={dance.name} />
                            )}
                            <div className="card-body">
                                <h5 className="card-title">{dance.name}</h5>
                                <p className="card-text">{dance.description}</p>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default DancesPage;
