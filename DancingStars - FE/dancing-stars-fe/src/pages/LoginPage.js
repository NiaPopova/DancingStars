// LoginForm.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../authentication/auth';

const LoginForm = () => {
    const { login } = useAuth();
    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({});
    const [serverError, setServerError] = useState('');

    const validateForm = () => {
        let formErrors = {};
        if (!email) {
            formErrors.email = 'Email is required';
        }
        if (!password) {
            formErrors.password = 'Password is required';
        }
        setErrors(formErrors);
        return Object.keys(formErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            try {
                const response = await axios.post(`http://localhost:8080/user/login?email=${email}&password=${password}`);
                const { email: userEmail, favoriteTeam } = response.data;
                login(userEmail, favoriteTeam);
                navigate('/home'); // Redirect to the home page after successful login
            } catch (error) {
                setServerError('Failed to login. Please check your credentials.');
            }
        }
    };

    return (
        <div className="container mt-5">
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email</label>
                    <input
                        type="email"
                        className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    {errors.email && <div className="error-message">{errors.email}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input
                        type="password"
                        className={`form-control ${errors.password ? 'is-invalid' : ''}`}
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {errors.password && <div className="error-message">{errors.password}</div>}
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
                {serverError && <div className="error-message mt-3">{serverError}</div>}
            </form>
        </div>
    );
};

export default LoginForm;
