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
import lk.ijse.sams.Entity.SubjectMngEntity;
import lk.ijse.sams.Entity.dao.SubjectDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class SubjectDAOImpl implements SubjectDAO{

    @Override
    public boolean save(SubjectMngEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO subjects(sublect_id, subject_name, course_id) VALUES (?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, entity.getSubjectId());
        stm.setString(2, entity.getSubjectName());
        stm.setInt(3, entity.getCourseId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(SubjectMngEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "UPDATE subjects SET sublect_id=?, subject_name=?, course_id=? WHERE sublect_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, entity.getSubjectId());
        stm.setString(2, entity.getSubjectName());
        stm.setInt(3, entity.getCourseId());
        stm.setInt(4, entity.getSubjectId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "DELETE FROM subjects WHERE sublect_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public List<SubjectMngEntity> getAll() throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM subjects";
        PreparedStatement stm = conn.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        List<SubjectMngEntity> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new SubjectMngEntity(
                    rs.getInt("sublect_id"),
                    rs.getString("subject_name"),
                    rs.getInt("course_id")));
            
        }

        return list;
    
    }

    @Override
    public List<Integer> getCourseIds() throws Exception {
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
    
}
