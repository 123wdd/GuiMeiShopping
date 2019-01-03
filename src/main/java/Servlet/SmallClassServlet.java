package Servlet;

import pojo.Smallclass;
import pojo.page;
import pojo.smallBig;
import service.impl.SmallClassServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SmallClassServlet",urlPatterns = "/doSmall")
public class SmallClassServlet extends HttpServlet {
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
        //获取smallClassService的对象
        SmallClassServiceDaoImpl sma=SmallClassServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null && action.equals("querySmall")) {
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber = Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<smallBig> page = sma.smaPageQueryAll(pageNumber, pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doSmall?action=querySmall");
                request.getRequestDispatcher(path + "/page/showSmall.jsp").forward(request, response);
            }

        }

        /**
         * 删除
         */
        if (action!=null && action.equals("delSmall")){
            String id=request.getParameter("id");
            int a=sma.delSma(id);
            if (a>0){
                //删除成功;
                session.setAttribute("true","yes");
                response.sendRedirect(path+"/doSmall?action=querySmall&pageNumber=1");
            }else {
                //删除失败
                session.setAttribute("false","no");

            }

        }
    }
}
