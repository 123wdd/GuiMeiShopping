package Servlet;

import pojo.Customer;
import pojo.Superuser;
import pojo.page;
import service.impl.SuperServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SuperServlet",urlPatterns = "/doSup")
public class SuperServlet extends HttpServlet {
    String id;
    String name;
    String sex;
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
        //获取SuperService的对象
        SuperServiceDaoImpl supdao=SuperServiceDaoImpl.getInstance();
        //获取状态值
        String action=request.getParameter("action");
        /**
         * 登录
         */

        if (action!=null&&action.equals("beforeLogin")){
            String name = request.getParameter("userName");
            String pwd = request.getParameter("userPassword");
            Superuser sup = supdao.Login(name,pwd);
            session.setAttribute("loginSup",sup);
            if (sup!=null){
                out.print("1");
            }else{
                out.print("2");
            }
        }
        //

        if(action!=null && action.equals("supLogin")){
            String name=request.getParameter("userName");
            String pwd=request.getParameter("userPassword");
            Superuser sup=supdao.Login(name,pwd);
            if(sup!=null){
                session.setAttribute("Super",sup);
                response.sendRedirect(path+"/page/index.jsp");
            }else{
                request.setAttribute("false","sb");
                response.sendRedirect(path+"/Login.html");
            }
        }
        /**
         * 修改自己信息
         */
        if (action!=null && action.equals("UpdateSelf")){
            //接受管理员信息
            String id=request.getParameter("id");
            String loginName=request.getParameter("userLoginName");
            String pwd=request.getParameter("userPwd");
            String name=request.getParameter("userName");
            Superuser su=(Superuser) session.getAttribute("Super");
            String status=request.getParameter("userStatus");
            String userid=request.getParameter("userId");
            if (id!=null &&status!=null) {
                int id2 = Integer.parseInt(id);
                int  status2 = Integer.parseInt(status);
                Superuser sup = new Superuser(id2, name, pwd, su.getUserImage(), status2, userid, loginName);
                int a = supdao.supUpdateSelf(sup);
                if (a > 0) {
                    //ok
                    session.setAttribute("Super", sup);
                    out.println("<h1>修改成功</h1>");
                 // response.sendRedirect(path + "/page/index.jsp");
                } else {
                    out.print("修改失败");
                }
            }

        }
        /**
         * 级联查询顾客信息
         */
        if (action!=null && action.equals("jlQuery")) {
                 //定义每页显示的条数
                int pageSize = 5;
                //接收要查看的页码
                 String ss = request.getParameter("pageNumber");
                int pageNumber = Integer.parseInt(ss);
                   id = request.getParameter("cusId");
                   name = request.getParameter("cusLogin");
                   sex = request.getParameter("cusSex");

                //调用带有分页的查询业务方法
                    page<Customer> page = supdao.cusQuerylike(pageNumber, pageSize,id,name,sex);
                    session.setAttribute("Page", page);
                    request.setAttribute("ServletUrl", "doSup?action=jlQuery");
                    request.getRequestDispatcher(path + "/page/showCustomer.jsp").forward(request, response);


        }
    }
}
