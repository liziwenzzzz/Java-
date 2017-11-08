package three;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		jishiben test = new jishiben();
		while (true) {
			System.out.println("*****************");
			System.out.println(
					"1.add\n2.get count\n3.show all\n4.find by index\n5.delete all\n6.delete by index\n7.delete by content\n8.exit\n");
			int flag = 0;
			Scanner input = new Scanner(System.in);
			flag = input.nextInt();
			switch (flag) {
			case 1:
				System.out.println("input the document you want to add:");
				String name = input.next();

				test.add(name);
				break;
			case 2:
				System.out.println("the count is:" + test.getCount());
				break;
			case 3:
				test.showAll();
				break;
			case 4:
				System.out.println("the index is between 0 and" + test.getCount() + ":");
				int a = input.nextInt();
				test.find(a);
				break;
			case 5:
				test.deleteAll();
				break;
			case 6:
				System.out.println("the index is between 0 and" + test.getCount() + ":");
				a = input.nextInt();
				test.delete(a);
				break;
			case 7:
				System.out.println("input the document you want to delete:");
				String b = input.next();
				test.delete(b);
				break;
			case 8:
				return;
			}
		}
	}
}