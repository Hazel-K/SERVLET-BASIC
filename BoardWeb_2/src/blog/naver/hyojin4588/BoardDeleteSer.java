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

/**
 * Servlet implementation class BoardDeleteSer
 */
@WebServlet("/BoardDelete")
public class BoardDeleteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strI_board = request.getParameter("i_board");
//		System.out.println(strI_board);
		int i_board = Utils.parseStringToInt(strI_board);
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		int result = BoardDAO.delBoard(param);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/BoardDelete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
