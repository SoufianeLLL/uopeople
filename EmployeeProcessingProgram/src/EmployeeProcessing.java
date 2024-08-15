import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeProcessing {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Read JSON data from the file
			File file = new File("employees.json");

			// Deserialize JSON into a List of Employee objects
			List<Employee> employees = List.of(mapper.readValue(file, Employee[].class));

			// Get concatenated name and department
			Function<Employee, String> nameAndDepartment = emp -> emp.getName() + " - " + emp.getDepartment();

			// Generate a new collection of concatenated strings
			List<String> nameAndDeptList = employees.stream()
													.map(nameAndDepartment)
													.collect(Collectors.toList());

			System.out.println("\n🪪 Name and Department List:");
			nameAndDeptList.forEach(System.out::println);

			// Find the average salary of all employees
			double averageSalary = employees.stream()
											.mapToDouble(Employee::getSalary)
											.average()
											.orElse(0);

            // Format the average salary
            String formattedAverageSalary = String.format("$%.2f", averageSalary);

            // Print Average Salary
            System.out.println("\n\n💵 Average Salary: " + formattedAverageSalary);

			// Filter employees older than 30 and generate their name and department list
			List<String> filteredNameAndDeptList = employees.stream()
															.filter(employee -> employee.getAge() > 30)
															.map(nameAndDepartment)
															.collect(Collectors.toList());

            System.out.println("\n\n🪪 Filtered Name and Department List (Age > 30):");
			filteredNameAndDeptList.forEach(System.out::println);

		}
		catch (IOException e) {
			System.err.println("\nError reading or parsing JSON file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

class Employee {
	private String name;
	private int age;
	private String department;
	private double salary;

	// Getters and setters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}
}
