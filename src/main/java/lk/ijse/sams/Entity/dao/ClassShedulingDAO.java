/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.ClassShedulingEntity;

/**
 *
 * @author Sineth
 */
public interface ClassShedulingDAO {
    boolean save(ClassShedulingEntity entity) throws Exception;
    boolean delete(int id) throws Exception;
    List<ClassShedulingEntity> getAll() throws Exception;
    List<Integer> getCourseIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
    List<Integer> getLecturerIds() throws Exception;
}
