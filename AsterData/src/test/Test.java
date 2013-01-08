package test;

import dictionary.Dictionary;

public final class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dict = new Dictionary();
		try
		{
			
			//Tests for addWord, addMeaning, getMeaning, updateMeaning
			dict.addWord("abc","asdf");
			dict.addWord("aa","as");
			dict.addWord("ab","test");
			dict.getMeaning("ab");
			dict.addWord("cd");
			dict.getMeaning("cd");
			dict.addMeaning("cd","meaning");
			dict.getMeaning("cd");
			dict.addWord("a");
			dict.updateMeaning("a","check");
			dict.addWord("Word", "Meaning");
			
			//Tests for deletingWords
			dict.deleteWord("ef");

			//Test to retrieve all words with or without prefix
			dict.showAllWords();
			System.out.println("\n\n****Words with prefix ab***");
			dict.showAllWords("ab");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
