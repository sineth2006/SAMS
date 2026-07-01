/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.SubjectDTO;

/**
 *
 * @author Sineth
 */
public interface SubjectBO {
    boolean addSubject(SubjectDTO dto) throws Exception;
    boolean updateSubject(SubjectDTO dto) throws Exception;
    boolean deleteSubject(int id) throws Exception;
    List<SubjectDTO> getAllSubjects() throws Exception;
    List<Integer> getCourseIds() throws Exception;
}
