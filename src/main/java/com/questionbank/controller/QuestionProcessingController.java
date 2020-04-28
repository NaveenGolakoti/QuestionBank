package com.questionbank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.questionbank.entity.QuestionBankEntity;
import com.questionbank.service.QuestionBankProcessorService;

@Controller
public class QuestionProcessingController {
	@Autowired
	private QuestionBankProcessorService questionBankProcessorService;
	List<QuestionBankEntity> list = new ArrayList<QuestionBankEntity>();

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {
		InputStream input = file.getInputStream();
		Properties prop = new Properties();
		if (input == null) {
			System.out.println("Sorry, unable to find properties");
			return null;
		}

		// load a properties file from class path, inside static method
		prop.load(input);
		// get the property value and print it out
	    prop.forEach((key, value) ->{ 
		QuestionBankEntity questionBankEntity = new QuestionBankEntity();
	    System.out.println(key + " : " + value);
	    String arr[] = ((String) key).split("-");
		questionBankEntity.setType(arr[0]);
	    questionBankEntity.setQuestion((String) value);
		questionBankEntity.setTypeNumber(arr[1]);
		questionBankEntity.setQuestionNumber(Integer.parseInt(arr[2]));
		list.add(questionBankEntity);

	    });
		questionBankProcessorService.addQuestions(list);
	    ModelAndView mav = new ModelAndView("savesuccess");  
		return mav;

	}
}
