package edu.icet.librarymanagmentsystem.controller.reports;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;

public class ReoprtsFormController {
    public void btnActiveBorrowersReportOnAction(ActionEvent actionEvent)  {
        try {
            String reportPath = "/reports/Active_Borrowers.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void btnAllBooksReportOnAction(ActionEvent actionEvent) {
        try {
            String reportPath = "/reports/AllBooks.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
            // Show an error message to the user
        }
    }

    public void btnAllBorrowedBookReportOnAction(ActionEvent actionEvent)  {
        try {
            String reportPath = "/reports/allborrowedbook.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
            // Show an error message to the user
        }
    }

    public void btnBookAvailabilityOnAction(ActionEvent actionEvent){
        try {
            String reportPath = "/reports/AllBooks.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
            // Show an error message to the user
        }
    }

    public void btnAllCustomerReortOnAction(ActionEvent actionEvent){
        try {
            String reportPath = "/reports/Customer_Report.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
            // Show an error message to the user
        }
    }

    public void btnFineCollectionOnAction(ActionEvent actionEvent) {
        try {
            String reportPath = "/reports/Fine_Collection_Report.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
            // Show an error message to the user
        }
    }

    public void btnOverdueBooksReportOnAction(ActionEvent actionEvent)  {
        try {
            String reportPath = "/reports/Overdue_Books_Report.jrxml";
            InputStream inputStream = getClass().getResourceAsStream(reportPath);
            if (inputStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }
            JasperDesign design = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | FileNotFoundException e) {
            e.printStackTrace();

        }
    }
}
