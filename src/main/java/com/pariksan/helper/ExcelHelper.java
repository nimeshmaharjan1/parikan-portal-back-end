package com.pariksan.helper;

import com.pariksan.model.exam.Question;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    //TO CHECK IF THE FILE IS AN EXCEL FILE
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        assert contentType != null;
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
    //CONVERTS EXCEL TO LIST OF QUESTIONS
    public static List<Question> convertExcelToListOfQuestions(InputStream is) {
        List<Question> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while(iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();

                int cellId = 0;

                Question question = new Question();

                while(cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cellId) {
                        case 0 -> question.setQuestionId((long) cell.getNumericCellValue());
                        case 1 -> question.setContent(cell.getStringCellValue());
                        case 2 -> question.setOption1(cell.getStringCellValue());
                        case 3 -> question.setOption2(cell.getStringCellValue());
                        case 4 -> question.setOption3(cell.getStringCellValue());
                        case 5 -> question.setOption4(cell.getStringCellValue());
                        case 6 -> question.setAnswer(cell.getStringCellValue());
                        case 7 -> question.setDifficultyLevel((int) cell.getNumericCellValue());
                        default -> {
                        }
                    }
                    cellId++;
                }
                list.add(question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
