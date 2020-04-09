package Login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class graphic extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphic frame = new graphic();
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
	public graphic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String header[] = { "NO", "곡명", "가수명", "앨범명", "장르" };
		String contents[][] = { {} };
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 388, 26);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(422, 10, 73, 26);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("PW");
		label.setBounds(422, 32, 73, 26);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(500, 10, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(500, 35, 116, 21);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("추천 재생");
		btnNewButton.setBounds(433, 480, 195, 26);
		contentPane.add(btnNewButton);

		JButton button = new JButton("현재 재생");
		button.setBounds(433, 516, 195, 26);
		contentPane.add(button);

		JButton btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(422, 94, 194, 21);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("회원가입");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_mem();
			}
		});
		button_1.setBounds(422, 125, 194, 21);
		contentPane.add(button_1);

		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);

		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object act = e.getSource();
				if (act.equals(button_1)) {
					new_mem();
				}
			}
		});

		contentPane.add(button_1);

		setResizable(false);
		setVisible(true);
	}

	public void new_mem() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 259);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JLabel lblNewLabel = new JLabel("사용할 ID");
		lblNewLabel.setBounds(35, 34, 112, 25);
		contentPane1.add(lblNewLabel);

		JLabel label = new JLabel("사용할 PW");
		label.setBounds(35, 84, 112, 25);
		contentPane1.add(label);

		textField = new JTextField();
		textField.setBounds(129, 36, 116, 21);
		contentPane1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 86, 116, 21);
		contentPane1.add(textField_1);

		JLabel label_1 = new JLabel("PW 확인");
		label_1.setBounds(35, 107, 112, 25);
		contentPane1.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(129, 109, 116, 21);
		contentPane1.add(textField_2);

		btnNewButton = new JButton("가입 확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(81, 167, 130, 32);
		contentPane1.add(btnNewButton);
	}

}
