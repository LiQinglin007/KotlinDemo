package com.example.weatherwithkotlin.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：城市列表
 * 最后修改：
 */

@Entity
public class CityBean {
    @Id
    Long CityBeanId;
    String CityName;
    Integer Sign;//0:定位城市  1：添加城市

    @Override
    public String toString() {
        return "CityBean{" +
                "CityBeanId=" + CityBeanId +
                ", CityName='" + CityName + '\'' +
                ", Sign=" + Sign +
                '}';
    }

    public String getCityName() {
        return this.CityName;
    }
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }
    public Long getCityBeanId() {
        return this.CityBeanId;
    }
    public void setCityBeanId(Long CityBeanId) {
        this.CityBeanId = CityBeanId;
    }
    public Integer getSign() {
        return this.Sign;
    }
    public void setSign(Integer Sign) {
        this.Sign = Sign;
    }
    @Generated(hash = 315674997)
    public CityBean(Long CityBeanId, String CityName, Integer Sign) {
        this.CityBeanId = CityBeanId;
        this.CityName = CityName;
        this.Sign = Sign;
    }
    @Generated(hash = 273649691)
    public CityBean() {
    }
}
