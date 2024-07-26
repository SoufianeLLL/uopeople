/**
 * 
 * University of The People
 * 
 * Coded by Soufiane Loudaini
 * 2024
 * 
 * Description: The CourseManagement class provides static methods for managing courses and student enrollments.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class CourseManagement {
    private static Map<String, Course> courses = new HashMap<>();
    private static Map<String, Double> overallGrades = new HashMap<>();

    // Add a new course
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courses.put(courseCode, course);
    }

    // Enroll a student in a course
    public static boolean enrollStudent(Student student, Course course) {
        if (course.enrollStudent(student)) {
            student.enrollCourse(course);
            return true;
        }
        else {
            return false;
        }
    }

    // Assign grade to a student
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    // Calculate overall grade for a student
    public static double calculateOverallGrade(Student student) {
        double totalGrades = 0;
        int count = 0;
        for (Map.Entry<Course, Double> entry : student.getEnrolledCourses().entrySet()) {
            if (entry.getValue() != null) {
                totalGrades += entry.getValue();
                count++;
            }
        }
        double overallGrade = (count > 0) ? totalGrades / count : 0;
        overallGrades.put(student.getId(), overallGrade);
        
        return overallGrade;
    }

    // Get course by code
    public static Course getCourseByCode(String courseCode) {
        return courses.get(courseCode);
    }
}
