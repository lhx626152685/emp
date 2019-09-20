package com.edu.servlet;

import com.edu.entity.Dept;
import com.edu.entity.Emp;
import com.edu.service.DeptSevice;
import com.edu.service.EmpService;
import com.edu.service.impl.DeptServiceImpl;
import com.edu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/updateempview"})
public class UpdateEmpViewServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    private DeptSevice deptSevice = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取到id
        Integer empId = Integer.parseInt(req.getParameter("id"));
        // 2.根据id查询数据
        Emp emp = empService.getEmpById(empId);
        // 3.绑定到req对象
        req.setAttribute("emp",emp);
        // 再绑定所有部门数据
        List<Dept> deptList = deptSevice.listDept();
        req.setAttribute("deptList",deptList);
        // 4.转发到修改页
        req.getRequestDispatcher("/WEB-INF/pages/updateemp.jsp").forward(req,resp);

    }
}
