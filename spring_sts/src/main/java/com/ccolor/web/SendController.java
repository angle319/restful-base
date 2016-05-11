package com.ccolor.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class SendController {
	@Autowired
	private SimpMessagingTemplate template;
	@RequestMapping(value = "/ws/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> testWS(Locale locale, Model model,HttpServletRequest request,@PathVariable String id) {
		this.template.convertAndSendToUser(id,"/reply", "sendMessage:"+request.getRemoteAddr()+":"+request.getHeader("User-Agent"));
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
