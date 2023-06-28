package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelReadData;

public class DataProviderClass {
	@DataProvider(name="searchCriteria")
	public Object[][] GetSearchData() throws IOException
	{
		ExcelReadData E = new ExcelReadData();
		return E.ExcelRead("MakeMyTripData.xls", "Search");
	}
}
