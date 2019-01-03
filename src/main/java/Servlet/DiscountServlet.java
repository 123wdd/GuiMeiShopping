package Servlet;

import pojo.Discount;
import pojo.page;
import service.impl.DiscountServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",urlPatterns = "/doDis")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入流对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取Service的对象
        DiscountServiceDaoImpl disdao=DiscountServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null&&action.equals("queryDis")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Discount> page=disdao.disPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doDis?action=queryDis");
                request.getRequestDispatcher(path + "/page/showDiscount.jsp").forward(request, response);
            }

        }
        if (action!=null && action.equals("delDis")){
            String id=request.getParameter("id");
            int a=disdao.delDis(id);
            if (a>0){
                //删除成功
                session.setAttribute("true","yes");
                response.sendRedirect(path+"doDis?action=queryDis&pageNumber=1");
            }else {
                //删除失败
                session.setAttribute("false","no");
                response.sendRedirect(path+"doDis?action=queryDis&pageNumber=1");
            }

        }
    }
}
