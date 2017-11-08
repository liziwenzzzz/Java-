package four;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("input the path of file:");
		String path = new Scanner(System.in).nextLine();
		Helper it = new Helper();
		it.getFileContent(path);
		System.out.println("1.get count of letter\n2.get count of word");
		int flag = 0;
		Scanner input = new Scanner(System.in);
		flag = input.nextInt();
		switch (flag) {
		case 1:
			it.countLetter();
			it.showLetterCount();
			break;
		case 2:
			it.countWord();
			it.showWordCount();
			break;
		default:
			System.out.println("wrong");
		}
	}
}
