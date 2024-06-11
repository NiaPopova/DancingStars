import React from 'react';
import { formatDate } from '../utils/dateUtils';
import '../styles/episodeTemplate.scss';

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
                            <img src={require(`../assets/${episode.winnerTeam.photo}`)} alt={`${episode.winnerTeam.participantName} and ${episode.winnerTeam.professionalName}`} />
                        )}
                        <p>Participant: {episode.winnerTeam.participantName}</p>
                        <p>Profession: {episode.winnerTeam.participantProfession}</p>
                        <p>Professional: {episode.winnerTeam.professionalName}</p>
                        <p>SMS: {episode.winnerTeam.sms}</p>
                        <p>Final Position: {episode.winnerTeam.finalPosition}</p>
                    </div>
                )}
            </div>

            {
                episode.secondWinnerTeam && (
                    <div className="winner-team">
                        <h3>Second Winner Team</h3>
                        <div className="team-details">
                            {episode.secondWinnerTeam.photo && (
                                <img src={require(`../assets/${episode.secondWinnerTeam.photo}`)} alt={`${episode.secondWinnerTeam.participantName} and ${episode.secondWinnerTeam.professionalName}`} />
                            )}
                            <p>Participant: {episode.secondWinnerTeam.participantName}</p>
                            <p>Profession: {episode.secondWinnerTeam.participantProfession}</p>
                            <p>Professional: {episode.secondWinnerTeam.professionalName}</p>
                            <p>SMS: {episode.secondWinnerTeam.sms}</p>
                            <p>Final Position: {episode.secondWinnerTeam.finalPosition}</p>
                        </div>
                    </div>
                )
            }

            {
                episode.thirdWinnerTeam && (
                    <div className="winner-team">
                        <h3>Third Winner Team</h3>
                        <div className="team-details">
                            {episode.thirdWinnerTeam.photo && (
                                <img src={require(`../assets/${episode.thirdWinnerTeam.photo}`)} alt={`${episode.thirdWinnerTeam.participantName} and ${episode.thirdWinnerTeam.professionalName}`} />
                            )}
                            <p>Participant: {episode.thirdWinnerTeam.participantName}</p>
                            <p>Profession: {episode.thirdWinnerTeam.participantProfession}</p>
                            <p>Professional: {episode.thirdWinnerTeam.professionalName}</p>
                            <p>SMS: {episode.thirdWinnerTeam.sms}</p>
                            <p>Final Position: {episode.thirdWinnerTeam.finalPosition}</p>
                        </div>
                    </div>
                )
            }

            <div className="losing-team">
                <h3>Losing Team</h3>
                {episode.losingTeam && (
                    <div className="team-details">
                        {episode.losingTeam.photo && (
                            <img src={require(`../assets/${episode.losingTeam.photo}`)} alt={`${episode.losingTeam.participantName} and ${episode.losingTeam.professionalName}`} />
                        )}
                        <p>Participant: {episode.losingTeam.participantName}</p>
                        <p>Profession: {episode.losingTeam.participantProfession}</p>
                        <p>Professional: {episode.losingTeam.professionalName}</p>
                        <p>SMS: {episode.losingTeam.sms}</p>
                        <p>Final Position: {episode.losingTeam.finalPosition}</p>
                    </div>
                )}
            </div>

            {
                episode.secondLosingTeam && (
                    <div className="losing-team">
                        <h3>Second Losing Team</h3>
                        {episode.secondLosingTeam && (
                            <div className="team-details">
                                {episode.secondLosingTeam.photo && (
                                    <img src={require(`../assets/${episode.secondLosingTeam.photo}`)} alt={`${episode.secondLosingTeam.participantName} and ${episode.secondLosingTeam.professionalName}`} />
                                )}
                                <p>Participant: {episode.secondLosingTeam.participantName}</p>
                                <p>Profession: {episode.secondLosingTeam.participantProfession}</p>
                                <p>Professional: {episode.secondLosingTeam.professionalName}</p>
                                <p>SMS: {episode.secondLosingTeam.sms}</p>
                                <p>Final Position: {episode.secondLosingTeam.finalPosition}</p>
                            </div>
                        )}
                    </div>

                )
            }
        </div>
    );
};

export default EpisodeTemplate;
