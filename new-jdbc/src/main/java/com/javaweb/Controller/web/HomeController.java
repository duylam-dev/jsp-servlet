package com.javaweb.Controller.web;


import com.javaweb.Model.UserModel;
import com.javaweb.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            RequestDispatcher rd = req.getRequestDispatcher("views/login.jsp");
            rd.forward(req,resp);
        }else if(action != null && action.equals("logout")){

        }else{
            RequestDispatcher rd = req.getRequestDispatcher("views/web/home.jsp");
            rd.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            UserModel model = FormUtil.toModel(UserModel.class, req);
            //dang hoo den day...
        }
    }
}
