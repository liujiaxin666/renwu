import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Add {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("有异常");
			e.printStackTrace();
		}
		try {
			Connection kk = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studb", "root", "ll");
			System.out.println("创建成功");
			Statement sta = (Statement) kk.createStatement();
			int n = sta.executeUpdate("insert studb.yonghu value ('段慧杰','17')");
			System.out.println("添加" + n + "条");
			ResultSet cx = (ResultSet) sta
					.executeQuery("SELECT *  FROM studb.yonghu;");
			while (cx.next()) {
				String YongHuname = cx.getString(1);
				int YongHupwd = cx.getInt(2);
				System.out.println( YongHuname + YongHupwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建失败");
			e.printStackTrace();
		}
	} 
}
