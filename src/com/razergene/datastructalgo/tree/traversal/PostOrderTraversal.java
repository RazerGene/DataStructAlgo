package com.razergene.datastructalgo.tree.traversal;

import java.util.Stack;

public class PostOrderTraversal
{
	// 后序遍历非递归算法
	private void postOrder(BinaryTree root)
	{
		if (root != null)
		{
			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;)
			{
				while (root != null)
				{
					stack.push(root);
					root = root.getLeftChild();
				}

				while (!stack.empty() && root == stack.peek().getRightChild())
				{
					root = stack.pop();
					root.visit();
				}

				if (stack.empty())
				{
					return;
				} else
				{
					root = stack.peek().getRightChild();
				}
			}
		}
	}

	
	
	// 后序遍历递归算法
	private void postOrderRecursion(BinaryTree root)
	{
		if (root != null)
		{
			postOrderRecursion(root.getLeftChild());
			postOrderRecursion(root.getRightChild());
			root.visit();
		}
	}
	

}
