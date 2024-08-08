import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class AddCourseDialog extends JDialog {

    private DefaultTableModel courseTableModel;

    public AddCourseDialog(Frame parent, DefaultTableModel courseTableModel) {
        super(parent, "Add Course", true);
        this.courseTableModel = courseTableModel;

        setLayout(new GridLayout(2, 2));

        add(new JLabel("Course Name:"));
        JTextField courseNameField = new JTextField();
        add(courseNameField);

        JButton addButton = new JButton("Add Course");
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();

                if (!courseName.isEmpty()) {
                    Course course = new Course(courseName);
                    courseTableModel.addRow(new Object[]{course.getName()});
                    ((StudentManagementSystem) parent).getCourses().add(course); // Update course list
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AddCourseDialog.this, "Please enter a course name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
}
