package Dao;

import pojo.Discount;
import pojo.page;

public interface DiscountDao {
    page<Discount> disPageQueryAll(int pageNumber, int pageSize);
    int delDis(String id);
}
