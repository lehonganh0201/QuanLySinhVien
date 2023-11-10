package com.DataAccessObject;

import com.Database.JDBCManager;
import com.model.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherDAO implements DataInterface<Teacher> {

    public static TeacherDAO getInstance(){
        return new TeacherDAO();
    }

    @Override
    public int insert(Teacher teacher) {
        int kq=-1;
        try {
            Connection connection= JDBCManager.getConnection();

            String sql="INSERT INTO teacher(name,old,dob,address,gender,lopQuanLy)"+
                    " VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setInt(2,teacher.getOld());
            preparedStatement.setDate(3,teacher.getDob());
            preparedStatement.setString(4,teacher.getAddress());
            preparedStatement.setString(5,teacher.getGender());
            preparedStatement.setString(6,teacher.getLopQuanLy());

            kq=preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(Teacher teacher) {
        int kq=-1;
        try {
            Connection connection= JDBCManager.getConnection();

            String sql="UPDATE teacher"+
                    " SET"+
                    " name=?"+
                    ", old=?"+
                    ", dob=?"+
                    ", address=?"+
                    ", gender=?"+
                    ", lopQuanLy=?"+
                    " WHERE maGiaoVien=?"
                    ;

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setInt(2,teacher.getOld());
            preparedStatement.setDate(3,teacher.getDob());
            preparedStatement.setString(4,teacher.getAddress());
            preparedStatement.setString(5,teacher.getGender());
            preparedStatement.setString(6,teacher.getLopQuanLy());
            preparedStatement.setInt(7,Integer.parseInt(teacher.getMaGiaoVien()));

            kq=preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(Teacher teacher) {
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="DELETE from teacher"+
                    " WHERE maGiaoVien=?";

            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setString(1,teacher.getMaGiaoVien());

            preparedStatement.executeUpdate();

            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<Teacher> selectAll() {
        ArrayList<Teacher> teachers=new ArrayList<>();
        try {
            Connection connection=JDBCManager.getConnection();

            Statement statement=connection.createStatement();

            String str="SELECT *" +
                    " FROM teacher";

            ResultSet resultSet =statement.executeQuery(str);

            while(resultSet.next()){
                String mgv=resultSet.getString("maGiaoVien");
                String name=resultSet.getString("name");
                Integer old=resultSet.getInt("old");
                Date date=resultSet.getDate("dob");
                String address=resultSet.getString("address");
                String gender=resultSet.getString("gender");
                String lopQuanLy=resultSet.getString("lopQuanLy");
                Teacher teacher=new Teacher(name,old,date,address,gender,mgv,lopQuanLy);
                teachers.add(teacher);
            }
            JDBCManager.closeConnection(connection);
            return teachers;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Teacher selectById(Teacher teacher) {
        try {
            Connection connection=JDBCManager.getConnection();


            String str="SELECT *" +
                    " FROM teacher"+
                    " WHERE maGiaoVien=?";

            PreparedStatement statement=connection.prepareStatement(str);
            statement.setString(1, String.valueOf(Integer.parseInt(teacher.getMaGiaoVien())));
            ResultSet resultSet =statement.executeQuery();


            while(resultSet.next()){
                String mgv=resultSet.getString("maGiaoVien");
                String name=resultSet.getString("name");
                Integer old=resultSet.getInt("old");
                Date date=resultSet.getDate("dob");
                String address=resultSet.getString("address");
                String gender=resultSet.getString("gender");
                String lopQuanLy=resultSet.getString("lopQuanLy");

                Teacher teacher1=new Teacher(name,old,date,address,gender,mgv,lopQuanLy);

                return teacher1;
            }
            JDBCManager.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
