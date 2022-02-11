//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
	protected SLLNode<T> head, tail;

	public SLL() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(T el) {
		head = new SLLNode<T>(el, head);
		if (tail == null)
			tail = head;
	}

	public void addToTail(T el) {
		if (!isEmpty()) {
			tail.next = new SLLNode<T>(el);
			tail = tail.next;
		} else
			head = tail = new SLLNode<T>(el);
	}

	public T deleteFromHead() { // delete the head and return its info;
		if (isEmpty())
			return null;
		T el = head.info;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else
			head = head.next;
		return el;
	}

	public T deleteFromTail() { // delete the tail and return its info;
		if (isEmpty())
			return null;
		T el = tail.info;
		if (head == tail) // if only one node in the list;
			head = tail = null;
		else { // if more than one node in the list,
			SLLNode<T> tmp; // find the predecessor of tail;
			for (tmp = head; tmp.next != tail; tmp = tmp.next)
				;
			tail = tmp; // the predecessor of tail becomes tail;
			tail.next = null;
		}
		return el;
	}

	public void delete(T el) { // delete the node with an element el;
		if (!isEmpty())
			if (head == tail && el.equals(head.info)) // if only one
				head = tail = null; // node on the list;
			else if (el.equals(head.info)) // if more than one node on the list;
				head = head.next; // and el is in the head node;
			else { // if more than one node in the list
				SLLNode<T> pred, tmp;// and el is in a nonhead node;
				for (pred = head, tmp = head.next; tmp != null
						&& !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
					;
				if (tmp != null) { // if el was found;
					pred.next = tmp.next;
					if (tmp == tail) // if el is in the last node;
						tail = pred;
				}
			}
	}

	public void printAll() {
		for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info + " ");
		System.out.println();
	}

	public boolean isInList(T el) {
		SLLNode<T> tmp;
		for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
			;
		return tmp != null;
	}

	public int length() {
		int count = 0;
		SLLNode<T> tmp = head;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}

	public void insertBefore(T newElm, T existingElm) {
		SLLNode<T> pre = null, temp;
		temp = head;
		if (temp.info.equals(existingElm)) {
			SLLNode<T> newNode = new SLLNode<T>(newElm, head);
			head = newNode;
		} else {
			while (!temp.info.equals(existingElm)) {
				pre = temp;
				temp = temp.next;
				if (temp == null)
					break;
			}
			if (temp == null) {
				System.out.println("Element " + existingElm + " does not exist.");
				return;
			} else {
				SLLNode<T> newNode = new SLLNode<T>(newElm, temp);
				pre.next = newNode;
			}
		}
	}

	public void insertAfter(T newElm, T existingElm) {
		SLLNode<T> currentNode;
		currentNode = head;
		if (currentNode.info.equals(existingElm)) {
			SLLNode<T> newNode = new SLLNode<T>(newElm, head.next);
			head.next = newNode;
		} else {
			while (!currentNode.info.equals(existingElm)) {
				currentNode = currentNode.next;
				if (currentNode == null)
					break;
			}
			if (currentNode == null) {
				System.out.println("Element " + existingElm + " does not exist.");
				return;
			}
			SLLNode<T> newNode = new SLLNode<T>(newElm, currentNode.next);
			currentNode.next = newNode;
		}
	}

	// I manually deleted here
	public void deleteBefore(T existingElem) {
		SLLNode<T> currentNode, previousNode;
		currentNode = head;
		previousNode = head;
		if (currentNode.info.equals(existingElem)) {
			System.out.println("There is no element before " + existingElem);
			return;
		}
		while (!currentNode.next.info.equals(existingElem)) {
			previousNode = currentNode;
			currentNode = currentNode.next;
			if (currentNode.next == null) {
				System.out.println("Element " + existingElem + " does not exist");
				return;
			}
		}

		if (currentNode == head) {
			head = head.next;
			return;
		}
		previousNode.next = currentNode.next;
	}

	// I used the delete method here
	public void deleteAfter(T existingElem) {
		SLLNode<T> currentNode, nextNode;
		currentNode = head;
		if (currentNode.info.equals(existingElem)) {
			if (currentNode.next != null) {
				delete(currentNode.next.info);
			}
		}
		while (!currentNode.info.equals(existingElem)) {
			currentNode = currentNode.next;
			if (currentNode == null) {
				System.out.println("Element " + existingElem + " does not exist");
				return;
			}
		}
		if (currentNode.next == null) {
			System.out.println("You can not delete an element after " + existingElem);
			return;
		}
		delete(currentNode.next.info);
	}
}
