package Dao.impl;

import Dao.BaseDao;
import Dao.SellerDao;
import core.pageUtil;
import pojo.*;

import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoImpl extends BaseDao implements SellerDao{
    public page<Seller> sellPageQuery(int pageNumber, int pageSize) {
        page<Seller> Bpage=new page<Seller>();
        Bpage.setPageNumber(pageNumber);
        Bpage.setPageSize(pageSize);
        String sql="SELECT COUNT(1) from seller ";
        String sql2="select * from  seller";
        Bpage.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<Seller> list=new ArrayList<Seller>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while(rs.next()){
               Seller ss=new Seller();
               ss.setId(rs.getLong("id"));
               ss.setSellerName(rs.getString("sellerName"));
               ss.setSellerAddress(rs.getString("sellerAddress"));
               ss.setSellerBirthday(rs.getDate("sellerBirthday"));
               ss.setSellerEmail(rs.getString("sellerEmail"));
               ss.setSellerIdCard(rs.getString("sellerIdCard"));
               //ss.setSellerPassword(rs.getString("sellerPassword"));
               ss.setSellerSex(rs.getString("sellerSex"));
               ss.setSellerTel(rs.getString("sellerTel"));
               ss.setSellerUser(rs.getString("sellerUser"));
               list.add(ss);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        Bpage.setPageData(list);
        return Bpage;
    }

    public int delSell(String id) {
        String sql="delete from seller WHERE id NOT IN (SELECT goodsSellId from goods) and id=?";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public int addSell(Seller se) {
        String sql="insert into seller values(?,?,?,?,?,?,?,?,?,?)";
        Object[]par={se.getId(),se.getSellerName(),se.getSellerUser(),se.getSellerPassword(),se.getSellerSex(),se.getSellerBirthday(),se.getSellerIdCard(), se.getSellerEmail(),se.getSellerTel(),se.getSellerAddress()};
        return getUpdate(sql,par);
    }

    public int uppdateSell(Seller se) {
        String sql="update seller set id=?,sellerName=?,sellerUser=?,sellerPassword=?,sellerSex=?,sellerBirthday=?,sellerIdCard=?,sellerEmail=?,sellerTel=?,sellerAddress=? where id=?";
        Object[]par={se.getId(),se.getSellerName(),se.getSellerUser(),se.getSellerPassword(),se.getSellerSex(),se.getSellerBirthday(),se.getSellerIdCard(),se.getSellerEmail(),se.getSellerTel(),se.getSellerAddress(),se.getId()};
        return getUpdate(sql,par);
    }

    public Seller queryById(String id) {
        String sql="select * from seller where id=?";
        Object[]par={id};
        ResultSet rs=getQuery(sql,par);
        Seller ss=new Seller();
        try{
            while(rs.next()){
                ss.setId(rs.getLong("id"));
                ss.setSellerName(rs.getString("sellerName"));
                ss.setSellerAddress(rs.getString("sellerAddress"));
                ss.setSellerBirthday(rs.getDate("sellerBirthday"));
                ss.setSellerEmail(rs.getString("sellerEmail"));
                ss.setSellerIdCard(rs.getString("sellerIdCard"));
                ss.setSellerPassword(rs.getString("sellerPassword"));
                ss.setSellerSex(rs.getString("sellerSex"));
                ss.setSellerTel(rs.getString("sellerTel"));
                ss.setSellerUser(rs.getString("sellerUser"));

            }
            return  ss;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return  null;
    }

    public List<Seller> queryById() {
        String sql="select * from seller ";

        ResultSet rs=getQuery(sql,null);
        List<Seller>list=new ArrayList<Seller>();
        Seller ss=new Seller();
        try{
            while(rs.next()){
                ss.setId(rs.getLong("id"));
                ss.setSellerName(rs.getString("sellerName"));
                ss.setSellerAddress(rs.getString("sellerAddress"));
                ss.setSellerBirthday(rs.getDate("sellerBirthday"));
                ss.setSellerEmail(rs.getString("sellerEmail"));
                ss.setSellerIdCard(rs.getString("sellerIdCard"));
                ss.setSellerPassword(rs.getString("sellerPassword"));
                ss.setSellerSex(rs.getString("sellerSex"));
                ss.setSellerTel(rs.getString("sellerTel"));
                ss.setSellerUser(rs.getString("sellerUser"));
                list.add(ss);
            }
            return  list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return  null;
    }

    public Seller queryByid(String id) {
        return null;
    }

    public int updateById(Seller ss) {
        return 0;
    }

    public int addGoods(Goods gg) {
        return 0;
    }

    public List<Goods> queryGoods(String id) {
        return null;
    }

    public Goods ggQueryLike(String id, String name) {
        return null;
    }

    public List<Orderse> queryOrder(String id) {
        return null;
    }


    public int updateAnnById(String id) {
        return 0;
    }
}
