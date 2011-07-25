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
	private JTextArea commonArea; // 公共发言区
	private JTextArea myMsgArea;
	private JComboBox perponsComboBox;
	private JTextField inMsgField; // 发言输入框
	private JCheckBox privateTalk;
	private boolean privateTalkFlag = false; // 是否是私聊,默认值为假
	private JButton sentButton; // 发送消息按钮
	private JList peopleList; // 显示进入聊天室的人名单
	private JButton refurbishButton;

	private JMenuItem menuItem;
	private JMenuItem hideMenuItem;
	private BufferedReader in;
	private PrintWriter out;
	private DefaultListModel listModel;

	private String myName;
	private String withWho = "所有人";

	JPanel centerPanel;
	JScrollPane commonAreaScroll;
	JScrollPane myMsgAreaScroll;

	public ChatFrame() {
		super("Onehao聊天室");

		// *********************上面进入聊天室房间**************//
		JPanel upperPanel = new JPanel();
		welcomeInfo = new JLabel();
		Icon BordTop = new ImageIcon("images\\BordTop.gif");
		welcomeInfo.setIcon(BordTop);
		nameLabel = new JLabel();
		upperPanel.add(welcomeInfo);
		upperPanel.add(nameLabel);
		// *******************************************************//

		// **************中间聊天室两个窗口***********************//
		centerPanel = new JPanel(new BorderLayout()); // 面板
		// **************设置面板*********************//
		/*
		 * centerPanel = new JPanel(); centerPanel.setLayout(new BordLayout());
		 */
		// ***************构造具有指定行数和列数的新的空的TextArea************//
		commonArea = new JTextArea(15, 40); // 公共言论区
		// *************设置指定的boolean变量，以指示此TextComponent
		// 是否应该为可编辑的*************//
		commonArea.setEditable(false);
		commonAreaScroll = new JScrollPane(commonArea);
		commonAreaScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		commonAreaScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		commonAreaScroll.setBorder(BorderFactory.createTitledBorder("主聊天频道"));
		centerPanel.add(commonAreaScroll, BorderLayout.NORTH);

		myMsgArea = new JTextArea(10, 40); // 我的发言区
		// *************设置指定的boolean变量，以指示此TextComponent
		// 是否应该为可编辑的*************//
		myMsgArea.setEditable(false);
		myMsgArea.setForeground(new Color(107, 101, 29));// 设置颜色,设置此组件的前景色
		myMsgAreaScroll = new JScrollPane(myMsgArea);
		myMsgAreaScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myMsgAreaScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		myMsgAreaScroll.setBorder(BorderFactory.createTitledBorder("我的频道"));
		centerPanel.add(myMsgAreaScroll, BorderLayout.CENTER);

		// ******************输入发送区***********************
		JPanel centerLowerPanel = new JPanel(new BorderLayout());
		JPanel tempPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel tempPanel2 = new JPanel(new BorderLayout());

		JLabel withWho = new JLabel("对");
		perponsComboBox = new JComboBox();
		perponsComboBox.addItem("所有人");
		privateTalk = new JCheckBox("私聊");

		inMsgField = new JTextField(33);
		sentButton = new JButton();
		Icon sentIcon = new ImageIcon("images\\ButtonSenddown.gif");
		sentButton.setIcon(sentIcon);
		sentButton.setBackground(Color.WHITE);
		// JToggleButton toggleButton = new JToggleButton("私聊");
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

		// **************East 显示进入房间的名单*********************//
		JPanel eastPanel = new JPanel(new BorderLayout());
		listModel = new DefaultListModel();
		peopleList = new JList(listModel);
		peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane ListScrollPane = new JScrollPane(peopleList);
		ListScrollPane.setPreferredSize(new Dimension(150, 400));

		refurbishButton = new JButton("刷新列表");

		eastPanel.add(ListScrollPane, BorderLayout.CENTER);
		eastPanel.add(refurbishButton, BorderLayout.SOUTH);
		// *********************************************************//
		// ********************** 最下面的面板(South)*****************//
		JLabel BordBottomLabel = new JLabel();
		Icon BordBottom = new ImageIcon("images\\BordBottom.gif");
		BordBottomLabel.setIcon(BordBottom);
		// **********************************************************//
		// ******************组合整个框架**************************//
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
		 * (this,select,"你好",JOptionPane.INFORMATION_MESSAGE); } } } );
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
		menuItem = new JMenuItem("刷新频道");
		menuItem.addActionListener(this);
		popup.add(menuItem);

		hideMenuItem = new JMenuItem("隐藏公共频道");
		hideMenuItem.addActionListener(this);
		popup.add(hideMenuItem);
		// Add listener to the text area so the popup menu can come up.
		MouseListener popupListener = new PopupListener(popup);
		commonArea.addMouseListener(popupListener);
		myMsgArea.addMouseListener(popupListener);
	}

	public void init(BufferedReader in, PrintWriter out, String name) {

		// 获得输入、输出流
		this.in = in;
		this.out = out;
		// 获得我自己的名字
		myName = name;
		nameLabel.setText(myName); // 初始化名字

		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		String inmsg;
		while (true) {
			try {
				inmsg = in.readLine();
				// System.out.println(inmsg);

				// 已经在聊天室里的人显示到列表中
				if (inmsg.startsWith("old")) {
					String[] userInfo = inmsg.split("&");
					listModel
							.addElement(userInfo[1] + " 〖" + userInfo[2] + "〗"); // 更新用户列表
				}

				else if (inmsg.startsWith("new")) { // 接收第一次服务器发送欢迎信息
					String[] userInfo = inmsg.split("&");
					listModel
							.addElement(userInfo[1] + " 〖" + userInfo[2] + "〗"); // 更新用户列表
					commonArea.append("欢迎 " + userInfo[1] + "\n");
					myMsgArea.append("欢迎 " + userInfo[1] + "\n");
				}
				// 一般消息
				else if (inmsg != null) {
					if (inmsg.startsWith("withWho")) {
						String showmsg[] = inmsg.split("&");
						// System.out.println("接收者的名字："+showmsg[2]+"我的名字"+myName+";\n");
						if (showmsg[2].equals(myName)) { // 如果是发给自己的消息
							myMsgArea.append(showmsg[1] + "对『" + showmsg[2]
									+ "』说: " + showmsg[3] + "\n"); // 显示到我的频道
						}
						commonArea.append(showmsg[1] + "对『" + showmsg[2]
								+ "』说: " + showmsg[3] + "\n"); // 显示到公共频道
					} else if (inmsg.startsWith("privateTalk")) {
						String showmsg[] = inmsg.split("&");
						if (showmsg[1].equals(myName)) {// 如果接收到的是我自己发送的消息
							commonArea.append(" ※悄悄话 您对『" + showmsg[2] + "』说: "
									+ showmsg[3] + "\n");
						} else
							// 接收到的是别人发给我的消息（悄悄话）
							myMsgArea.append(" ※悄悄话 『" + showmsg[1] + "』对您说: "
									+ showmsg[3] + "\n");
					} else
						commonArea.append(inmsg + "\n");
				}
			} catch (Exception ee) {
				System.out.println("Error at run()" + ee);
				myMsgArea.append("与服务器连接中断,请重新登陆！\n");

				// 输出流，输入流设置为 null
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
				if ((mywords.trim()).length() != 0) { // 不能发送空消息也不能都发空格
					if (withWho.equals("所有人")) {
						outmsg = mywords;
						// 发送到服务器
						out.println(outmsg);
						out.flush();

						// 显示到我的频道里面
						myMsgArea.append(myName + "：" + mywords + "\n");
					} else { // 对某个人交谈
						outmsg = "withWho" + "&" + "privateFalse" + "&"
								+ withWho + "&" + mywords;
						if (privateTalkFlag) {
							outmsg = "withWho" + "&" + "privateTure" + "&"
									+ withWho + "&" + mywords;
							myMsgArea.append(" ※悄悄话 您对『" + withWho + "』说: "
									+ mywords + "\n");
						} else
							myMsgArea.append(myName + " 对『" + withWho + "』说: "
									+ mywords + "\n");

						// 发送到服务器
						out.println(outmsg);
						out.flush();
					}
				}
			} catch (Exception ee) {
				System.out.println(ee);
				myMsgArea.append("与服务器连接中断,请重新登陆！\n");
			} finally {
				// 清空输入区
				inMsgField.setText("");
			}
		}
		if (e.getSource() == refurbishButton) {
			try {
				// 清空列表
				listModel.clear();
				// 发送刷新请求到服务器
				out.println("refurbish");
				out.flush();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == perponsComboBox) {
			withWho = (String) perponsComboBox.getSelectedItem(); // 获得选择的名称
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
				if (select != null) { // 确保选择非空
					String[] userInfo = select.split("〖");
					String name = userInfo[0].trim(); // 提取名字

					if (!name.equals(myName)) { // 不能添加自己

						int count = perponsComboBox.getItemCount();
						for (int i = 0; i < count; i++) {
							perponsComboBox.setSelectedIndex(i);
							String strName = (String) perponsComboBox
									.getSelectedItem();
							if (name.equals(strName)) { // 如果已经在列表中，就复合框中选中，所以要确保没有重名的哦
								return;
							}
						}
						// 如果没有添加，就会执行下面语句 添加
						perponsComboBox.addItem(name);
					}
				}
			} catch (Exception ee) {
				System.out.println("发生错误 在valueChanged " + ee);
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == privateTalk) {
			if (e.getStateChange() == ItemEvent.SELECTED) { // 如果选中
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
			JOptionPane.showMessageDialog(this, ee, "错误",
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
// ※  