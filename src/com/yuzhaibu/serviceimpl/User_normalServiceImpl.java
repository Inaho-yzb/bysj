package com.yuzhaibu.serviceimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.User_normalService;
import com.yuzhaibu.util.DateUtils;
import com.yuzhaibu.util.StringUtils;

@Service
public class User_normalServiceImpl extends BaseManager implements User_normalService {
	
	@Resource
	private User_normalDao user_normalDao;
	
	
	
	@Override
	public User_normal findUserByUsernameAndPwd(String username,String pwd) {
		return user_normalDao.findByUsernameAndPwd(username, pwd); 
	}


	@Override
	public User_normal findUserByUsername(String username) {		
		User_normal user = user_normalDao.findByUsername(username);
		return user;
	}


	@Override
	public void updateUser(User_normal usernormal) {
		user_normalDao.updateUser(usernormal);
		
	}


	@Override
	public User_normal findUserByItemid(int itemid) {
		User_normal user = user_normalDao.findByItemId(itemid);
		return user;
	}


	@Override
	public Integer regUser(User_normal user) {
		return user_normalDao.regUser(user);
	}


	@Override
	public Integer editHeadImg(Map map) {
		String savePath = (String) map.get("savePath");
		List<MultipartFile> list = (List<MultipartFile>) map.get("images");
		// 创建保存目录的文件
		File saveFile = new File(savePath);
		// 判断保存目录文件是否存在,不存在则创建一个文件夹
		if (!saveFile.exists()) {
			log.debug("文件目录创建中。。。");
			saveFile.mkdir();
		}

		List<String> fileNameList = new ArrayList<String>();
		for (MultipartFile multipartFile : list) {
			if (!multipartFile.isEmpty()) {
				// 得到上传的文件名称
				String fileName = multipartFile.getOriginalFilename();
				log.debug("文件名是：" + fileName);
				if (fileName == null || fileName.trim().equals("")) {
					continue;
				}
				String changeName = StringUtils.changeHeadImgFileName(multipartFile.getOriginalFilename(),
						multipartFile.hashCode());
				String destPath = "uploads\\userheadimg\\" + DateUtils.dateToStrLong(new Date(), "yyyyMMdd") + "\\"
						+ changeName;
				try {
					// 获取item中的上传输入流
					BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
					// 创建一个文件输出流
					BufferedOutputStream bos = new BufferedOutputStream(
							new FileOutputStream(savePath + "\\" + changeName));
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
						// 使用BufferedOutputStream缓冲输出流将缓冲区的数据写入到指定的目录(savePath
						// +
						// "\\" + filename)当中
						bos.write(buffer, 0, length);
					}
					// 关闭输入流
					bis.close();
					// 关闭输出流
					bos.close();

					fileNameList.add(destPath);
				} catch (Exception e) {
					log.error("~~ImageUploadFaild~~itemid=itemid~~FileName" + fileName);
					e.printStackTrace();
				}
			}
		}
		
		Map resMap = new HashMap(); 
		resMap.put("userid", map.get("userid"));
		resMap.put("imgPath", fileNameList.get(0));
		
		return user_normalDao.editUserHeadImg(resMap);
		
	}


	@Override
	public Integer addForget(Integer id, String str) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("str", str);
		return user_normalDao.addForget(map);
	}
	
	
	
}
