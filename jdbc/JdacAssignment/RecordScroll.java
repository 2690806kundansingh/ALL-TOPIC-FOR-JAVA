import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class RecordScroll extends JFrame implements AdjustmentListener {
    JScrollBar bar;
    JLabel[] la = new JLabel[4];
    JTextField[] tb = new JTextField[4];
    JLabel rv;
    
    // In-memory record storage
    List<String[]> records = new ArrayList<>();
    int nor = 0;

    public RecordScroll() {
        setTitle("Student Records Navigator");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        String[] str = {"Sid", "Name", "City", "Age"};
        int y = 30;

        for (int i = 0; i < la.length; i++) {
            la[i] = new JLabel(str[i]);
            la[i].setBounds(50, y, 90, 27);
            add(la[i]);

            tb[i] = new JTextField();
            tb[i].setBounds(150, y, 180, 27);
            tb[i].setEditable(false);
            add(tb[i]);

            y += 50;
        }

        // Counter label
        rv = new JLabel("", SwingConstants.CENTER);
        rv.setBounds(150, y, 100, 25);
        add(rv);

        // Load sample records
        initData();

        // Scrollbar setup: (Orientation, Value, Extent, Min, Max)
        bar = new JScrollBar(JScrollBar.HORIZONTAL, 1, 1, 1, nor + 1);
        bar.setBounds(50, y + 35, 280, 25);
        bar.addAdjustmentListener(this);
        add(bar);

        if (nor > 0) {
            showRecord(1);
        } else {
            rv.setText("0 / 0");
        }

        setVisible(true);
    }

    private void initData() {
        // Mock dataset representing rows from the "Student" table
        records.add(new String[]{"101", "Rahul Sharma", "Delhi", "21"});
        records.add(new String[]{"102", "Priya Patel", "Mumbai", "22"});
        records.add(new String[]{"103", "Aman Verma", "Noida", "20"});
        records.add(new String[]{"104", "Sneha Rao", "Bangalore", "23"});
        records.add(new String[]{"105", "Vikas Gupta", "Pune", "24"});

        nor = records.size();
    }

    void showRecord(int rn) {
        if (rn >= 1 && rn <= nor) {
            String[] row = records.get(rn - 1);
            for (int i = 0; i < 4; i++) {
                tb[i].setText(row[i]);
            }
            rv.setText(rn + " / " + nor);
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        showRecord(e.getValue());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecordScroll());
    }
}