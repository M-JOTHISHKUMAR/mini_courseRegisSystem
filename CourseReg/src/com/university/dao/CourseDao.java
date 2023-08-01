package com.university.dao;

import com.university.model.Course;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);

    List<Course> getAllCourses();

    void updateCourse(Course course);

    void deleteCourse(int courseId);
    
    Course getCourseById(int courseId);
}
