package service.impl;

import Dao.impl.CustomerDaoImpl;
import pojo.Customer;
import pojo.page;
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
}
