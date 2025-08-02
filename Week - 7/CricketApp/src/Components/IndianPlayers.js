// src/components/IndianPlayers.js
import React from 'react';

const IndianPlayers = () => {
  const T20players = ["Rohit", "Virat", "SKY", "Hardik", "Pant"];
  const RanjiPlayers = ["Gill", "Pujara", "Rahane", "Jadeja", "Ashwin"];

  const mergedPlayers = [...T20players, ...RanjiPlayers];

  const oddPlayers = mergedPlayers.filter((_, index) => index % 2 === 0);
  const evenPlayers = mergedPlayers.filter((_, index) => index % 2 !== 0);

  return (
    <div>
      <h2>Merged Indian Team</h2>
      <ul>
        {mergedPlayers.map((player, i) => <li key={i}>{player}</li>)}
      </ul>

      <h2>Odd Team Players</h2>
      <ul>
        {oddPlayers.map((player, i) => <li key={i}>{player}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenPlayers.map((player, i) => <li key={i}>{player}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers; // ✅ Default export
