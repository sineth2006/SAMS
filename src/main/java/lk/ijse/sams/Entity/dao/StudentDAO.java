/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.StudentMngEntity;

/**
 *
 * @author Sineth
 */
public interface StudentDAO {// This class was mistakenly created here; it should be an entity inside the lk.ijse.sams.dao package.
    boolean save(StudentMngEntity entity) throws Exception;
    boolean update(StudentMngEntity entity) throws Exception;
    boolean delete(int id) throws Exception;
    List<StudentMngEntity> getAll() throws Exception;
    List<Integer> getCourseIds() throws Exception;
}
