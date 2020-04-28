package com.questionbank.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.questionbank.dao.QuestionBankProcessorDao;
import com.questionbank.dto.QuestionBankDto;
import com.questionbank.entity.QuestionBankEntity;
import com.questionbank.util.PDFView;

@Controller
public class PdfController {
	@Autowired
	QuestionBankProcessorDao questionBankProcessorDao;

	@RequestMapping(value = "/generateAssignmentPdf.htm", method = RequestMethod.GET)
	public ModelAndView generateAssignmentPdf(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<QuestionBankEntity> list = questionBankProcessorDao.getQuestions("assignment");
		Set<String> list1 = new HashSet<String>();

		for (QuestionBankEntity qe : list) {
			list1.add(qe.getTypeNumber());
		}
		return new ModelAndView("assignmentpdflinks", "list", list1);
	}

	@RequestMapping(value = "/generateTestPdf.htm", method = RequestMethod.GET)
	public ModelAndView generateTestPdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<QuestionBankEntity> list = questionBankProcessorDao.getQuestions("test");
		Set<String> list1 = new HashSet<String>();

		for (QuestionBankEntity qe : list) {
			list1.add(qe.getTypeNumber());
		}

		return new ModelAndView("testpdflinks", "list", list1);
	}

	private static ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);

			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	@RequestMapping(value = "/downloadPdf", method = RequestMethod.GET)
	public void redirect(@RequestParam("type") String type, @RequestParam("typeNumber") String typeNumber,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Calling generatePdf()...");
		System.out.println("type:::"+type);
	     System.out.println("type Number:::"+typeNumber);
		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();

		String fileName = "Generate_Report_" + type + typeNumber + ".pdf";
		List<QuestionBankEntity> list = questionBankProcessorDao.getQuestions(type, typeNumber);
		List<QuestionBankDto> list1 = new ArrayList<QuestionBankDto>();

		for (QuestionBankEntity qe : list) {
			QuestionBankDto questionBankDto = new QuestionBankDto();
			questionBankDto.setId(qe.getId());
			questionBankDto.setQuestion(qe.getQuestion());
			questionBankDto.setQuestionNumber(qe.getQuestionNumber());
			questionBankDto.setType(qe.getType());
			questionBankDto.setTypeNumber(qe.getTypeNumber());
			list1.add(questionBankDto);
		}
		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + fileName);

		try {

			PDFView.createPDF(temperotyFilePath + "\\" + fileName,list1);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}