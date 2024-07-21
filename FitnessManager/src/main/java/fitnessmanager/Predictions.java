package fitnessmanager;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Predictions extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField time100Field;
    private JTextField time200Field;
    private JTextField time400Field;
    private JTextField time5kField;


    private static final double RIEGEL_EXPONENT = 1.06;
	private JLabel pred100;
	private JLabel pred200;
	private JLabel pred400;
	private JLabel pred5k;

    /**
     * Create the dialog.
     */

    public Predictions(double time100, double time200, double time400, double time5k) {
    	getContentPane().setForeground(new Color(255, 255, 255));
        setBounds(100, 100, 299, 519);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        contentPanel.setBackground(new Color(255, 153, 51));
        contentPanel.setBounds(0, -11, 299, 465);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        JLabel lblpreds = new JLabel("Prediction for Upcoming Races\n");
        lblpreds.setFont(new Font("Lahore Gurmukhi", Font.BOLD, 17));
        lblpreds.setBounds(22, 35, 269, 52);
        contentPanel.add(lblpreds);

        JLabel lblNewLabel = new JLabel("100m -");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblNewLabel.setBounds(22, 99, 90, 30);
        contentPanel.add(lblNewLabel);

        JLabel lblm = new JLabel("200m - ");
        lblm.setForeground(new Color(255, 255, 255));
        lblm.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblm.setBounds(22, 177, 90, 30);
        contentPanel.add(lblm);

        JLabel lblm_1 = new JLabel("400m - ");
        lblm_1.setForeground(new Color(255, 255, 255));
        lblm_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblm_1.setBounds(22, 259, 90, 30);
        contentPanel.add(lblm_1);

        JLabel lblk = new JLabel("5K - ");
        lblk.setForeground(new Color(255, 255, 255));
        lblk.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblk.setBounds(22, 348, 90, 30);
        contentPanel.add(lblk);

        pred100 = new JLabel("New label");
        pred100.setFont(new Font("Copperplate", Font.PLAIN, 25));
        pred100.setBounds(84, 124, 190, 52);
        contentPanel.add(pred100);

        pred200 = new JLabel("New label");
        pred200.setFont(new Font("Copperplate", Font.PLAIN, 25));
        pred200.setBounds(84, 207, 190, 52);
        contentPanel.add(pred200);

        pred400 = new JLabel("New label");
        pred400.setFont(new Font("Copperplate", Font.PLAIN, 25));
        pred400.setBounds(84, 288, 190, 52);
        contentPanel.add(pred400);

        pred5k = new JLabel("New label");
        pred5k.setFont(new Font("Copperplate", Font.PLAIN, 25));
        pred5k.setBounds(84, 379, 190, 52);
        contentPanel.add(pred5k);
        
        JButton btnNewButton = new JButton("EXIT");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton.setBounds(182, 460, 117, 29);
        getContentPane().add(btnNewButton);
        
        calculatePredictions(time100,time200,time400,time5k);
    }

    private void calculatePredictions(double time100, double time200, double time400, double time5k) {

        double predicted100 = time100 * Math.pow(199.0/200.0, RIEGEL_EXPONENT);
        double predicted200 = time200 * Math.pow(197.0/200.0, RIEGEL_EXPONENT);
        double predicted400 = time400 * Math.pow(196.0/200.0, RIEGEL_EXPONENT);
        double predicted5k = time5k * Math.pow(194.0/200.0, RIEGEL_EXPONENT);


        pred100.setText(convertToHHMMSS(predicted100));
        pred200.setText(convertToHHMMSS(predicted200));
        pred400.setText(convertToHHMMSS(predicted400));
        pred5k.setText(convertToHHMMSS(predicted5k));
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

            return (hours * 3600) + (minutes * 60) + seconds + (milliseconds / 1000);
        } catch (NumberFormatException | ParseException e) {

            e.printStackTrace();
            return 0.0; 
        }
    }

    private String convertToHHMMSS(double seconds) {
        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int sec = (int) (seconds % 60);
        double milliseconds = (seconds - Math.floor(seconds)) * 1000;
        return String.format("%02d:%02d:%02d.%03.0f", hours, minutes, sec, milliseconds);
    }
}
