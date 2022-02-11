public class Test {
	public static void main(String[] args) {
		SLL<String> fruitList = new SLL<String>();
		System.out.print("After inserting Mango the list is>> ");
		fruitList.addToTail("Mango");
		fruitList.printAll();
		fruitList.addToTail("Avocado");
		System.out.print("After inserting Avocado the list is>> ");
		fruitList.printAll();
		fruitList.addToTail("Lime");
		System.out.print("After inserting Lime the list is>> ");
		fruitList.printAll();
		fruitList.addToTail("Peach");
		System.out.print("After inserting Peach the list is>> ");
		fruitList.printAll();
		fruitList.addToTail("Apple");
		System.out.print("After inserting Apple the list is>> ");
		fruitList.printAll();
		System.out.println("");
		fruitList.insertBefore("Fruits", "Apple");
		System.out.print("After insertBefore the list is>> ");
		fruitList.printAll();
		fruitList.insertAfter("Watermelon", "Lime");
		System.out.print("After insertAfter the list is>> ");
		fruitList.printAll();
		System.out.println("");
		fruitList.deleteBefore("Apple");
		System.out.print("After deleteBefore the list is>> ");
		fruitList.printAll();
		fruitList.deleteAfter("Lime");
		System.out.print("After deleteAfter the list is>> ");
		fruitList.printAll();
	}
}