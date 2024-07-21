package fitnessmanager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BioCalc extends JFrame {

    private JPanel contentPane;
    private JTextField txtAge;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JRadioButton rdbMale;
    private JRadioButton rdbFemale;

    // Method to launch the BioCalc frame
    public static void run(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BioCalc frame = new BioCalc();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor for the BioCalc frame
    public BioCalc() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 293, 609);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 153, 102));
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Loading images for the header
        BufferedImage Imgbar = ImageIO.read(new File("/Users/ganesh/Downloads/Microsoft-Fluentui-Emoji-3d-Orange-Square-3d.512.png"));
        BufferedImage logo = ImageIO.read(new File("/Users/ganesh/Desktop/FontAwesome-Weight-Scale-icon.png"));

        // Adding the logo image
        JLabel lblNewLabel_1 = new JLabel(new ImageIcon(logo));
        lblNewLabel_1.setBounds(36, 7, 61, 52);
        contentPane.add(lblNewLabel_1);

        // Button to return to the main frame
        JButton btnNewButton_1 = new JButton("⬅");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    returnMain();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds(108, 521, 68, 29);
        contentPane.add(btnNewButton_1);

        // Label for the calculator title
        JLabel lblNewLabel_2 = new JLabel("Calculator");
        lblNewLabel_2.setBackground(Color.BLACK);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Silom", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(101, 20, 142, 32);
        contentPane.add(lblNewLabel_2);

        // Header image
        JLabel lblNewLabel = new JLabel(new ImageIcon(Imgbar));
        lblNewLabel.setBounds(0, 0, 293, 66);
        contentPane.add(lblNewLabel);

        // Text fields for user input
        txtAge = new JTextField();
        txtAge.setBounds(16, 131, 260, 45);
        contentPane.add(txtAge);
        txtAge.setColumns(10);

        // Labels for input fields
        JLabel lblNewLabel_3 = new JLabel("AGE ");
        lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 15));
        lblNewLabel_3.setBounds(21, 101, 36, 32);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("GENDER");
        lblNewLabel_3_1.setFont(new Font("Monospaced", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(21, 185, 87, 32);
        contentPane.add(lblNewLabel_3_1);

        // Radio buttons for gender selection
        rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(14, 222, 61, 23);
        contentPane.add(rdbMale);

        rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(93, 222, 81, 23);
        contentPane.add(rdbFemale);

        JLabel lblNewLabel_3_2 = new JLabel("HEIGHT");
        lblNewLabel_3_2.setFont(new Font("Monospaced", Font.BOLD, 15));
        lblNewLabel_3_2.setBounds(21, 262, 54, 32);
        contentPane.add(lblNewLabel_3_2);

        txtHeight = new JTextField();
        txtHeight.setColumns(10);
        txtHeight.setBounds(16, 292, 260, 45);
        contentPane.add(txtHeight);

        JLabel lblNewLabel_3_2_1 = new JLabel("WEIGHT");
        lblNewLabel_3_2_1.setFont(new Font("Monospaced", Font.BOLD, 15));
        lblNewLabel_3_2_1.setBounds(21, 344, 54, 32);
        contentPane.add(lblNewLabel_3_2_1);

        txtWeight = new JTextField();
        txtWeight.setColumns(10);
        txtWeight.setBounds(16, 376, 260, 45);
        contentPane.add(txtWeight);

        // Button to calculate and open results
        JButton btnNewButton = new JButton("CALCULATE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    openResults();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(83, 439, 117, 29);
        contentPane.add(btnNewButton);

        // Footer image
        JLabel lblNewLabel_4 = new JLabel(new ImageIcon(Imgbar));
        lblNewLabel_4.setBounds(0, 490, 293, 90);
        contentPane.add(lblNewLabel_4);
    }

    // Method to calculate BMI
    private double calcBMI() {
        int age = Integer.parseInt(txtAge.getText());
        double height = Double.parseDouble(txtHeight.getText());
        double weight = Double.parseDouble(txtWeight.getText());
        height /= 100.0;
        boolean isMale = rdbMale.isSelected();
        double bmi = weight / (height * height);
        return bmi;
    }

    // Method to calculate BMR
    private double calcBMR() {
        double weight = Double.parseDouble(txtWeight.getText());
        double height = Double.parseDouble(txtHeight.getText());
        int age = Integer.parseInt(txtAge.getText());
        boolean isMale = rdbMale.isSelected();
        double bmr;
        if (isMale) {
            bmr = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }
        return bmr;
    }

    // Method to open the results frame
    private void openResults() throws IOException {
        double bmi = calcBMI();
        double bmr = calcBMR();
        Results rs = new Results(bmi, bmr);
        rs.setVisible(true);
    }

    // Method to return to the main frame
    private void returnMain() throws IOException {
        dispose();
        Main main = new Main();
        main.setVisible(true);
    }
}
