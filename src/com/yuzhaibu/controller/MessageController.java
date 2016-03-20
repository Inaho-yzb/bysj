package com.yuzhaibu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = ("addMessage"), method = RequestMethod.POST)
	public @ResponseBody AjaxResult addMessage(HttpServletRequest request, HttpSession session) {
		AjaxResult result = new AjaxResult();
		Integer userid = (Integer) session.getAttribute("userid");
		if ( userid == null) {
			result.setErrorCode(2);
			return result;
		}
		
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		String content = request.getParameter("content");
		
		if(itemid==null||content==null||content.length()>256){
			result.setErrorCode(3);
			return result;
		}
		
		if(messageService.addMessage(userid,itemid,content)>0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
	
}
