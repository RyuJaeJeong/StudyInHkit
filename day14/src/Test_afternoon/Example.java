package Test_afternoon;

public class Example {

	public static void main(String[] args) {
		DotPrinter dot = new DotPrinter();
		dot.printer();
		InkjetPrinter ink = new InkjetPrinter();
		ink.printer();
		
		System.out.println("-----------------");
		Printer p = new DotPrinter();
		p.printer();
		p= new InkjetPrinter();
		p.printer();
		
	}

}
