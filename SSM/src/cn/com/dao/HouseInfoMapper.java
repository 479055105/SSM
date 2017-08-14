package cn.com.dao;

import cn.com.pojo.HouseInfo;
import java.math.BigDecimal;

public interface HouseInfoMapper {
    int deleteByPrimaryKey(BigDecimal houseid);

    int insert(HouseInfo record);

    int insertSelective(HouseInfo record);

    HouseInfo selectByPrimaryKey(BigDecimal houseid);

    int updateByPrimaryKeySelective(HouseInfo record);

    int updateByPrimaryKey(HouseInfo record);
}