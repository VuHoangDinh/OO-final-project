package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loan extends JFrame {

	private JPanel contentPane;
	private JTextField jtextEnter;
	private JTextField jtextnumberofyears;
	private JTextField jtextEnterloanamount;
	private JTextField jtextmonthlyPayment;
	private JTextField jtexttotalPayment;
	private JTextField jtxtReceipt;

	private JButton btnExit ;
	private JButton btnReset ;
	private JButton btnLoan ;
	private JButton btnReceipt ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan frame = new Loan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(24, 60, 529, 534);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Interest rate");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(10, 11, 200, 44);
		panel.add(label);
		
		jtextEnter = new JTextField();
		jtextEnter.setColumns(10);
		jtextEnter.setBounds(235, 25, 86, 28);
		panel.add(jtextEnter);
		
		JLabel label_1 = new JLabel("Number of years");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_1.setBounds(10, 68, 213, 44);
		panel.add(label_1);
		
		jtextnumberofyears = new JTextField();
		jtextnumberofyears.setColumns(10);
		jtextnumberofyears.setBounds(235, 82, 86, 28);
		panel.add(jtextnumberofyears);
		
		JLabel label_2 = new JLabel("Amount of loan");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBounds(10, 123, 200, 44);
		panel.add(label_2);
		
		jtextEnterloanamount = new JTextField();
		jtextEnterloanamount.setColumns(10);
		jtextEnterloanamount.setBounds(235, 137, 86, 28);
		panel.add(jtextEnterloanamount);
		
		JLabel label_3 = new JLabel("Monthly payment");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBounds(10, 178, 225, 44);
		panel.add(label_3);
		
		jtextmonthlyPayment = new JTextField();
		jtextmonthlyPayment.setColumns(10);
		jtextmonthlyPayment.setBounds(235, 192, 86, 28);
		panel.add(jtextmonthlyPayment);
		
		JLabel lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotalPayment.setBounds(10, 233, 200, 44);
		panel.add(lblTotalPayment);
		
		jtexttotalPayment = new JTextField();
		jtexttotalPayment.setColumns(10);
		jtexttotalPayment.setBounds(235, 247, 86, 28);
		panel.add(jtexttotalPayment);
		
		JButton btnloan = new JButton("Loan");
		btnloan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double anualInterestRate = Double.parseDouble(jtextEnter.getText());
				double monthlyInterestRate = anualInterestRate/1200;
				int numberOfYears = Integer.parseInt(jtextnumberofyears.getText());
				double loanAmount = Double.parseDouble(jtextEnterloanamount.getText());
				
				double monthyPayment = loanAmount * monthlyInterestRate/(1-1/Math.pow(1+monthlyInterestRate, numberOfYears)*12);
				String imonthlyPayment;
				imonthlyPayment = Double.toString(monthyPayment);
				imonthlyPayment = String.format("€%.2f",monthyPayment);
				jtextmonthlyPayment.setText(imonthlyPayment);
				
				double totalPayment = monthyPayment * numberOfYears * 12;
				String itotalPayment;
				itotalPayment = String.format("€%.2f",totalPayment );
				jtexttotalPayment.setText(itotalPayment);
			}
		});
		btnloan.setForeground(Color.BLUE);
		btnloan.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnloan.setBounds(345, 11, 163, 44);
		panel.add(btnloan);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			private JTextArea jtextReceipt;

			public void actionPerformed(ActionEvent e) {
				String anualInterestRate = String.format(jtextEnter.getText());
				String numberOfYears = String.format(jtextnumberofyears.getText());
				String loanAmount = String.format(jtextEnterloanamount.getText());
				String monthlyPayment = String.format(jtextmonthlyPayment.getText());
				String totalPayment = String.format(jtexttotalPayment.getText());
				
				int refs = 1325 + (int) (Math.random()*4238);
				
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
				Tdate.format(timer.getTime());
			
				jtextReceipt.setText("\tLoan Management Systems\n"
						+ "\n========================\t"
						+ "\nInterest rate:\t\t\t" + anualInterestRate
						+ "\nRepayment years" + numberOfYears
						+ "\nAmount of Loan" + loanAmount
						+ "\nMonthly payment" + monthlyPayment
						+ "\nTotal payment" + totalPayment
						+ "\n========================\t"+
						"\nDate" + Tdate.format(timer.getTime()) +
						"\t\tTime" + tTime.format(timer.getTime()));
				
				
			}
		});
		btnReceipt.setForeground(Color.BLUE);
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnReceipt.setBounds(345, 85, 163, 44);
		panel.add(btnReceipt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtextEnter.setText(null);
				jtextnumberofyears.setText(null);
				jtextEnterloanamount.setText(null);
				jtextmonthlyPayment.setText(null);
				jtexttotalPayment.setText(null);
				jtxtReceipt.setText(null);
			}
		});
		btnReset.setForeground(Color.BLUE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnReset.setBounds(345, 157, 163, 44);
		panel.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setBounds(345, 233, 163, 44);
		panel.add(btnExit);
		
		JTextArea jtextReceipt = new JTextArea();
		jtextReceipt.setBounds(20, 288, 483, 235);
		panel.add(jtextReceipt);
		
		JLabel lblLoan = new JLabel("Loan ");
		lblLoan.setForeground(new Color(255, 153, 51));
		lblLoan.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblLoan.setBounds(248, 11, 95, 38);
		contentPane.add(lblLoan);
	}
}
