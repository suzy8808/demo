package org.bobo.clockin.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Subsidy {
    private Integer ssId;

    private Integer userId;

    private BigDecimal subsidy;

    private String ssYearMonth;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    public String getSsYearMonth() {
        return ssYearMonth;
    }

    public void setSsYearMonth(String ssYearMonth) {
        this.ssYearMonth = ssYearMonth == null ? null : ssYearMonth.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}