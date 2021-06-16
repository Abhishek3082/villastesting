package TestSuite;

import org.testng.annotations.Test;

import pages.MmtOneway;


public class MmtOnewaytest extends MmtOneway{
	@Test
	public void main() throws InterruptedException {
		MmtOneway o=new MmtOneway();
		o.setUp();
		o.openurl();
		o.oneway();
		o.setUp();
		o.openurl();
		o.roundtrip();
		o.setUp();
		o.openurl();
		o.multicity();
		o.setUp();
		o.openurl();
		o.invalidft();
		o.setUp();
		o.openurl();
		o.multione();
		o.openurl();
		o.Trending();
		
	}

}