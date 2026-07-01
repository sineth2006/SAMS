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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.sams.App;
import lk.ijse.sams.bo.ClassShedulingBO;
import lk.ijse.sams.bo.impl.ClassShedulingBOImpl;



import lk.ijse.sams.dto.ClassShedulingDTO;

public class ClassShedulingViewController {

    @FXML
    private Button BackBtn;

    @FXML
    private Button CancelBtn;

    @FXML
    private TableView<ClassShedulingDTO> ClassShedulingTbl;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> ClassroomCl;

    @FXML
    private ComboBox<String> ClassroomNo;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> CourseCl;

    @FXML
    private ChoiceBox<Integer> CourseCmb;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> DateCl;

    @FXML
    private DatePicker DateCmb;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> LecturerCl;

    @FXML
    private ChoiceBox<Integer> LecturerCmb;

    @FXML
    private Button SaveSheduleBtn;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> SubjectCl;

    @FXML
    private ChoiceBox<Integer> SubjectCmb;

    @FXML
    private TableColumn<ClassShedulingDTO, ?> TimeCl;

    @FXML
    private ChoiceBox<String> TimeCmb;
    
    @FXML
    private TableColumn<ClassShedulingDTO, ?> ShedulingIDCl;
    
    @FXML
    private TextField ShedulingIdTxt;

    private ClassShedulingBO schedulingBO = new ClassShedulingBOImpl();
    
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
    void CancelBtnOnAction(ActionEvent event) throws Exception{
        int id = Integer.parseInt(ShedulingIdTxt.getText());

        boolean cancekSheduling = schedulingBO.deleteSchedule(id);

        if(cancekSheduling){
            new Alert(Alert.AlertType.INFORMATION,"Class Schedule Cansel Successfully.").show();
            loadTable();
            clearTxt();
        }else{
            new Alert(Alert.AlertType.ERROR,"Cansel Failed").show();
        }

    }

    @FXML
    void SaveSheduleBtnOnAction(ActionEvent event) throws Exception {
        ClassShedulingDTO dto = new ClassShedulingDTO(
                    Integer.parseInt(ShedulingIdTxt.getText()),
                    CourseCmb.getValue(),
                    SubjectCmb.getValue(),
                    LecturerCmb.getValue(),
                    DateCmb.getValue().toString(),
                    TimeCmb.getValue(),
                    ClassroomNo.getValue());

        boolean addedsheduling = schedulingBO.addSchedule(dto);

        if (addedsheduling) {

            new Alert(Alert.AlertType.INFORMATION,"Class Schedule Added Successfully.").show();
            loadTable();
            clearTxt();
        }else{
            new Alert(Alert.AlertType.ERROR,"Save Failed").show();
        }
    }
    
    @FXML
    void ClassShedulingTblOnMouse(MouseEvent event) {
         ClassShedulingDTO selectedshedule = ClassShedulingTbl.getSelectionModel().getSelectedItem();

        ShedulingIdTxt.setText(String.valueOf(selectedshedule.getShedulingId()));
        CourseCmb.setValue(selectedshedule.getCourseId());
        SubjectCmb.setValue(selectedshedule.getSubjectId());
        LecturerCmb.setValue(selectedshedule.getLecturerId());
        
        DateCmb.setValue( java.time.LocalDate.parse(selectedshedule.getDate()));
        TimeCmb.setValue(selectedshedule.getTime());
        ClassroomNo.setValue(selectedshedule.getClassNo());
    
    }
    
    @FXML
    void CleanBtnOnAction(ActionEvent event) {
    clearTxt();
    }
    
    @FXML
    public void initialize() {    
        ShedulingIDCl.setCellValueFactory(new PropertyValueFactory<>("shedulingId"));
        DateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeCl.setCellValueFactory(new PropertyValueFactory<>("time"));
        CourseCl.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        SubjectCl.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        LecturerCl.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
        ClassroomCl.setCellValueFactory(new PropertyValueFactory<>("classNo"));
        
        ShedulingIDCl.setResizable(false);
        DateCl.setResizable(false);
        TimeCl.setResizable(false);
        CourseCl.setResizable(false);
        SubjectCl.setResizable(false);
        LecturerCl.setResizable(false);
        ClassroomCl.setResizable(false);
        DateCl.setStyle("-fx-alignment: CENTER-RIGHT;");

        ShedulingIDCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        TimeCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        CourseCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        SubjectCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        LecturerCl.setStyle("-fx-alignment: CENTER-RIGHT;");
        ClassroomCl.setStyle("-fx-alignment: CENTER-RIGHT;");

        loadTable();
        loadCoursesCbb();
        loadSubjectIdCbb();
        loadLecturerCbb();
        loadTimeSlot();
        loadClassRoomNo();

    }
    
    @FXML
    public void loadTable() {
    try {

        ObservableList<ClassShedulingDTO> list = FXCollections.observableArrayList(schedulingBO.getAllSchedules());

        ClassShedulingTbl.setItems(list);

    } catch (Exception e) {
        e.printStackTrace();
    }

}
    
    @FXML
    public void loadCoursesCbb() {

    try {
            CourseCmb.getItems().clear();

            CourseCmb.getItems().addAll(schedulingBO.getCourseIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    public void loadSubjectIdCbb() {

    try {
            SubjectCmb.getItems().clear();

            SubjectCmb.getItems().addAll(schedulingBO.getSubjectIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    public void loadLecturerCbb() {

    try {
            LecturerCmb.getItems().clear();

            LecturerCmb.getItems().addAll(schedulingBO.getLecturerIds());

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    public void loadTimeSlot() {
       TimeCmb.getItems().add("08:00 - 10:00");
       TimeCmb.getItems().add("10:00 - 12:00");
       TimeCmb.getItems().add("12:00 - 14:00");
       TimeCmb.getItems().add("14:00 - 16:00");
       TimeCmb.getItems().add("16:00 - 18:00");
    }
   
    @FXML
    public void loadClassRoomNo() {
       ClassroomNo.getItems().add("LAB - 200");
       ClassroomNo.getItems().add("LAB - 212");
       ClassroomNo.getItems().add("LAB - 224");
       ClassroomNo.getItems().add("LAB - 234");
       ClassroomNo.getItems().add("LAB - 244");
       ClassroomNo.getItems().add("LAB - 254");
   }
   
    @FXML
    public void clearTxt() {
        CourseCmb.setValue(null);
        SubjectCmb.setValue(null);
        LecturerCmb.setValue(null);
        DateCmb.setValue(null);
        TimeCmb.setValue(null);
        ClassroomNo.setValue(null);
        ShedulingIdTxt.setText("");
   }
}
