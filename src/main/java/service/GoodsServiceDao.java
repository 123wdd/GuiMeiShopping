package service;

import pojo.Goods;
import pojo.goodsSmaSell;
import pojo.page;

public interface GoodsServiceDao {
    page<goodsSmaSell> goodsPageQueryAll(int pageNumber, int pageSize);
    int delGoods(String id);
    int addGoods(Goods gg);

    Goods queryById(String id);
    int update(Goods gg);


}
