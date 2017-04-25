package com.razergene.datastructalgo.tree.ASTree;

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
 * 带有平衡条件的二叉查找树，每个节点的左子树和右子树高度最多差1，从而保证所有查找都在logN内结束，和二分查找一样。
 * 动态插入中保证树的平衡代价较大，要把普通二叉查找树变为平衡二叉查找树：单旋转，双旋转。
 */
public class ASTree
{
	/**
	 * Construct the tree.
	 */
	public ASTree()
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
	private ASNode insert(Comparable x, ASNode t)
	{
		if (t == null)
			t = new ASNode(x, null, null);

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
	
	
	private Comparable elementAt(ASNode t)
	{
		return t == null ? null : t.element;
	}
	
	public Comparable find(Comparable x)
	{
		return elementAt(find(x, root));
	}
	
	private ASNode find(Comparable x, ASNode t)
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
	
	private ASNode findMax(ASNode t)
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

	private ASNode findMin(ASNode t)
	{
		if (t == null)
			return t;

		while (t.left != null)
			t = t.left;
		return t;
	}

	

	private static int height(ASNode t)
	{
		return t == null ? -1 : t.height;
	}

	
	private static int max(int lhs, int rhs)
	{
		return lhs > rhs ? lhs : rhs;
	}

	
	
	private static ASNode rotateWithLeftChild(ASNode k2)
	{
		ASNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private static ASNode rotateWithRightChild(ASNode k1)
	{
		ASNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private static ASNode doubleWithLeftChild(ASNode k3)
	{
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private static ASNode doubleWithRightChild(ASNode k1)
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
	
	private void printTree(ASNode t)
	{
		if (t != null)
		{
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
	
	private ASNode root;

	public static void main(String[] args)
	{
		ASTree t = new ASTree();
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
