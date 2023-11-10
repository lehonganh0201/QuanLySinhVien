package com.DataAccessObject;

import com.Database.JDBCManager;
import com.model.Lop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LopDAO implements DataInterface<Lop> {

    public static LopDAO getInstance(){
        return new LopDAO();
    }

    @Override
    public int insert(Lop lop) {
        int kq = -1;
        try {
            Connection connection = JDBCManager.getConnection();

            String sql = "INSERT INTO lop(tenLop, soLuongHocSinh, maGiaoVien)" +
                    " VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, lop.getTenLop());
            preparedStatement.setInt(2, lop.getSoLuongHocSinh());
            preparedStatement.setInt(3, lop.getMaGiaoVien());

            kq = preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(Lop lop) {
        int kq = -1;
        try {
            Connection connection = JDBCManager.getConnection();

            String sql = "UPDATE lop" +
                    " SET" +
                    " tenLop=?" +
                    ", soLuongHocSinh=?" +
                    ", maGiaoVien=?" +
                    " WHERE maLop=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, lop.getTenLop());
            preparedStatement.setInt(2, lop.getSoLuongHocSinh());
            preparedStatement.setInt(3, lop.getMaGiaoVien());
            preparedStatement.setInt(4, lop.getMaLop());

            kq = preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }


    @Override
    public int delete(Lop lop) {
        int kq = -1;
        try {
            Connection connection = JDBCManager.getConnection();

            String sql = "DELETE FROM lop" +
                    " WHERE maLop=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, lop.getMaLop());

            kq = preparedStatement.executeUpdate();
            JDBCManager.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }


    @Override
    public ArrayList<Lop> selectAll() {
        ArrayList<Lop> lops = new ArrayList<>();
        try {
            Connection connection = JDBCManager.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM lop";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int maLop = resultSet.getInt("maLop");
                String tenLop = resultSet.getString("tenLop");
                int soLuongHocSinh = resultSet.getInt("soLuongHocSinh");
                int maGiaoVien = resultSet.getInt("maGiaoVien");

                Lop lop = new Lop(maLop, tenLop, soLuongHocSinh, maGiaoVien);
                lops.add(lop);
            }

            JDBCManager.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lops;
    }

    @Override
    public Lop selectById(Lop lop) {
        try {
            Connection connection = JDBCManager.getConnection();

            String sql = "SELECT * FROM lop" +
                    " WHERE maLop=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, lop.getMaLop());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int maLop = resultSet.getInt("maLop");
                String tenLop = resultSet.getString("tenLop");
                int soLuongHocSinh = resultSet.getInt("soLuongHocSinh");
                int maGiaoVien = resultSet.getInt("maGiaoVien");

                return new Lop(maLop, tenLop, soLuongHocSinh, maGiaoVien);
            }

            JDBCManager.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
