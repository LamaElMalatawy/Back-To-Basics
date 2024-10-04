package database;

import entities.Book;

import java.sql.*;

public class Database {
    String URL = "jdbc:postgresql://localhost:5433/Library";
    String USER = "postgres";
    String PASS = "postgres";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public Book getBookById(int id) {
        Connection connection = getConnection();
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Book book = new Book();
            if (resultSet.next()) {
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setSummary(resultSet.getString("summary"));
                book.setRating(resultSet.getString("rating"));
            }

            System.out.println(book.toString());
            return book;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting book by id", e);
        }
    }
}
