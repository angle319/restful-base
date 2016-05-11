package com.ccolor.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccolor.mybatis.bean.Account;
import com.ccolor.mybatis.service.AccountService;

@Controller
public class WebsocketController {
	@Autowired
	AccountService as;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Account greeting(String message) throws Exception {
		Thread.sleep(3000); // simulated delay
		System.out.println(message);
		Account account= as.getAccount("ACID");
		account.setFirstName(message);
		return account;
	}
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String testHtml(Locale locale, Model model) {
		return "test";
	}
	
	
}
