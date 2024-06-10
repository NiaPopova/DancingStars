// HomeRedirect.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './auth';

const HomeRedirect = () => {
  const { isAuthenticated } = useAuth();
  const navigate = useNavigate();

  React.useEffect(() => {
    if (isAuthenticated) {
      navigate('/teams');
    } else {
      navigate('/login');
    }
  }, [isAuthenticated, navigate]);

  return null; // This component doesn't render anything itself
};

export default HomeRedirect;
