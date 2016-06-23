
public interface BSTInterface
{
	static final int INORDER = 1;
	static final int PREORDER = 2;
	static final int POSTORDER = 3;
	
	boolean isEmpty();
	
	int size();
	
	boolean contains(KaushalAccountItemType element);
	
	boolean remove(KaushalAccountItemType element);
	
	KaushalAccountItemType get(KaushalAccountItemType elemnt);
	
	void add (KaushalAccountItemType element);
	
	int reset(int orderType);
	
	KaushalAccountItemType getNext (int orderType) throws QueueUnderflowException;
	
}
