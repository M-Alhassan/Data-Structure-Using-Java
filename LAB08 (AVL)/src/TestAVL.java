import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class TestAVL {
	public static void main(String[] args) {
		// Example which works with Left Rotation
		AVLTree<String> t = new AVLTree<String>();
		for (int i = 1; i <= 5; i++)
			t.insertAVL("a" + i);
		t.breadthFirst();
		System.out.println();
//===================Exercise 1==================
		System.out.println("============Exercise 1===========");
		t.rotateLeft();
		t.breadthFirst();
		System.out.println("");
		t.rotateLeftRight();
		
//===================Exercise 2==================
		System.out.println("=============Exercise 2===========");
		AVLTree<Integer> t2 = new AVLTree<Integer>();
		int[] values = { 8, 14, 12, 18, 23, 20, 15, 13, 7, 16 };
		for (int i = 0; i < values.length; i++) {
			t2.insertAVL(values[i]);
		}
		t2.breadthFirst();
		System.out.println("");
		t2.breadthFirst();
		System.out.println("");
		t2.deleteAVL(13);
		t2.breadthFirst();
		System.out.println("");

//===================Exercise 3==================
		System.out.println("============Exercise 3===========");
		AVLTree<String> t3 = new AVLTree<String>();
		try {
			String inputFileName = "sampletextfile.txt";
			FileReader fr = new FileReader(new File(inputFileName));
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			String[] words = s.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (!t3.isInTree(words[i])) {
					t3.insert(words[i]);
				}
			}
			t3.inorder();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}