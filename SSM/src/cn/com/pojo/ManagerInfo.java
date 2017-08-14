package cn.com.pojo;

import java.math.BigDecimal;

public class ManagerInfo {
    private Long managerid;

    private String managername;

    private String managerpwd;

    private BigDecimal managerlevel;

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    public String getManagerpwd() {
        return managerpwd;
    }

    public void setManagerpwd(String managerpwd) {
        this.managerpwd = managerpwd == null ? null : managerpwd.trim();
    }

    public BigDecimal getManagerlevel() {
        return managerlevel;
    }

    public void setManagerlevel(BigDecimal managerlevel) {
        this.managerlevel = managerlevel;
    }
}