import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AssignGradeDialog extends JDialog {

    private StudentManagementSystem parent;
    private List<Student> students;
    private List<Course> courses;
    private JComboBox<Student> studentComboBox;
    private JComboBox<Course> courseComboBox;
    private JTextField gradeField;

    public AssignGradeDialog(StudentManagementSystem parent, List<Student> students, List<Course> courses) {
        super(parent, "Assign Grade", true);
        this.parent = parent;
        this.students = students;
        this.courses = courses;

        setLayout(new GridLayout(5, 2));

        add(new JLabel("Student:"));
        studentComboBox = new JComboBox<>(students.toArray(new Student[0]));
        studentComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Student) {
                    value = ((Student) value).getName() + " - " + ((Student) value).getId();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        add(studentComboBox);

        add(new JLabel("Course:"));
        courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));
        courseComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Course) {
                    value = ((Course) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        add(courseComboBox);

        add(new JLabel("Grade:"));
        gradeField = new JTextField();
        add(gradeField);

        JButton assignButton = new JButton("Assign Grade");
        add(assignButton);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) studentComboBox.getSelectedItem();
                Course course = (Course) courseComboBox.getSelectedItem();
                String grade = gradeField.getText();

                if (student != null && course != null && !grade.isEmpty()) {
                    student.assignGrade(course, grade);
                    parent.refreshTables();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AssignGradeDialog.this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }
}
