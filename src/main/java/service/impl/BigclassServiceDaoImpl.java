package service.impl;

import Dao.impl.BigclassDaoImpl;
import pojo.Bigclass;
import pojo.page;
import service.BigclassServiceDao;

public class BigclassServiceDaoImpl implements BigclassServiceDao{
    private static BigclassServiceDaoImpl ourInstance = new BigclassServiceDaoImpl();

    public static BigclassServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private BigclassServiceDaoImpl() {
    }

    private BigclassDaoImpl bigclassDao=new BigclassDaoImpl();
    public page<Bigclass> bigPageQueryAll(int pageNumber, int pageSize) {
        return bigclassDao.bigPageQueryAll(pageNumber,pageSize) ;
    }

    public int delBig(String id) {
        return bigclassDao.delBig(id);
    }

    public int updateById(Bigclass big) {
        return bigclassDao.updateById(big);
    }

    public Bigclass queryById(String id) {
        return bigclassDao.queryById(id);
    }

    public int addBig(Bigclass big) {
        return bigclassDao.addBig(big);
    }
}
