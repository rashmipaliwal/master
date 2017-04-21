
public class LinkedListSort {
	public static void main(String[] args) {
		
	}
	
	private class Node {
		public int data;
		public Node next;
		
		public Node() {
			data = 0;
			next = null;
		}
	}
	
	private class LinkedList {
	    Node start;
	    Node end;
	    int size = 0;
	    
	    
	    public boolean isEmpty() {
	    	return (start == null);
	    }
	    
	    public int size() {
	    	return size;
	    }
	    
	    public void insertAtStart(int val) {
	    	Node node = new Node();
	    	node.data = val;
	    	
	    	size++;
	    	if (start == null) {
	    		start = node;
	    		end = start;
	    	}
	    	
	    	node.next = start;
	    	start = node;
	    }
	    
	    public void insertAtEnd(int val) {
	    	Node node = new Node();
	    	node.data = val;
	    	size++;
	    	
	    	if (start == null) {
	    		start = node;
	    		end = start;
	    	}
	    	
	    	end.next = node;
	    	node.next = null;
	    	end = node;
	    }
	    
	    public void insertAtPos(int val, int pos) {
	    	Node node = new Node();
	    	node.data = val;
	    	
	    	Node pointer = start;
	    	for (int i = 1; i < size; i++) {
	    		if (i == pos -1) {
	    			Node temp = pointer.next;
	    			pointer.next = node;
	    			node.next = temp;
	    			break;
	    		}
	    		pointer = pointer.next;
	    	}
	    	
	    	size++;
	    }
	    
	    public void deleteAtPos(int pos) {
	    	
	    	if (pos == 1) {
	    		start = start.next;
	    		size--;
	    		return;
	    	}
	    	
	    	if (pos == size) {
	    		Node s = start;
	    		Node t = start;
	    		
	    		while (s != end) {
	    			t = s;
	    			s = s.next;
	    		}
	    		
	    		end = t;
	    		t.next = null;
	    		size--;
	    		return;
	    	}
	    	
	    	Node pointer = start;
	    	
	    	for (int i = 1; i < size; i++) {
	    		if (i == pos - 1) {
	    			Node temp = pointer.next;
	    			temp = temp.next;
	    			pointer.next = temp;
	    			size--;
	    			return;
	    		}
	    		pointer = pointer.next;
	    	}
	    }
	}

}
