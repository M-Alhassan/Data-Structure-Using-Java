import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		tree.root = new BSTNode(8);
		tree.insert(4);
		tree.insert(9);
		tree.insert(2);
		tree.insert(7);
		
		System.out.println("=========================");
        System.out.print("E1: ");
		System.out.println("The number of nodes: " + tree.count(tree.root));
        System.out.print("E2: ");
        System.out.println("'4' is leaf? " + tree.isLeaf(4));
        System.out.println("    '7' is leaf? " + tree.isLeaf(7));
        System.out.print("E3: ");
		System.out.println("Number of leaves is: " + tree.countLeaves(tree.root));
        System.out.print("E4: ");
		System.out.println("Height is: " + tree.height(tree.root));
		System.out.println("=========================");
		
		System.out.println("E5:");
		ArrayList<Integer> list = new ArrayList<Integer>();
		BST<Integer> tree2 = new BST<Integer>();
		int num;
		for (int i = 0; i < 3; i++) {
			num = (int) (Math.random()*50);
			list.add(num);
			while(list.contains(num)) {
				num = (int) (Math.random()*50);
			}
			list.add(num);
		}
		
		tree2.root = new BSTNode<Integer>(list.get(0));
		for (int i = 1; i<list.size(); i++) {
			tree2.insert(list.get(i));
		}
		System.out.println("Random tree Generated.");
		System.out.println("Elements: " + list.toString() + "\n");
		System.out.println("The various traversals are>>");
		
		System.out.print("Preorder: ");
		tree2.preorder();
		System.out.println("");
		System.out.print("Inorder: ");
		tree2.inorder();
		System.out.println("");

		System.out.print("Postorder:");
		tree2.postorder();
		System.out.println("");

		System.out.print("Breadth First: ");
		tree2.breadthFirst();
	}
        
	}


