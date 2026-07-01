/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.ijse.sams.App;

public class LecturerDashViewController {

    @FXML
    private Button AttendenceBtn;

    @FXML
    private Button ReportBtn;

    @FXML
    private Button shedulingBtn;

    @FXML
    void btnAttendenceOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(App.class.getResource("AttendanceManagementView.fxml"));
        Stage stage=new Stage();
        stage.setTitle("SAMS");
        stage.setScene(new Scene(root));
        stage.show();
        
        Stage currentStage=(Stage)AttendenceBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(App.class.getResource("AttendanceReportView.fxml"));
        Stage stage=new Stage();
        stage.setTitle("SAMS");
        stage.setScene(new Scene(root));
        stage.show();
        
        Stage currentStage=(Stage)AttendenceBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void btnShedulingOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(App.class.getResource("ClassShedulingView.fxml"));
        Stage stage=new Stage();
        stage.setTitle("SAMS");
        stage.setScene(new Scene(root));
        stage.show();
        
        Stage currentStage=(Stage)AttendenceBtn.getScene().getWindow();
        currentStage.close();
    }
    @FXML
    void logoutBtnOnAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Warning");
        alert.setHeaderText("Logout");
        alert.setContentText("Do you want to logout?");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alert.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yesBtn) {

            Parent root = FXMLLoader.load(App.class.getResource("LoginView.fxml"));

            Stage stage = new Stage();
            stage.setTitle("SAMS");
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) AttendenceBtn.getScene().getWindow();
            currentStage.close();
    }
        System.out.println("-- Logout --");
    }
    

}
