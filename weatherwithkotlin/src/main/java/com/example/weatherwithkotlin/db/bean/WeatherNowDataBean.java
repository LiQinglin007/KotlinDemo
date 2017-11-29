package com.example.weatherwithkotlin.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/27
 * 内容：实况天气
 * 最后修改：
 */
@Entity
public class WeatherNowDataBean {
    @Id
    Long WeatherNowDataId;
    Long CityId;//城市表中的ID
    String CityName;//城市名称
    Long LastTime;//上次去服务器请求的时间
    String HttpCode;//请求服务器的code
    String UpdateTime;//更新时间
    String CloudCode;//实况天气状况代码
    String CloudTxt;//实况天气状况文字
    String Fl;//体感温度，默认单位：摄氏度
    String Hum;//相对湿度
    String Pcpn;//降水量
    String Tmp;//温度，默认单位：摄氏度
    String WindDir;//西南风  风向
    String WindSc;//微风  风力

    @Override
    public String toString() {
        return "WeatherNowDataBean{" +
                "WeatherNowDataId=" + WeatherNowDataId +
                ", CityId=" + CityId +
                ", CityName='" + CityName + '\'' +
                ", LastTime=" + LastTime +
                ", HttpCode='" + HttpCode + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", CloudCode='" + CloudCode + '\'' +
                ", CloudTxt='" + CloudTxt + '\'' +
                ", Fl='" + Fl + '\'' +
                ", Hum='" + Hum + '\'' +
                ", Pcpn='" + Pcpn + '\'' +
                ", Tmp='" + Tmp + '\'' +
                ", WindDir='" + WindDir + '\'' +
                ", WindSc='" + WindSc + '\'' +
                '}';
    }

    public String getWindSc() {
        return this.WindSc;
    }
    public void setWindSc(String WindSc) {
        this.WindSc = WindSc;
    }
    public String getWindDir() {
        return this.WindDir;
    }
    public void setWindDir(String WindDir) {
        this.WindDir = WindDir;
    }
    public String getTmp() {
        return this.Tmp;
    }
    public void setTmp(String Tmp) {
        this.Tmp = Tmp;
    }
    public String getPcpn() {
        return this.Pcpn;
    }
    public void setPcpn(String Pcpn) {
        this.Pcpn = Pcpn;
    }
    public String getHum() {
        return this.Hum;
    }
    public void setHum(String Hum) {
        this.Hum = Hum;
    }
    public String getFl() {
        return this.Fl;
    }
    public void setFl(String Fl) {
        this.Fl = Fl;
    }
    public String getCloudTxt() {
        return this.CloudTxt;
    }
    public void setCloudTxt(String CloudTxt) {
        this.CloudTxt = CloudTxt;
    }
    public String getCloudCode() {
        return this.CloudCode;
    }
    public void setCloudCode(String CloudCode) {
        this.CloudCode = CloudCode;
    }
    public String getUpdateTime() {
        return this.UpdateTime;
    }
    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }
    public Long getCityId() {
        return this.CityId;
    }
    public void setCityId(Long CityId) {
        this.CityId = CityId;
    }
    public Long getWeatherNowDataId() {
        return this.WeatherNowDataId;
    }
    public void setWeatherNowDataId(Long WeatherNowDataId) {
        this.WeatherNowDataId = WeatherNowDataId;
    }
    public String getCityName() {
        return this.CityName;
    }
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }
    public Long getLastTime() {
        return this.LastTime;
    }
    public void setLastTime(Long LastTime) {
        this.LastTime = LastTime;
    }
    public String getHttpCode() {
        return this.HttpCode;
    }
    public void setHttpCode(String HttpCode) {
        this.HttpCode = HttpCode;
    }
    @Generated(hash = 1894103231)
    public WeatherNowDataBean(Long WeatherNowDataId, Long CityId, String CityName,
            Long LastTime, String HttpCode, String UpdateTime, String CloudCode,
            String CloudTxt, String Fl, String Hum, String Pcpn, String Tmp,
            String WindDir, String WindSc) {
        this.WeatherNowDataId = WeatherNowDataId;
        this.CityId = CityId;
        this.CityName = CityName;
        this.LastTime = LastTime;
        this.HttpCode = HttpCode;
        this.UpdateTime = UpdateTime;
        this.CloudCode = CloudCode;
        this.CloudTxt = CloudTxt;
        this.Fl = Fl;
        this.Hum = Hum;
        this.Pcpn = Pcpn;
        this.Tmp = Tmp;
        this.WindDir = WindDir;
        this.WindSc = WindSc;
    }
    @Generated(hash = 1795671990)
    public WeatherNowDataBean() {
    }



}
