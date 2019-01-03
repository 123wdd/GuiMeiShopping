package service;

import pojo.Customer;
import pojo.Superuser;
import pojo.page;

import java.util.List;

public interface SuperServiceDao {
    Superuser Login(String name, String pwd);
    int supUpdateSelf(Superuser sup);

    page<Customer> cusQuerylike( int pageNumber, int pageSize,String id, String name, String sex);
}
