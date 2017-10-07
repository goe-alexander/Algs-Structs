package lists;

import java.util.Scanner;

/*List in which each element has a reference 
 * to the following item as well as the previous item
 * */
public class DoublyLinkedList {
	protected Node start;
	protected Node end;
	protected int size;
	
	public DoublyLinkedList(){
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return start == null;
	}

	public int getSize(){
		return size;
	}
	
	public void insertAtStart(int val){
		Node n = new Node(val, null, null);
		if (start == null){
			start = n;
			end = start;
		}else{
			start.setLinkPrevNode(n);
			n.setLinkNextNode(start);
			start = n;
		}	
		size++;
	}
	
	public void insertAtEnd(int val){
		Node newEnd = new Node(val, null, null);
		if(start == null){
			start = newEnd;
			end = start;
		}else{
			/*Set previous link to actual end
			 *take the end which is second to last now and link to new end.
			 *end now has the new value */
			newEnd.setLinkPrevNode(end);
			end.setLinkNextNode(newEnd);
			end = newEnd;
		}
		size++;
	}
	
	/*Insert element at position*/
	public void insertAtPos(int val, int pos){
		Node newPos = new Node(val, null, null);
		if(pos == 1){
			insertAtStart(val);
			return;
		}		
		
		Node location = start;
		for(int i = 2; i<=size; i++){
			if(i == pos)
			{
				Node tmp = location.getLinkNext();
				location.setLinkNextNode(newPos);
				newPos.setLinkPrevNode(location);
				newPos.setLinkNextNode(tmp);
				tmp.setLinkPrevNode(newPos);
			}
			location = location.getLinkNext();
		}
		size++;
	}
	
	public void deleteAtPosition(int pos){
		if(pos == 1){
			if(size == 1){
				start = null;
				end = null;
				size = 0;
				return;
			}
			start = start.getLinkNext();
			start.setLinkPrevNode(null);
			size--;
		}
		
		if(pos == size){
			end = end.getLinkPrev();
			end.setLinkNextNode(null);
			size--;
		}
		
		Node deletedNode = start.getLinkNext();
		for(int i = 2; i<=size; i++){
			if(i == pos){
				Node p = deletedNode.getLinkPrev();
				Node n = deletedNode.getLinkNext();
				
				p.setLinkNextNode(n);
				n.setLinkPrevNode(p);
				size--;
				return;
			}
			deletedNode = deletedNode.getLinkNext();
		}
		
	}
	
	public void display(){
		System.out.println("\nDoubly Linked List = ");
		if(size == 0){
			System.out.println("empty\n");
			return;
		}
		if(start.getLinkNext() == null){
			System.out.println(start.getData());
			return;
		}
		Node pt = start;
		System.out.print(start.getData() + " <-> " );
		pt = start.getLinkNext();
		while(pt.getLinkNext() != null){
			System.out.print(pt.getData() + " <-> ");
			pt = pt.getLinkNext();
		}
		//reaching the end we need to get on more value
		System.out.print(pt.getData() + "\n");
	}
	
}
