/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.bo.AttendanceRptBO;
import lk.ijse.sams.bo.impl.AttendanceRptBOImpl;
import lk.ijse.sams.dto.AttendanceRtpDTO;

public class AttendanceRptViewController {

    @FXML
    private TableView<AttendanceRtpDTO> AttendanceReportTbl;

    @FXML
    private Button BackBtn;

    @FXML
    private Button ClearBtn;

    @FXML
    private DatePicker DateRange1;

    @FXML
    private DatePicker DateRange2;

    @FXML
    private Button ReportBtn;

    @FXML
    private ComboBox<Integer> StudentIDCmb;

    @FXML
    private ComboBox<Integer> SubjectCmb;

    @FXML
    private TableColumn<AttendanceRtpDTO, String> dateCl;

    @FXML
    private TableColumn<AttendanceRtpDTO, String> statusCl;

    @FXML
    private TableColumn<AttendanceRtpDTO, Integer> studentIdcl;

    @FXML
    private TableColumn<AttendanceRtpDTO, String> studentNameCl;

    @FXML
    private TableColumn<AttendanceRtpDTO, Integer> subjectCl;

    private AttendanceRptBO attendanceRptBO = new AttendanceRptBOImpl();
    
    @FXML
    void BackBtnOnAction(ActionEvent event) throws IOException {
            String fxmlPath;

            if ("Lecturer".equals(App.currentUserRole)) {
                System.out.println(App.currentUserRole);
                fxmlPath = "LecturerDashboardView.fxml";
            } else {
                fxmlPath = "AdminDashboardView.fxml";
            }

            Parent root = FXMLLoader.load(App.class.getResource(fxmlPath));

            Stage stage = (Stage) BackBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("SAMS");
            stage.show();
    }

    @FXML
    void ClearBtnOnAction(ActionEvent event) {
        
        SubjectCmb.setValue(null);
        StudentIDCmb.setValue(null);
        DateRange2.setValue(null);
        DateRange1.setValue(null);

        AttendanceReportTbl.getItems().clear();
    }

    @FXML
    void ReportBtnONAction(ActionEvent event) {

    try {

        if (StudentIDCmb.getValue() == null ||
            SubjectCmb.getValue() == null ||
            DateRange1.getValue() == null ||
            DateRange2.getValue() == null) {

            new Alert(Alert.AlertType.ERROR, "Please fill all fields").show();
            return;
        }

        ObservableList<AttendanceRtpDTO> list =FXCollections.observableArrayList(
                        attendanceRptBO.getAttendanceReport(
                                StudentIDCmb.getValue(),
                                SubjectCmb.getValue(),
                                DateRange1.getValue(),
                                DateRange2.getValue()
                        )
                );

        AttendanceReportTbl.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    @FXML
    public void initialize() {

        studentIdcl.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCl.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        subjectCl.setCellValueFactory(new PropertyValueFactory<>("subject"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCl.setCellValueFactory(new PropertyValueFactory<>("status"));

        StudentIdCbb();
        SubjectIdCbb();
}
    
    @FXML
    public void SubjectIdCbb() {

        try {
            SubjectCmb.getItems().clear();
            SubjectCmb.getItems().addAll(attendanceRptBO.getStudentIds());

        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
    @FXML
    public void StudentIdCbb() {
        try {
            StudentIDCmb.getItems().clear();
            StudentIDCmb.getItems().addAll(attendanceRptBO.getSubjectIds());

        } catch (Exception e) {
            e.printStackTrace();
        }
       }

}
