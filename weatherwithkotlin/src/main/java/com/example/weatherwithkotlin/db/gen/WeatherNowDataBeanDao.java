package com.example.weatherwithkotlin.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.weatherwithkotlin.db.bean.WeatherNowDataBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WEATHER_NOW_DATA_BEAN".
*/
public class WeatherNowDataBeanDao extends AbstractDao<WeatherNowDataBean, Long> {

    public static final String TABLENAME = "WEATHER_NOW_DATA_BEAN";

    /**
     * Properties of entity WeatherNowDataBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property WeatherNowDataId = new Property(0, Long.class, "WeatherNowDataId", true, "_id");
        public final static Property CityId = new Property(1, Long.class, "CityId", false, "CITY_ID");
        public final static Property CityName = new Property(2, String.class, "CityName", false, "CITY_NAME");
        public final static Property LastTime = new Property(3, Long.class, "LastTime", false, "LAST_TIME");
        public final static Property HttpCode = new Property(4, String.class, "HttpCode", false, "HTTP_CODE");
        public final static Property UpdateTime = new Property(5, String.class, "UpdateTime", false, "UPDATE_TIME");
        public final static Property CloudCode = new Property(6, String.class, "CloudCode", false, "CLOUD_CODE");
        public final static Property CloudTxt = new Property(7, String.class, "CloudTxt", false, "CLOUD_TXT");
        public final static Property Fl = new Property(8, String.class, "Fl", false, "FL");
        public final static Property Hum = new Property(9, String.class, "Hum", false, "HUM");
        public final static Property Pcpn = new Property(10, String.class, "Pcpn", false, "PCPN");
        public final static Property Tmp = new Property(11, String.class, "Tmp", false, "TMP");
        public final static Property WindDir = new Property(12, String.class, "WindDir", false, "WIND_DIR");
        public final static Property WindSc = new Property(13, String.class, "WindSc", false, "WIND_SC");
    };


    public WeatherNowDataBeanDao(DaoConfig config) {
        super(config);
    }
    
    public WeatherNowDataBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WEATHER_NOW_DATA_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: WeatherNowDataId
                "\"CITY_ID\" INTEGER," + // 1: CityId
                "\"CITY_NAME\" TEXT," + // 2: CityName
                "\"LAST_TIME\" INTEGER," + // 3: LastTime
                "\"HTTP_CODE\" TEXT," + // 4: HttpCode
                "\"UPDATE_TIME\" TEXT," + // 5: UpdateTime
                "\"CLOUD_CODE\" TEXT," + // 6: CloudCode
                "\"CLOUD_TXT\" TEXT," + // 7: CloudTxt
                "\"FL\" TEXT," + // 8: Fl
                "\"HUM\" TEXT," + // 9: Hum
                "\"PCPN\" TEXT," + // 10: Pcpn
                "\"TMP\" TEXT," + // 11: Tmp
                "\"WIND_DIR\" TEXT," + // 12: WindDir
                "\"WIND_SC\" TEXT);"); // 13: WindSc
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WEATHER_NOW_DATA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, WeatherNowDataBean entity) {
        stmt.clearBindings();
 
        Long WeatherNowDataId = entity.getWeatherNowDataId();
        if (WeatherNowDataId != null) {
            stmt.bindLong(1, WeatherNowDataId);
        }
 
        Long CityId = entity.getCityId();
        if (CityId != null) {
            stmt.bindLong(2, CityId);
        }
 
        String CityName = entity.getCityName();
        if (CityName != null) {
            stmt.bindString(3, CityName);
        }
 
        Long LastTime = entity.getLastTime();
        if (LastTime != null) {
            stmt.bindLong(4, LastTime);
        }
 
        String HttpCode = entity.getHttpCode();
        if (HttpCode != null) {
            stmt.bindString(5, HttpCode);
        }
 
        String UpdateTime = entity.getUpdateTime();
        if (UpdateTime != null) {
            stmt.bindString(6, UpdateTime);
        }
 
        String CloudCode = entity.getCloudCode();
        if (CloudCode != null) {
            stmt.bindString(7, CloudCode);
        }
 
        String CloudTxt = entity.getCloudTxt();
        if (CloudTxt != null) {
            stmt.bindString(8, CloudTxt);
        }
 
        String Fl = entity.getFl();
        if (Fl != null) {
            stmt.bindString(9, Fl);
        }
 
        String Hum = entity.getHum();
        if (Hum != null) {
            stmt.bindString(10, Hum);
        }
 
        String Pcpn = entity.getPcpn();
        if (Pcpn != null) {
            stmt.bindString(11, Pcpn);
        }
 
        String Tmp = entity.getTmp();
        if (Tmp != null) {
            stmt.bindString(12, Tmp);
        }
 
        String WindDir = entity.getWindDir();
        if (WindDir != null) {
            stmt.bindString(13, WindDir);
        }
 
        String WindSc = entity.getWindSc();
        if (WindSc != null) {
            stmt.bindString(14, WindSc);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, WeatherNowDataBean entity) {
        stmt.clearBindings();
 
        Long WeatherNowDataId = entity.getWeatherNowDataId();
        if (WeatherNowDataId != null) {
            stmt.bindLong(1, WeatherNowDataId);
        }
 
        Long CityId = entity.getCityId();
        if (CityId != null) {
            stmt.bindLong(2, CityId);
        }
 
        String CityName = entity.getCityName();
        if (CityName != null) {
            stmt.bindString(3, CityName);
        }
 
        Long LastTime = entity.getLastTime();
        if (LastTime != null) {
            stmt.bindLong(4, LastTime);
        }
 
        String HttpCode = entity.getHttpCode();
        if (HttpCode != null) {
            stmt.bindString(5, HttpCode);
        }
 
        String UpdateTime = entity.getUpdateTime();
        if (UpdateTime != null) {
            stmt.bindString(6, UpdateTime);
        }
 
        String CloudCode = entity.getCloudCode();
        if (CloudCode != null) {
            stmt.bindString(7, CloudCode);
        }
 
        String CloudTxt = entity.getCloudTxt();
        if (CloudTxt != null) {
            stmt.bindString(8, CloudTxt);
        }
 
        String Fl = entity.getFl();
        if (Fl != null) {
            stmt.bindString(9, Fl);
        }
 
        String Hum = entity.getHum();
        if (Hum != null) {
            stmt.bindString(10, Hum);
        }
 
        String Pcpn = entity.getPcpn();
        if (Pcpn != null) {
            stmt.bindString(11, Pcpn);
        }
 
        String Tmp = entity.getTmp();
        if (Tmp != null) {
            stmt.bindString(12, Tmp);
        }
 
        String WindDir = entity.getWindDir();
        if (WindDir != null) {
            stmt.bindString(13, WindDir);
        }
 
        String WindSc = entity.getWindSc();
        if (WindSc != null) {
            stmt.bindString(14, WindSc);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public WeatherNowDataBean readEntity(Cursor cursor, int offset) {
        WeatherNowDataBean entity = new WeatherNowDataBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // WeatherNowDataId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // CityId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // CityName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // LastTime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // HttpCode
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // UpdateTime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // CloudCode
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // CloudTxt
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // Fl
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // Hum
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // Pcpn
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // Tmp
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // WindDir
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13) // WindSc
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, WeatherNowDataBean entity, int offset) {
        entity.setWeatherNowDataId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCityName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLastTime(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setHttpCode(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUpdateTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCloudCode(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCloudTxt(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setFl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setHum(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPcpn(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setTmp(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setWindDir(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setWindSc(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(WeatherNowDataBean entity, long rowId) {
        entity.setWeatherNowDataId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(WeatherNowDataBean entity) {
        if(entity != null) {
            return entity.getWeatherNowDataId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
