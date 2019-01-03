package service.impl;

import Dao.impl.OrderDaoImpl;
import pojo.Orderse;
import pojo.page;
import service.OrderServiceDao;

public class OrderServiceDaoImpl implements OrderServiceDao{
    private static OrderServiceDaoImpl ourInstance = new OrderServiceDaoImpl();

    public static OrderServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private OrderServiceDaoImpl() {
    }

    private OrderDaoImpl orderDao=new OrderDaoImpl();

    public page<Orderse> orderPageQueryAll(int pageNumber, int pageSize) {
        return orderDao.orderPageQueryAll(pageNumber,pageSize);
    }

    public int delOrder(String id) {
        return orderDao.delOrder(id);
    }

    public int updateById(Orderse oo) {
        return 0;
    }

    public Orderse queryByid(String id) {
        return null;
    }
}
