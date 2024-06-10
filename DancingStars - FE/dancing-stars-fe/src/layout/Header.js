import React from 'react';
import { NavLink } from 'react-router-dom';
import { useAuth } from '../authentication/auth';
import '../styles/header.scss';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignInAlt, faSignOutAlt, faUserCircle } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

const Header = () => {
    const { isAuthenticated, user, logout } = useAuth();

    const logOut = async () => {
        try {
            await axios.post(`http://localhost:8080/user/logout`);
            logout();
        } catch (error) {
            console.error('Failed to logout. Please check your credentials.');
        }
    }

    return (
        <nav className="app-header">
            <div className='app-main'>
                <ul className='main-nav'>
                    <li>
                        <NavLink to="/teams" className={({ isActive }) => isActive ? "nav-cell active" : "nav-cell"}>
                            Teams
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/dances" className={({ isActive }) => isActive ? "nav-cell active" : "nav-cell"}>
                            Dances
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/jury" className={({ isActive }) => isActive ? "nav-cell active" : "nav-cell"}>
                            Jury
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/episodes" className={({ isActive }) => isActive ? "nav-cell active" : "nav-cell"}>
                            Episodes
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/performances" className={({ isActive }) => isActive ? "nav-cell active" : "nav-cell"}>
                            Performance
                        </NavLink>
                    </li>
                </ul>
            </div>
            <div className="user-info">
                <FontAwesomeIcon icon={faUserCircle} className="user-icon" />
                {isAuthenticated ? (
                    <>
                        <span className="user-email">{user.email}</span>
                        <button onClick={logOut} className="btn-icon">
                            <FontAwesomeIcon icon={faSignOutAlt} />
                        </button>
                    </>
                ) : (
                    <NavLink to="/login" className="btn-icon">
                        <FontAwesomeIcon icon={faSignInAlt} />
                    </NavLink>
                )}
            </div>
        </nav>
    );
};

export default Header;
