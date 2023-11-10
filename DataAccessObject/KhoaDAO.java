package com.DataAccessObject;

import com.Database.JDBCManager;
import com.model.Khoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhoaDAO implements DataInterface<Khoa>{

    public static KhoaDAO getInstance(){
        return new KhoaDAO();
    }

    @Override
    public int insert(Khoa khoa) {
        int k=-1;
        try{
            Connection connection= JDBCManager.getConnection();

            String sql="INSERT INTO khoa(tenKHoa,soLuongPhongBan)"+" VALUES(?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,khoa.getTenKhoa());
            preparedStatement.setInt(2,khoa.getSoLuongPhongBan());

            k=preparedStatement.executeUpdate();

            JDBCManager.closeConnection(connection);
            return k;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public int update(Khoa khoa) {
        int k=-1;
        try{
            Connection connection=JDBCManager.getConnection();

            String sql="UPDATE khoa"+
                        " SET"+
                        " tenKhoa=?"+
                        ", soLuongPhongBan=?"+
                        " WHERE maKhoa=?"
                    ;

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,khoa.getTenKhoa());
            preparedStatement.setInt(2,khoa.getSoLuongPhongBan());
            preparedStatement.setInt(3,khoa.getMaKhoa());

            k=preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
            return k;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public int delete(Khoa khoa) {
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="DELETE FROM khoa"+
                        " WHERE maKhoa=?";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,khoa.getMaKhoa());

            preparedStatement.executeUpdate();

            JDBCManager.closeConnection(connection);

            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Khoa> selectAll() {
        ArrayList<Khoa> khoas=new ArrayList<>();
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="SELECT * FROM khoa";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int maKhoa=resultSet.getInt("maKhoa");
                String tenKhoa=resultSet.getString("tenKhoa");
                int soLuongPhongBan=resultSet.getInt("soLuongPhongBan");

                Khoa khoa=new Khoa(maKhoa,tenKhoa,soLuongPhongBan);
                khoas.add(khoa);
            }
            JDBCManager.closeConnection(connection);
            return khoas;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Khoa selectById(Khoa khoa) {
        try {
            Connection connection=JDBCManager.getConnection();

            String sql="SELECT * FROM khoa WHERE maKhoa=?";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,khoa.getMaKhoa());


            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int maKhoa=resultSet.getInt("maKhoa");
                String tenKhoa=resultSet.getString("tenKhoa");
                int soLuongPhongBan=resultSet.getInt("soLuongPhongBan");

                return new Khoa(maKhoa,tenKhoa,soLuongPhongBan);
            }
            JDBCManager.closeConnection(connection);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new Khoa();
    }
}
