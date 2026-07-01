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
import lk.ijse.sams.Entity.ClassShedulingEntity;
import lk.ijse.sams.Entity.dao.ClassShedulingDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class ClassShedulingDAOImpl implements ClassShedulingDAO{

    @Override
    public boolean save(ClassShedulingEntity entity) throws Exception{
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO sheduling(sheduling_id, course_id, sublect_id, lecturer_id, class_date, class_time, class_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);

                stm.setInt(1, entity.getShedulingId());
                stm.setInt(2, entity.getCourseId());
                stm.setInt(3, entity.getSubjectId());
                stm.setInt(4, entity.getLecturerId());
                stm.setString(5, entity.getDate());
                stm.setString(6, entity.getTime());
                stm.setString(7, entity.getClassNo());


        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception{
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "DELETE FROM sheduling WHERE sheduling_id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public List<ClassShedulingEntity> getAll() throws Exception{
            Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM sheduling";
        PreparedStatement stm = conn.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        List<ClassShedulingEntity> list = new ArrayList<>();
        while (rs.next()) {

            list.add(new ClassShedulingEntity(
                        rs.getInt("sheduling_id"),
                        rs.getInt("course_id"),
                        rs.getInt("sublect_id"),
                        rs.getInt("lecturer_id"),
                        rs.getString("class_date"),
                        rs.getString("class_time"),
                        rs.getString("class_no")));
        }

        return list;
    }

    @Override
    public List<Integer> getCourseIds() throws Exception{
    Connection conn = DBConnection.getInstance().getConnection();

    String sql = "SELECT course_id FROM courses";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    List<Integer> ids = new ArrayList<>();

    while (rs.next()) {
        ids.add(rs.getInt("course_id"));
    }

    return ids;

    }

    @Override
    public List<Integer> getSubjectIds() throws Exception{
    Connection conn = DBConnection.getInstance().getConnection();

    String sql = "SELECT sublect_id FROM subjects";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    List<Integer> ids = new ArrayList<>();

    while (rs.next()) {
        ids.add(rs.getInt("sublect_id"));
    }

    return ids;
    }

    @Override
    public List<Integer> getLecturerIds() throws Exception{
    Connection conn = DBConnection.getInstance().getConnection();

    String sql = "SELECT lecturer_id FROM lecturers";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    List<Integer> ids = new ArrayList<>();

    while (rs.next()) {
        ids.add(rs.getInt("lecturer_id"));
    }

    return ids;
    }
    
}
