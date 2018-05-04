package cn.htjx.dao;

import java.util.List;

import cn.htjx.domain.LeaveWord;

public interface ILeaveWordDao{
	
	public List<LeaveWord> findAll();
	
	public List<LeaveWord> findList();
	
	public void save(LeaveWord leaveWord);
	
}
