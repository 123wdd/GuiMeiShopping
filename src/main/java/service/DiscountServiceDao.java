package service;

import pojo.Discount;
import pojo.page;

public interface DiscountServiceDao {
    page<Discount> disPageQueryAll(int pageNumber, int pageSize);
    int delDis(String id);
}
