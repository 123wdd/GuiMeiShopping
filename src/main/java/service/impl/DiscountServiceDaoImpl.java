package service.impl;

import Dao.impl.DiscountDaoImpl;
import pojo.Discount;
import pojo.page;
import service.DiscountServiceDao;

public class DiscountServiceDaoImpl implements DiscountServiceDao {
    private static DiscountServiceDaoImpl ourInstance = new DiscountServiceDaoImpl();

    public static DiscountServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private DiscountServiceDaoImpl() {
    }
    private DiscountDaoImpl discountDao=new DiscountDaoImpl();

    public page<Discount> disPageQueryAll(int pageNumber, int pageSize) {
        return discountDao.disPageQueryAll(pageNumber,pageSize);
    }

    public int delDis(String id) {
        return discountDao.delDis(id);
    }
}
