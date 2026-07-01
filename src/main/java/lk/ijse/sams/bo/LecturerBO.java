/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author Sineth
 */
public interface LecturerBO {
    boolean addLecturer(LecturerDTO dto) throws Exception;
    boolean updateLecturer(LecturerDTO dto) throws Exception;
    boolean deleteLectuer(int id) throws Exception;
    List<LecturerDTO> getAllLecturers() throws Exception;
    List<Integer> getUserIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
}
