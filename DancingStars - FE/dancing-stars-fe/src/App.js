import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './LoginPage';
import RegistrationPage from './RegistrationPage';
import DancesPage from './DancesPage';
import HomePage from './HomePage';
import JuryPage from './JuryPage';
import TeamsPage from './TeamsPage';
import EpisodesPage from './EpisodesPage';
import Layout from './Layout';
import Performance from './Performance';
import AuthWrapper from './AuthWrapper';
import PrivateRoute from './PrivateRoute';
import PublicRoute from './PublicRoute';
import NotFoundPage from './NotFoundPage';

function App() {
  return (
    <Router>
      <AuthWrapper>
        <Routes>
          <Route element={<Layout />}>
            <Route path="/" element={<HomePage />} />
            <Route element={<PublicRoute />}>
              <Route path="/login" element={<LoginPage />} />
              <Route path="/register" element={<RegistrationPage />} />
            </Route>
            <Route element={<PrivateRoute />}>
              <Route path="/dances" element={<DancesPage />} />
              <Route path="/home" element={<HomePage />} />
              <Route path="/jury" element={<JuryPage />} />
              <Route path="/teams" element={<TeamsPage />} />
              <Route path="/episodes" element={<EpisodesPage />} />
              <Route path="/performances" element={<Performance />} />
            </Route>
            <Route path="*" element={<NotFoundPage />} />
          </Route>
        </Routes>
      </AuthWrapper>
    </Router>
  );
}

export default App;
