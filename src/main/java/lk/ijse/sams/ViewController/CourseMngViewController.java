/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.Entity.CourseMngEntity;
import lk.ijse.sams.bo.CourseBO;
import lk.ijse.sams.bo.impl.CourseBOImpl;
import lk.ijse.sams.db.DBConnection;
import lk.ijse.sams.dto.CourseDTO;

public class CourseMngViewController {

    @FXML
    private Button AddBtn;

    @FXML
    private Button BackBtn;

    @FXML
    private TableColumn<CourseDTO, String> CourseDurationClm;

    @FXML
    private TextField CourseDurationTxt;

    @FXML
    private TableColumn<CourseDTO, Integer> CourseIdClm;

    @FXML
    private TextField CourseIdTxt;

    @FXML
    private TableColumn<CourseDTO, String> CourseNameClm;

    @FXML
    private TextField CourseNameTxt;

    @FXML
    private TableView<CourseDTO> CourseTable;

    @FXML
    private Button DeleteBtn;
    
    @FXML
    private Button UpdateBtn;
    
    private CourseBO courseBO = new CourseBOImpl();
    
   @FXML
    void AddBtnOnAction(ActionEvent event) {
        
        try {
        CourseDTO dto = new CourseDTO(
                Integer.parseInt(CourseIdTxt.getText()),
                CourseNameTxt.getText(),
                CourseDurationTxt.getText());
        
        boolean courseAdded = courseBO.addCourse(dto);
        if (courseAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Course Added").show();
            loadTable();
            clearTxt();
        }else {
                new Alert(Alert.AlertType.ERROR, "Delete Failed").show();}  
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
    void CourseTableOnMousePressed(MouseEvent event) {
        
    CourseDTO selectedCourse = CourseTable.getSelectionModel().getSelectedItem();
    
    String id = Integer.toString(selectedCourse.getCourseId());
    String name = selectedCourse.getCourseName();
    String duration = selectedCourse.getDuration();
    
    CourseIdTxt.setText(id);
    CourseNameTxt.setText(name);
    CourseDurationTxt.setText(duration);
    
    }
    
    @FXML
    void DeleteBtnOnAction(ActionEvent event) {
         try {
                int courseId = Integer.parseInt(CourseIdTxt.getText());

                 boolean courseDeleted = courseBO.deleteCourse(courseId);
              
            if (courseDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Course Deleted Successfully").show();
                loadTable();
                clearTxt();     
            } else {
                new Alert(Alert.AlertType.ERROR, "Delete Failed").show();}     
            
            } catch (Exception e) {}
}

    @FXML
    void UpdateBtnOnAction(ActionEvent event) {
        try {
            CourseDTO dto = new CourseDTO(
                    Integer.parseInt(CourseIdTxt.getText()),
                    CourseNameTxt.getText(),
                    CourseDurationTxt.getText());

            boolean courseUpdate = courseBO.updateCourse(dto);

            if(courseUpdate){
            new Alert(Alert.AlertType.INFORMATION, "Course Updated Successfully").show();
            loadTable();
            clearTxt();
            
            } else {
                new Alert(Alert.AlertType.ERROR, "Update Failed").show();
                    }
        }catch (Exception e) {}
}
    
    @FXML
    public void loadTable() {

    try {
        List<CourseDTO> data = courseBO.getAllCourses();

        ObservableList<CourseDTO> list =
                FXCollections.observableArrayList(data);

        CourseTable.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    }


}

    @FXML
    public void initialize() {

    CourseIdClm.setCellValueFactory(new PropertyValueFactory<>("courseId"));
    CourseNameClm.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    CourseDurationClm.setCellValueFactory(new PropertyValueFactory<>("duration"));

    loadTable();

    }
    
    private void clearTxt() {
        CourseIdTxt.clear();
        CourseNameTxt.clear();
        CourseDurationTxt.clear();
}
}

