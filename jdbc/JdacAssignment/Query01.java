import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

class Query01 {
    public static void main(String args[]) {
        new Connect();
    }
}

class CreateFirstForm {
    StringBuffer strQuery = new StringBuffer("select ");
    StringBuffer orderByBuffer = new StringBuffer(" ");
    StringBuffer criteriaBuffer = new StringBuffer(" ");
    int createQueryStatus = 0;

    JFrame jf1;
    JLabel jl1, jl12, jl13, jl14, jl15;
    JComboBox<String> jcomb1, jcomb2, jcomb3;
    JTextField jtf1;
    JList<String> jlist1, jlist2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
    JCheckBox jcb1;
    JRadioButton jrb1, jrb2, jrb3;
    JScrollPane jsp1, jsp2;
    ButtonGroup bg1;

    CreateFirstForm() {
        jf1 = new JFrame("Query Builder");
        jf1.setSize(720, 650);
        jf1.setLocation(50, 30);
        jf1.setLayout(null);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl1 = new JLabel("Table to Be Queried");
        jl1.setBounds(40, 10, 200, 25);
        jf1.add(jl1);

        jcomb1 = new JComboBox<>(Connect.tableNames);
        jcomb1.setBounds(40, 40, 200, 25);
        jf1.add(jcomb1);

        jb1 = new JButton("Refresh");
        jb1.setBounds(300, 40, 100, 25);
        jf1.add(jb1);

        jlist1 = new JList<>();
        jsp1 = new JScrollPane(jlist1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp1.setBounds(40, 80, 200, 210);
        jf1.add(jsp1);

        jb2 = new JButton(">>");
        jb2.setBounds(260, 120, 60, 25);
        jf1.add(jb2);

        jb3 = new JButton("<<");
        jb3.setBounds(260, 160, 60, 25);
        jf1.add(jb3);

        jb4 = new JButton("<<<");
        jb4.setBounds(260, 200, 60, 25);
        jf1.add(jb4);

        jcb1 = new JCheckBox("Order By");
        jcb1.setBounds(260, 240, 100, 25);
        jf1.add(jcb1);

        jlist2 = new JList<>();
        jsp2 = new JScrollPane(jlist2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp2.setBounds(450, 80, 200, 200);
        jf1.add(jsp2);

        jl12 = new JLabel("Criteria");
        jl13 = new JLabel("Fields");
        jl14 = new JLabel("Operators");
        jl15 = new JLabel("Value");

        jl12.setBounds(40, 350, 200, 25); jf1.add(jl12);
        jl13.setBounds(150, 375, 100, 25); jf1.add(jl13);
        jl14.setBounds(280, 375, 100, 25); jf1.add(jl14);
        jl15.setBounds(470, 375, 100, 25); jf1.add(jl15);

        jcomb2 = new JComboBox<>();
        jcomb2.setBounds(150, 400, 120, 25);
        jf1.add(jcomb2);

        Vector<String> temp = new Vector<>();
        temp.add("---None---");
        temp.add("=");
        temp.add(">");
        temp.add(">=");
        temp.add("<");
        temp.add("<=");
        temp.add("!=");
        temp.add("LIKE");
        temp.add("BETWEEN");
        temp.add("IN");

        jcomb3 = new JComboBox<>(temp);
        jcomb3.setBounds(280, 400, 120, 25);
        jf1.add(jcomb3);

        jtf1 = new JTextField("Enter Value");
        jtf1.setBounds(420, 400, 140, 25);
        jf1.add(jtf1);

        jrb1 = new JRadioButton("AND");
        jrb1.setBounds(150, 440, 60, 25);
        jf1.add(jrb1);

        jrb2 = new JRadioButton("OR");
        jrb2.setBounds(220, 440, 60, 25);
        jf1.add(jrb2);

        jrb3 = new JRadioButton("None");
        jrb3.setBounds(290, 440, 70, 25);
        jf1.add(jrb3);

        bg1 = new ButtonGroup();
        bg1.add(jrb1);
        bg1.add(jrb2);
        bg1.add(jrb3);
        jrb3.setSelected(true);

        jb5 = new JButton("Execute");
        jb5.setBounds(580, 410, 100, 25);
        jf1.add(jb5);

        jb6 = new JButton("Build Query");
        jb6.setBounds(580, 440, 100, 25);
        jf1.add(jb6);

        jb7 = new JButton("Exit");
        jb7.setBounds(580, 470, 100, 30);
        jf1.add(jb7);

        jf1.setVisible(true);

        QueryEvent qev = new QueryEvent(this);
        jb1.addActionListener(qev);
        jb2.addActionListener(qev);
        jb3.addActionListener(qev);
        jb4.addActionListener(qev);
        jb5.addActionListener(qev);
        jb6.addActionListener(qev);
        jb7.addActionListener(qev);
        jcb1.addActionListener(qev);
    }
}

class QueryEvent implements ActionListener {
    CreateFirstForm cff;

    QueryEvent(CreateFirstForm cff) {
        this.cff = cff;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cff.jb1) {
            cff.orderByBuffer = new StringBuffer(" ");
            cff.criteriaBuffer = new StringBuffer(" ");
            cff.createQueryStatus = 0;
            cff.strQuery = new StringBuffer("select ");

            Connect.fieldNames = new Vector<>();
            cff.jlist2.setListData(Connect.fieldNames);

            try (Connection c = Connect.getConnection();
                 Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

                String str = (String) cff.jcomb1.getSelectedItem();
                if (str != null) {
                    ResultSet rs = s.executeQuery("select * from " + str);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int numberOfColumns = rsmd.getColumnCount();

                    Connect.columnNames = new Vector<>();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        Connect.columnNames.add(rsmd.getColumnName(i));
                    }
                    cff.jlist1.setListData(Connect.columnNames);

                    cff.jcomb2.removeAllItems();
                    cff.jcomb2.addItem("---None---");
                    for (String col : Connect.columnNames) {
                        cff.jcomb2.addItem(col);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(cff.jf1, "Error fetching columns: " + e.getMessage());
            }

            cff.jtf1.setText("Enter Value");
        }

        if (ae.getSource() == cff.jb2) {
            for (String col : cff.jlist1.getSelectedValuesList()) {
                if (!Connect.fieldNames.contains(col)) {
                    Connect.fieldNames.add(col);
                }
            }
            cff.jlist2.setListData(Connect.fieldNames);
            cff.jlist1.clearSelection();
        }

        if (ae.getSource() == cff.jb3) {
            for (String sel : cff.jlist2.getSelectedValuesList()) {
                Connect.fieldNames.remove(sel);
            }
            cff.jlist2.setListData(Connect.fieldNames);
        }

        if (ae.getSource() == cff.jb4) {
            Connect.fieldNames.removeAllElements();
            cff.jlist2.setListData(Connect.fieldNames);
        }

        if (ae.getSource() == cff.jb5) {
            new TableResult(cff.strQuery);
        }

        if (ae.getSource() == cff.jb6) {
            cff.strQuery = new StringBuffer("select ");
            int count = Connect.fieldNames.size();
            if (count == 0) {
                cff.strQuery.append("* ");
            } else {
                for (int i = 0; i < count; i++) {
                    cff.strQuery.append(Connect.fieldNames.elementAt(i));
                    cff.strQuery.append(i < count - 1 ? ", " : " ");
                }
            }

            cff.strQuery.append("FROM ").append(cff.jcomb1.getSelectedItem()).append(" ");

            if (cff.jcomb2.getSelectedItem() != null && !cff.jcomb2.getSelectedItem().equals("---None---") && !cff.jtf1.getText().equals("Enter Value")) {
                cff.criteriaBuffer = new StringBuffer("WHERE ");
                cff.criteriaBuffer.append(cff.jcomb2.getSelectedItem()).append(" ");
                cff.criteriaBuffer.append(cff.jcomb3.getSelectedItem()).append(" '");
                cff.criteriaBuffer.append(cff.jtf1.getText()).append("' ");
                cff.strQuery.append(cff.criteriaBuffer);
            }

            cff.strQuery.append(cff.orderByBuffer);
            JOptionPane.showMessageDialog(cff.jf1, "Generated Query:\n" + cff.strQuery.toString());
        }

        if (ae.getSource() == cff.jb7) {
            System.exit(0);
        }

        if (ae.getSource() == cff.jcb1) {
            JFrame jfOrder = new JFrame("Order By Optimizer");
            jfOrder.setSize(380, 250);
            jfOrder.setLocation(200, 200);
            jfOrder.setLayout(null);

            JLabel jlOrd = new JLabel("Order By Column:");
            jlOrd.setBounds(20, 20, 120, 25);
            jfOrder.add(jlOrd);

            JComboBox<String> jcombOrd = new JComboBox<>(Connect.columnNames);
            jcombOrd.insertItemAt("---None---", 0);
            jcombOrd.setSelectedIndex(0);
            jcombOrd.setBounds(150, 20, 180, 25);
            jfOrder.add(jcombOrd);

            JRadioButton jrbAsc = new JRadioButton("Ascending", true);
            jrbAsc.setBounds(60, 70, 100, 25);
            jfOrder.add(jrbAsc);

            JRadioButton jrbDesc = new JRadioButton("Descending");
            jrbDesc.setBounds(180, 70, 110, 25);
            jfOrder.add(jrbDesc);

            ButtonGroup bgOrd = new ButtonGroup();
            bgOrd.add(jrbAsc);
            bgOrd.add(jrbDesc);

            JButton jbOrdOk = new JButton("OK");
            jbOrdOk.setBounds(40, 130, 80, 25);
            jfOrder.add(jbOrdOk);

            JButton jbOrdClear = new JButton("Clear");
            jbOrdClear.setBounds(140, 130, 80, 25);
            jfOrder.add(jbOrdClear);

            JButton jbOrdCancel = new JButton("Cancel");
            jbOrdCancel.setBounds(240, 130, 80, 25);
            jfOrder.add(jbOrdCancel);

            jfOrder.setVisible(true);

            jbOrdOk.addActionListener(e -> {
                if (!"---None---".equals(jcombOrd.getSelectedItem())) {
                    cff.orderByBuffer = new StringBuffer(" ORDER BY ");
                    cff.orderByBuffer.append(jcombOrd.getSelectedItem());
                    cff.orderByBuffer.append(jrbAsc.isSelected() ? " ASC " : " DESC ");
                }
                jfOrder.dispose();
            });

            jbOrdClear.addActionListener(e -> {
                cff.orderByBuffer = new StringBuffer(" ");
                jfOrder.dispose();
            });

            jbOrdCancel.addActionListener(e -> jfOrder.dispose());
        }
    }
}

class TableResult {
    JFrame jf;
    JButton jb1, jb2;
    JScrollPane jsp;
    JTable jt;

    TableResult(StringBuffer sb) {
        createForm();
        showTable(sb.toString());
    }

    void createForm() {
        jf = new JFrame("Display Table Data");
        jf.setSize(600, 400);
        jf.setLocation(100, 100);
        jf.setLayout(null);

        jb1 = new JButton("Close");
        jb1.setBounds(180, 20, 100, 30);
        jf.add(jb1);

        jb2 = new JButton("Exit App");
        jb2.setBounds(300, 20, 100, 30);
        jf.add(jb2);

        jb1.addActionListener(e -> jf.dispose());
        jb2.addActionListener(e -> System.exit(0));
    }

    void showTable(String sql) {
        Vector<Vector<String>> rowDataMain = new Vector<>();
        Vector<String> colNames = new Vector<>();

        try (Connection c = Connect.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            for (int i = 1; i <= colCount; i++) {
                colNames.add(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 1; i <= colCount; i++) {
                    row.add(rs.getString(i));
                }
                rowDataMain.add(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jf, "SQL Query Error: " + e.getMessage());
            return;
        }

        jt = new JTable(rowDataMain, colNames);
        jsp = new JScrollPane(jt);
        jsp.setBounds(30, 70, 520, 260);
        jf.add(jsp);
        jf.setVisible(true);
    }
}

class Connect {
    static Vector<String> tableNames = new Vector<>();
    static Vector<String> columnNames = new Vector<>();
    static Vector<String> fieldNames = new Vector<>();

    static String driverClass = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost:3306/mydatabase?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
    static String dbUser = "root";
    static String dbPassword = "your_actual_password";

    JFrame jf;
    JComboBox<String> jcbDriver;
    JTextField jtfUrl, jtfUser;
    JPasswordField jtfPass;
    JButton jbOk, jbExit;

    Connect() {
        jf = new JFrame("Type 4 JDBC Multi-Driver Connector");
        jf.setSize(520, 280);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlDriver = new JLabel("Database Driver:");
        jlDriver.setBounds(30, 20, 120, 25);
        jf.add(jlDriver);

        String[] drivers = {
            "MySQL (Type 4)",
            "PostgreSQL (Type 4)",
            "Oracle Thin (Type 4)"
        };
        jcbDriver = new JComboBox<>(drivers);
        jcbDriver.setBounds(160, 20, 310, 25);
        jf.add(jcbDriver);

        JLabel jlUrl = new JLabel("JDBC URL:");
        jlUrl.setBounds(30, 60, 120, 25);
        jf.add(jlUrl);

        jtfUrl = new JTextField(dbUrl);
        jtfUrl.setBounds(160, 60, 310, 25);
        jf.add(jtfUrl);

        JLabel jlUser = new JLabel("Username:");
        jlUser.setBounds(30, 100, 120, 25);
        jf.add(jlUser);

        jtfUser = new JTextField(dbUser);
        jtfUser.setBounds(160, 100, 310, 25);
        jf.add(jtfUser);

        JLabel jlPass = new JLabel("Password:");
        jlPass.setBounds(30, 140, 120, 25);
        jf.add(jlPass);

        jtfPass = new JPasswordField(dbPassword);
        jtfPass.setBounds(160, 140, 310, 25);
        jf.add(jtfPass);

        jbOk = new JButton("Connect");
        jbOk.setBounds(160, 190, 110, 30);
        jf.add(jbOk);

        jbExit = new JButton("Exit");
        jbExit.setBounds(290, 190, 110, 30);
        jf.add(jbExit);

        jcbDriver.addActionListener(e -> {
            int idx = jcbDriver.getSelectedIndex();
            switch (idx) {
                case 0: // MySQL
                    driverClass = "com.mysql.jdbc.Driver";
                    jtfUrl.setText("jdbc:mysql://localhost:3306/mydatabase?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true");
                    jtfUser.setText("root");
                    jtfPass.setText("your_actual_password");
                    break;
                case 1: // PostgreSQL
                    driverClass = "org.postgresql.Driver";
                    jtfUrl.setText("jdbc:postgresql://localhost:5432/postgres");
                    jtfUser.setText("postgres");
                    jtfPass.setText("");
                    break;
                case 2: // Oracle
                    driverClass = "oracle.jdbc.driver.OracleDriver";
                    jtfUrl.setText("jdbc:oracle:thin:@localhost:1521:xe");
                    jtfUser.setText("system");
                    jtfPass.setText("");
                    break;
            }
        });

        jbOk.addActionListener(e -> {
            dbUrl = jtfUrl.getText().trim();
            dbUser = jtfUser.getText().trim();
            dbPassword = new String(jtfPass.getPassword());

            if (connectDatabase()) {
                jf.dispose();
                new CreateFirstForm();
            }
        });

        jbExit.addActionListener(e -> System.exit(0));
        jf.setVisible(true);
    }

    public static Connection getConnection() throws SQLException {
        if (driverClass.contains("mysql")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    throw new SQLException("MySQL Driver class not found in classpath.");
                }
            }
        } else {
            try {
                Class.forName(driverClass);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver class not found in classpath: " + driverClass);
            }
        }
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public boolean connectDatabase() {
        try (Connection c = getConnection()) {
            // If connected to MySQL, ensure sample table exists so dropdown is not empty
            if (driverClass.contains("mysql")) {
                try (Statement initStmt = c.createStatement()) {
                    initStmt.executeUpdate("CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name VARCHAR(50), age INT)");
                } catch (Exception ignored) {}
            }

            DatabaseMetaData dbmd = c.getMetaData();
            String[] types = {"TABLE"};

            String schemaPattern = null;
            String catalogPattern = null;

            if (driverClass.contains("oracle")) {
                schemaPattern = (dbUser != null && !dbUser.trim().isEmpty()) ? dbUser.trim().toUpperCase() : null;
            } else if (driverClass.contains("postgresql")) {
                schemaPattern = "public";
            }

            ResultSet rs = dbmd.getTables(catalogPattern, schemaPattern, "%", types);

            tableNames.removeAllElements();
            while (rs.next()) {
                tableNames.add(rs.getString("TABLE_NAME"));
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jf, "Connection failed:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

//javac -cp ".;*" Query01.java
//java -cp ".;*" Query01