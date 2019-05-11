import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置字符编码
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	    out.println("您还没有登录本系统，请<a href='userDl'>点击此处</a>进入登录页面<br/>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       response.setCharacterEncoding("UTF-8");//设置字符编码
	        response.setContentType("text/html");//设置响应类型
	        PrintWriter out = response.getWriter();
	        HttpSession session=request.getSession();//获取session对象
	        /**
	         * 业务逻辑：先判断session中有没有登录信息,如果有则直接返回成功页面，
	         * 如果没有，返回提示页面，提示进入登录页面登录。
	         */
	        String uName=(String) session.getAttribute("userName");//从session中取出用户名
	        if(uName!=null && !uName.equals("")){
	            //输出成功页面
	            out.println("<!DOCTYPE html>");
	            out.println("<HTML>");
	            out.println("<HEAD><TITLE>成功页面</TITLE>" +
	            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
	             out.println(" <BODY>");
	             out.println("欢迎："+uName+"使用本系统！<a href='userLogout'>恭喜你登录成功</a><br/>");
	             out.println("  </BODY>");
	             out.println("</HTML>");
	        }else{
	        	String userName=request.getParameter("userName");

	        	String password=request.getParameter("password");

	        	if(userName.equals("luu") && password.equals("123456")){
	        	    request.getRequestDispatcher("Zq").forward(request, response);//转发到成功页面
	        	}else{
	        	    response.sendRedirect("Sb");//密码错误,重定向到失败页面
	        	
	                    session.setAttribute("userName", userName);}//保存用户信息到session中
	                    //输出成功页面
	                    out.println("<!DOCTYPE html>");
	                    out.println("<HTML>");
	                    out.println("<HEAD><TITLE>成功页面</TITLE>" +
	                    "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
	                     out.println(" <BODY>");
	                     out.println("欢迎："+userName+"使用本系统！<a href='userDl'>注销</a><br/>");
	                     out.println("  </BODY>");
	                     out.println("</HTML>");
	        	}
	        }
	public void init() throws ServletException {
		// Put your code here
	}

}
