package com.razergene.datastructalgo.sort;

import java.util.Random;

public class InsertionSort
{
	
	/**
	 * j��������keyֵ��i��������ǰ���ź����ֵ��
	 * �ӵ�j��Ԫ�ؿ�ʼ��ǰ���Ԫ��Ϊ�ź���Ԫ�أ�j����û�źá���key��¼j����ֵ����i����j֮ǰ��ÿ��Ԫ�ء�
	 * ���i��ֵ����key�����Ԫ�����ƣ�ֱ��i��ֵ���ٴ��ڴ���key��ʵ�ʾ����ҵ�Ҫ����λ�á�
	 * Ȼ����i+1��Ҫ����λ�ò���key��
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
		System.out.println("����ʱ��:" + (end - start) + "ms");

	}

}