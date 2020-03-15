package fzu.gxfj.dao;

import fzu.gxfj.pojo.Admin;
import fzu.gxfj.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {
	public Admin getAdminUser(String account) {
		Admin admin = null;
		String sql = "SELECT * FROM admin WHERE account = " + account + " ; ";

		try (Connection connection = DBUtil.getConnection(); Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("sql");
			resultSet.next();

			admin = new Admin();

			admin.setAccount(resultSet.getString("account"));
			admin.setPassword(resultSet.getString("password"));
			admin.setUserName(resultSet.getString("userName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	//通过管理员账户获取管理员信息，无则返回空
}
