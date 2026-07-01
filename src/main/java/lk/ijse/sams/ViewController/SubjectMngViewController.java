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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.bo.SubjectBO;
import lk.ijse.sams.bo.impl.SubjectBOImpl;
import lk.ijse.sams.dto.SubjectDTO;

public class SubjectMngViewController {

    @FXML
    private Button AddBtn;

    @FXML
    private Button BackBtn;

    @FXML
    private TableColumn<SubjectDTO, Integer> CourseIDClm;

    @FXML
    private ChoiceBox<Integer> CourseIDTxt;

    @FXML
    private Button DeleteBtn;

    @FXML
    private TableColumn<SubjectDTO, Integer> SubjectIDClm;

    @FXML
    private TextField SubjectIDTxt;

    @FXML
    private TableColumn<SubjectDTO, String> SubjectNameClm;

    @FXML
    private TextField SubjectNameTxt;

    @FXML
    private TableView<SubjectDTO> SubjectTable;

    @FXML
    private Button UpdateBtn;

    private SubjectBO subjectBO = new SubjectBOImpl();
    
    @FXML
    void AddBtnOnAction(ActionEvent event) {
    try {

        SubjectDTO dto = new SubjectDTO(
                Integer.parseInt(SubjectIDTxt.getText()),
                SubjectNameTxt.getText(),
                CourseIDTxt.getValue()
        );

        boolean subjectAdded = subjectBO.addSubject(dto);

        if (subjectAdded) {

            new Alert(Alert.AlertType.INFORMATION, "New Subject Added Successfully.").show();

            loadTable();
            clearTxt();

        } else {

            new Alert(Alert.AlertType.ERROR, "ADD Failed.").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    void BackBtnOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("AdminDashboardView.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setTitle("SAMS");
        stage.show();

        Stage currentStage=(Stage)UpdateBtn.getScene().getWindow();

        currentStage.close();
        
        System.out.println("Couese Back");
    }

    @FXML
    void DeleteBtnOnAction(ActionEvent event) {
    try {

        int subjectId = Integer.parseInt(SubjectIDTxt.getText());

        boolean subjectDeleted = subjectBO.deleteSubject(subjectId);

        if (subjectDeleted) {

            new Alert(Alert.AlertType.INFORMATION, "Subject Deleted Successfully.").show();

            loadTable();
            clearTxt();

        } else {

            new Alert(Alert.AlertType.ERROR, "DELETE Failed.").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    

    @FXML
    void SubjectTableOnAction(MouseEvent event) {
        
    SubjectDTO selectedsubject = SubjectTable.getSelectionModel().getSelectedItem();
    
    String id = Integer.toString(selectedsubject.getSubjectId());
    String name = selectedsubject.getSubjectName();
    int courseId = selectedsubject.getCourseId();
    
    SubjectIDTxt.setText(id);
    SubjectNameTxt.setText(name);
    CourseIDTxt.setValue(courseId);
    
    
    }

    @FXML
    void UpdteBtnOnAction(ActionEvent event) {
        
    try {

        SubjectDTO dto = new SubjectDTO(
                Integer.parseInt(SubjectIDTxt.getText()),
                SubjectNameTxt.getText(),
                CourseIDTxt.getValue()
        );

        boolean subjectUpdated = subjectBO.updateSubject(dto);

        if (subjectUpdated) {

            new Alert(Alert.AlertType.INFORMATION, "Subject Updated Successfully.").show();

            loadTable();
            clearTxt();

        } else {

            new Alert(Alert.AlertType.ERROR, "UPDATE Failed.").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    @FXML
    public void CourseIDCbb() {

    try {
            CourseIDTxt.getItems().clear();

            CourseIDTxt.getItems().addAll(subjectBO.getCourseIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    public void loadTable() {

    try {

        ObservableList<SubjectDTO> list = FXCollections.observableArrayList(subjectBO.getAllSubjects());
        SubjectTable.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    } 
    }

    @FXML
    public void initialize() {

        SubjectIDClm.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        SubjectNameClm.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        CourseIDClm.setCellValueFactory(new PropertyValueFactory<>("courseId"));

        SubjectIDClm.setResizable(false);
        SubjectNameClm.setResizable(false);
        CourseIDClm.setResizable(false);

        SubjectIDClm.setStyle("-fx-alignment: CENTER-RIGHT;");
        SubjectNameClm.setStyle("-fx-alignment: CENTER-RIGHT;");
        CourseIDClm.setStyle("-fx-alignment: CENTER-RIGHT;");

        loadTable();
        CourseIDCbb();
    
    }
    
    @FXML
    private void clearTxt() {
        
        SubjectIDTxt.clear();
        SubjectNameTxt.clear();
        CourseIDTxt.setValue(null);
    }

}