package JTable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class windowbuilder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField PW;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowbuilder frame = new windowbuilder();
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
	public windowbuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String header[] = { "NO", "곡명", "가수명", "앨범명", "장르" };
		String contents[][] = { {} };
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 359, 46);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(407, 17, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("PW");
		label.setBounds(407, 42, 57, 15);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(446, 14, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(386, 67, 212, 19);
		contentPane.add(lblNewLabel_1);

		PW = new JPasswordField();
		PW.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (PW.getText().length() < 3) {
					lblNewLabel_1.setText("PW는 4글자 이상이어야합니다.");
//					pwicon1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\자물쇠_검정.png"));
				} else {
//					pwicon1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\자물쇠_초록.png"));
					lblNewLabel_1.setText("");

				}
			}
		});
		PW.setColumns(10);
		PW.setBounds(446, 39, 116, 21);
		contentPane.add(PW);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(417, 96, 166, 29);
		contentPane.add(btnNewButton);

		JButton button = new JButton("회원가입");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object act = arg0.getSource();
				if (act.equals(button)) {
					new new_mem();

				}
			}
		});
		button.setBounds(417, 132, 166, 29);
		contentPane.add(button);
		JButton btnNewButton_1 = new JButton("선택 음악 재생");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(396, 453, 212, 35);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("현재 재생 목록");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(396, 498, 212, 35);
		contentPane.add(button_1);

		JList list = new JList();
		list.setToolTipText("나중에 무언가 들어갈 곳\r\n");
		list.setBounds(393, 293, 205, 145);
		contentPane.add(list);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(393, 177, 205, 106);
		contentPane.add(btnNewButton_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(459, 10, 5, 5);
		contentPane.add(tabbedPane);

	}
}
