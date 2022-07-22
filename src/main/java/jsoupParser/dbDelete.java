package jsoupParser;

import java.sql.SQLException;

public class dbDelete implements Command{
    DatabaseControl databaseControl = new DatabaseControl();
    String condition;

    public dbDelete(String condition) throws SQLException {
        if (null != condition)
            this.condition = condition;
    }

    @Override
    public void execute() {
        try {
            databaseControl.delete(this.condition);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
