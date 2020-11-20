
package btree;

/**
 * 
 * @author null
 *
 */
public class BinaryTree {
	
	/**
	 *  
	 */
	private Node root;
	
	/**
	 * 
	 * @param rootValue
	 */
	public BinaryTree(String rootValue) {
		root = new Node(rootValue);
	}
	
	
	public BinaryTree(){
		root = null;
	}
	public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
		root = new Node(rootValue, left, right);
	}
	
	public void insert(String aData){
		if(root == null) root = new Node(aData);
			
		if(aData.compareTo(root.getData()) < 0) {
			if(root.getLeft() == null) 	root.setLeft(new BinaryTree(aData));
			else 						root.getLeft().insert(aData);
		}
		if(aData.compareTo(root.getData()) > 0) {
			if(root.getRight() == null) 	root.setRight(new BinaryTree(aData));
			else 						root.getRight().insert(aData);
		}
	}
	
	public BinaryTree find(String aData){
		if(root == null) return null;
		if(aData.compareTo(root.getData()) == 0) return this;
		
		if(aData.compareTo(root.getData()) < 0 && root.getLeft() != null)
			return root.getLeft().find(aData);
		if(aData.compareTo(root.getData()) > 0 && root.getRight() != null)
			return root.getRight().find(aData);
		
		return null;
	}
	
	public BinaryTree findLeftMost() { //Etsii vasemman puoleisimman silmukan
		return (root.getLeft() != null) ? root.getLeft().findLeftMost(): this;
	}
	
	public void deleteNode(String aData) {//TODO: .getRoot().left() => .getLeft()
		BinaryTree foundTree = find(aData);
		if(foundTree == null) return; //TAPAUS 1: Etsittävä ei löydy
		
		if(foundTree.getLeft() == null && foundTree.getRight() == null) {
			foundTree.setRoot(null); //2. Silmukka on lehti silmukka
			return;
		}

		if((foundTree.getLeft() != null)^(foundTree.getRight() != null)) { //TAPAUS 3: Silmukalla on joko oikea tai vasen lapsisilmukka
			if(foundTree.getLeft() != null) foundTree.setRoot(foundTree.getLeft().getRoot());
			
			if(foundTree.getRight() != null) foundTree.setRoot(foundTree.getRight().getRoot()); //Asetetaan lapsisilmukka silmukan tilalle
			return; // välttämätön jotta ei siirryttäisi seuraavaan if lohkoon
		}
		
		if((foundTree.getLeft() != null)&&(foundTree.getRight() != null)) { //TAPAUS 4: Silmukalla on oikea JA vasen lapsi silmukka
			BinaryTree rightMostChild = foundTree.getRight().findLeftMost(); //Etsii vasemmasta silmukasta oikeapuoleisimman lehtisilmukan
			foundTree.setData(rightMostChild.getData());
			rightMostChild.setRoot(null);
			return;
		}
	}
	
	public int laskeKorkeus() {
		int v = 0, o = 0;
		
		if(root.getLeft() != null) v = laskeKorkeus(v);
		if(root.getRight() != null) o = laskeKorkeus(o);
		
		return (v >= o) ? v: o;
	}
	
	public int laskeKorkeus(String data) {
		int v = 0, o = 0;
		BinaryTree foundTree = find(data);
		
		if(foundTree == null) return -1;
		if(foundTree.getLeft() != null) v = foundTree.laskeKorkeus(v);
		if(foundTree.getRight() != null) o = foundTree.laskeKorkeus(o);
		
		return (v >= o) ? v: o;
	}
	
	public int laskeKorkeus(int korkeus) {
		int v = korkeus, o = korkeus;

		if(root.getLeft() != null) v = root.getLeft().laskeKorkeus(++v);
		if(root.getRight() != null) o = root.getRight().laskeKorkeus(++o);
		
		return (v >= o) ? v: o;
	}
	
	public void preOrder() {
		if (root == null) return;
		System.out.println(root.getData()+',');
		if (root.getLeft() != null)	root.getLeft().preOrder();
		if (root.getRight() != null) root.getRight().preOrder();
	}
	
	public Node getRoot() {
		return root;
	}
	public String getData() {
		return root.getData();
	}
	public BinaryTree getRight() {
		return root.getRight();
	}
	public BinaryTree getLeft() {
		return root.getLeft();
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	public void setData(String data) {
		root.setData(data);
	}
	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}
	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}
}