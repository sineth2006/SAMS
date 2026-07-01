/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;

import java.io.IOException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.bo.StudentBO;
import lk.ijse.sams.bo.impl.StudentBOImpl;
import lk.ijse.sams.dto.StudentDTO;

public class StudentMngViewController {

    @FXML
    private Button BackBtn;

    @FXML
    private TableColumn<StudentDTO, Integer> CourseCl;

    @FXML
    private ChoiceBox<Integer> CoursesCbb;

    @FXML
    private TableColumn<StudentDTO, String> EmailCl;

    @FXML
    private TextField EmailTxt;

    @FXML
    private Button StudentAddBtn;

    @FXML
    private Button StudentDeleteBtn;

    @FXML
    private TableColumn<StudentDTO, Integer> StudentIDCl;

    @FXML
    private TextField StudentIDTxt;

    @FXML
    private TableColumn<StudentDTO, String> StudentNameCl;

    @FXML
    private TextField StudentNameTxt;

    @FXML
    private TableView<StudentDTO> StudentTable;

    @FXML
    private Button StudentUpdateBtn;

    @FXML
    private TableColumn<StudentDTO, Integer> TelNoCl;

    @FXML
    private TextField TelNoTxt;

    private StudentBO studentBO = new StudentBOImpl();
    
    @FXML
    void BackBtnOnAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(App.class.getResource("AdminDashboardView.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setTitle("SAMS");
        stage.show();

        Stage currentStage=(Stage)StudentUpdateBtn.getScene().getWindow();

        currentStage.close();
        
        System.out.println("Student Back");
    }

    @FXML
    void StudentAddBtnOnAction(ActionEvent event) {

        try {
            StudentDTO dto = new StudentDTO(
                Integer.parseInt(StudentIDTxt.getText()),
                StudentNameTxt.getText(),
                Integer.parseInt(TelNoTxt.getText()),
                EmailTxt.getText(),
                CoursesCbb.getValue());

        boolean studentAdded = studentBO.addStudent(dto);
        if (studentAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Student Added").show();
            loadTable();
            clearTxt();
        }
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    @FXML
    void StudentDeleteBtnOnAction(ActionEvent event) {
         try {
                int studentId = Integer.parseInt(StudentIDTxt.getText());

                 boolean studentDeleted = studentBO.deleteStudent(studentId);
              
            if (studentDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Student Deleted Successfully").show();
                loadTable();
                clearTxt();     
            } else {
                new Alert(Alert.AlertType.ERROR, "Delete Failed").show();
                }
            
        } catch (Exception e) {
    }
}

    @FXML
    void StudentUpdateBtnOnAction(ActionEvent event) {
        try {
            StudentDTO dto = new StudentDTO(
                Integer.parseInt(StudentIDTxt.getText()),
                StudentNameTxt.getText(),
                Integer.parseInt(TelNoTxt.getText()),
                EmailTxt.getText(),
                CoursesCbb.getValue());

            boolean studentUpdate = studentBO.updateStudent(dto);

            if(studentUpdate){
            new Alert(Alert.AlertType.INFORMATION, "Student Updated Successfully").show();
            loadTable();
            clearTxt();
            
            } else {
                new Alert(Alert.AlertType.ERROR, "Update Failed").show();
                    }
    } 
        catch (Exception e) {}
    }
    
    @FXML
    void StudentTableOnMouseClick(MouseEvent event) {
        
        StudentDTO selectedstudent = StudentTable.getSelectionModel().getSelectedItem();

        String studentId = Integer.toString(selectedstudent.getStudentId());
        String studentName = selectedstudent.getStudentName();
        String telNo = Integer.toString(selectedstudent.getTelNo());
        String email = selectedstudent.getEmail();
        int courseId = selectedstudent.getCourseId();

        StudentIDTxt.setText(studentId);
        StudentNameTxt.setText(studentName);
        TelNoTxt.setText(telNo);
        EmailTxt.setText(email);
        CoursesCbb.setValue(courseId);
    }
    
    @FXML
    public void loadTable() {
    try {
        List<StudentDTO> data = studentBO.getAllStudent();

        ObservableList<StudentDTO> list =
                FXCollections.observableArrayList(data);

        StudentTable.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    public void initialize() {

    StudentIDCl.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    StudentNameCl.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    TelNoCl.setCellValueFactory(new PropertyValueFactory<>("telNo"));
    EmailCl.setCellValueFactory(new PropertyValueFactory<>("email"));
    CourseCl.setCellValueFactory(new PropertyValueFactory<>("courseId"));

    try {
        loadTable();
        loadCoursesCbb();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    }
    
    @FXML
    public void loadCoursesCbb() {

    try {
            CoursesCbb.getItems().clear();

            CoursesCbb.getItems().addAll(studentBO.getCourseIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @FXML
    public void clearTxt(){
    StudentIDTxt.clear();
    StudentNameTxt.clear();
    TelNoTxt.clear();
    EmailTxt.clear();
    CoursesCbb.setValue(null);
    }

}

