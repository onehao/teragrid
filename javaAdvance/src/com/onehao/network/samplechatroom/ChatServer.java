package com.onehao.network.samplechatroom;

import java.net.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class ChatServer {
	static final int DEFAULT_PORT = 6000;
	static ServerSocket serverSocket;
	static Vector<Socket> connections;
	static Vector<ClientProc> clients;

	public static void sendAll(String s) {
		if (connections != null) {
			for (Enumeration e = connections.elements(); e.hasMoreElements();) {
				try {
					PrintWriter pw = new PrintWriter(
							((Socket) e.nextElement()).getOutputStream());
					pw.println(s);
					pw.flush();
				} catch (IOException ex) {
				}
			}
		}
		System.out.println(s);
	}

	// ��������һ����
	public static boolean sendOne(String name, String msg) {
		if (clients != null) {
			for (Enumeration e = clients.elements(); e.hasMoreElements();) {
				ClientProc cp = (ClientProc) e.nextElement();
				if ((cp.getName()).equals(name)) {
					try {
						PrintWriter pw = new PrintWriter(
								(cp.getSocket()).getOutputStream());
						pw.println(msg);
						pw.flush();
						return true; // ���˷��� �ҷ���ֵΪ��
					} catch (IOException ioe) {
					}
				}
			}
		}
		return false;// û���ҵ�����ˣ�Ӧ���Ǵ����Ѿ��˳���������
	}

	public static void addConnection(Socket s, ClientProc cp) {
		if (connections == null) {
			connections = new Vector<Socket>();
		}
		connections.addElement(s);

		if (clients == null) {
			clients = new Vector<ClientProc>();
		}
		clients.addElement(cp);
	}

	public static void deleteConnection(Socket s, ClientProc cp)
			throws IOException {
		if (connections != null) {
			connections.removeElement(s);
			s.close();
		}
		if (clients != null) {
			clients.removeElement(cp);
		}
	}

	public static Vector getClients() {
		return clients;
	}

	public static void main(String[] arg) {

		int port = DEFAULT_PORT;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("�������Ѿ����������ڼ���...");
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		while (true) {
			try {
				Socket cs = serverSocket.accept();

				ClientProc cp = new ClientProc(cs);

				Thread ct = new Thread(cp);
				ct.start();

				addConnection(cs, cp);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}

// ClientProc
class ClientProc implements Runnable {

	Socket s;
	BufferedReader in;
	PrintWriter out;

	private String name = null;
	private String sex = null;

	// Date now;

	public ClientProc(Socket s) throws IOException {
		this.s = s;
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream());
		this.updateList();
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Socket getSocket() {
		return s;
	}

	private void updateList() {
		// �����û��б������͵�ǰ�������ҵ��û����������û��б��У�
		Vector cs = ChatServer.getClients();
		if (cs != null) {
			for (Enumeration e = cs.elements(); e.hasMoreElements();) {
				ClientProc cp = (ClientProc) e.nextElement();
				String exist_name = cp.getName();
				String exit_sex = cp.getSex();
				/**
				 * for (int i = 0;i<cs.size() ;i++ ){ String exist_name
				 * =((ClientProc)cs.elementAt(i)).getName(); //����Ҫ��ͬ������ String
				 * exit_sex = ((ClientProc)cs.elementAt(i)).getSex();
				 */
				out.println("old" + "&" + exist_name + "&" + exit_sex);
				out.flush();

			}

		}
	}

	// Thread's run
	public void run() {
		while (name == null) {
			try {
				String inmsg;
				inmsg = in.readLine();
				ChatServer.sendAll("new" + "&" + inmsg);// ������Ϣ�����û��б�

				String[] userInfo;
				userInfo = inmsg.split("&");
				name = userInfo[0];
				sex = userInfo[1];
				// out.println("��ӭ "+name); //���ε�½
				// out.flush();
			} catch (IOException ee) {
			}
		}
		while (true) {
			try {
				String line = in.readLine();

				// �����˳��¼�
				if (line.equals("quit")) {
					ChatServer.sendAll("��ϵͳ��Ϣ�� " + this.name + " �˳���������");
					ChatServer.deleteConnection(s, this);
					return;
				}
				// ����ˢ���û��б�����
				else if (line.equals("refurbish")) {
					this.updateList();
				}

				// һ����Ϣ,�ֿ��Է�Ϊ����,�Դ��˵, ��ĳ���˽�̸,����˽��
				else {
					// now = new Date();
					// String datestr =
					// DateFormat.getTimeInstance().format(now);
					// ChatServer.sendAll(datestr+"  "+name + "\n " +line);
					if (!line.startsWith("withWho")) { // ��������˵
						ChatServer.sendAll(name + " : " + line);
					} else {
						String[] inmsg = line.split("&");
						if (inmsg[1].equals("privateTure")) {
							if (ChatServer.sendOne(inmsg[2], "privateTalk"
									+ "&" + name + "&" + inmsg[2] + "&"
									+ inmsg[3])) { // success
								out.println("privateTalk" + "&" + name + "&"
										+ inmsg[2] + "&" + inmsg[3]); // �ٷ����Լ�һ��
								out.flush(); // һ��Ҫ��סҪ
							} else {
								out.println(inmsg[2] + "�Ѿ��뿪������");
								out.flush(); // һ��Ҫ��סҪ
							}
						} else
							ChatServer.sendAll("withWho" + "&" + name + "&"
									+ inmsg[2] + "&" + inmsg[3]); // �������е���
					}
				}
			} catch (IOException e) {
				System.out.println("What happen? " + e);
				try {
					s.close();
				} catch (IOException e2) {
				}
				return;
			}
		}
	}
}