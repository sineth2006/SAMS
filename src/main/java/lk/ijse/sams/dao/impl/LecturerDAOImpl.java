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
import lk.ijse.sams.Entity.LecturerMngEntity;
import lk.ijse.sams.Entity.dao.LecturerDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class LecturerDAOImpl implements LecturerDAO{

    @Override
    public boolean save(LecturerMngEntity entity) throws Exception {
        
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO lecturers (lecturer_id, lecturer_name, email, tel_no, user_id, sublect_id) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, entity.getLecturerId());
        stm.setString(2, entity.getLecturerName());
        stm.setString(3, entity.getEmail());
        stm.setString(4, entity.getTelNo());
        stm.setInt(5, entity.getUserId());
        stm.setInt(6, entity.getSubjectId());

        return stm.executeUpdate() > 0;        
    }

    @Override
    public boolean update(LecturerMngEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "UPDATE lecturers SET lecturer_id=?, lecturer_name=?, email=?, tel_no=?, user_id=?, sublect_id=? WHERE lecturer_id=?";

        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, entity.getLecturerId());
        stm.setString(2, entity.getLecturerName());
        stm.setString(3, entity.getEmail());
        stm.setString(4, entity.getTelNo());
        stm.setInt(5, entity.getUserId());
        stm.setInt(6, entity.getSubjectId());
        stm.setInt(7, entity.getLecturerId());

        return stm.executeUpdate() > 0;  
    }

    @Override
    public boolean delete(int id) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "DELETE FROM lecturers WHERE lecturer_id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public List<LecturerMngEntity> getAll() throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM lecturers";
        PreparedStatement stm = conn.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        List<LecturerMngEntity> list = new ArrayList<>();
        while (rs.next()) {

            list.add(new LecturerMngEntity(
                    rs.getInt("lecturer_id"),
                    rs.getString("lecturer_name"),
                    rs.getString("email"),
                    rs.getString("tel_no"),
                    rs.getInt("user_id"),
                    rs.getInt("sublect_id")));
        }

        return list;
    }

    @Override
    public List<Integer> getUserIds() throws Exception {
    Connection conn = DBConnection.getInstance().getConnection();

    String sql = "SELECT user_id FROM users";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    List<Integer> ids = new ArrayList<>();

    while (rs.next()) {
        ids.add(rs.getInt("user_id"));
    }

    return ids;
    
    }

    @Override
    public List<Integer> getSubjectIds() throws Exception {
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
    
}
