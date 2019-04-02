package com.mozhaev.bin;

import com.mozhaev.bin.Node;

public class BinaryTree {

    Node root;

    public void nodeAdd(int value) {
        root = recurrentNodeAdd(root, value);
    }

    private Node recurrentNodeAdd(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = recurrentNodeAdd(current.left, value);
        } else if (value > current.value) {
            current.right = recurrentNodeAdd(current.right, value);
        }

        return current;
    }

    public boolean hasNode(int value) {
        return recurrentHasNode(root, value);
    }

    private boolean recurrentHasNode(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? recurrentHasNode(current.left, value)
                : recurrentHasNode(current.right, value);
    }

    private int getSmallestNode(Node root) {
        return root.left == null ? root.value : getSmallestNode(root.left);
    }

    public void nodeDelete(int value) {
        root = recurrentNodeDelete(root, value);
    }

    private Node recurrentNodeDelete(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {

            // Node has 0 leaves
            if (current.left == null && current.right == null) {
                return null;
            }

            // Node has only one leaf
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Node has both leaves
            int smallestNode = getSmallestNode(current.right);
            current.value = smallestNode;
            current.right = recurrentNodeDelete(current.right, smallestNode);
            return current;
        }
        if (value < current.value) {
            current.left = recurrentNodeDelete(current.left, value);
            return current;
        }

        current.right = recurrentNodeDelete(current.right, value);
        return current;
    }
}