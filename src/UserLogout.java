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

		response.setCharacterEncoding("UTF-8");//�����ַ�����
        response.setContentType("text/html");//������Ӧ����
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();//��ȡsession����
        String userName=(String) session.getAttribute("userName");//��ȡsession���û���Ϣ
        if(userName==null || userName.equals("")){//û�е�¼�������ֱ�ӷ���ע������
            //��ʾҳ��
            out.println("<!DOCTYPE html>");
            out.println("<HTML>");
            out.println("<HEAD><TITLE>��ʾҳ��</TITLE>" +
            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
             out.println(" <BODY>");
             out.println("����û�е�¼��ϵͳ����<a href='userDl'>����˴�</a>�����¼ҳ��<br/>");
             out.println("  </BODY>");
             out.println("</HTML>");
        }else{
            session.invalidate();//����session,��session�е�����Ҳ���ᱻ���٣�
            out.println("<!DOCTYPE html>");
            out.println("<HTML>");
            out.println("<HEAD><TITLE>ע��ҳ��</TITLE>" +
            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
             out.println(" <BODY>");
             out.println("ע���ɹ�����<a href='userDl'>����˴�</a>�����¼ҳ��<br/>");
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
