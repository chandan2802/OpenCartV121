package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginDatafunc")
	public String[][] getData() throws IOException {
		
		String path=".\\TestData\\automation data driven.xlsx";
		ExcelUtility xutil= new ExcelUtility(path);
		
		int totalRows=xutil.getRowCount("Sheet1");
		int totalColums=xutil.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalRows][totalColums];
		
		for(int i=1;i<totalRows;i++) {
			for(int j=0;j<totalColums;j++) {
				 loginData[i-1][j]=xutil.getCellData("Sheet1", i, j);
			}
			
		}
		return loginData;
	}

}
