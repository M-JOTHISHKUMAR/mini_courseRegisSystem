package com.university.model;


public class Course  {
    private int courseId;
    private String courseName;
    private int capacity;
    private String prerequisites;

    public Course(int courseId, String courseName, int capacity, String prerequisites) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
    }

    // Getters and setters


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	@Override
	public String toString() {
		return String.format("Course [courseId=%s, courseName=%s, capacity=%s, prerequisites=%s]",
				courseId, courseName, capacity, prerequisites);
	}
}
