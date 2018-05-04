package cn.htjx.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.htjx.common.DateDealwith;
import cn.htjx.dao.IArticlePubDao;
import cn.htjx.dao.IJoinUsDao;
import cn.htjx.dao.ILeaveWordDao;
import cn.htjx.domain.ArticlePub;
import cn.htjx.domain.JoinUs;
import cn.htjx.domain.LeaveWord;
import cn.htjx.domain.MessageEntity;
import cn.htjx.service.IManageService;
import cn.htjx.vo.ArticlePageVo;
import cn.htjx.vo.ArticlePubPageVo;
import cn.htjx.vo.Page;

@Service
public class ManageServiceImpl implements IManageService {
	
	@Value("${web.upload-path}")
    private String path;
  
	@Autowired
	private IArticlePubDao articlePubDao;
	@Autowired
	private ILeaveWordDao leaveWordDao;
	@Autowired
	private IJoinUsDao joinUsDao;
	
	@Override
	public MessageEntity uploadInfo(MessageEntity messageEntity,MultipartFile file,String titleName,String content) throws IOException {
		if (file != null){
			if (file.getName() != null || "".equals(file.getName())){
				String[] name = file.getContentType().split("/");
				if ("BMP".equals(name[name.length - 1]) || "JPG".equals(name[name.length - 1])
						|| "JPEG".equals(name[name.length - 1]) || "bmp".equals(name[name.length - 1])
						|| "jpg".equals(name[name.length - 1]) || "jpeg".equals(name[name.length - 1])){
					//创建文件夹
					int radom = (int)(Math.random()*10);
					String imgName = DateDealwith.getSHC();
					String randomId = imgName+radom;
	              	String bkPath = "";
	              	File dirFile = new File(path+randomId);
	              	Boolean bFile = dirFile.exists();
	              	bFile = dirFile.mkdir();
	              	String newPath = "";
	              	if(bFile){
	              		bkPath = dirFile.toString();
	              		newPath = bkPath+"/";
	              	}else{
	              		System.out.println("not");
	              	}
	              	// 物理地址
	              	String imgUrl = newPath+imgName;
	              	String dataUrl = randomId+","+imgName;
	                file.transferTo(new File(imgUrl));
	                messageEntity.setState(0);
	                messageEntity.setMsg("上传成功!");
	                //修改后缀名
	                DateDealwith.getNew(newPath);
	                //数据库保存
	                ArticlePub articlePub = new ArticlePub();
	                articlePub.setTitleName(titleName);
	                articlePub.setContent(content);
	                articlePub.setImgUrl(dataUrl);
	                articlePub.setCreateTime(new Date());
	                articlePub.setUpdateTime(new Date());
	                articlePubDao.save(articlePub);
	                return messageEntity;
	            } else {  
	                messageEntity.setState(1);  
	                messageEntity.setMsg("格式不正确!");  
	            }  
	        } else {  
	            messageEntity.setState(1);  
	            messageEntity.setMsg("请选择文件!");  
	        }  
	    } else {  
	        messageEntity.setState(1);  
	        messageEntity.setMsg("请选择文件!");  
	    }  
	    return messageEntity;
	}
	@Override
	public List<ArticlePub> findAllArticle() throws Exception {
		return articlePubDao.findAll();
	}
	@Override
	public ArticlePubPageVo findArticlePage(int pageNo, int pageSize) throws Exception {
		Page page = new Page();
		//获得当前页数
		if(pageNo <= 0){ pageNo = 1; }
		//当前页码
		int currPageNo = pageNo;
		//获得记录总数
		long totalCount = articlePubDao.findTotalCount();
		//设置每页条数
		page.setPageSize(pageSize);
		//设置总记录数
		page.setTotalCount(totalCount);
		//获取总页
		int totalPages = page.getTotalNo();
		//对首页末页进行控制
		if(currPageNo < 1)
			currPageNo = 1;
		else if(currPageNo > page.getTotalNo())
			currPageNo = totalPages;
		//设置当前页码
		page.setPageNo(currPageNo);
		//坐标
		long index = (currPageNo-1)*page.getPageSize();
		//获得频道集合
		List<ArticlePub> articlePubs = articlePubDao.findArticlePage(page.getPageSize(),index);
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		List<ArticlePageVo> list1 = new ArrayList<>();
		for (ArticlePub articlePub : articlePubs) {
			ArticlePageVo articlePageVo = new ArticlePageVo();
			articlePageVo.setId(articlePub.getId());
			articlePageVo.setTitleName(articlePub.getTitleName());
			articlePageVo.setTitleUrl("/ppzxxq?wid="+articlePub.getId());
			articlePageVo.setImgUrl(articlePub.getImgUrl());
			articlePageVo.setNewImgUrl("/getQRCode?a="+articlePub.getImgUrl());
			articlePageVo.setContent(articlePub.getContent());
			articlePageVo.setcTime(std.format(articlePub.getCreateTime()).toString());
			articlePageVo.setuTime(std.format(articlePub.getUpdateTime()).toString());
			list1.add(articlePageVo);
		}
		ArticlePubPageVo articlePubPageVo = new ArticlePubPageVo();
		articlePubPageVo.setArticlePages(list1);
		articlePubPageVo.setPage(page);
		return articlePubPageVo;
	}
	@Override
	public List<ArticlePub> findListArticle() throws Exception {
		return articlePubDao.findList();
	}
	@Override
	public List<ArticlePageVo> findListArticleTwo() throws Exception {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		List<ArticlePub> articlePubs = articlePubDao.findListTwo();
		List<ArticlePageVo> list = new ArrayList<>();
		for (ArticlePub articlePub : articlePubs) {
			ArticlePageVo articlePageVo = new ArticlePageVo();
			articlePageVo.setId(articlePub.getId());
			articlePageVo.setTitleName(articlePub.getTitleName());
			articlePageVo.setTitleUrl("/ppzxxq?wid="+articlePub.getId());
			articlePageVo.setImgUrl(articlePub.getImgUrl());
			articlePageVo.setNewImgUrl("/getQRCode?a="+articlePub.getImgUrl());
			articlePageVo.setContent(articlePub.getContent());
			articlePageVo.setcTime(std.format(articlePub.getCreateTime()).toString());
			articlePageVo.setuTime(std.format(articlePub.getUpdateTime()).toString());
			list.add(articlePageVo);
		}
		return list;
	}
	@Override
	public List<ArticlePub> findListArticleTen() throws Exception {
		return articlePubDao.findListTen();
	}
	@Override
	public ArticlePub findOneArticle(Long id) throws Exception {
		return articlePubDao.findOne(id);
	}
	
	@Override
	public List<LeaveWord> findAllLeave() throws Exception {
		return leaveWordDao.findAll();
	}
	@Override
	public List<LeaveWord> findListLeave() throws Exception {
		return leaveWordDao.findList();
	}
	@Override
	public void saveLeave(LeaveWord leaveWord) throws Exception {
		leaveWord.setCreateTime(new Date());
		leaveWord.setUpdateTime(new Date());
		leaveWordDao.save(leaveWord);
	}
	
	@Override
	public List<JoinUs> findAllJoin() throws Exception {
		return joinUsDao.findAll();
	}
	@Override
	public List<JoinUs> findListJoin() throws Exception {
		return joinUsDao.findList();
	}
	@Override
	public void saveJoin(JoinUs joinUs) throws Exception {
		joinUs.setCreateTime(new Date());
		joinUs.setUpdateTime(new Date());
		joinUsDao.save(joinUs);
	}

}
