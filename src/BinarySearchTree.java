public class BinarySearchTree implements BSTInterface {
	protected BSTNode root;
	boolean found;

	// for traversals
	protected LinkedUnbndQueue inOrderQueue; // queue of info
	protected LinkedUnbndQueue preOrderQueue; // queue of info
	protected LinkedUnbndQueue postOrderQueue; // queue of info

	public BinarySearchTree()
	// Creates an empty BST object.
	{
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public int size() {
		return recSize(root);
	}

	private int recSize(BSTNode tree) {
		if (tree == null) {
			return 0;
		} else
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}

	private boolean recContains(KaushalAccountItemType element, BSTNode tree)
	// Returns true if tree contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns false.
	{
		if (tree == null)
			return false; // element is not found
		else if (element.compareTo(tree.getInfo()) < 0)
			return recContains(element, tree.getLeft()); // Search left subtree
		else if (element.compareTo(tree.getInfo()) > 0)
			return recContains(element, tree.getRight()); // Search right
															// subtree
		else
			return true; // element is found
	}

	@Override
	public boolean contains(KaushalAccountItemType element) {
		return recContains(element, root);
	}

	private KaushalAccountItemType recGet(KaushalAccountItemType element,
			BSTNode tree)
	// Returns an element e from tree such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		if (tree == null)
			return null; // element is not found
		else if (element.compareTo(tree.getInfo()) < 0)
			return recGet(element, tree.getLeft()); // get from left subtree
		else if (element.compareTo(tree.getInfo()) > 0)
			return recGet(element, tree.getRight()); // get from right subtree
		else
			return tree.getInfo(); // element is found
	}

	@Override
	public boolean remove(KaushalAccountItemType element) {
		root = recRemove(element, root);
		return found;
	}

	private BSTNode recRemove(KaushalAccountItemType element, BSTNode tree)
	// Removes an element e from tree such that e.compareTo(element) == 0
	// and returns true; if no such element exists, returns false.
	{
		if (tree == null)
			found = false;
		else if (element.compareTo(tree.getInfo()) < 0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if (element.compareTo(tree.getInfo()) > 0)
			tree.setRight(recRemove(element, tree.getRight()));
		else {
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}

	private BSTNode removeNode(BSTNode tree)
	// Removes the information at the node referenced by tree.
	// The user's data in the node referenced by tree is no
	// longer in the tree. If tree is a leaf node or has only
	// a non-null child pointer, the node pointed to by tree is
	// removed; otherwise, the user's data is replaced by its
	// logical predecessor and the predecessor's node is removed.
	{
		KaushalAccountItemType data;

		if (tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else {
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}

	private KaushalAccountItemType getPredecessor(BSTNode tree)
	// Returns the information held in the rightmost node in tree
	{
		while (tree.getRight() != null)
			tree = tree.getRight();
		return tree.getInfo();
	}

	@Override
	public KaushalAccountItemType get(KaushalAccountItemType element) {
		return recGet(element, root);
	}

	@Override
	public void add(KaushalAccountItemType element) {
		root = recAdd(element, root);
	}

	private BSTNode recAdd(KaushalAccountItemType element, BSTNode tree)
	// Adds element to tree; tree retains its BST property.
	{
		if (tree == null)
			// Addition place found
			tree = new BSTNode(element);
		else if (element.compareTo(tree.getInfo()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft())); // Add in left
															// subtree
		else
			tree.setRight(recAdd(element, tree.getRight())); // Add in right
																// subtree
		return tree;
	}

	@Override
	public int reset(int orderType) {
		int numNodes = size();

		if (orderType == INORDER) {
			inOrderQueue = new LinkedUnbndQueue();
			inOrder(root);
		} else if (orderType == PREORDER) {
			preOrderQueue = new LinkedUnbndQueue();
			preOrder(root);
		}
		if (orderType == POSTORDER) {
			postOrderQueue = new LinkedUnbndQueue();
			postOrder(root);
		}
		return numNodes;
	}

	@Override
	public KaushalAccountItemType getNext(int orderType)
			throws QueueUnderflowException {
		{
			if (orderType == INORDER)
				return inOrderQueue.dequeue();
			else if (orderType == PREORDER)
				return preOrderQueue.dequeue();
			else if (orderType == POSTORDER)
				return postOrderQueue.dequeue();
			else
				return null;
		}
	}

	private void inOrder(BSTNode tree)
	// Initializes inOrderQueue with tree elements in inOrder order.
	{
		if (tree != null) {
			inOrder(tree.getLeft());
			inOrderQueue.enqueue(tree.getInfo());
			inOrder(tree.getRight());
		}
	}

	private void preOrder(BSTNode tree)
	// Initializes preOrderQueue with tree elements in preOrder order.
	{
		if (tree != null) {
			preOrderQueue.enqueue(tree.getInfo());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	private void postOrder(BSTNode tree)
	// Initializes postOrderQueue with tree elements in postOrder order.
	{
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			postOrderQueue.enqueue(tree.getInfo());
		}
	}

}
