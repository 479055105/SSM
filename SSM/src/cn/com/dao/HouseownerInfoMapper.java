package cn.com.dao;

import cn.com.pojo.HouseownerInfo;
import java.math.BigDecimal;

public interface HouseownerInfoMapper {
    int deleteByPrimaryKey(BigDecimal houseownerid);

    int insert(HouseownerInfo record);

    int insertSelective(HouseownerInfo record);

    HouseownerInfo selectByPrimaryKey(BigDecimal houseownerid);

    int updateByPrimaryKeySelective(HouseownerInfo record);

    int updateByPrimaryKey(HouseownerInfo record);
}