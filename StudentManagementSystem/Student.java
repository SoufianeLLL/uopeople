import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private List<Course> courses;
    private Map<Course, String> grades; // Map to store grades for each course

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

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

    public List<Course> getCourses() {
        return courses;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public Map<Course, String> getGrades() {
        return grades;
    }

    public void assignGrade(Course course, String grade) {
        grades.put(course, grade);
    }

    public void setGrade(Course course, String grade) {
        grades.put(course, grade);
    }

    public String getGradeForCourse(Course course) {
        return grades.getOrDefault(course, "No grade assigned");
    }

    @Override
    public String toString() {
        return name + " - " + id;
    }
}
