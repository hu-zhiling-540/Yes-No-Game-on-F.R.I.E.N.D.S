package datastructures;

/**
 * A class that represents a tree of questions and answers
 * @author Zhiling
 *
 */
public class QsGameTree	{
	
	private QsGameNode root;
	

	/**
	 * Default constructor
	 */
	public QsGameTree()	{
		root = null;
	}
	
	
	/**
	 * Returns the root node
	 */
	public QsGameNode getRoot()	{
		return root;
	}
	
	
	/**
	 * Sets the node passed in as the root of the list
	 * @param root
	 */
	public void setRoot(QsGameNode root)	{
		this.root = root;	
	}
	
	
	/**
	 * If the root node is empty, it is an empty tree.
	 */
	public boolean isEmpty()	{
		return (root==null);
	}
	
	
	/**
	 * for inorderTraversal
	 * a public method to start the process
	 * @return
	 */
	public SinglyLinkedList<String> inorderTraversal()	{	
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		if (root == null)
			return null;
			
		inorderTraversal(root, list);
		return list;
	}
	
	
	/**
	 * for inorderTraversal
	 * a private recursive method
	 * @param node
	 * @param traversal
	 */
	private void inorderTraversal(QsGameNode node, SinglyLinkedList<String> traversal)	{
		
		if (node!=null)	{
		// if left exists, try left again
		if (node.getLeftChild()!=null)
			inorderTraversal(node.getLeftChild(), traversal);
		
		// couldn't go any further left, add current node
		traversal.insertLast(node.getData());
		
		// then visit right
		if (node.getRightChild()!=null)
			inorderTraversal(node.getRightChild(), traversal);
		}
	}
	
	
	/**
	 * Print the tree using inorder traversal.
	 * 
	 * @return inorder String
	 */
	
	public String inorderString() 	{
		return inorderTraversal().toString();
	}
	

}
