package com.DataAccessObject;

import com.Database.JDBCManager;
import com.model.Address;
import com.model.Person;
import com.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO implements DataInterface<Student>{

    public static StudentDAO getInstance(){
        return new StudentDAO();
    }

    @Override
    public int insert(Student student) {
        int kq=-1;
        try {
            Connection connection= JDBCManager.getConnection();

            String sql="INSERT INTO student(name,old,dob,address,gender,className,khoaQuanLy,schoolName,GPA)"+
                        " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getOld());
            preparedStatement.setDate(3,student.getDob());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getGender());
            preparedStatement.setString(6,student.getClassName());
            preparedStatement.setString(7,student.getKhoaQuanLy());
            preparedStatement.setString(8,student.getSchoolName());
            preparedStatement.setFloat(9,student.getGPA());

            kq=preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(Student student) {
        int kq=-1;
        try {
            Connection connection= JDBCManager.getConnection();

            String sql="UPDATE student"+
                        " SET"+
                        " name=?"+
                        ", old=?"+
                        ", dob=?"+
                        ", address=?"+
                        ", gender=?"+
                        ", className=?"+
                        ", khoaQuanLy=?"+
                        ", schoolName=?"+
                        ", GPA=?"+
                        " WHERE maSinhVien=?"
                        ;

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getOld());
            preparedStatement.setDate(3,student.getDob());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getGender());
            preparedStatement.setString(6,student.getClassName());
            preparedStatement.setString(7,student.getKhoaQuanLy());
            preparedStatement.setString(8,student.getSchoolName());
            preparedStatement.setFloat(9,student.getGPA());
            preparedStatement.setInt(10,Integer.parseInt(student.getMaSinhVien()));

            kq=preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(Student student) {
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="DELETE from student"+
                    " WHERE maSinhVien=?";

            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getMaSinhVien());

            preparedStatement.executeUpdate();

            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student> students=new ArrayList<>();
        try {
            Connection connection=JDBCManager.getConnection();

            Statement statement=connection.createStatement();

            String str="SELECT *"+
                    " FROM student";

            ResultSet resultSet =statement.executeQuery(str);

            while(resultSet.next()){
                String msv=resultSet.getString("maSinhVien");
                String name=resultSet.getString("name");
                Integer old=resultSet.getInt("old");
                Date date=resultSet.getDate("dob");
                String address=resultSet.getString("address");
                String gender=resultSet.getString("gender");
                String className=resultSet.getString("className");
                String khoa=resultSet.getString("khoaQuanLy");
                String school=resultSet.getString("schoolName");
                Float GPA=resultSet.getFloat("GPA");

                Person student=new Student(name,old,date,address,gender,msv,className,khoa,school,GPA);
                students.add((Student) student);
            }
            JDBCManager.closeConnection(connection);
            return students;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Student selectById(Student student) {
        try {
            Connection connection=JDBCManager.getConnection();


            String str="SELECT *" +
                    " FROM student"+
                    " WHERE maSinhVien=?";

            PreparedStatement statement=connection.prepareStatement(str);
            statement.setInt(1, Integer.parseInt(student.getMaSinhVien()));
            ResultSet resultSet =statement.executeQuery();

            while(resultSet.next()){
                String msv=resultSet.getString("maSinhVien");
                String name=resultSet.getString("name");
                Integer old=resultSet.getInt("old");
                Date date=resultSet.getDate("dob");
                 String address=resultSet.getString("address");
                String gender=resultSet.getString("gender");
                String className=resultSet.getString("className");
                String khoa=resultSet.getString("khoaQuanLy");
                String school=resultSet.getString("schoolName");
                Float GPA=resultSet.getFloat("GPA");

                Person newStudent=new Student(name,old,date,address,gender,msv,className,khoa,school,GPA);
                return (Student) newStudent;
            }
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void insertAll(ArrayList<Student> students){
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="INSERT INTO student(name,old,dob,address,gender,className,khoaQuanLy,schoolName,GPA)"+
                    " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            for(Student student:students){
                preparedStatement.setString(1,student.getName());
                preparedStatement.setInt(2,student.getOld());
                preparedStatement.setDate(3,student.getDob());
                preparedStatement.setString(4,student.getAddress());
                preparedStatement.setString(5,student.getGender());
                preparedStatement.setString(6,student.getClassName());
                preparedStatement.setString(7,student.getKhoaQuanLy());
                preparedStatement.setString(8,student.getSchoolName());
                preparedStatement.setFloat(9,student.getGPA());
            }

            preparedStatement.executeUpdate();

            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
