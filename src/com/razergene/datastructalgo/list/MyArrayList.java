package com.razergene.datastructalgo.list;

import java.util.Iterator;
import java.util.NoSuchElementException;



//顺序存储的结构底层都是用数组实现的。

public class MyArrayList<T> implements Iterable<T>
{
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private T[] theItems;
	
	public MyArrayList()
	{
		
	}
	
	
	//基于可增长数组的扩展函数
	public void clear()
	{
		theSize = 0;
		ensureCapcity(DEFAULT_CAPACITY);
	}
	
	public int size()
	{
		return theSize;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public void trimToSize()
	{
		ensureCapcity(size());
	}
	
	public void ensureCapcity(int newCapacity)
	{
		if(newCapacity < theSize)
		{
			return;
		}
		
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		for(int i=0;i < size(); i++)
		{
			theItems[i] = old[i];
		}
	}
	
	
	//get/set函数
	public T get(int idx)
	{
		if(idx < 0 || idx >= size())
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	
	public T set(int idx, T newVal)
	{
		if(idx < 0 || idx >= size())
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		T old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}
	
	//add/remove方法
	public void add(int idx, T x)
	{
		if(theItems.length == size())
		{
			ensureCapcity(size() * 2 + 1);
		}
		for(int i = theSize; i > idx; i--)
		{
			theItems[i] = theItems[i - 1];
		}
		theItems[idx] = x;
		theSize++;
	}
	
	public T remove(int idx)
	{
		T removedItem = theItems[idx];
		for(int i = idx;i < size() - 1; i++)
		{
			theItems[i] = theItems[i + 1];
		}
		theSize--;
		return removedItem;
	}
	
	//迭代器
	private class ArrayListIterator implements Iterator<T>
	{
		private int current = 0;
		
		public boolean hasNext()
		{
			return current < size();
		}
		
		public T next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			return theItems[current++];
		}
		
		public void remove()
		{
			MyArrayList.this.remove(--current);
		} 
	}
	
	public Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}
	
}

