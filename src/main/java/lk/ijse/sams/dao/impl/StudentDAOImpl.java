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
import lk.ijse.sams.Entity.StudentMngEntity;
import lk.ijse.sams.Entity.dao.StudentDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public boolean save(StudentMngEntity s) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO students(student_id, student_name, tel_no, email, course_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, s.getStudentId());
            stm.setString(2, s.getStudentName());
            stm.setInt(3, s.getTelNo());
            stm.setString(4, s.getEmail());
            stm.setInt(5, s.getCourseId());

        return stm.executeUpdate() > 0;
    
    }

    @Override
    public boolean update(StudentMngEntity s) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "UPDATE students SET student_name=?, tel_no=?, email=?, course_id=? WHERE student_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setString(1, s.getStudentName());
        stm.setInt(2, s.getTelNo());
        stm.setString(3, s.getEmail());
        stm.setInt(4, s.getCourseId());
        stm.setInt(5, s.getStudentId());
            
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "DELETE FROM students WHERE student_id=?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    
    }

    @Override
    public List<StudentMngEntity> getAll() throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM students";
        PreparedStatement stm = conn.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        List<StudentMngEntity> list = new ArrayList<>();
        while (rs.next()) {

            list.add(new StudentMngEntity(
                rs.getInt("student_id"),
                rs.getString("student_name"),
                rs.getInt("tel_no"),
                rs.getString("email"),
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
