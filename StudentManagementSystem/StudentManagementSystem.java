import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentManagementSystem extends JFrame {
    private List<Student> students;
    private List<Course> courses = new ArrayList<>();
    private JTable studentTable;
    private JTable courseTable;
    private JTable enrollmentTable;
    private JTable gradesTable;
    private DefaultTableModel studentTableModel;
    private DefaultTableModel courseTableModel;
    private DefaultTableModel enrollmentTableModel;
    private DefaultTableModel gradesTableModel;


    public StudentManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Student Details Tab
        JPanel studentPanel = new JPanel(new BorderLayout());
        studentTableModel = new DefaultTableModel(new String[]{"Student ID", "Student Name"}, 0);
        studentTable = new JTable(studentTableModel);
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        tabbedPane.addTab("Student Details", studentPanel);

        // Course List Tab
        JPanel coursePanel = new JPanel(new BorderLayout());
        courseTableModel = new DefaultTableModel(new String[]{"Course Name"}, 0);
        courseTable = new JTable(courseTableModel);
        coursePanel.add(new JScrollPane(courseTable), BorderLayout.CENTER);
        tabbedPane.addTab("Course List", coursePanel);

        // Enrollment List Tab
        JPanel enrollmentPanel = new JPanel(new BorderLayout());
        enrollmentTableModel = new DefaultTableModel(new String[]{"Student ID", "Student Name", "Course Name"}, 0);
        enrollmentTable = new JTable(enrollmentTableModel);
        enrollmentPanel.add(new JScrollPane(enrollmentTable), BorderLayout.CENTER);
        tabbedPane.addTab("Enrollment List", enrollmentPanel);

        // Grades Tab
        JPanel gradesPanel = new JPanel(new BorderLayout());
        gradesTableModel = new DefaultTableModel(new String[]{"Student ID", "Student Name", "Course Name", "Grade"}, 0);
        gradesTable = new JTable(gradesTableModel);
        gradesPanel.add(new JScrollPane(gradesTable), BorderLayout.CENTER);
        tabbedPane.addTab("Grades List", gradesPanel);

        add(tabbedPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentDialog(StudentManagementSystem.this).setVisible(true);
            }
        });
        controlPanel.add(addStudentButton);

        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCourseDialog(StudentManagementSystem.this, courseTableModel).setVisible(true);
            }
        });
        controlPanel.add(addCourseButton);

        JButton enrollStudentButton = new JButton("Enroll Student");
        enrollStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnrollStudentDialog(StudentManagementSystem.this, students, courses).setVisible(true);
            }
        });
        controlPanel.add(enrollStudentButton);

        JButton assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignGradeDialog(StudentManagementSystem.this, students, courses).setVisible(true);
            }
        });
        controlPanel.add(assignGradeButton);

        add(controlPanel, BorderLayout.NORTH);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void refreshTables() {
        refreshStudentTable();
        refreshCourseTable();
        refreshEnrollmentTable();
        refreshGradesTable();
    }

    public void refreshGradesTable() {
        DefaultTableModel gradesTableModel = new DefaultTableModel(new String[]{"Student ID", "Student Name", "Course Name", "Grade"}, 0);
        for (Student student : students) {
            for (Map.Entry<Course, String> entry : student.getGrades().entrySet()) {
                Course course = entry.getKey();
                String grade = entry.getValue();
                gradesTableModel.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    course.getName(),
                    grade
                });
            }
        }
        gradesTable.setModel(gradesTableModel);
    }

    public void refreshCourseTable() {
        courseTableModel.setRowCount(0);
        for (Course course : courses) {
            courseTableModel.addRow(new Object[]{course.getName()});
        }
    }

    public void refreshEnrollmentTable() {
        DefaultTableModel enrollmentTableModel = new DefaultTableModel(new String[]{"Student ID", "Student Name", "Course Name"}, 0);
        for (Student student : students) {
            for (Course course : student.getCourses()) {
                enrollmentTableModel.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    course.getName()
                });
            }
        }
        enrollmentTable.setModel(enrollmentTableModel);
    }

    public void addStudent(String id, String name) {
        students.add(new Student(name, id));
        studentTableModel.addRow(new Object[]{id, name});
    }

    public void refreshStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student student : students) {
            studentTableModel.addRow(new Object[]{student.getId(), student.getName()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}
