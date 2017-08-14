package cn.com.service;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import cn.com.pojo.ManagerInfo;
@Repository
public interface IManagerInfoServer {

    int deleteByPrimaryKey(Long managerid);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    ManagerInfo selectByPrimaryKey(Long managerid);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);
    
    List<ManagerInfo> selectall(Map<String, Object> map);
}
