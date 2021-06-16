package TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Villas;

public class Villatest extends Villas{
	@Test
void main() throws InterruptedException, IOException
{
		Villas v= new Villas();
		v.setUp();
		v.openUrl();
		v.selectPage();
		v.selectCity();
		v.dates();
		//v.noOfGuests();
		v.noOfinvalidGuests();
		v.travellingFor();
		v.finalSearch();
		//v.selectfilters();
		//v.selectvillas();
		//v.validatetitle();
		//v.booking();
		//v.slider();
		report.flush();
		}
	}

