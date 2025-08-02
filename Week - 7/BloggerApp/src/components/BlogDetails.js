import React from 'react';

const BlogDetails = () => {
  const blogs = [
    { title: "React Hooks in Depth", author: "Sandy" },
    { title: "JSX vs HTML", author: "Sam" },
    { title: "Functional Components", author: "Nina" }
  ];

  return (
    <div>
      <h2>📝 Blog Details</h2>
      <ul>
        {blogs.map((blog, index) => (
          <li key={index}>
            <strong>{blog.title}</strong> - {blog.author}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BlogDetails;
