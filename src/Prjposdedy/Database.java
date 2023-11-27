    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Prjposdedy;

    import java.sql.*;
    /**
     *
     * @author Lenovo
     */
    public class Database {
        Connection con;
        private final String driver="com.mysql.jdbc.Driver";
        private final String url="jdbc:mysql://localhost/pos_dedy";
        private final String user="root";
        private final String pwd="";
        
        public void koneksi(){
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pwd);
                System.out.println("Koneksi Berhasil");
            } catch (ClassNotFoundException e) {
                System.out.println("Error:\nKoneksi Gagal\n"+e.getMessage());
            } catch (SQLException e){
                System.out.println("Error:\nKoneksi Gagal\n"+e.getMessage());
            }
        }
        
        public ResultSet ambildata(String SQL){
            try {
                Statement st=con.createStatement();
                return st.executeQuery(SQL);
            } catch (Exception e) {
                System.out.println("Error:\nPengecekan data gagal\n");
                return null;
            }
        }
        
        public void aksi(String SQL){
            try {
                Statement st=con.createStatement();
                st.executeUpdate(SQL);
            } catch (SQLException e) {
                System.out.println("Error:\nAksi data gagal\n");
                System.out.println(e.getMessage());
            }
        }
        
        
        public static void main(String[] args) {
            Database db=new Database();
            db.koneksi();
        }
        
        
    }
