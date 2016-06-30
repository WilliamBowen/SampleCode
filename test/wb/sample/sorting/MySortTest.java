package wb.sample.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

import wb.sample.sorting.MySort;

public class MySortTest {

	@Test
	public void testInsertionSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.insertionSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSelectionSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.selectionSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testMergeSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.mergeSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testHeapSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.heapSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
	
	/*
	@Test
	public void testQuickSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.quickSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
	*/
	
	@Test
	public void testBubbleSort() {
		// setup
		int[] testArray = {1, 5, 3, 7, 6, 8, 4, 2, 9, 1, 5, 3, 7, 6, 8, 4, 2, 9};
		//execute
		int[] result = MySort.bubbleSort(testArray);
		//assert
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
		assertArrayEquals(expected, result);
	}
}
