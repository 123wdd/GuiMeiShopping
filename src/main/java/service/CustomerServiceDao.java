package service;

import pojo.*;

import java.util.List;

public interface CustomerServiceDao {

    page<Customer> cusPageQueryAll(int pageNumber, int pageSize);
    int delCus(String id);
    Customer  queryById(String id);
    int updateById(Customer cus);

    /**
     * 前台
     * @return
     */
    //添加-购物车
    int addShop(Shoppingcar shop);
    //修改-购物车
    int updateShop(Shoppingcar shop);
    //删除-购物车
    int delShop(String id);
    //查询订单
    Orderse queryOrder(String id);
    //模糊查询商品信息
    List<Goods> queryLikeGoods(String id, String name);

}
