package blog.naver.hyojin4588;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.naver.hyojin4588.common.Utils;
import blog.naver.hyojin4588.db.BoardDAO;
import blog.naver.hyojin4588.vo.BoardVO;

@WebServlet("/BoardWrite")
public class BoardWriteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteSer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board);
		BoardVO vo1 = null;
		if (i_board != 0) {
			vo1 = new BoardVO();
			vo1.setI_board(i_board);
			BoardVO vo2 = BoardDAO.selBoard(vo1);
			request.setAttribute("vo2", vo2);
		}
		request.setAttribute("msg", i_board == 0 ? "등록하기" : "수정하기");
		request.getRequestDispatcher("/WEB-INF/view/BoardWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board);
		String title = request.getParameter("title");
		String strI_student = request.getParameter("nm");
		String ctnt = request.getParameter("ctnt");
		BoardVO param = new BoardVO();
		param.setI_student(Utils.parseStringToInt(strI_student));
		param.setTitle(title);
		param.setCtnt(ctnt);

		int result = BoardDAO.insBoard(param);

		if (result == 1) {
			response.sendRedirect("/BoardList");
		} else {
			request.setAttribute("msg2", "에러가 발생하였습니다.");
		}

	}

}
