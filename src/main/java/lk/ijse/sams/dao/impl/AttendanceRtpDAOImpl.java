/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.AttendanceRtpEntity;
import lk.ijse.sams.Entity.dao.AttendanceRtpDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class AttendanceRtpDAOImpl implements AttendanceRtpDAO{

    @Override
    public List<AttendanceRtpEntity> getAttendanceReport(int studentId, int subjectId, LocalDate from, LocalDate to) throws Exception {

    Connection conn = DBConnection.getInstance().getConnection();

    String sql =
        "SELECT a.student_id, s.student_name, sub.subject_name, " +
        "a.status, a.attendance_date " +
        "FROM attendance a " +
        "JOIN students s ON a.student_id=s.student_id " +
        "JOIN sheduling sh ON a.sheduling_id=sh.sheduling_id " +
        "JOIN subjects sub ON sh.sublect_id=sub.sublect_id " +
        "WHERE a.student_id=? " +
        "AND sh.sublect_id=? " +
        "AND a.attendance_date BETWEEN ? AND ?";

    PreparedStatement pst = conn.prepareStatement(sql);

    pst.setInt(1, studentId);
    pst.setInt(2, subjectId);
    pst.setDate(3, Date.valueOf(from));
    pst.setDate(4, Date.valueOf(to));

    ResultSet rs = pst.executeQuery();

    List<AttendanceRtpEntity> list = new ArrayList<>();

    while(rs.next()){

        list.add(new AttendanceRtpEntity(

                rs.getInt("student_id"),
                rs.getString("student_name"),
                rs.getString("subject_name"),
                rs.getString("attendance_date"),
                rs.getString("status")
        ));
    }

    return list;
    
    }

    @Override
    public List<Integer> getStudentIds() throws Exception {
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
    public List<Integer> getSubjectIds() throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

    String sql = "SELECT student_id FROM students";
    PreparedStatement pst = conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    List<Integer> ids = new ArrayList<>();

    while (rs.next()) {
        ids.add(rs.getInt("student_id"));
    }

    return ids;
    }
    
}
