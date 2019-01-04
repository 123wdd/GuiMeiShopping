package Servlet;

import pojo.Bigclass;
import pojo.page;
import service.impl.BigclassServiceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bigServlet",urlPatterns = "/doBig")
public class bigServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }
    @Override
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
        //获取bigClassService的对象
        BigclassServiceDaoImpl bigDao=BigclassServiceDaoImpl.getInstance();
        String action=request.getParameter("action");
        if (action!=null && action.equals("queryBig")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            String ss = request.getParameter("pageNumber");
            if (ss != null && !ss.equals("")) {
                int pageNumber=Integer.parseInt(ss);
                //调用带有分页的查询业务方法
                page<Bigclass> page = bigDao.bigPageQueryAll(pageNumber,pageSize);
                session.setAttribute("Page", page);
                request.setAttribute("ServletUrl", "/doBig?action=queryBig");
                request.getRequestDispatcher(path + "/page/showBigclass.jsp").forward(request, response);
            }

        }
        /**
         * 删除
         */
        if (action!=null && action.equals("delBig")) {
            String id=request.getParameter("id");
            int a=bigDao.delBig(id);
            if (a>0){
                response.sendRedirect(path+"doBig?action=queryBig&pageNumber=1");
            }else {
                out.println("删除失败");
            }
        }

        /**
         * 修改
         */
        if (action!=null && action.equals("bb")){
            String id=request.getParameter("id");
            Bigclass b=bigDao.queryById(id);
            session.setAttribute("xgBig",b);
            response.sendRedirect(path+"page/updateBigInfo.jsp");

        }
        if (action!=null && action.equals("updateBig")){
                String id=request.getParameter("id");
                String name=request.getParameter("bigName");
                String text=request.getParameter("bigText");
                if (id!=null && !id.equals("")){
                    long id2=Long.valueOf(id);
                    Bigclass bigclass= new Bigclass(id2,name,text);
                    int a=bigDao.updateById(bigclass);
                    if (a>0){
                        //修改成功
                        response.sendRedirect(path+"doBig?action=queryBig&pageNumber=1");
                    }
                }
        }
        /**
         * 添加大分类
         */
        if (action!=null && action.equals("addBig")){
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String text=request.getParameter("text");

            if (id!=null&&!id.equals("") ){
                long id2=Long.valueOf(id);
                Bigclass b=new Bigclass(id2,name,text);
                int a=bigDao.addBig(b);
                if (a>0){
                    //添加成功
                    response.sendRedirect(path+"doBig?action=queryBig&pageNumber=1");
                }else{
                    out.println("添加失败");
                }

            }

        }

        /**
         * 级联查
         */
        if (action!=null && action.equals("queryJlBig")){



        }

    }
}
