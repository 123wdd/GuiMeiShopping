package Dao;

import pojo.Goods;
import pojo.goodsSmaSell;
import pojo.page;

import java.util.List;

public interface GoodsDao {
    page<goodsSmaSell> goodsPageQueryAll(int pageNumber, int pageSize);
    int delGoods(String id);
    int add(Goods gg);
    List<Goods> query(String sql, Object[] parameter);
    Goods queryById(String id);
    int update(Goods gg);

    /**
     * 上面的不用
     * 前端方法如下
     */

    //

}
