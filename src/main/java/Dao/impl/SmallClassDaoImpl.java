package Dao.impl;

import Dao.BaseDao;
import Dao.SmallClassDao;
import core.pageUtil;
import pojo.Bigclass;
import pojo.Smallclass;
import pojo.page;
import pojo.smallBig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmallClassDaoImpl extends BaseDao implements SmallClassDao{
    public page<smallBig> bigPageQueryAll(int pageNumber, int pageSize) {
        page<smallBig> Spage=new page<smallBig>();
        Spage.setPageSize(pageSize);
        Spage.setPageNumber(pageNumber);
        String sql= "select count(1) from smallclass INNER JOIN bigclass ON smallBigId=bigclass.id";
        String sql2="select smallclass.id,smallName,smallBigId,smallText,bigclass.bigName from smallclass\n" +
                "INNER JOIN bigclass ON smallBigId=bigclass.id\n" +
                "ORDER BY smallclass.id DESC";
        Spage.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<smallBig> list=new ArrayList<smallBig>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while (rs.next()){
                smallBig smallBig=new smallBig();
               Smallclass sma=new Smallclass();
               sma.setId(rs.getLong("id"));
               sma.setSmallText(rs.getString("smallText"));
               sma.setSmallName(rs.getString("smallName"));
               sma.setSmallBigId(rs.getLong("smallBigId"));
               smallBig.setSma(sma);
                Bigclass big=new Bigclass();
                big.setBigName(rs.getString("bigName"));
                smallBig.setBig(big);
                list.add(smallBig);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        Spage.setPageData(list);
        return Spage;
    }

    public int delSma(String id) {
        String sql="delete from smallclass WHERE  id NOT IN (SELECT goodsSmalId from goods) and id=?  ";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public Smallclass sm() {
        String sql="select * from smallclass";
        ResultSet rs=getQuery(sql,null);
        Smallclass sma=new Smallclass();
        try{
            while (rs.next()){
                sma.setId(rs.getLong("id"));
                sma.setSmallText(rs.getString("smallText"));
                sma.setSmallName(rs.getString("smallName"));
                sma.setSmallBigId(rs.getLong("smallBigId"));
            }
            return  sma;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }

        return null;
    }
}
