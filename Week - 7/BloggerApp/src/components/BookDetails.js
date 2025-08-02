import React from 'react';

const BookDetails = () => {
  const books = [
    { title: "JavaScript Essentials", author: "Kyle Simpson" },
    { title: "React Explained", author: "Zac Gordon" },
    { title: "You Don't Know JS", author: "Kyle Simpson" }
  ];

  return (
    <div>
      <h2>📚 Book Details</h2>
      <ul>
        {books.map((book, index) => (
          <li key={index}>
            <strong>{book.title}</strong> by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookDetails;
