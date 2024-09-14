package View;

import Controller.DatabaseValidation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JTextField cowIDField;
    private JButton checkButton;
    private JButton stopButton;
    private JTextArea resultArea;
    private DatabaseValidation controller;

    public App() {
        controller = new DatabaseValidation();

        setTitle("ตรวจสอบข้อมูลวัว");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

        JLabel cowIDLabel = new JLabel("กรอกรหัสวัว:");
        cowIDLabel.setBounds(20, 20, 100, 25);
        cowIDLabel.setFont(thaiFont);
        add(cowIDLabel);

        cowIDField = new JTextField();
        cowIDField.setBounds(120, 20, 250, 25);
        cowIDField.setFont(thaiFont);
        add(cowIDField);

        checkButton = new JButton("ตรวจสอบ");
        checkButton.setBounds(380, 20, 120, 25);
        checkButton.setFont(thaiFont); 
        add(checkButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 60, 740, 380);
        resultArea.setEditable(false);
        resultArea.setFont(thaiFont);
        add(resultArea);

        stopButton = new JButton("หยุด");
        stopButton.setBounds(510, 20, 100, 25);
        stopButton.setFont(thaiFont);
        stopButton.setEnabled(false);
        add(stopButton);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cowID = cowIDField.getText();
                String result = controller.validateAndGetCowInfo(cowID);
                resultArea.append(result + "\n");
                stopButton.setEnabled(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
    }
}
