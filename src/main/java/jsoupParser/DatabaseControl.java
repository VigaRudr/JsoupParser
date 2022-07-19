package jsoupParser;

import java.sql.*;

public class DatabaseControl {
    Database db;
    Connection connection;
    Statement statement;

    DatabaseControl() throws SQLException {
        db = new Database();
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + db.path);
        this.statement = this.connection.createStatement();
    }

    public void send(String url, String keyword, int matches) throws SQLException {
        String query =
                "INSERT INTO " + db.tableName + " (URL, Keyword, KeywordMatches) " +
                "VALUES ('" + url + "', '" + keyword + "', '" + matches + "')";
        this.statement.executeUpdate(query);
    }

    public void updatePath(String path, String url) throws SQLException {
        String query = "UPDATE " + db.tableName +
                " SET SavePath = '" + path +
                "' WHERE URL = '" + url + "' AND SavePath IS NULL";
        this.statement.executeUpdate(query);
    }

    public void delete(String condition) throws SQLException {
        String query = "DELETE FROM "+ db.tableName + " WHERE " + condition;
        this.statement.executeUpdate(query);
    }

    public void clear() throws SQLException {
        String query = "DELETE FROM "+ db.tableName;
        this.statement.executeUpdate(query);
    }

    class Database {
        String tableName = "JsoupParserTable";
        String path = "database\\JsoupParser.db";
    }
}
