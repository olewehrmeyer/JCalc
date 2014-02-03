package me.Belogron.jCalc;

import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

public class JCalc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6881305414907714466L;
	private JPanel contentPane;
	private JTextArea inputArea;
	private JLabel lblResult;
	private JSjit jit = new JSjit();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		setTitle("JCalc");		
		inputArea = new JTextArea();
		inputArea.setBounds(12, 12, 426, 180);
		contentPane.add(inputArea);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculateResult();
			}

		});
		btnCalculate.setBounds(321, 204, 117, 25);
		contentPane.add(btnCalculate);
		
		lblResult = new JLabel("<html><body>Type your mathmatical expression into the textfield above and press calculate. The answer will appear here. You can reuse the last result as it is saved in the 'ans' variable.</body></html>");
		lblResult.setVerticalAlignment(SwingConstants.TOP);
		lblResult.setBounds(12, 241, 426, 75);
		contentPane.add(lblResult);
	}

	protected void calculateResult() {
		try {
			String input = expandShortForms(inputArea.getText());
			Object result = jit.calculate(input);
			lblResult.setText(result.toString());
		} catch (ScriptException e) {
			JOptionPane.showMessageDialog(this, "An error occured evaluating your input\n"+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	private String expandShortForms(String text) {
		//TODO: regex magic
		return text;
	}
}
