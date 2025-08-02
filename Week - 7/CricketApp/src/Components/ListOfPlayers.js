// src/components/ListOfPlayers.js
import React from 'react';

const players = [
  { name: "Virat Kohli", score: 95 },
  { name: "Rohit Sharma", score: 89 },
  { name: "KL Rahul", score: 72 },
  { name: "Shikhar Dhawan", score: 45 },
  { name: "MS Dhoni", score: 67 },
  { name: "Ravindra Jadeja", score: 77 },
  { name: "Hardik Pandya", score: 82 },
  { name: "R Ashwin", score: 56 },
  { name: "Bumrah", score: 60 },
  { name: "Shami", score: 70 },
  { name: "Chahal", score: 35 },
];

const ListOfPlayers = () => {
  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h2>Players with Score Below 70</h2>
      <ul>
        {players.filter(p => p.score < 70).map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfPlayers; // ✅ Default export
