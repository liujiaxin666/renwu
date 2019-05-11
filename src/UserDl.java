import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserDl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserDl() {
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
	        response.setContentType("text/html");//设置响应类型
	        HttpSession session=request.getSession();//获取session对象
	        PrintWriter out = response.getWriter();
	        String msg="";//登录失败信息
	        String userName=(String) session.getAttribute("userName");//从session中获取用户名
	        if(userName!=null && !userName.equals("")){//用户已登录
	            //重定向到成功页面
	            response.sendRedirect("userLogoin");
	        }else{
	            msg=(String) session.getAttribute("msg");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		 out.println(" <BODY>");
         out.print("<h3><font color='red'>"+(msg==null?"":msg)+"</font></h3>" +
                 "<form  method='post' action='userLogin'>" +
                 "<label for='textfield'>用户名：</label>" +
                 "<input type='text' name='userName' id='userName' /><br/> " +
                 "<label for='textfield'>密&nbsp;&nbsp;&nbsp;码：</label> " +
                 "<input type='text' name='password' id='password' /><br/>" +
                 "<input type='submit' name='button' id='button' value='提交' />" +
                 "</form>");
         out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	   }
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
