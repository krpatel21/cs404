import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        int binaryTree [] = new int[10];

        System.out.println("Input 10 integers seperated by spaces");

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < binaryTree.length; i++) {
            binaryTree[i] = s.nextInt();
        }
    }
}
