package survey.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DbExample;
import survey.model.dto.SurveyAnswerDTO;
import survey.model.dto.SurveyDTO;



public class SurveyDAO__ {
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConn() {
		conn = DbExample.dbConn();
		return conn;
	}
	
	public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		DbExample.dbConnClose(rs, pstmt, conn);
	}
	
	public int setInsert(SurveyDTO dto) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "insert into survey_table values(seq_surveyTable.NEXTVAL,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getAns1());
			pstmt.setString(3, dto.getAns2());
			pstmt.setString(4, dto.getAns3());
			pstmt.setString(5, dto.getAns4());
			pstmt.setString(6, dto.getStatus());
			pstmt.setTimestamp(7, dto.getStart_date());
			pstmt.setTimestamp(8, dto.getLast_date());
			//String 으로 받아서 sql 부분에 to_timestamp(?) 라고 써주는 방법도있다.
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("입력 실패");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public int getTotalRecord(String list_gubun,String search_option, String search_data,String search_data_s, String search_data_e, String search_date_check) {
		conn = getConn();
		int result = 0;
		try {
			
			if(search_data_s.length()>0 && search_data_e.length()>0) {
				search_data_s+="00:00:00.0";
				search_data_e+="23:59:59.999999";
				//java.sql.Timestamp search_data_s = java.sql.Timestamp.valueOf(search_data_s);
				//java.sql.Timestamp search_data_e = java.sql.Timestamp.valueOf(search_data_e);
			}
			
			String sql = "";
			sql += "select count(*) from survey_table where no > ?";
			
			if(list_gubun.equals("all")) {
				
			}else if(list_gubun.equals("ing")) {
			sql += " and start_date<CURRENT_TIMESTAMP and last_date>CURRENT_TIMESTAMP";	
			}else if(list_gubun.equals("end")) {
			sql += " and last_date<CURRENT_TIMESTAMP";	
			}
			
			
			if(search_option.length()>0 && search_data.length()>0) {
				sql += " and " + search_option + " like ? ";
			}
			System.out.println(search_date_check+"제발2");
			if(!search_date_check.equals("")&&search_date_check.length()!=0) {
				if(search_data_s.length()>0 && search_data_e.length()>0) {
					sql += " and (start_date >= to_timestamp(?) and last_date <= to_timestamp(?))";
				}
			}
			
			int k = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++k, 0);
			
			if(search_option.length()>0 && search_data.length()>0) {
				pstmt.setString(++k, "%"+search_data+"%");
			}
			//System.out.println(search_data_s+search_data_e+"11111111111111");
			if(!search_date_check.equals("")&&search_date_check.length()!=0) {
				if(search_data_s.length()>0 && search_data_e.length()>0) {
					pstmt.setString(++k, search_data_s );
					pstmt.setString(++k, search_data_e );
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<SurveyDTO> getList(int startRecord,  int lastRecord, String list_gubun, String search_option, String search_data,String search_data_s_, String search_data_e_, String search_date_check) {
		conn = getConn();
		ArrayList<SurveyDTO> list = new ArrayList<>();
		try {
			java.sql.Timestamp search_data_s = null;
			java.sql.Timestamp search_data_e = null;
			if(search_data_s_.length()>0 && search_data_e_.length()>0) {
				search_data_s_+=" 00:00:00.0";
				search_data_e_+=" 23:59:59.9";
				
				search_data_s = java.sql.Timestamp.valueOf(search_data_s_);
				search_data_e = java.sql.Timestamp.valueOf(search_data_e_);
			
				System.out.println(search_data_s +"f");
				System.out.println(search_data_e + "e");
			}
			
			
			String basicSql = "";  //업무에 가면 *보다는 출력할 필드명을 모두 명시해주는 것이 좋다. 
			basicSql += "select*from survey_table where no>?";
			if(list_gubun.equals("all")) {
				
			}else if(list_gubun.equals("ing")) {
				basicSql += " and start_date<CURRENT_TIMESTAMP and last_date>CURRENT_TIMESTAMP";	
			}else if(list_gubun.equals("end")) {
				basicSql += " and last_date<CURRENT_TIMESTAMP";	
			}
				
			if(search_option.length()>0 && search_data.length()>0) {
				basicSql += " and " + search_option + " like ? ";
			}	
			if(!search_date_check.equals("")&&search_date_check.length()!=0) {
				if(search_data_s_.length()>0 && search_data_e_.length()>0) {
					basicSql += " and (start_date >= ? and last_date <= ?)";
				}
			}
			basicSql+= " order by no desc";
			String sql = "";
			sql += "select*from(select A.*, Rownum Rnum from ("+ basicSql + ")A)";
			sql += "where Rnum>= ? and Rnum <= ?";
			int k = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++k, 0);
			if(search_option.length()>0 && search_data.length()>0) {
				pstmt.setString(++k, "%"+search_data+"%");
			}
			if(!search_date_check.equals("")&&search_date_check.length()!=0) {
				if(search_data_s_.length()>0 && search_data_e_.length()>0) {
					
					pstmt.setTimestamp(++k, search_data_s );
					pstmt.setTimestamp(++k, search_data_e );
				}
				
			}
			pstmt.setInt(++k, startRecord);
			pstmt.setInt(++k, lastRecord);
			
			System.out.println(sql+"2");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				dto.setNo(rs.getInt("no"));
				dto.setQuestion(rs.getString("Question"));
				dto.setAns1(rs.getString("ans1"));
				dto.setAns2(rs.getString("ans2"));
				dto.setAns3(rs.getString("ans3"));
				dto.setAns4(rs.getString("ans4"));
				dto.setStart_date(rs.getTimestamp("start_date"));
				dto.setLast_date(rs.getTimestamp("last_date"));
				dto.setRegi_date(rs.getTimestamp("regi_date"));
				dto.setStatus(rs.getString("status"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public SurveyDTO getSelectOne(int no) {
		conn = getConn();
		SurveyDTO dto = new SurveyDTO();
		try {
			String sql = "select*from survey_table where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setQuestion(rs.getString("Question"));
				dto.setAns1(rs.getString("ans1"));
				dto.setAns2(rs.getString("ans2"));
				dto.setAns3(rs.getString("ans3"));
				dto.setAns4(rs.getString("ans4"));
				dto.setStart_date(rs.getTimestamp("start_date"));
				dto.setLast_date(rs.getTimestamp("last_date"));
				dto.setRegi_date(rs.getTimestamp("regi_date"));
				dto.setStatus(rs.getString("status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return dto;
	}
	
	public int setJosa(SurveyAnswerDTO ansDTO) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "insert into survey_answer values(seq_survey_answer.NEXTVAL,?,?,CURRENT_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ansDTO.getNo());
			pstmt.setInt(2, ansDTO.getAnswer());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("입력 실패");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList getView(int no) {
		conn = getConn();
		ArrayList arr = new ArrayList<>();
		SurveyDTO dto = new SurveyDTO();
		SurveyAnswerDTO ansDTO = new SurveyAnswerDTO();
		try {
			String sql="";
			sql += "select t.no, t.question, t.ans1, t.ans2, t.ans3, t.ans4,t.start_date,t.last_date,t.regi_date, t.status,  a.answer, a.answer_no";
			sql += " from survey_table t inner join survey_answer a";
			sql += " on t.? = a.?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setQuestion(rs.getString("Question"));
				dto.setAns1(rs.getString("ans1"));
				dto.setAns2(rs.getString("ans2"));
				dto.setAns3(rs.getString("ans3"));
				dto.setAns4(rs.getString("ans4"));
				dto.setStart_date(rs.getTimestamp("start_date"));
				dto.setLast_date(rs.getTimestamp("last_date"));
				dto.setRegi_date(rs.getTimestamp("regi_date"));
				dto.setStatus(rs.getString("status"));
				ansDTO.setAnswer(rs.getInt("answer"));
				ansDTO.setAnswer_no(rs.getInt("answer_no"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return arr;
	}
	
	public int setUpdate(SurveyDTO dto) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "";
			sql += "update survey_table set question=?, ans1=?, ans2=?, ans3=?,  status=?, start_date=?, last_date=? where no=? ";
			pstmt = conn.prepareStatement(sql);
			int k =1;
			pstmt.setString(k++, dto.getQuestion());
			pstmt.setString(k++, dto.getAns1());
			pstmt.setString(k++, dto.getAns2());
			pstmt.setString(k++, dto.getAns3());
			pstmt.setString(k++, dto.getStatus());
			pstmt.setTimestamp(k++, dto.getStart_date());
			pstmt.setTimestamp(k++, dto.getLast_date());
			pstmt.setInt(k++, dto.getNo());
			
			result = pstmt.executeUpdate();
			System.out.println("--수정성공--");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int getDelete(int no) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "delete from survey_table where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--삭제 실패--");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		
		return result;
	}
	
}
