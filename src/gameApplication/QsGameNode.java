package gameApplication;
/**
 * A class that represents a single question node and its answers
 * @author Zhiling
 *
 */
public class QsGameNode	{
	
	protected String data;
	protected QsGameNode left;
	protected QsGameNode right;
	
	
	
	/**
	 * Default constructor
	 */	
	public QsGameNode()	{
		
	}
	
	
	
	/**
	 * Gets the data of the node
	 * @return
	 */
	public String getData() {
		return this.data;
	}

	
	
	/**
	 * set the date of this node
	 * @param data
	 */
	public void setData(String data)	{
		this.data = data;
	}

	/**
	 * return the left child node
	 * @return
	 */
	public QsGameNode getLeftChild()	{
		return left;
	}

	
	
	/**
	 * return the right child node
	 * @return
	 */
	public QsGameNode getRightChild()	{
		return right;
	}
	
	

	/**
	 * set the left child
	 * @param left
	 */
	public void setLeftChild(QsGameNode left)	{
		this.left = left;
	}

	
	
	/**
	 * set the right child
	 * @param right
	 */
	public void setRightChild(QsGameNode right)	{
		this.right = right;
		
	}

	
	
	/**
	 * decide if it is leaf
	 * @return
	 */
	public boolean isLeaf()	{
		if(left==null && right==null )
			return true;
		else
			return false;
	}

}
