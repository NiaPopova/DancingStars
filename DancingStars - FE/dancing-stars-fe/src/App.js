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

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<LoginPage />} />
          <Route path="register" element={<RegistrationPage />} />
          <Route path="dances" element={<DancesPage />} />
          <Route path="home" element={<HomePage />} />
          <Route path="jury" element={<JuryPage />} />
          <Route path="teams" element={<TeamsPage />} />
          <Route path="episodes" element={<EpisodesPage />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
