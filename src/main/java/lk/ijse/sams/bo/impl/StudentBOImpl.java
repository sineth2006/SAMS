/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.StudentMngEntity;
import lk.ijse.sams.Entity.dao.StudentDAO;
import lk.ijse.sams.bo.StudentBO;
import lk.ijse.sams.dao.impl.StudentDAOImpl;
import lk.ijse.sams.dto.StudentDTO;

/**
 *
 * @author Sineth
 */
public class StudentBOImpl implements StudentBO{
    
    private StudentDAO studentDAO = new StudentDAOImpl();
    
    @Override
    public boolean addStudent(StudentDTO dto) throws Exception {
            StudentMngEntity entity = new StudentMngEntity(
                    dto.getStudentId(),
                    dto.getStudentName(), 
                    dto.getTelNo(), 
                    dto.getEmail(), 
                    dto.getCourseId()); 
            return studentDAO.save(entity);
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
            StudentMngEntity entity = new StudentMngEntity(
                    dto.getStudentId(),
                    dto.getStudentName(), 
                    dto.getTelNo(), 
                    dto.getEmail(), 
                    dto.getCourseId()); 
            return studentDAO.update(entity);
    
    }

    @Override
    public boolean deleteStudent(int id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
           List<StudentMngEntity> entityList = studentDAO.getAll();

           List<StudentDTO> dtoList = new ArrayList<>();

           for (StudentMngEntity e : entityList) {
           dtoList.add(new StudentDTO(
                    e.getStudentId(),
                    e.getStudentName(), 
                    e.getTelNo(), 
                    e.getEmail(), 
                    e.getCourseId())
           ); 
                }
                return dtoList;
    }
    
    @Override
    public List<Integer> getCourseIds() throws Exception {
    return studentDAO.getCourseIds();
}
    
}
