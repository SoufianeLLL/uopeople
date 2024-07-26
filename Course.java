/**
 * 
 * University of The People
 * 
 * Coded by Soufiane Loudaini
 * 2024
 * 
 * Description: The Course class encapsulates course details and tracks the total number of enrolled students 
 * across all courses using static variables.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Enroll a student in the course
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            return true;
        }
        else {
            return false;
        }
    }

    // Static method to retrieve total number of enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Get enrolled students
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
