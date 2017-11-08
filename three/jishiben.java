package three;

import java.util.ArrayList;
import java.util.List;

public class jishiben {
	List<String> list = new ArrayList<>();

	public int getCount() {
		return list.size();
	}

	public void add(String name) {
		list.add(name);
		System.out.println("add successfully");
	}

	public void showAll() {
		System.out.println("the all document is follow:");
		for (String record : list) {
			System.out.println(record);
		}
	}

	public void find(int index) {
		System.out.println("the order " + index + "is :");
		System.out.println(list.get(index));
	}

	public void deleteAll() {
		list.clear();
		System.out.println("delete success");
	}

	public void delete(int index) {
		list.remove(index);
		System.out.println("delete success");
	}

	public void delete(String record) {
		list.remove((Object) record);
		System.out.println("delete success");
	}
}