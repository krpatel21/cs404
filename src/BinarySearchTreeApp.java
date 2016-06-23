import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BinarySearchTreeApp {
	public static void main(String[] args) throws IOException,
			UnsupportedEncodingException {
		int count = 0;
		Scanner input = new Scanner(new File("C:/Users/Kaushal/IdeaProjects/404/input.txt"));
		// replace this with what ever the path for your file is
		BinarySearchTree tree = new BinarySearchTree();
		// this is uses the DEFCAP. put in an integer to throw an exception
		String name = "";
		int accountNumber;
		double balance;
		while (count < 9) {
			for (int i = 0; i < 3; i++) {
				name = input.next();
				accountNumber = input.nextInt();
				balance = input.nextDouble();
				KaushalAccountItemType a = new KaushalAccountItemType(name,
						accountNumber, balance);
				tree.add(a);
				count++;
			}
		}
		// System.out.println(stack);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		tree.reset(1);
		writer.println(tree.inOrderQueue.toString());
		tree.reset(2);
		writer.println(tree.preOrderQueue.toString());
		tree.reset(3);
		writer.println(tree.postOrderQueue.toString());
		writer.close();
	}

}
