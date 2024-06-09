import React from 'react';
import { Link } from 'react-router-dom';
import './styles/footer.scss';

const Footer = () => {
    return (
        <footer className="app-footer">
            <div className="footer-menu">
                <Link className="footer-cell" to="/teams">Teams</Link>
                <Link className="footer-cell" to="/dances">Dances</Link>
                <Link className="footer-cell" to="/jury">Jury</Link>
                <Link className="footer-cell" to="/episodes">Episodes</Link>
                <Link className="footer-cell" to="/performance">Performance</Link>
            </div>
        </footer>
    );
};

export default Footer;
