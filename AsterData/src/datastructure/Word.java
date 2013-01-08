package datastructure;

/**
 * @author Vaibhav
 *	The basic dictionary element having word and definition pairs.
 */
public class Word{
	private String key;
	private String definition;
	
	/**
	 * If a new word object is created without any definition
	 * @param word
	 * @throws Exception
	 */
	public Word(String word) throws Exception{
		super();
		if(!isWordValid(word))
			throw new Exception();		
		key = word;
		definition = "";
	}
	public void updateMeaning(String meaning) {
		// TODO Auto-generated method stub
		this.definition = meaning;
	}
	public void addMeaning(String meaning){
		definition = meaning;
	}
	
	/**
	 * If a new word object is created along with its definition
	 * @param word
	 * @param meaning
	 * @throws Exception
	 */
	public Word(String word, String meaning) throws Exception{
		super();
		if(!isWordValid(word))
			throw new Exception();
		key = word;
		definition = meaning;
	}
	public String getWord(){
		return key;
	}
	/**
	 * Return the meaning of a given word
	 * @param word
	 * @return
	 * @throws Exception
	 */
	public String getMeaning(){
		return definition;
	}
	/**
	 * Given a word, to validate if it is correct or incorrect.
	 * Invalid word -> It is possible to give empty string, or something with numbers of special characters.
	 * @param word
	 * @return
	 */
	private boolean isWordValid(String word){
		if(word.isEmpty())
			return false;
		return true;
	}
}
