public class Main {

    public static void main(String[] args) throws NoSuchElementException, EmptyListException {
	// write your code here
        SingleLinkedList sl = new SingleLinkedList();
        sl.insertFirst(new Integer(1));
//        sl.insertFirst(new Integer(5));
//        sl.insertFirst(new Integer(4));
//        sl.insertFirst(new Integer(2));
//        sl.insertFirst(new Integer(3));
//        sl.insertFirst(new Integer(11));
        sl.print();
        sl.reverse();
        System.out.println("reversed list");
        sl.print();
    }
}
