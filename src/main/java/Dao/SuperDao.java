package Dao;

import pojo.Customer;
import pojo.Superuser;
import pojo.page;

import java.util.List;

public interface SuperDao  {
    List<Superuser> querySuper(String name,String pwd);
    int supUpdateSelf(Superuser sup);

    List<Customer> query(String sql,Object[]par);
    page<Customer> cusQuerylike(int pageNumber, int pageSize,String sql1,String sql2,Object[]par);

}
