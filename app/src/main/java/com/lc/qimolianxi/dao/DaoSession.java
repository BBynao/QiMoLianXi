package com.lc.qimolianxi.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.lc.qimolianxi.bean.MainGreenDaoBean;

import com.lc.qimolianxi.dao.MainGreenDaoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig mainGreenDaoBeanDaoConfig;

    private final MainGreenDaoBeanDao mainGreenDaoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        mainGreenDaoBeanDaoConfig = daoConfigMap.get(MainGreenDaoBeanDao.class).clone();
        mainGreenDaoBeanDaoConfig.initIdentityScope(type);

        mainGreenDaoBeanDao = new MainGreenDaoBeanDao(mainGreenDaoBeanDaoConfig, this);

        registerDao(MainGreenDaoBean.class, mainGreenDaoBeanDao);
    }
    
    public void clear() {
        mainGreenDaoBeanDaoConfig.clearIdentityScope();
    }

    public MainGreenDaoBeanDao getMainGreenDaoBeanDao() {
        return mainGreenDaoBeanDao;
    }

}