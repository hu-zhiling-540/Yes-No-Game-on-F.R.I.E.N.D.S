# Yes-No-Game-on-F.R.I.E.N.D.S

## Synopsis

A big fan of Friends? You have some character in mind and I will asks a series of yes/no questions to try to determine who you are thinking of.

## Code Example

	public SinglyLinkedList<String> inorderTraversal()	{	
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		if (root == null)
			return null;
			
		inorderTraversal(root, list);
		return list;
	}
  
	public void inorderTraversal(QsGameNode node, SinglyLinkedList<String> traversal)	{
		if (node!=null)	{
		if (node.getLeftChild()!=null)
			inorderTraversal(node.getLeftChild(), traversal);
		traversal.insertLast(node.getData());
		if (node.getRightChild()!=null)
			inorderTraversal(node.getRightChild(), traversal);
		}
	}
  
## Motivation

This is an extended application from my final project for CS 201 at Mount Holyoke College. 


## Tests

Tests on two classes of data structures we are relying on: SinglyLinkedList.java and SinglyLinkedListNode.java

## Contributors

Thanks for guidance and advice from Professor Peter Klemperer.


