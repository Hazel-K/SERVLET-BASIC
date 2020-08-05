package blog.naver.hyojin4588.db;

import java.sql.*;
import java.util.*;

import blog.naver.hyojin4588.vo.BoardVO;

public class BoardDAO {
	
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_board, i_student, title FROM t_board ORDER BY i_board DESC";
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setI_board(rs.getInt("i_board"));
				vo.setI_student(rs.getInt("i_student"));
				vo.setTitle(rs.getNString("title"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		
		return list;
	}
}
