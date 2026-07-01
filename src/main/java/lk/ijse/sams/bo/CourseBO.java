/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.util.List;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author Sineth
 */
public interface CourseBO {
    boolean addCourse(CourseDTO dto) throws Exception;
    boolean updateCourse(CourseDTO dto) throws Exception;
    boolean deleteCourse(int id) throws Exception;
    List<CourseDTO> getAllCourses() throws Exception;
}
