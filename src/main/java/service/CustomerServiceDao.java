package service;

import pojo.Customer;
import pojo.page;

import java.util.List;

public interface CustomerServiceDao {

    page<Customer> cusPageQueryAll(int pageNumber, int pageSize);
    int delCus(String id);
    Customer  queryById(String id);
    int updateById(Customer cus);

}
