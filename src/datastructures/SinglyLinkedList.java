package datastructures;

/**
 * A linked list consists of a single chain of nodes, each connected to the next by a link
 * @author Zhiling
 *
 * @param <T>
 */
public class SinglyLinkedList<T>	{
	
	public SinglyLinkedListNode<T> head;	//The head instance variable refers to the first node in the linked list

	/**
	 * Default Constructor that creates an empty list
	 */
	public SinglyLinkedList()	{
		head = null;
	}
	
	
	
	/**
	 * Gets the data stored in the head node
	 */
	public T getFirst()	{
		if ( head != null)
			return head.getData();
		return null;
	}
	 
	
	
	/**
	 * Returnss the head node of the list.
	 */
	public SinglyLinkedListNode<T> getFirstNode()	{
		return head;
	}
	 

	
	/**
	 * Returns the tail node
	 */
	public SinglyLinkedListNode<T> getLastNode()	{		
		// if the head is empty
		if ( head == null )
			return null;
		
		// jump to this if the head is not empty
		SinglyLinkedListNode<T> currentNode = head;

		// if next node is null, it means that we come to the last node
		while (currentNode.getNext()!= null )	{
			// move to next node
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	
	
	/**
	 * Gets the data stored in last node
	 */
	public T getLast()	{
		if (getLastNode()==null)
			return null;
		return getLastNode().getData();
	}
	 
	
	 
	/**
	 * Inserts a node to the start of the list,
	 * which makes the new node become the first node on the list
	 */
	public void insertFirst( T data )	{
		// create a new node with data passed in
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);

		if (isEmpty())
			head = newNode;
		else	{
			// link the old head after the new node
			newNode.setNext(head); 
			// make the head point to the new node, as head gives the location of the current first node of the list
			head = newNode; 
		}
	}
	 
	
	
	/**
	 * Inserts a node with data passed in after a certain node
	 */
	public void insertAfter( SinglyLinkedListNode<T> currentNode, T data )	{
		// create a new node with data passed in
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
		
		// if the head is null, it is an empty list, so it will be the first node of the list
		if ( head == null )
			head = newNode;
		else	{
			SinglyLinkedListNode<T> preNode = head;
			SinglyLinkedListNode<T> tempNode = head.getNext();

			// loop through the list
			while ( preNode!= null )	{
				// if we come to a node that contains the data we are looking for
				if ( preNode.getData().equals(currentNode.getData()) )	{
					preNode.setNext(newNode);
					newNode.setNext(tempNode);
					return;
				}
				// otherwise move on to the next node if there is one
				else if (tempNode.getNext()!=null)	{
					preNode = tempNode;
					tempNode = tempNode.getNext();
				}
				// do nothing if no such node exists
				else
					return;
			}
		}
	 }
	
	
	
	/**
	 * Inserts a new node to the end of the list.
	 */
	public void insertLast( T data )	{
		// create a new node with data passed in
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
		
		// if head is empty, the list is empty
		if ( head == null )	{
			// make the head point to the new node
			head = newNode;
			return;
		}
		
		SinglyLinkedListNode<T> currentNode = head;

		// if the next node is null, the current node is supposed to be the last node
		while ( currentNode.getNext() != null )	{
			// move to next node
			currentNode = currentNode.getNext();
			}

		// currentNode represents the old last node
		currentNode.setNext(newNode);

	}
	
	
	
	/**
	 * Removes the first node
	 */
	public void deleteFirst()	{
		if (head == null)
			return;
		
		// get the second node
		SinglyLinkedListNode<T> nextNode = head.getNext();
		// made the head point to the second node
		head = nextNode;
	}
	 
	
	
	/**
	 * Removes the last node
	 */
	public void deleteLast()	{
		 //if there is a case that head is empty, the list is empty
		 if ( head == null)	{
		 	return;
		 }

		// if there is only one node
		if ( head.getNext() == null )	{
			// unlink the first node, thus deletes the first node
			head = head.getNext();
			return;
		}

		SinglyLinkedListNode<T> preNode = null;
		SinglyLinkedListNode<T> currentNode = head;

		// if the next node is null, the current node is supposed to be the last node
		while (currentNode.getNext()!= null )
		{
			// move to next node
			preNode = currentNode;
			currentNode = currentNode.getNext();
		}
			// currentNode now represents the last node
			// set the second to last one point to null
			preNode.setNext(null);
	}
	 
	
	
	/**
	 * Removes node right after the currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 */
	public void deleteNext(T data )	{
		// if no node exists
		if (isEmpty())
			return;

		SinglyLinkedListNode<T> preNode = head;
		SinglyLinkedListNode<T> tempNode = head.getNext();

		if (preNode!=null)	{
			while ( tempNode!= null )	{
				if ( preNode.getData().equals(data) )	{
					preNode.setNext(tempNode.getNext());
					return;
				}
				else if (tempNode.getNext()!=null)	{
					preNode = tempNode;
					tempNode = tempNode.getNext();
				}
				// do nothing if no such node exists
				else
					return;
				}
		}
		else
			return;

	}
	 
	
	
	/**
	 * Returns the number of nodes in the list.
	 */
	public int size()	{
		int count = 0;
		if (isEmpty())
			return count;

		SinglyLinkedListNode<T> currentNode = head;
		while(currentNode!= null)	{
			count = count + 1;
			currentNode = currentNode.getNext();
		}
		return count;
		
	}
	 
	
	
	/**
	 * Checks if the list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty()	{
		// if head points to null, the list is empty
		return (this.head == null);
	}
	 
	
	
	/**
	 * Return a String representation of the list.
	 */
	public String toString()	{
		String output = "{";

		if (head != null)
		{
			SinglyLinkedListNode<T> tempNode = head;
			while (tempNode != null)
			{
				output += tempNode.getData() + ", ";
				tempNode = tempNode.getNext();
			}
			
		}
		output += "}";
		return output;
	}
}