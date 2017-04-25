package com.razergene.datastructalgo.sort;

import com.razergene.datastructalgo.common.Utils;

/**
 * �������� ���÷���˼�룬������ֳ������֣�Ȼ���ٵ����ֳ������֣�����ɺ���������������ɡ�
 * 
 * @author Razer
 */
public class QuickSort
{

	/**
	 * ���ҳ����ᣨĬ�������λlow������numbers�������������λ��
	 * @param numbers ����������
	 * @param low ��ʼλ��
	 * @param high����λ��
	 * @return ��������λ��
	 */
	public static int getMiddle(int[] numbers, int low, int high)
	{
		int temp = numbers[low]; // ����ĵ�һ����Ϊ����
		while (low < high)
		{
			while (low < high && numbers[high] > temp)
			{
				high--;
			}
			numbers[low] = numbers[high];// ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && numbers[low] < temp)
			{
				low++;
			}
			numbers[high] = numbers[low]; // �������ļ�¼�Ƶ��߶�
		}
		numbers[low] = temp; // �����¼��β
		return low; // ���������λ��
	}

	
	public static int getMiddle2(int[] nums, int low, int high)
	{
		int temp = nums[low];
		int pivot = low;
		while(low < high)
		{
			while(nums[high] > temp)
			{
				high--;
			}
			Utils.switchNum(nums[high], nums[pivot]);
			pivot = high;
			
			while(nums[low] < temp)
			{
				low++;
			}
			Utils.switchNum(nums[low], nums[pivot]);
			pivot = low;
		}
		return pivot;
	}
	
	
	
	public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
        	int middle = getMiddle(numbers,low,high); //��numbers�������һ��Ϊ��
        	quickSort(numbers, low, middle-1);   //�Ե��ֶα���еݹ�����
        	quickSort(numbers, middle+1, high); //�Ը��ֶα���еݹ�����
        }
    
    }
	
	
}
