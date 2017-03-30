package com.test.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mydomain.Article;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public LinkedList<Article> get(Model model) {
		FileReader reader;
		
		//FileSystemResource resource;
		LinkedList<Article> articles = null;
		try {
			//resource = new FileSystemResource("classpath:articles.xml");
			reader = new FileReader(getClass().getClassLoader().getResource("articles.xml").getFile());
			// convert "unmarshal" data from XML "articles.xml" to Java object
			// LinkedList<Article>
			articles = (LinkedList<Article>) Unmarshaller.unmarshal(LinkedList.class, reader);
			/*for (Article article : articles) {
				System.out.println(article.getTitle());
			}*/
			
			model.addAttribute("articles", articles);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}

		return articles;

	}
	
	//Read from extension. i.e 
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public LinkedList<Article> json(Model model) {
		FileReader reader;
		
		//FileSystemResource resource;
		LinkedList<Article> articles = null;
		try {
			//resource = new FileSystemResource("classpath:articles.xml");
			reader = new FileReader(getClass().getClassLoader().getResource("articles.xml").getFile());
			// convert "unmarshal" data from XML "articles.xml" to Java object
			// LinkedList<Article>
			articles = (LinkedList<Article>) Unmarshaller.unmarshal(LinkedList.class, reader);
			/*for (Article article : articles) {
				System.out.println(article.getTitle());
			}*/
			
			model.addAttribute("articles", articles);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}

		return articles;

	}
	
/*	@RequestMapping(value="/angular", method = RequestMethod.GET)
	public String getString()
	{
		return "angularpage";
	}*/
	
	
}
