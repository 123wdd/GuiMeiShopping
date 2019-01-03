package Dao.impl;

import Dao.BaseDao;
import Dao.CustomerDao;
import core.pageUtil;
import pojo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao{

    public page<Customer> pageQuery(int pageSize, int pageNumber) {
        page<Customer> pageList=new page<Customer>();
        pageList.setPageSize(pageSize);
        pageList.setPageNumber(pageNumber);
        String sql1 = "select count(1) from customer";
        String sql2 = "select * from customer";
        pageList.setTotalRecode(pageUtil.getTotalRecode(sql1,null));
        List<Customer> list=new ArrayList<Customer>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                    Customer cus=new Customer();
                    cus.setId(rs.getLong("id"));
                    cus.setCusName(rs.getString("cusName"));
                    cus.setCusLoginName(rs.getString("cusLoginName"));
                    cus.setCusBirthday(rs.getDate("cusBirthday"));
                    cus.setCusCode(rs.getString("cusCode"));
                    cus.setCusEmail(rs.getString("cusEmail"));
                    cus.setCusHobby(rs.getString("cusHobby"));
                    cus.setCusPassword(rs.getString("cusPassword"));
                    cus.setCusSex(rs.getString("cusSex"));
                    cus.setCusPhoto(rs.getString("cusPhoto"));
                    list.add(cus);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        pageList.setPageData(list);
        return pageList;
    }

    public int delCus(String id) {
        String sql="delete from customer where id=?";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public Customer queryById(String id) {
        String sql="select *from customer where id=?";
        Object[]par={id};
        ResultSet rs=getQuery(sql,par);
        Customer cus=null;
        try{
            while(rs.next()){
                 cus=new Customer();
                cus.setId(rs.getLong("id"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusLoginName(rs.getString("cusLoginName"));
                cus.setCusBirthday(rs.getDate("cusBirthday"));
                cus.setCusCode(rs.getString("cusCode"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusHobby(rs.getString("cusHobby"));
                cus.setCusPassword(rs.getString("cusPassword"));
                cus.setCusSex(rs.getString("cusSex"));
                cus.setCusPhoto(rs.getString("cusPhoto"));
            }
           return  cus;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    public int updateById(Customer cus) {
        String sql="update customer set id=?,cusName=?,cusEmail=?,cusSex=?,cusPhoto=?,cusHobby=?,cusCode=?,cusBirthday=? where id=?";
        Object[]par={cus.getId(),cus.getCusName(),cus.getCusEmail(),cus.getCusSex(),cus.getCusPhoto(),cus.getCusHobby(),cus.getCusCode(),cus.getCusBirthday(),cus.getId()};
        return getUpdate(sql,par);
    }

    public List<Customer> login(String name, String pwd) {
        return null;
    }

    public int addCus(Customer cus) {
        return 0;
    }

    public List<Goods> query() {
        return null;
    }

    public int addShop(Shoppingcar shop) {
        return 0;
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
