package two;

import java.util.Scanner;

public class Main {

	public static Shape[] shapes = new Shape[20];

	public static Shape findByName(String name) {
		for (int i = 0; i < 20; i++) {
			if (shapes[i] != null && name.equals(shapes[i].name)) {
				return shapes[i];
			}
		}
		return null;
	}

	public static void draw(int n) {
		for (int i = 0; i < n && shapes[i] != null; i++) {
			System.out.println(
					"order:" + shapes[i].order + " shape:" + Shape.judgeType(shapes[i]) + " name:" + shapes[i].name);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int choose = 0;
		do {
			System.out.println("1.create a shape\n2.find a shape\n3.draw shapes\n4.exit");
			choose = input.nextInt();
			if (choose == 1) {
				Shape m = Shape.create();
				shapes[m.order - 1] = m;
			} else if (choose == 2) {
				System.out.println("what are you finding?input its name:");
				Scanner input2 = new Scanner(System.in);
				String nameString = input2.next();
				Shape m = findByName(nameString);
				if (m == null) {
					System.out.println(nameString + " not found");
				} else {
					System.out.println("shape:" + Shape.judgeType(m) + " " + "order:" + m.order);
				}
			} else if (choose == 3) {
				System.out.println("input the order you want to draw:");
				Scanner input2 = new Scanner(System.in);
				int drawOrder = input2.nextInt();
				draw(drawOrder);
			} else if (choose == 4) {
				System.out.println("success exit");
				System.exit(0);
			} else {
				System.out.println("Input wrong! please input again.");
			}
			System.out.println();
		} while (true);
	}
}