package cn.htjx.vo;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = -1515713901106619171L;
	
	private int pageNo = 1;//当前页码
	private int pageSize = 0;//每页显示的记录数
	private int totalNo = 1;//总页数
	private long totalCount = 0;//记录总数
	
	public int getPageNo() {
		if(totalNo == 0){
			return 0;
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(this.pageNo > 0){
			this.pageNo = pageNo;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}
	public int getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		if(totalCount > 0){
			this.totalCount = totalCount;
			//计算总页数
			this.totalNo = (int)(this.totalCount%pageSize==0?(this.totalCount/pageSize):this.totalCount/pageSize + 1);
		}
	}
	
}
