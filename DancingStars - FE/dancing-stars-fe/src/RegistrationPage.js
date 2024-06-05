import React, { useState } from 'react';
import './styles/registration.scss';

const RegistrationPage = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Perform registration logic here
        if (password !== confirmPassword) {
            alert('Passwords do not match');
            return;
        }
        console.log('Email:', email);
        console.log('Password:', password);
    };

    return (
        <div className="container registration-container">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <h2 className="registration-header">Register</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>Email:</label>
                            <input
                                type="email"
                                className="form-control"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Password:</label>
                            <input
                                type="password"
                                className="form-control"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Confirm Password:</label>
                            <input
                                type="password"
                                className="form-control"
                                value={confirmPassword}
                                onChange={(e) => setConfirmPassword(e.target.value)}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary btn-block">Register</button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default RegistrationPage;
