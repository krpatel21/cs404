
public class BSTNode {

	protected KaushalAccountItemType info;
	protected BSTNode left;
	protected BSTNode right;
	
	public BSTNode(KaushalAccountItemType info){
		this.info = info;
		left = null;
		right = null;
	}

	public KaushalAccountItemType getInfo() {
		return info;
	}

	public void setInfo(KaushalAccountItemType info) {
		this.info = info;
	}
	
	public void setLeft (BSTNode link){
		left = link;
	}
	
	public void setRight (BSTNode link){
		right = link;
	}
		
	public BSTNode getLeft(){
		return left;
	}
	
	public BSTNode getRight(){
		return right;
	}
}
