package fitnessmanager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class WorkoutPlan extends JFrame {

    private JPanel contentPane;

    // Method to launch the WorkoutPlan frame
    public static void run(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WorkoutPlan frame = new WorkoutPlan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor for the WorkoutPlan frame
    public WorkoutPlan() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1018, 705);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 165, 0));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Loading workout images
        BufferedImage legs = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg (3).png"));
        BufferedImage biceps = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg (4).png"));
        BufferedImage triceps = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg.png"));
        BufferedImage shoulders = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg (2).png"));
        BufferedImage chest = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg (1).png"));
        BufferedImage back = ImageIO.read(new File("/Users/ganesh/Downloads/pngegg (5).png"));

        // Buttons for different workout categories
        JButton btnChest = new JButton("Watch CHEST Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnChest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=MxnzcssW-tk");
            }
        });
        btnChest.setBackground(new Color(255, 165, 0));
        btnChest.setForeground(new Color(255, 165, 0));
        btnChest.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnChest.setBounds(42, 299, 274, 33);
        contentPane.add(btnChest);

        // Similar buttons for other workout categories
        JButton btnBack = new JButton("Watch BACK Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=KGwi_oSQrAY");
            }
        });
        btnBack.setForeground(new Color(255, 165, 0));
        btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnBack.setBounds(370, 299, 274, 33);
        contentPane.add(btnBack);

        JButton btnBicep = new JButton("Watch BICEP Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnBicep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=v0deQPDVFZ8");
            }
        });
        btnBicep.setForeground(new Color(255, 165, 0));
        btnBicep.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnBicep.setBounds(693, 299, 274, 33);
        contentPane.add(btnBicep);

        JButton btnTricep = new JButton("Watch TRICEP Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnTricep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=tmgfpdpQ5sk");
            }
        });
        btnTricep.setForeground(new Color(255, 165, 0));
        btnTricep.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnTricep.setBounds(370, 554, 274, 33);
        contentPane.add(btnTricep);

        JButton btnLeg = new JButton("Watch LEG Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnLeg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=-AWLDxutS08");
            }
        });
        btnLeg.setForeground(new Color(255, 165, 0));
        btnLeg.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnLeg.setBounds(42, 554, 274, 33);
        contentPane.add(btnLeg);

        JButton btnShoulder = new JButton("Watch SHOULDER Workouts");
        // Add ActionListener to open a URL when the button is clicked
        btnShoulder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUrl("https://www.youtube.com/watch?v=oq77AW1XNbc");
            }
        });
        btnShoulder.setForeground(new Color(255, 165, 0));
        btnShoulder.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnShoulder.setBounds(693, 553, 274, 33);
        contentPane.add(btnShoulder);

        // Labels for displaying workout images
        JLabel lblNewLabel_1_1_1 = new JLabel(new ImageIcon(legs));
        lblNewLabel_1_1_1.setBounds(85, 356, 200, 200);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel(new ImageIcon(biceps));
        lblNewLabel_1_1_2.setBounds(743, 102, 200, 200);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel(new ImageIcon(triceps));
        lblNewLabel_1_1_3.setBounds(413, 344, 200, 200);
        contentPane.add(lblNewLabel_1_1_3);

        JLabel lblNewLabel_1_1_4 = new JLabel(new ImageIcon(shoulders));
        lblNewLabel_1_1_4.setBounds(721, 356, 200, 200);
        contentPane.add(lblNewLabel_1_1_4);

        JLabel lblNewLabel_1 = new JLabel(new ImageIcon(chest));
        lblNewLabel_1.setBounds(71, 92, 200, 200);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon(back));
        lblNewLabel_1_1.setBounds(399, 92, 200, 200);
        contentPane.add(lblNewLabel_1_1);

        // Fitness Manager logo
        BufferedImage Img = ImageIO.read(new File("/Users/ganesh/Downloads/heartbeat.png"));
        JLabel lblNewLabel = new JLabel(new ImageIcon(Img));
        lblNewLabel.setBounds(318, 6, 94, 87);
        contentPane.add(lblNewLabel);

        // Title for the frame
        JLabel lblNewLabel_2 = new JLabel("PICK A WORKOUT");
        lblNewLabel_2.setFont(new Font("Menlo", Font.BOLD, 33));
        lblNewLabel_2.setForeground(new Color(255, 165, 0));
        lblNewLabel_2.setBounds(419, 18, 280, 60);
        contentPane.add(lblNewLabel_2);

        // Button to navigate to the Weight Calculation frame
        JButton btnWeight = new JButton("Find Your Ideal Exercise Weight!");
        btnWeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    openWpCalc();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnWeight.setForeground(Color.DARK_GRAY);
        btnWeight.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        btnWeight.setBounds(39, 607, 930, 53);
        btnWeight.setBackground(new Color(255, 204, 153)); // Light Orange color
        contentPane.add(btnWeight);

        // Button to return to the main frame
        JButton btnNewButton = new JButton("⬅");
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
        btnNewButton.setBounds(6, 6, 55, 29);
        contentPane.add(btnNewButton);
    }

    // Method to open a URL in the default web browser
    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    // Method to open the Weight Calculation frame
    private void openWpCalc() throws IOException {
        WpCalc wpCalc = new WpCalc();
        wpCalc.setVisible(true);
    }
}
