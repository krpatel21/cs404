
public class LLNode {
		//fields
		private LLNode link;
		private KaushalAccountItemType info;
		
		//contructors
		public LLNode(KaushalAccountItemType info) {
			link = null;
			this.info = info;
		}

		public LLNode getLink() {
			return link;
		}

		public void setLink(LLNode link) {
			this.link = link;
		}

		public KaushalAccountItemType getInfo() {
			return info;
		}

		public void setInfo(KaushalAccountItemType info) {
			this.info = info;
		}
		
		
		
}
