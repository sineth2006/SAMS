/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.CourseMngEntity;

/**
 *
 * @author Sineth
 */
public interface CourseDAO {// This class was mistakenly created here; it should be an entity inside the lk.ijse.sams.dao package.
    boolean save(CourseMngEntity entity) throws Exception;
    boolean update(CourseMngEntity entity) throws Exception;
    boolean delete(int id) throws Exception;
    List<CourseMngEntity> getAll() throws Exception;
}
