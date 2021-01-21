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
			System.out.println("**1.管理员信息添加**");
			System.out.println("**2.管理员信息删除**");
			System.out.println("**3.管理员信息修改**");
			System.out.println("**4.管理员信息查询**");
			System.out.println("**5.出库订单管理***");
			System.out.println("**6.入库订单管理***");
			System.out.println("**7.退出*********");
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

	public void admin_info_add() throws Exception {//管理员信息的添加
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要添加管理员的工号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要添加管理员的姓名：");
			String name = scanner.nextLine();
			System.out.println("请输入要添加管理员的联系电话：");
			String tel = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into admin values (" + num + ",'" + name + "'" + ",'" + tel + "');";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("管理员信息添加成功");
			} else {
				System.out.println("管理员信息添加失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_delete() throws Exception {//管理员信息的删除
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要删除的管理员工号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from admin where adminnum = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("管理员信息删除成功");
			} else {
				System.out.println("管理员信息删除失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_modify() throws Exception {//管理员信息的修改
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要修改管理员的工号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要修改管理员的姓名：");
			String name = scanner.nextLine();
			System.out.println("请输入要修改管理员的联系电话：");
			String tel = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update admin set admin_name= '" + name + "',admin_tel='" + tel + "' where adminnum=" + num
					+ ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("管理员信息修改成功");
			} else {
				System.out.println("管理员信息修改失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void admin_info_query() throws Exception {//管理员信息的查询
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from admin";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("工号\t姓名\t联系电话");
			while (resultSet.next()) {
				int id = resultSet.getInt("adminnum");
				String name = resultSet.getString("admin_name");
				String tel = resultSet.getString("admin_tel");
				System.out.println(id + "\t" + name + "\t" + tel);
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}
}
