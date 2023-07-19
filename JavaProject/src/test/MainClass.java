package test;

public class MainClass {
	public static void main(String[] args) {
		printNames("a", "b", "c");
	}

	public static void printNames(String... names) {
		for (String tmp : names) {
			System.out.println(tmp);
		}

	}
}
