package Servlet;

import pojo.Seller;
import pojo.page;
import service.impl.BigclassServiceDaoImpl;
import service.impl.SellerServiceDaoIMpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "SellerServlet",urlPatterns = "/doSell")
public class SellerServlet extends HttpServlet {
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
        //获取Service的对象
        SellerServiceDaoIMpl seldao=SellerServiceDaoIMpl.getInstance();

        String action=request.getParameter("action");
        if (action!=null && action.equals("querySell")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Seller> page = seldao.sellPageQuery(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doSell?action=querySell");
                request.getRequestDispatcher(path + "/page/showSeller.jsp").forward(request, response);
            }

        }
        /**
         * 删除
         */
        if(action!=null&&action.equals("delSeller")){
            String id=request.getParameter("id");
            int a=seldao.delSell(id);
            if (a>0){
                //删除成功
                //session.setAttribute("true","tr");
                response.sendRedirect(path+"doSell?action=querySell&pageNumber=1");
            }else{
                //删除失败
                //session.setAttribute("false","fa");
                out.println("删除失败");
            }
        }
        /**
         * 添加
         */
        if (action!=null && action.equals("addSell")){
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String user=request.getParameter("user");
            String sex=request.getParameter("sex");
            String address=request.getParameter("address");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            String birthday=request.getParameter("birthday");
            String idCard=request.getParameter("idCard");
            String pwd=request.getParameter("pwd");
            if (id!=null && !id.equals("")) {
                long id2=Long.valueOf(id);
                Seller se = new Seller(id2, name, user, pwd, sex, Date.valueOf(birthday), idCard, email, phone, address);
                int a=seldao.addSell(se);
                System.out.println(a+"qwerdf");
                if (a>0){
                    //添加成功
                    response.sendRedirect(path+"doSell?action=querySell&pageNumber=1");
                }else{
                    out.println("添加失败");
                }

            }

        }
        /**
         * 修改
         */
        if (action!=null && action.equals("upSeller")){
            String id=request.getParameter("id");
            Seller ss=seldao.queryById(id);
            session.setAttribute("Seller",ss);
            response.sendRedirect(path+"page/updateSeller.jsp");
        }
        if (action!=null && action.equals("updateSell")){
            Seller ss=(Seller)session.getAttribute("Seller");
            String id=request.getParameter("id");
            String user=request.getParameter("sellUser");
            String sex=request.getParameter("sex");
            String address=request.getParameter("sellAddress");
            String email=request.getParameter("sellEmail");
            String phone=request.getParameter("sellPhone");
            String birthday=request.getParameter("sellBir");
            String idCard=request.getParameter("sellIdCard");
            String pwd=request.getParameter("sellPwd");
            String name=request.getParameter("sellName");
            if (!name.equals(ss.getSellerName())){
                if (id!=null && !id.equals("")) {
                    long id2 = Long.valueOf(id);
                    Seller se = new Seller(id2, name, user, pwd, sex, Date.valueOf(birthday), idCard, email, phone, address);
                    int a = seldao.uppdateSell(se);
                    if (a>0){
                        response.sendRedirect(path+"doSell?action=querySell&pageNumber=1");
                    }
                }
            }else{
                out.println("<script>alert('商家名称不能相同')</script>");
                //response.sendRedirect(path+"doSell?action=querySell&pageNumber=1");
            }

        }
    }
}
