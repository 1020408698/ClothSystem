package ClothSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		int choice;
		Admin admin = new Admin();
		Clothinfo clothinfo = new Clothinfo();
		Clothlb clothlb = new Clothlb();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\t\t*****服饰管理系统*****");
			System.out.println("\t\t一： 管理员信息操作");
			System.out.println("\t\t二： 服饰信息操作");
			System.out.println("\t\t三： 服饰类别信息操作");
			System.out.println("\t\t四： 退出系统");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:{
				admin.run();
				break;
			}
			case 2:{
				clothinfo.run();
				break;
			}
			case 3:{
				clothlb.run();
				break;
			}
			case 4:
				return ;
			}
		} while (choice!=4);
	}
}
