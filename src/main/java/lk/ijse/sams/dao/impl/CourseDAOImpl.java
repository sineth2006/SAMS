/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.CourseMngEntity;
import lk.ijse.sams.Entity.dao.CourseDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class CourseDAOImpl implements CourseDAO{

    @Override
    public boolean save(CourseMngEntity c) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO courses VALUES (?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, c.getCourseId());
        stm.setString(2, c.getCourseName());
        stm.setString(3, c.getDuration());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(CourseMngEntity c) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "UPDATE courses SET course_name=?, duration=? WHERE course_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setString(1, c.getCourseName());
        stm.setString(2, c.getDuration());
        stm.setInt(3, c.getCourseId());

        return stm.executeUpdate() > 0;
    
    }

    @Override
    public boolean delete(int id) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "DELETE FROM courses WHERE course_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public List<CourseMngEntity> getAll() throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM courses";
        PreparedStatement stm = conn.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        List<CourseMngEntity> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new CourseMngEntity(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getString("duration")
            ));
        }

        return list;
    }
    
}
