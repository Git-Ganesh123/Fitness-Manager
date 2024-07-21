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

public class Results extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void run(String[] args) {
        try {
            Results dialog = new Results(0.000, 0.000);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     * @throws IOException 
     */
    public Results(final double bmi, final double bmr) throws IOException {
        getContentPane().setBackground(new Color(255, 127, 80));
        setBounds(100, 100, 510, 261);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 127, 80));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        contentPanel.setLayout(null);
        {
            // Image for the background
            BufferedImage Imgbar = ImageIO.read(new File("/Users/ganesh/Downloads/Microsoft-Fluentui-Emoji-3d-Orange-Square-3d.512.png"));

            // Labels for displaying BMI and BMR
            JLabel lblbmrwarning = new JLabel("");
            lblbmrwarning.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
            lblbmrwarning.setBounds(251, 113, 253, 60);
            contentPanel.add(lblbmrwarning);
            if (bmr < 1500) {
                lblbmrwarning.setText("Eat more calories for healthy living.");
            } else if (bmr >= 1500 && bmr < 2000) {
                lblbmrwarning.setText("Eat the same amount of calories for healthy living.");
            } else {
                lblbmrwarning.setText("Eat fewer calories for healthy living.");
            }

            JLabel lblbmiwarning = new JLabel("");
            lblbmiwarning.setBounds(17, 113, 180, 60);
            contentPanel.add(lblbmiwarning);
            if (bmi < 18.5) {
                lblbmiwarning.setText("This indicates malnourishment.");
            } else if (bmi >= 18.5 && bmi < 25) {
                lblbmiwarning.setText("This indicates a healthy BMI.");
            } else {
                lblbmiwarning.setText("This indicates obesity.");
            }

            JLabel lblNewLabel_1 = new JLabel("-");
            lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_1.setBounds(235, 83, 61, 16);
            contentPanel.add(lblNewLabel_1);

            JLabel lblBMR = new JLabel("0.000");
            lblBMR.setText(String.format("%.2f", bmr));
            lblBMR.setForeground(new Color(255, 255, 255));
            lblBMR.setFont(new Font("Lahore Gurmukhi", Font.PLAIN, 25));
            lblBMR.setBounds(358, 53, 86, 29);
            contentPanel.add(lblBMR);

            JLabel lblBMI = new JLabel("0.000");
            lblBMI.setText(String.format("%.2f", bmi));
            lblBMI.setForeground(new Color(255, 255, 255));
            lblBMI.setFont(new Font("Lahore Gurmukhi", Font.PLAIN, 25));
            lblBMI.setBounds(75, 53, 86, 29);
            contentPanel.add(lblBMI);

            JLabel lblNewLabel_2 = new JLabel("BMI");
            lblNewLabel_2.setFont(new Font("Noto Sans Kannada", Font.BOLD, 25));
            lblNewLabel_2.setBounds(80, 18, 55, 29);
            contentPanel.add(lblNewLabel_2);

            JLabel lblNewLabel_2 = new JLabel("BMR");
            lblNewLabel_2.setFont(new Font("Noto Sans Kannada", Font.BOLD, 25));
            lblNewLabel_2.setBounds(358, 18, 61, 29);
            contentPanel.add(lblNewLabel_2);

            // JLabel for displaying the background image
            JLabel lblNewLabel = new JLabel(new ImageIcon(Imgbar));
            lblNewLabel.setBackground(new Color(255, 127, 80));
            lblNewLabel.setBounds(0, 0, 450, 194);
            contentPanel.add(lblNewLabel);
        }

        // JPanel for the OK button
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(255, 255, 255));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            // OK button to close the dialog
            JButton cancelButton = new JButton("OK");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }
    }
}
