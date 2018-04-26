package cn.itcast.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//依赖UserService
		UserService userService = new UserService();
	
		
		/*
		 * 封装表单数据到User对象中
		 */
		User form = CommonUtils.toBean(request.getParameterMap(),User.class);
		
		System.out.print(form);
		/*
		 * 调用userService的register方法，传递form过去
		 * 得到异常，获取异常信息保存到request域中，转发到register.jsp中
		 * 没有异常，输出注册成功
		 */
		try {
			userService.register(form);
			response.getWriter().print("<h1>注册成功</h1><a href='"+request.getContextPath()+"/user/login.jsp"+"'>点击这里登录</a>");
		} catch (UserException e) {
			// 获取异常保存到request域中
			request.setAttribute("msg", e.getMessage());
			//转发到register.jsp
			request.getRequestDispatcher("/user/register.jsp");
		}
		
	}

}
