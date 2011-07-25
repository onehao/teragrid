package com.onehao.network.samplechatroom;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

class ChatFrame extends JFrame implements ActionListener,
		ListSelectionListener, ItemListener, Runnable {
	/**  
     *  
     */
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;

	private JLabel welcomeInfo;
	private JTextArea commonArea; // ����������
	private JTextArea myMsgArea;
	private JComboBox perponsComboBox;
	private JTextField inMsgField; // ���������
	private JCheckBox privateTalk;
	private boolean privateTalkFlag = false; // �Ƿ���˽��,Ĭ��ֵΪ��
	private JButton sentButton; // ������Ϣ��ť
	private JList peopleList; // ��ʾ���������ҵ�������
	private JButton refurbishButton;

	private JMenuItem menuItem;
	private JMenuItem hideMenuItem;
	private BufferedReader in;
	private PrintWriter out;
	private DefaultListModel listModel;

	private String myName;
	private String withWho = "������";

	JPanel centerPanel;
	JScrollPane commonAreaScroll;
	JScrollPane myMsgAreaScroll;

	public ChatFrame() {
		super("Onehao������");

		// *********************������������ҷ���**************//
		JPanel upperPanel = new JPanel();
		welcomeInfo = new JLabel();
		Icon BordTop = new ImageIcon("images\\BordTop.gif");
		welcomeInfo.setIcon(BordTop);
		nameLabel = new JLabel();
		upperPanel.add(welcomeInfo);
		upperPanel.add(nameLabel);
		// *******************************************************//

		// **************�м���������������***********************//
		centerPanel = new JPanel(new BorderLayout()); // ���
		// **************�������*********************//
		/*
		 * centerPanel = new JPanel(); centerPanel.setLayout(new BordLayout());
		 */
		// ***************�������ָ���������������µĿյ�TextArea************//
		commonArea = new JTextArea(15, 40); // ����������
		// *************����ָ����boolean��������ָʾ��TextComponent
		// �Ƿ�Ӧ��Ϊ�ɱ༭��*************//
		commonArea.setEditable(false);
		commonAreaScroll = new JScrollPane(commonArea);
		commonAreaScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commonAreaScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		commonAreaScroll.setBorder(BorderFactory.createTitledBorder("������Ƶ��"));
		centerPanel.add(commonAreaScroll, BorderLayout.NORTH);

		myMsgArea = new JTextArea(10, 40); // �ҵķ�����
		// *************����ָ����boolean��������ָʾ��TextComponent
		// �Ƿ�Ӧ��Ϊ�ɱ༭��*************//
		myMsgArea.setEditable(false);
		myMsgArea.setForeground(new Color(107, 101, 29));// ������ɫ,���ô������ǰ��ɫ
		myMsgAreaScroll = new JScrollPane(myMsgArea);
		myMsgAreaScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myMsgAreaScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		myMsgAreaScroll.setBorder(BorderFactory.createTitledBorder("�ҵ�Ƶ��"));
		centerPanel.add(myMsgAreaScroll, BorderLayout.CENTER);

		// ******************���뷢����***********************
		JPanel centerLowerPanel = new JPanel(new BorderLayout());
		JPanel tempPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel tempPanel2 = new JPanel(new BorderLayout());

		JLabel withWho = new JLabel("��");
		perponsComboBox = new JComboBox();
		perponsComboBox.addItem("������");
		privateTalk = new JCheckBox("˽��");

		inMsgField = new JTextField(33);
		sentButton = new JButton();
		Icon sentIcon = new ImageIcon("images\\ButtonSenddown.gif");
		sentButton.setIcon(sentIcon);
		sentButton.setBackground(Color.WHITE);
		// JToggleButton toggleButton = new JToggleButton("˽��");
		tempPanel1.add(withWho);
		tempPanel1.add(perponsComboBox);
		tempPanel1.add(privateTalk);
		// tempPanel1.add(toggleButton);

		tempPanel2.add(inMsgField, BorderLayout.CENTER);
		tempPanel2.add(sentButton, BorderLayout.EAST);

		centerLowerPanel.add(tempPanel1, BorderLayout.CENTER);
		centerLowerPanel.add(tempPanel2, BorderLayout.SOUTH);

		centerPanel.add(centerLowerPanel, BorderLayout.SOUTH);
		// **********************************************************//

		// **************East ��ʾ���뷿�������*********************//
		JPanel eastPanel = new JPanel(new BorderLayout());
		listModel = new DefaultListModel();
		peopleList = new JList(listModel);
		peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane ListScrollPane = new JScrollPane(peopleList);
		ListScrollPane.setPreferredSize(new Dimension(150, 400));

		refurbishButton = new JButton("ˢ���б�");

		eastPanel.add(ListScrollPane, BorderLayout.CENTER);
		eastPanel.add(refurbishButton, BorderLayout.SOUTH);
		// *********************************************************//
		// ********************** ����������(South)*****************//
		JLabel BordBottomLabel = new JLabel();
		Icon BordBottom = new ImageIcon("images\\BordBottom.gif");
		BordBottomLabel.setIcon(BordBottom);
		// **********************************************************//
		// ******************����������**************************//
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(BordBottomLabel, BorderLayout.SOUTH);
		// ********************************************************//
		sentButton.addActionListener(this);
		refurbishButton.addActionListener(this);

		perponsComboBox.addActionListener(this);
		peopleList.addListSelectionListener(this);

		privateTalk.addItemListener(this);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * peopleList.addListSelectionListener( new ListSelectionListener () {
		 * public void valueChanged(ListSelectionEvent e) { if (e.getSource() ==
		 * peopleList){ String select = (String)peopleList.getSelectedValue();
		 * perponsComboBox.addItem(select);
		 * perponsComboBox.setSelectedItem(select);
		 * //JOptionPane.showMessageDialog
		 * (this,select,"���",JOptionPane.INFORMATION_MESSAGE); } } } );
		 */
		this.createPopupMenu();
		this.pack();
		this.setVisible(true);

		// when close the windows
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				shutDown();
			}
		});
	}

	public void createPopupMenu() {

		// Create the popup menu.
		JPopupMenu popup = new JPopupMenu();
		menuItem = new JMenuItem("ˢ��Ƶ��");
		menuItem.addActionListener(this);
		popup.add(menuItem);

		hideMenuItem = new JMenuItem("���ع���Ƶ��");
		hideMenuItem.addActionListener(this);
		popup.add(hideMenuItem);
		// Add listener to the text area so the popup menu can come up.
		MouseListener popupListener = new PopupListener(popup);
		commonArea.addMouseListener(popupListener);
		myMsgArea.addMouseListener(popupListener);
	}

	public void init(BufferedReader in, PrintWriter out, String name) {

		// ������롢�����
		this.in = in;
		this.out = out;
		// ������Լ�������
		myName = name;
		nameLabel.setText(myName); // ��ʼ������

		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		String inmsg;
		while (true) {
			try {
				inmsg = in.readLine();
				// System.out.println(inmsg);

				// �Ѿ����������������ʾ���б���
				if (inmsg.startsWith("old")) {
					String[] userInfo = inmsg.split("&");
					listModel
							.addElement(userInfo[1] + " ��" + userInfo[2] + "��"); // �����û��б�
				}

				else if (inmsg.startsWith("new")) { // ���յ�һ�η��������ͻ�ӭ��Ϣ
					String[] userInfo = inmsg.split("&");
					listModel
							.addElement(userInfo[1] + " ��" + userInfo[2] + "��"); // �����û��б�
					commonArea.append("��ӭ " + userInfo[1] + "\n");
					myMsgArea.append("��ӭ " + userInfo[1] + "\n");
				}
				// һ����Ϣ
				else if (inmsg != null) {
					if (inmsg.startsWith("withWho")) {
						String showmsg[] = inmsg.split("&");
						// System.out.println("�����ߵ����֣�"+showmsg[2]+"�ҵ�����"+myName+";\n");
						if (showmsg[2].equals(myName)) { // ����Ƿ����Լ�����Ϣ
							myMsgArea.append(showmsg[1] + "�ԡ�" + showmsg[2]
									+ "��˵: " + showmsg[3] + "\n"); // ��ʾ���ҵ�Ƶ��
						}
						commonArea.append(showmsg[1] + "�ԡ�" + showmsg[2]
								+ "��˵: " + showmsg[3] + "\n"); // ��ʾ������Ƶ��
					} else if (inmsg.startsWith("privateTalk")) {
						String showmsg[] = inmsg.split("&");
						if (showmsg[1].equals(myName)) {// ������յ��������Լ����͵���Ϣ
							commonArea.append(" �����Ļ� ���ԡ�" + showmsg[2] + "��˵: "
									+ showmsg[3] + "\n");
						} else
							// ���յ����Ǳ��˷����ҵ���Ϣ�����Ļ���
							myMsgArea.append(" �����Ļ� ��" + showmsg[1] + "������˵: "
									+ showmsg[3] + "\n");
					} else
						commonArea.append(inmsg + "\n");
				}
			} catch (Exception ee) {
				System.out.println("Error at run()" + ee);
				myMsgArea.append("������������ж�,�����µ�½��\n");

				// �����������������Ϊ null
				in = null;
				out = null;

				return;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		String outmsg;
		String mywords;
		if (e.getSource() == sentButton) {
			try {
				mywords = inMsgField.getText();
				if ((mywords.trim()).length() != 0) { // ���ܷ��Ϳ���ϢҲ���ܶ����ո�
					if (withWho.equals("������")) {
						outmsg = mywords;
						// ���͵�������
						out.println(outmsg);
						out.flush();

						// ��ʾ���ҵ�Ƶ������
						myMsgArea.append(myName + "��" + mywords + "\n");
					} else { // ��ĳ���˽�̸
						outmsg = "withWho" + "&" + "privateFalse" + "&"
								+ withWho + "&" + mywords;
						if (privateTalkFlag) {
							outmsg = "withWho" + "&" + "privateTure" + "&"
									+ withWho + "&" + mywords;
							myMsgArea.append(" �����Ļ� ���ԡ�" + withWho + "��˵: "
									+ mywords + "\n");
						} else
							myMsgArea.append(myName + " �ԡ�" + withWho + "��˵: "
									+ mywords + "\n");

						// ���͵�������
						out.println(outmsg);
						out.flush();
					}
				}
			} catch (Exception ee) {
				System.out.println(ee);
				myMsgArea.append("������������ж�,�����µ�½��\n");
			} finally {
				// ���������
				inMsgField.setText("");
			}
		}
		if (e.getSource() == refurbishButton) {
			try {
				// ����б�
				listModel.clear();
				// ����ˢ�����󵽷�����
				out.println("refurbish");
				out.flush();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == perponsComboBox) {
			withWho = (String) perponsComboBox.getSelectedItem(); // ���ѡ�������
		}
		if (e.getSource() == menuItem) {
			commonArea.setText("");
		}
		if (e.getSource() == hideMenuItem) {
			centerPanel.add(myMsgAreaScroll);
			// BordBottomLabel.setVisible(false);
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == peopleList) {
			try {
				String select = (String) peopleList.getSelectedValue();
				if (select != null) { // ȷ��ѡ��ǿ�
					String[] userInfo = select.split("��");
					String name = userInfo[0].trim(); // ��ȡ����

					if (!name.equals(myName)) { // ��������Լ�

						int count = perponsComboBox.getItemCount();
						for (int i = 0; i < count; i++) {
							perponsComboBox.setSelectedIndex(i);
							String strName = (String) perponsComboBox
									.getSelectedItem();
							if (name.equals(strName)) { // ����Ѿ����б��У��͸��Ͽ���ѡ�У�����Ҫȷ��û��������Ŷ
								return;
							}
						}
						// ���û����ӣ��ͻ�ִ��������� ���
						perponsComboBox.addItem(name);
					}
				}
			} catch (Exception ee) {
				System.out.println("�������� ��valueChanged " + ee);
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == privateTalk) {
			if (e.getStateChange() == ItemEvent.SELECTED) { // ���ѡ��
				privateTalkFlag = true;
			} else
				privateTalkFlag = false;
		}

	}

	public void shutDown() {
		try {
			out.println("quit");
			out.flush();
		} catch (Exception ee) {
			JOptionPane.showMessageDialog(this, ee, "����",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			System.exit(0);
		}
	}

	// main
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ChatFrame();
			}
		});
	}

}

class PopupListener extends MouseAdapter {
	JPopupMenu popup;

	PopupListener(JPopupMenu popupMenu) {
		popup = popupMenu;
	}

	public void mousePressed(MouseEvent e) {
		maybeShowPopup(e);
	}

	public void mouseReleased(MouseEvent e) {
		maybeShowPopup(e);
	}

	private void maybeShowPopup(MouseEvent e) {
		if (e.isPopupTrigger()) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
// ��  