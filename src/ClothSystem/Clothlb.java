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
			System.out.println("**1.服饰类别信息添加**");
			System.out.println("**2.服饰类别信息删除**");
			System.out.println("**3.服饰类别信息修改**");
			System.out.println("**4.服饰类别信息查询**");
			System.out.println("**5.退出*********");
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

	public void cloth_lb_add() throws Exception {//服饰类别信息的添加
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要添加服饰的类别号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要添加服饰的类别名称：");
			String name = scanner.nextLine();
			System.out.println("请输入要添加的服饰是否破损：");
			String ps = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into clothlb values (" + num + ",'" + name + "'" + ",'" + ps + "');";
			System.out.println(sql);
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("服饰类别信息添加成功");
			} else {
				System.out.println("服饰类别信息添加失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_delete() throws Exception {//服饰类别信息的删除
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要删除的服饰类别编号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from clothlb where lbid = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("服饰类别信息删除成功");
			} else {
				System.out.println("服饰类别信息删除失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_modify() throws Exception {//服饰类别的修改
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要修改服饰类别信息的类别号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要修改服饰类别信息的名称：");
			String name = scanner.nextLine();
			System.out.println("请输入要修改服饰类别信息的破损度：");
			String ps = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update clothlb set lb_name= '" + name + "',lb_sfsh='" + ps + "';";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("服饰类别信息修改成功");
			} else {
				System.out.println("服饰类别信息修改失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_lb_query() throws Exception {//服饰类别的查询
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from clothlb";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("类别号\t类别名称\t是否破损");
			while (resultSet.next()) {
				int id = resultSet.getInt("lbid");
				String name = resultSet.getString("lb_name");
				String pString = resultSet.getString("lb_sfsh");
				System.out.println(id + "\t" + name + "\t" + pString);
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
