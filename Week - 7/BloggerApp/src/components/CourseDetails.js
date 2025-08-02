import React from 'react';

const CourseDetails = () => {
  const courses = [
    { name: "React Basics", duration: "3 weeks" },
    { name: "Advanced JavaScript", duration: "4 weeks" },
    { name: "Full Stack Development", duration: "6 weeks" }
  ];

  return (
    <div>
      <h2>🎓 Course Details</h2>
      <ul>
        {courses.map((course, index) => (
          <li key={index}>
            {course.name} - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseDetails;
