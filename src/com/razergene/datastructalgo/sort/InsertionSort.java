package com.razergene.datastructalgo.sort;

import java.util.Random;

public class InsertionSort
{
	
	/**
	 * j用来遍历key值，i用来遍历前面排好序的值。
	 * 从第j个元素开始，前面的元素为排好序元素，j后面没排好。用key记录j的数值，用i遍历j之前的每个元素。
	 * 如果i的值大于key，则该元素右移，直到i的值不再大于大于key，实际就是找到要插入位置。
	 * 然后在i+1即要插入位置插入key。
	 * O(n^2)
	 */
	public void Insertion_Sort(int[] a)
	{
		for (int j = 1; j <= a.length; j++)
		{
			int key = a[j];
			
			int i = j - 1;
			
			while (i > 0 && a[i] > key)
			{
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;
		}
	}

	
	public static void main(String[] args)
	{
		InsertionSort insert = new InsertionSort();
		Random ran = new Random();
		double start, end;
		int a[] = new int[30000];
		for (int i = 0; i < 30000; i++)
			a[i] = ran.nextInt(30000);
		start = System.currentTimeMillis();
		 insert.Insertion_Sort(a);
		end = System.currentTimeMillis();
		for (int t = 0; t < 30000; t++)
			System.out.println(a[t] + " ");
		System.out.println("运行时间:" + (end - start) + "ms");

	}

}