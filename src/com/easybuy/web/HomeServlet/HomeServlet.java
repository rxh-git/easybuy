package com.easybuy.web.HomeServlet;

import com.easybuy.entity.EasyBuyProductCategory;
import com.easybuy.service.product.IProductCategoryService;
import com.easybuy.service.product.impl.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//从service层获取数据
        IProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
        List<EasyBuyProductCategory> categoryList = productCategoryService.queryAllProductCatagory("0");
        //存储数据
        request.setAttribute("categoryList",categoryList);
        //跳转到home.jsp
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
