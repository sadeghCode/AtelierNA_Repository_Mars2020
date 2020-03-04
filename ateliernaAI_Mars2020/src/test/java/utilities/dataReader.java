package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
public class dataReader {
 

   public static  String GetValue(String NameParam) throws IOException {
	// try {
		  // Specify the path of file
	   	  boolean ParamFound=false;
	   	  String ParamValue = null;
		  File src=new File("C://Data//TestData.xlsx");
		   // load file
		   FileInputStream fis=new FileInputStream(src);
		 
		   // Load workbook
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		   // Load sheet- Here we are loading first sheetonly
		      XSSFSheet sh1= wb.getSheetAt(0);
		      int Rows=sh1.getLastRowNum();
		      XSSFRow row = sh1.getRow(0);
		      int colNum = row.getLastCellNum();
		      System.out.print("nombre de colonnes"+colNum);
		      String str="";
		      for (int i=0;i<colNum;i++) {
		    	  str=sh1.getRow(0).getCell(i).getStringCellValue();
		    	   //ParamValue=str;
		    	   if ((str!=null) && str.equals(NameParam)){
		    		  ParamFound=true;
		    		  ParamValue=sh1.getRow(1).getCell(i).getStringCellValue(); 
		    		  break;  
		    	   }
		    	  
		       }
			return   ParamValue;
    }
}