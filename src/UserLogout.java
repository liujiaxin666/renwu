import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogout extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLogout() {
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
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();//获取session对象
        String userName=(String) session.getAttribute("userName");//获取session中用户信息
        if(userName==null || userName.equals("")){//没有登录的情况下直接访问注销链接
            //提示页面
            out.println("<!DOCTYPE html>");
            out.println("<HTML>");
            out.println("<HEAD><TITLE>提示页面</TITLE>" +
            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
             out.println(" <BODY>");
             out.println("您还没有登录本系统，请<a href='userDl'>点击此处</a>进入登录页面<br/>");
             out.println("  </BODY>");
             out.println("</HTML>");
        }else{
            session.invalidate();//销毁session,（session中的数据也将会被销毁）
            out.println("<!DOCTYPE html>");
            out.println("<HTML>");
            out.println("<HEAD><TITLE>注销页面</TITLE>" +
            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
             out.println(" <BODY>");
             out.println("注销成功！请<a href='userDl'>点击此处</a>进入登录页面<br/>");
             out.println("  </BODY>");
             out.println("</HTML>");
        }
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
