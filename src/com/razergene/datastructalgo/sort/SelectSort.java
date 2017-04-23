package com.razergene.datastructalgo.sort;

import com.razergene.datastructalgo.common.Utils;

/**
 * 选择排序
 * 
 * @author Razer
 */
public class SelectSort
{

	/**
	 * 选择排序算法 在未排序序列中找到最小元素，存放到排序序列的起始位置 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
	 * 以此类推，直到所有元素均排序完毕。
	 * @param numbers
	 */
	public static void selectSort(int[] numbers)
	{
		for(int i=0;i<numbers.length;i++)
		{
			int min = Integer.MAX_VALUE;
			int index = 0;
			//遍历找到i之后（包括i）的最小值
			for(int j=i;j<numbers.length;j++)
			{
				if(numbers[j] < min)
				{
					min = numbers[j];
					index = j;
				}
			}
			Utils.switchNum(numbers[i], numbers[index]);
		}
		
	}


}