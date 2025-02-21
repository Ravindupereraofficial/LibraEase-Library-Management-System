package edu.icet.librarymanagmentsystem.repository.custom.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.BorrowRecords;
import edu.icet.librarymanagmentsystem.dto.Fine;
import edu.icet.librarymanagmentsystem.entity.BookEntity;
import edu.icet.librarymanagmentsystem.entity.BorrowRecordsEntity;
import edu.icet.librarymanagmentsystem.entity.FineEntity;
import edu.icet.librarymanagmentsystem.entity.MemberEntity;
import edu.icet.librarymanagmentsystem.repository.custom.BorrowDao;
import edu.icet.librarymanagmentsystem.service.custome.BorrowService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {

    private static final String SELECT_MEMBER_BY_ID_SQL = "SELECT * FROM librarymembers WHERE MemberID = ?";
    private static final String SELECT_BOOK_BY_ID_SQL = "SELECT * FROM books WHERE BookID = ? AND AvailabilityStatus = 'Available'";


    @Override
    public boolean save(BookEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BookEntity entity) throws SQLException {
        return false;
    }

    @Override
    public BookEntity search(String s) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<BookEntity> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public BookEntity searchBookById(String bookId) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID_SQL)) {

            preparedStatement.setString(1, bookId);
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
    public MemberEntity searchById(String memberId) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBER_BY_ID_SQL)) {

            preparedStatement.setString(1, memberId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new MemberEntity(
                        resultSet.getString("MemberID"),
                        resultSet.getString("Name"),
                        resultSet.getString("ContactInfo"),
                        resultSet.getDate("MembershipDate").toLocalDate()
                );
            }
        }
        return null;
    }

    @Override
    public boolean saveTheRecord(BorrowRecordsEntity borrowRecord, Connection connection) throws SQLException {
        String sql = "INSERT INTO borrowrecords (BorrowID, MemberID, BookID, BorrowDate, ReturnDate, DateGiven, isReturned) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, borrowRecord.getBorrowId());
            pstm.setString(2, borrowRecord.getMemberId());
            pstm.setString(3, borrowRecord.getBookId());
            pstm.setDate(4, Date.valueOf(borrowRecord.getBorrowDate()));
            pstm.setDate(5, Date.valueOf(borrowRecord.getReturnDate()));
            pstm.setDate(6, null); // DateGiven is null
            pstm.setBoolean(7, borrowRecord.isReturned()); // isReturned is false by default

            return pstm.executeUpdate() > 0; // Return true if the record is saved successfully
        }
    }

    @Override
    public String getLastBorrowId(Connection connection) throws SQLException {
        String sql = "SELECT BorrowID FROM borrowrecords ORDER BY BorrowID DESC LIMIT 1";

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet resultSet = pstm.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("BorrowID");
            }
        }
        return null;
    }

    @Override
    public boolean hasUnreturnedBooks(String memberId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM borrowrecords WHERE MemberID = ? AND isReturned = 0";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, memberId);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
        return false;
    }

    @Override
    public List<BorrowRecordsEntity> getBorrowRecordsByMemberId(String memberId) throws SQLException {
        String sql = "SELECT * FROM borrowrecords WHERE MemberID = ? AND isReturned = 0";
        List<BorrowRecordsEntity> borrowRecords = new ArrayList<>();

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, memberId);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                BorrowRecordsEntity borrowRecord = new BorrowRecordsEntity(
                        resultSet.getString("BorrowID"),
                        resultSet.getString("MemberID"),
                        resultSet.getString("BookID"),
                        resultSet.getDate("BorrowDate").toLocalDate(),
                        resultSet.getDate("ReturnDate").toLocalDate(),
                        resultSet.getDate("DateGiven") != null ? resultSet.getDate("DateGiven").toLocalDate() : null,
                        resultSet.getBoolean("isReturned")
                );
                borrowRecords.add(borrowRecord);
            }
        }
        return borrowRecords;
    }

    @Override
    public BorrowRecordsEntity getBorrowRecordByBookId(String selectedBookId) throws SQLException {
        String sql = "SELECT * FROM borrowrecords WHERE BookID = ? AND isReturned = 0";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, selectedBookId);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                return new BorrowRecordsEntity(
                        resultSet.getString("BorrowID"),
                        resultSet.getString("MemberID"),
                        resultSet.getString("BookID"),
                        resultSet.getDate("BorrowDate").toLocalDate(),
                        resultSet.getDate("ReturnDate").toLocalDate(),
                        resultSet.getDate("DateGiven") != null ? resultSet.getDate("DateGiven").toLocalDate() : null,
                        resultSet.getBoolean("isReturned")
                );
            }
        }
        return null; // No borrow record found
    }

    @Override
    public boolean updateBorrowRecordAsReturned(String selectedBookId, LocalDate today, Connection connection) {
        String sql = "UPDATE borrowrecords SET isReturned = 1, DateGiven = ? WHERE BookID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setDate(1, Date.valueOf(today));
            pstm.setString(2, selectedBookId);
            return pstm.executeUpdate() > 0; // Return true if the update is successful
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBorrowIdByBookId(String selectedBookId, Connection connection) throws SQLException {

        String sql = "SELECT BorrowID FROM borrowrecords WHERE BookID = ? AND isReturned = 0";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, selectedBookId);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("BorrowID");
            }
        }
        return null;

    }

    @Override
    public boolean saveFine(FineEntity fine, Connection connection) throws SQLException {
        String sql = "INSERT INTO fines (BorrowID, FineAmount, PaymentDate) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, fine.getBorrowId());
            pstm.setBigDecimal(2, fine.getFineAmount());
            pstm.setDate(3, Date.valueOf(fine.getPaymentDate()));

            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting fine: " + e.getMessage());
            throw e;
        }
    }

}