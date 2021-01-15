package memo.model.dto;

public class MemoDTO {
	//field
		int no;
		String writer;
		String content;
		String wdate;
		public MemoDTO() {
			// TODO Auto-generated constructor stub
		}
		
		
		//gs
		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}


		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}


		public String getWdate() {
			return wdate;
		}


		public void setWdate(String wdate) {
			this.wdate = wdate;
		}
		
		
}
