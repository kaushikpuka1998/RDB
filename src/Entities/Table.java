package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    int autoIncrementedId;
    String name;
    List<Row> rows = new ArrayList<>();
    Map<String,Column> columnMap = new HashMap<>();

    public Table(String name, List<Column> columns) {
        this.autoIncrementedId = 1;
        this.name = name;
        poopulateTheColumn(columns);
    }

    private void poopulateTheColumn(List<Column> columns) {
        for (Column column : columns) {
            columnMap.put(column.getName(), column);
        }
    }

    public void truncateTheTable(){
        this.rows.clear();
    }

    public void insertRows(Map<Column, Object>value){
        for(Column column: value.keySet()){
            if(!checkColumnExists(column.getName())){
                System.out.println("Column does not exists");
                return;
            }
        }
        int rowId = getAutoIncrementedId();
        HashMap<Column,Object> objectHashMap = new HashMap<>(value);
        Row row = new Row(rowId,objectHashMap);
        this.rows.add(row);
    }

    public void deleteRow(int id){
        for(Row row: rows){
            if(row.getId() == id){
                rows.remove(row);
                return;
            }
        }
    }

    public void populateDataByColumnValue(Column column, Object value){
        List<Row> rows  = new ArrayList<>();
        for(Row row: this.rows){
            if(row.getColumnValueMap().get(column).equals(value)){
                rows.add(row);
            }
        }
        System.out.println("Printing matching rows for Table: "+this.name);
        printRecords(rows);
    }

    private boolean checkTableExists(String tableName){
        if(this.name.equals(tableName)){
            return true;
        }
        return false;
    }

    public void printRecords(List<Row> rows){
        System.out.print("\t");
        for(Map.Entry<String,Column> entry : this.columnMap.entrySet()) {
            System.out.print("\t"+entry.getKey()+"\t");
        }
        for(Row row: rows) {
            System.out.print("\n\t"+row.getId()+".");
            for(Map.Entry<Column, Object> entry : row.getColumnValueMap().entrySet()) {
                System.out.print("\t"+entry.getValue()+"\t");
            }
        }
        System.out.print("\n");
    }



    private int getAutoIncrementedId() {
        return this.autoIncrementedId++;
    }

    private boolean checkColumnExists(String ColumnName){
        if(!columnMap.containsKey(ColumnName)){
            return false;
        }
        return true;
    }

    public Map<String, Column> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, Column> columnMap) {
        this.columnMap = columnMap;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAutoIncrementedId(int autoIncrementedId) {
        this.autoIncrementedId = autoIncrementedId;
    }

    public void printAllRows() {
        System.out.println("Printing all rows for Table: "+this.name);
        printRecords(this.rows);
    }
}
