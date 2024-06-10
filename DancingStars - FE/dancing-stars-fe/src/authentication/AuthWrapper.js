import React from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthProvider as OriginalAuthProvider } from './auth';

const AuthWrapper = ({ children }) => {
    const navigate = useNavigate();

    return (
        <OriginalAuthProvider navigate={navigate}>
            {children}
        </OriginalAuthProvider>
    );
};

export default AuthWrapper;
