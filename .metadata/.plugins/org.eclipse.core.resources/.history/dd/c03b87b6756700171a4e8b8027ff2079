import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

class BuildExcel {
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private String excelFilePath = "";
	int rowCount = 0;
	// Constructor
	BuildExcel(String excelFilePath){
		// Create excel workbook and sheet
		 workbook = new XSSFWorkbook();
		 sheet = workbook.createSheet("Moody_1980");
		 this.excelFilePath = excelFilePath;
		 addColumnNames();
	}
	// Add Row data
	public void addRow(Data data){
		 
		 Row row = sheet.createRow(rowCount++);
		 row.setHeightInPoints((5*sheet.getDefaultRowHeightInPoints()));
	     addCells(data, row);
	        
	}
	// Add cells for each column
	
	public void addCells(Data data, Row row){
		// Add Date
		Cell cell = row.createCell(1);
	    cell.setCellValue(data.date);
	    // Add Time
	    cell = row.createCell(2);
	    cell.setCellValue(data.time);
	    // Add Sale
	    cell = row.createCell(3);
	    cell.setCellValue(data.sale);
	    // Add Rating
	    cell = row.createCell(4);
	    cell.setCellValue(data.rating);
	    // Add Amount
	    cell = row.createCell(5);
	    cell.setCellValue(data.amount);
	    // Add issue
	    cell = row.createCell(6);
	    CellStyle cs = workbook.createCellStyle();
	    cs.setWrapText(true);
	    cell.setCellStyle(cs);
	    cell.setCellValue(data.issue);
	    // Add population
	    cell = row.createCell(7);
	    cell.setCellStyle(cs);
	    cell.setCellValue(data.pop);
	    // Add net
	    cell = row.createCell(8);
	    cell.setCellValue(data.net);
	    // Add comment
	    cell = row.createCell(9);
	    cell.setCellValue(data.comment);
	    	
	}
	
	public void addColumnNames(){
		Data colData = new Data();
		colData.date = "Date";
		colData.time = "Time";
		colData.sale = "Sale";
		colData.rating = "Rating";
		colData.amount = "Amount";
		colData.issue = "Issue: (Country) State";
		colData.pop = "Population: Assesses Valuation";
		colData.net = "Net Direct & Overall Debt";
		colData.comment= "Comment";
		
		addRow(colData);
	}
	
	public void generateOutput(){
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
            workbook.close();
        }
     catch(IOException e){
    	 e.printStackTrace();
     }
	}
	
	
	
}
