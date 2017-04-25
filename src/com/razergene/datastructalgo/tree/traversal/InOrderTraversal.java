package com.razergene.datastructalgo.tree.traversal;

import java.util.Stack;



public class InOrderTraversal
{
	// 中序遍历的非递归算法
	public void inOrder(BinaryTree root)
	{
		if (root != null)
		{

			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;)
			{
				// 寻找最左的左子树节点,并将遍历的左节点进栈
				while (node != null)
				{
					stack.push(node);
					node = node.getLeftChild();
				}

				if (!stack.empty())
				{
					node = stack.pop(); // 出栈
					node.visit(); // 读取节点值
					node = node.getRightChild();
				}
			}
		}
	}

	
	
	// 中序遍历的递归算法
	public void inOrderRecursion(BinaryTree root)
	{
		if (root != null)
		{
			inOrderRecursion(root.getLeftChild());
			root.visit();
			inOrderRecursion(root.getRightChild());
		}

	}
}
