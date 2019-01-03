package Dao.impl;

import Dao.BaseDao;
import Dao.SuperDao;
import core.pageUtil;
import pojo.Customer;
import pojo.Superuser;
import pojo.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperDaoImpl extends BaseDao implements SuperDao {
    public List<Superuser> querySuper(String name,String pwd) {
        String sql="select * from superuser where userLoginName=? and userPassword=?";
        Object[]par={name,pwd};
        List<Superuser> supList=new ArrayList<Superuser>();
        ResultSet rs=getQuery(sql,par);
        try{
            while (rs.next()){
                Superuser sup=new Superuser();
                sup.setId(rs.getLong("id"));
                sup.setUserId(rs.getString("userID"));
                sup.setUserName(rs.getString("userName"));
                sup.setUserLoginName(rs.getString("userLoginName"));
                sup.setUserPassword(rs.getString("userPassword"));
                sup.setUserImage(rs.getString("userImage"));
                sup.setUserStatus(rs.getLong("userStatus"));
                supList.add(sup);
            }
            return  supList;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    public int supUpdateSelf(Superuser sup) {
        String sql="update superuser set userName=?,userImage=?,userStatus=?,userID=?,userLoginName=? where id=?";
        Object[]par={sup.getUserName(),sup.getUserImage(),sup.getUserStatus(),sup.getUserId(),sup.getUserLoginName(),sup.getId()};
        return getUpdate(sql,par);
    }

    public List<Customer> query(String sql,Object[]par) {
        ResultSet rs= getQuery(sql,par);
        List<Customer>cuslist=new ArrayList<Customer>();
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
                cuslist.add(cus);
            }
            return  cuslist;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    public page<Customer> cusQuerylike(int pageNumber, int pageSize, String sql1,String sql2,Object[]par) {
        page<Customer> pageList=new page<Customer>();
        pageList.setPageSize(pageSize);
        pageList.setPageNumber(pageNumber);
        pageList.setTotalRecode(pageUtil.getTotalRecode(sql1,par));
        List<Customer> list=new ArrayList<Customer>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,par);
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
}
