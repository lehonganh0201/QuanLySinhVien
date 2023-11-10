package com.Test;

import com.DataAccessObject.KhoaDAO;
import com.DataAccessObject.LopDAO;
import com.DataAccessObject.StudentDAO;
import com.DataAccessObject.TeacherDAO;
import com.model.Khoa;
import com.model.Lop;
import com.model.Student;
import com.model.Teacher;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentTest {
    public static void main(String[] args) {
//        Date sqlDate = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date utilDate = sdf.parse("2004-02-01");
//            sqlDate = new Date(utilDate.getTime());
//            System.out.println("sqlDate: " + sqlDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Lop lop=new Lop("Marketing",60,2);
        LopDAO.getInstance().insert(lop);
    }
}
