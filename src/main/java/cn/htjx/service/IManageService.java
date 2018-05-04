package cn.htjx.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.htjx.domain.ArticlePub;
import cn.htjx.domain.JoinUs;
import cn.htjx.domain.LeaveWord;
import cn.htjx.domain.MessageEntity;
import cn.htjx.vo.ArticlePageVo;
import cn.htjx.vo.ArticlePubPageVo;

public interface IManageService {
	
	public MessageEntity uploadInfo(MessageEntity messageEntity,MultipartFile file,String titleName,String content) throws IOException;
	public List<ArticlePub> findAllArticle() throws Exception;
	public ArticlePubPageVo findArticlePage(int pageNo,int pageSize) throws Exception;
	public List<ArticlePub> findListArticle() throws Exception;
	public List<ArticlePageVo> findListArticleTwo() throws Exception;
	public List<ArticlePub> findListArticleTen() throws Exception;
	public ArticlePub findOneArticle(Long id) throws Exception;
	
	public List<LeaveWord> findAllLeave() throws Exception;
	public List<LeaveWord> findListLeave() throws Exception;
	public void saveLeave(LeaveWord leaveWord) throws Exception;
	
	public List<JoinUs> findAllJoin() throws Exception;
	public List<JoinUs> findListJoin() throws Exception;
	public void saveJoin(JoinUs joinUs) throws Exception;
	
}
