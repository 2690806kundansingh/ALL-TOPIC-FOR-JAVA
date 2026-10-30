import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

class RecordFilter extends JFrame implements KeyListener {
    JLabel lid;
    JTextField tb;
    JTable ta;
    DefaultTableModel model;
    JScrollPane sp;

    // In-memory data store representing the "Employee" table
    String[] columns = {"EID", "Name", "Department", "Phone"};
    List<String[]> employeeData = new ArrayList<>();

    public RecordFilter() {
        setTitle("Employee Record Filter");
        setSize(520, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lid = new JLabel("Enter ID/Phone:");
        lid.setBounds(50, 40, 120, 27);
        add(lid);

        tb = new JTextField();
        tb.setBounds(170, 40, 180, 27);
        tb.addKeyListener(this);
        add(tb);

        // Initialize Table & Model
        model = new DefaultTableModel(columns, 0);
        ta = new JTable(model);
        sp = new JScrollPane(ta);
        sp.setBounds(50, 90, 400, 250);
        add(sp);

        // Populate sample records
        loadSampleData();

        setVisible(true);
    }

    private void loadSampleData() {
        employeeData.add(new String[]{"101", "Amit Kumar", "IT", "9876543210"});
        employeeData.add(new String[]{"102", "Pooja Sharma", "HR", "9123456780"});
        employeeData.add(new String[]{"103", "Rohan Verma", "Finance", "9988776655"});
        employeeData.add(new String[]{"104", "Sneha Rao", "IT", "9871122334"});
        employeeData.add(new String[]{"105", "Vikas Gupta", "Marketing", "9555667788"});
        employeeData.add(new String[]{"201", "Anjali Mehta", "Sales", "9444332211"});
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        String query = tb.getText().trim().toLowerCase();
        
        // Clear previous rows
        model.setRowCount(0);

        if (query.isEmpty()) {
            return;
        }

        // Filter by EID (index 0) or Phone (index 3) starting with query prefix
        for (String[] emp : employeeData) {
            String eid = emp[0].toLowerCase();
            String phone = emp[3].toLowerCase();

            if (eid.startsWith(query) || phone.startsWith(query)) {
                model.addRow(emp);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecordFilter());
    }
}