package com.ccolor.web;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ccolor.mybatis.bean.Account;
import com.ccolor.mybatis.mapper.AccountMapper;
import com.ccolor.mybatis.service.AccountService;

/**
 * Handles requests for the application home page.
 */
@RestController

public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	AccountService as;
	@Autowired
	private HttpSession httpSession;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET , produces = "application/json")
	public  Account home(Locale locale, Model model,HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		Account account=as.getAccount("ACID");
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate +account.getCity());
		
		return "index";*/
		 /*try {
			//response.sendRedirect("test");
			 response.sendError(403);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 return as.getAccount("ACID");
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> fetchWellData(Locale locale, Model model){
		  try {
			  throw new NullPointerException("demo");
		  } catch(NullPointerException e) {
			  String errorMessage;
		      errorMessage = e + " <== error";
		      return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		  }
		
	}
	@RequestMapping(value = "/session", method = RequestMethod.GET, produces = "application/json")
	public  String  sessionTest(Locale locale, Model model){
		
		return httpSession.getId();
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Account> update(@RequestBody Account account) {
		return  new ResponseEntity<Account>(account, HttpStatus.ACCEPTED);
	}
	
}
