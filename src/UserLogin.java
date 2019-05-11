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
		response.setCharacterEncoding("UTF-8");//�����ַ�����
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	    out.println("����û�е�¼��ϵͳ����<a href='userDl'>����˴�</a>�����¼ҳ��<br/>");
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
	       response.setCharacterEncoding("UTF-8");//�����ַ�����
	        response.setContentType("text/html");//������Ӧ����
	        PrintWriter out = response.getWriter();
	        HttpSession session=request.getSession();//��ȡsession����
	        /**
	         * ҵ���߼������ж�session����û�е�¼��Ϣ,�������ֱ�ӷ��سɹ�ҳ�棬
	         * ���û�У�������ʾҳ�棬��ʾ�����¼ҳ���¼��
	         */
	        String uName=(String) session.getAttribute("userName");//��session��ȡ���û���
	        if(uName!=null && !uName.equals("")){
	            //����ɹ�ҳ��
	            out.println("<!DOCTYPE html>");
	            out.println("<HTML>");
	            out.println("<HEAD><TITLE>�ɹ�ҳ��</TITLE>" +
	            "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
	             out.println(" <BODY>");
	             out.println("��ӭ��"+uName+"ʹ�ñ�ϵͳ��<a href='userLogout'>��ϲ���¼�ɹ�</a><br/>");
	             out.println("  </BODY>");
	             out.println("</HTML>");
	        }else{
	        	String userName=request.getParameter("userName");

	        	String password=request.getParameter("password");

	        	if(userName.equals("luu") && password.equals("123456")){
	        	    request.getRequestDispatcher("Zq").forward(request, response);//ת�����ɹ�ҳ��
	        	}else{
	        	    response.sendRedirect("Sb");//�������,�ض���ʧ��ҳ��
	        	
	                    session.setAttribute("userName", userName);}//�����û���Ϣ��session��
	                    //����ɹ�ҳ��
	                    out.println("<!DOCTYPE html>");
	                    out.println("<HTML>");
	                    out.println("<HEAD><TITLE>�ɹ�ҳ��</TITLE>" +
	                    "<meta http-equiv='content-type' content='text/html; charset=UTF-8'></HEAD>");
	                     out.println(" <BODY>");
	                     out.println("��ӭ��"+userName+"ʹ�ñ�ϵͳ��<a href='userDl'>ע��</a><br/>");
	                     out.println("  </BODY>");
	                     out.println("</HTML>");
	        	}
	        }
	public void init() throws ServletException {
		// Put your code here
	}

}
