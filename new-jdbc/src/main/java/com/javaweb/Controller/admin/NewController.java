package com.javaweb.Controller.admin;

import com.javaweb.Model.NewModel;
import com.javaweb.Service.INewService;
import com.javaweb.constant.SystemConstant;
import com.javaweb.paging.PageRequest;
import com.javaweb.paging.Pageble;
import com.javaweb.sort.Sorter;
import com.javaweb.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
    @Inject
    private INewService newService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewModel model = FormUtil.toModel(NewModel.class, req);
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                                                new Sorter(model.getSortName(), model.getSortBy()));
        model.setListResult(newService.findAll(pageble));
        model.setTotalItem(newService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        req.setAttribute(SystemConstant.MODEL, model);

        RequestDispatcher rd = req.getRequestDispatcher("views/admin/new/list.jsp");
        rd.forward(req, resp);
    }
}
