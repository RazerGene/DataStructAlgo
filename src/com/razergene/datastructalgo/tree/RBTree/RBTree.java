package com.razergene.datastructalgo.tree.RBTree;

import com.razergene.datastructalgo.tree.BinarySearchTree.MyInteger;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

/**
 * 红黑树是对2-3查找树的改进，它能用一种统一的方式完成所有变换。
 * 我们将3-结点表示为由一条左斜的红色链接相连的两个2-结点。
 */
public class RBTree
{
	/**
	 * Construct the tree.
	 */
	public RBTree()
	{
		root = null;
	}

	 
	
	public void makeEmpty()
	{
		root = null;
	}

	public boolean isEmpty()
	{
		return root == null;
	}
	
	
	public void insert(Comparable x)
	{
		root = insert(x, root);
	}

	//先找插入结点，若结点有空(即2-结点)，则直接插入。如结点没空(即3-结点)，则插入使其临时容纳这个元素，
	//然后分裂此结点，把中间元素移到其父结点中。对父结点亦如此处理。
	//（中键一直往上移，直到找到空位，在此过程中没有空位就先搞个临时的，再分裂。）
	private RBNode insert(Comparable x, RBNode t)
	{
		if (t == null)
			t = new RBNode(x, null, null);

		else if (x.compareTo(t.element) < 0)
		{
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2)
				if (x.compareTo(t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x.compareTo(t.element) > 0)
		{
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2)
				if (x.compareTo(t.right.element) > 0)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // Duplicate; do nothing

		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	
	
	public void remove(Comparable x)
	{
		System.out.println("Sorry, remove unimplemented");
	}
	
	
	private Comparable elementAt(RBNode t)
	{
		return t == null ? null : t.element;
	}
	
	public Comparable find(Comparable x)
	{
		return elementAt(find(x, root));
	}
	
	private RBNode find(Comparable x, RBNode t)
	{
		while (t != null)
			if (x.compareTo(t.element) < 0)
				t = t.left;
			else if (x.compareTo(t.element) > 0)
				t = t.right;
			else
				return t; // Match

		return null; // No match
	}
	

	public Comparable findMax()
	{
		return elementAt(findMax(root));
	}
	
	private RBNode findMax(RBNode t)
	{
		if (t == null)
			return t;

		while (t.right != null)
			t = t.right;
		return t;
	}

	public Comparable findMin()
	{
		return elementAt(findMin(root));
	}

	private RBNode findMin(RBNode t)
	{
		if (t == null)
			return t;

		while (t.left != null)
			t = t.left;
		return t;
	}

	

	private static int height(RBNode t)
	{
		return t == null ? -1 : t.height;
	}

	
	private static int max(int lhs, int rhs)
	{
		return lhs > rhs ? lhs : rhs;
	}

	
	
	private static RBNode rotateWithLeftChild(RBNode k2)
	{
		RBNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private static RBNode rotateWithRightChild(RBNode k1)
	{
		RBNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private static RBNode doubleWithLeftChild(RBNode k3)
	{
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private static RBNode doubleWithRightChild(RBNode k1)
	{
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	
	
	public void printTree()
	{
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	private void printTree(RBNode t)
	{
		if (t != null)
		{
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
	
	private RBNode root;

	public static void main(String[] args)
	{
		RBTree t = new RBTree();
		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(new MyInteger(i));

		if (NUMS < 40)
			t.printTree();
		if (((MyInteger) (t.findMin())).intValue() != 1
				|| ((MyInteger) (t.findMax())).intValue() != NUMS - 1)
			System.out.println("FindMin or FindMax error!");

		for (int i = 1; i < NUMS; i++)
			if (((MyInteger) (t.find(new MyInteger(i)))).intValue() != i)
				System.out.println("Find error1!");
	}

}
