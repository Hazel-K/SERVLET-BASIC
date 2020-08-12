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

@WebServlet("/BoardMod")
public class BoardModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardModSer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board);
		
		if (i_board == 0) {
			response.sendRedirect("/");
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		request.setAttribute("vo2", BoardDAO.selBoard(param));
		
		String jsp = "/WEB-INF/view/BoardRegmod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		int result = BoardDAO.updBoard(param);
		
		if (result == 1) {
			response.sendRedirect("/BoardDetail?i_board=" + i_board);
			return;
		} else {
			request.setAttribute("msg2", "오류가 발생했습니다. 관리자에게 문의해주세요.");
		}
		
		String jsp = "/WEB-INF/view/BoardRegmod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
