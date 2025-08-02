// src/components/GuestPage.js
import React from 'react';

const GuestPage = () => {
  return (
    <div>
      <h2>✈️ Welcome Guest</h2>
      <p>Here are some flight details:</p>
      <ul>
        <li>Chennai to Delhi - ₹3500</li>
        <li>Mumbai to Bangalore - ₹2800</li>
        <li>Kolkata to Hyderabad - ₹4000</li>
      </ul>
      <p>Please log in to book your tickets.</p>
    </div>
  );
};

export default GuestPage;
