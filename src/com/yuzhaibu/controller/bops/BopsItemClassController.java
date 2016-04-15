package com.yuzhaibu.controller.bops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuzhaibu.dao.ItemClassDao;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.util.AjaxResult;

import net.sf.json.JSONArray;

@Controller
public class BopsItemClassController {
	
	@Autowired
	private ItemClassDao itemClassDao;
	
	@RequestMapping(value=("/bops/class"))
	public String toItemClass(HttpServletRequest request,ModelMap model){
		List<ItemClass> itemClassList = itemClassDao.findAllItemClass();
		model.put("query", itemClassList);
		return "/bops/class";
	}
	
	@RequestMapping(value=("/bops/findallfc"))
	public @ResponseBody AjaxResult findAllFatherClass(HttpServletRequest request){
		List<ItemClass> itemClassList = itemClassDao.findAllFatherClass();
		String str = JSONArray.fromObject(itemClassList).toString();
		AjaxResult result = new AjaxResult();
		result.setErrorCode(0);
		result.setResultStr(str);
		return result;
	}
	
	@RequestMapping(value=("/bops/editclass"),method=RequestMethod.POST)
	public @ResponseBody AjaxResult editClass(HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		String className = request.getParameter("classname");
		Integer fid = Integer.valueOf(request.getParameter("fid"));
		Integer id = Integer.valueOf(request.getParameter("id"));
		Map map = new HashMap();
		map.put("className", className);
		map.put("fid", fid);
		map.put("id", id);
		itemClassDao.updateClass(map);
		result.setErrorCode(0);
		return result;
	}
	
}
