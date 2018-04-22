public class SingleLinkedList {

    Node head;

    public SingleLinkedList() {
	head = null;
    }

    public boolean isEmpty() {
	return (head == null);
    }

    // Method for inserting an object in the first position of a list
    public void insertFirst(Object o) {
	// Pack o into a Node
	Node n = new Node(o);

	// put n at the beginning of the list
	n.next = head;

	// and modify the head of the list
	head = n;
    }

    // Method for inserting an object in the last position of a list
    public void insertLast(Object o) {
	// Pack o into a Node
	Node n = new Node(o);

	// If the list is empty, we simply have to change head
	if (head == null) {
	    head = n;
	    return;
	}
	// The list is not empty, so we have to traverse it, stopping at the last element
	Node crt = head;
	while (crt.next != null)
	    crt = crt.next;
	crt.next = n;
    }

    // Method for printing the entire list (demonstrates traversal)
    public void print() {
	for (Node crt = head; crt != null; crt = crt.next)
	    System.out.println(crt.content);
    }

    // Method for removing the first element in the list; the object is returned
    // Note that this is O(1), since we have a sequence of primitive operations
    public Object removeFirst() throws EmptyListException {

	if (head == null) throw new EmptyListException();

	// Put a "finger" on the current head
	Node crt = head;

	// Move the head to the appropriate spot
	head = head.next;

	// Figure out what we need to return
	Object o = crt.content;

	// Clear out all pointer - the garbage collector will take care of this area in memory
	crt.content = null;
	crt.next = null;

	// And we're done
	return o;
    }


    // Method for removing the last element in the list; the object is returned
    // This is O(n) because we need to traverse the list
    public Object removeLast() throws EmptyListException {

	if (head == null) throw new EmptyListException();

	Object o;

	// If there is only one element, we need to modify the head of the list
	if (head.next == null) {
	    o = head.content;
	    head.content = null;
	    head = null;
	    return o;
	}

	// We need to go to the second-to-last element
	Node crt = head;
	while (crt.next.next != null)
	    crt = crt.next;

	// Now get the content
	o = crt.next.content;

	// Remove all references that are not needed
	crt.next.content = null;
	crt.next = null;

	// And we're done
	return o;
    }

    // Method for finding an object in a list; returns true if the object is found
    public boolean find (Object o) {
	if (head == null) return false;

	// We need an index in the list
	for (Node crt = head; crt != null; crt = crt.next) {
	    if (o.equals(crt.content)) return true;
	}
	return false;
    }

    public Object removeBefore(Object o) throws EmptyListException,NoSuchElementException
    {
    	if(head == null) throw new EmptyListException();
    	if(!find(o) || o.equals(head.content))
    	{
    		throw new NoSuchElementException();
    	}
		Node prev = head;
		if(o.equals(head.next.content))
		{
			removeFirst();
			return head;
		}
    	for(Node crt= head.next; crt != null; crt = crt.next)
    	{
    		if(crt.next != null && o.equals(crt.next.content))
    		{
    			prev.next = crt.next;
    		}
    		prev = prev.next;
    	}
    	return head;
    }

    public Object removeAfter(Object o) throws EmptyListException, NoSuchElementException
    {
    	if(head == null) throw new EmptyListException();
    	Node prev = head;
    	if(head.next == null || !find(o))
    	{
    		throw new NoSuchElementException();
    	}
    	for(Node crt = head.next; crt !=null; crt = crt.next)
    	{
    		if(o.equals(prev.content))
    		{
    			prev.next = crt.next;
    		}
    		prev = crt;
    	}
    	if(prev.content.equals(o))
		{
			throw new NoSuchElementException();
		}
    	return head;
    }
    public Object reverse() throws EmptyListException
	{
		if(head==null) throw new EmptyListException();
		Node prev = new Node(-1);
		Node crt = head;
		Node then = crt.next;
		prev.next = crt;
		while(crt.next != null)
		{
			crt.next = then.next;
			then.next = prev.next;
			prev.next = then;
			then = crt.next;
		}
		head = prev.next;
		return head;
	}

}