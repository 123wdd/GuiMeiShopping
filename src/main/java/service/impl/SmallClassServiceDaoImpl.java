package service.impl;

import Dao.impl.SmallClassDaoImpl;
import pojo.Smallclass;
import pojo.page;
import pojo.smallBig;
import service.SmallClassServiceDao;

public class SmallClassServiceDaoImpl implements SmallClassServiceDao {
    private static SmallClassServiceDaoImpl ourInstance = new SmallClassServiceDaoImpl();

    public static SmallClassServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private SmallClassServiceDaoImpl() {
    }

    private SmallClassDaoImpl smallClassDao=new SmallClassDaoImpl();
    public page<smallBig> smaPageQueryAll(int pageNumber, int pageSize) {
        return smallClassDao.bigPageQueryAll(pageNumber,pageSize);
    }

    public int delSma(String id) {
        return smallClassDao.delSma(id);
    }

    public Smallclass sm() {
        return smallClassDao.sm();
    }
}
