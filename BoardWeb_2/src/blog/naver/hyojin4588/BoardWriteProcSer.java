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

/**
 * Servlet implementation class BoardWriteProcSer
 */
@WebServlet("/BoardWriteProc")
public class BoardWriteProcSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteProcSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/BoardWriteProc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String strI_student = request.getParameter("nm");
		String ctnt = request.getParameter("ctnt");
		BoardVO param = new BoardVO();
		param.setI_student(Utils.parseStringToInt(strI_student));
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		int result = BoardDAO.insBoard(param);
		request.setAttribute("temp", result);
		
//		doGet(request, response);
	}

}
