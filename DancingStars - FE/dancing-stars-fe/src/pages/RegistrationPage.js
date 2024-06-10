// RegisterForm.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../authentication/auth';

const RegisterForm = () => {
    const { register } = useAuth();
    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [errors, setErrors] = useState({});
    const [serverError, setServerError] = useState('');

    const validateForm = () => {
        let formErrors = {};

        if (!email) {
            formErrors.email = 'Email is required';
        }

        if (!password) {
            formErrors.password = 'Password is required';
        } else {
            const passwordErrors = [];
            if (password.length < 8) {
                passwordErrors.push('at least 8 symbols long');
            }
            if (!/\d/.test(password)) {
                passwordErrors.push('at least one digit');
            }
            if (!/[A-Z]/.test(password)) {
                passwordErrors.push('at least one upper case character');
            }
            if (/\s/.test(password)) {
                passwordErrors.push('no spaces allowed');
            }
            if (passwordErrors.length > 0) {
                formErrors.password = `Password should be: ${passwordErrors.join(', ')}.`;
            }
        }

        if (password !== confirmPassword) {
            formErrors.confirmPassword = 'Passwords do not match';
        }

        setErrors(formErrors);
        return Object.keys(formErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            try {
                const response = await axios.post(`http://localhost:8080/user/register?email=${email}&password=${password}`);
                const { email: userEmail, favoriteTeam } = response.data;
                register(userEmail, favoriteTeam); // Assuming the email and favorite team are returned in the response
                navigate('/home'); // Redirect to home after successful registration
            } catch (error) {
                setServerError('Failed to register. Please try again.');
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
                <div className="mb-3">
                    <label htmlFor="confirmPassword" className="form-label">Confirm Password</label>
                    <input
                        type="password"
                        className={`form-control ${errors.confirmPassword ? 'is-invalid' : ''}`}
                        id="confirmPassword"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                    />
                    {errors.confirmPassword && <div className="error-message">{errors.confirmPassword}</div>}
                </div>
                <button type="submit" className="btn btn-primary">Register</button>
                {serverError && <div className="error-message mt-3">{serverError}</div>}
            </form>
        </div>
    );
};

export default RegisterForm;
