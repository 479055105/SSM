package cn.com.pojo;

import java.math.BigDecimal;

public class HouseownerInfo {
    private BigDecimal houseownerid;

    private String houseownername;

    private String houseownerphone;

    private String houseownerstatus;

    public BigDecimal getHouseownerid() {
        return houseownerid;
    }

    public void setHouseownerid(BigDecimal houseownerid) {
        this.houseownerid = houseownerid;
    }

    public String getHouseownername() {
        return houseownername;
    }

    public void setHouseownername(String houseownername) {
        this.houseownername = houseownername == null ? null : houseownername.trim();
    }

    public String getHouseownerphone() {
        return houseownerphone;
    }

    public void setHouseownerphone(String houseownerphone) {
        this.houseownerphone = houseownerphone == null ? null : houseownerphone.trim();
    }

    public String getHouseownerstatus() {
        return houseownerstatus;
    }

    public void setHouseownerstatus(String houseownerstatus) {
        this.houseownerstatus = houseownerstatus == null ? null : houseownerstatus.trim();
    }
}