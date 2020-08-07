package blog.naver.hyojin4588;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.naver.hyojin4588.common.Utils;
import blog.naver.hyojin4588.db.BoardDAO;
import blog.naver.hyojin4588.vo.BoardVO;

@WebServlet("/BoardDetail") // 주소값 매핑
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardDetailSer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board, 0);
		if (i_board == 0) {
			response.sendRedirect("/");
			return; // 리턴 필수, 안하면 doGet() 메소드 끝까지 실행함
		}
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		BoardVO data = BoardDAO.selBoard(param);
		request.setAttribute("data", data);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/BoardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
