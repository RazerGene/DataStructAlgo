package com.razergene.datastructalgo.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;



//链式存储的结构底层都是用链表实现的。

public class MyLinkedList<T> implements Iterable<T>
{
	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;
	
	
	public MyLinkedList()
	{
		clear();
	}
	
	
	public void clear()
	{
		beginMarker = new Node<T>(null, null, null);
		endMarker = new Node<T>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}
	
	
	public int size()
	{
		return theSize;
	}
	
	
	public boolean isEmpty()
	{
		return size() == 0;
	}

	
	
	//get/set
	public T get(int idx)
	{
		return getNode(idx).data;
	}
	

	public T set(int idx, T newVal)
	{
		Node<T> p = getNode(idx);
		T oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	
	
	private Node<T> getNode(int idx)
	{
		Node<T> p;
		if(idx < 0 || idx >size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(idx < size()/2)
		{
			p = beginMarker.next;
			for(int i = 0; i < idx; i++)
			{
				p = p.next;
			}
		}
		else 
		{
			p = endMarker;
			for(int i = size(); i > idx; i--)
			{
				p = p.prev;
			}
		}
		return p;
	}
	
	
	//add/remove
	public boolean add(T x)
	{
		add(size(), x);
		return true;
	}
	
	
	public void add(int idx, T x)
	{
		addBefore(getNode(idx), x);
	}
	
	
	private void addBefore(Node<T> p, T x)
	{
		//通过Node的构造函数确定当前Node的prev和next
		Node<T> newNode = new Node<T>(x, p.prev, p);
		//然后再连接其他两个指针
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}
	
	
	public T remove(int idx)
	{
		return remove(getNode(idx));
	}
	
	
	private T remove(Node<T> p)
	{
		//P的前后节点双向连接
		p.next.prev = p.prev;
		p.prev.next = p.next;
		//?是否需要P的prev和next指空
		theSize--;
		modCount++;
		return p.data;
	}
	
	
    public void makeEmpty( )
    {
        beginMarker.next = null;
    }


	
	
	//迭代器
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator()
	{
		return (Iterator<T>) new LinkedListIterator();
	}
	
	
	
	//Node类
	private static class Node<T>
	{
		public T data;
		public Node<T> prev;
		public Node<T> next;
		
		
		public Node(T d, Node<T> p, Node<T> n)
		{
			data = d;
			prev = p;
			next = n;
		}
	}

	
	//LinkedListIterator类
	private class LinkedListIterator implements Iterable<T>
	{
		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext()
		{
			return current != endMarker;
		}
		
		public T next()
		{
			if(modCount != expectedModCount)
			{
				throw new ConcurrentModificationException();
			}
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		
		public void remove()
		{
			if(modCount != expectedModCount)
			{
				throw new ConcurrentModificationException();
			}
			if(!okToRemove)
			{
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}

		@Override
		public Iterator<T> iterator()
		{
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	

}
