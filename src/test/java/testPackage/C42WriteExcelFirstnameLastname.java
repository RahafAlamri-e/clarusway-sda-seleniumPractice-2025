package testPackage;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class C42WriteExcelFirstnameLastname {

    //Create Firstname and Lastname Columns and write names in a new sheet

    @Test
    public void excelTest() throws IOException {

        // Create new workbook
        Workbook workbook = WorkbookFactory.create(true);

        //Create a new sheet
        Sheet sheet = workbook.createSheet("FirstNameLastName");

        //Create Firstname and Lastname Columns
        sheet.createRow(0).createCell(0).setCellValue("FIRST NAME");
        sheet.getRow(0).createCell(1).setCellValue("LAST NAME");

        //Fill some rows
        sheet.createRow(1).createCell(0).setCellValue("rahaf");
        sheet.getRow(1).createCell(1).setCellValue("alamri");

        String[][] employees = {
                {"RAHAF", "ALAMRI"},
                {"roro", "ALamri"},
                {"rere", "alamri"}
        };

        for (String [] employee : employees){
            sheet.createRow(sheet.getLastRowNum()+1).createCell(0).setCellValue(employee[0]);
            sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(employee[1]);
        }

        addNewEmployee(sheet,"alamri", "rahaf");

        FileOutputStream fos = new FileOutputStream(Path.of(".", "resources", "Employees.xlsx").toString());
        workbook.write(fos);
    }

    private void addNewEmployee(Sheet sheet, String name, String lastName) {
        sheet.createRow(sheet.getLastRowNum()+1).createCell(0).setCellValue(name);
        sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(lastName);
    }
}

