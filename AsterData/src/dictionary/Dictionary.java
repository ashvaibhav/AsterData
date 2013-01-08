package dictionary;
import datastructure.Tree;
public class Dictionary {
	private Tree db;
	/**
	 * Default Constructor
	 */
	public Dictionary(){
		super();
		db = new Tree();
	}
	/**
	 * Method to add a word with no meaning. Word will be created only if no such word exists already
	 * @param word
	 * @return true if word was added successfully
	 * @throws Exception
	 */
	public boolean addWord(String word) throws Exception{

		/*First word being added to dictionary*/
		if(db==null){
			db = new Tree();
		}
		return db.addWord(word);
	}
	/**
	 * Method to add a word with specified meaning. Word will be created only if no such word exists already. Meaning will NOT BE Overwritten
	 * @param word
	 * @param meaning
	 * @return true if word was added successfully
	 * @throws Exception
	 */
	public boolean addWord(String word, String meaning) throws Exception{
		return db.addWord(word, meaning);
	}
	/**
	 * Method to add meaning to an already existing word. Meaning will NOT BE overwritten on already existing meaning.
	 * @param word
	 * @param meaning
	 * @return true if meaning was added succesfully
	 */
	public boolean  addMeaning(String word, String meaning){
		//(db.search(word)).addMeaning(meaning);
		return db.addMeaning(word, meaning);
	}

	/**
	 * Method to see the complete dictionary listing alphabetically.
	 */
	public void showAllWords(){

		db.displayAllWords();
	}
	/**
	 * Method to retrieve meaning of a specified word.
	 * @param word
	 * @return the meaning description in String 
	 */
	public String getMeaning(String word){
		//return (db.search(word)).getMeaning();
		return db.getMeaning(word);
	}
	/**
	 * Method to update the meaning of any given word in the dictionary.
	 * @param word
	 * @param meaning
	 * @return
	 * @throws Exception
	 */
	public boolean updateMeaning(String word, String meaning) throws Exception{
		return db.updateWordMeaning(word, meaning);
	}
	/**
	 * Method to delete a word from the dictionary.
	 * @param word
	 * @return true if word deleted successfully
	 * @throws Exception
	 */
	public boolean deleteWord(String word) throws Exception{
		//(db.search(word))
		return db.deleteWord(word);
	}
	
	public void showAllWords(String prefix){
		db.displayAllWords(prefix);
	}
}
