import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Longest Path from root to leaf Node
 */
public class BinaryTreeLongestPath {
	
	static Node temp1 = null;
	static Node temp2 = null;
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node root = bt.constructTree(bt);
		List path = printPath(root);
		Iterator itr = path.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println("inorder traversal");
		inorderTraversal(root);

		correctBST(root, null);
		
		List<Node> totalTreesFrom1toN = constructTrees(1, 3);
		 
		 
	    /*  Printing preorder traversal of all constructed BSTs   */
	    System.out.println("Preorder traversals of all constructed BSTs are \n");
	    for (int i = 0; i < totalTreesFrom1toN.size(); i++)
	    {
	        preorderTraversal(totalTreesFrom1toN.get(i));
	        
	    }
	    
	    isPairPresent(root, 150);
	}
	
	public static void preorderTraversal(Node node) {
		if (node == null) {
			return;
		}

		System.out.println(node.data);
		inorderTraversal(node.left);
		inorderTraversal(node.right);
	}

	public static void inorderTraversal(Node node) {
		if (node == null) {
			return;
		}

		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);

	}

	static void correctBST(Node root, Node prev) {

		boolean found = false;
		if (found) {
			return;
		}

		if (root != null) {
			correctBST(root.left, prev);
			if (prev == null || root.left != null) {
				prev = root.left;
			}
			if (temp1 == null && prev != null && root.data < prev.data)
				temp1 = prev;// find the first such element
			else if (temp2 == null && prev != null && root.data < prev.data)
				temp2 = root;// somewhere along the traversal find the 2nd
								// element too.
			if (temp1 != null && temp2 != null && !found) {
				System.out.println("node1= " + temp1.data + "node2=" + temp2.data);
				found = true;
				return;
			}
			if (root.right != null) {
				prev = root;
			}
			correctBST(root.right, prev);

		}
	}

	public static List<Integer> printPath(Node root) {
		if (root == null) {
			return null;
		}
		List<Integer> path = new ArrayList<>();
		path.add(root.data);
		List result = getMaxList(printPath(root.left), printPath(root.right));
		if (result != null) {
			path.addAll(result);
		}
		return path;
	}

	public static List<Integer> getMaxList(List<Integer> list1, List<Integer> list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.size() > list2.size()) {
			return list1;
		} else {
			return list2;
		}
	}
	
	static List<Node> constructTrees(int start, int end)
	{
	    List<Node> list = new ArrayList<Node>();
	 
	    /*  if start > end   then subtree will be empty so returning NULL
	        in the list */
	    if (start > end)
	    {
	        list.add(null);
	        return list;
	    }
	 
	    /*  iterating through all values from start to end  for constructing\
	        left and right subtree recursively  */
	    for (int i = start; i <= end; i++)
	    {
	        /*  constructing left subtree   */
	        List<Node> leftSubtree  = constructTrees(start, i - 1);
	 
	        /*  constructing right subtree  */
	        List<Node> rightSubtree = constructTrees(i + 1, end);
	 
	        /*  now looping through all left and right subtrees and connecting
	            them to ith root  below  */
	        for (int j = 0; j < leftSubtree.size(); j++)
	        {
	            Node left = leftSubtree.get(j);
	            for (int k = 0; k < rightSubtree.size(); k++)
	            {
	                Node right = rightSubtree.get(k);
	                Node node = new Node(i);// making value i as root
	                node.left = left;              // connect left subtree
	                node.right = right;            // connect right subtree
	                list.add(node);           // add this tree to list
	            }
	        }
	    }
	    return list;
	}
	
	public static boolean isPairPresent(Node root, int target)
	{
	    // Create two stacks. s1 is used for normal inorder traversal
	    // and s2 is used for reverse inorder traversal
	    Stack<Node> s1 = new Stack<Node>();
	    Stack<Node> s2 = new Stack<Node>();
	 
	    // Note the sizes of stacks is MAX_SIZE, we can find the tree size and
	    // fix stack size as O(Logn) for balanced trees like AVL and Red Black
	    // tree. We have used MAX_SIZE to keep the code simple
	 
	    // done1, val1 and curr1 are used for normal inorder traversal using s1
	    // done2, val2 and curr2 are used for reverse inorder traversal using s2
	    boolean done1 = false;
	    boolean done2 = false;
	    int val1 = 0;
	    int val2 = 0;
	    
	    Node curr1 = root;
	    Node curr2 = root;
	 
	    // The loop will break when we either find a pair or one of the two
	    // traversals is complete
	    while (true)
	    {
	        // Find next node in normal Inorder traversal. See following post
	        // http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	        while (done1 == false)
	        {
	            if (curr1 != null)
	            {
	                s1.push(curr1);
	                curr1 = curr1.left;
	            }
	            else
	            {
	                if (s1.isEmpty())
	                    done1 = true;
	                else
	                {
	                    curr1 = s1.pop();
	                    val1 = curr1.data;
	                    curr1 = curr1.right;
	                    done1 = true;
	                }
	            }
	        }
	 
	        // Find next node in REVERSE Inorder traversal. The only
	        // difference between above and below loop is, in below loop
	        // right subtree is traversed before left subtree
	        while (done2 == false)
	        {
	            if (curr2 != null)
	            {
	                s2.push(curr2);
	                curr2 = curr2.right;
	            }
	            else
	            {
	                if (s2.isEmpty())
	                    done2 = true;
	                else
	                {
	                    curr2 = s2.pop();
	                    val2 = curr2.data;
	                    curr2 = curr2.left;
	                    done2 = true;
	                }
	            }
	        }
	 
	        // If we find a pair, then print the pair and return. The first
	        // condition makes sure that two same values are not added
	        if ((val1 != val2) && (val1 + val2) == target)
	        {
	            System.out.println("Pair Found: " + val1 + " " + val2 + " target:" + target);
	            return true;
	        }
	 
	        // If sum of current values is smaller, then move to next node in
	        // normal inorder traversal
	        else if ((val1 + val2) < target)
	            done1 = false;
	 
	        // If sum of current values is greater, then move to next node in
	        // reverse inorder traversal
	        else if ((val1 + val2) > target)
	            done2 = false;
	 
	        // If any of the inorder traversals is over, then there is no pair
	        // so return false
	        if (val1 >= val2)
	            return false;
	    }
	}


}




class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	/* Get width of a given level */
	int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the height of each subtree */
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one */
			return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
		}
	}

	/* Driver program to test above functions */
	public Node constructTree(BinaryTree tree) {
		/*
		 * Constructed binary tree is: 1 / \ 2 3 / \ \ 4 5 8 / \ 6 7
		 */
		tree.root = new Node(50);
		tree.root.left = new Node(40);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(20);
		tree.root.left.left.left = new Node(10);
		tree.root.left.right = new Node(45);
		tree.root.right.right = new Node(80);
		tree.root.right.left = new Node(55);
		tree.root.right.right.right = new Node(100);
		return tree.root;
	}
}