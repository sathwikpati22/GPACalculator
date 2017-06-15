package org.uc.sathwik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String testCases = request.getParameter("ntestCases");
		String inputs = request.getParameter("ntestCases");
		PrintWriter out = response.getWriter();
		out.println("Hello  from Get Method" );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
		String grade1 = request.getParameter("grade1");
		String grade2 = request.getParameter("grade2");
		String grade3 = request.getParameter("grade3");
		String grade4 = request.getParameter("grade4");		
		String grade5 = request.getParameter("grade5");
//		request.setAttribute("grade5", "4");
		PrintWriter out = response.getWriter();
		double grade = 0;
		Integer credits = 0;
		if ( grade1 != null && grade1 != "" ){
			Integer lcrd = Integer.parseInt(request.getParameter("credit1"));
			credits = credits + lcrd;
			grade = grade + GPA(grade1);
		}
		if ( grade2 != null && grade2 != "" ){
			Integer lcrd = Integer.parseInt(request.getParameter("credit2"));			
			grade = (grade*credits + lcrd*GPA(grade2))/(credits+lcrd);
			credits = credits + lcrd;
		}
		if ( grade3 != null && grade3 != "" ){
			Integer lcrd = Integer.parseInt(request.getParameter("credit3"));			
			grade = (grade*credits + lcrd*GPA(grade3))/(credits+lcrd);
			credits = credits + lcrd;
		}
		if ( grade4 != null && grade4 != "" ){
			Integer lcrd = Integer.parseInt(request.getParameter("credit4"));			
			grade = (grade*credits + lcrd*GPA(grade4))/(credits+lcrd);
			credits = credits + lcrd;
		}
		if ( grade5 != null && grade5 != "" ){
			Integer lcrd = Integer.parseInt(request.getParameter("credit5"));			
			grade = (grade*credits + lcrd*GPA(grade5))/(credits+lcrd);
			credits = credits + lcrd;
		}
		out.println("<html><head><style>table, th, td{ border: 1px solid black; border-collapse: collapse;padding:5px;}</style></head>");
		out.println("<body style='font-family:verdana;color:black;background-position:left;' background='1.jpg'><center>");
		out.println("<br><br><br>");
		out.println("<b>Your final GPA is :<input type='text' value='"+grade+"'></b>");
		out.println("<br><table style='width:20%'><caption>Grading Scales</caption><br><br><tr><th>Grade</th><th>Quality Points</th></tr>");
		out.println("<tr><td>A</td><td>4.0000</td><tr><td>A-</td><td>3.6667</td><tr><td>B+</td><td>3.3333</td><tr><td>B</td><td>3.0000</td><tr><td>B-</td><td>2.6667</td>");
		out.println("<tr><td>C+</td><td>2.3333</td><tr><td>C</td><td>2.0000</td><tr><td>C-</td><td>1.6667</td><tr><td>D+</td><td>1.3333</td><tr><td>D</td><td>1.0000</td><tr><td>D-</td><td>0.6667</td></table>");
		out.println("<br><br><a href='index.html'>HomePage</a>");
		out.println("</body></html>");
	}
	
	public double GPA(String grade){
		double rgrade = 0;
		if ( grade != "" && grade != null){
			if ( grade.contains("A") || grade.contains("a") ){
				if (grade.contains("-")){
					rgrade = 3.6667;
				} else {
					rgrade = 4;
				}				
			}				
			else if ( grade.contains("B") || grade.contains("b") ){
				if (grade.contains("-")){
					rgrade = 2.6667;
				} else if (grade.contains("+")){
					rgrade = 3.3333;
				} else {
					rgrade = 3;
				}
			}				
			else if ( grade.contains("C") || grade.contains("c") ){
				if (grade.contains("-")){
					rgrade = 1.6667;
				} else if (grade.contains("+")){
					rgrade = 2.3333;
				} else {
					rgrade = 2;
				}
			}				
			else if ( grade.contains("D") || grade.contains("d") ){
				if (grade.contains("-")){
					rgrade = 0.6667;
				} else if (grade.contains("+")){
					rgrade = 1.3333;
				} else {
					rgrade = 1;
				}
			}				
			else {
				rgrade = 0;
			}
		}
		return rgrade;
	}
}
