package com.example.SpringBootAccdb;

import com.healthmarketscience.jackcess.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@SpringBootApplication
public class SpringBootAccdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAccdbApplication.class, args);
	}

	@RequestMapping("/getvalue")
	String getValue() throws IOException {

		// Connection Accdb file
		Database Database = DatabaseBuilder.open(new File("db.mdb"));
		// Connection Database
		Table Table = Database.getTable("krach_t");
		String text = "";

//        select all
		for(Row row : Table) {
			text +="Column 'a' has value: " + row.get("ID") + " "+ row.get("fname") + " " + row.get("lname")+System.lineSeparator() ;
		}
//
//        Insert
//        Table.addRow(Column.AUTO_NUMBER, "1", "2", "3", "4", "5", "6");
//
//        Creating a new Database
//        File file = new File("newdb.mdb");
//        Database db = new DatabaseBuilder(file)
//                .setFileFormat(Database.FileFormat.V2000)
//                .create();
//
//        Creating a Table
//        Table table = new TableBuilder("pp")
//                .addColumn(new ColumnBuilder("ID", DataType.LONG)
//                        .setAutoNumber(true))
//                .addColumn(new ColumnBuilder("Name", DataType.TEXT))
//                .addColumn(new ColumnBuilder("Salary", DataType.MONEY))
//                .addColumn(new ColumnBuilder("StartDate", DataType.SHORT_DATE_TIME))
//                .toTable(db);
//        System.out.println(table);
//
//        Delete on id
//        ArrayList<Integer> enabledComponentsIds = new ArrayList<>();
//        enabledComponentsIds.add(2);
//        enabledComponentsIds.add(3);
//        try (Database db = DatabaseBuilder.open(new File("db.mdb"))) {
//            for (Row r : Table) {
//                if (enabledComponentsIds.contains(r.getInt("ID"))) {
//                    Table.deleteRow(r);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
//
//
		return text;
//	}
	}

}
