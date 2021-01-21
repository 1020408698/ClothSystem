package ClothSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Clothinfo {
	public void run() throws Exception {
		boolean flag = true;
		while (flag) {
			System.out.println("*******************");
			System.out.println("**1.������Ϣ���******");
			System.out.println("**2.������Ϣɾ��******");
			System.out.println("**3.������Ϣ�޸�******");
			System.out.println("**4.���еķ�����Ϣ��ѯ**");
			System.out.println("**5.�����������Ϣ��ѯ**");
			System.out.println("**6.�˳�************");
			int choice;
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				cloth_info_add();
				break;
			}
			case 2: {
				cloth_info_delete();
				break;
			}
			case 3: {
				cloth_info_modify();
				break;
			}
			case 4: {
				cloth_info_query();
				break;
			}
			case 5: {
				clothlb_info_query();
				break;
			}
			case 6: {
				flag = false;
				break;
			}
			}
		}
	}

	public void cloth_info_add() throws Exception {//������Ϣ����
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ��ӷ��εı�ţ�");
			String num = scanner.nextLine();
			System.out.println("������Ҫ��ӷ��ε����֣�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ��ӷ������id��");
			int lbid = scanner.nextInt();
			System.out.println("������Ҫ��ӷ��ε��ۣ�");
			int single_price = scanner.nextInt();
			System.out.println("������Ҫ��ӷ���������");
			int cloth_mount = scanner.nextInt();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql1 = "select lbid from clothlb where lbid ="+lbid+";";
			Statement statement1 = conn.createStatement();
			ResultSet result1 = statement1.executeQuery(sql1);
			boolean flag2 = false;
			while(result1.next()){
				int id = result1.getInt("lbid");
				if (id==lbid) {
					flag2=true;
					break;
				}
			}
			if (flag2) {
				String sql = "insert into clothinfo values ('" + num + "','" + name + "'" + "," + lbid + "," + single_price
						+ "," + cloth_mount + ");";				
				Statement statement = conn.createStatement();
				int result = statement.executeUpdate(sql);
				if (result > 0) {
					System.out.println("������Ϣ��ӳɹ�");
				} else {
					System.out.println("������Ϣ���ʧ��");
				}
			}
			else{
				System.out.println("������𲻴���");
				System.out.println("������Ϣ���ʧ��");
			}
			scanner.nextLine();
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_delete() throws Exception {//������Ϣɾ��
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫɾ���ķ��α�ţ�");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from clothinfo where cloth_num = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("������Ϣɾ���ɹ�");
			} else {
				System.out.println("������Ϣɾ��ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_modify() throws Exception {//������Ϣ�޸�
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ�޸ķ�����Ϣ�ı�ţ�");
			String num = scanner.nextLine();
			System.out.println("������Ҫ�޸ķ�����Ϣ�����ƣ�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ�޸ķ�����Ϣ�����ţ�");
			int lbid = scanner.nextInt();
			System.out.println("������Ҫ�޸ķ�����Ϣ�ĵ��ۣ�");
			int single_price = scanner.nextInt();
			System.out.println("������Ҫ�޸ķ�����Ϣ�Ŀ������");
			int mount = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update clothinfo set cloth_name= '" + name + "',lbid=" + lbid+",single_price="+single_price+",cloth_mount="+mount+" where cloth_num="+num+";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("������Ϣ�޸ĳɹ�");
			} else {
				System.out.println("������Ϣ�޸�ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_query() throws Exception {//���з�����Ϣ��ѯ
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from clothinfo";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("���α��\t����\t����\t����\t�����");
			while (resultSet.next()) {
				String id = resultSet.getString("cloth_num");
				String name = resultSet.getString("cloth_name");
				int lbid = resultSet.getInt("lbid");
				int single_price = resultSet.getInt("single_price");
				int cloth_mount = resultSet.getInt("cloth_mount");
				System.out.println(id + "\t" + name + "\t" + lbid + "\t" + single_price + "\t" + cloth_mount);
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}
	
	public void clothlb_info_query() throws Exception {//���ݷ�������ѯ
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("������Ҫ��ѯ���ε����");
			int leibie = scanner.nextInt();
			scanner.nextLine();
			String sql = "select cloth_num,cloth_name,clothinfo.lbid,single_price,cloth_mount,lb_name,lb_sfsh from clothinfo,clothlb where clothinfo.lbid = "+leibie+" and clothinfo.lbid=clothlb.lbid;";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("���α��\t����\t����\t����\t�����\t�������\t�𻵳̶�");
			while (resultSet.next()) {
				String id = resultSet.getString("cloth_num");
				String name = resultSet.getString("cloth_name");
				int lbid = resultSet.getInt("lbid");
				int single_price = resultSet.getInt("single_price");
				int cloth_mount = resultSet.getInt("cloth_mount");
				String lb_name = resultSet.getString("lb_name");
				String shcd = resultSet.getString("lb_sfsh");
				System.out.println(id + "\t" + name + "\t" + lbid + "\t" + single_price + "\t" + cloth_mount+ "\t" +lb_name+ "\t" +shcd);
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
