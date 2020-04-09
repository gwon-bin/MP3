package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public static DAO ins;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	private DAO() {
	}

	public static DAO getInstance() {
		if (ins == null) {
			ins = new DAO();
		}
		return ins;
	}
	public boolean idcheck(String id) {
			try {
				String sql = "select count(*) cnt from loogin where id= ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				rs = pst.executeQuery();

				if (rs.next()) {
					int cnt = rs.getInt("cnt");
					if (cnt > 0) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
}
