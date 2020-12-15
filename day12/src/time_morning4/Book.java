package time_morning4;

	public class Book {
		
		//Field
		protected String bookName;
		protected String author;
		protected String maker;
		protected int year;
		protected int price;
		
		//cons
		public Book() {
			// TODO Auto-generated constructor stub
		}

		public Book(String bookName, String author, String maker, int year, int price) {
		
			this.bookName = bookName;
			this.author = author;
			this.maker = maker;
			this.year = year;
			this.price = price;
		}
		//method
		
		
		
		
		
		//getter&setter

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getMaker() {
			return maker;
		}

		public void setMaker(String maker) {
			this.maker = maker;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		

	}
