package service;

import pojo.Seller;
import pojo.page;

import java.util.List;

public interface SellerServiceDao {
    page<Seller> sellPageQuery(int pageNumber, int pageSize);
    int delSell(String id);
    int addSell(Seller se);
    int uppdateSell(Seller se);
    Seller queryById(String id);
    List<Seller> queryById();
    Seller seLogin(String sellerUser,String sellerPassword);

}
