package heap.priorityqueue;

public class TreeClass {
	Node root;
	
	public class Node {
		int data;
		Node left;
		Node right;
		
		public Node(){
			left = null;
			right = null;
		}
		
		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
			
		
	}
	
	
	public int height(Node root){
		if(root == null)
			return -1;
		
		if(root.left == null && root.right == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	
	@Override
	public String toString() {
		return "TreeClass [root=" + root + "]";
	}

	public Node insert(Node root, int data){
		if(root == null)
			return new Node(data);
		
		if(root.data < data)
			root.right = insert(root.right, data);
		else if(root.data > data)
			root.left = insert(root.left, data);
		
		return root;	
	}
	
	public boolean isEqual(Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null){
			return root1.data == root2.data && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
		}
			
		return false;
	}
	
	public boolean isBST(Node root, int leftbound, int rightbound){
		if(root == null)
			return true;
		
		return root.data > leftbound && root.data < rightbound && isBST(root.left, leftbound, root.data) && isBST(root.right, root.data, rightbound);
		
	}
	
	public void swap(Node root){
		int temp = root.left.data;
		root.left.data = root.data;
		root.data = temp;
	}
	
	public static void main(String[] argv){
		
		TreeClass bst = new TreeClass();
		Node root = null;
		
		root = bst.insert(root, 7);
		root = bst.insert(root, 4);
		root = bst.insert(root, 9);
		root = bst.insert(root, 1);
		root = bst.insert(root, 6);
		root = bst.insert(root, 8);
		root = bst.insert(root, 10);
		
		//bst.swap(root);
		
		System.out.println(root);
		System.out.println(bst.height(root));
		System.out.println(bst.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
