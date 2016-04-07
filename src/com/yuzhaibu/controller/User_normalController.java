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
import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.AuthenService;
import com.yuzhaibu.service.FavService;
import com.yuzhaibu.service.ItemClassService;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;
import com.yuzhaibu.util.DateUtils;
import com.yuzhaibu.util.StringUtils;

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
	private FavService favService;
	
	@Resource
	private AuthenService authenService;
	
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
		model.put("tt","个人主页" );
		return "profile";
	}

	@RequestMapping("/user/editUsernormalProfile")
	public String editUernormalProfile(User_normal user, HttpServletRequest request, HttpSession session) {

		user.setUsername((String) session.getAttribute("username"));

		user_normalService.updateUser(user);

		return "redirect:toProfile.htm";
	}

	@RequestMapping("/user/quit")
	public String quit(HttpSession session,ModelMap model) {
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
	public String toReleasePro(HttpServletRequest request,ModelMap model,HttpSession session) {
		
		User_normal user = user_normalService.findUserByUsername((String)session.getAttribute("username"));
		if(StringUtils.isBlank(user.getMobile())&&StringUtils.isBlank(user.getQq())){
			model.put("errorMes", "请先完善信息！");
			model.put("returnurl", "/user/toProfile.htm");
			model.put("returnname", "返回个人主页");
			return "fail";
		}
		model.put("tt","发布物品" );
		List<ItemClass> itemClassList =  itemClassService.findAllChildClass();
		model.put("itemClassList", itemClassList);
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
	
	@RequestMapping(value=("/user/getitemdetail"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult getitemdetail(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		
		Item item = itemService.findItemByItemId(itemid);
		
		if(item!=null){
			String resStr = JSONObject.fromObject(item).toString();
			result.setErrorCode(0);
			result.setResultStr(resStr);
		}else{
			result.setErrorCode(1);
			result.setErrorMes("没有该物品!");
		}
		
		return result;
		
	}
	
	@RequestMapping(value=("/user/ajaxupdateitem"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult ajaxupdateitem(HttpServletRequest request,HttpSession session){
		AjaxResult result = new AjaxResult();
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		String itemname = request.getParameter("itemname");
		Double itemsellprice = Double.valueOf(request.getParameter("itemsellprice"));
		Double itemoriginprice = Double.valueOf(request.getParameter("itemoriginprice"));
		Integer bargain = Integer.valueOf(request.getParameter("bargain"));
		String color = request.getParameter("color");
		String itemtradeposition = request.getParameter("itemtradeposition");
		String itemdescription = request.getParameter("itemdescription");
		
		Integer userid = (Integer) session.getAttribute("userid");
		if(itemService.findItemCountByUseridAndItemId(userid,itemid)==1){
			Item item = new Item();
			item.setItemid(itemid);
			item.setItemname(itemname);
			item.setSellprice(itemsellprice);
			item.setOriginprice(itemoriginprice);
			item.setBargain(bargain);
			item.setColor(color);
			item.setTradeposition(itemtradeposition);
			item.setDiscreption(itemdescription);
			itemService.editItem(item);
			result.setErrorCode(0);
			return result;
		}else{
			result.setErrorCode(0);
			result.setErrorMes("非法操作！");
			return result;
		}
		
	}
	
	@RequestMapping(value=("/user/deletemyitem"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult deletemyitem(HttpServletRequest request,HttpSession session){
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		Integer userid = (Integer) session.getAttribute("userid");
		AjaxResult result = new AjaxResult();
		if(itemService.deleteItem(itemid,userid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		return result;
	}
	
	@RequestMapping(value=("/user/deletefav"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult deleteFav(HttpServletRequest request,HttpSession session){
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		Integer userid = (Integer) session.getAttribute("userid");
		AjaxResult result = new AjaxResult();
		if(favService.deletefav(itemid,userid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		return result;
	}
	
	@RequestMapping(value=("/user/changeItemstatus"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult changeItemStatus(HttpServletRequest request,HttpSession session){
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		Integer status = Integer.valueOf(request.getParameter("status"));
		Integer userid = (Integer) session.getAttribute("userid");
		
		AjaxResult result = new AjaxResult();
		if(itemService.changeItemStatus(itemid,status,userid)!=0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
	
	@RequestMapping(value=("/user/authen"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult authen(HttpServletRequest request,HttpSession session){
		AjaxResult result = new AjaxResult();
		Integer userid = (Integer) session.getAttribute("userid");
		Integer count = authenService.findUserIsAuthen(userid);
		
		if(count!=0){
			result.setErrorCode(1);
			result.setErrorMes("操作失败！");
			return result;
		}
		// 消息提示
				// 将req转换成Spring的request
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
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
				
				String savePath = request.getServletContext().getRealPath("WEB-INF/upload/userauthen/"+date);
				
				String authenName = multipartHttpServletRequest.getParameter("authenname");
				String idCode = multipartHttpServletRequest.getParameter("idcode");
				
				if(StringUtils.isBlank(authenName) || StringUtils.isBlank(idCode)){
					result.setErrorCode(1);
					result.setErrorMes("请输入正确的表单信息！");
					return result;
				}
				
				UserAuthen userAuthen = new UserAuthen();
				
				userAuthen.setAuthenName(authenName);
				userAuthen.setIdCode(idCode);
				userAuthen.setUserId(userid);
				
				Map map = new HashMap();
				map.put("images", list);
				map.put("UserAuthen", userAuthen);
				
				Integer res = authenService.addNewAuthen(map,savePath);
				if(res!=0){
					result.setErrorCode(0);
				}else{
					result.setErrorCode(1);
					result.setErrorMes("操作失败！");
				}
				return result;
	}

	@RequestMapping(value = ("/user/changehd"), method = RequestMethod.POST)
	public @ResponseBody AjaxResult changeHead(HttpServletRequest request, HttpSession session) {
		AjaxResult result = new AjaxResult();
		Integer userid = (Integer) session.getAttribute("userid");

		// 将req转换成Spring的request
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		// 获取上传文件
		List<MultipartFile> list = multipartHttpServletRequest.getFiles("uploadfile");

		for (MultipartFile mf : list) {
			int index = mf.getOriginalFilename().lastIndexOf(".");
			String la = mf.getOriginalFilename().substring(index).toLowerCase();
			if (!(".jpg".equals(la) || ".gif".equals(la) || ".jpeg".equals(la) || ".png".equals(la))) {
				result.setErrorCode(2);
				result.setErrorMes("请上传图片文件！");
				return result;
			} else if (mf.getSize() > (long) 10485760) {
				result.setErrorCode(2);
				result.setErrorMes("图片过大！请上传小于10M的图");
				return result;
			}

		}

		String date = DateUtils.dateToStrLong(new Date(), "yyyyMMdd");

		String savePath = request.getServletContext().getRealPath("uploads/userheadimg/" + date);

		Map map = new HashMap();
		map.put("images", list);
		map.put("userid", userid);
		map.put("savePath", savePath);
		
		Integer res = user_normalService.editHeadImg(map);
		
		if (res != 0) {
			result.setErrorCode(0);
		} else {
			result.setErrorCode(1);
			result.setErrorMes("操作失败！");
		}
		return result;
	}
}
