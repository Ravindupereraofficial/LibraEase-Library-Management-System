package edu.icet.librarymanagmentsystem.repository.custom.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.entity.BookEntity;
import edu.icet.librarymanagmentsystem.entity.MemberEntity;
import edu.icet.librarymanagmentsystem.repository.custom.BookDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private static final String SELECT_LAST_BOOK_ID_SQL = "SELECT BookID FROM books ORDER BY BookID DESC LIMIT 1";
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO books (BookID, ISBN, Title, Author, CategoryID, AvailabilityStatus) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_BOOK_SQL = "SELECT * FROM books";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE BookID = ?";
    private static final String UPDATE_BOOK_SQL =
            "UPDATE books SET ISBN = ?, Title = ?, Author = ?, CategoryID = ?, AvailabilityStatus = ? WHERE BookID = ?";
    private static final String SELECT_BOOK_BY_ID_SQL = "SELECT * FROM books WHERE BookID = ?";



    @Override
    public boolean save(BookEntity entity) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {

            preparedStatement.setString(1, entity.getBookId());
            preparedStatement.setString(2, entity.getIsbn());
            preparedStatement.setString(3, entity.getBookTitle());
            preparedStatement.setString(4, entity.getAuthor());
            preparedStatement.setInt(5, entity.getCategoryId());
            preparedStatement.setString(6, entity.getAvailabilityStatus());


            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public boolean update(BookEntity entity) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {

            preparedStatement.setString(1, entity.getIsbn());
            preparedStatement.setString(2, entity.getBookTitle());
            preparedStatement.setString(3, entity.getAuthor());
            preparedStatement.setInt(4, entity.getCategoryId());
            preparedStatement.setString(5, entity.getAvailabilityStatus());
            preparedStatement.setString(6, entity.getBookId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }

    }

    @Override
    public BookEntity search(String s) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID_SQL)) {

            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new BookEntity(
                        resultSet.getString("BookID"),
                        resultSet.getString("ISBN"),
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("AvailabilityStatus")
                );
            }
        }
        return null;

    }

    @Override
    public boolean delete(String s) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {

            preparedStatement.setString(1, s);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public List<BookEntity> getAll() throws SQLException {
        List<BookEntity> books = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(new BookEntity(
                        resultSet.getString("BookID"),
                        resultSet.getString("ISBN"),
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("AvailabilityStatus")
                ));
            }
        }
        return books;
    }

    @Override
    public ArrayList<String> getAllCategoryIds() throws SQLException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select CategoryID From categories");
        ArrayList<String> cateids=new ArrayList<>();
        while(rst.next()){
            cateids.add(rst.getString(1));
        }
        return cateids;
    }

    @Override
    public String getLastBookID() {
        String lastMemberID = "B0000";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_BOOK_ID_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                lastMemberID = resultSet.getString("BookID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastMemberID;

    }

    @Override
    public boolean updateAvailabilityStatus(String bookId, String borrowed, Connection connection) throws SQLException {
        String sql = "UPDATE books SET AvailabilityStatus = ? WHERE BookID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, borrowed);
            pstm.setString(2, bookId);

            return pstm.executeUpdate() > 0; // Return true if the update is successful
        }
    }
}
