package datastructure;


public class Tree{
	/*
	 * This is a 27-way Search Tree. 
	 * Every node has 27 place-holders.
	 * First 26 correspond to a pointer to another tree below
	 * 27th correspond to a Word object
	 * Another reference is stored to point to the parent (just in case).
	 */
	Node root;
	private Node currentNode;
	private int MAX = 26;
	/**
	 * Constructor
	 */
	public Tree(){
		super();
		root = new Node(null,null);
	}
	/**
	 * Method to display all the items being stored in the inhouse Tree data structure implemented
	 * @param prefix
	 */
	public void displayAllWords(String prefix) {
		// TODO Auto-generated method stub
		updateCurrentNode(prefix);
		traverse(currentNode, 0);
	}
	/**
	 * Private Method to display information of the current node. Called from traverse method
	 * @param cur
	 */
	private void visit(Node cur){
		if(cur.word!=null && cur.word.getWord()!=null)
			System.out.println(cur.word.getWord()+"\t"+cur.word.getMeaning());
	}
	/**
	 * Private Recursive Method for preorder traversal of the entire 27-way tree. Calls visit method to display information.
	 * @param cur
	 * @param pos
	 */
	private void traverse(Node cur, int pos){
		if(cur==null)
			return;
		//Following preorder traversal
		if(pos==0)
			visit(cur);
		//Visiting children from left to right.
		while(pos<MAX){
			if(cur.pointers[pos]!=null)
				traverse(cur.pointers[pos],0);
			pos++;
		}
		//Returning to parent
		return;
	}
	
	/**
	 * Publicly available Method to view entire tree via preorder traversal. 
	 */
	public void displayAllWords() {
		traverse(root, 0);
	}
	
	/**
	 * Very important private method to be used to identify the location of the word being searched. In its way, it also creates Node objects if they do not exist. Hence, method would be slow during the initial population of the dictionary.
	 * Performance can be improved by removing the object creation capability and making corresponding changes in a couple of other methods.  
	 * @param word
	 */
	private void updateCurrentNode(String word){
		int length = word.length();
		word = word.toLowerCase();
		currentNode = root;
		if(currentNode==null)
			currentNode = new Node(null,null);//Initializing Root node which ideally should not be needed. Assertion is that currentNode!=null 
		for(int i=0;i<length;i++){
			if(currentNode.pointers[word.charAt(i)-'a']==null){
				currentNode.pointers[word.charAt(i)-'a'] = new Node(currentNode);
			}
			currentNode = currentNode.pointers[word.charAt(i)-'a'];
		}
	}
	/**
	 * Method to add value to key in the tree nodes
	 * @param word
	 * @param meaning
	 * @return
	 */
	public boolean addMeaning(String word, String meaning){
		updateCurrentNode(word);
		if(currentNode.word!=null){
			currentNode.word.addMeaning(meaning);
			return true;
		}
		return false;
	}
	/**
	 * Method to get value corresponding to a key in the tree nodes.
	 * @param word
	 * @return
	 */
	public String getMeaning(String word){
		updateCurrentNode(word);
		if(currentNode.word!=null){
			return currentNode.word.getMeaning();
		}
		return null;
	}
	/**
	 * Method which deletes nodes corresponding to given key.
	 * @param word
	 * @return
	 * @throws Exception
	 */
	public boolean deleteWord(String word) throws Exception{
		updateCurrentNode(word);
		if(currentNode.word!=null){
			currentNode.word = null;
			return true;
		}
		return false;
	}
	/**
	 * Algo -> 1. Search word position. 2. Check if word exists then return false. 3. If word doesn't exist, add new word and return true.
	 * @param word
	 * @return true if word didn't exist earlier
	 * @throws Exception
	 */
	public boolean addWord(String word) throws Exception{
		updateCurrentNode(word);		
		if(currentNode.word==null){
			currentNode.word = new Word(word);
			return true;
		}		
		return false;//Word already existed
	}
	/**
	 * Algo -> 1. Search word position. 2. Check if word exists then return false. 3. If word doesn't exist, add new word and return true.
	 * @param word
	 * @param meaning
	 * @return true if word didn't exist earlier
	 * @throws Exception
	 */
	public boolean addWord(String word, String meaning) throws Exception{
		updateCurrentNode(word);
		if(currentNode.word==null){
			currentNode.word = new Word(word);
			currentNode.word.addMeaning(meaning);
			return true;
		}		
		return false;//Word already existed
	}
	/**
	 * To update value for a given key.
	 * @param word
	 * @param meaning
	 * @return
	 * @throws Exception
	 */
	public boolean updateWordMeaning(String word, String meaning) throws Exception{
		updateCurrentNode(word);
		if(currentNode.word!=null){
			currentNode.word.updateMeaning(meaning);
			return true;
		}
		return false;
	}
}
