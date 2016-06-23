import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PatelBankAccountTestDriver 
{

	public static void main(String[] args) throws FileNotFoundException, 
	IOException, QueueUnderflowException 
	{

		BinarySearchTree tree = new BinarySearchTree();
		
		// put in the correct file path. Your's might be different from mine.
		Scanner input = new Scanner(new File("../Assignment 5/src/input.txt"));
		Scanner conIn = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		String name = "";
		int accountNumber;
		double balance;
		boolean keepGoing;
		int operation;
		String skip;
		keepGoing = true;
		
		while (keepGoing) {
			System.out.println("Choose and operation");
			System.out.println("1 add");
			System.out.println("2 remove");
			System.out.println("3 isEmpty");
			System.out.println("4 toString");
			System.out.println("5 size");
			System.out.println("6 contains");
			System.out.println("7 terminate");
	
			if(conIn.hasNextInt())
				operation = conIn.nextInt();
			else{
				System.out.println("Error you must enter an integer");
				System.out.println("Terminating Test");
				return;
			}
			skip = conIn.nextLine();
			switch(operation)
			{
			case 1:
				//while (input.hasNext()) 
				//{
					for (int i = 0; i < 1; i++) 
					{
						name = input.next();
						accountNumber = input.nextInt();
						balance = input.nextDouble();
						KaushalAccountItemType a = new KaushalAccountItemType(name,
								accountNumber, balance);

						tree.add(a);
						
					}
					writer.println("add performed");
				//}
				break;
			
			case 2:				
					tree.remove(new KaushalAccountItemType("Kaushal", 1,50000));
					writer.println("remove performed");
				
				break;
			
			case 3: 
				writer.println(tree.isEmpty());
				break;
				
			case 4: 
				tree.reset(1);
				writer.println(tree.inOrderQueue.toString());
				tree.reset(2);
				writer.println(tree.preOrderQueue.toString());
				tree.reset(3);
				writer.println(tree.postOrderQueue.toString());
			
			case 5: 
				writer.println(tree.size());
				break;
			case 6: 
				writer.println(tree.contains(new KaushalAccountItemType("Kaushal", 1,50000)));
				break;
			
			case 7: 
				keepGoing = false;
				break;
			}
		}
				//System.out.println(stack);
				
			writer.close();	
				
	}
}
