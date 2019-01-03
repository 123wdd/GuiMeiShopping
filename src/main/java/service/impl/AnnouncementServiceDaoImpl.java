package service.impl;

import Dao.impl.AnnouncementDaoImpl;
import pojo.Announcement;
import pojo.page;
import service.AnnouncementServiceDao;

public class AnnouncementServiceDaoImpl implements AnnouncementServiceDao{
    private static AnnouncementServiceDaoImpl ourInstance = new AnnouncementServiceDaoImpl();

    public static AnnouncementServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private AnnouncementServiceDaoImpl() {
    }


    private AnnouncementDaoImpl announcementDao=new AnnouncementDaoImpl();
    public page<Announcement> annPageQueryAll(int pageNumber, int pageSize) {
        return announcementDao.annPageQueryAll(pageNumber,pageSize);
    }

    public int addAnn(Announcement ann) {
        return announcementDao.addAnn(ann);
    }

    public int delAnn(String id) {
        return announcementDao.delAnn(id);
    }

    public Announcement queryById(String id) {
        return announcementDao.queryById(id);
    }

    public int updateByid(Announcement ann) {
        return announcementDao.updateByid(ann);
    }
}
