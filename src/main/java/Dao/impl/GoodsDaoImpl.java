package Dao.impl;

import Dao.BaseDao;
import Dao.GoodsDao;
import core.pageUtil;
import pojo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao{
    public page<goodsSmaSell> goodsPageQueryAll(int pageNumber, int pageSize) {
        page<goodsSmaSell> Gpage=new page<goodsSmaSell>();
        Gpage.setPageSize(pageSize);
        Gpage.setPageNumber(pageNumber);
        String sql1="select count(1) from goods";
        String sql2= "SELECT goods.id,goods.goodsName,smallclass.smallName,goods.goodsMoney,goods.goodsNumber,goods.goodsImage,goods.goodsCarriage,goods.goodsType,seller.sellerName,discount.discRate\n" +
                "from goods\n" +
                "INNER JOIN seller ON goods.goodsSellId=seller.id\n" +
                "INNER JOIN smallclass ON smallclass.id=goods.goodsSmalId\n" +
                "INNER JOIN discount ON goodsDiscId=discount.id";
        Gpage.setTotalRecode(pageUtil.getTotalRecode(sql1,null));
        List<goodsSmaSell> list=new ArrayList<goodsSmaSell>();
        ResultSet rs=pageUtil.getPageDate(sql2,pageSize,pageNumber,null);

        try{
            while (rs.next()){
                goodsSmaSell goodsSmaSell=new goodsSmaSell();
                Goods g=new Goods();
                g.setId(rs.getLong("id"));
                g.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                g.setGoodsImage(rs.getString("goodsImage"));
                g.setGoodsMoney(rs.getDouble("goodsMoney"));
                g.setGoodsName(rs.getString("goodsName"));
                g.setGoodsNumber(rs.getLong("goodsNumber"));
                g.setGoodsType(rs.getLong("goodsType"));
                goodsSmaSell.setGood(g);
                Smallclass ss=new Smallclass();
                ss.setSmallName(rs.getString("smallName"));
                Seller se=new Seller();
                se.setSellerName(rs.getString("sellerName"));
                Discount dis=new Discount();
                dis.setDiscRate(rs.getDouble("discRate"));
                goodsSmaSell.setDis(dis);
                goodsSmaSell.setSel(se);
                goodsSmaSell.setSma(ss);
                list.add(goodsSmaSell);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
        Gpage.setPageData(list);
        return Gpage;
    }

    public int delGoods(String id) {
        String sql="delete from goods where id = ?";
        Object[]par={id};
        return getUpdate(sql,par);
    }

    public int add(Goods gg) {
        String sql = "insert into goods  values (?,?,?,?,?,?,?,?,?,?)";
        Object []paramete = {gg.getId(),gg.getGoodsName(),gg.getGoodsSmalId(),gg.getGoodsMoney(),gg.getGoodsNumber(),
                gg.getGoodsImage(), gg.getGoodsCarriage(),gg.getGoodsType(),gg.getGoodsDiscId(),gg.getGoodsSellId()};
        return getUpdate(sql,paramete);
    }

    public List<Goods> query(String sql, Object[] parameter) {
        return null;
    }

    public Goods queryById(String id) {
        String sql="select * from goods where id=?";
        Object[]par={id};
        ResultSet rs= getQuery(sql,par);
        Goods g=new Goods();
        try{
            while (rs.next()){
                g.setId(rs.getLong("id"));
                g.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                g.setGoodsImage(rs.getString("goodsImage"));
                g.setGoodsMoney(rs.getDouble("goodsMoney"));
                g.setGoodsName(rs.getString("goodsName"));
                g.setGoodsNumber(rs.getLong("goodsNumber"));
                g.setGoodsType(rs.getLong("goodsType"));
                g.setGoodsDiscId(rs.getLong("goodsDiscId"));
                g.setGoodsSmalId(rs.getLong("goodsSmalId"));
                g.setGoodsSellid(rs.getLong("goodsSellId"));
            }
            return  g;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();

        }
        return  null;
    }

    public int update(Goods gg) {
        String sql="update goods set id=?,goodsName=?,goodsSmalId=?,goodsMoney=?,goodsNumber=?," +
                "goodsCarriage=?,goodsType=?,goodsDiscId=?,goodsSellId=? where id=?";
        Object[]par={gg.getId(),gg.getGoodsName(),gg.getGoodsSmalId(),gg.getGoodsMoney(),
                gg.getGoodsNumber(),gg.getGoodsCarriage(),gg.getGoodsType(),gg.getGoodsDiscId(),gg.getGoodsSellId(),gg.getId()};
        return getUpdate(sql,par);
    }

}
