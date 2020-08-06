package blog.naver.hyojin4588;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.naver.hyojin4588.db.BoardDAO;
import blog.naver.hyojin4588.vo.BoardVO;

@WebServlet("/") // 주소값 매핑. 'localhost:8089/'로 접속, 보안상 취약하므로 클래스명과 다르게 이름을 변경해주면 좋음
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L; // 세션 구축 시 값이 달라지면 연동이 안될 수 있음
       
    public BoardListSer() {
        super(); // 직속 부모의 기본 생성자를 호출
    }
    
	// get, post 방식으로 호출할 경우 JSP Container가 자동으로 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 브라우저가 뭔지, 데이터는 뭔지, 유저가 준 정보는 다 들어있음.
//		String strI_board = request.getParameter("i_board");
//		System.out.println("Servlet i_board : " + strI_board);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/BoardList.jsp");
		// getRequestDispatcher();와 sendRedirect(); 와의 차이점
		// 1. request, response가 그대로 보존되어 페이지를 실행하는 디스패처와 달리, 리다이렉트는 이동하는 즉시 해당 페이지에서 새롭게 호출된 파라미터를 사용한다.
		// 2. 이동할 때 디스패처는 주소값이 변하지 않지만, 리다이렉트는 변한다.
		// 3. doGet, doPost에서 sendRedirect();를 날리면 무조건 get방식으로 전송된다. 또한 각 디스패처는 jsp외에 servlet을 호출할 수 있다.
		// doGet을 이용해서 WebInfo를 열고, doPost를 이용하여 servlet에 접속하면 파라미터를 노출시키지 않고 웹페이지 접근이 가능하다.
		// 같은 클래스 내의 페이지 이동은 디스패처를 통해 가능. 그 외에는 리다이렉트를 사용
		List<BoardVO> list = BoardDAO.selBoardList(); // static으로 생성된 함수를 호출 가능, import 필요
		request.setAttribute("data", list);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	// get, post 방식으로 호출할 경우 JSP Container가 자동으로 실행, get-post 둘 다 존재할 필요는 없음. 필요한 것만 사용
}