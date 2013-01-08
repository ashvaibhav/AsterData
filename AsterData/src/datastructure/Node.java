package datastructure;



/**
 * @author Vaibhav
 * The Node is basic element which is used by Tree class.
 */
public class Node{
	Node pointers[] = new Node[26];		/*From a-z*/
	Node parent;						/*pointing towards parent. would be null only in case of root.*/
	Word word;							/*if the word is exactly as the location.*/
	public Node(Node parent, Word word){
		this.parent = parent;
		this.word = word;
	}
	public Node (Node parent){
		this.parent = parent;
		this.word = null;
	}

}