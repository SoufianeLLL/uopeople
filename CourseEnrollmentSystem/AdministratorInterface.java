/**
 * 
 * University of The People
 * 
 * Coded by Soufiane Loudaini
 * 2024
 * 
 * Description: A simple command-line interface for administrators to interact with the system.
 * 
 */

import java.util.Scanner;

public class AdministratorInterface {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Add new course");
			System.out.println("2. Enroll student in course");
			System.out.println("3. Assign grade to student");
			System.out.println("4. Calculate overall grade for student");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();

			switch (option) {
				case 1:
					addNewCourse();
					break;
				case 2:
					enrollStudentInCourse();
					break;
				case 3:
					assignGradeToStudent();
					break;
				case 4:
					calculateOverallGradeForStudent();
					break;
				case 5:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void addNewCourse() {
		System.out.print("Enter course code: ");
		String courseCode = scanner.next();
		System.out.print("Enter course name: ");
		String name = scanner.next();
		System.out.print("Enter maximum capacity: ");
		int maxCapacity = scanner.nextInt();
		CourseManagement.addCourse(courseCode, name, maxCapacity);
		System.out.println("Course added successfully.");
	}

	private static void enrollStudentInCourse() {
		System.out.print("Enter student name: ");
		String name = scanner.next();
		System.out.print("Enter student ID: ");
		String id = scanner.next();
		Student student = new Student(name, id);

		System.out.print("Enter course code: ");
		String courseCode = scanner.next();
		Course course = CourseManagement.getCourseByCode(courseCode);

		if (course != null) {
			if (CourseManagement.enrollStudent(student, course)) {
				System.out.println("Student enrolled successfully.");
			}
			else {
				System.out.println("Failed to enroll student. Course might be full.");
			}
		}
		else {
			System.out.println("Course not found.");
		}
	}

	private static void assignGradeToStudent() {
		System.out.print("Enter student ID: ");
		String id = scanner.next();
		// Assuming we can fetch student by ID
		Student student = new Student("", id);

		System.out.print("Enter course code: ");
		String courseCode = scanner.next();
		Course course = CourseManagement.getCourseByCode(courseCode);

		if (course != null) {
			System.out.print("Enter grade: ");
			double grade = scanner.nextDouble();
			CourseManagement.assignGrade(student, course, grade);
			System.out.println("Grade assigned successfully.");
		}
		else {
			System.out.println("Course not found.");
		}
	}

	private static void calculateOverallGradeForStudent() {
		System.out.print("Enter student ID: ");
		String id = scanner.next();
		// Assuming we can fetch student by ID
		Student student = new Student("", id);
		double overallGrade = CourseManagement.calculateOverallGrade(student);
		System.out.println("Overall grade for student ID " + id + ": " + overallGrade);
	}

}
