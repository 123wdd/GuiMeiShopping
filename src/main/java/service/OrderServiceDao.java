package service;

import pojo.Orderse;
import pojo.page;

public interface OrderServiceDao {

    page<Orderse> orderPageQueryAll(int pageNumber, int pageSize);
    int delOrder(String id);
    int updateById(Orderse oo);
    Orderse queryByid(String id);
}
