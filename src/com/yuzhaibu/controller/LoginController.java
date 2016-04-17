package com.yuzhaibu.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.Mail;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.MailUtil;
import com.yuzhaibu.util.StringUtils;

@Controller
public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1824613938168248847L;
	@Resource
	private User_normalService user_normalService;
	
	@RequestMapping("/login/toLogin")
	public String toLogin(HttpSession session,HttpServletRequest request,ModelMap model){
		if(session.getAttribute("username")==null){
			String reUrl = request.getParameter("url");
			if(reUrl!=null){
				model.put("url", reUrl);
			}
			model.addAttribute("tt", "登录");
			return "login";
		}
		return "redirect:../user/toProfile.htm";
	}
	
	
	
	@RequestMapping("/login/checkLogin")
	public String login(String username,String pwd,HttpSession session,HttpServletRequest request,ModelMap model){
		User_normal user = user_normalService.findUserByUsernameAndPwd(username, StringUtils.string2MD5(pwd));
		
		if(user!=null){
			session.setAttribute("username", username);
			session.setAttribute("userid", user.getUsernormal_id());
			String url = request.getParameter("url");
			if(url!=null){
				return "redirect:../"+url;
			}
			return "redirect:../user/toProfile.htm";
		}else{
			model.addAttribute("tt", "登录");
			request.setAttribute("loginmessage", "用户名密码错误");
			return "login";
		}
	}
	
	@RequestMapping("/login/toRegistered")
	public String toRegistered(HttpServletRequest request,ModelMap model){
		model.addAttribute("tt", "注册");
		return "registered";
	}
	
	@RequestMapping("/login/ajaxcheckusername")
	@ResponseBody
	public AjaxResult checkusername(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		String username = request.getParameter("username");
		if(StringUtils.isBlank(username)||username.length()>20||!username.matches("[a-zA-Z0-9_.]{6,20}")){
			result.setErrorCode(1);
		}else{
			if(user_normalService.findUserByUsername(username)==null){
				result.setErrorCode(0);
			}else{
				result.setErrorCode(2);
			}
		}
		return result;
	}
	
	@RequestMapping(value=("/login/reg"),method=RequestMethod.POST)
	public String reg(HttpServletRequest request,ModelMap model,HttpSession session){
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		model.put("tt","注册" );
		if(StringUtils.isBlank(username)||username.length()>20||!username.matches("[a-zA-Z0-9_.]{6,20}")){
			model.addAttribute("errorMes", "请检查用户名是否符合规范！");
			return "loginerror";
		}
		
		if(StringUtils.isBlank(nickname)||nickname.length()>20||!nickname.matches("[a-zA-Z0-9_.]{6,20}")){
			model.addAttribute("errorMes", "请检查昵称是否符合规范！");
			return "loginerror";
		}
		
		if(StringUtils.isBlank(pwd)||pwd.length()>15||!pwd.matches("[a-zA-Z0-9]{8,15}")){
			model.addAttribute("errorMes", "请检查密码是否符合规范！");
			return "loginerror";
		}
		
		if(StringUtils.isBlank(email)||!email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
			model.addAttribute("errorMes", "请检查邮箱是否符合规范！");
			return "loginerror";
		}
		
		User_normal user = new User_normal();
		user.setUsername(username);
		user.setNickname(nickname);
		user.setPwd(StringUtils.string2MD5(pwd));
		user.setEmail(email);
		user.setHeadimg("/images/defualthead.jpg");
		
		if(user_normalService.regUser(user)>0){
			User_normal us = user_normalService.findUserByUsername(username);
			session.setAttribute("userid", us.getUsernormal_id());
			session.setAttribute("username", username);
			model.put("tt","注册成功" );
			return "regsuccess";
		}else{
			model.addAttribute("errorMes","注册失败，请稍候再试！");
			model.put("tt","注册失败" );
			return "loginerror";
		}
	}
	
	@RequestMapping(value=("/login/ajaxchecklogin"),method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult ajaxchecklogin(HttpSession session){
		AjaxResult result = new AjaxResult();
		if(session.getAttribute("username")==null){
			result.setErrorCode(1);
		}else{
			result.setErrorCode(0);
		}
		return result;
	}
	
	@RequestMapping(value=("/login/forgetpassword"),method=RequestMethod.GET)
	public String toForget(HttpServletRequest request){
		return "forgetpassword";
	}
	
	@RequestMapping(value=("/login/forgetpassword"),method=RequestMethod.POST)
	public String forget(HttpServletRequest request,ModelMap model){
		String username = request.getParameter("username");
		if(username!=null){
			User_normal user = user_normalService.findUserByUsername(username);
			if(user!=null){
				Integer id = user.getUsernormal_id();
				String str = StringUtils.getRandomMD5Str();
				user_normalService.deleteForgetById(id);
				user_normalService.addForget(id,str);
				Mail mail = new Mail();
				mail.setReceiver(user.getEmail());
				mail.setMessage("您的重置密码链接：http://bysj.yuzhaibu.com/login/resetpwd.htm?vcode="+str+"&uid="+id);
				if(MailUtil.send(mail)){
					model.put("successMes","已发送重置邮件！");
					model.put("returnurl", "/index.htm");
					model.put("returnname", "首页");
					return "success";
				}else{
					model.put("errorMes", "服务器出错！");
					model.put("returnurl", "/login/forgetpassword.htm");
					model.put("returnname", "忘记密码");
					return "fail";
				}
			}else{
				model.put("errorMes", "用户名不存在");
				model.put("returnurl", "/login/forgetpassword.htm");
				model.put("returnname", "忘记密码");
				return "fail";
			}
		}else{
			model.put("errorMes", "用户名不能为空");
			model.put("returnurl", "/login/forgetpassword.htm");
			model.put("returnname", "忘记密码");
			return "fail";
		}
		
	}
	
	@RequestMapping(value=("/login/resetpwd"),method=RequestMethod.GET)
	public String toResetPwd(HttpServletRequest request,ModelMap model){
		String vCode = request.getParameter("vcode");
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		
		if(user_normalService.findForget(vCode,uid)){
			model.put("vcode", vCode);
			model.put("uid", uid);
			return "resetpwd";
		}else{
			model.put("errorMes", "系统错误");
			model.put("returnurl", "/index.htm");
			model.put("returnname", "首页");
			return "fail";
		}
		
	}
	
	@RequestMapping(value=("/login/resetpwd"),method=RequestMethod.POST)
	public String resetPwd(HttpServletRequest request,ModelMap model){
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		String vcode = request.getParameter("vcode");
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		if(pwd!=null && repwd!=null && (pwd.equals(repwd))){
			if(user_normalService.updatePwd(pwd,uid)!=0){
				user_normalService.deleteForget(vcode,uid);
				model.put("successMes","密码修改成功！");
				model.put("returnurl", "/login/toLogin.htm");
				model.put("returnname", "登录");
				return "success";
			}else{
				model.put("errorMes", "系统错误！");
				model.put("returnurl", "/index.htm");
				model.put("returnname", "首页");
				return "fail";
			}
			
		}else{
			model.put("errorMes", "请填写正确密码！");
			model.put("returnurl", "/login/resetpwd.htm?vcode="+vcode+"&uid="+uid);
			model.put("returnname", "重置密码");
			return "fail";
		}
		
	}
	
}
