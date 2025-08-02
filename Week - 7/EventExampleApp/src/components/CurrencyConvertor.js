import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState('');

  const handleSubmit = () => {
    const rupeeValue = parseFloat(rupees);
    if (!isNaN(rupeeValue)) {
      const euroValue = rupeeValue * 0.011;
      setEuro(euroValue.toFixed(2));
    } else {
      alert("Please enter a valid number");
    }
  };

  return (
    <div>
      <h2>Currency Converter</h2>
      <input
        type="text"
        placeholder="Enter amount in ₹"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />
      <button onClick={handleSubmit}>Convert</button>
      {euro && <p>€ {euro}</p>}
    </div>
  );
};

export default CurrencyConvertor;
