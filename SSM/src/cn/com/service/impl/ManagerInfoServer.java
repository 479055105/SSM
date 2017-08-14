package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.dao.ManagerInfoMapper;
import cn.com.pojo.ManagerInfo;
import cn.com.service.IManagerInfoServer;
@Service
public class ManagerInfoServer implements IManagerInfoServer{
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Long managerid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ManagerInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ManagerInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ManagerInfo selectByPrimaryKey(Long managerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ManagerInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ManagerInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ManagerInfo> selectall(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return managerInfoMapper.selectall(map);
	}

}
