package BomberMan.Game.Diaplay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BomberMan.Game.Game;

public class Profile {

	private JFrame frame;
	private JTextField txtEnterPassword;

	public static ArrayList<String> NamesVaPassword = new ArrayList<String>();
	public static String SignUpNameVaPassWord, SignInNameVaPassword;
	private Image imageIcon;
	private String PhotoPath = null;
	public static  ArrayList<String> Information = new ArrayList<>();
	private JTextField txtWidth;
	private JTextField txtHeight;
	private static double FinalScore;
	// age btn addPIc zde beshe true mishe
	private boolean booleanAddPic = false;
	// age btn name zd true mishe
	private boolean ChangeName = false;
	// age btn password ro zd true mishe
	private boolean ChangePassword = false;

	private String temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Profile() {
		KhondnTxt_NamesVaPassword();
		 one();
//		SignUp();
		// ChangeInformation();
		// GetInformation();
		// Two();
		// GetInformation();
//		 SignIn(Information);
	}

	// ******************************
	// &&&&&&&&&&&&&&&&&&&&& One
	// ******************************
	private void one() {

		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JButton btnStartGame_1 = new JButton("Start Game");
		btnStartGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Two();
			}
		});
		btnStartGame_1.setFocusable(false);
		btnStartGame_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStartGame_1.setForeground(Color.WHITE);
		btnStartGame_1.setBackground(Color.DARK_GRAY);
		btnStartGame_1.setBounds(53, 122, 97, 25);
		frame.getContentPane().add(btnStartGame_1);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Old English Text MT", Font.BOLD | Font.ITALIC, 17));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(12, 42, 191, 25);
		frame.getContentPane().add(lblWelcome);
		frame.setResizable(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(600, 200, 221, 214);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// *********************************
	// &&&&&&&&&& Two
	// *********************************
	public void Two() {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JTextField txtEnterTheName = new JTextField();
		txtEnterTheName.setText("Enter the Name");
		txtEnterTheName.setForeground(Color.WHITE);
		txtEnterTheName.setBackground(Color.DARK_GRAY);
		txtEnterTheName.setBounds(12, 46, 116, 22);
		frame.getContentPane().add(txtEnterTheName);
		txtEnterTheName.setColumns(10);
		txtEnterTheName.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtEnterTheName.setText("");
			}
		});
		txtEnterTheName.setVisible(false);

		JLabel lblError = new JLabel("Error");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setForeground(Color.RED);
		lblError.setBounds(12, 105, 186, 22);
		lblError.setVisible(false);
		frame.getContentPane().add(lblError);

		JButton btnEnterSignUp = new JButton("Enter");
		btnEnterSignUp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEnterSignUp.setForeground(Color.WHITE);
		btnEnterSignUp.setBackground(Color.DARK_GRAY);
		btnEnterSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread x = new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							if (!(TheNameIsNotDuplicate(
									txtEnterTheName.getText() + " " + txtEnterPassword.getText()))) {
								frame.dispose();
								NamesVaPassword.add(txtEnterTheName.getText() + " " + txtEnterPassword.getText());
								SignUpNameVaPassWord = txtEnterTheName.getText() + " " + txtEnterPassword.getText();
								Txt_NamesPorKon();
								SignUp();
								break;
							} else {
								lblError.setText("Error");
								lblError.setVisible(true);
							}
						}
					}
				});
				x.start();

			}
		});
		btnEnterSignUp.setVisible(false);
		btnEnterSignUp.setFocusable(false);
		btnEnterSignUp.setBounds(145, 69, 60, 25);
		frame.getContentPane().add(btnEnterSignUp);

		JButton btnEnterSignIn = new JButton("Enter");
		btnEnterSignIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEnterSignIn.setForeground(Color.WHITE);
		btnEnterSignIn.setBackground(Color.DARK_GRAY);
		btnEnterSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread x = new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							if (TheNameIsNotDuplicate(txtEnterTheName.getText() + " " + txtEnterPassword.getText())) {
								frame.dispose();
								NamesVaPassword.add(txtEnterTheName.getText() + " " + txtEnterPassword.getText());
								SignInNameVaPassword = txtEnterTheName.getText() + " " + txtEnterPassword.getText();
								ArrayList<String> Information = KhondnTxt(SignInNameVaPassword);

								SignIn(Information);
								break;
							} else {
								lblError.setText("Error");
								lblError.setVisible(true);
							}
						}
					}
				});
				x.start();

			}
		});
		btnEnterSignIn.setVisible(false);
		btnEnterSignIn.setFocusable(false);
		btnEnterSignIn.setBounds(145, 69, 60, 25);
		frame.getContentPane().add(btnEnterSignIn);
		frame.setBounds(300, 200, 216, 175);
		JButton btnSignIn = new JButton("Sign in");

		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.DARK_GRAY);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEnterTheName.setVisible(true);
				btnEnterSignUp.setVisible(true);
				txtEnterPassword.setVisible(true);
				btnSignUp.setVisible(false);
				btnSignIn.setVisible(false);
				btnEnterSignIn.setVisible(false);
			}
		});
		btnSignUp.setFocusable(false);
		btnSignUp.setBounds(12, 13, 80, 25);
		frame.getContentPane().add(btnSignUp);

		btnSignIn.setBackground(Color.DARK_GRAY);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEnterTheName.setVisible(true);
				txtEnterPassword.setVisible(true);
				btnEnterSignIn.setVisible(true);
				btnEnterSignUp.setVisible(false);
				btnSignUp.setVisible(false);
				btnSignIn.setVisible(false);
			}
		});
		btnSignIn.setFocusable(false);
		btnSignIn.setBounds(118, 13, 80, 25);
		frame.getContentPane().add(btnSignIn);

		txtEnterPassword = new JTextField();
		txtEnterPassword.setText("Enter the Password");
		txtEnterPassword.setForeground(Color.WHITE);
		txtEnterPassword.setBackground(Color.DARK_GRAY);
		txtEnterPassword.setBounds(12, 70, 116, 22);
		txtEnterPassword.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtEnterPassword.setText("");
			}
		});
		txtEnterPassword.setVisible(false);
		frame.getContentPane().add(txtEnterPassword);
		txtEnterPassword.setColumns(10);

		frame.setVisible(true);
	}

	// *****************************
	// &&&&&&&&&&&&&&&& SignUp
	// *****************************
	private void SignUp() {
		// inja shart khoroj kame krdn moshakasat hst
		boolean aksVardKrd = false;
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JLabel lblName_1 = new JLabel("Name   :");
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setBounds(12, 104, 72, 22);
		frame.getContentPane().add(lblName_1);

		// miyaym esm va password ro joda mikonim
		System.out.println(SignUpNameVaPassWord);
		String[] NP = SignUpNameVaPassWord.split(" ");
		JLabel lblPutTheName = new JLabel(NP[0]);
		lblPutTheName.setForeground(Color.WHITE);
		lblPutTheName.setBounds(94, 107, 127, 16);
		frame.getContentPane().add(lblPutTheName);

		JLabel lblPassword_1 = new JLabel("Password :");
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setBounds(12, 128, 72, 16);
		frame.getContentPane().add(lblPassword_1);

		JLabel lblPutthepassword = new JLabel(NP[1]);
		lblPutthepassword.setForeground(Color.WHITE);
		lblPutthepassword.setBounds(104, 128, 127, 16);
		frame.getContentPane().add(lblPutthepassword);
		// aks ro in ghrar migire
		JLabel lblLblphoto_1 = new JLabel("image");
		lblLblphoto_1.setForeground(Color.WHITE);
		lblLblphoto_1.setBackground(Color.DARK_GRAY);
		lblLblphoto_1.setBounds(12, 13, 100, 84);
		lblLblphoto_1.setOpaque(true);
		frame.getContentPane().add(lblLblphoto_1);

		// aks ro az photo Path mikhonim
		if (booleanAddPic) {
			try {
				File file = new File(PhotoPath);

				Image image = ImageIO.read(file);
				Image image1 = image.getScaledInstance(100, 84, image.SCALE_DEFAULT);
				imageIcon = image1;
				// inja aks ro be lblphoto ezfe mikonim
				lblLblphoto_1.setIcon(new ImageIcon(imageIcon));
			} catch (Exception e) {
			}

		}

		JButton btnChangePhoto = new JButton("Add pic");
		btnChangePhoto.setForeground(Color.WHITE);
		btnChangePhoto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChangePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aksVardKrd=true;
				JFileChooser chooser = new JFileChooser();
				int flg = chooser.showOpenDialog(null);
				if (flg == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					PhotoPath = file.getPath();
					try {
						Image image = ImageIO.read(file);
						Image image1 = image.getScaledInstance(100, 84, image.SCALE_DEFAULT);
						booleanAddPic = true;
						imageIcon = image1;
						// inja aks ro be lblphoto ezfe mikonim
						lblLblphoto_1.setIcon(new ImageIcon(imageIcon));

					} catch (IOException e1) {
					}

				}
			}

		});
		btnChangePhoto.setFocusable(false);
		btnChangePhoto.setBackground(Color.DARK_GRAY);
		btnChangePhoto.setBounds(153, 44, 68, 25);

		frame.getContentPane().add(btnChangePhoto);

		JButton btnOffline = new JButton("Offline");
		btnOffline.setForeground(Color.WHITE);
		btnOffline.setBackground(Color.DARK_GRAY);
		btnOffline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (booleanAddPic) {
					frame.dispose();
					for (int j = 0; j < Information.size(); j++) {
						Information.remove(j);
					}
					Information.add(SignUpNameVaPassWord);
					Information.add(PhotoPath);
					GetInformation();
				}
			}
		});
		btnOffline.setFocusable(false);
		btnOffline.setBounds(12, 179, 81, 25);
		frame.getContentPane().add(btnOffline);

		JButton btnOnline = new JButton("Online");
		btnOnline.setForeground(Color.WHITE);
		btnOnline.setBackground(Color.DARK_GRAY);
		btnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOnline.setFocusable(false);
		btnOnline.setBounds(136, 179, 72, 25);
		frame.getContentPane().add(btnOnline);
		// inja etelaat ro be sort arrayList dr miyarim

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ArrayList<String> Information = new ArrayList<>();
				Information.add(SignUpNameVaPassWord);
				Information.add(PhotoPath);
				NevshtnTXT(Information);
				Two();
			}
		});
		btnBack.setBounds(153, 13, 68, 25);
		btnBack.setFocusable(false);
		frame.getContentPane().add(btnBack);

		JButton btnNewButton = new JButton("Change Information");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (booleanAddPic) {
					frame.dispose();
					ChangeInformation(NP[0], NP[1]);
				}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(81, 146, 140, 25);
		frame.getContentPane().add(btnNewButton);

		frame.setBounds(300, 200, 251, 264);

		// frame.setResizable(false);
		frame.setVisible(true);
	}

	// ***************************
	// &&&&&&&&&&&& Sign In
	// ****************************
	public void SignIn(ArrayList<String> Information) {
		// etelaat ro az txt migirim
		// ArrayList<String> Sort = InformationSort(Information);
		// esm va password ro joda mikonim
		String[] NP = Information.get(0).split(" ");
		System.out.println(Information.get(1));
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setBounds(12, 123, 86, 22);
		frame.getContentPane().add(lblName_1);

		JLabel lblPutTheName = new JLabel(NP[0]);
		lblPutTheName.setForeground(Color.WHITE);
		lblPutTheName.setBounds(99, 126, 114, 16);
		frame.getContentPane().add(lblPutTheName);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(12, 158, 68, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblPutPassword = new JLabel(NP[1]);
		lblPutPassword.setForeground(Color.WHITE);
		lblPutPassword.setBounds(92, 158, 121, 16);
		frame.getContentPane().add(lblPutPassword);
		frame.setBounds(300, 200, 334, 363);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 190, 165, 113);
		frame.getContentPane().add(scrollPane);

		JTextArea txtrHistory = new JTextArea();
		scrollPane.setViewportView(txtrHistory);
		txtrHistory.setEditable(false);
		txtrHistory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrHistory.setText("Hi");

		JButton btnSortScore = new JButton("sort Score");
		btnSortScore.setForeground(Color.WHITE);
		btnSortScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrHistory.setText("");
				ArrayList<String> sort = new ArrayList<>();
				sort=InformationSort(Information);
				for (int i = 0; i < sort.size(); i++) {
					txtrHistory.append(sort.get(i));
					txtrHistory.append("\n");
				}
			}
		});
		btnSortScore.setBounds(207, 214, 97, 25);
		btnSortScore.setFocusable(false);
		btnSortScore.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(btnSortScore);

		// aks ro in ghrar migire
		JLabel lblLblphoto_1 = new JLabel("lblPhoto");
		lblLblphoto_1.setBackground(Color.WHITE);
		lblLblphoto_1.setBounds(12, 13, 100, 84);
		lblLblphoto_1.setOpaque(true);
		// ezfe krdn aks be lbl
		File file = new File(Information.get(1));
		try {
			Image image = ImageIO.read(file);
			image = image.getScaledInstance(100, 84, image.SCALE_DEFAULT);
			lblLblphoto_1.setIcon(new ImageIcon(image));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		frame.getContentPane().add(lblLblphoto_1);

		JButton btnChangePhoto = new JButton("Add pic");
		btnChangePhoto.setForeground(Color.WHITE);
		btnChangePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int flg = chooser.showOpenDialog(null);
				if (flg == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					PhotoPath = file.getPath();
					Information.set(1, PhotoPath);
					try {
						Image image = ImageIO.read(file);
						Image image1 = image.getScaledInstance(100, 84, image.SCALE_DEFAULT);
						imageIcon = image1;
						lblLblphoto_1.setIcon(new ImageIcon(imageIcon));

					} catch (IOException e1) {
					}

				}
			}

		});
		btnChangePhoto.setFocusable(false);
		btnChangePhoto.setBackground(Color.DARK_GRAY);
		btnChangePhoto.setBounds(223, 62, 81, 25);

		frame.getContentPane().add(btnChangePhoto);

		JButton btnHistory = new JButton("History");
		btnHistory.setForeground(Color.WHITE);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrHistory.setText("");
				for (int i = 2; i < Information.size(); i++) {
					txtrHistory.append(Information.get(i));
					txtrHistory.append("\n");
				}
			}
		});
		btnHistory.setBackground(Color.DARK_GRAY);
		btnHistory.setBounds(207, 187, 97, 25);
		btnHistory.setFocusable(false);
		frame.getContentPane().add(btnHistory);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
			}
		});
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setFocusable(false);
		btnBack.setBounds(223, 24, 81, 25);
		frame.getContentPane().add(btnBack);

		JButton btnOfline = new JButton("Ofline");
		btnOfline.setBackground(Color.DARK_GRAY);
		btnOfline.setForeground(Color.WHITE);
		btnOfline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				GetInformation();
			}
		});
		btnOfline.setBounds(207, 241, 97, 25);
		frame.getContentPane().add(btnOfline);

		JButton btnChangeInformation = new JButton("change Information");
		btnChangeInformation.setBackground(Color.DARK_GRAY);
		btnChangeInformation.setForeground(Color.WHITE);
		btnChangeInformation.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnChangeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ChangeInformation(name, password);
			}
		});
		btnChangeInformation.setBounds(189, 278, 115, 25);
		frame.getContentPane().add(btnChangeInformation);

		// frame.setResizable(false);
		frame.setVisible(true);

	}

	// *************************************
	// &&&&&&&&& GetInformation
	// *************************************
	public void GetInformation() {

		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Enter width and height");
		lblWelcome.setFont(new Font("Old English Text MT", Font.BOLD | Font.ITALIC, 17));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(12, 13, 191, 25);
		frame.getContentPane().add(lblWelcome);

		txtWidth = new JTextField();
		txtWidth.setText("width");
		txtWidth.setBounds(12, 51, 116, 22);
		txtWidth.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtWidth.setText("");
			}
		});
		frame.getContentPane().add(txtWidth);
		txtWidth.setColumns(10);

		txtHeight = new JTextField();
		txtHeight.setText("height");
		txtHeight.setBounds(12, 86, 116, 22);
		txtHeight.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHeight.setText("");
			}
		});
		frame.getContentPane().add(txtHeight);
		txtHeight.setColumns(10);

		JTextField txtCountOfEnemies = new JTextField();
		txtCountOfEnemies.setText("Count of enemies");
		txtCountOfEnemies.setBounds(12, 121, 116, 22);
		txtCountOfEnemies.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCountOfEnemies.setText("");
			}
		});
		frame.getContentPane().add(txtCountOfEnemies);
		txtCountOfEnemies.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.out.println("frs   "+txtWidth.getText());
				Game game = new Game("Bomber Man", Integer.parseInt(txtWidth.getText()),
						Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtCountOfEnemies.getText()) , Information.get(0));
				game.start();
			}
		});
		btnEnter.setFocusable(false);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setBackground(Color.DARK_GRAY);
		btnEnter.setBounds(130, 141, 73, 25);
		frame.getContentPane().add(btnEnter);

		frame.setResizable(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(600, 200, 221, 214);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	// ****************************************
	// &&&&&&&& Change Information
	// ****************************************

	private void ChangeInformation(String name, String password) {

		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 14));
		lblEnterName.setForeground(Color.WHITE);
		lblEnterName.setBounds(12, 40, 191, 25);
		lblEnterName.setVisible(false);
		frame.getContentPane().add(lblEnterName);

		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 16));
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setBounds(12, 40, 191, 25);
		lblEnterPassword.setVisible(false);
		frame.getContentPane().add(lblEnterPassword);
		JTextField txtName2 = new JTextField();
		txtName2.setText("Name");
		txtName2.setBounds(12, 66, 116, 22);
		txtName2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtName2.setText("");
			}
		});
		frame.getContentPane().add(txtName2);
		txtName2.setColumns(10);
		txtName2.setVisible(false);
		JTextField txtPassword2 = new JTextField();
		txtPassword2.setText("password");
		txtPassword2.setBounds(12, 89, 116, 22);
		txtPassword2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtPassword2.setText("");
			}
		});
		frame.getContentPane().add(txtPassword2);
		txtPassword2.setColumns(10);
		txtPassword2.setVisible(false);
		JButton btnPassword = new JButton("Password");

		JButton btnEnter = new JButton("Enter");

		JButton btnChangeName = new JButton("Name");
		btnChangeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeName = true;
				lblEnterName.setVisible(true);
				txtName2.setVisible(true);
				btnEnter.setVisible(true);
				btnPassword.setVisible(false);
				btnChangeName.setVisible(false);
			}
		});
		btnChangeName.setFocusable(false);
		btnChangeName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChangeName.setForeground(Color.WHITE);
		btnChangeName.setBackground(Color.DARK_GRAY);
		btnChangeName.setBounds(12, 13, 73, 25);
		frame.getContentPane().add(btnChangeName);

		JLabel lblError_1 = new JLabel("Error");
		lblError_1.setForeground(Color.RED);
		lblError_1.setBounds(12, 113, 52, 20);
		lblError_1.setVisible(false);

		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword = true;
				lblEnterPassword.setVisible(true);
				txtPassword2.setVisible(true);
				btnEnter.setVisible(true);
				btnPassword.setVisible(false);
				btnChangeName.setVisible(false);
			}
		});
		btnPassword.setFocusable(false);
		btnPassword.setBackground(Color.DARK_GRAY);
		btnPassword.setForeground(Color.WHITE);
		btnPassword.setBounds(106, 13, 97, 25);
		frame.getContentPane().add(btnPassword);

		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				if (ChangeName) {
					// temp = txtName2.getText();
					Thread x = new Thread(new Runnable() {
						@Override
						public void run() {
							while (true) {
								if (!(TheNameIsNotDuplicate(txtName2.getText() + " " + password))) {
									frame.dispose();
									NamesVaPassword.add(txtName2.getText() + " " + password);
									for (int i = 0; i < NamesVaPassword.size(); i++) {
										if (NamesVaPassword.get(i).equals(SignUpNameVaPassWord)) {
											NamesVaPassword.remove(i);
										}
									}
									SignUpNameVaPassWord = txtName2.getText() + " " + password;
									Txt_NamesPorKon();
									SignUp();
									break;
								} else {
									lblError_1.setText("Error");
									lblError_1.setVisible(true);
								}
							}
						}
					});
					x.start();
				} else {

					Thread x = new Thread(new Runnable() {
						@Override
						public void run() {
							while (true) {
								if (!(TheNameIsNotDuplicate(name + " " + txtPassword2.getText()))) {
									frame.dispose();
									NamesVaPassword.add(name + " " + txtPassword2.getText());
									for (int i = 0; i < NamesVaPassword.size(); i++) {
										if (NamesVaPassword.get(i).equals(SignUpNameVaPassWord)) {
											NamesVaPassword.remove(i);
										}
									}
									SignUpNameVaPassWord = name + " " + txtPassword2.getText();
									Txt_NamesPorKon();
									SignUp();
									break;
								} else {
									lblError_1.setText("Error");
									lblError_1.setVisible(true);
								}
							}
						}
					});
					x.start();

				}
			}
		});
		btnEnter.setFocusable(false);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setBackground(Color.DARK_GRAY);
		btnEnter.setBounds(140, 89, 73, 25);
		btnEnter.setVisible(false);
		frame.getContentPane().add(btnEnter);

		// frame
		frame.getContentPane().add(lblError_1);
		frame.setResizable(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(600, 200, 222, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	// in tabe zir tamam esm ha ro negah midre
	public void Txt_NamesPorKon() {
		try {

			File file = new File("Names.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < NamesVaPassword.size(); i++) {
				buffer.write(NamesVaPassword.get(i));
				buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// etelaat grfte shode az txt ro sort mikinim
	public ArrayList<String> InformationSort(ArrayList<String> Information) {
		ArrayList<String> Sort = new ArrayList<>();
		ArrayList<Integer> intSort = new ArrayList<>();
		// chon andis 1 va 2 betartib esm va address aks hst
	System.out.println("inf s = "+Information.size());
		for (int i = 2; i < Information.size(); i++) {
			System.out.println(Information.get(i));
			intSort.add(Integer.parseInt(Information.get(i)));
		}
		// bubble sort
		for (int i = 0; i < intSort.size() - 1; i++) {
			for (int j = 1; j < intSort.size() - i; j++) {
				if (intSort.get(j - 1) > intSort.get(j)) {
					int temp = intSort.get(j - 1);
					intSort.set(j - 1, intSort.get(j));
					intSort.set(j, temp);
				}
			}
		}
		// tbdil be String
		for (int i = 0; i < intSort.size(); i++) {
			Sort.add(String.valueOf(intSort.get(i)));
		}

		return Sort;
	}

	// in tabe miyd esm haye ke dshtim ro mikhone
	public void KhondnTxt_NamesVaPassword() {
		try {
			FileReader fr = new FileReader("Names.txt");
			BufferedReader br = new BufferedReader(fr);
			String x;
			while ((x = br.readLine()) != null) {
				NamesVaPassword.add(x);
			}

		} catch (Exception e) {
		}
	}

	// in tabe brsi mikone ke aya esm Vojod dard ya na
	private boolean TheNameIsNotDuplicate(String Name) {
		for (int i = 0; i < NamesVaPassword.size(); i++) {
			if (NamesVaPassword.get(i).equals(Name)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<String> KhondnTxt(String Name) {
		ArrayList<String> Information = new ArrayList<>();
		try {
			File file = new File(Name+".txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String x;
			while ((x = br.readLine()) != null) {
				System.out.println("XXXXX" +x);
				Information.add(x);
			}
			return Information;
		} catch (Exception e) {
		}
		return Information;
	}

	public static void Txt_PorKon() {
		try {

			File file = new File(SignInNameVaPassword + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < NamesVaPassword.size(); i++) {
				buffer.write(NamesVaPassword.get(i));
				buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void NevshtnTXT(ArrayList<String> Information) {
		try {
			String Name = Information.get(0);

			File file = new File(Name + ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < Information.size(); i++) {
				buffer.write(Information.get(i));
				buffer.newLine();
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// mohasebe emtiyaz
	public static double FinalScore(int w, int tddEnemy, long Time, int TddBomb) {
		double Log2 = (Math.log(TddBomb) / Math.log(2));
		return FinalScore = (Math.pow(tddEnemy, w) / (Time + Log2));
	}
}
