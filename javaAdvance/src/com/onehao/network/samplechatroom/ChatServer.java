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

	// 发给单独一个人
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
						return true; // 找了返回 且返回值为真
					} catch (IOException ioe) {
					}
				}
			}
		}
		return false;// 没有找到这个人，应该是此人已经退出了聊天室
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
			System.out.println("服务器已经启动，正在监听...");
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
		// 更新用户列表（即发送当前在聊天室的用户到新来的用户列表中）
		Vector cs = ChatServer.getClients();
		if (cs != null) {
			for (Enumeration e = cs.elements(); e.hasMoreElements();) {
				ClientProc cp = (ClientProc) e.nextElement();
				String exist_name = cp.getName();
				String exit_sex = cp.getSex();
				/**
				 * for (int i = 0;i<cs.size() ;i++ ){ String exist_name
				 * =((ClientProc)cs.elementAt(i)).getName(); //或许要用同步语句块 String
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
				ChatServer.sendAll("new" + "&" + inmsg);// 发送信息更新用户列表

				String[] userInfo;
				userInfo = inmsg.split("&");
				name = userInfo[0];
				sex = userInfo[1];
				// out.println("欢迎 "+name); //初次登陆
				// out.flush();
			} catch (IOException ee) {
			}
		}
		while (true) {
			try {
				String line = in.readLine();

				// 处理退出事件
				if (line.equals("quit")) {
					ChatServer.sendAll("【系统消息】 " + this.name + " 退出了聊天室");
					ChatServer.deleteConnection(s, this);
					return;
				}
				// 处理刷新用户列表请求
				else if (line.equals("refurbish")) {
					this.updateList();
				}

				// 一般消息,又可以分为几种,对大家说, 与某个人交谈,或者私聊
				else {
					// now = new Date();
					// String datestr =
					// DateFormat.getTimeInstance().format(now);
					// ChatServer.sendAll(datestr+"  "+name + "\n " +line);
					if (!line.startsWith("withWho")) { // 对所有人说
						ChatServer.sendAll(name + " : " + line);
					} else {
						String[] inmsg = line.split("&");
						if (inmsg[1].equals("privateTure")) {
							if (ChatServer.sendOne(inmsg[2], "privateTalk"
									+ "&" + name + "&" + inmsg[2] + "&"
									+ inmsg[3])) { // success
								out.println("privateTalk" + "&" + name + "&"
										+ inmsg[2] + "&" + inmsg[3]); // 再发给自己一份
								out.flush(); // 一定要记住要
							} else {
								out.println(inmsg[2] + "已经离开聊天室");
								out.flush(); // 一定要记住要
							}
						} else
							ChatServer.sendAll("withWho" + "&" + name + "&"
									+ inmsg[2] + "&" + inmsg[3]); // 发给所有的人
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