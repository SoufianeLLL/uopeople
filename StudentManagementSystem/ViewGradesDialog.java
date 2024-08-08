import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewGradesDialog extends JDialog {

    public ViewGradesDialog(JFrame parent, List<Student> students) {
        super(parent, "View Grades", true);
        setLayout(new GridLayout(2, 1));
        setSize(400, 300);

        JComboBox<Student> studentComboBox = new JComboBox<>(students.toArray(new Student[0]));
        JTextArea gradesArea = new JTextArea(10, 30);
        gradesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gradesArea);

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Grades:"));
        add(scrollPane);

        studentComboBox.addActionListener(e -> {
            Student selectedStudent = (Student) studentComboBox.getSelectedItem();
            if (selectedStudent != null) {
                updateGradesArea(selectedStudent, gradesArea);
            }
        });
    }

    private void updateGradesArea(Student student, JTextArea area) {
        StringBuilder sb = new StringBuilder("Courses and Grades:\n");
        for (Course course : student.getCourses()) {
            String grade = student.getGradeForCourse(course);
            sb.append(course.getName()).append(": ").append(grade).append("\n");
        }
        area.setText(sb.toString());
    }
}