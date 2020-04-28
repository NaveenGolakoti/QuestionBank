package com.questionbank.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.QuestionBankProcessorDao;
import com.questionbank.entity.QuestionBankEntity;
import com.questionbank.service.QuestionBankProcessorService;

@Service
public class QuestionBankProcessorServiceImpl implements QuestionBankProcessorService{
    @Autowired
	private QuestionBankProcessorDao questionBankProcessorDao;
	@Override
	public void addQuestions(List<QuestionBankEntity> list) {
		// TODO Auto-generated method stub
		
	 questionBankProcessorDao.addQuestions(list);
	}

}
