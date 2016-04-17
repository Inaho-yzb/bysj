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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.yuzhaibu.dao.AuthenDao;
import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.UserAuthen;
import com.yuzhaibu.service.AuthenService;
import com.yuzhaibu.util.DateUtils;
import com.yuzhaibu.util.StringUtils;

@Service
public class AuthenServiceImpl extends BaseManager implements AuthenService {

	@Autowired
	private AuthenDao authenDao;
	
	@Autowired
	private User_normalDao user_normalDao;

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Override
	public Integer findUserIsAuthen(Integer userid) {
		return authenDao.findUserIsAuthen(userid);
	}

	@Override
	public Integer addNewAuthen(Map map, String savePath) {
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
				String changeName = StringUtils.changeAuthenImgFileName(multipartFile.getOriginalFilename(),
						multipartFile.hashCode());
				String destPath = "/uploads/userauthen/" + DateUtils.dateToStrLong(new Date(), "yyyyMMdd") + "/"
						+ changeName;
				try {
					// 获取item中的上传输入流
					BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
					// 创建一个文件输出流
					BufferedOutputStream bos = new BufferedOutputStream(
							new FileOutputStream(savePath + "/" + changeName));
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

		final UserAuthen userAuthen = (UserAuthen) map.get("UserAuthen");
		userAuthen.setImage(fileNameList.get(0));
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status){
				try{
					authenDao.addNewAuthen(userAuthen);
					Map map = new HashMap();
					map.put("userid", userAuthen.getUserId());
					map.put("authen", 1);
					user_normalDao.updateAuthen(map);
					return 1;
				}catch(Exception e){
					status.setRollbackOnly();
					e.printStackTrace();
					log.error(e.getMessage());
					return -1;
				}
			}
		}
		);

	}
	
}
