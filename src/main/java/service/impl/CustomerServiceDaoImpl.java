package service.impl;

import Dao.impl.CustomerDaoImpl;
import pojo.*;
import service.CustomerServiceDao;

import java.util.List;

public class CustomerServiceDaoImpl implements CustomerServiceDao{
    private static CustomerServiceDaoImpl ourInstance = new CustomerServiceDaoImpl();

    public static CustomerServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private CustomerServiceDaoImpl() {
    }

    private CustomerDaoImpl customerDao=new CustomerDaoImpl();

    public page<Customer> cusPageQueryAll(int pageNumber, int pageSize) {
        return customerDao.pageQuery(pageSize,pageNumber);
    }

    public int delCus(String id) {
        return customerDao.delCus(id);
    }

    public Customer queryById(String id) {
        return customerDao.queryById(id);
    }

    public int updateById(Customer cus) {
        return customerDao.updateById(cus);
    }

    public int addShop(Shoppingcar shop) {
        return customerDao.addShop(shop);
    }

    public int updateShop(Shoppingcar shop) {
        return 0;
    }

    public int delShop(String id) {
        return 0;
    }

    public Orderse queryOrder(String id) {
        return null;
    }

    public List<Goods> queryLikeGoods(String id, String name) {
        return null;
    }


}
