package com.razergene.datastructalgo.tree.ASTree;

// Basic node stored in AVL trees
// Note that this class is not accessible outside
// of package DataStructures

class ASNode
{
	// Constructors
	ASNode(Comparable theElement)
	{
		this(theElement, null, null);
	}

	ASNode(Comparable theElement, ASNode lt, ASNode rt)
	{
		element = theElement;
		left = lt;
		right = rt;
		height = 0;
	}

	// Friendly data; accessible by other package routines
	Comparable element; // The data in the node
	ASNode left; // Left child
	ASNode right; // Right child
	int height; // Height
}
