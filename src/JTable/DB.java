package JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class DB extends JFrame {
	String header[] = { "NO", "곡명", "가수명", "앨범명", "장르명" };
	String contents[][] = { { "1", "곡명테스트1", "가수명테스트1", "앨범명테스트1", "발라드" },
			{ "2", "곡명테스트2", "가수명테스트2", "앨범명테스트2", "락" } };
	JTabbedPane tabPane = new JTabbedPane();

	DefaultTableModel tableModel = new DefaultTableModel(contents, header);

	JTable table = new JTable(tableModel);
	JScrollPane tableScroll = new JScrollPane(table);

	JPanel tab_1 = new JPanel();
	JPanel tab_1_inputP = new JPanel();

	JTextField[] indata = new JTextField[4];

	JPopupMenu popup;
	JMenuItem m_del, m_mod;

	int modIntRow = -1;

	String fileName = "data.txt";

	DB() {
		Dimension size = new Dimension(600, 400);
		menuLayout();// 팝업메뉴
		tableSetting();
		createInputP();
		createTabbedP();

		// init(); // frame이 실행되고 모든 컴포넌트가 생성되면 초기 데이터 값을 가져오는 메서드

		this.setLocation(300, 300);
		this.setSize(size);
		this.add(tabPane);
		// this.setPreferredSize(size);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	public void menuLayout() {
		popup = new JPopupMenu();
		m_mod = new JMenuItem("수정");
		m_mod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				modIntRow = table.getSelectedRow();
				for (int i = 0; i < indata.length; i++) {
					indata[i].setText((String) table.getValueAt(modIntRow, i));
				}
			}
		});
		m_del = new JMenuItem("삭제");
		m_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() == -1) {
					return;
				} else {
					delTableRow(table.getSelectedRow());
				}
			}
		});
		popup.add(m_mod);
		popup.add(m_del);
	}

	public void delTableRow(int row) {
		tableModel.removeRow(row);
	}

	public void tableSetting() {
		table.setRowMargin(0);
		table.getColumnModel().setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.add(popup);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				}
				if (e.getClickCount() == 2) {
				}
				if (e.getButton() == 3) {
					int column = table.columnAtPoint(e.getPoint());
					int row = table.rowAtPoint(e.getPoint());
					table.changeSelection(row, column, false, false);
					popup.show(table, e.getX(), e.getY());
				}
			}
		});

		DefaultTableCellRenderer ts = new DefaultTableCellRenderer();

		ts.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = table.getColumnModel();
		for (int i = 0; i < tc.getColumnCount(); i++) {
			tc.getColumn(i).setCellRenderer(ts);
		}

	}

	public void createInputP() {
		tab_1_inputP.setLayout(new BoxLayout(tab_1_inputP, BoxLayout.X_AXIS));
		for (int i = 0; i < indata.length; i++) {
			tab_1_inputP.add(indata[i] = new JTextField());
		}
		JButton addB = new JButton("Add");
		tab_1_inputP.add(addB);
		addB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String in[] = new String[4];
				for (int i = 0; i < indata.length; i++) {
					in[i] = indata[i].getText();
					indata[i].setText("");
				}
				tableModel.addRow(in);
//				saveToDB(in);
			}
		});

		JButton modB = new JButton("Mod");
		tab_1_inputP.add(modB);
		modB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (modIntRow != -1) {
					String in[] = new String[4];
					for (int i = 0; i < indata.length; i++) {
						in[i] = indata[i].getText();
						delTableRow(modIntRow);
						tableModel.insertRow(modIntRow, in);
					}
					modIntRow = -1;
				}
			}
		});

		JButton delB = new JButton("Del");
		tab_1_inputP.add(delB);
		delB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() == -1) {
					return;
				} else {
					delTableRow(table.getSelectedRow());
				}
			}
		});

		JButton saveB = new JButton("Play");
		tab_1_inputP.add(saveB);
		saveB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

//				saveToDB();
			}
		});
	}

	public void createTabbedP() {
		tab_1.setLayout(new BorderLayout());
		tab_1.add(tableScroll, "Center");
		tab_1.add(tab_1_inputP, "South");
		tabPane.add("Data", tab_1);

	}

	public static void main(String[] args) {
		new DB();
	}
}
