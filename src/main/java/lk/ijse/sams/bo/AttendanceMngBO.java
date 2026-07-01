/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.AttendanceMngDTO;

/**
 *
 * @author Sineth
 */
public interface AttendanceMngBO {
    boolean saveAttendance(int scheduleId,List<AttendanceMngDTO> list) throws Exception;
    List<AttendanceMngDTO> getStudents(int scheduleId) throws Exception;
    List<Integer> getScheduleIds() throws Exception;    
}
