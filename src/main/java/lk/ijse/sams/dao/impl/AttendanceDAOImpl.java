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
import lk.ijse.sams.Entity.AttendanceMngEntity;
import lk.ijse.sams.Entity.SubjectMngEntity;
import lk.ijse.sams.Entity.dao.AttendanceMngDAO;
import lk.ijse.sams.db.DBConnection;

/**
 *
 * @author Sineth
 */
public class AttendanceDAOImpl implements AttendanceMngDAO{

    @Override
    public boolean saveAttendance(int scheduleId, List<AttendanceMngEntity> list) throws Exception {
        
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "INSERT INTO attendance (sheduling_id, student_id, status, attendance_date) "
                       + "VALUES (?, ?, ?, CURDATE())";

        PreparedStatement pst = conn.prepareStatement(sql);

        for (AttendanceMngEntity row : list) {

            pst.setInt(1, scheduleId);
            pst.setInt(2, row.getStudentId());

            if (row.isPresent()) {
                pst.setString(3, "Present");
            } else if (row.isAbsent()) {
                pst.setString(3, "Absent");
            } else {
                continue;
            }

            pst.addBatch();
        }

        pst.executeBatch();

        return true;
    
    }

    @Override
    public List<AttendanceMngEntity> getStudents(int scheduleId) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql =
                "SELECT s.student_id, s.student_name " +
                "FROM students s " +
                "JOIN sheduling sh ON s.course_id = sh.course_id " +
                "WHERE sh.sheduling_id = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, scheduleId);

        ResultSet rs = pst.executeQuery();

        List<AttendanceMngEntity> list = new ArrayList<>();

        int no = 1;

        while (rs.next()) {

            AttendanceMngEntity entity = new AttendanceMngEntity(
                    no++,
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    false,
                    false
            );

            list.add(entity);
        }

        return list;
    }

    @Override
    public List<Integer> getScheduleIds() throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql = "SELECT sheduling_id FROM sheduling";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Integer> ids = new ArrayList<>();

        while (rs.next()) {
            ids.add(rs.getInt("sheduling_id"));
        }

        return ids;
        }
}
