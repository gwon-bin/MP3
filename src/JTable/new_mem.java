package JTable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class new_mem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new_mem frame = new new_mem();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public new_mem() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 200, 360, 296);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("사용할 ID");
		lblNewLabel.setBounds(42, 35, 104, 27);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("사용할 PW");
		label.setBounds(42, 81, 104, 27);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(177, 38, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 84, 116, 21);
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("PW 확인");
		label_1.setBounds(42, 107, 104, 27);
		contentPane.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 115, 116, 21);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.setBounds(78, 165, 175, 46);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
}
