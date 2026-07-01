/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.LecturerMngEntity;
import lk.ijse.sams.Entity.dao.LecturerDAO;
import lk.ijse.sams.bo.LecturerBO;
import lk.ijse.sams.dao.impl.LecturerDAOImpl;
import lk.ijse.sams.dto.LecturerDTO;

/**
 *
 * @author Sineth
 */
public class LecturerBOImpl implements LecturerBO {
    
    private LecturerDAO lecturerDAO = new LecturerDAOImpl();
    
    @Override
    public boolean addLecturer(LecturerDTO dto) throws Exception {
        LecturerMngEntity entity = new LecturerMngEntity(
                dto.getLecturerId(),
                dto.getLecturerName(),
                dto.getEmail(),
                dto.getTelNo(),
                dto.getUserId(),
                dto.getSubjectId()
        );

        return lecturerDAO.save(entity);
    
}

    @Override
    public boolean updateLecturer(LecturerDTO dto) throws Exception {
        LecturerMngEntity entity = new LecturerMngEntity(
                dto.getLecturerId(),
                dto.getLecturerName(),
                dto.getEmail(),
                dto.getTelNo(),
                dto.getUserId(),
                dto.getSubjectId()
        );

        return lecturerDAO.update(entity);        
    }

    @Override
    public boolean deleteLectuer(int id) throws Exception {
        return lecturerDAO.delete(id);
    }

    @Override
    public List<LecturerDTO> getAllLecturers() throws Exception {
                   List<LecturerMngEntity> entityList = lecturerDAO.getAll();

           List<LecturerDTO> dtoList = new ArrayList<>();

           for (LecturerMngEntity e : entityList) {
           dtoList.add(new LecturerDTO(
                e.getLecturerId(),
                e.getLecturerName(),
                e.getEmail(),
                e.getTelNo(),
                e.getUserId(),
                e.getSubjectId())
           ); 
                }
                return dtoList;
    
    }

    @Override
    public List<Integer> getUserIds() throws Exception {
    return lecturerDAO.getUserIds();        
    }

    @Override
    public List<Integer> getSubjectIds() throws Exception {
    return lecturerDAO.getSubjectIds();   
    }
    
}
