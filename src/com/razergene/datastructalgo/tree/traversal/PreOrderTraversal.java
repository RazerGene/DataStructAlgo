package com.razergene.datastructalgo.tree.traversal;

import java.util.Stack;

public class PreOrderTraversal
{
	// ��������ǵݹ��㷨
	private void preOrder(BinaryTree root)
	{
		if (root != null)
		{

			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;)
			{

				// ���������ڵ�λ�յ�ʱ���ջ
				if (node == null)
				{
					node = stack.pop();
				}

				node.visit();

				// �����Һ��Ӵ���ջ��
				if (node.getRightChild() != null)
				{
					stack.push(node.getRightChild());
				}

				// �����������ڵ�
				node = node.getLeftChild();
			}
		}
	}

	// ��������ݹ��㷨
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
