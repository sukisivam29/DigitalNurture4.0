// src/App.js
import React, { useState } from 'react';
import ListOfPlayers from './Components/ListOfPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App">
      <h1>🏏 Cricket Application</h1>
      <button onClick={() => setFlag(!flag)}>
        Toggle Flag (Current: {flag.toString()})
      </button>
      {flag ? <ListOfPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
