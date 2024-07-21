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

public class Main extends JFrame {

    private JPanel contentPane;
    private JButton btnCalc;
    private JButton btnTracker;
    private JButton btnCompete;

    // Main method to launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor for the main frame
    public Main() throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1018, 601);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title label
        JLabel Title = new JLabel("Fitness Manager");
        Title.setForeground(new Color(0, 0, 0));
        Title.setFont(new Font("Gill Sans", Font.BOLD, 24));
        Title.setBounds(86, 17, 205, 45);
        contentPane.add(Title);

        // Icon label
        BufferedImage Img = ImageIO.read(new File("/Users/ganesh/Downloads/heartbeat.png"));
        JLabel lblicon = new JLabel(new ImageIcon(Img));
        lblicon.setBounds(6, 0, 80, 81);
        contentPane.add(lblicon);

        // Buttons for different features
        btnCalc = new JButton("Biometric Calculator");
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    openBioCalc();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnCalc.setFont(new Font("Kodchasan", Font.BOLD, 20));
        btnCalc.setBounds(44, 432, 258, 70);
        contentPane.add(btnCalc);

        btnTracker = new JButton("Workout Planner");
        btnTracker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    openWorkoutPlan();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnTracker.setFont(new Font("Kodchasan", Font.BOLD, 20));
        btnTracker.setBounds(383, 432, 253, 70);
        contentPane.add(btnTracker);

        btnCompete = new JButton("Compete!");
        btnCompete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCompete();
            }
        });
        btnCompete.setFont(new Font("Kodchasan", Font.BOLD, 20));
        btnCompete.setBounds(713, 432, 253, 70);
        contentPane.add(btnCompete);

        // Images for each feature
        BufferedImage Img2 = ImageIO.read(new File("/Users/ganesh/Downloads/pngwing.com (2).png"));
        JLabel lblCalcImage = new JLabel(new ImageIcon(Img2));
        lblCalcImage.setBounds(33, 106, 276, 280);
        contentPane.add(lblCalcImage);

        BufferedImage Img3 = ImageIO.read(new File("/Users/ganesh/Downloads/report.png"));
        JLabel lblimg2 = new JLabel(new ImageIcon(Img3));
        lblimg2.setBounds(364, 140, 301, 256);
        contentPane.add(lblimg2);

        BufferedImage Img4 = ImageIO.read(new File("/Users/ganesh/Downloads/runner.png"));
        JLabel lblNewLabel = new JLabel(new ImageIcon(Img4));
        lblNewLabel.setBounds(703, 140, 281, 262);
        contentPane.add(lblNewLabel);
    }

    // Method to open the Biometric Calculator feature
    private void openBioCalc() throws IOException {
        this.setVisible(false);
        BioCalc bc = new BioCalc();
        bc.setVisible(true);
    }

    // Method to open the Workout Planner feature
    private void openWorkoutPlan() throws IOException {
        WorkoutPlan wp = new WorkoutPlan();
        this.setVisible(false);
        wp.setVisible(true);
    }

    // Method to open the Compete feature
    private void openCompete() {
        this.setVisible(false);
        openCOmpete oc = new openCOmpete();
        oc.setVisible(true);
    }
}
