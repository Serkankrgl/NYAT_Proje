package DataBase;

import Main.User;

import java.sql.*;

public class DbContext {
    static String url = "jdbc:postgresql://localhost:5432/NYAT";
    static Connection conn = null;
    //db connection
    public static void Connect(){
        try {
            conn = DriverManager.getConnection(url,"postgres","26Ser737");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void Disconnect(){
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void CreateUser(User user){
        try{
            String Sql ="INSERT INTO \"public\".\"USER\" (\"USERNAME\",\"PASSWORD\",\"NAME\",\"SURNAME\",\"LOCATION\", \"ISLOCKED\" ) VALUES(?,?,?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(Sql);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getName());
            statement.setString(4,user.getSurname());
            statement.setString(5,user.getLocation());
            statement.setBoolean(6,user.getIsLocked());
            statement.executeUpdate();
            System.out.println("Kullanıcı Oluşturuldu");
        }catch (SQLException e){
            System.out.println("Kullanıcı Oluşturulamadı");
            e.printStackTrace();
        }
    }
//insert example
    public static User CheckUser(String UserName, String Password){
        try {
            String Sql = "select * from \"public\".\"USER\" where \"USERNAME\" = ? and \"PASSWORD\" = ? ";
            PreparedStatement statement = conn.prepareStatement(Sql);
            statement.setString(1,UserName);
            statement.setString(2,Password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.println("Giriş Yapıldı");
                User user = new User.Builder()
                                    .UserName(resultSet.getString("USERNAME"))
                                    .Password(resultSet.getString("PASSWORD"))
                                    .Name(resultSet.getString("NAME"))
                                    .Surname(resultSet.getString("SURNAME"))
                                    .Location(resultSet.getString("LOCATION"))
                                    .ProductNumber(resultSet.getInt("PRODUCTNUMBER"))
                                    .isLocked(resultSet.getBoolean("ISLOCKED"))
                                    .build();
                return user;
            }

            System.out.println("Giriş Yapılamadı Tekrar Deneyiniz");
            return new User();


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Giriş Sırasında Bir Hata Meydana Geldi.");
            return new User();
        }
    }
}
