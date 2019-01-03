package Dao;

import pojo.*;

import java.util.List;

public interface SellerDao  {
    page<Seller> sellPageQuery(int pageNumber, int pageSize);
    int delSell(String id);
    int addSell(Seller se);
    int uppdateSell(Seller se);
    Seller queryById(String id);
    List<Seller> queryById();



    /**
     * 前端方法如下
     */
    //查询个人信息
    Seller queryByid(String id);
    //修改个人信息+密码
    int updateById(Seller ss);
    //添加商品
    int addGoods(Goods gg);
    //查询商品
    List<Goods> queryGoods(String id);
    //级联查询
    Goods ggQueryLike(String id,String name);
    //查询订单
    List<Orderse> queryOrder(String id);
    //修改订单
    int updateAnnById(String id);



}
