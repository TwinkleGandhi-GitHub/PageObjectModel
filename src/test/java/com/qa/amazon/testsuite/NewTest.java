package com.qa.amazon.testsuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amazon.util.TestUtil;

public class NewTest {

	static Workbook book;
	static Sheet sh;

	@DataProvider
	public Object[][] getTestData() {
		FileInputStream fp = null;
		try {
			fp = new FileInputStream(TestUtil.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fp);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = book.getSheet("Sheet1");
		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int k = 0; k < sh.getRow(i).getLastCellNum(); k++) {
				data[i][k] = sh.getRow(i+1).getCell(k).toString();
				
			}
			System.out.println();
		}
		
		return data;

	}
	
	@Test(dataProvider = "getTestData")
	public void runData(String CustomerID, String CustomerName, String Country) {
		System.out.println(CustomerID+"  "+CustomerName+"  "+Country);
	}
}
