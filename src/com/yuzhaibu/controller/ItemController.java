package com.yuzhaibu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.entity.ItemImg;
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.FavService;
import com.yuzhaibu.service.ItemClassService;
import com.yuzhaibu.service.ItemImagesService;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;

@Controller
public class ItemController {
	
	@Resource
	private User_normal usernormal;

	@Resource
	private User_normalService user_normalService;
	
	@Resource
	private MessageService messageService;
	
	@Resource
	private ItemClassService itemClassService;
	
	@Resource
	private ItemService itemService;
	
	@Resource
	private ItemImagesService itemImagesService;
	
	@Resource
	private FavService favService;
	
	@RequestMapping("item")
	public String toItem(HttpServletRequest request,ModelMap model,HttpSession session){
		String username = (String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("username",username);
		}
		
		
		int itemid = Integer.valueOf(request.getParameter("id"));		
		Item item = itemService.findItemByItemId(itemid);
		
		User_normal user = user_normalService.findUserByItemid(itemid);
		item.setUsernormal(user);
		
		List<Message> messages = messageService.findInitItemMessageByItemId(itemid);
		
		List<Item> otherItem = itemService.findOtherItemByUserId(user.getUsernormal_id());
		
		List<ItemImg> itemImgList = itemImagesService.findItemImagesByItemId(itemid);
				
		itemService.updateViewTimes(itemid);
		model.addAttribute("item",item);
		model.addAttribute("messages",messages);
		model.addAttribute("otherItem",otherItem);
		model.addAttribute("itemimages",itemImgList);
		
		return "item";
	}
	
	@RequestMapping("itemlist")
	public String toItemList(HttpServletRequest request,HttpSession session,ModelMap model){
		String username = (String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("username",username);
		}
		
		if(request.getParameter("fid")!=null&&request.getParameter("id")==null){
			int fid = Integer.valueOf(request.getParameter("fid"));
			
			List<Item> itemlist = itemService.findItemListFatherItemByFatherId(fid);
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);						
			
			model.addAttribute("itemlist",itemlist);
			model.addAttribute("itemChildClassList",itemChildClassList);
			model.addAttribute("navFatherItemClass",fatherItemClass);
			
		}else if(request.getParameter("fid")==null&&request.getParameter("id")!=null){
			int id = Integer.valueOf(request.getParameter("id"));
			
			ItemClass childItemClass = itemClassService.findItemClassById(id);
			int fid = childItemClass.getItemclass_fatherid();
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);
			
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			List<Item> itemList = itemService.findItemListByClassId(id);
			
			model.addAttribute("itemChildClassList",itemChildClassList);
			model.addAttribute("navChildItemClass",childItemClass);
			model.addAttribute("navFatherItemClass",fatherItemClass);
			model.addAttribute("itemlist",itemList);
		}
		
		return "itemlist";
	}
	
	@RequestMapping(value=("ajaxaddtofav"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult ajaxaddtofav(HttpServletRequest request,HttpSession session){
		AjaxResult result = new AjaxResult();
		if(session.getAttribute("userid")==null){
			result.setErrorCode(2);
			return result;
		}
		Integer	serid = (Integer) session.getAttribute("userid");
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		
		
		if(favService.addToFav(itemid,serid)>0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
}
