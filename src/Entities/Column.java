package Entities;

public class Column {
    String name;
    ColumnType columnType;

    public Column(String name, ColumnType columnType) {
        this.name = name;
        this.columnType = columnType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public String getName() {
        return name;
    }
}
