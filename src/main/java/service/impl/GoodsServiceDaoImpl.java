package service.impl;

import Dao.impl.GoodsDaoImpl;
import pojo.Goods;
import pojo.goodsSmaSell;
import pojo.page;
import service.GoodsServiceDao;

import java.util.List;

public class GoodsServiceDaoImpl implements GoodsServiceDao {
    private static GoodsServiceDaoImpl ourInstance = new GoodsServiceDaoImpl();

    public static GoodsServiceDaoImpl getInstance() {
        return ourInstance;
    }

    public GoodsServiceDaoImpl() {
    }

    private GoodsDaoImpl goodsDao=new GoodsDaoImpl();
    public page<goodsSmaSell> goodsPageQueryAll(int pageNumber, int pageSize) {
        return goodsDao.goodsPageQueryAll(pageNumber,pageSize);
    }

    public int delGoods(String id) {
        return goodsDao.delGoods(id);
    }

    public int addGoods(Goods gg) {
     return  goodsDao.add(gg);
    }

    public Goods queryById(String id) {
        return goodsDao.queryById(id);
    }

    public int update(Goods gg) {
        return goodsDao.update(gg);
    }
}
