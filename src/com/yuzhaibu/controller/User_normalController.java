package com.yuzhaibu.controller;

import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemClassService;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.DateUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class User_normalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921877745686585290L;

	@Resource
	private User_normalService user_normalService;

	@Resource
	private MessageService messageService;

	@Resource
	private User_normal usernormal;

	@Resource
	private ItemService itemService;
	
	@Resource
	private ItemClassService itemClassService;

	@RequestMapping("/toProfile")
	public String toProfile(HttpSession session, ModelMap model, HttpServletRequest request) {
		String username = (String) session.getAttribute("username");
		String tag = request.getParameter("tag");

		usernormal = user_normalService.findUserByUsername(username);
		List<Item> items = itemService.findItemByUserId(usernormal.getUsernormal_id());
		List<Fav> favs = itemService.findFavItemByUserId(usernormal.getUsernormal_id());
		List<Message> messages = messageService.findAllNotReadMessageByUserId(usernormal.getUsernormal_id());

		int exp = (usernormal.getLevexp() / 1000 + 1) * 1000;

		model.addAttribute("usernormal", usernormal);
		model.put("nextexp", exp);
		model.addAttribute("items", items);
		model.addAttribute("favs", favs);
		model.addAttribute("messages", messages);
		model.put("tag", tag);

		return "profile";
	}

	@RequestMapping("/editUsernormalProfile")
	public String editUernormalProfile(User_normal user, HttpServletRequest request, HttpSession session) {

		user.setUsername((String) session.getAttribute("username"));

		user_normalService.updateUser(user);

		return "redirect:toProfile.htm";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.setAttribute("username", null);
		return "redirect:../index.htm";
	}

	@RequestMapping(value = "/ajaxCheckMes", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult ajaxCheckMes(HttpSession session, HttpServletRequest request) {
		AjaxResult result = new AjaxResult();

		String username = (String) session.getAttribute("username");

		if (username != null) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			messageService.checkMesById(id);
			result.setErrorCode(0);
		} else {
			result.setErrorCode(1);
		}
		return result;
	}

	@RequestMapping(value = ("/releasepro"))
	public String toReleasePro(HttpServletRequest request,ModelMap map) {
		List<ItemClass> itemClassList =  itemClassService.findAllChildClass();
		map.put("itemClassList", itemClassList);
		return "releasepro";
	}

	@RequestMapping(value=("/uploaditem"),method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult uploadItem(HttpServletRequest req, HttpServletResponse resp,HttpSession session){
		AjaxResult result = new AjaxResult();
		 
		// 消息提示
		// 将req转换成Spring的request
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
		// 获取上传文件
		List<MultipartFile> list = multipartHttpServletRequest.getFiles("uploadfile");
		
		String date = DateUtils.dateToStrLong(new Date(), "yyyyMMdd");
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = req.getServletContext().getRealPath("/uploads/itemimages/"+date);
		
		String itemname = multipartHttpServletRequest.getParameter("itemname");
		String sellprice = multipartHttpServletRequest.getParameter("sellprice");
		String originprice = multipartHttpServletRequest.getParameter("originprice");
		String bargain = multipartHttpServletRequest.getParameter("bargain");
		String color = multipartHttpServletRequest.getParameter("color");
		String tradeposition = multipartHttpServletRequest.getParameter("tradeposition");
		String discreption = multipartHttpServletRequest.getParameter("description");
		String username = (String) session.getAttribute("username");
		Map map = new HashMap();
		map.put("images", list);
		map.put("itemname",itemname);
		map.put("sellprice", sellprice);
		map.put("originprice",originprice);
		map.put("bargain",bargain);
		map.put("color", color);
		map.put("tradeposition",tradeposition);
		map.put("discreption", discreption);
		map.put("username", username);
		
		itemService.uploadItem(map,savePath);
		return result;
	}

}
