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

	@RequestMapping("/user/toProfile")
	public String toProfile(HttpSession session, ModelMap model, HttpServletRequest request) {
		String username = (String) session.getAttribute("username");
		Integer userid = (Integer) session.getAttribute("userid");
		String tag = request.getParameter("tag");

		usernormal = user_normalService.findUserByUsername(username);
		Map itemsMap = itemService.findItemByUserId(userid,1,5);
		Map favsMap = itemService.findFavItemByUserId(userid,1,5);
		Map messagesMap = messageService.findAllNotReadMessageByUserId(userid,1,5);

		int exp = (usernormal.getLevexp() / 1000 + 1) * 1000;

		model.addAttribute("usernormal", usernormal);
		model.put("nextexp", exp);
		model.addAttribute("items", itemsMap.get("items"));
		model.addAttribute("itempage", itemsMap.get("itempage"));
		model.addAttribute("favs", favsMap.get("favItems"));
		model.addAttribute("favpage",favsMap.get("favpage"));
		model.put("messages", messagesMap.get("messages"));
		model.put("mespage", messagesMap.get("mespage"));
		model.put("tag", tag);

		return "profile";
	}

	@RequestMapping("/user/editUsernormalProfile")
	public String editUernormalProfile(User_normal user, HttpServletRequest request, HttpSession session) {

		user.setUsername((String) session.getAttribute("username"));

		user_normalService.updateUser(user);

		return "redirect:toProfile.htm";
	}

	@RequestMapping("/user/quit")
	public String quit(HttpSession session) {
		session.setAttribute("username", null);
		session.setAttribute("userid", null);
		return "redirect:../index.htm";
	}

	@RequestMapping(value = "/user/ajaxCheckMes", method = RequestMethod.POST)
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

	@RequestMapping(value = ("/user/releasepro"))
	public String toReleasePro(HttpServletRequest request,ModelMap map) {
		List<ItemClass> itemClassList =  itemClassService.findAllChildClass();
		map.put("itemClassList", itemClassList);
		return "releasepro";
	}

	@RequestMapping(value=("/user/uploaditem"),method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult uploadItem(HttpServletRequest req, HttpServletResponse resp,HttpSession session){
		AjaxResult result = new AjaxResult();
		 
		// 消息提示
		// 将req转换成Spring的request
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
		// 获取上传文件
		List<MultipartFile> list = multipartHttpServletRequest.getFiles("uploadfile");
		
		for(MultipartFile mf:list){
			int index = mf.getOriginalFilename().lastIndexOf("."); 
	        String la = mf.getOriginalFilename().substring(index).toLowerCase();
	        if(!(".jpg".equals(la)||".gif".equals(la)||".jpeg".equals(la)||".png".equals(la))){ 
	              result.setErrorCode(2);
	              result.setErrorMes("请上传图片文件！");
	              return result;
	        }else if(mf.getSize()>(long)10485760){
	        		result.setErrorCode(2);
	              result.setErrorMes("图片过大！请上传小于10M的图");
	              return result;
	        }

		}
		
		String date = DateUtils.dateToStrLong(new Date(), "yyyyMMdd");
		
		String savePath = req.getServletContext().getRealPath("/uploads/itemimages/"+date);
		
		String itemname = multipartHttpServletRequest.getParameter("itemname");
		Double sellprice = Double.valueOf(multipartHttpServletRequest.getParameter("sellprice"));
		Double originprice = Double.valueOf(multipartHttpServletRequest.getParameter("originprice"));
		Integer bargain = Integer.valueOf(multipartHttpServletRequest.getParameter("bargain"));
		String color = multipartHttpServletRequest.getParameter("color");
		String tradeposition = multipartHttpServletRequest.getParameter("tradeposition");
		String discreption = multipartHttpServletRequest.getParameter("description");
		String username = (String) session.getAttribute("username");
		Integer itemclassid = Integer.valueOf(multipartHttpServletRequest.getParameter("itemclassid"));
		
		if(itemname.length()>15 || tradeposition.length()>150 || discreption.length()>150){
			result.setErrorCode(1);
			result.setErrorMes("请输入正确的表单信息！");
			return result;
		}
		
		Item item = new Item();
		
		Map map = new HashMap();
		map.put("images", list);
		item.setItemname(itemname);
		item.setSellprice(sellprice);
		item.setOriginprice(originprice);
		item.setBargain(bargain);
		item.setColor(color);
		item.setTradeposition(tradeposition);
		item.setDiscreption(discreption);
		item.setUsername(username);
		item.setItemclassid(itemclassid);
		map.put("item", item);
		
		Integer itemid = itemService.uploadItem(map,savePath);
		if(itemid!=-1){
			result.setErrorCode(0);
			result.setResultStr(String.valueOf(itemid));
		}else{
			result.setErrorCode(1);
		}
		return result;
	}

	@RequestMapping(value=("/user/ajaxprofilenextitems"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult ajaxprofilenextitems(HttpServletRequest request){
		Integer userid = Integer.valueOf(request.getParameter("userid"));
		Integer page = Integer.valueOf(request.getParameter("page"));
		AjaxResult result = new AjaxResult();
		Map itemsMap = itemService.findItemByUserId(userid,page,5);
		String str = JSONObject.fromObject(itemsMap).toString();
		result.setErrorCode(0);
		result.setResultStr(str);
		return result;
	}
	
	@RequestMapping(value=("/user/ajaxprofilenextfav"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult ajaxprofilenextfav(HttpServletRequest request){
		Integer userid = Integer.valueOf(request.getParameter("userid"));
		Integer page = Integer.valueOf(request.getParameter("page"));
		AjaxResult result = new AjaxResult();
		Map favsMap = itemService.findFavItemByUserId(userid,page,5);
		String str = JSONObject.fromObject(favsMap).toString();
		result.setErrorCode(0);
		result.setResultStr(str);
		return result;
	}
	
	@RequestMapping(value=("/user/ajaxprofilenextmes"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult ajaxprofilenextmes(HttpServletRequest request){
		Integer userid = Integer.valueOf(request.getParameter("userid"));
		Integer page = Integer.valueOf(request.getParameter("page"));
		AjaxResult result = new AjaxResult();
		Map messagesMap = messageService.findAllNotReadMessageByUserId(userid,page,5);
		String str = JSONObject.fromObject(messagesMap).toString();
		result.setErrorCode(0);
		result.setResultStr(str);
		return result;
	}
}
