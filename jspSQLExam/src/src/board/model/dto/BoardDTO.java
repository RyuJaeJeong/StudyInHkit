package src.board.model.dto;

public class BoardDTO {

	//field
	private int no;					//일련번호
	private int num;				//순번
	private String jakseongja;			//작성자
	private String subject;			//제목
	private String content;			//내용
	private String email;			//이메일
	private String passwd;			//비밀번호
	private int ref;				
	private int re_step;
	private int re_level;
	private int hit;				//조회수
	private String wdate;
	private String parentInfo;
	
	/*
	 * 
	 * 
	 * 			ref			re_step 	re_level	parentInfo
	 * 1		 1			   1			1						<--새글의 경우
	 * 2		 2             1			1						<--새글의 경우
	 * 3		 3			   1			1						<--새글의 경우
	 * 4		 4			   1			1  						<--새글의 경우
	 * 5		 5			   1			1			
	 * 11	     1			   2 			2			1/1/1	
	 * 22		 2			   2			2			2/2/2	
	 * 111		 1			   3			5			1/2/2
	 * 111_1	 1			   3		    4			1/2/2
	 * 111_2	 1			   3			3			1/2/2
	 * 1111		 1			   4			7			1/3/5
	 * 1111(1)	 1			   4		    6			1/3/5
	 * 1111_1	 		
	 * ref : 부모글 번호	
	 * re_step : 부모글 re_step + 1
	 * re_level : 부모글 re_level 보다 큰 숫자들은 1씩증가,
	 * 			  부모글 re_level + 1 을 저장 
	 * 
	 * order by ref desc, re_level asc
	 *
	 * 
	 * 사람이 하는 일의 온도 36.5
	 * 
	 * 
	 * */
	
	
	
	public String getParentInfo() {
		return parentInfo;
	}


	public void setParentInfo(String parentInfo) {
		this.parentInfo = parentInfo;
	}


	//cons
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	
	//getter&setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	

	public String getJakseongja() {
		return jakseongja;
	}


	public void setJakseongja(String jakseongja) {
		this.jakseongja = jakseongja;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
	
	
	
}













/*
 * 
 * 
 * 			ref			re_step 	re_level	parentInfo
 * 1		 1			   1			1						<--새글의 경우
 * 11	     1			   2 			2			1/1/1		
 * 111		 1			   3			5			1/2/2
 * 111_1	 1			   3		    4			1/2/2
 * 111_2	 1			   3			3			1/2/2
 * 1111		 1			   4			7			1/3/5
 * 1111(1)	 1			   4		    6			1/3/5
 * 1111_1	 		
 * ref : 부모글 번호	
 * re_step : 부모글 re_step + 1
 * re_level : 부모글 re_level 보다 큰 숫자들은 1씩증가,
 * 			  부모글 re_level + 1 을 저장 
 * 
 * order by ref desc, re_level asc
 * 
 * 
 * */



























