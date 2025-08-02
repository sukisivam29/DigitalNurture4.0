import React from 'react';
import './App.css';
import officeImage from './images/office.jpeg'; 

function App() {
  const heading = <h1 style={{ textAlign: 'center' }}>🏢 Office Space Rental App</h1>;
  const office = {
    name: 'SkyView Tower',
    rent: 55000,
    address: '3rd Floor, Anna Salai, Chennai'
  };
  const officeSpaces = [
    {
      name: 'SkyView Tower',
      rent: 55000,
      address: '3rd Floor, Anna Salai, Chennai'
    },
    {
      name: 'TechPark Avenue',
      rent: 72000,
      address: 'OMR Road, Chennai'
    },
    {
      name: 'Business Bay',
      rent: 45000,
      address: 'MG Road, Bengaluru'
    },
    {
      name: 'Central Plaza',
      rent: 85000,
      address: 'Banjara Hills, Hyderabad'
    }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      {heading}

      {/* Office Image */}
      <img
        src={officeImage}
        alt="Office space"
        style={{
    width: '300px',
    height: '200px',
    objectFit: 'cover',
    borderRadius: '10px',
    display: 'block',
    margin: '20px auto',
    borderRadius: '10px' }}
      />

      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Rent:</strong> <span style={{ color: office.rent > 60000 ? 'green' : 'red' }}>₹{office.rent}</span></p>
      <p><strong>Address:</strong> {office.address}</p>

      <h2>Available Offices</h2>
      <ul>
        {officeSpaces.map((item, index) => (
          <li key={index} style={{ marginBottom: '15px' }}>
            <strong>{item.name}</strong><br />
            Rent: <span style={{ color: item.rent > 60000 ? 'green' : 'red' }}>₹{item.rent}</span><br />
            Address: {item.address}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
