/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.LecturerMngEntity;

/**
 *
 * @author Sineth
 */
public interface LecturerDAO {
    boolean save(LecturerMngEntity entity) throws Exception;
    boolean update(LecturerMngEntity entity) throws Exception;
    boolean delete(int id) throws Exception;
    List<LecturerMngEntity> getAll() throws Exception;
    List<Integer> getUserIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
}
