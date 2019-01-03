package Dao;

import pojo.*;

import java.util.List;

public interface CustomerDao {
    page<Customer> pageQuery(int pageSize, int pageNumber);

    int delCus(String id);

    Customer queryById(String id);
    int updateById(Customer cus);

    /**
     * 前台方法
     */
    //登录
   List<Customer> login(String name,String pwd);
    //注册
    int addCus(Customer cus);
    //查询商品
    List<Goods> query();
    //添加-购物车
    int addShop(Shoppingcar shop);
    //修改-购物车
    int updateShop(Shoppingcar shop);
    //删除-购物车
    int delShop(String id);
    //查询订单
    Orderse queryOrder(String id);
    //模糊查询商品信息
    List<Goods> queryLikeGoods(String id,String name);

}
