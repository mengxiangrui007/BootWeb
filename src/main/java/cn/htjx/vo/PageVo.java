package cn.htjx.vo;

import java.io.Serializable;

public class PageVo implements Serializable {

	private static final long serialVersionUID = -1515713901106619171L;
	
	private int numPage;
	private String pageUrl;
	
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
}
