package com.questionbank.dto;

public class QuestionBankDto {
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "QuestionBankDto [id=" + id + ", questionNumber=" + questionNumber + ", question=" + question + ", type="
				+ type + ", typeNumber=" + typeNumber + "]";
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(String typeNumber) {
		this.typeNumber = typeNumber;
	}
	private int questionNumber;
	private String question;
	private String type;
	private String typeNumber;

}
