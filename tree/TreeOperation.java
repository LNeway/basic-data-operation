package com.neway.tree;

import com.neway.model.TreeNode;

/**
 * Created by Neway on 2015/12/5.
 */
public class TreeOperation {


    /**
     * Get the node quantity of
     *
     * Because the this tree is Complete Binary Tree,
     * the left subtree is full binary tree or the right
     * subtree is full binary tree.
     * So we can use the formula to get the quanlity.
     *
     * Formula:
     * the full binary tree quantity is the 2^ k -1 ;
     * the k is layer count.
     *
     * @param root
     * @return
     */
    public int getQuantityOfCompleteBinaryTree(TreeNode root) {
        int count = 0;
        int treeHight = 0;
        TreeNode cur = root;
        if(cur == null) {
            return treeHight;
        }

        while( cur != null) {
            cur = cur.left;
            treeHight++;
        }

        cur = root.right;
        int rightTreeHight = 0;
        while(cur != null) {
            rightTreeHight++;
            cur = cur.left;
        }

        /**
         * the right subtree is full binary tree.
         */
        if(rightTreeHight + 1 == treeHight) {
            int leftTreeNodeCount = (int)Math.pow(2,treeHight - 1) - 1;
            count += leftTreeNodeCount;
            count += getQuantityOfCompleteBinaryTree(root.right);
        } else {
            /**
             * the left subtree is full binary tree.
             */
            int rightTreeNodeCount = (int)Math.pow(2,treeHight - 2) - 1;
            count += rightTreeNodeCount;
            count += getQuantityOfCompleteBinaryTree(root.left);
        }
        count += 1;

        return count;
    }
}
