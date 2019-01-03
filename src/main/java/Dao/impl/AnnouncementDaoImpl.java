package Dao.impl;

import Dao.AnnouncementDao;
import Dao.BaseDao;
import core.pageUtil;
import pojo.Announcement;
import pojo.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl extends BaseDao implements AnnouncementDao {
    public page<Announcement> annPageQueryAll(int pageNumber, int pageSize) {
        page<Announcement> Bpage=new page<Announcement>();
        Bpage.setPageNumber(pageNumber);
        Bpage.setPageSize(pageSize);
        String sql="SELECT COUNT(1) from announcement ";
        String sql2="select * from  announcement";
        Bpage.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<Announcement> list=new ArrayList<Announcement>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while(rs.next()){
               Announcement a=new Announcement();
             a.setATitle(rs.getString("aaTitle"));
             a.setAText(rs.getString("aaText"));
             a.setADate(rs.getDate("aaDate"));
             a.setId(rs.getLong("id"));
              list.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        Bpage.setPageData(list);
        return Bpage;

    }

    public int addAnn(Announcement ann) {
        String sql="insert into announcement values(?,?,?,?)";
        Object[]par={ann.getId(),ann.getAnTitle(),ann.getAnText(),ann.getAnDate()};
        return getUpdate(sql,par);
    }

    public int delAnn(String id) {
        String sql="delete from announcement where id=?";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public Announcement queryById(String id) {
        String sql="select * from announcement where id=?";
        Object[]par={id};
        ResultSet rs= getQuery(sql,par);
        Announcement a=new Announcement();
        try{
            while(rs.next()){
                a.setATitle(rs.getString("aaTitle"));
                a.setAText(rs.getString("aaText"));
                a.setADate(rs.getDate("aaDate"));
                a.setId(rs.getLong("id"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return   a;
    }

    public int updateByid(Announcement ann) {
        String sql="update announcement set id=?,aaTitle=?,aaText=?,aaDate=? where id=?";
        Object[]par={ann.getId(),ann.getAnTitle(),ann.getAnText(),ann.getAnDate(),ann.getId()};
        return getUpdate(sql,par);
    }
}
