package com.onehao.network.samplechatroom;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

class Connect extends JFrame implements ActionListener, ItemListener {
	/**  
     *  
     */
	private static final long serialVersionUID = 1L;

	private Socket client;// 套接字
	private String hostName = "localhost";
	private int port = 6000;

	private JLabel nameLabel;
	private JTextField nameText;
	private JRadioButton boyRadio, girlRadio, secretRadio;
	private String sex = "";

	private JLabel hostLabel;
	private JLabel portLabel;
	private JTextField hostText;
	private JTextField portText;

	private JButton cancell;
	private JButton ok;

	private Container c;

	private BufferedReader in;
	private PrintWriter out;

	public Connect() {
		super("聊天登陆");

		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		final Color defaultBackground = this.getBackground();

		hostLabel = new JLabel("地址：");
		portLabel = new JLabel("端口：");
		hostText = new JTextField(10);
		hostText.setText(hostName); // 设置默认值
		portText = new JTextField(4);
		portText.setText(Integer.toString(port));

		cancell = new JButton("放弃");
		ok = new JButton("连接");

		nameLabel = new JLabel("姓名：");
		nameText = new JTextField(10);
		boyRadio = new JRadioButton("男生");
		girlRadio = new JRadioButton("女生");
		secretRadio = new JRadioButton("保密");

		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(boyRadio);
		sexGroup.add(girlRadio);
		sexGroup.add(secretRadio);

		// *********用户信息面板*********************//
		JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		userInfoPanel.add(nameLabel);
		userInfoPanel.add(nameText);

		userInfoPanel.add(boyRadio);
		userInfoPanel.add(girlRadio);
		userInfoPanel.add(secretRadio);
		// ***************************************//

		// ****************连接服务器面板******************//
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerPanel.add(hostLabel);
		centerPanel.add(hostText);
		centerPanel.add(portLabel);
		centerPanel.add(portText);
		// ***************************************************//

		// *******************组合以上两个面板*****************//
		JPanel upperPanel = new JPanel(new GridLayout(2, 1)); // 面板
		// *******************创建一个具有指定颜色和宽度的线边框*****************//
		upperPanel.setBorder(BorderFactory.createLineBorder(new Color(125, 161,
				253), 2));
		// *******************设置此组件的背景色*****************//
		upperPanel.setBackground(new Color(70, 61, 129));
		upperPanel.add(userInfoPanel);
		upperPanel.add(centerPanel);
		// ***************************************************//

		// ****************连接确认连接的面板******************//
		JPanel lowerPanel = new JPanel();
		JLabel spaceLabel = new JLabel("");
		// ****************设置此组件的首选大小******************//
		spaceLabel.setPreferredSize(new Dimension(20, 20));
		lowerPanel.add(cancell);
		lowerPanel.add(spaceLabel);
		lowerPanel.add(ok);
		// ***************************************************//

		// ***************组合整个框架**********************//
		c.add(upperPanel, BorderLayout.CENTER);
		c.add(lowerPanel, BorderLayout.SOUTH);
		// **************************************************//

		// 事件监听 单选
		boyRadio.addItemListener(this);
		girlRadio.addItemListener(this);
		secretRadio.addItemListener(this);

		// 事件监听 按钮
		cancell.addActionListener(this);
		ok.addActionListener(this);

		this.setPreferredSize(new Dimension(350, 150));
		this.setMaximumSize(new Dimension(350, 150));
		this.setLocation(300, 200);
		this.pack();
		this.setResizable(false); // 设置不能最大化
		this.setVisible(true);
	}

	// 事件 单选
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == boyRadio) {
			sex = "Boy";
		}
		if (e.getSource() == girlRadio) {
			sex = "Girl";
		}
		if (e.getSource() == secretRadio) {
			sex = "Secret";
		}

	}

	// 事件 按钮
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancell) {
			this.shutDown();
		} else if (e.getSource() == ok) {
			if ((nameText.getText()).trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "请输入一个名字", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if (sex.length() == 0) {
				JOptionPane.showMessageDialog(this, "请选择性别", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				try {
					this.link();
					ChatFrame app = new ChatFrame();
					app.init(in, out, nameText.getText());
					ok.setEnabled(false); // 确保不会被再次点击
					this.setVisible(false);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(this, "登陆失败", "失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
	}

	public void link() throws Exception { // 连接服务器

		hostName = hostText.getText().trim();
		port = Integer.parseInt(portText.getText());
		client = new Socket(hostName, port);

		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream());
		out.println(nameText.getText() + "&" + sex);
		out.flush();

		/**
		 * catch(NumberFormatException nfe){ System.out.println(nfe); // return
		 * false; } catch(Exception e){ System.out.println(e); // return false;
		 * } //return true;
		 */
	}

	public void shutDown() {
		System.exit(0);
	}

	public static void main(String[] args) {
		Connect app = new Connect();

		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}