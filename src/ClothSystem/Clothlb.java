package ClothSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Clothlb {
	public void run() throws Exception {
		boolean flag = true;
		while (flag) {
			System.out.println("****************");
			System.out.println("**1.���������Ϣ���**");
			System.out.println("**2.���������Ϣɾ��**");
			System.out.println("**3.���������Ϣ�޸�**");
			System.out.println("**4.���������Ϣ��ѯ**");
			System.out.println("**5.�˳�*********");
			int choice;
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				cloth_lb_add();
				break;
			}
			case 2: {
				cloth_lb_delete();
				break;
			}
			case 3: {
				cloth_lb_modify();
				break;
			}
			case 4: {
				cloth_lb_query();
				break;
			}
			case 5: {
				flag = false;
				break;
			}
			}
		}
	}

	public void cloth_lb_add() throws Exception {//���������Ϣ�����
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ��ӷ��ε����ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ��ӷ��ε�������ƣ�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ��ӵķ����Ƿ�����");
			String ps = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into clothlb values (" + num + ",'" + name + "'" + ",'" + ps + "');";
			System.out.println(sql);
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("���������Ϣ��ӳɹ�");
			} else {
				System.out.println("���������Ϣ���ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_delete() throws Exception {//���������Ϣ��ɾ��
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫɾ���ķ�������ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from clothlb where lbid = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("���������Ϣɾ���ɹ�");
			} else {
				System.out.println("���������Ϣɾ��ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_modify() throws Exception {//���������޸�
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ�޸ķ��������Ϣ�����ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ�޸ķ��������Ϣ�����ƣ�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ�޸ķ��������Ϣ������ȣ�");
			String ps = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update clothlb set lb_name= '" + name + "',lb_sfsh='" + ps + "';";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("���������Ϣ�޸ĳɹ�");
			} else {
				System.out.println("���������Ϣ�޸�ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_query() throws Exception {//�������Ĳ�ѯ
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from clothlb";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("����\t�������\t�Ƿ�����");
			while (resultSet.next()) {
				int id = resultSet.getInt("lbid");
				String name = resultSet.getString("lb_name");
				String pString = resultSet.getString("lb_sfsh");
				System.out.println(id + "\t" + name + "\t" + pString);
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
