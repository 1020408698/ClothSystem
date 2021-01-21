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
			System.out.println("**1.服饰信息添加******");
			System.out.println("**2.服饰信息删除******");
			System.out.println("**3.服饰信息修改******");
			System.out.println("**4.所有的服饰信息查询**");
			System.out.println("**5.按服饰类别信息查询**");
			System.out.println("**6.退出************");
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

	public void cloth_info_add() throws Exception {//服饰信息增加
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要添加服饰的编号：");
			String num = scanner.nextLine();
			System.out.println("请输入要添加服饰的名字：");
			String name = scanner.nextLine();
			System.out.println("请输入要添加服饰类别id：");
			int lbid = scanner.nextInt();
			System.out.println("请输入要添加服饰单价：");
			int single_price = scanner.nextInt();
			System.out.println("请输入要添加服饰数量：");
			int cloth_mount = scanner.nextInt();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
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
					System.out.println("服饰信息添加成功");
				} else {
					System.out.println("服饰信息添加失败");
				}
			}
			else{
				System.out.println("服饰类别不存在");
				System.out.println("服饰信息添加失败");
			}
			scanner.nextLine();
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_delete() throws Exception {//服饰信息删除
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要删除的服饰编号：");
			int num = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from clothinfo where cloth_num = " + num + ";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("服饰信息删除成功");
			} else {
				System.out.println("服饰信息删除失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_modify() throws Exception {//服饰信息修改
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要修改服饰信息的编号：");
			String num = scanner.nextLine();
			System.out.println("请输入要修改服饰信息的名称：");
			String name = scanner.nextLine();
			System.out.println("请输入要修改服饰信息的类别号：");
			int lbid = scanner.nextInt();
			System.out.println("请输入要修改服饰信息的单价：");
			int single_price = scanner.nextInt();
			System.out.println("请输入要修改服饰信息的库存数：");
			int mount = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "update clothinfo set cloth_name= '" + name + "',lbid=" + lbid+",single_price="+single_price+",cloth_mount="+mount+" where cloth_num="+num+";";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("服饰信息修改成功");
			} else {
				System.out.println("服饰信息修改失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_info_query() throws Exception {//所有服饰信息查询
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from clothinfo";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("服饰编号\t名称\t类别号\t单价\t库存数");
			while (resultSet.next()) {
				String id = resultSet.getString("cloth_num");
				String name = resultSet.getString("cloth_name");
				int lbid = resultSet.getInt("lbid");
				int single_price = resultSet.getInt("single_price");
				int cloth_mount = resultSet.getInt("cloth_mount");
				System.out.println(id + "\t" + name + "\t" + lbid + "\t" + single_price + "\t" + cloth_mount);
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}
	
	public void clothlb_info_query() throws Exception {//根据服饰类别查询
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("请输入要查询服饰的类别：");
			int leibie = scanner.nextInt();
			scanner.nextLine();
			String sql = "select cloth_num,cloth_name,clothinfo.lbid,single_price,cloth_mount,lb_name,lb_sfsh from clothinfo,clothlb where clothinfo.lbid = "+leibie+" and clothinfo.lbid=clothlb.lbid;";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("服饰编号\t名称\t类别号\t单价\t库存数\t类别名称\t损坏程度");
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
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}
}
