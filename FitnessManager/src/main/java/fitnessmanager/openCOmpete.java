package fitnessmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class openCOmpete extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JTextField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    openCOmpete frame = new openCOmpete();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public openCOmpete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 165, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1_2 = new JLabel("Username");
        lblNewLabel_1_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(179, 54, 86, 29);
        contentPane.add(lblNewLabel_1_2);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(110, 83, 229, 26);
        contentPane.add(txtUsername);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(181, 134, 146, 29);
        contentPane.add(lblNewLabel_1_1);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(110, 160, 229, 26);
        contentPane.add(txtPassword);

        JButton btncomp = new JButton("Enter Competition");
        btncomp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btncomp.setForeground(new Color(255, 165, 0));
        btncomp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                
                if (checkUserCredentials(username, password)) {
                    Compete competeFrame = new Compete(username, password);
                    competeFrame.setSize(1018, 601); 
                    competeFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Username Taken", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btncomp.setBounds(156, 217, 146, 29);
        contentPane.add(btncomp);

        JButton btnreturn = new JButton("⬅");
        btnreturn.setForeground(new Color(255, 140, 0));
        btnreturn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        btnreturn.addActionListener(new ActionListener() {
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
        btnreturn.setBounds(6, 6, 55, 29);
        contentPane.add(btnreturn);
    }

    private boolean checkUserCredentials(String username, String password) {
        String url = "jdbc:sqlite:/Users/ganesh/Desktop/fmdb.db";
        String selectQuery = "SELECT * FROM cmpTable WHERE Username = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {

            selectStatement.setString(1, username);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("Password");
                return password.equals(storedPassword);
            } else {
                return true; 
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false; // Error occurred
    }


}
