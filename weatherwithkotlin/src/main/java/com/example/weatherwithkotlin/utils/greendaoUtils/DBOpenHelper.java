package com.example.weatherwithkotlin.utils.greendaoUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.weatherwithkotlin.db.gen.CityBeanDao;
import com.example.weatherwithkotlin.db.gen.DaoMaster;
import com.example.weatherwithkotlin.db.gen.WeatherNowDataBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * @author 小东
 * @version v1.0
 * @date 2017/2/28 10:00
 * @detail 数据库升级
 */
public class DBOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = DBOpenHelper.class.getSimpleName();

    public DBOpenHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory) {
        super(context, dbName, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //DBManager.getInstance().onUpgrade(db);
        /**
         * * 数据库版本号不能降低,会导致App无法安装(newVersion < oldVersion)
         * 循环数据库版本,更新各版本数据结构差异
         */
        if (newVersion > oldVersion) {
            MigrationHelper.getInstance().migrate(db, CityBeanDao.class);
            MigrationHelper.getInstance().migrate(db, WeatherNowDataBeanDao.class);
        }
    }
}
