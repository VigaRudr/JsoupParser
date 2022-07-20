package jsoupParser;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseControl {
    Database db = new Database();

    public DatabaseControl() throws SQLException {
    }

    public void send(String url, String keyword, int matches) throws SQLException {
        String query =
                "INSERT INTO " + db.tableName + " (URL, Keyword) " +
                "VALUES ('" + url + "', '" + keyword + "')";
        db.statement.executeUpdate(query);
    }

    public void updatePath(String path, String url) throws SQLException {
        String query = "UPDATE " + db.tableName +
                " SET SavePath = '" + path +
                "' WHERE URL = '" + url + "' AND SavePath IS NULL";
        db.statement.executeUpdate(query);
    }

    public void delete(String condition) throws SQLException {
        String query = "DELETE FROM "+ db.tableName + " WHERE " + condition;
        db.statement.executeUpdate(query);
    }

    public void clear() throws SQLException {
        String query = "DELETE FROM "+ db.tableName;
        db.statement.executeUpdate(query);
    }

    class Database {
        String tableName = "JsoupParserTable";
        String path = "database\\JsoupParser.db";
        Connection connection;
        Statement statement;

        public Database() throws SQLException {
            db = new Database();
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.path);
            this.statement = this.connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+ this.tableName +" ( " +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "    URL VARCHAR(100)," +
                    "    Keyword VARCHAR(50)," +
                    "    SavePath VARCHAR(50))";

            this.statement.execute(query);
        }
    }
}
