package Dao.impl;

import Dao.BaseDao;
import Dao.OrderDao;
import core.pageUtil;
import pojo.Orderse;
import pojo.page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDaoImpl  extends BaseDao implements OrderDao {
    public page<Orderse> orderPageQueryAll(int pageNumber, int pageSize) {

        page<Orderse> page=new page<Orderse>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        String sql="select count(1) from orderse ";
        String sql2="select *from orderse";
        page.setTotalRecode(pageUtil.getTotalRecode(sql,null));
        List<Orderse> list=new ArrayList<Orderse>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while(rs.next()){
                Orderse oo=new Orderse();
                oo.setId(rs.getLong("id"));
                oo.setOrderseCusId(rs.getLong("orderseCusId"));
                oo.setOrderseAddress(rs.getString("orderseAddress"));
                oo.setOrderseDate(rs.getDate("orderseDate"));
                oo.setOrderseGoodsId(rs.getLong("orderseGoodsId"));
                oo.setOrderseMoney(rs.getDouble("orderseMoney"));
                oo.setOrderseStatus(rs.getLong("orderseStatus"));
                list.add(oo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(list);
        return page;
    }

    public int delOrder(String id) {
        String sql="delete from orderse where id=?";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public int updateById(Orderse oo) {
        return 0;
    }

    public Orderse queryByid(String id) {
        String sql="select * from orderse where id=?";
        Object[]par={id};
        ResultSet rs= getQuery(sql,par);

        try{
            while (rs.next()){
                Orderse or=new Orderse();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
        return  null;
    }
}
