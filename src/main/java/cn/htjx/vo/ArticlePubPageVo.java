package cn.htjx.vo;

import java.io.Serializable;
import java.util.List;

public class ArticlePubPageVo implements Serializable {

	private static final long serialVersionUID = -738843796028607638L;
	
	private List<ArticlePageVo> articlePages;
	private Page page;
	
	public List<ArticlePageVo> getArticlePages() {
		return articlePages;
	}
	public void setArticlePages(List<ArticlePageVo> articlePages) {
		this.articlePages = articlePages;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
