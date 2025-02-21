package edu.icet.librarymanagmentsystem.controller.reports;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import javafx.event.ActionEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class ReoprtsFormController {
    public void btnActiveBorrowersReportOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/Active_Borrowers.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnAllBooksReportOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/AllBooks.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnAllBorrowedBookReportOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/allborrowedbook.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnBookAvailabilityOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/Books_Availability_Report.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnAllCustomerReortOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/Customer_Report.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnFineCollectionOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/Fine_Collection_Report.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }

    public void btnOverdueBooksReportOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        String reportPath = "F:/jetbean projects/Final Cw/Library Managment System/library-managment-system/src/main/resources/reports/Overdue_Books_Report.jrxml";

        JasperDesign design = JRXmlLoader.load(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint, false);
    }
}
