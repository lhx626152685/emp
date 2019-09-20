package com.edu.servlet;

import com.edu.entity.Emp;
import com.edu.service.EmpService;
import com.edu.service.impl.EmpServiceImpl;
import org.apache.ibatis.annotations.Param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/addemp"})
public class AddEmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
        Integer deptId = Integer.parseInt(req.getParameter("deptId"));
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(salary);

        Emp param = new Emp();
        param.setName(name);
        param.setAge(age);
        param.setSex(sex);
        param.setSalary(salary);
        param.setDeptId(deptId);

        System.out.println(req.getParameter("deptId"));

        empService.saveEmp(param);

        //跳转页面到员工列表页
//        req.getRequestDispatcher("emplist").forward(req,resp);
        resp.sendRedirect("emplist");
    }
}
