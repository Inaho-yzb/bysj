package com.yuzhaibu.controller;

import java.util.List;
import java.util.Map;

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
import com.yuzhaibu.service.ReportService;
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
	
	@Resource
	private ReportService reportService;
	
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
		
		Integer userid = (Integer) session.getAttribute("userid");
		
		if(userid!=null){
			Integer inFav = favService.isInFav(userid, itemid);
			Integer inReport = reportService.isInRep(userid,itemid);
			model.addAttribute("inFav",inFav);
			model.addAttribute("inReport",inReport);
		}
				
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
			Integer fid = Integer.valueOf(request.getParameter("fid"));
			Integer pageSize = 8;
			Map map = itemService.findItemListFatherItemByFatherId(fid,0,pageSize);
			List<Item> itemlist = (List<Item>) map.get("itemlist");
			Integer count = (Integer) map.get("count");
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);
			Integer pageCount;
			
			Integer currentPage = 1;
			
			model.addAttribute("itemlist",itemlist);
			model.addAttribute("itemChildClassList",itemChildClassList);
			model.addAttribute("navFatherItemClass",fatherItemClass);
			
		}else if(request.getParameter("fid")==null&&request.getParameter("id")!=null){
			Integer id = Integer.valueOf(request.getParameter("id"));
			Integer pageSize = 8;
			ItemClass childItemClass = itemClassService.findItemClassById(id);
			Integer fid = childItemClass.getItemclass_fatherid();
			ItemClass fatherItemClass = itemClassService.findItemClassById(fid);
			
			List<ItemClass> itemChildClassList = itemClassService.findChildItemClassListByFatherId(fid);
			Map map = itemService.findItemListByClassId(id,0,pageSize);
			List<Item> itemList = (List<Item>) map.get("itemList");
			Integer count = (Integer) map.get("count");
			
			Integer currentPage = 1;
			
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
		
		if(favService.isInFav(serid,itemid)!=null){
			result.setErrorCode(3);
			return result;
		}
		
		if(favService.addToFav(itemid,serid)>0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
	
	@RequestMapping(value=("ajaxreportitem"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult reportItem(HttpServletRequest request,HttpSession session){
		AjaxResult result = new AjaxResult();
		if(session.getAttribute("userid")==null){
			result.setErrorCode(2);
			return result;
		}
		
		Integer	userid = (Integer) session.getAttribute("userid");
		Integer itemid = Integer.valueOf(request.getParameter("itemid"));
		Integer reasonid = Integer.valueOf(request.getParameter("reasonid"));
		
		if(reportService.isInRep(userid,itemid)!=null){
			result.setErrorCode(3);
			return result;
		}
		
		if(reportService.addReport(itemid,userid,reasonid)>0){
			result.setErrorCode(0);
		}else{
			result.setErrorCode(1);
		}
		
		return result;
	}
	
}
