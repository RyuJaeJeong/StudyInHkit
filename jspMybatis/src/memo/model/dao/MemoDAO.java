package memo.model.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.session.SqlSession;

import member.model.dto.MemberDTO;
import memo.model.dto.MemoDTO;
import sqlmap.MybatisManager;


public class MemoDAO {

	
	
	public int setInsert(MemoDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("memo.setInsert", map);

		session.commit();
		session.close();
		return result;
		
		
		
	}
	
	public List<MemoDTO> getListAll(int startRecord,  int lastRecord) {
		Map<String, String> map = new HashMap<>();
		  map.put("startRecord", startRecord + "");
		  map.put("lastRecord", lastRecord + "");
		  
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<MemoDTO> arr = session.selectList("memo.getListAll", map); //리스트로 반환한다.
		session.close();
		return arr;
	}
	
	public MemoDTO goView(int id) {
		SqlSession session = MybatisManager.getInstance().openSession();
		MemoDTO dto = session.selectOne("memo.goView", id);
		session.commit();
		session.close();
		return dto;
	}
	
	
	public int getTotalRecord() {
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.selectOne("memo.getTotalRecord");
		session.close();
		return result;
		
	}
	
	public int getDelete(String[] array) {
		SqlSession session = MybatisManager.getInstance().openSession();
		int result=0;
		
		for (int i = 0; i < array.length; i++) {
			String id_ = array[i];
			int id = Integer.parseInt(id_);
			result = session.delete("memo.getDelete", id);
			
		}
		
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
	public int getUpdate(MemoDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.update("memo.getUpdate", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
}
