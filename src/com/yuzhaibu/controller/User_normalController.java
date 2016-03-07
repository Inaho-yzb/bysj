package com.yuzhaibu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import com.yuzhaibu.entity.Message;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.service.MessageService;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.AjaxResult;

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
	public String toReleasePro(HttpServletRequest request, HttpSession session) {
		return "releasepro";
	}

	@RequestMapping(value=("/uploaditemimg"))
	public AjaxResult uploadFile(HttpServletRequest req, HttpServletResponse resp){
		AjaxResult result = new AjaxResult();
		/*
		 * //防止中文乱码，与页面字符集一致 req.setCharacterEncoding("UTF-8");
		 */
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = req.getServletContext().getRealPath("/uploads/itemimages");
		// this.getServletContext().getRealPath("/WEB-INF/upload");
		// 创建保存目录的文件
		File saveFile = new File(savePath);
		// 判断保存目录文件是否存在,不存在则创建一个文件夹
		if (!saveFile.exists()) {
			System.out.println("文件目录创建中。。。");
			saveFile.mkdir();
		}
		// 消息提示
		// 将req转换成Spring的request
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
		// 获取上传文件
		List<MultipartFile> list = multipartHttpServletRequest.getFiles("file");
		// 获取普通输入项的数据
		String map = multipartHttpServletRequest.getParameter("username");
		System.out.println(map);
		List<String> fileNameList = new ArrayList<String>();
		for (MultipartFile multipartFile : list) {
			if (!multipartFile.isEmpty()) {
				// 得到上传的文件名称
				String fileName = multipartFile.getOriginalFilename();
				System.out.println("文件名是：" + fileName);
				if (fileName == null || fileName.trim().equals("")) {
					fileNameList.add(fileName);
					continue;
				}
				try{
				// 获取item中的上传输入流
				BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
				// 创建一个文件输出流
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath + "\\" + fileName));
				// 创建一个缓冲区
				byte[] buffer = new byte[1024 * 8];
				// 循环将缓冲输入流读入到缓冲区当中
				while (true) {
					// 循环将缓冲输入流读入到缓冲区当中
					int length = bis.read(buffer);
					// 判断是否读取到文件末尾
					if (length == -1) {
						break;
					}
					// 使用BufferedOutputStream缓冲输出流将缓冲区的数据写入到指定的目录(savePath +
					// "\\" + filename)当中
					bos.write(buffer, 0, length);
				}
				// 关闭输入流
				bis.close();
				// 关闭输出流
				bos.close();
				
				result.setErrorCode(0);
				String resStr = JSONObject.fromObject(fileNameList).toString();
				result.setResultStr(resStr);
				}catch(Exception e){
					result.setErrorCode(1);
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}
