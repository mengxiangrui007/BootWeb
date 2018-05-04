package cn.htjx.dao;

import java.util.List;

import cn.htjx.domain.JoinUs;

public interface IJoinUsDao{
	
	public List<JoinUs> findAll();
	
	public List<JoinUs> findList();
	
	public void save(JoinUs joinUs);
	
}
