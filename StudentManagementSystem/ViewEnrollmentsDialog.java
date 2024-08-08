import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewEnrollmentsDialog extends JDialog {

    public ViewEnrollmentsDialog(JFrame parent, List<Student> students) {
        super(parent, "View Enrollments", true);
        setLayout(new GridLayout(2, 1));
        setSize(400, 300);

        JComboBox<Student> studentComboBox = new JComboBox<>(students.toArray(new Student[0]));
        JTextArea enrollmentsArea = new JTextArea(10, 30);
        enrollmentsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(enrollmentsArea);

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Enrolled Courses:"));
        add(scrollPane);

        studentComboBox.addActionListener(e -> {
            Student selectedStudent = (Student) studentComboBox.getSelectedItem();
            if (selectedStudent != null) {
                updateEnrollmentsArea(selectedStudent, enrollmentsArea);
            }
        });
    }

    private void updateEnrollmentsArea(Student student, JTextArea area) {
        StringBuilder sb = new StringBuilder("Courses Enrolled:\n");
        for (Course course : student.getCourses()) {
            sb.append(course.getName()).append("\n");
        }
        area.setText(sb.toString());
    }
}