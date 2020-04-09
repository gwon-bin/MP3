package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import DB.DAO;

public class Connect {
	private Socket sc = null;
	private InputStream remsg = null;
	private OutputStream sdmsg = null;
	private DAO getIns = DAO.getInstance();
	private String msg = null;
	
	Connect(Socket sc) {
		this.sc = sc;
		while (true) {
			try {
				remsg = sc.getInputStream();
				byte buffer[] = new byte[100];
				remsg.read(buffer);
				msg = new String(buffer);

				login(msg);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void login(String msg) {
		String sendMsg;
		if (msg.equals("signup")) {
			send("signup_assent");
		} else if (msg.contains("ID중복확인")) {
			System.out.println(msg);
			StringTokenizer tk = new StringTokenizer(msg, "/");
			tk.nextToken();
			String id = tk.nextToken();
			System.out.println(id);
			if (getIns.idcheck(id)) {
				sendMsg = "중복된 ID";
				send(sendMsg);
				sendMsg = "";
			} else {
				sendMsg = "사용가능한 ID";
				send(sendMsg);
				sendMsg = "";
			}
		}
	}

	private void send(String msg) {
		try {
			sdmsg = sc.getOutputStream();
			sdmsg.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
