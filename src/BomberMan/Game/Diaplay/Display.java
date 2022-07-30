package BomberMan.Game.Diaplay;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private String title;
	// in 2 ta chon tavasot class haye dige mostaghim seda zde mishn static hstn
	public static JLabel lblOutPutTime;
	public static JLabel lblOutPutHealth;

	// in motaghyr ha be vasileye Game meqdr dahi mishn
	private int width, height;
	private int tddEnemy, w, tddBomb;
	private long Time;
	private String Name;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay() {

		frame = new JFrame(title);
		frame.setSize(width, height + 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout(0));
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(width, 50));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHealth = new JLabel("Health");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHealth.setForeground(Color.WHITE);
		lblHealth.setBounds(12, 13, 77, 24);
		panel.add(lblHealth);

		lblOutPutHealth = new JLabel("100");
		lblOutPutHealth.setForeground(Color.WHITE);
		lblOutPutHealth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutPutHealth.setBounds(86, 13, 39, 24);

		panel.add(lblOutPutHealth);

		JButton btnNewButton = new JButton("back");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(width - 85, 14, 65, 30);
		btnNewButton.setFocusable(false);
		panel.add(btnNewButton);
		frame.add(panel);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setForeground(new Color(255, 182, 193));
		lblTime.setBounds(149, 13, 56, 21);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblTime);

		lblOutPutTime = new JLabel("0");
		lblOutPutTime.setForeground(Color.WHITE);
		lblOutPutTime.setBounds(212, 18, 46, 16);
		lblOutPutTime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblOutPutTime);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		frame.add(canvas);
	}

	public void YouWin() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 222, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 475, 216);
		panel_1.setBackground(new Color(136, 0, 21));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblYouWin = new JLabel("YOU WIN");
		lblYouWin.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 18));
		lblYouWin.setBounds(12, 47, 171, 37);
		lblYouWin.setForeground(Color.white);
		panel_1.add(lblYouWin);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Profile.Information.add(String.valueOf(Profile.FinalScore(w, tddEnemy, Time, tddBomb)));
				Profile.NevshtnTXT(Profile.Information);
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(12, 108, 97, 25);
		btnSave.setFocusable(false);
		panel_1.add(btnSave);

	}

	public void YouLose() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 222, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 475, 216);
		panel_1.setBackground(new Color(136, 0, 21));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblYouLose = new JLabel("YOU LOSE");
		lblYouLose.setForeground(Color.WHITE);
		lblYouLose.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 18));
		lblYouLose.setBounds(12, 47, 171, 37);
		panel_1.add(lblYouLose);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile.Information.add(String.valueOf(Profile.FinalScore(w, tddEnemy, Time, tddBomb)));
				Profile.NevshtnTXT(Profile.Information);
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(12, 108, 97, 25);
		btnSave.setFocusable(false);
		panel_1.add(btnSave);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

	public int getTddEnemy() {
		return tddEnemy;
	}

	public void setTddEnemy(int tddEnemy) {
		this.tddEnemy = tddEnemy;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getTddBomb() {
		return tddBomb;
	}

	public void setTddBomb(int tddBomb) {
		this.tddBomb = tddBomb;
	}

	public long getTime() {
		return Time;
	}

	public void setTime(long time) {
		Time = time;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
