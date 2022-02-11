public class TestTree {
	public static void main(String[] args) {
		BST<String> tree = new BST<String>();
		tree.insert("D");
		tree.insert("B");
		tree.insert("A");
		tree.insert("C");
		tree.insert("F");
		tree.insert("H");

		BST<Integer> tree2 = new BST<Integer>();
		tree2.insert(25);
		tree2.insert(20);
		tree2.insert(36);
		tree2.insert(10);
		tree2.insert(22);
		tree2.insert(30);
		tree2.insert(40);
		tree2.insert(5);
		tree2.insert(12);
		tree2.insert(28);
		tree2.insert(38);
		tree2.insert(48);

		System.out.println("Tree1:");
		tree.breadthFirst();
		System.out.println("");
		System.out.println("Path for 'A' >>" + tree.getPath("A"));
		System.out.println("Path for 'Q' >>" + tree.getPath(new String("Q")));
		System.out.println("Right leaf count >> " + tree.getRightLeafCount());
		System.out.println("Elements between 'D' and 'A' >> " + tree.rangeCounter("D", "A"));
		System.out.println("Elements between 'D' and 'A' (2nd method) >> " + tree.rangeCounter2("D", "A"));

		System.out.println("----------------------------------\nTree2:");
		tree2.breadthFirst();
		System.out.println("");
		System.out.println("Path for 22 >>" + tree2.getPath(22));
		System.out.println("Path for 29 >>" + tree2.getPath(29));
		System.out.println("Right leaf count >> " + tree2.getRightLeafCount());
		System.out.println("Elements between 25 and 12 >> " + tree2.rangeCounter(25, 12));
		System.out.println("Elements between 25 and 12 (2nd method) >> " + tree2.rangeCounter2(25, 12));

	}
}
