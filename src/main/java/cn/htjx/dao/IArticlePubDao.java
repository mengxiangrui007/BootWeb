package cn.htjx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htjx.domain.ArticlePub;

public interface IArticlePubDao{

	public List<ArticlePub> findAll();
	
	public List<ArticlePub> findListTwo();
	
	public List<ArticlePub> findListTen();
	
	public Long findTotalCount();
	
	public List<ArticlePub> findArticlePage(@Param("pageSize") int pageSize, @Param("index") Long index);
	
	public List<ArticlePub> findList();
	
	public ArticlePub findOne(@Param("id") Long id);
	
	public void update(ArticlePub articlePub, @Param("id") Long id);
	
	public void save(ArticlePub articlePub);
	
}
