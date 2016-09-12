class Node {
	int element;
	int i;
	int j;
 
	public Node(int element, int i, int j) {
		this.element = element;
		this.i = i;
		this.j = j;
	}
}
 
class MinHeap {
	int capacity;
	Node arr[];
	int size;
 
	public MinHeap(Node[] arr) {
		this.capacity = arr.length;
		this.size = this.capacity;
		this.arr = arr;
		buildMinHeap();
	}
 
	void swap(Node[] arr, int i, int j) {
		Node temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
 
	int parent(int i) {
		return (i-1)/2;
	}
 
	int left(int i) {
		return 2*i + 1;
	}
 
	int right(int i) {
		return 2*i + 2;
	}
 
	Node getMin() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return null;
		}
		return arr[0];
	}
 
	Node extractMin() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return null;
		}
		if(size == 1) {
			size--;
			return arr[0];
		}
 
		Node root = arr[0];
		arr[0] = arr[size-1];
		size--;
		minHeapify(0);
 
		return root;
	}
 
	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
 
		if(l < size && arr[l].element < arr[smallest].element)
			smallest = l;
		if(r < size && arr[r].element < arr[smallest].element)
			smallest = r;
		if(smallest != i) {
			swap(arr,i,smallest);
			minHeapify(smallest);
		}
	}
 
	void buildMinHeap() {
		int n = arr.length;
		for(int i = (n/2)-1;i>=0;i--)
			minHeapify(i);
	}
 
	void replaceMin(Node root) {
		arr[0] = root;
		minHeapify(0);
	}
 
	void printMinHeap() {
		for(int i=0;i<size;i++)
			System.out.print(arr[i].element + " ");
		System.out.println();
	}
}
 
class MergeKSortedArrays {
 
	static void mergeKSortedArrays(int[][] arr, int k) {
		Node[] hArr = new Node[k];
		int resultSize = 0;
		for(int i=0;i<arr.length;i++) {
			Node node = new Node(arr[i][0],i,1);
			hArr[i] = node;
			resultSize += arr[i].length;
		}
 
		MinHeap mh = new MinHeap(hArr);
 
		int[] result = new int[resultSize];
 
		for(int i=0;i<resultSize;i++) {
			Node root = mh.getMin();
			result[i] = root.element;
 
			if(root.j < arr[root.i].length)
				root.element = arr[root.i][root.j++];
			else
				root.element = Integer.MAX_VALUE;
 
			mh.replaceMin(root);
		}
 
		printArray(result);
 
	}
 
	static void printArray2D(int[][] arr) {
		for(int[] a : arr) {
			for(int i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}
 
	static void printArray(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
 
	public static void main(String[] args) {
		int[][] arr= {{2, 6, 8, 12, 34},
                     {1, 9, 20, 25, 100, 1000},
                     {23, 34, 90, 2000}};
 
		System.out.println("Arrays:");
		printArray2D(arr);
 
		mergeKSortedArrays(arr,arr.length);
	}
}
