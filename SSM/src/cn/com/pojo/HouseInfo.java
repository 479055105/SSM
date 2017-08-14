package cn.com.pojo;

import java.math.BigDecimal;

public class HouseInfo {
    private BigDecimal houseid;

    private BigDecimal housedy;

    private BigDecimal housefh;

    private BigDecimal houseacreage;

    private BigDecimal houseownerid;

    private String houseuse;

    public BigDecimal getHouseid() {
        return houseid;
    }

    public void setHouseid(BigDecimal houseid) {
        this.houseid = houseid;
    }

    public BigDecimal getHousedy() {
        return housedy;
    }

    public void setHousedy(BigDecimal housedy) {
        this.housedy = housedy;
    }

    public BigDecimal getHousefh() {
        return housefh;
    }

    public void setHousefh(BigDecimal housefh) {
        this.housefh = housefh;
    }

    public BigDecimal getHouseacreage() {
        return houseacreage;
    }

    public void setHouseacreage(BigDecimal houseacreage) {
        this.houseacreage = houseacreage;
    }

    public BigDecimal getHouseownerid() {
        return houseownerid;
    }

    public void setHouseownerid(BigDecimal houseownerid) {
        this.houseownerid = houseownerid;
    }

    public String getHouseuse() {
        return houseuse;
    }

    public void setHouseuse(String houseuse) {
        this.houseuse = houseuse == null ? null : houseuse.trim();
    }
}