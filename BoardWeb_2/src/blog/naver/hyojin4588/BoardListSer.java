package blog.naver.hyojin4588;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/") // 보안상 취약하므로 클래스명과 다르게 이름을 변경해주면 좋음
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListSer() {
        super(); // 직속 부모의 기본 생성자를 호출
    }
    
	// get, post 방식으로 호출할 경우 JSP Container가 자동으로 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 브라우저가 뭔지, 데이터는 뭔지, 유저가 준 정보는 다 들어있음.
		String strI_board = request.getParameter("i_board");
		System.out.println("Servlet i_board : " + strI_board);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/BoardList.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	// get, post 방식으로 호출할 경우 JSP Container가 자동으로 실행
}