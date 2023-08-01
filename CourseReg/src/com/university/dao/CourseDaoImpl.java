package com.university.dao;

import com.university.model.Course;
import com.university.util.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private Connection connection;

    public CourseDaoImpl() {
        connection = DBHandler.getConnection();
    }

    @Override
    public Course getCourseById(int courseId) {
        Course course = null;
        String query = "SELECT * FROM courses WHERE courseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course = new Course(
                        resultSet.getInt("courseId"),
                        resultSet.getString("courseName"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("prerequisites")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
    
    @Override
    public void addCourse(Course course) {
        String query = "INSERT INTO courses (courseId, courseName, capacity, prerequisites) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setInt(3, course.getCapacity());
            preparedStatement.setString(4, course.getPrerequisites());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getInt("courseId"),
                        resultSet.getString("courseName"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("prerequisites")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public void updateCourse(Course course) {
        String query = "UPDATE courses SET courseName = ?, capacity = ?, prerequisites = ? WHERE courseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCapacity());
            preparedStatement.setString(3, course.getPrerequisites());
            preparedStatement.setInt(4, course.getCourseId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        String query = "DELETE FROM courses WHERE courseId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
