import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
    const [currentUser, setCurrentUser] = useState(null);
    const [loans, setLoans] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        // retrieve authenticated user's profile, loan history, and social credit score
        fetch('/api/users/me')
            .then(response => response.json())
            .then(data => {
                setCurrentUser(data.user);
                setLoans(data.loans);
            })
            .catch(error => setError(error));
    }, []);

    if (error) {
        return (
            <div>
                <p>An error occurred: {error.message}</p>
            </div>
        );
    }

    if (!currentUser) {
        return (
            <div>
                <p>Loading...</p>
            </div>
        );
    }

    return (
        <div className="App">
            <header className="App-header">
                <p>Welcome, {currentUser.name}!</p>
                <p>Social Credit Score: {currentUser.socialCreditScore}</p>
                <p>Loan History:</p>
                <ul>
                    {loans.map(loan => (
                        <li key={loan.id}>
                            Borrower: {loan.borrowerId} | Amount: {loan.amount} |
                            Due Date: {loan.dueDate} |
                            Status: {loan.status}
                        </li>
                    ))}
                </ul>
            </header>
        </div>
    );
}

export default App;
