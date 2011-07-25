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

	private Socket client;// �׽���
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
		super("�����½");

		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		final Color defaultBackground = this.getBackground();

		hostLabel = new JLabel("��ַ��");
		portLabel = new JLabel("�˿ڣ�");
		hostText = new JTextField(10);
		hostText.setText(hostName); // ����Ĭ��ֵ
		portText = new JTextField(4);
		portText.setText(Integer.toString(port));

		cancell = new JButton("����");
		ok = new JButton("����");

		nameLabel = new JLabel("������");
		nameText = new JTextField(10);
		boyRadio = new JRadioButton("����");
		girlRadio = new JRadioButton("Ů��");
		secretRadio = new JRadioButton("����");

		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(boyRadio);
		sexGroup.add(girlRadio);
		sexGroup.add(secretRadio);

		// *********�û���Ϣ���*********************//
		JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		userInfoPanel.add(nameLabel);
		userInfoPanel.add(nameText);

		userInfoPanel.add(boyRadio);
		userInfoPanel.add(girlRadio);
		userInfoPanel.add(secretRadio);
		// ***************************************//

		// ****************���ӷ��������******************//
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerPanel.add(hostLabel);
		centerPanel.add(hostText);
		centerPanel.add(portLabel);
		centerPanel.add(portText);
		// ***************************************************//

		// *******************��������������*****************//
		JPanel upperPanel = new JPanel(new GridLayout(2, 1)); // ���
		// *******************����һ������ָ����ɫ�Ϳ�ȵ��߱߿�*****************//
		upperPanel.setBorder(BorderFactory.createLineBorder(new Color(125, 161,
				253), 2));
		// *******************���ô�����ı���ɫ*****************//
		upperPanel.setBackground(new Color(70, 61, 129));
		upperPanel.add(userInfoPanel);
		upperPanel.add(centerPanel);
		// ***************************************************//

		// ****************����ȷ�����ӵ����******************//
		JPanel lowerPanel = new JPanel();
		JLabel spaceLabel = new JLabel("");
		// ****************���ô��������ѡ��С******************//
		spaceLabel.setPreferredSize(new Dimension(20, 20));
		lowerPanel.add(cancell);
		lowerPanel.add(spaceLabel);
		lowerPanel.add(ok);
		// ***************************************************//

		// ***************����������**********************//
		c.add(upperPanel, BorderLayout.CENTER);
		c.add(lowerPanel, BorderLayout.SOUTH);
		// **************************************************//

		// �¼����� ��ѡ
		boyRadio.addItemListener(this);
		girlRadio.addItemListener(this);
		secretRadio.addItemListener(this);

		// �¼����� ��ť
		cancell.addActionListener(this);
		ok.addActionListener(this);

		this.setPreferredSize(new Dimension(350, 150));
		this.setMaximumSize(new Dimension(350, 150));
		this.setLocation(300, 200);
		this.pack();
		this.setResizable(false); // ���ò������
		this.setVisible(true);
	}

	// �¼� ��ѡ
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

	// �¼� ��ť
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancell) {
			this.shutDown();
		} else if (e.getSource() == ok) {
			if ((nameText.getText()).trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "������һ������", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else if (sex.length() == 0) {
				JOptionPane.showMessageDialog(this, "��ѡ���Ա�", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				try {
					this.link();
					ChatFrame app = new ChatFrame();
					app.init(in, out, nameText.getText());
					ok.setEnabled(false); // ȷ�����ᱻ�ٴε��
					this.setVisible(false);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(this, "��½ʧ��", "ʧ��",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
	}

	public void link() throws Exception { // ���ӷ�����

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