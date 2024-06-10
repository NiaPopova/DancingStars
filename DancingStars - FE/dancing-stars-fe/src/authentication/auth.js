import React, { createContext, useContext, useState, useEffect } from 'react';

const AuthContext = createContext();

export const AuthProvider = ({ children, navigate }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [user, setUser] = useState(null);

    useEffect(() => {
        const authStatus = localStorage.getItem('isAuthenticated');
        if (authStatus === 'true') {
            setIsAuthenticated(true);
            setUser({
                email: localStorage.getItem('email'),
                favoriteTeam: localStorage.getItem('favoriteTeam'),
            });
        }
    }, []);

    const login = (email, favoriteTeam) => {
        setIsAuthenticated(true);
        setUser({ email, favoriteTeam });
        localStorage.setItem('isAuthenticated', 'true');
        localStorage.setItem('email', email);
        localStorage.setItem('favoriteTeam', favoriteTeam);
        navigate('/home'); // Redirect to home page after login
    };

    const logout = () => {
        setIsAuthenticated(false);
        setUser(null);
        localStorage.setItem('isAuthenticated', 'false');
        localStorage.removeItem('email');
        localStorage.removeItem('favoriteTeam');
        navigate('/login'); // Redirect to login page after logout
    };

    const register = (email, favoriteTeam) => {
        setIsAuthenticated(true);
        setUser({ email, favoriteTeam });
        localStorage.setItem('isAuthenticated', 'true');
        localStorage.setItem('email', email);
        localStorage.setItem('favoriteTeam', favoriteTeam);
        navigate('/home'); // Redirect to home page after registration
    };

    return (
        <AuthContext.Provider value={{ isAuthenticated, user, login, logout, register }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
