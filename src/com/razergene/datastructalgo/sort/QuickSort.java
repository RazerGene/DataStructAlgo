package com.razergene.datastructalgo.sort;

import com.razergene.datastructalgo.common.Utils;

/**
 * 快速排序 采用分治思想，将整体分成两部分，然后再单独分成两部分，都完成后整个序列排序完成。
 * 
 * @author Razer
 */
public class QuickSort
{

	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * @param numbers 带查找数组
	 * @param low 开始位置
	 * @param high结束位置
	 * @return 中轴所在位置
	 */
	public static int getMiddle(int[] numbers, int low, int high)
	{
		int temp = numbers[low]; // 数组的第一个作为中轴
		while (low < high)
		{
			while (low < high && numbers[high] > temp)
			{
				high--;
			}
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
			while (low < high && numbers[low] < temp)
			{
				low++;
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
		numbers[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	
	public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
        	int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
        	quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
        	quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    
    }
	
	
}
