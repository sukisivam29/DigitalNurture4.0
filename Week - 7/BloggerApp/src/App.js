// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  return (
    <Router>
      <div className="App" style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>📰 Blogger App (React Router)</h1>

        {/* Navigation Menu */}
        <nav style={{ marginBottom: '20px' }}>
          <Link to="/books" style={{ marginRight: '10px' }}>Books</Link>
          <Link to="/blogs" style={{ marginRight: '10px' }}>Blogs</Link>
          <Link to="/courses">Courses</Link>
        </nav>

        {/* Routes */}
        <Routes>
          <Route path="/books" element={<BookDetails />} />
          <Route path="/blogs" element={<BlogDetails />} />
          <Route path="/courses" element={<CourseDetails />} />
          {/* Default route */}
          <Route path="*" element={<p>📢 Please select a section from above.</p>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
