package Servlet;

import pojo.Customer;
import pojo.page;
import service.impl.CustomerServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CustomerServlet",urlPatterns = "/doCus")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
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
        //获取CustomerService的对象
        CustomerServiceDaoImpl cusImpl=CustomerServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        /**
         * 查询顾客
         */
        if(action!=null && action.equals("queryCustomer")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Customer> page = cusImpl.cusPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doCus?action=queryCustomer");
                request.getRequestDispatcher(path + "/page/showCustomer.jsp").forward(request, response);
            }
        }
        /**
         * 删除
         */
        if(action!=null && action.equals("delCus")){
            String cusid=request.getParameter("id");
            int i=cusImpl.delCus(cusid);
            if (i>0){
                //删除成功
                session.setAttribute("true","tr");
                response.sendRedirect(path+"doCus?action=queryCustomer&pageNumber=1");
            }else{
                //删除失败
                session.setAttribute("false","fa");
            }

        }

        /**
         * 修改信息
         */
        if (action!=null && action.equals("upCus")){
            String id=request.getParameter("id");
            Customer s=cusImpl.queryById(id);
            if (s!=null){
                session.setAttribute("cus",s);
                response.sendRedirect(path+"page/updateCusInfo.jsp");
            }
        }
        if (action!=null && action.equals("updateCus")){

            String cusid=request.getParameter("id");
            String name=request.getParameter("cusName");
            String pwd=request.getParameter("cusPwd");
            String email=request.getParameter("cusEmail");
            String car=request.getParameter("cusCarid");
            String sex=request.getParameter("sex");
            String hobby=request.getParameter("cusHobby");
            String birthday=request.getParameter("cusBirthday");
            String cusLogin=request.getParameter("cusLogin");
            Customer c=(Customer) session.getAttribute("cus");
            if ((cusid!=null&&!cusid.equals("")) && (birthday!=null && !birthday.equals(""))) {
                try {
                    java.util.Date  dd=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                    long id2=Long.valueOf(cusid);
                    Customer customer = new Customer(id2, name, cusLogin, pwd, email, sex, c.getCusPhoto(), hobby, car, dd);
                    int a= cusImpl.updateById(customer);
                    if (a>0){
                        //修改成功
                       // session.setAttribute("cusq",customer);
                    // session.setAttribute("cg","tr");
                        response.sendRedirect(path+"doCus?action=queryCustomer&pageNumber=1");
                    }else {
                       // session.setAttribute("sb","fa");
                        out.println("修改失败");

                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

        /**
         * 添加商品到购物车
         */
        if (action!=null && action.equals("addGoodsToShopCar")){

        }
        /**
         * 修改商品到购物车
         */
        if (action!=null && action.equals("updateGoodsToShopCar")){

        }
        /**
         * 删除商品到购物车
         */
        if (action!=null && action.equals("delGoodsToShopCar")){

        }
        /**
         * 查询订单状态
         */
        if (action!=null && action.equals("queryGoodsStatusToShopCar")){

        }

        /**
         * 模糊查询商品信息
         */
        if (action!=null && action.equals("queryGoodsOnLike")){

        }


    }
}
