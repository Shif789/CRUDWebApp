package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	PrintWriter printWriter = response.getWriter();
//		printWriter.println("<h1>Request URI: " + request.getRequestURI() + "</h1>");
//		printWriter.println("<h1>Context Path: " + request.getContextPath() + "</h1>");
//		printWriter.println("<h1>Servlet Path: " + request.getServletPath() + "</h1>");
//		printWriter.println("<h1>Path Info: " + request.getPathInfo() + "</h1>");
//		printWriter.println("<h1>QueryString: " + request.getQueryString() + "</h1>");
//		printWriter.println("<h1>IP Address: " + request.getRemoteAddr() + "</h1>");

		IStudentService studentService = StudentServiceFactory.getStudentService();
		if (request.getRequestURI().endsWith("addform")) {
			String sAge = request.getParameter("sage");
			String sName = request.getParameter("sname");
			String sAddress = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(sName);
			student.setSage(Integer.parseInt(sAge));
			student.setSaddress(sAddress);

			String message = studentService.addStudent2(student);
			RequestDispatcher requestDispatcher=null;
			if (message.equals("success")) {
				request.setAttribute("status", "success");
				 requestDispatcher = request.getRequestDispatcher("../insertResult.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				requestDispatcher = request.getRequestDispatcher("../insertResult.jsp");
				requestDispatcher.forward(request, response);
			}
			printWriter.close();
		}

		if (request.getRequestURI().endsWith("searchform")) {
			String sId = request.getParameter("sid");

			
			Student student = studentService.searchStudent(Integer.parseInt(sId));
			request.setAttribute("student", student);
			RequestDispatcher requestDispatcher=null;
			requestDispatcher = request.getRequestDispatcher("../display.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("deleteform")) {
			String sId = request.getParameter("sid");

			String message = studentService.deleteStudent(Integer.parseInt(sId));
			RequestDispatcher requestDispatcher=null;
			if (message.equals("success")) {
				request.setAttribute("status", "success");
				 requestDispatcher = request.getRequestDispatcher("../deleteResult.jsp");
				requestDispatcher.forward(request, response);
			} else if (message.equals("not found")) {
				request.setAttribute("status", "not found");
				requestDispatcher = request.getRequestDispatcher("../deleteResult.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				 requestDispatcher = request.getRequestDispatcher("../deleteResult.jsp");
				 requestDispatcher.forward(request, response);
			}

		}
		
		if (request.getRequestURI().endsWith("editform")) {
			String sId = request.getParameter("sid");

			Student student = studentService.searchStudent(Integer.parseInt(sId));
			RequestDispatcher requestDispatcher = null;

			request.setAttribute("student", student);
			requestDispatcher = request.getRequestDispatcher("../updateForm.jsp");
			requestDispatcher.forward(request, response);

		}
		
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sId = request.getParameter("sid");
			String sAge = request.getParameter("sageUpdated");
			String sName = request.getParameter("snameUpdated");
			String sAddress = request.getParameter("saddressUpdated");
			
//			System.out.println(sId);
//			System.out.println(sName);
//			System.out.println(sAge);
//			System.out.println(sAddress);

			Student student = new Student();
			student.setSid(Integer.parseInt(sId));
			student.setSname(sName);
			student.setSage(Integer.parseInt(sAge));
			student.setSaddress(sAddress);

			String message = studentService.updateStudent2(student);
			RequestDispatcher requestDispatcher=null;
			if (message.equals("success")) {
				 requestDispatcher = request.getRequestDispatcher("../../updateSuccess.html");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("../../updateFailure.html");
				requestDispatcher.forward(request, response);
			}
		}

	}

}
