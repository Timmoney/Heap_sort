class HeapSort{

	void heapSort(int arr[]){
		int n = arr.length;

		//building heap
		for(int i=n/2-1; i>=0; i--)
			heapify(arr, n, i);

		//swap last element with the first element
		for(int i=n-1; i>=0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			//heapify --> swap
			heapify(arr, i, 0);
		}
	}

	//i is index, n is the size of arr[], this is going to creat max heap
	void heapify(int arr[], int n, int i){
		
		//those are the index representation
		int largest = i;
		int l = 2*i + 1; //left
		int r = 2*i + 2; //right

		//left child is larger than root
		if(l < n && arr[l] > arr[largest])
			largest = l;

		//right child is larger 
		if(r < n && arr[r] > arr[largest])
			largest = r;
		
		if(largest != i){
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			//sub-tree
			heapify(arr, n, largest);
		}
	}

	//prints the arrays
	void printArray(int arr[]){
		int n = arr.length;

		for(int i=0; i<n; i++)
			System.out.println(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {600,55,44,324,22,10};

		HeapSort obj = new HeapSort();

		obj.heapSort(arr);
		System.out.println("Sorted array");
		obj.printArray(arr);
	}
}