package service;

import pojo.Smallclass;
import pojo.page;
import pojo.smallBig;

public interface SmallClassServiceDao {
    page<smallBig> smaPageQueryAll(int pageNumber, int pageSize);

    int delSma(String id);
    Smallclass sm();
}
