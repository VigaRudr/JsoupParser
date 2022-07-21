package jsoupParser;

import java.io.File;
import java.sql.*;

public class DatabaseControl {
    Database db = new Database();

    public DatabaseControl() throws SQLException {
    }

    public void read(String readParameter, String tableName, String condition) throws SQLException {
        String query = "SELECT " + readParameter + " FROM " + tableName;
        if (null != condition) {
            query += " WHERE " + condition;
        }
        db.statement.executeQuery(query);
    }

    public void update(String tableName, String setParameter, String condition) throws SQLException {
        String query = "UPDATE " + tableName + " SET " + setParameter + " WHERE " + condition;
        db.statement.executeUpdate(query);
    }

    public void delete(String tableName, String condition) throws SQLException {
        String query = "DELETE FROM " + tableName;
        if (null != condition)
            query += " WHERE " + condition;
        int recordsNum = db.statement.executeUpdate(query);
        db.recordCount -= recordsNum;
    }

    public void insert(String tableName, String columnNames, String values) throws SQLException{
        String query = "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + values + ")";
        db.statement.executeUpdate(query);
        db.recordCount++;
    }


    static class Database {
        String tableName = "JsoupParserTable";
        String path = "database\\JsoupParser.db";
        Connection connection;
        Statement statement;
        File folder = new File("database");
        int recordCount;

        public Database() throws SQLException {
            if (!folder.exists())
                folder.mkdir();

            this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.path);
            this.statement = this.connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+ this.tableName +" ( " +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "    URL VARCHAR(100)," +
                    "    Keyword VARCHAR(50)," +
                    "    SavePath VARCHAR(50))";

            this.statement.execute(query);

            ResultSet res = this.statement.executeQuery("SELECT * FROM " + this.tableName);
            while (res.next())
                recordCount++;
        }
    }
}
