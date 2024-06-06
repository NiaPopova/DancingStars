import React from 'react';
import { formatDate } from './utils/dateUtils';
import './styles/episodeTemplate.scss';

const EpisodeTemplate = ({ episode }) => {
    return (
        <div className="episode-template">
            <h2 className="episode-theme">{episode.theme}</h2>
            <p className="episode-date">Date: {formatDate(episode.date)}</p>

            <div className="winner-team">
                <h3>Winner Team</h3>
                {episode.winnerTeam && (
                    <div className="team-details">
                        {episode.winnerTeam.photo && (
                            <img src={require(`${episode.winnerTeam.photo}`)} alt={`${episode.winnerTeam.participantName} and ${episode.winnerTeam.professionalName}`} />
                        )}
                        <p>Participant: {episode.winnerTeam.participantName}</p>
                        <p>Profession: {episode.winnerTeam.participantProfession}</p>
                        <p>Professional: {episode.winnerTeam.professionalName}</p>
                        <p>SMS: {episode.winnerTeam.sms}</p>
                        <p>Final Position: {episode.winnerTeam.finalPosition}</p>
                    </div>
                )}
            </div>

            <div className="losing-team">
                <h3>Losing Team</h3>
                {episode.losingTeam && (
                    <div className="team-details">
                        {episode.losingTeam.photo && (
                            <img src={require(`${episode.losingTeam.photo}`)} alt={`${episode.losingTeam.participantName} and ${episode.losingTeam.professionalName}`} />
                        )}
                        <p>Participant: {episode.losingTeam.participantName}</p>
                        <p>Profession: {episode.losingTeam.participantProfession}</p>
                        <p>Professional: {episode.losingTeam.professionalName}</p>
                        <p>SMS: {episode.losingTeam.sms}</p>
                        <p>Final Position: {episode.losingTeam.finalPosition}</p>
                    </div>
                )}
            </div>
        </div>
    );
};

export default EpisodeTemplate;
