package me.Belogron.jCalc;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JCalc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6881305414907714466L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalc frame = new JCalc();
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
	public JCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 12, 426, 180);
		contentPane.add(textArea);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(321, 204, 117, 25);
		contentPane.add(btnCalculate);
		
		JLabel lblResult = new JLabel("<html><body>Type your mathmatical expression into the textfield above and press calculate. The answer will appear here. You can reuse the last result as it is saved in the 'ans' variable.</body></html>");
		lblResult.setVerticalAlignment(SwingConstants.TOP);
		lblResult.setBounds(12, 241, 426, 75);
		contentPane.add(lblResult);
	}
}
