package four;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	private StringBuilder content;
	private int[] letterCount = new int[(int) ('z' - 'a' + 1 + 'Z' - 'A' + 1)];
	private Map<String, Integer> wordCount = new HashMap<>();
	private BufferedReader br;

	private void getFileStream(String path) throws IOException {
		File f = new File(path);
		InputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		br = new BufferedReader(isr);
	}

	private void closeFileStream() throws IOException {
		if (br != null)
			br.close();
	}

	public void getFileContent(String path) throws IOException {
		getFileStream(path);
		content = new StringBuilder();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			content.append(temp);
		}
		closeFileStream();
	}

	public void countLetter() {
		char[] c = new char[content.length()];
		content.getChars(0, content.length(), c, 0);
		for (char i : c) {
			if (Character.isLowerCase(i)) {
				letterCount[i - 'a']++;
			} else if (Character.isUpperCase(i)) {
				letterCount[i - 'A' + 26]++;
			}
		}
	}

	// ºöÂÔ´óÐ¡Ð´
	public void countWord() {
		Pattern p = Pattern.compile("\\b([a-zA-Z'-]+)[:,.!?]?\\b", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(content);
		while (m.find()) {
			String t = m.group();
			t = t.toLowerCase();
			wordCount.put(t, wordCount.get(t) == null ? 1 : wordCount.get(t) + 1);
		}
	}

	public void showWordCount() {
		System.out.println(wordCount);
	}

	public void showLetterCount() {
		for (int i = 0; i < 26; i++) { // lowercase
			if (letterCount[i] != 0)
				System.out.println((char) (i + 'a') + ":" + letterCount[i]);
		}
		for (int i = 26; i < 26 + 26; i++) { // uppercase
			if (letterCount[i] != 0)
				System.out.println((char) (i + 'A' - 26) + ":" + letterCount[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		Helper it = new Helper();
		it.getFileContent("D:\\Eclipse\\Java-practice\\four\\te.txt");
		it.countLetter();
		it.showLetterCount();

		it.countWord();
		it.showWordCount();
	}

}