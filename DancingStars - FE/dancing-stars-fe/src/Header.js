import React from 'react';
import { Link } from 'react-router-dom';
import './styles/header.scss';

const Header = () => {
    return (
        <nav className="app-header">
            <div className='app-main'>
                <ul className='main-nav'>
                    <li>
                        <Link to="/teams"> <span className="nav-cell">Teams</span></Link>
                    </li>
                    <li>
                        <Link to="/dances"> <span className="nav-cell">Dances</span></Link>
                    </li>
                    <li>
                        <Link to="/jury"> <span className="nav-cell">Jury</span></Link>
                    </li>
                    <li>
                        <Link to="/episodes"> <span className="nav-cell">Episodes</span></Link>

                    </li>
                    <li>
                        <Link to="/performances"> <span className="nav-cell">Performance</span></Link>
                    </li>
                </ul>
            </div>
            <div className="user-info">
                <i className="bi bi-person-circle user-icon"></i>
                <span className="user-email">user@example.com</span>
            </div>
        </nav>
    );
};

export default Header;
