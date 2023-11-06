package com.Test;

import com.DataAccessObject.StudentDAO;
import com.DataAccessObject.TeacherDAO;
import com.model.Student;
import com.model.Teacher;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentTest {
    public static void main(String[] args) {
        Date sqlDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse("2004-02-01");
            sqlDate = new Date(utilDate.getTime());
            System.out.println("sqlDate: " + sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Teacher teacher=new Teacher("Le Hong Anh",28,sqlDate,"Hai Duong","Nam","KTPM01");
        teacher.setMaGiaoVien("10");
        System.out.println(TeacherDAO.getInstance().selectById(teacher));
    }
}
