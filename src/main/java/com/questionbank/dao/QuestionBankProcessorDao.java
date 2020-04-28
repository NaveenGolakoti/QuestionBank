package com.questionbank.dao;

import java.util.List;

import com.questionbank.dto.QuestionBankDto;
import com.questionbank.entity.QuestionBankEntity;

public interface QuestionBankProcessorDao {

	
	public void addQuestions(List<QuestionBankEntity> list);
	
	public List<QuestionBankEntity> getQuestions(String type);
	
	public List<QuestionBankEntity> getQuestions(String type, String typeNumber);
}
