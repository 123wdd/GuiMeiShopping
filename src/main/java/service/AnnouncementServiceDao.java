package service;

import pojo.Announcement;
import pojo.page;

public interface AnnouncementServiceDao {

     page<Announcement> annPageQueryAll( int pageNumber,int  pageSize);
     int addAnn(Announcement ann);
     int delAnn(String id);
     Announcement queryById(String id);
     int updateByid(Announcement ann);
}
