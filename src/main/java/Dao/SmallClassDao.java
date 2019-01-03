package Dao;

import pojo.Smallclass;
import pojo.page;
import pojo.smallBig;

public interface SmallClassDao {
    page<smallBig> bigPageQueryAll(int pageNumber, int pageSize);
    int delSma(String id);
    Smallclass sm();
}
