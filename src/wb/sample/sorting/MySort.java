package wb.sample.sorting;

import java.util.Arrays;

public class MySort {
	
	private static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	//SIMPLE SORTS
	/*
	 * insertion sort is O(n^2)
	 */
	public static int[] insertionSort(int[] ints){
		int[] result = ints;
		for(int i = 1; i < result.length; i++){
			int x = result[i];
			int j = i-1;
			while(j > 0 && result[j] > x){
				result[j+1] = result[j];
				j--;
			}
			result[j+1] = x;
		}
		return result;
	}
	
	/*
	 * selection sort is O(n^2)
	 */
	public static int[] selectionSort(int[] ints){
		int[] result = ints;
		for(int i = 0; i < result.length - 1; i++){
			int jMin = i;
			for (int j = i + 1; j < result.length; j++){
				if(result[j] < result[jMin]){
					jMin = j;
				}
			}
			if(jMin != i){
				swap(result, jMin, i);
			}
		}
		return result;
	}
	
	
	//EFFICIENT SORTS
	
	/*
	 * Merge sort is O(n log n)
	 */
	public static int[] mergeSort(int[] ints){
		if (ints.length <= 1){
			return ints;
		} else {
			int middle = ints.length / 2;
			int[] left = Arrays.copyOfRange(ints, 0, middle);
			int[] right = Arrays.copyOfRange(ints, middle, ints.length);
			left = mergeSort(left);
			right = mergeSort(right);
			return merge(left, right);
		}
	}
	
	private static int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				result[k] = left[i];
				i++;
				k++;
			} else {
				result[k] = right[j];
				j++;
				k++;
			}
		}
		while(i < left.length){
			result[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			result[k] = right[j];
			j++;
			k++;
		}
		return result;
	}
	/*
	 * Heap sort is O(n log n)
	 */
	public static int[] heapSort(int[] ints){
		int[]result = ints;
		buildHeap(result);
		for(int i = result.length - 1; i >= 0; i--){
			swap(result, 0, i);
			heapify(result, 0, i);
		}
		return result;
	}
	
	private static void buildHeap(int[] array){
		for(int i = array.length / 2; i >= 0; i--){
			heapify(array, i, array.length);
		}
		return;
	}
	
	private static void heapify(int[] array, int root, int length){
		int left = (2 * root) + 1;
		int right = (2 * root) + 2;
		int max;
		
		if(left <= length - 1 && array[left] > array[root]){
			max = left;
		} else {
			max = root;
		}
		if (right <= length - 1 && array[right] > array[max]){
			max = right;
		}
		if (max != root){
			swap(array, root, max);
			heapify(array, max, length);
		}
		return;
	}
	
	/*
	 * Quick sort
	 */
	public static int[] quickSort(int[] ints){
		//TODO implement quickSort
		int[] result = ints;
		
		return result;
	}
	
	
	//BUBBLE SORT AND VARIANTS
	
	/*
	 * bubble sort is O(n^2)
	 */
	public static int[] bubbleSort(int[] ints){
		int[] result = ints;
		int n = result.length;
		boolean swapped = true;
		while(swapped){
			swapped = false;
			for(int i = 0; i < n-1; i++){
				if(result[i] > result[i+1]){
					swap(result, i, i+1);
					swapped = true;
				}
			}
		}
		return result;
	}
	
	/*
	 * Shell sort
	 */
	
	/*
	 * Comb sort
	 */
	
	//DISTRIBUTION SORT
	
	/*
	 * Counting sort
	 */
	
	/*
	 * Bucket sort
	 */
	
	/*
	 * Radix sort
	 */
}
