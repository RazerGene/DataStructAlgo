package com.razergene.datastructalgo.tree.BTree;



/**
 * BTree相当于多阶的二叉查找树，左边小，右边大。
 *B树中的每个结点根据实际情况可以包含大量的关键字信息和分支(当然是不能超过磁盘块的大小，根据磁盘驱动(diskdrives)的不同，一般块的大小在1k~4k左右)；
 *这样树的深度降低了，这就意味着查找一个元素只要很少结点从外存磁盘中读入内存，很快访问到要查找的数据。
 */
public class BPlusTree
{

}
