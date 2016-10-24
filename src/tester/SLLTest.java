package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedListNode;

public class SLLTest {

	@Test
	public void testDefaultConstructor() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertNull(list.head);
	}
	
	@Test
	public void testGetFirst()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertNull(list.getFirst());
		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>("Phoebe");
		list.head = node;	// list: Phoebe
		assertEquals("Phoebe",list.getFirst());
	}
	
	@Test
	public void testGetFirstNode()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertNull(list.getFirstNode());
		
		SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>("Phoebe");
		list.head = node;	// list: Phoebe
		assertEquals("Data: Phoebe, Next: null; ",list.getFirstNode().toString());
	}
	
	@Test
	public void testGetLastNode()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertNull(list.getLastNode());
		
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>("Phoebe");
		list.head = node1;	// list: Phoebe
		assertEquals("Data: Phoebe, Next: null; ",list.getLastNode().toString());
		
		SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<String>("Monica");
		node1.next = node2;	// list: Phoebe, Monica
		assertEquals("Data: Monica, Next: null; ",list.getLastNode().toString());
	}
	
	@Test
	public void testGetLast()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertNull(list.getLast());
		
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>("Phoebe");
		list.head = node1;	// list: Phoebe
		assertEquals("Phoebe",list.getLast());
		
		SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<String>("Monica");
		node1.next = node2;	// list: Phoebe, Monica
		assertEquals("Monica",list.getLast());
	}
	
	@Test
	public void testInsertFirst()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		list.insertFirst("Phoebe");	// list: Phoebe
		assertEquals("Phoebe",list.getFirst());
		
		list.insertFirst("Rachel");	// list: Rachel, Phoebe
		assertEquals("Rachel",list.getFirst());
	}
	
	@Test
	public void testInsertAfter()	{
		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>(); // an empty list
		SinglyLinkedListNode<String> newNode1 = new SinglyLinkedListNode<String>("Ross");
		list1.insertAfter(newNode1, "Phoebe");	// list: Phoebe
		assertEquals("Phoebe",list1.getFirst());
		
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>(); // an empty list
		SinglyLinkedListNode<String> newNode2 = new SinglyLinkedListNode<String>("Joey");
		list2.head = newNode2;	// list: Joey
		list2.insertAfter(newNode2, "Phoebe");	// list: Joey, Phoebe
		assertEquals("Joey",list2.getFirst());
		
		list2.insertAfter(newNode2, "Rachel");	// list: Joey, Rachel, Phoebe
		assertEquals("Joey",list2.getFirst());
		assertEquals("Phoebe",list2.getLast());
	}
	
	@Test
	public void testInsertLast()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		list.insertLast("Phoebe");	// list: Phoebe
		assertEquals("Phoebe",list.getFirst());
		assertEquals("Phoebe",list.getLast());
		
		list.insertLast("Joey");	// list: Phoebe, Joey
		assertEquals("Phoebe",list.getFirst());
		assertEquals("Joey",list.getLast());
		
		list.insertLast("Chandler");	// list: Phoebe, Joey, Chandler
		list.insertLast("Monica");	// list: Phoebe, Joey, Chandler, Monica
		assertEquals("Phoebe",list.getFirst());
		assertEquals("Monica",list.getLast());
	}
	
	@Test
	public void testDeleteFirst()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		list.deleteFirst();
		assertTrue(list.isEmpty());
		
		list.insertFirst("Rachel");	// list: Rachel
		list.insertFirst("Monica");	// list: Monica, Rachel
		assertEquals("Monica",list.getFirst());
		list.deleteFirst();	// list: Rachel
		assertEquals("Rachel",list.getFirst());
		
		list.insertFirst("Monica");	// list: Monica, Rachel
		list.insertFirst("Ross");	// list: Ross, Monica, Rachel
		list.insertLast("Chandler");	// list: Ross, Monica, Rachel, Chandler
		assertEquals("Ross",list.getFirst());
		list.deleteFirst();	// list: Monica, Rachel, Chandler
		assertEquals("Monica",list.getFirst());
	}
	
	@Test
	public void testDeleteLast()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();	// an empty list
		list.deleteLast();
		assertTrue(list.isEmpty());
		
		list.insertFirst("Rachel");	// list: Rachel
		assertEquals("Rachel",list.getLast());
		list.deleteLast();	// list:
		assertNull(list.getLast());
		
		list.insertFirst("Monica");	// list: Monica
		list.insertFirst("Ross");	// list: Ross, Monica
		assertEquals("Monica",list.getLast());
		list.deleteLast();	// list: Ross
		assertEquals("Ross",list.getLast());
		
		list.insertFirst("Rachel");	// list: Rachel, Ross
		list.insertFirst("Monica");	// list: Monica, Rachel, Ross
		list.insertFirst("Chandler");	// list: Chandler, Monica, Rachel, Ross
		assertEquals("Ross",list.getLast());
		list.deleteLast();	// list: Chandler, Monica, Rachel
		assertEquals("Rachel",list.getLast());
	}
	
	@Test
	public void testDeleteNext()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<String>("Ross");
		list.deleteNext("Ross");
		assertTrue(list.isEmpty());
		
		list.head = node1;	// list: Ross
		list.deleteNext(node1.getData());	// list: Rpss
		assertEquals(node1, list.getFirstNode());
		
		list.insertAfter(node1, "Joey");	// list: Ross, Joey
		assertEquals("Joey", list.getLast());
		list.deleteNext(node1.getData());	// list: Ross
		assertEquals("Ross", list.getLast());
		
		list.insertAfter(node1, "Joey");	// list: Ross, Joey
		list.insertLast("Phoebe");	// list: Ross, Joey, Phoebe
		list.deleteNext("Joey");
		assertEquals("Joey", list.getLast());
	}
	
	@Test
	public void testSize()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>(); // an empty list
		assertEquals(0, list.size());
		
		list.insertFirst("Joey");	// list: Joey
		assertEquals(1, list.size());
		
		list.insertFirst("Phoebe");	// list: Phoebe, Joey
		assertEquals(2, list.size());
	}
	
	@Test
	public void testIsEmpty()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();	// an empty list
		assertTrue(list.isEmpty());
		
		list.insertFirst("Joey");	// list: Joey
		assertFalse(list.isEmpty());
		
		list.deleteFirst();	// list:
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testToString()	{
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();	// an empty list
		assertEquals("{}", list.toString());
		
		list.insertFirst("Joey");	// list: Joey
		assertEquals("{Joey, }", list.toString());
		
		list.insertFirst("Chandler");	// list: Joey, Chandler
		assertEquals("{Chandler, Joey, }", list.toString());
	}
	
}
