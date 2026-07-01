/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.SubjectMngEntity;
import lk.ijse.sams.Entity.dao.SubjectDAO;
import lk.ijse.sams.bo.SubjectBO;
import lk.ijse.sams.dao.impl.SubjectDAOImpl;
import lk.ijse.sams.dto.SubjectDTO;

/**
 *
 * @author Sineth
 */
public class SubjectBOImpl implements SubjectBO{

    private SubjectDAO subjectDAO = new SubjectDAOImpl();
    
    @Override
    public boolean addSubject(SubjectDTO dto) throws Exception {
            SubjectMngEntity entity = new SubjectMngEntity(
                dto.getSubjectId(),
                dto.getSubjectName(),
                dto.getCourseId()
        );

        return subjectDAO.save(entity);
    
    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws Exception {
                SubjectMngEntity entity = new SubjectMngEntity(
                dto.getSubjectId(),
                dto.getSubjectName(),
                dto.getCourseId()
        );

        return subjectDAO.update(entity);
    }

    @Override
    public boolean deleteSubject(int id) throws Exception {
    return subjectDAO.delete(id);
    }

    @Override
    public List<SubjectDTO> getAllSubjects() throws Exception {
        List<SubjectMngEntity> entityList = subjectDAO.getAll();

        List<SubjectDTO> dtoList = new ArrayList<>();

        for (SubjectMngEntity e : entityList) {

            dtoList.add(new SubjectDTO(
                    e.getSubjectId(),
                    e.getSubjectName(),
                    e.getCourseId()
            ));
        }

        return dtoList;
    }

    @Override
    public List<Integer> getCourseIds() throws Exception {
        return subjectDAO.getCourseIds();
    }
    
}
