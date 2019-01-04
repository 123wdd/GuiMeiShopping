package Servlet;

import pojo.*;
import service.impl.GoodsServiceDaoImpl;
import service.impl.SellerServiceDaoIMpl;
import service.impl.SmallClassServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "goodsServlet",urlPatterns = "/doGoods")
public class goodsServlet extends HttpServlet {
    @Override
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
        GoodsServiceDaoImpl goodsServiceDao=GoodsServiceDaoImpl.getInstance();
        SellerServiceDaoIMpl seldao=SellerServiceDaoIMpl.getInstance();
        SmallClassServiceDaoImpl sma=SmallClassServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null && action.equals("queryGoods")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
               page<goodsSmaSell> page=goodsServiceDao.goodsPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doGoods?action=queryGoods");
                request.getRequestDispatcher(path + "/page/showGoods.jsp").forward(request, response);
        }
        }
        /**
         * 删除
         */
        if (action!=null && action.equals("delGoods")){
            String id=request.getParameter("id");
            int a=goodsServiceDao.delGoods(id);
            if (a>0){
                //删除成功
                request.setAttribute("true","tr");
                response.sendRedirect(path+"doGoods?action=queryGoods&pageNumber=1");
            }else{
                //删除失败
                request.setAttribute("false","fa");
            }

        }
        /**
         * 修改
         */
        if (action!=null && action.equals("upGoods")){
            String id=request.getParameter("id");
            Goods gg=goodsServiceDao.queryById(id);
            session.setAttribute("good",gg);
            response.sendRedirect(path+"page/updateGoods.jsp");

        }
        if (action!=null && action.equals("updateGoods")){
            long id=Long.valueOf(request.getParameter("id"));
            String img=request.getParameter("goodsImg");
            String name=request.getParameter("goodsName");
            long type=Long.valueOf(request.getParameter("goodsType"));
            long dis=Long.valueOf(request.getParameter("goodsDiscId"));
            long smid=Long.valueOf(request.getParameter("goodsSmalId"));
            double money=Double.valueOf(request.getParameter("goodsMoney"));
            long number=Long.valueOf(request.getParameter("goodsNumber"));
            String sellid=request.getParameter("goodsSell");
            double Carriage=Double.valueOf(request.getParameter("goodsCarriage"));
            Goods g=new Goods(id,name,smid,money,number,img,Carriage,type,dis,sellid);
            int a=goodsServiceDao.update(g);
            if (a>0){
                response.sendRedirect(path+"doGoods?action=queryGoods&pageNumber=1");
            }else{
                out.println("修改失败");
            }



        }

        /**
         * 添加
         */


        if (action!=null && action.equals("addGoods")){
            List<Seller> ss=seldao.queryById();
            Smallclass sm=sma.sm();
            session.setAttribute("seller",ss);
            int id = Integer.parseInt(request.getParameter("id"));
            String goodsName = request.getParameter("goodsName");

            double goodsMoney = Double.parseDouble(request.getParameter("goodsMoney"));
            long goodsNumber = Long.parseLong(request.getParameter("goodsNumber"));
            String goodsImage = request.getParameter("goodsImage");
            //System.out.println(goodsImage);
            double goodsCarriage = Double.parseDouble(request.getParameter("goodsCarriage"));
            long goodsType = Long.parseLong(request.getParameter("goodsType"));
            long goodsDiscId = Long.parseLong(request.getParameter("goodsDiscId"));
            String goodsSmalId =request.getParameter("goodsSmalId");
            String goodsSeId =request.getParameter("goodsSeId");
           // System.out.println(ss.getId()+"---"+sm.getId());
                long goodsSmalId2=Long.valueOf(goodsSmalId);
                Goods goods = new Goods(id, goodsName, goodsSmalId2, goodsMoney, goodsNumber, goodsImage, goodsCarriage, goodsType, goodsDiscId, goodsSeId);
                int a = goodsServiceDao.addGoods(goods);
                if (a > 0) {
                    //out.print("<h3>添加成功</h3>");
                    response.sendRedirect(path + "doGoods?action=queryGoods&pageNumber=1");


                } else {
                    out.println("<h3>添加失败</h3>");
                }
            }


//        /**
//         * 修改
//         */
//        if (action!=null && action.equals("upGoods")){
//            String id=request.getParameter("id");
//            Goods goods=goodsServiceDao.queryById(id);
//            session.setAttribute("goods",goods);
//            response.sendRedirect(path+"updateGoods.jsp");
//
//        }
//        if (action!=null && action.equals("updateGoods")){
//            String id=request.getParameter("id");
//            String name=request.getParameter("id");
//            String num=request.getParameter("id");
//            String type=request.getParameter("goodsType");
//            String money=request.getParameter("goodsMoney");
//            String smaId=request.getParameter("goodsSmalId");
//            String sellName=request.getParameter("id");
//            String dis=request.getParameter("goodsDiscId");
//            String img=request.getParameter("goodsImg");
//
//
//        }
    }
}