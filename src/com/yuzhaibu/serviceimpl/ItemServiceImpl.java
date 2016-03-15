package com.yuzhaibu.serviceimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuzhaibu.dao.ItemClassDao;
import com.yuzhaibu.dao.ItemDao;
import com.yuzhaibu.dao.ItemImgDao;
import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.service.ItemService;

@Service
public class ItemServiceImpl extends BaseManager implements ItemService {
	
	@Resource
	private ItemDao itemDao;
	
	@Resource
	private ItemClassDao itemClassDao;
	
	@Resource
	private MessageDao messageDao;
	
	@Resource
	private Item item;
	
	@Resource
	private User_normalDao user_normalDao;
	
	@Resource
	private ItemImgDao itemImgDao;

	@Override
	public List<Item> findItemByUserId(int sellerid) {
		
		List<Item> items = itemDao.findItemByUserId(sellerid);
		
		return items;
		
	}

	@Override
	public List<Fav> findFavItemByUserId(int userid) {
		
		List<Fav> favItems = itemDao.findFavItemByUserId(userid);
		
		return favItems;
		
	}

	@Override
	public Map<Integer, List<Item>> findIndexItemByClass(List<ItemClass> itemClass) {
		Map<Integer,List<Item>> map = new HashMap<Integer,List<Item>>();
		
		for(ItemClass ic:itemClass){
			int id = ic.getItemclass_id();
			List<Item> item = itemDao.findIndexItemByClassId(id);
			
			map.put(id, item);
		}
		
		return map;
	}

	@Override
	public Item findItemByItemId(int itemid) {
		
		Item item = itemDao.findItemByItemId(itemid);
		ItemClass itemClass = itemClassDao.childClassMapper(item.getItemclassid());
		item.setItemClass(itemClass);
		
		return item;
	}

	@Override
	public List<Item> findOtherItemByUserId(int userid) {
		List<Item> item = itemDao.findOtherItemByUserId(userid);
		return item;
	}

	@Override
	public List<Item> findItemListFatherItemByFatherId(int fid) {
		List<Item> items = itemDao.findItemListFatherItemByFatherId(fid);
		for(Item item:items){
			int mescount = messageDao.findMesCountByItemId(item.getItemid());
			int favcount = itemDao.findFavCountByItemId(item.getItemid());
			
			item.setMescount(mescount);
			item.setFavcount(favcount);
		}
		return items;
	}

	@Override
	public List<Item> findItemListByClassId(int id) {
		List<Item> itemList = itemDao.findItemListByClassId(id);
		for(Item item:itemList){
			int mescount = messageDao.findMesCountByItemId(item.getItemid());
			int favcount = itemDao.findFavCountByItemId(item.getItemid());
			
			item.setMescount(mescount);
			item.setFavcount(favcount);
		}
		return itemList;
	}

	@Override
	public Integer uploadItem(Map map,String savePath) {
		Integer sellerid = user_normalDao.findUserIdByUsername((String)map.get("username"));
		map.put("sellerid",sellerid);
		Integer id = itemDao.insertNewItem(map);
		
		List<MultipartFile> list = (List<MultipartFile>) map.get("list");
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
				
				fileNameList.add(savePath+"\\"+fileName);
				}catch(Exception e){
					log.debug(e.getMessage());
				}
			}
		}
		
		Map imgMap = new HashMap();
		imgMap.put("id", id);
		imgMap.put("fileNameList", fileNameList);
		
		//TODO
		itemImgDao.insertNewImg(imgMap);
		
		return id;
	}

}
