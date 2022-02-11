public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 10; i++)
			test.addToTail("a" + i);
		
		DLL<String> test2 = new DLL<String>();
		for(int i = 0; i < 5; i++)
			test2.addToTail("B" + i);
		
		test.printAll();
//		test.insertAlternate(test2);
		test.delete7();
		test.printAll();
		
	}
}