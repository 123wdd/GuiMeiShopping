package Dao.impl;

import Dao.BaseDao;
import Dao.DiscountDao;
import core.pageUtil;
import pojo.Discount;
import pojo.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountDaoImpl extends BaseDao implements DiscountDao{
    public page<Discount> disPageQueryAll(int pageNumber, int pageSize) {
        page<Discount> page=new page<Discount>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        String sql="select count(1) from discount ";
        String sql2="select *from discount";
        page.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<Discount> list=new ArrayList<Discount>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while(rs.next()){
                Discount dis=new Discount();
                dis.setId(rs.getLong("id"));
                dis.setDiscRate(rs.getDouble("discRate"));
                list.add(dis);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(list);
        return page;
    }

    public int delDis(String id) {
        String sql="delete from discount where id=?";
        Object[]par={id};
        return getUpdate(sql,par);
    }
}
