package com.razergene.datastructalgo.tree.BinarySearchTree;

// BinarySearchTree class
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

/**
 * 二叉查找树的左边的节点小，右边节点大，时间复杂度是 logN。
 * 二叉查找树是将二分查找的效率和链表的灵活操作结合起来。
 * 二叉查找树和快速排序有异曲同工之妙。
 */
public class BinarySearchTree
{
	/** The tree root. */
	private BinaryNode root;

	/**
	 * Construct the tree.
	 */
	public BinarySearchTree()
	{
		root = null;
	}

	
	
	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty()
	{
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return root == null;
	}

	
	
	public boolean contains(Comparable x)
	{
		return contains(x, root);
	}

	public boolean contains(Comparable x, BinaryNode t)
	{
		if (t == null)
		{
			return false;
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
		{
			return contains(x, t.left);
		} else if (compareResult > 0)
		{
			return contains(x, t.right);
		} else
		{
			return true;
		}
	}

	
	
	/**
	 * Internal method to get element field.
	 * @param t the node.
	 * @return the element field or null if t is null.
	 */
	private Comparable elementAt(BinaryNode t)
	{
		return t == null ? null : t.element;
	}
	
	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public Comparable findMin()
	{
		return elementAt(findMin(root));
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the smallest item.最左边的节点就是最小节点。
	 */
	private BinaryNode findMin(BinaryNode t)
	{
		if (t == null)
			return null;

		else if (t.left == null)
			return t;

		return findMin(t.left);
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item of null if empty.
	 */
	public Comparable findMax()
	{
		return elementAt(findMax(root));
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the largest item.最右边的节点就是最大节点。
	 */
	private BinaryNode findMax(BinaryNode t)
	{
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Find an item in the tree.
	 * @param x the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find(Comparable x)
	{
		return elementAt(find(x, root));
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BinaryNode find(Comparable x, BinaryNode t)
	{
		if (t == null)
			return null;

		if (x.compareTo(t.element) < 0)
			return find(x, t.left);

		else if (x.compareTo(t.element) > 0)
			return find(x, t.right);

		else
			return t; // Match
	}

	
	
	/**
	 * Insert into the tree; duplicates are ignored.
	 * @param x the item to insert.
	 */
	public void insert(Comparable x)
	{
		root = insert(x, root);
	}

	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode insert(Comparable x, BinaryNode t)
	{
		if (t == null)
		{
			t = new BinaryNode(x, null, null);
		}
			
		else if (x.compareTo(t.element) < 0)
		{
			t.left = insert(x, t.left);
		}

		else if (x.compareTo(t.element) > 0)
		{
			t.right = insert(x, t.right);
		}

		return t;
	}

	
	
	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	public void remove(Comparable x)
	{
		root = remove(x, root);
	}

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode remove(Comparable x, BinaryNode t)
	{
		if (t == null)
			return t; // Item not found; do nothing

		if (x.compareTo(t.element) < 0)
			t.left = remove(x, t.left);

		else if (x.compareTo(t.element) > 0)
			t.right = remove(x, t.right);

		else if (t.left != null && t.right != null) // Two children
		{
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}

		else
			t = (t.left != null) ? t.left : t.right;

		return t;
	}

	
	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree()
	{
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param t the node that roots the tree.
	 */
	private void printTree(BinaryNode t)
	{
		if (t != null)
		{
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	
	// Test program
	public static void main(String[] args)
	{
		BinarySearchTree t = new BinarySearchTree();
		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking...(no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(new MyInteger(i));

		for (int i = 1; i < NUMS; i += 2)
			t.remove(new MyInteger(i));

		if (NUMS < 40)
			t.printTree();

		if (((MyInteger) (t.findMin())).intValue() != 2
				|| ((MyInteger) (t.findMax())).intValue() != NUMS - 2)
			System.out.println("FindMin or FindMax error!");

		for (int i = 2; i < NUMS; i += 2)
			if (((MyInteger) (t.find(new MyInteger(i)))).intValue() != i)
				System.out.println("Find error1!");

		for (int i = 1; i < NUMS; i += 2)
		{
			if (t.find(new MyInteger(i)) != null)
				System.out.println("Find error2!");
		}
	}

}
