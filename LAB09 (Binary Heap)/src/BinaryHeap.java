import java.util.Arrays;

public class BinaryHeap {
	protected Comparable array[];
	int count;

	public BinaryHeap(int i) {
		array = new Comparable[i + 1];
	}

	public BinaryHeap(Comparable[] comparable) {
		this(comparable.length);
		for (int i = 0; i < comparable.length; i++)
			array[i + 1] = comparable[i];

		count = comparable.length;

		// buildHeapTopDown(); PART OF Q. 1
		buildHeapBottomUp(comparable);
	}

	private void buildHeapBottomUp(Comparable[] comparable) {
		// Q1
		for (int i = 0; i < comparable.length; i++)
			array[i + 1] = comparable[i];
		count = comparable.length;

		int paranet = count / 2;
		while (paranet > 0) {
			percolateDown(paranet);
			paranet--;
		}

	}

	private void buildHeapTopDown(Comparable[] comparable) {
		// Q1
		for (int i = 0; i < comparable.length; i++) {
			enqueue(comparable[i]);
		}
	}

	public void percolateDown(int index) {
		int child = index * 2;
		while (child <= count) {
			if (child + 1 <= count && array[child].compareTo(array[child + 1]) < 0)
				child++;
			if (array[index].compareTo(array[child]) < 0)
				swap(index, child, array);

			index = child;
			child = index * 2;
		}
	}

	private void percolateUp(int index) {
		// Q1
		int parent = index / 2;
		while (index > 1 && array[index].compareTo(array[parent]) > 0) {
			swap(parent, index, array);
			index /= 2;
			parent = index / 2;
		}

	}

	private void swap(int first, int second, Comparable[] array) {
		Comparable tmp;

		tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}

	public void purge() {
		while (count > 0)
			array[count--] = null;
	}

	public void enqueue(Comparable comparable) {
		int index = ++count;

		// percolate up via a gap
		while (index > 1 && array[index / 2].compareTo(comparable) > 0) {
			array[index] = array[index / 2];
			index = index / 2;
		}

		array[index] = comparable;
	}

	public Comparable findMin() {
		return array[1];
	}

	public Comparable dequeueMax() {
		Comparable minItem = array[1];
		array[1] = array[count];
		count--;
		percolateDown(1);
		return minItem;
	}

	public Comparable[] heapSort() {
		Comparable[] x = new Comparable[count];
		int total = count;
		for (int i = 0; i < total; i++) {
			x[i] = dequeueMax();
		}
		return x;
	}

	public boolean isFull() {
		return count == array.length - 1;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public String toString() {
		Comparable[] tempArray = new Comparable[array.length - 1];
		System.arraycopy(array, 1, tempArray, 0, array.length - 1);
		return Arrays.toString(tempArray);

	}

	public static void main(String[] args) {
		Integer[] a = { 10, 2, 8, 9, 1, 6, 3, 4, 0, 5 };
		System.out.println("The original array is: " + Arrays.toString(a));
		BinaryHeap bh = new BinaryHeap(a);
		// builds heap bottom up: change the constructor to build it top-down
		System.out.println("\nThe heap is: " + bh);
		System.out.println("\nSorted Array is: " + Arrays.toString(bh.heapSort()));
	}
}