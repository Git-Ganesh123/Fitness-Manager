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

public class WpCalc extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnCalculate;
    private JComboBox cmbExercise;
    private JComboBox cmbLevel;
    private JRadioButton rdbMale;
    private JRadioButton rdbFemale;
    private JLabel lblNewLabel_2;
    private JLabel lblExercise;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void run(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WpCalc frame = new WpCalc();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws IOException 
     */
    public WpCalc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 426, 685);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setForeground(new Color(255, 250, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // JComboBox for selecting the exercise
        cmbExercise = new JComboBox();
        cmbExercise.setBounds(12, 155, 255, 34);
        contentPane.add(cmbExercise);
        cmbExercise.addItem("Bench Press");
        cmbExercise.addItem("Shoulder Press");
        cmbExercise.addItem("Squat");
        cmbExercise.addItem("Deadlift");
        cmbExercise.addItem("Bicep Curl");
        cmbExercise.addItem("Tricep Pushdown");

        // JComboBox for selecting the comfort level
        cmbLevel = new JComboBox();
        cmbLevel.setBounds(12, 241, 255, 34);
        contentPane.add(cmbLevel);
        cmbLevel.addItem("Beginner");
        cmbLevel.addItem("Intermediate");
        cmbLevel.addItem("Advanced");

        // Labels for guiding user input
        JLabel lblNewLabel = new JLabel("Choose an Exercise");
        lblNewLabel.setBounds(16, 116, 166, 34);
        contentPane.add(lblNewLabel);

        JLabel lblChooseYourComfortlevel = new JLabel("Choose Your Comfort Level");
        lblChooseYourComfortlevel.setBounds(16, 198, 212, 34);
        contentPane.add(lblChooseYourComfortlevel);

        JLabel lblGender = new JLabel("Gender ");
        lblGender.setBounds(16, 280, 212, 34);
        contentPane.add(lblGender);

        // RadioButtons for selecting gender
        rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(16, 316, 81, 23);
        contentPane.add(rdbMale);

        rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(98, 316, 95, 23);
        contentPane.add(rdbFemale);

        // Label and TextField for entering weight
        JLabel lblWeightinKilograms = new JLabel("Weight (in Kilograms)");
        lblWeightinKilograms.setBounds(16, 351, 212, 34);
        contentPane.add(lblWeightinKilograms);

        textField = new JTextField();
        textField.setBounds(16, 386, 251, 45);
        contentPane.add(textField);
        textField.setColumns(10);

        // Labels for displaying calculated results
        JLabel lblNewLabel_1 = new JLabel("Your ideal Working Weight for the");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(48, 495, 330, 45);
        contentPane.add(lblNewLabel_1);

        lblExercise = new JLabel("Exercise");
        lblExercise.setForeground(new Color(0, 0, 0));
        lblExercise.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        lblExercise.setHorizontalAlignment(SwingConstants.CENTER);
        lblExercise.setBounds(48, 536, 330, 55);
        contentPane.add(lblExercise);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(new Color(255, 165, 0));
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(48, 577, 330, 60);
        contentPane.add(lblNewLabel_2);

        // Label for the frame title
        JLabel lblNewLabel_3 = new JLabel("WEIGHT SELECTOR");
        lblNewLabel_3.setForeground(new Color(255, 140, 0));
        lblNewLabel_3.setFont(new Font("Myanmar MN", Font.BOLD, 25));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 51, 426, 60);
        contentPane.add(lblNewLabel_3);

        // Logo image
        try {
            BufferedImage logo = ImageIO.read(new File("/Users/ganesh/Desktop/Screenshot 2023-08-08 at 9.47.37 PM.png"));
            JLabel LOGO = new JLabel(new ImageIcon(logo));
            LOGO.setBounds(124, 6, 181, 55);
            contentPane.add(LOGO);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details
        }

        // Button to calculate the ideal working weight
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplayWeight();
            }
        });
        btnCalculate.setBounds(150, 457, 117, 29);
        contentPane.add(btnCalculate);

        // Button to return to the WorkoutPlan frame
        btnNewButton = new JButton("⬅");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    WorkoutPlan wp = new WorkoutPlan();
                    wp.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(0, 6, 51, 29);
        contentPane.add(btnNewButton);
    }

    // Method to calculate and display the ideal working weight
    private void calculateAndDisplayWeight() {
        // Retrieve selected exercise and comfort level
        String selectedExercise = (String) cmbExercise.getSelectedItem();
        String selectedLevel = (String) cmbLevel.getSelectedItem();

        // Retrieve weight from the text field
        String weightText = textField.getText();
        if (selectedExercise == null || selectedLevel == null || weightText.isEmpty()) {
            showErrorDialog("Please fill in all the fields.");
            return;
        }

        // Parse weight from the text field
        double weight = Double.parseDouble(textField.getText());
        try {
            weight = Double.parseDouble(weightText);
        } catch (NumberFormatException ex) {
            showErrorDialog("Invalid weight. Please enter a valid number.");
            return;
        }

        // Determine gender multiplier based on selected gender
        boolean isMale = rdbMale.isSelected();
        double genderMultiplier = isMale ? 1.0 : 0.7;

        // Default multipliers for different levels
        double beginnerMultiplier = 0.5;
        double intermediateMultiplier = 0.6;
        double advancedMultiplier = 0.75;

        // Adjust multipliers based on selected exercise
        if (selectedExercise.equals("Bench Press")) {
            beginnerMultiplier = 0.7;
            intermediateMultiplier = 1.15;
            advancedMultiplier = 1.7;
        } else if (selectedExercise.equals("Shoulder Press")) {
            beginnerMultiplier = 0.47;
            intermediateMultiplier = 0.8;
            advancedMultiplier = 1.3;
        } else if (selectedExercise.equals("Deadlift")) {
            beginnerMultiplier = 1.35;
            intermediateMultiplier = 1.9;
            advancedMultiplier = 2.4;
        } else if (selectedExercise.equals("Squat")) {
            beginnerMultiplier = 1.36;
            intermediateMultiplier = 1.95;
            advancedMultiplier = 2.3;
        } else if (selectedExercise.equals("Bicep Curl")) {
            beginnerMultiplier = 0.1;
            intermediateMultiplier = 0.23;
            advancedMultiplier = 0.33;
        } else if (selectedExercise.equals("Tricep Pushdown")) {
            beginnerMultiplier = 0.38;
            intermediateMultiplier = 0.71;
            advancedMultiplier = 1.1;
        }

        // Adjust multipliers based on selected level
        if (selectedLevel.equals("Intermediate")) {
            beginnerMultiplier = intermediateMultiplier;
        } else if (selectedLevel.equals("Advanced")) {
            beginnerMultiplier = advancedMultiplier;
        }

        // Calculate and display the ideal working weight
        double exerciseWeight = (beginnerMultiplier) * 0.9 * genderMultiplier * weight;
        lblNewLabel_2.setText(String.format("%.3fkg", exerciseWeight));
        lblExercise.setText(selectedExercise);
    }

    // Method to show an error dialog
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
