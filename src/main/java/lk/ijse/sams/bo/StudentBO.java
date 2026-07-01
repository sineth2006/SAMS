/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author Sineth
 */
public interface StudentBO {
    boolean addStudent(StudentDTO dto) throws Exception;
    boolean updateStudent(StudentDTO dto) throws Exception;
    boolean deleteStudent(int id) throws Exception;
    List<StudentDTO> getAllStudent() throws Exception;
    List<Integer> getCourseIds() throws Exception;
}
