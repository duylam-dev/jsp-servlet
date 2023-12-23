package com.javaweb.Controller.web;


import com.javaweb.Model.UserModel;
import com.javaweb.Service.IUserService;
import com.javaweb.utils.FormUtil;
import com.javaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
    @Inject
    private IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            RequestDispatcher rd = req.getRequestDispatcher("views/login.jsp");
            rd.forward(req,resp);
        }else if(action != null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(req,"USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/trang-chu");
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
            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
            if (model != null){
                SessionUtil.getInstance().putValue(req,"USERMODEL", model);
                if(model.getRole().getCode().equals("USER")){
                    resp.sendRedirect(req.getContextPath() + "/trang-chu");
                }else if(model.getRole().getCode().equals("ADMIN")){
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                }
            }else{
                resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
            }
        }
    }
}
