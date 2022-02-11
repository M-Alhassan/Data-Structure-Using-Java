import java.util.Scanner;

public class HashTable<T> {

	private Entry[] entryList;
	private int n;
	private int count;

	public HashTable() {
		n = 100;
		entryList = new Entry[n];
		for (int i = 0; i < n; i++) {
			Entry newEntry = new Entry();
			entryList[i] = newEntry;
		}
		count = 0;
	}

	public HashTable(int n) {
		this.n = n;
		entryList = new Entry[n];
		for (int i = 0; i < n; i++) {
			Entry newEntry = new Entry();
			entryList[i] = newEntry;
		}
		count = 0;
	}

	private int getHash(T dataObject) {
		return (dataObject.hashCode()) % n;
	}

	public int findNextVacantSlot(T dataObject) {
		int hash = getHash(dataObject);
		if (count == n)
			return hash;
		while (entryList[hash].status != "E" && entryList[hash].hash() != dataObject.hashCode()) {
			System.out.println("Collision at position " + hash + ". Linear probing");
			hash = (hash + 1) % n;
		}
		return hash;
	}

	public boolean insert(T dataObject) {
		int hash = findNextVacantSlot(dataObject);
		if (entryList[hash].status != "dataObject") {
			entryList[hash].dataObject = dataObject;
			entryList[hash].status = "dataObject";
			count += 1;
			return true;
		}
		return false;
	}

	public int checkPresent(T dataObject) {
		int hash = getHash(dataObject);
		int iterations = 0;
		while (iterations < n && entryList[hash].status != "E" && entryList[hash].hash() != dataObject.hashCode()) {
			System.out.println("The status at position " + hash + " is " + entryList[hash].status + ". Linear probing");
			hash = (hash + 1) % n;
			iterations += 1;
		}
		if (entryList[hash].status == "dataObject" && entryList[hash].hash() == dataObject.hashCode())
			return hash;
		return -1;
	}

	public boolean find(T dataObject) {
		int i = checkPresent(dataObject);
		if (i == -1)
			return false;
		return true;
	}

	public boolean delete(T dataObject) {
		int i = checkPresent(dataObject);
		if (i != -1) {
			entryList[i].status = "D";
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		for (int i = 0; i < n; i++) {
			if (entryList[i].status == "dataObject") {
				System.out.print(entryList[i].toString() + " ");
			}
			System.out.println(entryList[i].status);
		}
		return "";
	}

	public static void main(String args[]) {
		int c;
		Scanner kb = new Scanner(System.in);

		System.out.println("Enter the size of the Hashtable: ");
		c = kb.nextInt();

		HashTable map = new HashTable(c);

		while (true) {
			System.out.println("1) Insertion\n2) Deletion\n3) Find\n4) Print\n5) Exit\nChoose an operation: ");
			c = kb.nextInt();

			boolean status = true;
			switch (c) {
			case 1:
				System.out.println("Enter the element to insert: ");
				c = kb.nextInt();

				status = map.insert(c);

				if (status) {
					System.out.println(c + " inserted!\n");
				} else {
					System.out.println(c + " is not inserted\n");
				}
				break;

			case 2:
				System.out.println("Enter the element delete: ");
				c = kb.nextInt();

				status = map.delete(c);

				if (status) {
					System.out.println(c + " deleted!\n");
				} else {
					System.out.println(c + " is not deleted\n");
				}
				break;

			case 3:
				System.out.println("Enter the element search for: ");
				c = kb.nextInt();

				status = map.find(c);

				if (status) {
					System.out.println(c + " is found\n");
				} else {
					System.out.println(c + " is not found\n");
				}
				break;

			case 4:
				map.toString();
				break;

			case 5:
				return;

			default:
				System.out.println("option not valid\n");
			}
		}
	}
}
