package sr.unasat.trafficsim.datastructures;

import sr.unasat.trafficsim.entities.Car;

import java.util.Vector;

public class BinaryTreeNode {
    private String key;
    private Car value;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(String key, Car value)
    {
        this.key = key;
        this.value = value;
    }

    public Car get(String key )
    {
        if (this.key.equals(key))
        {
            return value;
        }

        if (key.compareTo(this.key) < 0 )
        {
            return left == null ? null : left.get(key);
        }
        else
        {
            return right == null ? null : right.get(key);
        }
    }

    public void put(String key, Car value)
    {

        if (key.compareTo(this.key) < 0)
        {
            if (left != null)
            {
                left.put(key, value);
            }
            else
            {
                left = new BinaryTreeNode(key, value);
            }
        }
        else if (key.compareTo(this.key) > 0)
        {
            if (right != null)
            {
                right.put(key, value);
            }
            else
            {
                right = new BinaryTreeNode(key, value);
            }
        }
        else {
            this.value = value;
        }
    }

    void storeBSTNodes(BinaryTreeNode root, Vector<BinaryTreeNode> nodes)
    {
        // Base case
        if (root == null)
            return;

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    BinaryTreeNode buildTreeUtil(Vector<BinaryTreeNode> nodes, int start,int end)
    {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        BinaryTreeNode node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    public BinaryTreeNode buildTree(BinaryTreeNode root)
    {
        // Store nodes of given BST in sorted order
        Vector<BinaryTreeNode> nodes = new Vector<BinaryTreeNode>();
        storeBSTNodes(root, nodes);

        // Constucts BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

}
