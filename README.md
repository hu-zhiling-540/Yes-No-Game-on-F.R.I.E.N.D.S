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

## Screenshot of Application

![Screenshot_1](https://github.com/hu-zhiling-540/Yes-No-Game-on-F.R.I.E.N.D.S/blob/master/Screen%20Shot%202017-04-21%20at%208.50.03%20PM.png)
![Screenshot_2](https://github.com/hu-zhiling-540/Yes-No-Game-on-F.R.I.E.N.D.S/blob/master/Screen%20Shot%202017-04-21%20at%208.50.19%20PM.png)

## Tests

Tests on two classes of data structures we are relying on: SinglyLinkedList.java and SinglyLinkedListNode.java

## Contributors

Thanks for guidance and advice from Professor Peter Klemperer.


