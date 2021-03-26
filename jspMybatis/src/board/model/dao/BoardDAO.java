package board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.model.dto.BoardDTO;
import member.model.dto.MemberDTO;
import memo.model.dto.MemoDTO;
import sqlmap.MybatisManager;

public class BoardDAO {
	
	String tableName01 = "board";
	
	public int getTotalRecord(String tbl, String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		map.put("tbl", tbl);
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		map.put("tableName01", tableName01);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("board.getTotalRecord", map);
		return result;
		
	}
	
	public List<BoardDTO> getListAll(int startRecord, int lastRecord, String tbl, String search_option, String search_data){
		Map<String, String> map = new HashMap<>();
		  map.put("startRecord", startRecord + "");
		  map.put("lastRecord", lastRecord + "");
		  map.put("search_option", search_option);
		  map.put("search_data", search_data);
		  map.put("tbl", tbl);
		  map.put("tableName01", tableName01);
		  
		  SqlSession session = MybatisManager.getInstance().openSession();
		  List<BoardDTO> arr = session.selectList("board.getListAll", map);
		  session.close();
		  return arr;
	}
	
	public int getMaxNoticeNo(String tbl) {
		Map<String, String> map = new HashMap<>();
		map.put("tbl", tbl);
		map.put("tableName01", tableName01);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("board.getMaxNoticeNo", map);
		return result;
		
	}
	
	public int getMaxNum() {
						
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("board.getMaxNum", tableName01);
		return result;
		
	}
	
	public int getMaxRefNo() {

		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("board.getMaxRefNo", tableName01);
		return result;
		
	}

	public int setInsert(BoardDTO dto) {
		//System.out.println("dao : " + dto.getSecretGubun());
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("board.setInsert", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
		
	}

	public int setUpdateHit(int no) {
		Map<String, String> map = new HashMap<>();
		String no_ = Integer.toString(no);
		map.put("no", no_);
		map.put("tableName01", tableName01);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("board.setUpdateHit", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
		
	}
	
	public BoardDTO goView(int no) {
		
		Map<String, String> map = new HashMap<>();
		String no_ = Integer.toString(no);
		map.put("no", no_);
		map.put("tableName01", tableName01);
		
		SqlSession session = MybatisManager.getInstance().openSession();
		BoardDTO dto = session.selectOne("board.goView", map);
		session.close();
		return dto;
	}

	public void setUpdateReLevel(BoardDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		session.selectOne("board.setUpdateReLevel", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
	}
	
	public int getUpdate(BoardDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.update("board.getUpdate", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}

	public int getDelete(BoardDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.delete("board.getDelete", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
	
}
