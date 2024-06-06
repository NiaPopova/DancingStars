import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';
import './styles/layout.scss';

const Layout = () => {
    return (
        <div className="app-container">
            <Header />
            <main className="app-content">
                <Outlet />
            </main>
            <Footer />
        </div>
    );
};

export default Layout;
