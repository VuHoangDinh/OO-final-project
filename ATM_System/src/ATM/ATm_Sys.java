package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import ATM.Account;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class ATm_Sys {

	JFrame frame;
	private JTextField jlblDisplay;
	
	private Account myAccount;

	
	
	private JButton jbtnPayment;
	private JButton jbtnTransaction ;
	private JButton jbtnWithdrawal ;
	private JButton jbtnDeposit ;
	private JButton jbtnLoan;
	private JButton jbtnBalance;
	private JButton jbtn1,jbtn2,jbtn3,jbtn4,jbtn5,jbtn6,jbtn7,jbtn8,jbtn9,jbtn0 ;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATm_Sys window = new ATm_Sys();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATm_Sys() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Account myAccount = new Account();
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 827);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 162, 111, 227);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	/**
	 * Buttons functions (1)
	 */	
		JButton jbtnPayment = new JButton(">");
		jbtnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean action1 = true;
				while (action1) {
					String nAccount = JOptionPane.showInputDialog("Name of recipent/account number: ");
					
					if ( nAccount != null && nAccount.isEmpty()  ) {
						JOptionPane.showMessageDialog(null, "Please try again!");		
					}  
						 else {
							boolean action2 = true;
							while (action2) {
							String nMessage = JOptionPane.showInputDialog("Message: ");
							String inputPayment = JOptionPane.showInputDialog("Amount:");
							double amount = 0;
							if (inputPayment == null) {
								JOptionPane.showMessageDialog(null, "Action ended.");
								action1 = false;
								action2 = false;
							} else {
								try {
									amount = Double.parseDouble(inputPayment);
									double balance = myAccount.getBalance();
									if (amount < 0 || amount > balance) {
										JOptionPane.showMessageDialog(null, "Invalid amount.");
										action2 = true;
									} else {
										myAccount.withdraw(amount);
										double nbalance = myAccount.getBalance();
										String s = new String();
										s = "Account balance: " + String.valueOf(nbalance) +"€";
										jlblDisplay.setText(s);
										action1 = false;
										action2 = false;
									}				
								}
								catch (NumberFormatException c) {
									JOptionPane.showMessageDialog(null, "Please enter a number.");
								}
							}
						}
						}
					}
				
			}
			
		});
		jbtnPayment.setEnabled(false);
		jbtnPayment.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnPayment.setBounds(10, 83, 97, 61);
		panel.add(jbtnPayment);
		
		JButton jbtnWithdrawal = new JButton(">");
		jbtnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean action1 = true;
				while (action1) {
					String inputWithdraw = JOptionPane.showInputDialog(null, "Amount: ");
					double amount = 0;
					if (inputWithdraw == null) {
						JOptionPane.showMessageDialog(null, "Action ended");
						action1 = false;
						} else {
							try {
								amount = Double.parseDouble(inputWithdraw);
								double balance = myAccount.getBalance();
								if (amount < 0 || amount > balance) 
								{
									JOptionPane.showMessageDialog(null, "Invalid amount.");
									action1 = true;
								} else 
									{
									myAccount.withdraw(amount);
									double nbalance = myAccount.getBalance();
									String s = new String();
									s = "Account balance: " + String.valueOf(nbalance) + "€";
									jlblDisplay.setText(s);
									action1 = false;
									}
								}
							catch (NumberFormatException c) {
								JOptionPane.showMessageDialog(null, "Please enter an amount.");
								}
				}
				}
			}
		});
		jbtnWithdrawal.setEnabled(false);
		jbtnWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnWithdrawal.setBounds(10, 155, 97, 61);
		panel.add(jbtnWithdrawal);
		
		JButton jbtnBalance = new JButton(">");
		jbtnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlblDisplay.setText("Account balance: " + myAccount.getBalance()+"€");
				
			}
		});
		
		jbtnBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnBalance.setEnabled(false);
		jbtnBalance.setBounds(10, 11, 97, 61);
		panel.add(jbtnBalance);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(131, 109, 297, 280);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jlblPayment = new JLabel("Payment");
		jlblPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblPayment.setBounds(10, 155, 73, 31);
		panel_1.add(jlblPayment);
		
		JLabel jlblTransaction = new JLabel("Lastest Trannsaction");
		jlblTransaction.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblTransaction.setBounds(131, 226, 156, 31);
		panel_1.add(jlblTransaction);
		
		JLabel jlblWithdrawal = new JLabel("Withdrawal");
		jlblWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblWithdrawal.setBounds(10, 226, 87, 31);
		panel_1.add(jlblWithdrawal);
		
		JLabel jlblDeposit = new JLabel("Deposit");
		jlblDeposit.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblDeposit.setBounds(214, 155, 73, 31);
		panel_1.add(jlblDeposit);
		
		JLabel jlblBalance = new JLabel("Balance");
		jlblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblBalance.setBounds(10, 82, 73, 31);
		panel_1.add(jlblBalance);
		
		JLabel jlblLoan = new JLabel("Loan");
		jlblLoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlblLoan.setBounds(214, 82, 73, 31);
		panel_1.add(jlblLoan);
		
		jlblDisplay = new JTextField();
		jlblDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlblDisplay.setBounds(10, 21, 277, 34);
		panel_1.add(jlblDisplay);
		jlblDisplay.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(438, 163, 111, 226);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		/**
		 * Buttons functions (2)
		 */		
		JButton jbtnTransaction = new JButton("<");
		jbtnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jbtnTransaction.setEnabled(false);
		jbtnTransaction.setFont(new Font("Tahoma", Font.BOLD, 29));
		jbtnTransaction.setBounds(10, 154, 97, 61);
		panel_2.add(jbtnTransaction);
		
		JButton jbtnDeposit = new JButton("<");
		jbtnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean action2 = true;
				while (action2) {
					String inputDeposit = JOptionPane.showInputDialog(null, "Amount: ");
					double amount = 0;
					if (inputDeposit == null) {
						JOptionPane.showMessageDialog(null, "Action ended");
						action2 = false;
						} else {
							try {
									amount = Double.parseDouble(inputDeposit);
									double balance = myAccount.getBalance(); 
									myAccount.deposit(amount);
									double nbalance = myAccount.getBalance();
									String s = new String();
									s = "Account balance: " + String.valueOf(nbalance) + "€";
									jlblDisplay.setText(s);
									action2 = false;
								}
							catch (NumberFormatException c) {
								JOptionPane.showMessageDialog(null, "Please enter an amount.");
								}
				}
				}
			}
		});
		jbtnDeposit.setBounds(10, 82, 97, 61);
		panel_2.add(jbtnDeposit);
		jbtnDeposit.setEnabled(false);
		jbtnDeposit.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton jbtnLoan = new JButton("<");
		jbtnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan l = new Loan();
				l.setVisible(true);
				frame.dispose();
			}
		});
		jbtnLoan.setFont(new Font("Tahoma", Font.BOLD, 30));
		jbtnLoan.setEnabled(false);
		jbtnLoan.setBounds(10, 11, 97, 61);
		panel_2.add(jbtnLoan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 435, 534, 321);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//number buttons
		JButton jbtn1 = new JButton("");
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "1";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn1.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/1.png")));
		jbtn1.setBounds(40, 22, 97, 61);
		panel_3.add(jbtn1);
		
		JButton jbtn2 = new JButton("");
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "2";
				jlblDisplay.setText(Enternunber);
			
			}
		});
		jbtn2.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/2.png")));
		jbtn2.setBounds(147, 22, 97, 61);
		panel_3.add(jbtn2);
		
		JButton jbtn3 = new JButton("");
		jbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "3";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn3.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/3.png")));
		jbtn3.setBounds(254, 22, 97, 61);
		panel_3.add(jbtn3);
		
		
		JButton jbtn4 = new JButton("");
		jbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "4";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn4.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/4.png")));
		jbtn4.setBounds(40, 94, 97, 61);
		panel_3.add(jbtn4);
		
		JButton jbtn5 = new JButton("");
		jbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "5";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn5.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/5.png")));
		jbtn5.setBounds(147, 94, 97, 61);
		panel_3.add(jbtn5);
		
		JButton jbtn6 = new JButton("");
		jbtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "6";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn6.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/6.png")));
		jbtn6.setBounds(254, 94, 97, 61);
		panel_3.add(jbtn6);
		
		JButton jbtnClear = new JButton("");
		jbtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlblDisplay.setText("");
			}
		});
		jbtnClear.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/clear.png")));
		jbtnClear.setBounds(394, 94, 97, 61);
		panel_3.add(jbtnClear);
		
		JButton jbtn7 = new JButton("");
		jbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "7";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn7.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/7.png")));
		jbtn7.setBounds(40, 166, 97, 61);
		panel_3.add(jbtn7);
		
		JButton jbtn8 = new JButton("");
		jbtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "8";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn8.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/8.png")));
		jbtn8.setBounds(147, 166, 97, 61);
		panel_3.add(jbtn8);
		
		JButton jbtn9 = new JButton("");
		jbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "9";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn9.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/9.png")));
		jbtn9.setBounds(254, 166, 97, 61);
		panel_3.add(jbtn9);
		
		JButton jbtn0 = new JButton("");
		jbtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternunber = jlblDisplay.getText() + "0";
				jlblDisplay.setText(Enternunber);
			}
		});
		jbtn0.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/0.png")));
		jbtn0.setBounds(147, 238, 97, 61);
		panel_3.add(jbtn0);
		
		/**
		 * Buttons functions (3)
		 */
		
		JButton jbtnCancel = new JButton("");
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnCancel.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/cancel.png")));
		jbtnCancel.setBounds(394, 22, 97, 61);
		panel_3.add(jbtnCancel);
		
		JButton jbtnEnter = new JButton("");
		jbtnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pin1 = Integer.parseInt(jlblDisplay.getText());
				int pin2 = Integer.parseInt(jlblDisplay.getText());
				int pin3 = Integer.parseInt(jlblDisplay.getText());
				
				if (pin1 == 1234) {
					jbtnPayment.setEnabled(true);
					jbtnTransaction.setEnabled(true);
					jbtnWithdrawal.setEnabled(true);
					jbtnDeposit.setEnabled(true);
					jbtnLoan.setEnabled(true);;
					jbtnBalance.setEnabled(true);;
					
					jlblTransaction.setVisible(true);
					jlblPayment.setVisible(true);
					jlblWithdrawal.setVisible(true);
					jlblDeposit.setVisible(true);
					jlblLoan.setVisible(true);
					jlblBalance.setVisible(true);
					jlblDisplay.setText("");
				}
				
				else if (pin2 == 9631) {
					jbtnPayment.setEnabled(true);
					jbtnTransaction.setEnabled(true);
					jbtnWithdrawal.setEnabled(true);
					jbtnDeposit.setEnabled(true);
					jbtnLoan.setEnabled(true);;
					jbtnBalance.setEnabled(true);;
					
					jlblTransaction.setVisible(true);
					jlblPayment.setVisible(true);
					jlblWithdrawal.setVisible(true);
					jlblDeposit.setVisible(true);
					jlblLoan.setVisible(true);
					jlblBalance.setVisible(true);
					jlblDisplay.setText("");
				}
				
				else if (pin3 == 2256) {
					jbtnPayment.setEnabled(true);
					jbtnTransaction.setEnabled(true);
					jbtnWithdrawal.setEnabled(true);
					jbtnDeposit.setEnabled(true);
					jbtnLoan.setEnabled(true);;
					jbtnBalance.setEnabled(true);;
					
					jlblTransaction.setVisible(true);
					jlblPayment.setVisible(true);
					jlblWithdrawal.setVisible(true);
					jlblDeposit.setVisible(true);
					jlblLoan.setVisible(true);
					jlblBalance.setVisible(true);
					jlblDisplay.setText("");
				}
				else
				{
					jlblDisplay.setText("Invalid Pin");
				}
			}
		});
		jbtnEnter.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/enter.png")));
		jbtnEnter.setBounds(394, 166, 97, 61);
		panel_3.add(jbtnEnter);
		
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/null.png")));
		button_11.setBounds(40, 238, 97, 61);
		panel_3.add(button_11);
		
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/null.png")));
		button_13.setBounds(254, 238, 97, 61);
		panel_3.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setIcon(new ImageIcon(ATm_Sys.class.getResource("/ATM/null.png")));
		button_14.setBounds(394, 238, 97, 61);
		panel_3.add(button_14);
		
		JLabel lblOtto = new JLabel("Otto Machine");
		lblOtto.setForeground(Color.ORANGE);
		lblOtto.setFont(new Font("Verdana", Font.BOLD, 30));
		lblOtto.setBounds(170, 17, 238, 81);
		frame.getContentPane().add(lblOtto);
	}
}
