package com.example.lql.kotlindemo.bean;

import java.util.List;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/23
 * 修改备注：
 */
public class WeatherDataBeanjava {


    @Override
    public String toString() {
        return "WeatherDataBeanjava{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    /**
     * date : 20171123
     * message : Success !
     * status : 200
     * city : 石家庄
     * count : 6
     * data : {"shidu":"24%","pm25":36,"pm10":88,"quality":"良","wendu":"4","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"22日星期三","sunrise":"07:09","high":"高温 12.0℃","low":"低温 0.0℃","sunset":"17:06","aqi":57,"fx":"西北风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},"forecast":[{"date":"23日星期四","sunrise":"07:10","high":"高温 11.0℃","low":"低温 -1.0℃","sunset":"17:06","aqi":65,"fx":"西风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"24日星期五","sunrise":"07:11","high":"高温 10.0℃","low":"低温 0.0℃","sunset":"17:05","aqi":67,"fx":"南风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"25日星期六","sunrise":"07:12","high":"高温 11.0℃","low":"低温 0.0℃","sunset":"17:05","aqi":141,"fx":"南风","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"26日星期日","sunrise":"07:13","high":"高温 6.0℃","low":"低温 -2.0℃","sunset":"17:04","aqi":85,"fx":"北风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"27日星期一","sunrise":"07:14","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"17:04","aqi":199,"fx":"南风","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "shidu='" + shidu + '\'' +
                    ", pm25=" + pm25 +
                    ", pm10=" + pm10 +
                    ", quality='" + quality + '\'' +
                    ", wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", yesterday=" + yesterday +
                    ", forecast=" + forecast +
                    '}';
        }

        /**
         * shidu : 24%
         * pm25 : 36.0
         * pm10 : 88.0
         * quality : 良
         * wendu : 4
         * ganmao : 极少数敏感人群应减少户外活动
         * yesterday : {"date":"22日星期三","sunrise":"07:09","high":"高温 12.0℃","low":"低温 0.0℃","sunset":"17:06","aqi":57,"fx":"西北风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"}
         * forecast : [{"date":"23日星期四","sunrise":"07:10","high":"高温 11.0℃","low":"低温 -1.0℃","sunset":"17:06","aqi":65,"fx":"西风","fl":"3-4级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"24日星期五","sunrise":"07:11","high":"高温 10.0℃","low":"低温 0.0℃","sunset":"17:05","aqi":67,"fx":"南风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"25日星期六","sunrise":"07:12","high":"高温 11.0℃","low":"低温 0.0℃","sunset":"17:05","aqi":141,"fx":"南风","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"26日星期日","sunrise":"07:13","high":"高温 6.0℃","low":"低温 -2.0℃","sunset":"17:04","aqi":85,"fx":"北风","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"27日星期一","sunrise":"07:14","high":"高温 9.0℃","low":"低温 -1.0℃","sunset":"17:04","aqi":199,"fx":"南风","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"}]
         */


        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            @Override
            public String toString() {
                return "YesterdayBean{" +
                        "date='" + date + '\'' +
                        ", sunrise='" + sunrise + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", aqi=" + aqi +
                        ", fx='" + fx + '\'' +
                        ", fl='" + fl + '\'' +
                        ", type='" + type + '\'' +
                        ", notice='" + notice + '\'' +
                        '}';
            }

            /**
             * date : 22日星期三
             * sunrise : 07:09
             * high : 高温 12.0℃
             * low : 低温 0.0℃
             * sunset : 17:06
             * aqi : 57.0
             * fx : 西北风
             * fl : 3-4级
             * type : 晴
             * notice : 天气干燥，请适当增加室内湿度
             */


            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            @Override
            public String toString() {
                return "ForecastBean{" +
                        "date='" + date + '\'' +
                        ", sunrise='" + sunrise + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", aqi=" + aqi +
                        ", fx='" + fx + '\'' +
                        ", fl='" + fl + '\'' +
                        ", type='" + type + '\'' +
                        ", notice='" + notice + '\'' +
                        '}';
            }

            /**
             * date : 23日星期四
             * sunrise : 07:10
             * high : 高温 11.0℃
             * low : 低温 -1.0℃
             * sunset : 17:06
             * aqi : 65.0
             * fx : 西风
             * fl : 3-4级
             * type : 晴
             * notice : 天气干燥，请适当增加室内湿度
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
