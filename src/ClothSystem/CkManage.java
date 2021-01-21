package ClothSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CkManage {
	public void run() throws Exception {
		boolean flag = true;
		while (flag) {
			System.out.println("*********************");
			System.out.println("**1.服饰出库订单添加*****");
			System.out.println("**2.服饰出库订单删除*****");
			System.out.println("**3.服饰出库订单修改*****");
			System.out.println("**4.服饰出库订单查询*****");
			System.out.println("**5.退出**************");
			int choice;
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				cloth_ck_add();
				break;
			}
			case 2: {
				cloth_ck_delete();
				break;
			}
			case 3: {
				cloth_ck_modify();
				break;
			}
			case 4: {
				cloth_ck_query();
				break;
			}
			case 5: {
				flag = false;
				break;
			}
			}
		}
	}

	public void cloth_ck_add() throws Exception {//出库订单的添加
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要添加的出库单号：");
			String num = scanner.nextLine();
			System.out.println("请输入要添加出库单服饰的名称：");
			String name = scanner.nextLine();
			System.out.println("请输入要添加出库单服饰的数量：");
			int count = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要添加出库单服饰的时间：");
			String time = scanner.nextLine();
			System.out.println("请输入要添加服饰数量管理员工号：");
			int id = scanner.nextInt();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into ckmanage values ('" + num + "','" + name + "'" + "," + count + ",'" +time 
					+ "'," + id + ");";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			String sql2 = "select cloth_mount from clothinfo where cloth_num = '"+num+"';";
			int res = 0;
			Statement sta = conn.createStatement();
			ResultSet resultSet = sta.executeQuery(sql2);
			while(resultSet.next()){
				res = resultSet.getInt("cloth_mount");
			}
			if (res<count) {
				System.out.println("库存数不足");
				System.out.println("出库订单添加失败");
			}else{
				String sql1 = "update clothinfo,ckmanage set cloth_mount = cloth_mount - "+count +" where cloth_num = '"+name+"' and ckmanage.cloth_name=clothinfo.cloth_num;";
				Statement statement1 = conn.createStatement();
				int result1 = statement1.executeUpdate(sql1);
				if (result > 0 || result1>0) {
					System.out.println("出库订单添加成功");
				} else {
					System.out.println("出库订单添加失败");
				}				
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

	public void cloth_ck_delete() throws Exception {//出库订单的删除
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要删除的出库单号：");
			String num = scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql2 = "select * from ckmanage where ck_id = '" + num + "';";
			Statement statement1 = conn.createStatement();
			ResultSet resultSet = statement1.executeQuery(sql2);
			int count = 0;
			String name = null;
			while (resultSet.next()) {
				count = resultSet.getInt("ck_mount");
				name = resultSet.getString("cloth_name");
			}
			String sql1 = "update clothinfo,ckmanage set cloth_mount = cloth_mount + "+count +" where cloth_num = '"+name+"' and ckmanage.cloth_name=clothinfo.cloth_num;";
			Statement statement2 = conn.createStatement();
			int result2 = statement2.executeUpdate(sql1);
			String sql = "delete from ckmanage where ck_id = '" + num + "';";
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0 ||result2>0) {
				System.out.println("出库订单删除成功");
			} else {
				System.out.println("出库订单删除失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_ck_modify() throws Exception {//出库订单的修改
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要修改的出库单号：");
			String num = scanner.nextLine();
			System.out.println("请输入要修改出库单的名称：");
			String name = scanner.nextLine();
			System.out.println("请输入要修改出库单的数量：");
			int count = scanner.nextInt();
			scanner.nextLine();
			System.out.println("请输入要修改出库单的时间：");
			String time = scanner.nextLine();
			System.out.println("请输入要修改出库单的管理员工号：");
			int id = scanner.nextInt();
			scanner.nextLine();
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql1 = "select * from ckmanage where ck_id = '" + num + "';";
			Statement statement1 = conn.createStatement();
			ResultSet resultSet1 = statement1.executeQuery(sql1);
			int count1 = 0;
			String name1 = null;
			while (resultSet1.next()) {
				count1 = resultSet1.getInt("ck_mount");
				name1 = resultSet1.getString("cloth_name");
			}
			if(count<count1){
				String sql2 = "update clothinfo,ckmanage set cloth_mount = cloth_mount + "+(count1-count) +" where cloth_num = '"+name1+"' and ckmanage.cloth_name=clothinfo.cloth_num;";
				Statement statement2 = conn.createStatement();
				int result2 = statement2.executeUpdate(sql2);		
			}else{
				String sql2 = "update clothinfo,ckmanage set cloth_mount = cloth_mount - "+(count-count1) +" where cloth_num = '"+name1+"' and ckmanage.cloth_name=clothinfo.cloth_num;";
				Statement statement2 = conn.createStatement();
				int result2 = statement2.executeUpdate(sql2);
			}
			String sql = "update ckmanage set cloth_name= '" + name + "',ck_mount=" + count + ",ck_time='"+ time + "',adminnum=" + id + " where ck_id='" + num + "';";
			System.out.println(sql);
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(sql);
			if (result > 0) {
				System.out.println("出库单内容修改成功");
			} else {
				System.out.println("出库单内容修改失败");
			}
			System.out.println("是否返回退出：y/n");
			String ans = scanner.nextLine();
			if (ans.equals("y")) {
				flag = false;
			} else
				flag = true;
		}
	}

	public void cloth_ck_query() throws Exception {//出库订单的查询
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			Class.forName("com.mysql.jdbc.Driver"); //// 驱动程序名
			String url = "jdbc:mysql://localhost:3306/clothmanagesys"; // 数据库名
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from ckmanage";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("出库单号\t单号名称\t出库数量\t出库时间\t管理员工号");
			while (resultSet.next()) {
				String id = resultSet.getString("ck_id");
				String name = resultSet.getString("cloth_name");
				int count = resultSet.getInt("ck_mount");
				String time = resultSet.getString("ck_time");
				int adminnum = resultSet.getInt("adminnum");
				System.out.println(id + "\t" + name + "\t" + count + "\t" + time + "\t" + adminnum);
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
