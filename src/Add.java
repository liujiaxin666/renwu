import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Add {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���쳣");
			e.printStackTrace();
		}
		try {
			Connection kk = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studb", "root", "ll");
			System.out.println("�����ɹ�");
			Statement sta = (Statement) kk.createStatement();
			int n = sta.executeUpdate("insert studb.yonghu value ('�λ۽�','17')");
			System.out.println("���" + n + "��");
			ResultSet cx = (ResultSet) sta
					.executeQuery("SELECT *  FROM studb.yonghu;");
			while (cx.next()) {
				String YongHuname = cx.getString(1);
				int YongHupwd = cx.getInt(2);
				System.out.println( YongHuname + YongHupwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
	} 
}
