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
			System.out.println("\t\t*****���ι���ϵͳ*****");
			System.out.println("\t\tһ�� ����Ա��Ϣ����");
			System.out.println("\t\t���� ������Ϣ����");
			System.out.println("\t\t���� ���������Ϣ����");
			System.out.println("\t\t�ģ� �˳�ϵͳ");
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
