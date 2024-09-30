package Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    String name;
    Map<String, Table> DBMappedTable= new HashMap<>();;

    public DB(String name) {
        this.name = name;
    }

    public void createTable(String tableName, List<Column> columns){
        if(checkTableExists(tableName)) {
            System.out.println("Table already exists");
            return;
        }
        Table table = new Table(tableName, columns);
        DBMappedTable.put(tableName,table) ;
        return;

    }
    public void dropTable(String tableName){
        if(!checkTableExists(tableName)){
            System.out.println("Table does not exists");
            return;
        }
        DBMappedTable.remove(tableName);
        System.out.println("Table Dropped Successfully");
        return;
    }

    public void truncateTable(String tableName){
        if(!checkTableExists(tableName)){
            System.out.println("Table does not exists");
            return;
        }
        Table table = DBMappedTable.get(tableName);
        table.truncateTheTable();
        System.out.println("Table Truncated Successfully");
        return;
    }

    public void insertTableRows(String tableName, Map<Column, Object> value){
        if(!checkTableExists(tableName)){
            System.out.println("Table does not exists");
            return;
        }
        Table table = DBMappedTable.get(tableName);
        table.insertRows(value);
        System.out.println("Row Inserted Successfully");
        return;
    }

    public void printAllRows(String tableName){
        if(!checkTableExists(tableName)){
            System.out.println("Table does not exists");
            return;
        }
        Table table = DBMappedTable.get(tableName);
        table.printAllRows();
    }

    public void populateDataByColumnValue(String TableName, Column column, Object value){
        if(!checkTableExists(TableName)){
            System.out.println("Table does not exists");
            return;
        }
        Table table = DBMappedTable.get(TableName);
        table.populateDataByColumnValue(column,value);
    }

    private boolean checkTableExists(String tableName) {
         if(DBMappedTable.containsKey(tableName)){
            return true;
         }
         else{
             return false;
         }
    }
}
