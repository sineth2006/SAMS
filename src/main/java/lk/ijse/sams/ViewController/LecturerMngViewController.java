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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.bo.LecturerBO;
import lk.ijse.sams.bo.impl.LecturerBOImpl;
import lk.ijse.sams.dto.LecturerDTO;

public class LecturerMngViewController {

    @FXML
    private Button AddLecturerBtn;

    @FXML
    private Button BackBtn;

    @FXML
    private Button DeleteLecturerBtn;

    @FXML
    private TextField EmailTxt;

    @FXML
    private TableColumn<LecturerDTO, String> LecturerEmailCl;

    @FXML
    private TableColumn<LecturerDTO, Integer> LecturerIdCl;

    @FXML
    private TextField LecturerIdTxt;

    @FXML
    private TableColumn<LecturerDTO, String> LecturerNameCl;

    @FXML
    private TextField LecturerNameTxt;

    @FXML
    private TableView<LecturerDTO> LecturerTable;

    @FXML
    private ComboBox<Integer> SubjectIdCbb;

    @FXML
    private TableColumn<LecturerDTO, Integer> SubjectIdCl;

    @FXML
    private TableColumn<LecturerDTO, Integer> TelNoCl;

    @FXML
    private TextField TelephoneTxt;

    @FXML
    private Button UpdateLecturerBtn;

    @FXML
    private ComboBox<Integer> UserIdCbb;

    @FXML
    private TableColumn<LecturerDTO, Integer> UserIdCl;

    private LecturerBO lecturerBO = new LecturerBOImpl();
    
    @FXML
    void AddLecturerBtnOnAction(ActionEvent event) {

        try {
            LecturerDTO dto = new LecturerDTO(
                    Integer.parseInt(LecturerIdTxt.getText()),
                    LecturerNameTxt.getText(),
                    EmailTxt.getText(),
                    TelephoneTxt.getText(),
                    UserIdCbb.getValue(),
                    SubjectIdCbb.getValue()
            );

            boolean LecturerAdded = lecturerBO.addLecturer(dto);

            if (LecturerAdded) {

                new Alert(Alert.AlertType.INFORMATION,"New Lecturer Added Successfully.").show();

                loadTable();
                clearTxt();

            } else {
                new Alert(Alert.AlertType.ERROR,"ADD Faild.").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void BackBtnOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(App.class.getResource("AdminDashboardView.fxml"));
        Stage stage=new Stage();
        stage.setTitle("SAMS");
        stage.setScene(new Scene(root));
        stage.show();
        
        Stage currentStage=(Stage)UpdateLecturerBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void DeleteLecturerBtnOnAction(ActionEvent event) {
        
    try {
                int lecturerId = Integer.parseInt(LecturerIdTxt.getText());

                boolean lecturerDeleted = lecturerBO.deleteLectuer(lecturerId);
                
            if (lecturerDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Lecturer Deleted Successfully").show();
                loadTable();
                clearTxt();     
            } else {
                new Alert(Alert.AlertType.ERROR, "DELETE Failed").show();
                }
            
        } catch (Exception e) {
    }

    }

    @FXML
    void UpdateLecturerBtnOnAction(ActionEvent event) throws IOException {
    try {
                LecturerDTO dto = new LecturerDTO(
                        Integer.parseInt(LecturerIdTxt.getText()),
                        LecturerNameTxt.getText(),
                        EmailTxt.getText(),
                        TelephoneTxt.getText(),
                        UserIdCbb.getValue(),
                        SubjectIdCbb.getValue()
                );
            boolean LecturerUpdated = lecturerBO.updateLecturer(dto);

            if (LecturerUpdated) {

                new Alert(Alert.AlertType.INFORMATION,"New Lecturer Updated Successfully.").show();

                loadTable();
                clearTxt();

            } else {
                new Alert(Alert.AlertType.ERROR,"UPDATE Failed.").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void LecturerTableOnMouse(MouseEvent event) {
    LecturerDTO selectedLecturer = LecturerTable.getSelectionModel().getSelectedItem();

        String studentId = Integer.toString(selectedLecturer.getLecturerId());
        String studentName = selectedLecturer.getLecturerName();
        String telNo = selectedLecturer.getTelNo();
        String email = selectedLecturer.getEmail();
        int userId = selectedLecturer.getUserId();
        int courseId = selectedLecturer.getSubjectId();


        LecturerIdTxt.setText(studentId);
        LecturerNameTxt.setText(studentName);
        TelephoneTxt.setText(telNo);
        EmailTxt.setText(email);
        UserIdCbb.setValue(courseId);
        SubjectIdCbb.setValue(courseId);
    
    }
    
    @FXML
    public void loadTable() {
    try {
        ObservableList<LecturerDTO> list = FXCollections.observableArrayList(
                lecturerBO.getAllLecturers()
        );

        LecturerTable.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    @FXML
    public void initialize() {

        LecturerIdCl.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
        LecturerNameCl.setCellValueFactory(new PropertyValueFactory<>("lecturerName"));
        LecturerEmailCl.setCellValueFactory(new PropertyValueFactory<>("email"));
        TelNoCl.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        UserIdCl.setCellValueFactory(new PropertyValueFactory<>("userId"));
        SubjectIdCl.setCellValueFactory(new PropertyValueFactory<>("subjectId"));

        LecturerIdCl.setResizable(false);
        LecturerNameCl.setResizable(false);
        LecturerEmailCl.setResizable(false);
        TelNoCl.setResizable(false);
        UserIdCl.setResizable(false);
        SubjectIdCl.setResizable(false);

        LecturerIdCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        LecturerNameCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        LecturerEmailCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        TelNoCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        UserIdCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        SubjectIdCl.setStyle("-fx-alignment: CENTER-RIGHT;");

        loadTable();
        UserIdCbb();
        SubjectIdCbb();
    }
    
    
    @FXML
    public void UserIdCbb() {

    try {
            UserIdCbb.getItems().clear();

            UserIdCbb.getItems().addAll(lecturerBO.getUserIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
   }
    

    @FXML
    public void SubjectIdCbb() {

    try {
            SubjectIdCbb.getItems().clear();

            SubjectIdCbb.getItems().addAll(lecturerBO.getSubjectIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @FXML
    private void clearTxt() {
        
        LecturerIdTxt.clear();
        LecturerNameTxt.clear();
        TelephoneTxt.clear();
        EmailTxt.clear();
        UserIdCbb.setValue(null);
        SubjectIdCbb.setValue(null);
    }
}