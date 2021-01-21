package ClothSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
	CkManage ckManage = new CkManage();
	RkManage rkManage = new RkManage();
	public void run() throws Exception {
		boolean flag = true;
		while (flag) {
			System.out.println("****************");
			System.out.println("**1.����Ա��Ϣ���**");
			System.out.println("**2.����Ա��Ϣɾ��**");
			System.out.println("**3.����Ա��Ϣ�޸�**");
			System.out.println("**4.����Ա��Ϣ��ѯ**");
			System.out.println("**5.���ⶩ������***");
			System.out.println("**6.��ⶩ������***");
			System.out.println("**7.�˳�*********");
			int choice;
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				admin_info_add();
				break;
			}
			case 2: {
				admin_info_delete();
				break;
			}
			case 3: {
				admin_info_modify();
				break;
			}
			case 4: {
				admin_info_query();
				break;
			}
			case 5: {
				ckManage.run();
				break;
			}
			case 6: {
				rkManage.run();
				break;
			}
			case 7: {
				flag = false;
				break;
			}
			}
		}
	}

	public void admin_info_add() throws Exception {//����Ա��Ϣ�����
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ��ӹ���Ա�Ĺ��ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ��ӹ���Ա��������");
			String name = scanner.nextLine();
			System.out.println("������Ҫ��ӹ���Ա����ϵ�绰��");
			String tel = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into admin values (" + num + ",'" + name + "'" + ",'" + tel + "');";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("����Ա��Ϣ��ӳɹ�");
			} else {
				System.out.println("����Ա��Ϣ���ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_delete() throws Exception {//����Ա��Ϣ��ɾ��
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫɾ���Ĺ���Ա���ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from admin where adminnum = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("����Ա��Ϣɾ���ɹ�");
			} else {
				System.out.println("����Ա��Ϣɾ��ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_modify() throws Exception {//����Ա��Ϣ���޸�
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ�޸Ĺ���Ա�Ĺ��ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ�޸Ĺ���Ա��������");
			String name = scanner.nextLine();
			System.out.println("������Ҫ�޸Ĺ���Ա����ϵ�绰��");
			String tel = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update admin set admin_name= '" + name + "',admin_tel='" + tel + "' where adminnum=" + num
					+ ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("����Ա��Ϣ�޸ĳɹ�");
			} else {
				System.out.println("����Ա��Ϣ�޸�ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_query() throws Exception {//����Ա��Ϣ�Ĳ�ѯ
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from admin";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("����\t����\t��ϵ�绰");
			while (resultSet.next()) {
				int id = resultSet.getInt("adminnum");
				String name = resultSet.getString("admin_name");
				String tel = resultSet.getString("admin_tel");
				System.out.println(id + "\t" + name + "\t" + tel);
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}
}
