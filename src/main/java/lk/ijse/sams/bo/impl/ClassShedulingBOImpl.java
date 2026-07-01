/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.ClassShedulingEntity;
import lk.ijse.sams.Entity.dao.ClassShedulingDAO;
import lk.ijse.sams.bo.ClassShedulingBO;
import lk.ijse.sams.dao.impl.ClassShedulingDAOImpl;
import lk.ijse.sams.dto.ClassShedulingDTO;

/**
 *
 * @author Sineth
 */
public class ClassShedulingBOImpl implements ClassShedulingBO{

     private ClassShedulingDAO shedulingDAO = new ClassShedulingDAOImpl();
    
    @Override
    public boolean addSchedule(ClassShedulingDTO dto) throws Exception {
                ClassShedulingEntity entity = new ClassShedulingEntity(
                        dto.getShedulingId(),
                        dto.getCourseId(),
                        dto.getSubjectId(),
                        dto.getLecturerId(),
                        dto.getDate(),
                        dto.getTime(),
                        dto.getClassNo()
        );

        return shedulingDAO.save(entity);
    }

    @Override
    public boolean deleteSchedule(int id) throws Exception {
    return shedulingDAO.delete(id);
    }

    @Override
    public List<ClassShedulingDTO> getAllSchedules() throws Exception {
        List<ClassShedulingEntity> entityList = shedulingDAO.getAll();

         List<ClassShedulingDTO> dtoList = new ArrayList<>();

        for (ClassShedulingEntity e : entityList) {

            dtoList.add(new ClassShedulingDTO(
                        e.getShedulingId(),
                        e.getCourseId(),
                        e.getSubjectId(),
                        e.getLecturerId(),
                        e.getDate(),
                        e.getTime(),
                        e.getClassNo()
            ));
        }

        return dtoList;
    }

    @Override
    public List<Integer> getCourseIds() throws Exception {
    return shedulingDAO.getCourseIds();
    }

    @Override
    public List<Integer> getSubjectIds() throws Exception {
    return shedulingDAO.getSubjectIds();
    }

    @Override
    public List<Integer> getLecturerIds() throws Exception {
    return shedulingDAO.getLecturerIds();
    }
    
}
