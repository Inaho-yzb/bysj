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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.yuzhaibu.dao.FavDao;
import com.yuzhaibu.dao.ItemClassDao;
import com.yuzhaibu.dao.ItemDao;
import com.yuzhaibu.dao.ItemImgDao;
import com.yuzhaibu.dao.MessageDao;
import com.yuzhaibu.dao.ReportDao;
import com.yuzhaibu.dao.User_normalDao;
import com.yuzhaibu.entity.Fav;
import com.yuzhaibu.entity.Item;
import com.yuzhaibu.entity.ItemClass;
import com.yuzhaibu.entity.User_normal;
import com.yuzhaibu.service.ItemService;
import com.yuzhaibu.util.DateUtils;
import com.yuzhaibu.util.Page;
import com.yuzhaibu.util.StringUtils;

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

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private FavDao favDao;
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public Map findItemByUserId(Integer sellerid,Integer index,Integer pageSize) {
		Integer curIndex = (index-1)*pageSize;
		Map map = new HashMap();
		map.put("sellerid", sellerid);
		map.put("index", curIndex);
		map.put("pageSize", pageSize);
		List<Item> items = itemDao.findItemByUserId(map);
		Integer count =  itemDao.findItemByUserIdCount(map);
		Page page = new Page(count,pageSize,index);
		Map resMap = new HashMap();
		resMap.put("items", items);
		resMap.put("itempage", page);
		return resMap;
	}

	@Override
	public Map findFavItemByUserId(Integer userid,Integer index,Integer pageSize) {
		Integer curIndex = (index-1)*pageSize;
		Map map = new HashMap();
		map.put("userid",userid);
		map.put("index", curIndex);
		map.put("pageSize", pageSize);
		List<Fav> favItems = favDao.findFavItemByUserId(map);
		Integer favcount = favDao.findFavItemCountByUserId(map);
		Page page = new Page(favcount,pageSize,index);
		Map resMap = new HashMap();
		resMap.put("favItems", favItems);
		resMap.put("favpage", page);
		return resMap;

	}

	@Override
	public Map<Integer, List<Item>> findIndexItemByClass(List<ItemClass> itemClass) {
		Map<Integer, List<Item>> map = new HashMap<Integer, List<Item>>();

		for (ItemClass ic : itemClass) {
			int id = ic.getItemclass_id();
			List<Item> item = itemDao.findIndexItemByClassId(id);

			map.put(id, item);
		}

		return map;
	}

	@Override
	public Item findItemByItemId(Integer itemid) {

		Item item = itemDao.findItemByItemId(itemid);

		return item;
	}

	@Override
	public List<Item> findOtherItemByUserId(Integer userid) {
		List<Item> item = itemDao.findOtherItemByUserId(userid);
		return item;
	}

	@Override
	public Map findItemListFatherItemByFatherId(Integer fid,Integer index,Integer pageSize,String order) {
		Map map = new HashMap();
		map.put("fid", fid);
		Integer startRow = index*pageSize;
		map.put("index", startRow);
		map.put("pageSize", pageSize);
		map.put("order", order);
		List<Item> items = itemDao.findItemListFatherItemByFatherId(map);
		Integer count = itemDao.countItemByFatherId(fid);
		Map resMap = new HashMap();
		resMap.put("itemList", items);
		resMap.put("count", count);
		return resMap;
	}

	@Override
	public Map findItemListByClassId(Integer id,Integer index,Integer pageSize,String order) {
		Map map = new HashMap();
		map.put("id", id);
		Integer startRow = index*pageSize;
		map.put("index", startRow);
		map.put("pageSize", pageSize);
		map.put("order", order);
		List<Item> itemList = itemDao.findItemListByClassId(map);
		Integer count = itemDao.countItemById(id);
		Map resMap = new HashMap();
		resMap.put("itemList", itemList);
		resMap.put("count", count);
		return resMap;
	}

	@Override
	public Integer uploadItem(final Map map, final String savePath) {
		Item item = (Item) map.get("item");
		Integer sellerid = user_normalDao.findUserIdByUsername(item.getUsername());
		item.setSellerid(sellerid);
		itemDao.insertNewItem(item);
		final Integer itemid = item.getItemid();
		Map expMap = new HashMap();
		expMap.put("id", sellerid);
		expMap.put("point", 10);
		user_normalDao.addUserExp(expMap);
		
		new Thread(){
			public void run(){
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
						String changeName = StringUtils.changeImgFileName(multipartFile.getOriginalFilename(),
								multipartFile.hashCode());
						String destPath = "/uploads/itemimages/" + DateUtils.dateToStrLong(new Date(), "yyyyMMdd") + "/"
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
							log.error("~~ImageUploadFaild~~itemid=itemid~~FileName"+fileName);
							e.printStackTrace();
						}
					}
				}

				Map imgMap = new HashMap();
				imgMap.put("id", itemid);
				imgMap.put("fileNameList", fileNameList);

				itemImgDao.insertNewImg(imgMap);
				Map mainMap = new HashMap<>();
				mainMap.put("id", itemid);
				mainMap.put("mainimg", fileNameList.get(0));
				itemDao.updateMainImg(mainMap);
			}
		}.start();
		
		return itemid;

	}

	@Override
	public Integer updateViewTimes(Integer itemid) {
		return itemDao.updateViewTimes(itemid);
	}

	@Override
	public Integer findItemCountByUseridAndItemId(Integer userid, Integer itemid) {
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("itemid", itemid);
		return itemDao.findItemCountByUseridAndItemId(map);
	}

	@Override
	public Integer editItem(Item item) {
		return itemDao.editItem(item);
	}

	@Override
	public Map searchItemByKeyword(Map frommap) {
		Integer index = ((Integer)frommap.get("toPage")-1)*8;
		frommap.put("index", index);
		List<Item> itemList = itemDao.searchItemByKeyword(frommap);
		Integer count = itemDao.searchItemByKeywordCount(frommap);
		Page pg = new Page(count,(Integer)frommap.get("pageSize"),(Integer)frommap.get("toPage"));
		Map resMap = new HashMap();
		resMap.put("itemList", itemList);
		resMap.put("page", pg);
		return resMap;
	}

	@Override
	public Integer deleteItem(final Integer itemid,final Integer userid) {
		return transactionTemplate.execute(new TransactionCallback<Integer>() {
					public Integer doInTransaction(TransactionStatus status){
						try{
							Map map = new HashMap();
							map.put("itemid", itemid);
							map.put("userid", userid);
							
							if(itemDao.deleteItem(map)!=0){
								itemImgDao.deleteItemImg(itemid);
								favDao.deleteFavByItemid(itemid);
								messageDao.deleteMesByItemid(itemid);
								reportDao.deleteReportByItemid(itemid);
							}
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

	@Override
	public int changeItemStatus(Integer itemid, Integer status, Integer userid) {
		Map map = new HashMap<>();
		map.put("itemid", itemid);
		map.put("status", status);
		map.put("userid", userid);
		return itemDao.changeItemStatus(map);
	}

	@Override
	public List<Integer> findAllItemCount() {
		return itemDao.findAllItemCount();
	}

}
