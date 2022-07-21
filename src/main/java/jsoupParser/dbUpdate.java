package jsoupParser;

import java.sql.SQLException;

public class dbUpdate implements Command{
    DatabaseControl databaseControl = new DatabaseControl();
    String tableName;
    String setParameter;
    String condition;

    public dbUpdate(String tableName, String setParameter, String condition) throws SQLException {
        this.tableName = tableName;
        this.setParameter = setParameter;

        if (null != condition)
            this.condition = condition;
    }

    @Override
    public void execute() {
        try {
            databaseControl.update(this.tableName, this.setParameter, this.condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
