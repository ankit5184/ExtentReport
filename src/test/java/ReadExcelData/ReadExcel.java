package ReadExcelData;

import org.apache.poi.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static void main(String[] args) throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig excel = new ExcelDataConfig(excelSheetPath+"//TestData//TestExceldata.xls");
        System.out.println(excel.getData(0, 0, 0));
    }
}