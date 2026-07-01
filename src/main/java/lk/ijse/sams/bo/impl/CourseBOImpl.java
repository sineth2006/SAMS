/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.CourseMngEntity;
import lk.ijse.sams.Entity.dao.CourseDAO;
import lk.ijse.sams.bo.CourseBO;
import lk.ijse.sams.dao.impl.CourseDAOImpl;
import lk.ijse.sams.dto.CourseDTO;

/**
 *
 * @author Sineth
 */
public class CourseBOImpl implements CourseBO{
    private CourseDAO courseDAO = new CourseDAOImpl();
    @Override
    public boolean addCourse(CourseDTO dto) throws Exception {
                CourseMngEntity entity = new CourseMngEntity(
                dto.getCourseId(),
                dto.getCourseName(),
                dto.getDuration()
        );

        return courseDAO.save(entity);
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        CourseMngEntity entity = new CourseMngEntity(
                dto.getCourseId(),
                dto.getCourseName(),
                dto.getDuration()
        );

        return courseDAO.update(entity);
    }

    @Override
    public boolean deleteCourse(int id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        List<CourseMngEntity> entityList = courseDAO.getAll();
        List<CourseDTO> dtoList = new ArrayList<>();

        for (CourseMngEntity e : entityList) {
            dtoList.add(new CourseDTO(
                    e.getCourseId(),
                    e.getCourseName(),
                    e.getDuration()
            ));
        }
    return dtoList;
    }
  
}
