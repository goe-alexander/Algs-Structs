package lists;

public class Node {
	protected int data;
	protected Node next, prev;
	
	public Node(){
		next = null;
		prev = null;
		data = 0;
	}
	
    public Node(int d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }
	
	public void setLinkNextNode(Node n){
		next = n;
	}
	
	public void setLinkPrevNode(Node n){
		prev = n;
	}
	
	public Node getLinkNext(){
		return next;
	}

	public Node getLinkPrev(){
		return prev;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
