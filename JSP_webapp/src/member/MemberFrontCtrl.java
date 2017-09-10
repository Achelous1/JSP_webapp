package member;

import java.io.IOException;
import com.lonely_traveler.variables.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.sql.SQLException;

import member.command.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.mctrl")
public class MemberFrontCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String img_type = "mem_img";
       
    public MemberFrontCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url 경로 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		//이미지 파일 경로
		String img_path = "C:\\Users\\korea\\Desktop\\JSP_webapp\\JSP_webapp\\WebContent\\public\\FILE_SYSTEM\\MEM_IMG\\";
		
		System.out.println(cmdURI);
		System.out.println(contextPath);
		//회원가입 했을 경우
		if(cmdURI.equals("/signup.mctrl")) {
			String savePath = img_path;
			int maxSize = 10 * 1024 * 1024;
			//multi type form 처리
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			MemberCmd cmd = new MemberSignupCmd();
			
			System.out.println(multi.getParameter("user_id"));
			cmd.execute(multi, response);
			//이미지 파일 업로드
			FileUpload.uploadImage(request, multi, img_path, img_type);

			RequestDispatcher rd = request.getRequestDispatcher("/Main");
			rd.forward(request, response);
		//로그인을 했을 경우
		}else if(cmdURI.equals("/login.mctrl")) {
			MemberCmd cmd = new MemberLoginCmd();
			request.setAttribute("mem_img", "./public/FILE_SYSTEM/MEM_IMG/" + (String)request.getParameter("user_id"));
			cmd.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("public/php/SessionAttributeSet.jsp");
			rd.forward(request, response);
		}else if(cmdURI.equals("/checkId.mctrl")) {
			MemberCmd cmd = new MemberCheckIdCmd();
			cmd.execute(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("public/php/checkId.jsp");
			rd.forward(request, response);
		}
	}

}
