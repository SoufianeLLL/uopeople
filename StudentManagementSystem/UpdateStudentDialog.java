import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class UpdateStudentDialog extends JDialog {

    private DefaultTableModel studentTableModel;

    public UpdateStudentDialog(Frame parent, DefaultTableModel studentTableModel) {
        super(parent, "Update Student", true);
        this.studentTableModel = studentTableModel;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        add(idField);

        add(new JLabel("New Name:"));
        JTextField nameField = new JTextField();
        add(nameField);

        JButton updateButton = new JButton("Update Student");
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String newName = nameField.getText();

                if (!id.isEmpty() && !newName.isEmpty()) {
                    boolean updated = false;
                    for (int i = 0; i < studentTableModel.getRowCount(); i++) {
                        String currentId = (String) studentTableModel.getValueAt(i, 0);
                        if (currentId.equals(id)) {
                            studentTableModel.setValueAt(newName, i, 1);
                            updated = true;
                            break;
                        }
                    }

                    if (updated) {
                        JOptionPane.showMessageDialog(UpdateStudentDialog.this, "Student updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(UpdateStudentDialog.this, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(UpdateStudentDialog.this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
}
