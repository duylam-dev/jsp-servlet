package com.javaweb.Controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.Model.NewModel;
import com.javaweb.Service.INewService;
import com.javaweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
    @Inject
    private INewService newService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        newModel = newService.save(newModel);
        mapper.writeValue(resp.getOutputStream(), newModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel updateNew = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        updateNew = newService.update(updateNew);
        mapper.writeValue(resp.getOutputStream(), updateNew);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel deleteNew = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        newService.delete(deleteNew.getIds());
        mapper.writeValue(resp.getOutputStream(),"{}");
    }
}
