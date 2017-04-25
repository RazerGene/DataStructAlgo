package com.razergene.datastructalgo.tree.RBTree;

// Basic node stored in AVL trees
// Note that this class is not accessible outside
// of package DataStructures

class RBNode
{
	// Constructors
	RBNode(Comparable theElement)
	{
		this(theElement, null, null);
	}

	RBNode(Comparable theElement, RBNode lt, RBNode rt)
	{
		element = theElement;
		left = lt;
		right = rt;
		height = 0;
	}

	// Friendly data; accessible by other package routines
	Comparable element; // The data in the node
	RBNode left; // Left child
	RBNode right; // Right child
	int height; // Height
}
