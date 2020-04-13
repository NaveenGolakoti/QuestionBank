package com.questionbank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionProcessingController {
	
     
	    @RequestMapping("uploadform")  
	    public ModelAndView uploadForm(){  
	        return new ModelAndView("home");    
	    }  
	      
	    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
		public @ResponseBody
		String uploadFileHandler(
				@RequestParam("file") MultipartFile file) throws IOException {
	    	InputStream input = file.getInputStream();
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));



	    	System.out.println("Welcome ****************");
					return "name";

//			if (!file.isEmpty()) {
//				try {
//					byte[] bytes = file.getBytes();
//
//					// Creating the directory to store file
//					String rootPath = System.getProperty("catalina.home");
//					File dir = new File(rootPath + File.separator + "tmpFiles");
//					if (!dir.exists())
//						dir.mkdirs();
//
//					// Create the file on server
//					File serverFile = new File(dir.getAbsolutePath()
//							+ File.separator + name);
//					BufferedOutputStream stream = new BufferedOutputStream(
//							new FileOutputStream(serverFile));
//					stream.write(bytes);
//					stream.close();
//					return "You successfully uploaded file=" + name;
//				} catch (Exception e) {
//					return "You failed to upload " + name + " => " + e.getMessage();
//				}
//			} else {
//				return "You failed to upload " + name
//						+ " because the file was empty.";
//			}
		}
	    }
