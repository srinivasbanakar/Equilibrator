package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL
{
	public static String getData(String path,String sheet,int r,int c)
	{
		String v="";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
			System.out.println("Cell Value "+v);
						
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;		
	}
	
	public static int getRowCount(String path,String sheet)
	{
		int rc=-1;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
			System.out.println(rc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
	}
	
	public static int getCellCount(String path,String sheet,int r)
	{
		int cc=-1;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			cc=wb.getSheet(sheet).getRow(r).getLastCellNum();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}
	
	public static void writeData(String path,String sheet,int r,int c,String v)
	{
		try
		{
			
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).createRow(r).createCell(c).setCellValue(v);
			wb.write(new FileOutputStream(path));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
