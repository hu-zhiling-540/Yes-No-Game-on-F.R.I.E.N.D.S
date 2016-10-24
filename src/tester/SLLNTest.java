package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import datastructures.SinglyLinkedListNode;

public class SLLNTest {

	@Test
	public void testDefaultConstructor() {
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(); // an empty node
		assertNull(node.data);
		assertNull(node.next);
	}
	
	@Test
	public void testConstructor()	{
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>("Joey");
		assertEquals("Joey", node.data);
		assertNull(node.next);
	}
	
	@Test
	public void testSetData()	{
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>(); // an empty node
		node.setData("Phoebe");
		assertEquals("Phoebe", node.data);
	}
	
	@Test
	public void testGetData()	{
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>("Chandler");
		assertEquals("Chandler", node.data);
	}
	
	@Test
	public void testSetNext()	{
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>("Chandler");
		SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<String>("Phoebe");
		node1.setNext(node2);
		assertEquals("Phoebe", node1.next.data);
	}
	
	@Test
	public void testGetNext()	{
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>("Chandler");
		SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<String>("Phoebe");
		node1.setNext(node2);
		assertEquals(node2, node1.getNext());
	}
	
	@Test
	public void testToString()	{
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>(); // an empty node
		assertEquals("Data: null, Next: null; ", node1.toString());
		node1.setData("Rachel");
		assertEquals("Data: Rachel, Next: null; ", node1.toString());
		SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<String>("Phoebe");
		node1.setNext(node2);
		assertEquals("Data: Rachel, Next: Phoebe; ", node1.toString());
		
		
	}
}
