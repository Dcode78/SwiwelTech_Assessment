package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {
    public static String readExcel(int row, int col, String fileName, String sheetName) throws Exception{

        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook excelWBook = new XSSFWorkbook(inputStream);
        XSSFSheet excelSheet = excelWBook.getSheet(sheetName);

        return excelSheet.getRow(row).getCell(col).getStringCellValue().toString();

    }
}
