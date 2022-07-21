package jsoupParser;

import java.sql.SQLException;

public class dbRead implements Command{
    DatabaseControl databaseControl = new DatabaseControl();
    String tableName;
    String readParameter;
    String condition;

    public dbRead(String tableName, String readParameter, String condition) throws SQLException {
        this.tableName = tableName;
        this.readParameter = readParameter;

        if (null != condition)
            this.condition = condition;
    }

    @Override
    public void execute() {
        try {
            databaseControl.read(this.tableName, this.readParameter, this.condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
