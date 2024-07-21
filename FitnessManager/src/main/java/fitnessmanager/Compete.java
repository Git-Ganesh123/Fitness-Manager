package fitnessmanager;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class Compete extends JFrame {

    private Connection connection;
    private JPanel contentPane;
    private JTable cmp100;
    private JTextField txt100;
    private JTextField txt200;
    private JTextField txt400;
    private JTextField txt5k;
    private JTable cmp400;
    private JTable cmmp5k;
    private JTable cmp200;

    private static String enteredUsername;
    private static String enteredPassword;
    
    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Compete frame = new Compete(enteredUsername, enteredPassword);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Compete(String username, String password) {
        enteredUsername = username;
        enteredPassword = password;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1015, 601);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
       

        try {
            String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";
            connection = DriverManager.getConnection(url);
            Runtime.getRuntime().addShutdownHook(new Thread(this::closeConnection));
            connection.setAutoCommit(false); 

            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
        UIManager.put("Table.focusCellHighlightBorder",
        	    new BorderUIResource(BorderFactory.createLineBorder(Color.orange)));
        UIManager.put("TableHeader.background", new ColorUIResource(Color.ORANGE));
        UIManager.put("TableHeader.foreground", new ColorUIResource(Color.BLACK));
        
        cmp100 = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cmp100.setBounds(204, 20, 382, 251);
        contentPane.add(cmp100);

        JLabel lblNewLabel_1 = new JLabel("100m Time - ");
        lblNewLabel_1.setForeground(new Color(255, 165, 0));
        lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_1.setBounds(38, 64, 110, 29);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("200m Time - ");
        lblNewLabel_2.setForeground(new Color(255, 165, 0));
        lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_2.setBounds(38, 169, 110, 29);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("400m Time -");
        lblNewLabel_2_1.setForeground(new Color(255, 165, 0));
        lblNewLabel_2_1.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_2_1.setBounds(38, 272, 114, 29);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("5K time - ");
        lblNewLabel_2_2.setForeground(new Color(255, 165, 0));
        lblNewLabel_2_2.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_2_2.setBounds(54, 374, 81, 29);
        contentPane.add(lblNewLabel_2_2);

        txt100 = new JTextField();
        txt100.setBounds(15, 105, 159, 26);
        contentPane.add(txt100);
        txt100.setColumns(10);

        txt200 = new JTextField();
        txt200.setColumns(10);
        txt200.setBounds(15, 210, 159, 26);
        contentPane.add(txt200);

        txt400 = new JTextField();
        txt400.setColumns(10);
        txt400.setBounds(15, 313, 159, 26);
        contentPane.add(txt400);

        txt5k = new JTextField();
        txt5k.setColumns(10);
        txt5k.setBounds(15, 415, 159, 26);
        contentPane.add(txt5k);

        cmp400 = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cmp400.setBounds(204, 300, 382, 251);
        contentPane.add(cmp400);

        cmmp5k = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cmmp5k.setBounds(611, 300, 382, 251);
        contentPane.add(cmmp5k);

        cmp200 = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cmp200.setBounds(611, 20, 382, 251);
        contentPane.add(cmp200);

        JScrollPane cmp100ScrollPane = new JScrollPane(cmp100);
        cmp100ScrollPane.setBounds(204, 20, 382, 251);
        contentPane.add(cmp100ScrollPane);

        JScrollPane cmp200ScrollPane = new JScrollPane(cmp200);
        cmp200ScrollPane.setBounds(611, 20, 382, 251);
        contentPane.add(cmp200ScrollPane);

        JScrollPane cmp400ScrollPane = new JScrollPane(cmp400);
        cmp400ScrollPane.setBounds(204, 300, 382, 251);
        contentPane.add(cmp400ScrollPane);

        JScrollPane cmmp5kScrollPane = new JScrollPane(cmmp5k);
        cmmp5kScrollPane.setBounds(611, 300, 382, 251);
        contentPane.add(cmmp5kScrollPane);

        addDoubleClickEditFeature(cmp100);
        addDoubleClickEditFeature(cmp200);
        addDoubleClickEditFeature(cmp400);
        addDoubleClickEditFeature(cmmp5k);
        
        updateTableHeaders();
        
        updateTables();

        JButton btnCompete = new JButton("Compete!");
        btnCompete.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnCompete.setForeground(new Color(255, 140, 0));
        btnCompete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                    double time100 = parseTimeToSeconds(txt100.getText());
                    double time200 = parseTimeToSeconds(txt200.getText());
                    double time400 = parseTimeToSeconds(txt400.getText());
                    double time5k = parseTimeToSeconds(txt5k.getText());

                    insertData();
                    updateTables();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Invalid time format. Please enter time in hh:mm:ss.ss format.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                
                
            }
        });
        btnCompete.setBounds(44, 466, 104, 29);
        contentPane.add(btnCompete);

        JButton btnNewButton = new JButton("⬅");
        btnNewButton.setForeground(new Color(255, 165, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main main = null;
                try {
                    main = new Main();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                main.setVisible(true);
            }
        });
        btnNewButton.setBounds(10, 0, 59, 29);
        contentPane.add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 165, 0));
        panel.setBounds(191, -12, 824, 585);
        contentPane.add(panel);
        
        JButton btnPredict = new JButton("PREDICT MY STATS");
        btnPredict.setForeground(new Color(255, 102, 0));
        btnPredict.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    double time100 = parseTimeToSeconds(txt100.getText());
                    double time200 = parseTimeToSeconds(txt200.getText());
                    double time400 = parseTimeToSeconds(txt400.getText());
                    double time5k = parseTimeToSeconds(txt5k.getText());

                    Predictions preds = new Predictions(time100, time200, time400, time5k);
                    preds.setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Invalid time format. Please enter time in hh:mm:ss.ss format.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        btnPredict.setBounds(7, 505, 177, 59);
        contentPane.add(btnPredict);
        
        connectToDatabase(); // Extracted method for database connection
        updateTableHeaders();
        updateTables();
    }
    
    
    private void addDoubleClickEditFeature(final JTable table) {
        table.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Detect double-click
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String username = (String) table.getValueAt(selectedRow, 1);
                        if (username.equals(enteredUsername)) {
                            populateTextFieldsFromDatabase(username);
                        } else {
                            JOptionPane.showMessageDialog(
                                null,
                                "Unable to edit other user's data",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                }
            }
        });
    }


    
    
    private void insertData() {
        try {
            double time100 = parseTimeToSeconds(txt100.getText());
            double time200 = parseTimeToSeconds(txt200.getText());
            double time400 = parseTimeToSeconds(txt400.getText());
            double time5k = parseTimeToSeconds(txt5k.getText());

            // Check if the user already has records in the database
            String selectQuery = "SELECT * FROM cmpTable WHERE Username = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setString(1, enteredUsername);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    // User exists, update the records
                    String updateQuery = "UPDATE cmpTable SET \"100m\" = ?, \"200m\" = ?, \"400m\" = ?, \"5k\" = ? WHERE Username = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                        updateStatement.setLong(1, (long) time100);
                        updateStatement.setLong(2, (long) time200);
                        updateStatement.setLong(3, (long) time400);
                        updateStatement.setLong(4, (long) time5k);
                        updateStatement.setString(5, enteredUsername);
                        updateStatement.executeUpdate();
                    }
                } else {
                    // User does not exist, insert new records
                    String insertQuery = "INSERT INTO cmpTable (\"Username\", \"Password\", \"100m\", \"200m\", \"400m\", \"5k\") VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                        insertStatement.setString(1, enteredUsername);
                        insertStatement.setString(2, enteredPassword);
                        insertStatement.setLong(3, (long) time100);
                        insertStatement.setLong(4, (long) time200);
                        insertStatement.setLong(5, (long) time400);
                        insertStatement.setLong(6, (long) time5k);
                        insertStatement.executeUpdate();
                    }
                }
                connection.commit();
                System.out.println("Data updated successfully.");
                updateTables();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Log the exception or show an error message
            JOptionPane.showMessageDialog(
                    null,
                    "Error updating database: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



    private void updateTables() {
        String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";

        try (Connection connection = DriverManager.getConnection(url)) {
        	
           
            String cmp100Query = "SELECT RANK() OVER(ORDER BY \"100m\" ASC) AS Rank, \"Username\", \"100m\" FROM cmpTable ORDER BY \"100m\" ASC";
            ResultSet cmp100Result = connection.createStatement().executeQuery(cmp100Query);
            DefaultTableModel cmp100Model = buildTableModel(cmp100Result, "100m");
            cmp100.setModel(cmp100Model);

            String cmp200Query = "SELECT RANK() OVER(ORDER BY \"200m\" ASC) AS Rank, \"Username\", \"200m\" FROM cmpTable ORDER BY \"200m\" ASC";
            ResultSet cmp200Result = connection.createStatement().executeQuery(cmp200Query);
            DefaultTableModel cmp200Model = buildTableModel(cmp200Result, "200m");
            cmp200.setModel(cmp200Model);

            String cmp400Query = "SELECT RANK() OVER(ORDER BY \"400m\" ASC) AS Rank, \"Username\", \"400m\" FROM cmpTable ORDER BY \"400m\" ASC";
            ResultSet cmp400Result = connection.createStatement().executeQuery(cmp400Query);
            DefaultTableModel cmp400Model = buildTableModel(cmp400Result, "400m");
            cmp400.setModel(cmp400Model);

            String cmmp5kQuery = "SELECT RANK() OVER(ORDER BY \"5k\" ASC) AS Rank, \"Username\", \"5k\" FROM cmpTable ORDER BY \"5k\" ASC";
            ResultSet cmmp5kResult = connection.createStatement().executeQuery(cmmp5kQuery);
            DefaultTableModel cmmp5kModel = buildTableModel(cmmp5kResult, "5k");
            cmmp5k.setModel(cmmp5kModel);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            Runtime.getRuntime().addShutdownHook(new Thread(this::closeConnection));
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Log the exception or show an error message
            JOptionPane.showMessageDialog(
                    null,
                    "Error connecting to the database: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    

    private DefaultTableModel buildTableModel(ResultSet resultSet, String eventName) throws SQLException {
        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames[columnIndex - 1] = metaData.getColumnName(columnIndex);
        }

        String[] additionalHeader = new String[columnCount];
        additionalHeader[0] = "";
        additionalHeader[1] = "Event";
        for (int i = 2; i < columnCount; i++) {
            additionalHeader[i] = eventName;
        }

        Object[][] data = new Object[0][columnCount];
        while (resultSet.next()) {
            Object[] newRow = new Object[columnCount];
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                if (metaData.getColumnName(columnIndex).contains("Time")) {
                    newRow[columnIndex - 1] = convertToHHMMSS(resultSet.getDouble(columnIndex));
                } else {
                    newRow[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
            }
            data = addRow(data, newRow);
        }

        data = addRow(data, additionalHeader);

        return new DefaultTableModel(data, columnNames);
    }



    private Object[][] addRow(Object[][] originalArray, Object[] newRow) {
        Object[][] newArray = new Object[originalArray.length + 1][newRow.length];
        for (int rowIndex = 0; rowIndex < originalArray.length; rowIndex++) {
            newArray[rowIndex] = originalArray[rowIndex];
        }
        newArray[originalArray.length] = newRow;
        return newArray;
    }
    
    private void updateDatabase() {
        String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";
        double time100 = convertTimeToSeconds(txt100.getText());
        double time200 = convertTimeToSeconds(txt200.getText());
        double time400 = convertTimeToSeconds(txt400.getText());
        double time5k = convertTimeToSeconds(txt5k.getText());


        String updateQuery = "UPDATE cmpTable SET \"100m\" = ?, \"200m\" = ?, \"400m\" = ?, \"5k\" = ? WHERE Username = ?";
        
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            updateStatement.setLong(1, (long) time100);
            updateStatement.setLong(2, (long) time200);
            updateStatement.setLong(3, (long) time400);
            updateStatement.setLong(4, (long) time5k);
            updateStatement.setString(5, enteredUsername);

            updateStatement.executeUpdate();
            System.out.println("Data updated successfully.");


            updateTables();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateTextFieldsFromDatabase(String username) {
        String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";
        String selectQuery = "SELECT * FROM cmpTable WHERE Username = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {

            selectStatement.setString(1, username);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                txt100.setText(convertToHHMMSS(resultSet.getDouble("100m")));
                txt200.setText(convertToHHMMSS(resultSet.getDouble("200m")));
                txt400.setText(convertToHHMMSS(resultSet.getDouble("400m")));
                txt5k.setText(convertToHHMMSS(resultSet.getDouble("5k")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    private void setTableHeaderRenderer(JTable table, final String eventName) {
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.ORANGE);
        header.setForeground(table.getTableHeader().getForeground());
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(JLabel.CENTER);
            }
        });


        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, table);
        if (scrollPane != null) {
            scrollPane.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(),
                    eventName,
                    TitledBorder.LEFT,
                    TitledBorder.TOP,
                    new Font("Bold", Font.BOLD, 14), 
                    Color.BLACK             ));
        }

        table.setSelectionBackground(Color.ORANGE);
    }
    private double convertTimeToSeconds(String timeStr) {
        try {
            String[] parts = timeStr.split(":");
            if (parts.length != 3) {
                throw new ParseException("Invalid time format", 0);
            }

            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            String[] secondsParts = parts[2].split("\\.");
            if (secondsParts.length != 2) {
                throw new ParseException("Invalid time format", 0);
            }

            int seconds = Integer.parseInt(secondsParts[0]);
            double milliseconds = Double.parseDouble(secondsParts[1]);

            if (hours < 0 || minutes < 0 || seconds < 0 || milliseconds < 0) {
                throw new ParseException("Time components cannot be negative", 0);
            }

            return (hours * 3600) + (minutes * 60) + seconds + (milliseconds / 100);
        } catch (NumberFormatException | ParseException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    
    private double parseTimeToSeconds(String timeStr) {
        try {
            String[] parts = timeStr.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            String[] secondsParts = parts[2].split("\\.");
            int seconds = Integer.parseInt(secondsParts[0]);
            double milliseconds = Double.parseDouble(secondsParts[1]);
            return (hours * 3600) + (minutes * 60) + seconds + (milliseconds / 100);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 0.0; // Return 0 if there was an error
        }
    }


    private String convertToHHMMSS(double seconds) {
        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int secs = (int) (seconds % 60);
        int milliseconds = (int) ((seconds - Math.floor(seconds)) * 100);


        return String.format("%02d:%02d:%02d.%02d", hours, minutes, secs, milliseconds);
       
    }



    
    private void updateTableHeaders() {
        setTableHeaderRenderer(cmp100, "100m");
        setTableHeaderRenderer(cmp200, "200m");
        setTableHeaderRenderer(cmp400, "400m");
        setTableHeaderRenderer(cmmp5k, "5k");
    }
}
