package models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is used to create a collection of questions.
 * 
 * NOTE: Not all methods are actively used in the current implementation of the application. 
 * They are included for future development.
 */

public class MyQuestionsCollection {

	/** Observable list of questions */
	public ObservableList<Questions> questionsList;
	
	/**
	 * This constructor creates a new MyQuestionsCollection object with an
	 * observable list of questions.
	 */
	public MyQuestionsCollection() {
		questionsList = FXCollections.observableArrayList();
	}
	
	/** gets the observable list of questions */
	public ObservableList<Questions> getQuestions() {
		return questionsList;
	}
	
	/** adds a question to the list of questions */
	public void addQuestion(Questions question) {
		questionsList.add(question);
	}
	
	/** removes a question from the observable list of questions */
	public void removeQuestion(Questions question) {
		questionsList.remove(question);
	}
	
	/** clears the observable list of questions */
	public void clearList() {
		questionsList.clear();
	}
	
	/** gets the size of the observable list of questions */
	public int size() {
		return questionsList.size();
	}
	
	/** gets a question from the observable list of questions */
	public Questions getQuestion(int index) {
		return questionsList.get(index);
	}
	
	/** sets a question in the observable list of questions */
	public void setQuestion(int index, Questions question) {
		questionsList.set(index, question);
	}
	
	/** checks if the observable list of questions contains a question */
	public boolean contains(Questions question) {
		return questionsList.contains(question);
	}

}
	

