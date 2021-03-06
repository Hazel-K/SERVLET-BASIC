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

	public BoardWriteSer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/BoardWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_student = request.getParameter("nm");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO param = new BoardVO();
		param.setI_student(Utils.parseStringToInt(strI_student));
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		int result = BoardDAO.insBoard(param);
		
		if (result == 1) {
			response.sendRedirect("/");
			return;
		} else {
			request.setAttribute("msg2", "오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
		
		request.getRequestDispatcher("/WEB-INF/view/BoardWrite.jsp").forward(request, response);
	}

}
