package com.razergene.datastructalgo.sort;

import java.util.Random;

public class MergeSort
{
	/**
	 * 采用分治模式，分解待排序n个元素的序列成各有n/2个元素的两个子序列；使用归并排序递归的排序两个子序列；
	 * 合并两个已排序的子序列产生最终排序。
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void mergeSort(int[] a, int p, int r)
	{
		//采用递归的归并排序，最底层实现两个元素的归并排序，并合并。
		if (p < r)
		{
			int q = (r + p) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	
	
	private static void merge(int[] a, int p, int q, int r)
	{
		//两段数据的长度
		int n1, n2;
		n1 = q - p + 1;
		n2 = r - q;
		int L[], R[];
		L = new int[n1 + 1];
		R = new int[n2 + 1];
		
		//初始化两段数据
		for (int i = 0; i < n1; i++)
			L[i] = a[p + i];
		
		for (int i = 0; i < n2; i++)
			R[i] = a[q + i + 1];
		
		//哨兵，当一个队列排序完成后，只有最后一个哨兵元素，另一个队列会跟哨兵逐个比较，当让都比哨兵小，从而逐个合并到a中。
		L[n1] = R[n2] = 60000;
		
		//复用两个值，初始化
		n1 = n2 = 0;
		
		//两段数据的第0个值作比较，取两者较小的值放到a数组中，然后被取出值的队列指针后移。
		for (int i = p; i <= r; i++)
		{
			if (L[n1] > R[n2])
			{
				a[i] = R[n2];
				n2++;
			} 
			else
			{
				a[i] = L[n1];
				n1++;
			}
		}
	}

	
	
	public static void main(String[] args)
	{
		Random ran = new Random();
		double start, end;
		int a[] = new int[30000];
		for (int i = 0; i < 30000; i++)
			a[i] = ran.nextInt(10000);
		start = System.currentTimeMillis();
		
		mergeSort(a, 0, 29999);
		
		end = System.currentTimeMillis();
		for (int t = 0; t < 30000; t++)
			System.out.println(a[t] + " ");
		System.out.println("运行时间:" + (end - start) + "ms");

	}

	
}