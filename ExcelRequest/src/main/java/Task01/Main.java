package Task01;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Users users = new Users();
        String filePath = "output.xlsx";
        exportToExcel(filePath, users);
        System.out.println(users.getUsers().size());
    }

    public static void exportToExcel(String path, Users users) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File created");
        } else {
            System.out.println("Already exist");
        }

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(file)) {
            Sheet sheet = workbook.createSheet("Database");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Nickname");
            headerRow.createCell(2).setCellValue("Score");

            Collections.sort(users.getUsers(), Comparator.comparingInt(User::getScore).reversed());

            int rowNum = 1;
            for (User user : users.getUsers()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getUniqueNumber());
                row.createCell(1).setCellValue(user.getNickname());
                row.createCell(2).setCellValue(user.getScore());
            }

            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
