package service.impl;

import Dao.impl.SellerDaoImpl;
import pojo.Goods;
import pojo.Seller;
import pojo.page;
import service.SellerServiceDao;

import java.util.List;

public class SellerServiceDaoIMpl implements SellerServiceDao{
    private static SellerServiceDaoIMpl ourInstance = new SellerServiceDaoIMpl();

    public static SellerServiceDaoIMpl getInstance() {
        return ourInstance;
    }

    private SellerServiceDaoIMpl() {
    }
    private SellerDaoImpl sellerDao=new SellerDaoImpl();

    public page<Seller> sellPageQuery(int pageNumber, int pageSize) {
        return sellerDao.sellPageQuery(pageNumber,pageSize);
    }

    public int delSell(String id) {
        return sellerDao.delSell(id);
    }

    public int addSell(Seller se) {
        return sellerDao.addSell(se);
    }

    public int uppdateSell(Seller se) {
        return sellerDao.uppdateSell(se);
    }

    public Seller queryById(String id) {
        return sellerDao.queryById(id);
    }

    public List<Seller> queryById() {
        return sellerDao.queryById();
    }

    public List<Goods> queryGoods(String id) {
        return sellerDao.queryGoods(id);
    }

    public Goods ggQueryLike(String goodsid, String sellerid, String name) {
        return sellerDao.ggQueryLike(goodsid,sellerid,name);
    }


}
