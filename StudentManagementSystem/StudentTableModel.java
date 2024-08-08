import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentTableModel extends DefaultTableModel {
    private List<Student> students;

    public StudentTableModel(List<Student> students) {
        super(new String[]{"Student ID", "Student Name"}, 0);
        this.students = students;
        updateTable();
    }

    public void addStudent(Student student) {
        students.add(student);
        addRow(new Object[]{student.getId(), student.getName()});
    }

    public boolean updateStudent(String id, String newName) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(id)) {
                student.setName(newName);
                setValueAt(newName, i, 1);
                return true;
            }
        }
        return false;
    }

    public void updateTable() {
        setRowCount(0);
        for (Student student : students) {
            addRow(new Object[]{student.getId(), student.getName()});
        }
    }
}
