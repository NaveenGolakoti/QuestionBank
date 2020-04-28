package com.questionbank.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.questionbank.dao.QuestionBankProcessorDao;
import com.questionbank.dto.QuestionBankDto;
import com.questionbank.entity.QuestionBankEntity;
import com.questionbank.util.HibernateUtil;

@Repository
public class QuestionBankProcessorDaoImpl extends HibernateUtil implements QuestionBankProcessorDao {

	@Override
	public void addQuestions(List<QuestionBankEntity> list) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		for (QuestionBankEntity qe : list) {
			session.save(qe);
		}

	}

	@Override
		// TODO Auto-generated method stub
	public List<QuestionBankEntity> getQuestions(String type) {
		String hql = "";
		Session session = this.getSession();
		
			hql = "FROM QuestionBankEntity q WHERE q.type = :value";
		Query query = session.createQuery(hql);
		query.setString("value", type);
		List<QuestionBankEntity> list = query.list();
		for(QuestionBankEntity q : list){
			System.out.println(q.toString());
		}
		return list;
	}

	@Override
	public List<QuestionBankEntity> getQuestions(String type, String typeNumber) {
		// TODO Auto-generated method stub
		String hql = "";
		Session session = this.getSession();
		
			hql = "FROM QuestionBankEntity q WHERE q.type = :value and q.typeNumber =:value1";
		Query query = session.createQuery(hql);
		query.setString("value", type);
		query.setString("value1",typeNumber);
		List<QuestionBankEntity> list = query.list();
		for(QuestionBankEntity q : list){
			System.out.println(q.toString());
		}
		return list;
	}

}
