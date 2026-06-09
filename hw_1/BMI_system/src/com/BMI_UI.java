package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;

public class BMI_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel outPanel;
	private JTextField nameField;
	private JTextField heightField;
	private JTextField weightField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    try {

	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName()
	        );

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_UI frame = new BMI_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param printNewButton 
	 * @param printButton 
	 */
	public BMI_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//x, y, width, height
		setBounds(100, 100, 600, 400);
		outPanel = new JPanel();
		outPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(outPanel);
		outPanel.setLayout(null);
		
		JLabel title = new JLabel("BMI計算系統");
		title.setFont(new Font("新細明體", Font.BOLD, 24));
		title.setBounds(210, 0, 158, 75);
		outPanel.add(title);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(20, 75, 550, 130);
		outPanel.add(panel);
		panel.setLayout(null);
		
		JLabel NameLabel = new JLabel("姓名：");
		NameLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		NameLabel.setBounds(10, 10, 50, 30);
		panel.add(NameLabel);
		
		String[] genderList = {"男","女"};
		JComboBox<String> genderbox = new JComboBox<>(genderList);
		genderbox.setFont(new Font("新細明體", Font.BOLD, 12));
		genderbox.setBounds(176, 14, 50, 25);
		panel.add(genderbox);
		
		JLabel HeightLabel;
		HeightLabel = new JLabel("身高：");
		HeightLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		HeightLabel.setBounds(10, 50, 50, 30);
		panel.add(HeightLabel);
		
		JLabel WeightLabel;
		WeightLabel = new JLabel("體重：");
		WeightLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		WeightLabel.setBounds(10, 90, 50, 30);
		panel.add(WeightLabel);
		
		nameField = new JTextField();
		nameField.setBounds(70, 15, 96, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		heightField = new JTextField();
		heightField.setBounds(70, 55, 96, 20);
		panel.add(heightField);
		heightField.setColumns(10);
		
		weightField = new JTextField();
		weightField.setBounds(70, 95, 96, 20);
		panel.add(weightField);
		weightField.setColumns(10);
		
		JLabel cmLabel = new JLabel("公分");
		cmLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		cmLabel.setBounds(176, 50, 50, 30);
		panel.add(cmLabel);
		
		JLabel kgLabel = new JLabel("公斤");
		kgLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		kgLabel.setBounds(176, 90, 50, 30);
		panel.add(kgLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 215, 550, 130);
		outPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea out = new JTextArea("");
		out.setFont(new Font("新細明體", Font.PLAIN, 16));
		out.setBounds(10, 10, 345, 110);
		panel_1.add(out);
		

		
		//固定視窗大小
		setResizable(false);
		
		/****************************event*****************************/	
		//計算
		JButton okButton = new JButton("計算");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BMI_controller controller = new BMI_controller();
				String name = nameField.getText();
				String gender = (String) genderbox.getSelectedItem();
				double height = Double.parseDouble(heightField.getText());
				double weight = Double.parseDouble(weightField.getText());
				double bmi = controller.calcBMI(height, weight);
				DecimalFormat df = new DecimalFormat("0.00");
				String bmiText = df.format(bmi);
				String result = controller.getResult(bmi);
				String today = LocalDate.now().toString();
				
				out.setText(
					    "姓名：" + name + "\t性別：" + gender +
					    "\n身高：" + height + "\t體重：" + weight +
					    "\nBMI：" + bmiText + "\t結果：" + result +
					    "\n-------------------------------------" +
					    "\n建立時間：" + today
				);
			}
		});
		okButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		okButton.setBounds(456, 94, 84, 22);
		panel.add(okButton);
		
		//清除
		JButton clearButton = new JButton("清除");
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				heightField.setText("");
				weightField.setText("");
				out.setText("");
			}
		});
		clearButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		clearButton.setBounds(362, 94, 84, 22);
		panel.add(clearButton);
		
		//列印
		JButton ppButton = new JButton("列印");
		ppButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					out.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ppButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		ppButton.setBounds(365, 98, 84, 22);
		panel_1.add(ppButton);
		
		//離開
		JButton exitButton = new JButton("離開");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		exitButton.setBounds(456, 98, 84, 22);
		panel_1.add(exitButton);
		
		//時間
		JLabel time = new JLabel("");
		time.setFont(new Font("新細明體", Font.BOLD, 14));
		time.setBounds(366, 55, 200, 20);
		outPanel.add(time);
		
		DateTimeFormatter now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Timer timer = new Timer(1000, e ->time.setText("系統時間: " + LocalDateTime.now().format(now)));
		timer.start();
		
	}
}