package core;

import Dao.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class pageUtil extends BaseDao{
    public  static  int getTotalRecode(String sql,Object[]par) {
        int totalRecode = 0;
        ResultSet rs=getQuery(sql,par);
        try {
            if(rs.next()){
                totalRecode = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return totalRecode;

    }
    public static ResultSet getPageDate(String sql,int pageSize,int pageNumber,Object []parameter){
        int index =  (pageNumber-1)*pageSize;
        sql = sql+" limit "+index+","+pageSize;
        ResultSet rs = getQuery(sql,parameter);
        if (rs!=null) {
            return rs;
        }
        return  null;
    }

}
