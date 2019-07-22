package com.lc.qimolianxi.db;

import com.lc.qimolianxi.app.MainApplocation;
import com.lc.qimolianxi.bean.MainGreenDaoBean;
import com.lc.qimolianxi.dao.DaoMaster;
import com.lc.qimolianxi.dao.DaoSession;
import com.lc.qimolianxi.dao.MainGreenDaoBeanDao;

import java.util.List;

public class MainDBUtil {
    public static MainDBUtil dbUtil;
    private static MainGreenDaoBeanDao dao;

    public static MainDBUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized(MainDBUtil.class){
                if (dbUtil == null) {
                    dbUtil =new MainDBUtil();
                }
            }
        }
        return dbUtil;
    }

    public MainDBUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MainApplocation.getApplocation(), "lc.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getMainGreenDaoBeanDao();
    }

    public static long inser(MainGreenDaoBean bean){
        if (!isHas(bean)){
            long l = dao.insertOrReplace(bean);
            return l;
        }
        return -1;
    }

    public static boolean delete(MainGreenDaoBean bean){
        if (isHas(bean)){
            dao.delete(bean);
            return true;
        }
        return false;
    }

    public static List<MainGreenDaoBean> queryAll(){
        List<MainGreenDaoBean> list = dao.queryBuilder().list();
        return list;
    }

    public static boolean update(MainGreenDaoBean bean){
       if (isHas(bean)){
           dao.update(bean);
           return true;
       }
       return false;
    }

    public static boolean isHas(MainGreenDaoBean bean){
        List<MainGreenDaoBean> list = dao.queryBuilder().where(MainGreenDaoBeanDao.Properties.Desc.eq(bean.getDesc())).list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
