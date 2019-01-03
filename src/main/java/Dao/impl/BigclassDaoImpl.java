package Dao.impl;

import Dao.BaseDao;
import Dao.BigclassDao;
import core.pageUtil;
import pojo.Bigclass;
import pojo.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BigclassDaoImpl extends BaseDao implements BigclassDao {
    public page<Bigclass> bigPageQueryAll(int pageNumber, int pageSize) {
        page<Bigclass> Bpage=new page<Bigclass>();
        Bpage.setPageNumber(pageNumber);
        Bpage.setPageSize(pageSize);
        String sql="SELECT COUNT(1) from bigclass ";
        String sql2="select * from  bigclass";
        Bpage.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<Bigclass> list=new ArrayList<Bigclass>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while(rs.next()){
                Bigclass b=new Bigclass();
                b.setId(rs.getLong("id"));
                b.setBigName(rs.getString("bigName"));
                b.setBigText(rs.getString("bigText"));
                list.add(b);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
         dbClose();
        }
            Bpage.setPageData(list);

        return Bpage;
    }

    public int delBig(String id) {
        String sql="DELETE FROM bigclass where id=?  and id not IN (select smallclass.smallBigId FROM smallclass) ";
        Object[]par={id};
        return  getUpdate(sql,par);

    }

    public int updateById(Bigclass big) {
        String sql="update bigclass set id=?,bigName=?,bigText=? where id=?";
        Object[]par={big.getId(),big.getBigName(),big.getBigText(),big.getId()};
        return getUpdate(sql,par);
    }

    public Bigclass queryById(String id) {
        String sql="select * from bigclass where id=?";
        Object[]par={id};
        ResultSet rs=getQuery(sql,par);
        Bigclass b=null;
        try{
            while(rs.next()){
               b=new Bigclass();
                b.setId(rs.getLong("id"));
                b.setBigName(rs.getString("bigName"));
                b.setBigText(rs.getString("bigText"));

            }
            return b;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    public int addBig(Bigclass big) {
        String sql="INSERT IGNORE INTO bigclass VALUE(?,?,?)";
        Object[]par={big.getId(),big.getBigName(),big.getBigText()};
        return getUpdate(sql,par);
    }
}
