package com.questionbank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionBankEntity {
    @Id
	private int questionNumber;
	private String question;
	private String type;

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

	public void setType(String type) {
		this.type = type;
	}
}
