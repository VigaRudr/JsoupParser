package jsoupParser;

import java.sql.SQLException;

public class dbCreate implements Command{
    DatabaseControl databaseControl = new DatabaseControl();
    String columnNames;
    String values;

    public dbCreate(String columnNames, String values) throws SQLException {
        this.columnNames = columnNames;
        this.values = values;
    }

    @Override
    public void execute() {
        try {
            databaseControl.create(this.columnNames, this.values);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
