package com.razergene.datastructalgo.tree.traversal;

import java.util.Stack;

public class PreOrderTraversal
{
	// 先序遍历非递归算法
	private void preOrder(BinaryTree root)
	{
		if (root != null)
		{

			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;)
			{

				// 当遍历至节点位空的时候出栈
				if (node == null)
				{
					node = stack.pop();
				}

				node.visit();

				// 遍历右孩子存入栈内
				if (node.getRightChild() != null)
				{
					stack.push(node.getRightChild());
				}

				// 遍历左子树节点
				node = node.getLeftChild();
			}
		}
	}

	// 先序遍历递归算法
	public void preOrderRecursion(BinaryTree root)
	{
		if (root != null)
		{
			root.visit();
			preOrderRecursion(root.getLeftChild());
			preOrderRecursion(root.getRightChild());
		}
	}
}
