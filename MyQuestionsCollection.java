package models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class MyQuestionsCollection {

	public ObservableList<Questions> questionsList;
	
	
	public MyQuestionsCollection() {
		questionsList = FXCollections.observableArrayList();
	}
	
	public ObservableList<Questions> getQuestions() {
		return questionsList;
	}
	
	public void addQuestion(Questions question) {
		questionsList.add(question);
	}
	
	public void removeQuestion(Questions question) {
		questionsList.remove(question);
	}
	
	public void clearList() {
		questionsList.clear();
	}
	
	public int size() {
		return questionsList.size();
	}
	
	public Questions getQuestion(int index) {
		return questionsList.get(index);
	}
	
	public void setQuestion(int index, Questions question) {
		questionsList.set(index, question);
	}
	
	public boolean contains(Questions question) {
		return questionsList.contains(question);
	}

}
	

