package com.razergene.datastructalgo.sort;

import com.razergene.datastructalgo.common.Utils;



/**
 * 冒泡排序
 * 遍历一次时，相邻两个元素比较，小者放前，大者放后。经过一遍后，最大元素会到最后，因为只有
 * 后一个元素能跟更后元素对比大小。
 * 后面再经过N-1次遍历，每次都遍历前N-i个元素，找到最大元素放最后。
 * 剩下最后一个元素自然是最小的，于是完成排序。
 * ********
 * ******
 * ****
 * ***
 * **
 * *
 * @author Razer
 */
public class BubbleSort
{
	
	public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i++)  //这个遍历是针对N-1的次数
        {
        	for(int j = 0;j < size-1-i; j++) //这个才是真的去遍历数组中元素
        	{
        		if(numbers[j] > numbers[j+1])  //交换两数位置
        		{
        			Utils.switchNum(numbers[j], numbers[j+1]);
        		}
        	}
        }
    }

	

	
}