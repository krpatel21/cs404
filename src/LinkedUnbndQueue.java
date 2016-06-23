
public class LinkedUnbndQueue implements UnboundedQueueInterface {
	protected LLNode front;
	protected LLNode rear;
	
	
	public LinkedUnbndQueue() {
		front = null;
		rear = null;
	}
	
	@Override
	public void enqueue(KaushalAccountItemType element) {
		LLNode newNode = new LLNode(element);		
		if (rear == null){
			front = newNode;
		}
		else{
			rear.setLink(newNode);
		}
		rear = newNode;
	}
	
	public KaushalAccountItemType dequeue() throws QueueUnderflowException{
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue");
		else{
			KaushalAccountItemType element;
			element = front.getInfo();
			front = front.getLink();
			if (front ==null)
				rear = null;
			
			return element;
		}			
	}
	
	public boolean isEmpty(){
		return (front ==null);
	}
	   public String toString()
	   {
	      String result = "";
	      LLNode current = front;

	      while (current != null)
	      {
	         result = result + (current.getInfo()).toString() + "\n";
	         current = current.getLink();
	      }

	      return result;
	   }
	
}
