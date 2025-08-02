// src/App.js
import React from 'react';
import Counter from './components/Counter';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
  return (
    <div className="App">
      <h1>🌐 React Event Handling Example</h1>
      <Counter />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
