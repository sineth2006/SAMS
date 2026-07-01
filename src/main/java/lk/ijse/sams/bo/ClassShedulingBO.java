/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.ClassShedulingDTO;

/**
 *
 * @author Sineth
 */
public interface ClassShedulingBO {
    boolean addSchedule(ClassShedulingDTO dto) throws Exception;
    boolean deleteSchedule(int id) throws Exception;
    List<ClassShedulingDTO> getAllSchedules() throws Exception;
    List<Integer> getCourseIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
    List<Integer> getLecturerIds() throws Exception;
}
