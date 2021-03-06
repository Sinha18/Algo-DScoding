package DSA.Tree.BST;
/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * Space Complexity: O(n) , in worst case when BST is skew tree
 * Time Complexity: O(n), n is the total number of nodes in BST
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class ConvertBSTtoDLL {
    Node first=null;
    Node last=null;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return root;
        helper(root);
        first.left=last;
        last.right=first;
        return first;
    }
    public void helper(Node root){
        if(root==null)
              return;
        helper(root.left);
        if(last!=null){
            last.right=root;
            root.left=last;
            last=root;
        }else{
            first=root;
            last=root;
        }
        helper(root.right);
    }
}