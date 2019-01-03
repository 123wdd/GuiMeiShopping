package Servlet;

import pojo.Announcement;
import pojo.page;
import service.impl.AnnouncementServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "AnnouncementServlet",urlPatterns = "/doAnn")
public class AnnouncementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //统一字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入流对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取goodsService的对象
        AnnouncementServiceDaoImpl annDao=AnnouncementServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null && action.equals("queryAnn")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Announcement> page=annDao.annPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doAnn?action=queryAnn");
                request.getRequestDispatcher(path + "/page/showAnnouncement.jsp").forward(request, response);
            }
        }



        /**
         * 删除
         */
        if (action!=null && action.equals("delAnn")){
            String id=request.getParameter("id");
            int a=annDao.delAnn(id);
            if (a>0){
                response.sendRedirect(path+"doAnn?action=queryAnn&pageNumber=1");
            }else {
                out.println("删除失败");
            }
        }

        /**
         * 修改
         */
        if (action!=null && action.equals("upAnn")){
            String id=request.getParameter("id");
            Announcement ann=annDao.queryById(id);
            if (ann!=null){
                session.setAttribute("Ann",ann);
                response.sendRedirect(path+"page/updateAnnouncement.jsp");
            }
        }
        if (action!=null && action.equals("updateAnn")){
            String id=request.getParameter("id");
            String title=request.getParameter("anTitle");
            String date=request.getParameter("anDate");
            String text=request.getParameter("anText");
            if (id!=null && !id.equals("")) {
                long id2=Long.valueOf(id);
                Announcement aa = new Announcement(id2, title, text, Date.valueOf(date));
                int a=annDao.updateByid(aa);
                if (a>0){
                    //修改成功
                    response.sendRedirect(path+"doAnn?action=queryAnn&pageNumber=1");
                }else{
                    out.println("修改失败");
                }
            }

        }
        /**
         * 添加
         */
        if(action!=null&&action.equals("addAnn")){
            String id=request.getParameter("id");
            String title=request.getParameter("title");
            String text=request.getParameter("text");
            String date=request.getParameter("date");
            if (id!=null&&!id.equals("")) {
                long id2=Long.valueOf(id);
                Announcement aa = new Announcement(id2, title, text, Date.valueOf(date));
                int a=annDao.addAnn(aa);
                if (a>0){
                    //添加成功
                    response.sendRedirect(path+"doAnn?action=queryAnn&pageNumber=1");
                }else{
                    out.println("添加失败");
                }
            }
        }

    }
}
