package com.questionbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_BANK")
public class QuestionBankEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private int questionNumber;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "QuestionBankEntity [id=" + id + ", questionNumber=" + questionNumber + ", question=" + question
				+ ", type=" + type + ", typeNumber=" + typeNumber + "]";
	}



	private String question;
	private String type;
	private String typeNumber;

	public String getTypeNumber() {
		return typeNumber;
	}

	public void setTypeNumber(String typeNumber) {
		this.typeNumber = typeNumber;
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

	public void setType(String type) {
		this.type = type;
	}
}
