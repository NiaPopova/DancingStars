import React from 'react';
import './styles/header.scss';

const Header = () => {
    return (
        <header className="app-header">
            <div className="user-info">
                <i className="bi bi-person-circle user-icon"></i>
                <span className="user-email">user@example.com</span>
            </div>
        </header>
    );
};

export default Header;
