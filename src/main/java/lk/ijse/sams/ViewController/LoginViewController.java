/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.ViewController;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.db.DBConnection;

public class LoginViewController {
    
private static Scene scene;
    
    @FXML
    private Button cleanBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passWordTxt;

    @FXML
    private TextField userNameTxt;

    @FXML
    void btnCleanOnAction(ActionEvent event) {
        userNameTxt.setText("");
        passWordTxt.setText("");
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException{
        String username = userNameTxt.getText();
        String password = passWordTxt.getText();
        
        Connection conn=DBConnection.getInstance().getConnection();
        
        
        if(conn!=null){
        System.out.println("Login Ckeck!!!");
        
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, username);
        stm.setString(2, password);
        
        ResultSet result = stm.executeQuery();
        System.out.println("Check");
        
        if(result.next()){

        String role = result.getString("role");
        if(role.equals("Admin")){
            
        App.currentUserRole = "Admin";

        Parent root = FXMLLoader.load(App.class.getResource("AdminDashboardView.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setTitle("SAMS");
        stage.show();

        Stage currentStage=(Stage)loginBtn.getScene().getWindow();

        currentStage.close();
        System.out.println("--Come In Admin--");

    }else if(role.equals("Lecturer")){
        
        App.currentUserRole = "Lecturer";

        Parent root = FXMLLoader.load(App.class.getResource("LecturerDashboardView.fxml"));

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setTitle("SAMS");
        stage.show();

        Stage currentStage=(Stage)loginBtn.getScene().getWindow();

        currentStage.close();
        System.out.println("--Come In Lecturer--");
    }

    }else{
        System.out.println("Invalid Username or Password");
        
        userNameTxt.setText("");
        passWordTxt.setText("");
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Warning");
        alert.setHeaderText("Invalid Login");
        alert.setContentText("Check Your Username Or Password.!!!");
        alert.showAndWait();
}
        }
        
    }
}

