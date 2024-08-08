import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class AddStudentDialog extends JDialog {

    private StudentManagementSystem parent;

    public AddStudentDialog(StudentManagementSystem parent) {
        super(parent, "Add Student", true);
        this.parent = parent;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        add(idField);

        add(new JLabel("Student Name:"));
        JTextField nameField = new JTextField();
        add(nameField);

        JButton addButton = new JButton("Add Student");
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();

                if (!id.isEmpty() && !name.isEmpty()) {
                    parent.addStudent(id, name);
                    parent.refreshStudentTable();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AddStudentDialog.this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
}
