/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.Entity.AttendanceMngEntity;
import lk.ijse.sams.bo.AttendanceMngBO;
import lk.ijse.sams.bo.impl.AttendanceBOImpl;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.AttendanceMngDTO;

public class AttendanceMngViewController {

    @FXML
    private TableView<AttendanceMngEntity> AttendaceManagementTbl;

    @FXML
    private Button BackBtn;

    @FXML
    private ComboBox<Integer> ChoiceClassCmb;

    @FXML
    private Button CleanBtn;

    @FXML
    private Button SaveBtn;
    
    @FXML
    private TableColumn<AttendanceMngEntity, Boolean> absentIdCl;

    @FXML
    private TableColumn<AttendanceMngEntity, Boolean> presentIdCl;

    @FXML
    private TableColumn<AttendanceMngEntity, Integer> shedulingIdCl;

    @FXML
    private TableColumn<AttendanceMngEntity, Integer> studentIdCl;

    @FXML
    private TableColumn<AttendanceMngEntity, String> studentNamecl;
    
    private AttendanceMngBO attendanceBO = new AttendanceBOImpl();
    
    @FXML
    void AttendaceManagementTblOnMouse(MouseEvent event) {

    }

    @FXML
    void BackBtnOnAction(ActionEvent event) throws IOException {
            String fxmlPath;

            if ("Lecturer".equals(App.currentUserRole)) {

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
    void CleanBtnOnAction(ActionEvent event) {
    cleanTxt();
    }
    
    @FXML
    void SaveBtnOnAction(ActionEvent event) {
    try {

        List<AttendanceMngDTO> dtoList = new ArrayList<>();

        for (AttendanceMngEntity row : AttendaceManagementTbl.getItems()) {

            dtoList.add(new AttendanceMngDTO(
                    row.getAttendanceId(),
                    row.getStudentId(),
                    row.getStudentName(),
                    row.isPresent(),
                    row.isAbsent()));
        }

        boolean saved = attendanceBO.saveAttendance(
                ChoiceClassCmb.getValue(),
                dtoList);

        if (saved) {
            new Alert(Alert.AlertType.INFORMATION,"Attendance Saved Successfully.").show();
            cleanTxt();
        } else {
            new Alert(Alert.AlertType.ERROR,"Save Failed.").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    
    @FXML
    private void loadTable() {
        
        if (ChoiceClassCmb.getValue() == null) {
            return;
        }

        try {

            List<AttendanceMngDTO> dtoList =
                    attendanceBO.getStudents(ChoiceClassCmb.getValue());

            ObservableList<AttendanceMngEntity> list =
                    FXCollections.observableArrayList();

            for (AttendanceMngDTO dto : dtoList) {

                AttendanceMngEntity entity =
                        new AttendanceMngEntity(
                                dto.getAttendanceId(),
                                dto.getStudentId(),
                                dto.getStudentName(),
                                dto.isPresent(),
                                dto.isAbsent());

                entity.presentProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal) {
                        entity.setAbsent(false);
                    }
                });

                entity.absentProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal) {
                        entity.setPresent(false);
                    }
                });

                list.add(entity);
            }

            AttendaceManagementTbl.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
    @FXML
    void ChoiceClassOnAction(ActionEvent event) {
    loadTable();
    }
    
    @FXML
    public void loadChoiceClassCmb() {

        try {

            ChoiceClassCmb.getItems().clear();

             Connection conn = DBConnection.getInstance().getConnection();

            String sql = "SELECT sheduling_id FROM sheduling";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ChoiceClassCmb.getItems().add(rs.getInt("sheduling_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
        
    shedulingIdCl.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
    studentIdCl.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    studentNamecl.setCellValueFactory(new PropertyValueFactory<>("studentName"));

    // BooleanProperty columns
    presentIdCl.setCellValueFactory(cellData -> cellData.getValue().presentProperty());
    absentIdCl.setCellValueFactory(cellData -> cellData.getValue().absentProperty());

    // Display checkboxes
    presentIdCl.setCellFactory(CheckBoxTableCell.forTableColumn(presentIdCl));
    absentIdCl.setCellFactory(CheckBoxTableCell.forTableColumn(absentIdCl));

    // Make table editable
    AttendaceManagementTbl.setEditable(true);
    presentIdCl.setEditable(true);
    absentIdCl.setEditable(true);

    loadChoiceClassCmb();
    }
    
    
    @FXML
    public void cleanTxt() {
    for (AttendanceMngEntity row : AttendaceManagementTbl.getItems()) {
        row.setPresent(false);
        row.setAbsent(false);
    }  
    AttendaceManagementTbl.refresh();
    ChoiceClassCmb.getSelectionModel().clearSelection();
    ChoiceClassCmb.setValue(null);
    AttendaceManagementTbl.getItems().clear();
    }
}