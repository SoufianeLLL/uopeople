import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EnrollStudentDialog extends JDialog {

    private StudentManagementSystem parent;
    private List<Student> students;
    private List<Course> courses;

    public EnrollStudentDialog(StudentManagementSystem parent, List<Student> students, List<Course> courses) {
        super(parent, "Enroll Student", true);
        this.parent = parent;
        this.students = students;
        this.courses = courses;

        setLayout(new GridLayout(4, 2));
        setSize(400, 200);

        JComboBox<Student> studentComboBox = new JComboBox<>(students.toArray(new Student[0]));
        JComboBox<Course> courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Select Course:"));
        add(courseComboBox);

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                Course selectedCourse = (Course) courseComboBox.getSelectedItem();

                if (selectedStudent == null || selectedCourse == null) {
                    JOptionPane.showMessageDialog(EnrollStudentDialog.this, "Please select both a student and a course.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                selectedStudent.enrollInCourse(selectedCourse);
                JOptionPane.showMessageDialog(EnrollStudentDialog.this, "Student enrolled in course successfully.");
                
                ((StudentManagementSystem) parent).refreshTables(); 
                dispose();
            }
        });

        add(enrollButton);
    }
}
