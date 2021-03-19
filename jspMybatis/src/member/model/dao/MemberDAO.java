package member.model.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import member.model.dto.MemberDTO;
import sqlmap.MybatisManager;


public class MemberDAO {
	
	String table_1 = "member";
	
	public int setInsert(MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("member.setInsert", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
	public MemberDTO getLogin(MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		MemberDTO resultdto = session.selectOne("member.getLogin", map);
		session.close();
		return resultdto;
	}
	
	public List<MemberDTO> getListAll(int startRecord, int lastRecord, String search_option, String search_data) {
		
		Map<String, String> map = new HashMap<>();
		  map.put("startRecord", startRecord + "");
		  map.put("lastRecord", lastRecord + "");
		  map.put("search_option", search_option);
		  map.put("search_data", search_data);
		  map.put("table_1", table_1);
		  
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<MemberDTO> arr = session.selectList("member.getListAll", map); //리스트로 반환한다.
		session.close();
		return arr;
	}
	
	
	
	public MemberDTO goView(int no) {
		
		SqlSession session = MybatisManager.getInstance().openSession();
		MemberDTO dto = session.selectOne("member.goView", no);
		session.close();
		return dto;
	}
	
	public int getUpdate(MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.update("member.getUpdate", map);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
	public int getDelete(int no) {
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.delete("member.getDelete", no);
		session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
		session.close();
		return result;
	}
	
	public int idCheck(String id) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		int result = session.selectOne("member.idCheck", id); //리스트로 반환한다.
		session.close();
		return result;
		
	}
	
	
	
	

	
	
	public String spCharacter(String something) {
		
		
		something = something.replace("<", "&lt;");	//특수문자 치환 처리.!
		something = something.replace(">", "&gt;");
		something = something.replace("&", "&amp;");
		something = something.replace("\"", "&quot;");
		something = something.replace("'", "&apos;");
		
		
		
		return something;
		
		
		
	}
	
	

	public int getTotalRecord(String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		  map.put("search_option", search_option);
		  map.put("search_data", search_data);
		  map.put("table_1", table_1);
		  
		SqlSession session = MybatisManager.getInstance().openSession();
		
		int result = session.selectOne("member.getTotalRecord", map);
		session.close();
		return result;
	}
	
	
	
	
}
