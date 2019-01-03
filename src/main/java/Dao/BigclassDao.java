package Dao;

import pojo.Bigclass;
import pojo.page;

public interface BigclassDao {
    page<Bigclass> bigPageQueryAll(int pageNumber, int pageSize);

    int delBig(String id);
    int updateById(Bigclass big);

    Bigclass queryById(String id);
    int addBig(Bigclass big);
}
