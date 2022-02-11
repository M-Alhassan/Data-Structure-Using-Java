//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
	private DLLNode<T> head, tail;

	public DLL() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void setToNull() {
		head = tail = null;
	}

	public T firstEl() {
		if (head != null)
			return head.info;
		else
			return null;
	}

	public void addToHead(T el) {
		if (head != null) {
			head = new DLLNode<T>(el, head, null);
			head.next.prev = head;
		} else
			head = tail = new DLLNode<T>(el);
	}

	public void addToTail(T el) {
		if (tail != null) {
			tail = new DLLNode<T>(el, null, tail);
			tail.prev.next = tail;
		} else
			head = tail = new DLLNode<T>(el);
	}

	public T deleteFromHead() {
		if (isEmpty())
			return null;
		T el = head.info;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else { // if more than one node in the list;
			head = head.next;
			head.prev = null;
		}
		return el;
	}

	public T deleteFromTail() {
		if (isEmpty())
			return null;
		T el = tail.info;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else { // if more than one node in the list;
			tail = tail.prev;
			tail.next = null;
		}
		return el;
	}

	public void printAll() {
		for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info + " ");
		System.out.println();
	}

	public T find(T el) {
		DLLNode<T> tmp;
		for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
			;
		if (tmp == null)
			return null;
		else
			return tmp.info;
	}

	public void printReverse() {
		DLLNode<T> tmp = new DLLNode<T>();
		if (isEmpty()) {
			System.out.println("The list is empty");
		} else if (head == tail) {
			System.out.println(head.info);
		} else {
			tmp = tail;
			while (tmp != null) {
				System.out.print(tmp.info + " ");
				tmp = tmp.prev;
			}
			System.out.println();
		}
	}

	public void delete7() {
		DLLNode<T> tmp = new DLLNode<T>();
		DLLNode<T> prevNode = new DLLNode<T>();
		if (isEmpty()) {
			System.out.println("The list is empty");
		} else {
			tmp = head;
			for (int i = 0; i < 6; i++) { //go to the 7th node in the list
				if (tmp.next == null) {
					System.out.println("There is no 7th element in the list");
				} else {
					tmp = tmp.next;
				}
			}
			if (tmp == tail) {	//if the 7th element was the last
				tail = tmp.prev;
				tail.next = null;
			} else {	//connecting the 6th node with the 8th and deleting the 7th node
			prevNode = tmp.prev;
			prevNode.next = tmp.next;
			tmp = null;
			}
		}
	}

	public void insertAlternate(DLL<T> newList) {
		DLLNode<T> tmp1 = head;
		DLLNode<T> tmp2 = newList.head;
		int len1 = 0;	//first list's length
		int len2 = 0;	//new list's length
		if (isEmpty()) {
			System.out.println("The first list is empty");
			return;
		}
		if (newList.isEmpty()) {
			System.out.println("The new list is empty");
		}

		while (tmp1 != null) { 	//to count the first list's length
			len1++;
			tmp1 = tmp1.next;
		}
		
		while (tmp2 != null) {	//to count the new list's length
			len2++;
			tmp2 = tmp2.next;
		}
		if (len1 != len2) {
			System.out.println("The lists have different lengths");
			return;
		} else {
			tmp1 = head;
			tmp2 = newList.head;
			while (tmp1.next != null) {
				newList.head = tmp2.next;
				tmp2.next = tmp1.next;
				tmp2.prev = tmp1;
				tmp1.next.prev = tmp2;
				tmp1.next = tmp2;
				tmp2 = newList.head;
				tmp1 = tmp1.next;
				tmp1 = tmp1.next;
			}
			tmp1.next = tmp2;
			tmp2.prev = tmp1;
			tmp2.next = null;
		}
	}
}
