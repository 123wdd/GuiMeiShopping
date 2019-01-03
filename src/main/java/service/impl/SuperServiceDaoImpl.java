package service.impl;

import Dao.impl.SuperDaoImpl;
import core.pageUtil;
import pojo.Customer;
import pojo.Superuser;
import pojo.page;
import service.SuperServiceDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SuperServiceDaoImpl implements SuperServiceDao {
    private static SuperServiceDaoImpl ourInstance = new SuperServiceDaoImpl();

    public static SuperServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private SuperServiceDaoImpl() {
    }

    private SuperDaoImpl superDao = new SuperDaoImpl();

    public Superuser Login(String name, String pwd) {
        List<Superuser> sup = superDao.querySuper(name, pwd);
        if (sup != null && sup.size() > 0) {
            return sup.get(0);
        }
        return null;
    }

    public int supUpdateSelf(Superuser sup) {
        return superDao.supUpdateSelf(sup);
    }

    public page<Customer> cusQuerylike(int pageNumber, int pageSize, String id, String name, String sex) {

        if (id!=null && name!=null && sex!=null) {
            int idsize = id.length();
            int nameSize = name.length();
            int sexSize = sex.length();

            if (idsize == 0 && nameSize == 0 && sexSize == 0) {
                //查询所有
                String sql = "select count(1) from customer ";
                String sql2 = "select * from customer";
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, null);

            } else if (idsize > 0 && nameSize == 0 && sexSize == 0) {
                //根据id具体查询
                String sql = "select count(1) from customer  where id=?";
                String sql2 = "select *from customer where id=? ";
                Object[] par = {id};
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, par);
            } else if (idsize == 0 && nameSize > 0 && sexSize == 0) {
                //根据姓名模糊查询
                String sql = "select count(1) from customer  where cusName like ? ";
                String sql2 = "select*from customer where cusName like ? ";
                Object[] par = {"%" + name + "%"};
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, par);
            } else if (idsize == 0 && nameSize == 0 && sexSize > 0) {
                //根据性别查询
                String sql = "select count(1) from customer  where cusSex = ?";
                String sql2 = "select*from customer where cusSex = ? ";
                Object[] par = {sex};
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, par);

            } else if (idsize > 0 && nameSize > 0 && sexSize > 0) {
                //根据id姓名性别查询
                String sql = "select count(1) from customer  where id = ? and cusName like ? and cusSex=?";
                String sql2 = "select*from customer where id = ? and cusName like ? and cusSex=? ";
                Object[] par = {id, "%" + name + "%", sex};
                return superDao.cusQuerylike(pageNumber, pageSize,sql, sql2, par);
            } else if (idsize > 0 && nameSize > 0 && sexSize == 0) {
                //根据id姓名查询
                String sql = "select count(1) from customer  where id = ? and cusName like ?";
                String sql2 = "select*from customer where id = ? and cusName like ? ";
                Object[] par = {id, "%" + name + "%"};
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, par);
            } else if (idsize > 0 && nameSize == 0 && sexSize > 0) {
                String sql = "select count(1) from customer  where id = ? and cusSex=?";
                String sql2 = "select*from customer where id = ? and cusSex=? ";
                Object[] par = {id, sex};
                return superDao.cusQuerylike(pageNumber, pageSize, sql, sql2, par);
            }


        }
        return null;
    }

}
