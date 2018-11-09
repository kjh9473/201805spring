package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//9*9단 custom view
//spring customview를 만들기 위해서는 View interface를 구현할 필요가 있음
public class TimesTablesView implements View{

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("<style type=\"text/css\">");
		pw.println("	td{");
		pw.println("		border : 1px solid;");
		pw.println("	}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table>");
		int tables = (int) model.get("tables");
		for(int i = 1;i < 10 ;i++){
			pw.println("<tr>");
			for (int j = 2; j <= tables; j++) {
				pw.println("	<td>"  + j + "*" + i +"=" + j*i + "</td>" );
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</body>");
		
		pw.flush();
		pw.close();
	}

}
