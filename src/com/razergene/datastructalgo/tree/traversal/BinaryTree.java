package com.razergene.datastructalgo.tree.traversal;

public class BinaryTree
{
	char data; // ���ڵ�
	BinaryTree leftChild; // ����
	BinaryTree rightChild; // �Һ���

	public BinaryTree()
	{

	}

	public void visit()
	{
		System.out.println(this.data);
	}

	public BinaryTree(char data)
	{
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public BinaryTree getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(BinaryTree leftChild)
	{
		this.leftChild = leftChild;
	}

	public BinaryTree getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(BinaryTree rightChild)
	{
		this.rightChild = rightChild;
	}

	public char getData()
	{
		return data;
	}

	public void setData(char data)
	{
		this.data = data;
	}

}
