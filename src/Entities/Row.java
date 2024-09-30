package Entities;

import java.util.Map;

public class Row {
    int id;
    Map<Column, Object> columnValueMap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Column, Object> getColumnValueMap() {
        return columnValueMap;
    }

    public void setColumnValueMap(Map<Column, Object> columnValueMap) {
        this.columnValueMap = columnValueMap;
    }

    public Row(int id, Map<Column, Object> columnValueMap) {
        this.id = id;
        this.columnValueMap = columnValueMap;
    }
}
