package com.Jie.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.Jie.Entity.Entity;
import com.Jie.model.Model;

public class Net {

	static Socket socket2;

	public static void main(String[] args) throws Exception {
		// ����������
		Model model = new Model();
		ServerSocket ss = new ServerSocket(8887);
		// �ȴ��ͻ�������
		while (true) {
			Socket socket = ss.accept();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			// ���ܸ�ʽ������
			Entity e = (Entity) ois.readObject();
			// ��������

			e = model.service(e);
			// �������ݽ��
			oos.writeObject(e);
			// �رմ�����
			ois.close();
			oos.close();
		}

	}

}
