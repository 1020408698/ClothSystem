package ClothSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RkManage {
	public void run() throws Exception {
		boolean flag = true;
		while (flag) {
			System.out.println("*********************");
			System.out.println("**1.������ⶩ�����*****");
			System.out.println("**2.������ⶩ��ɾ��*****");
			System.out.println("**3.������ⶩ���޸�*****");
			System.out.println("**4.������ⶩ����ѯ*****");
			System.out.println("**5.�˳�**************");
			int choice;
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				cloth_rk_add();
				break;
			}
			case 2: {
				cloth_rk_delete();
				break;
			}
			case 3: {
				cloth_rk_modify();
				break;
			}
			case 4: {
				cloth_rk_query();
				break;
			}
			case 5: {
				flag = false;
				break;
			}
			}
		}
	}

	public void cloth_rk_add() throws Exception {//��ⵥ�ŵ����
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ��ӵ���ⵥ�ţ�");
			String num = scanner.nextLine();
			System.out.println("������Ҫ�����ⵥ���ε����ƣ�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ�����ⵥ���ε�������");
			int count = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ�����ⵥ���ε�ʱ�䣺");
			String time = scanner.nextLine();
			System.out.println("������Ҫ��ӷ�����������Ա���ţ�");
			int id = scanner.nextInt();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into rkmanage values ('" + num + "','" + name + "'" + "," + count + ",'" + time + "',"
					+ id + ");";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			String sql1 = "update clothinfo,rkmanage set cloth_mount = cloth_mount + "+count +" where cloth_num = '"+name+"' and rkmanage.cloth_name=clothinfo.cloth_num;";
			Statement statement1 = conn.createStatement();
			int result1 = statement1.executeUpdate(sql1);
			if (result > 0 || result1 >0) {
				System.out.println("��ⶩ����ӳɹ�");
			} else {
				System.out.println("��ⶩ�����ʧ��");
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

	public void cloth_rk_delete() throws Exception {//��ⵥ�ŵ�ɾ��
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫɾ������ⵥ�ţ�");
			String num = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from rkmanage where rk_id = '" + num + "';";
			String sql2 = "select * from rkmanage where rk_id = '" + num + "';";
			Statement statement1 = conn.createStatement();
			ResultSet resultSet = statement1.executeQuery(sql2);
			int count = 0;
			String name = null;
			while (resultSet.next()) {
				count = resultSet.getInt("rk_mount");
				name = resultSet.getString("cloth_name");
			}
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			String sql1 = "update clothinfo,rkmanage set cloth_mount = cloth_mount - "+count +" where cloth_num = '"+name+"' and rkmanage.cloth_name=clothinfo.cloth_num;";
			Statement statement2 = conn.createStatement();
			int result2 = statement2.executeUpdate(sql1);
			if (result > 0 || result2>0) {
				System.out.println("��ⶩ��ɾ���ɹ�");
			} else {
				System.out.println("��ⶩ��ɾ��ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_rk_modify() throws Exception {//��ⵥ�ŵ��޸�
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ�޸ĵ���ⵥ�ţ�");
			String num = scanner.nextLine();
			System.out.println("������Ҫ�޸���ⵥ�����ƣ�");
			String name = scanner.nextLine();
			System.out.println("������Ҫ�޸���ⵥ��������");
			int count = scanner.nextInt();
			scanner.nextLine();
			System.out.println("������Ҫ�޸���ⵥ��ʱ�䣺");
			String time = scanner.nextLine();
			System.out.println("������Ҫ�޸���ⵥ�Ĺ���Ա���ţ�");
			int id = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql1 = "select * from rkmanage where rk_id = '" + num + "';";
			Statement statement1 = conn.createStatement();
			ResultSet resultSet1 = statement1.executeQuery(sql1);
			int count1 = 0;
			String name1 = null;
			while (resultSet1.next()) {
				count1 = resultSet1.getInt("rk_mount");
				name1 = resultSet1.getString("cloth_name");
			}
			System.out.println(count1);
			if(count<count1){//20 50
				String sql2 = "update clothinfo,rkmanage set cloth_mount = cloth_mount - "+(count1-count) +" where cloth_num = '"+name1+"' and rkmanage.cloth_name=clothinfo.cloth_num;";
				Statement statement2 = conn.createStatement();
				int result2 = statement2.executeUpdate(sql2);
			}else{
				String sql2 = "update clothinfo,rkmanage set cloth_mount = cloth_mount + "+(count-count1) +" where cloth_num = '"+name1+"' and rkmanage.cloth_name=clothinfo.cloth_num;";
				Statement statement2 = conn.createStatement();
				int result2 = statement2.executeUpdate(sql2);
			}
			String sql = "update rkmanage set cloth_name= '" + name + "',rk_mount=" + count + ",rk_time='" + time
					+ "',adminnum=" + id + " where rk_id='" + num + "';";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("��ⵥ�����޸ĳɹ�");
			} else {
				System.out.println("��ⵥ�����޸�ʧ��");
			}
			System.out.println("�Ƿ񷵻��˳���y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_rk_query() throws Exception {//��ⶩ����ѯ
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// ����������
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // ���ݿ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ��û�����
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from rkmanage";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("��ⵥ��\t��������\t�������\t���ʱ��\t����Ա����");
			while (resultSet.next()) {
				String id = resultSet.getString("rk_id");
				String name = resultSet.getString("cloth_name");
				int count = resultSet.getInt("rk_mount");
				String time = resultSet.getString("rk_time");
				int adminnum = resultSet.getInt("adminnum");
				System.out.println(id + "\t" + name + "\t" + count + "\t" + time + "\t" + adminnum);
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
