/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.SubjectMngEntity;

/**
 *
 * @author Sineth
 */
public interface SubjectDAO {
    boolean save(SubjectMngEntity entity) throws Exception;
    boolean update(SubjectMngEntity entity) throws Exception;
    boolean delete(int id) throws Exception;
    List<SubjectMngEntity> getAll() throws Exception;
    List<Integer> getCourseIds() throws Exception;
}
