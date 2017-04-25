package com.razergene.datastructalgo.tree.BinarySearchTree;



class BinaryNode
{
	// Constructors
	BinaryNode(Comparable theElement)
	{
		this(theElement, null, null);
	}

	BinaryNode(Comparable theElement, BinaryNode lt, BinaryNode rt)
	{
		element = theElement;
		left = lt;
		right = rt;
	}

	// Friendly data; accessible by other package routines
	Comparable element; // The data in the node
	BinaryNode left; // Left child
	BinaryNode right; // Right child
}
