/**
 * 
 * University of The People
 * 
 * Coded by Soufiane Loudaini
 * 2024
 * 
 * Description: The Student class encapsulates student information, including their name, ID, and enrolled courses.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<Course, Double> enrolledCourses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    /**
     *  Getter and setter methods
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Enroll in a course
    public void enrollCourse(Course course) {
        enrolledCourses.put(course, null);
    }

    // Assign grade to a course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        }
    }

    // Get grade for a course
    public Double getGrade(Course course) {
        return enrolledCourses.get(course);
    }

    // Get all enrolled courses
    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }
}
