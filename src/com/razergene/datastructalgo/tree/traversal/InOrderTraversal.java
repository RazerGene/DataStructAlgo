package com.razergene.datastructalgo.tree.traversal;

import java.util.Stack;



public class InOrderTraversal
{
	// ��������ķǵݹ��㷨
	public void inOrder(BinaryTree root)
	{
		if (root != null)
		{

			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;)
			{
				// Ѱ��������������ڵ�,������������ڵ��ջ
				while (node != null)
				{
					stack.push(node);
					node = node.getLeftChild();
				}

				if (!stack.empty())
				{
					node = stack.pop(); // ��ջ
					node.visit(); // ��ȡ�ڵ�ֵ
					node = node.getRightChild();
				}
			}
		}
	}

	
	
	// ��������ĵݹ��㷨
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
