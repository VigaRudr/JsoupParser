package jsoupParser;

import java.sql.SQLException;

public class dbDelete implements Command{
    DatabaseControl databaseControl = new DatabaseControl();
    String tableName;
    String condition;

    public dbDelete(String tableName, String condition) throws SQLException {
        this.tableName = tableName;

        if (null != condition)
            this.condition = condition;
    }

    @Override
    public void execute() {
        try {
            databaseControl.delete(this.tableName, this.condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
