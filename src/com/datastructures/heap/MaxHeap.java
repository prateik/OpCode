package com.datastructures.heap;

public class MaxHeap {

	int[] heap;
	int size;

	public MaxHeap(int heapSize) {
		heap = new int[heapSize];
		size = 0;
	}

	public void insert(int data) {
		if (size == heap.length) {
			System.out.println(" Heap is Full!");
			return;
		}
		size++;
		heap[size] = data;
		
		//System.out.println(" Inserted "+data+" at location : "+size);
		moveUp(size);
	}

	public void moveUp(int index) {

		//System.out.println(" Moving Up Data "+heap[index]+" : "+" at location "+index);
		
		while (index > 1) {

			if (heap[index] > heap[index / 2]) {
				swap(index, index / 2);
			}

			index = index / 2;
		}
           
	}

	public void moveDown() {
		int index = 1;

		while (index < size) {

			if (heap[2 * index] < heap[(2 * index) + 1]) {
				swap(index, (2 * index) + 1);
				index = (index * 2) + 1;
			} else {
				swap(index, (2 * index));
				index = (index * 2);
			}

		}

	}

	public int deleteMax() {
		int max = heap[1];
		heap[1] = heap[size];
		moveDown();
		return max;
	}

	public void swap(int i1, int i2) {
		
		//System.out.println(" Swapping "+heap[i1]+" and "+heap[i2]);
		int temp = heap[i1];
		heap[i1] = heap[i2];
		heap[i2] = temp;
		
		//System.out.println(" After Swap "+heap[i1]+" and "+heap[i2]);
		
	}

	public void printHeap() {

		for (int i = 1; i <=size; i++) {
			System.out.print(heap[i] + " | ");
		}

		System.out.println();
	}

	public static void main(String[] args) {

		MaxHeap heap = new MaxHeap(10);
		heap.insert(10);

		heap.insert(40);

		heap.printHeap();
		heap.insert(50);

		heap.printHeap();

		heap.insert(60);
		heap.insert(70);
		
		heap.deleteMax();

		heap.printHeap();
	}

}
