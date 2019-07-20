package com.vikram.exceltoDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelToDB
{
	public static void main(String[] args) throws IOException, SQLException 
	{
		ReadingExcelToDB rdedb= new ReadingExcelToDB();
		rdedb.readexcelfile();

	}
	static String [] cellvariable=new String[10];
	public static void readexcelfile() throws IOException, SQLException
	{
		try {
			
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/keysdatabase","root","Vikram#123"); 
				
			FileInputStream file =new FileInputStream("G:\\excel\\NYCKLAR.xlsx");
			Workbook workbook=new XSSFWorkbook(file);
			Sheet sh=workbook.getSheet("sheet1");
			int number_of_rows=sh.getLastRowNum();
			int number_of_cells;
			int number_of_columns=10;
			for(int i=1;i<number_of_rows;i++)
			{
				Row row=sh.getRow(i); 
				for(int j=0;j<number_of_columns;j++)
				{
					Cell cell=row.getCell(j,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
					String cell_value=cell.toString();
					cellvariable[j]=cell_value;
					System.out.println(cell_value);
				}
				Statement st=con.createStatement();
			
				String sqlquery="INSERT INTO keysexcel (district,key_position,adress,adress2,"
						+ "key_type,System_key,Markt,Frasc,keyProfile,ownername) VALUES(?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement pstm=con.prepareStatement(sqlquery);
				pstm.setString(1,cellvariable[0]);
				pstm.setString(2,cellvariable[1]);
				pstm.setString(3,cellvariable[2]);
				pstm.setString(4,cellvariable[3]);
				pstm.setString(5,cellvariable[4]);
				pstm.setString(6,cellvariable[5]);
				pstm.setString(7,cellvariable[6]);
				pstm.setString(8,cellvariable[7]);
				pstm.setString(9,cellvariable[8]);
				pstm.setString(10,cellvariable[9]);
				pstm.execute();				
			}
			//con.commit();
			con.close();
			System.out.println("Data is Populated Sucessfully");
			
		} 
		
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}


}
