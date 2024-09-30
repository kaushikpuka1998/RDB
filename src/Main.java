import Entities.Column;
import Entities.ColumnType;
import Entities.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String tableName = "Employee";
        Column name = new Column("name", ColumnType.STRING);
        Column age = new Column("age", ColumnType.INT);
        Column salary = new Column("salary", ColumnType.INT);
        DB db = new DB("MyDB");
        List<Column> columns = new ArrayList();
        columns.add(name);
        columns.add(age);
        columns.add(salary);
        db.createTable("Employee",columns);
        Map<Column,Object> columnValues = new HashMap();
        columnValues.put(name, "John");
        columnValues.put(age, 25);
        columnValues.put(salary, 10000);

        db.insertTableRows(tableName,columnValues);
        columnValues.clear();
        columnValues.put(name, "Kim");
        columnValues.put(age, 28);
        columnValues.put(salary, 12000);
        db.insertTableRows(tableName,columnValues);
        db.printAllRows(tableName);
        db.populateDataByColumnValue(tableName, age, 28);

        db.populateDataByColumnValue(tableName, name, "John");
        db.truncateTable(tableName);
        db.dropTable(tableName);
        db.printAllRows(tableName);
    }
}