import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegistrationPage from './pages/RegistrationPage';
import DancesPage from './pages/DancesPage';
import HomePage from './pages/HomePage';
import JuryPage from './pages/JuryPage';
import TeamsPage from './pages/TeamsPage';
import EpisodesPage from './pages/EpisodesPage';
import Layout from './layout/Layout';
import Performance from './pages/Performance';
import AuthWrapper from './authentication/AuthWrapper';
import PrivateRoute from './authentication/PrivateRoute';
import PublicRoute from './authentication/PublicRoute';
import NotFoundPage from './pages/NotFoundPage';

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
