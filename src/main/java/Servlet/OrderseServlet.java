package Servlet;

import pojo.Orderse;
import pojo.page;
import service.impl.OrderServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderseServlet",urlPatterns = "/doOrder")
public class OrderseServlet extends HttpServlet {
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
        OrderServiceDaoImpl orderdao=OrderServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null&&action.equals("queryOrder")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Orderse> page=orderdao.orderPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doOrder?action=queryOrder");
                request.getRequestDispatcher(path + "/page/showOrder.jsp").forward(request, response);
            }

        }
        /**
         * 删除
         */
        if(action!=null && action.equals("delOrder")){
            String id=request.getParameter("id");
            int a=orderdao.delOrder(id);
            if (a>0){
                //删除成功
                session.setAttribute("true","yes");
                response.sendRedirect(path+"doOrder?action=queryOrder&pageNumber=1");
            }else {
                //删除失败
                session.setAttribute("false","no");
                response.sendRedirect(path+"doOrder?action=queryOrder&pageNumber=1");
            }
        }
        /**
         * 修改
         */
        if (action!=null && action.equals("upOrder")){
            String id=request.getParameter("id");

        }
        if (action!=null && action.equals("updateOrder")){

        }
    }
}
