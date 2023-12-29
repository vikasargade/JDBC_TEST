package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImplmentaion implements Service {


    static Connection conn;

    static{

        String url = "jdbc:mysql://localhost:3306/moivedb";
        String userName = "root";
        String password = "tiger";

        try {
            conn = DriverManager.getConnection(url,userName,password);


        } catch (SQLException e) {
            System.out.println("PROBLEM OCCURED IN CONNECTION");
            System.exit(1);
        }
    }
    @Override
    public int filmDetails(Film film) {

        String insertQuery = "INSERT INTO MOIVE_INFO(fName,fYear,fLang,fRating)" + " values(?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,film.getFilmName());
            pstmt.setInt(2,film.getFilmYear());
            pstmt.setString(3,film.getFilmLang());
            pstmt.setInt(4,film.getFilmRating());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("UNABLE TO INSERT DATA");
        }

        return 0;
    }

    @Override
    public int updateDetails(int fYear, String fName) {

        String updateQuery = "UPDATE moive_info SET fYear = "+fYear+" WHERE fName = '"+fName+"';";

        try {
            Statement stmt = conn.createStatement();
             return stmt.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println("UNABLE TO UPDATE DETAILS");
        }


        return 0;
    }

    @Override
    public List<Film> displayDetails() {
        String displayAll = "SELECT * FROM MOIVE_INFO ORDER BY fRating desc ";
        List<Film> moiveAll = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(displayAll);

            while (rs.next())
            {

                String fName = rs.getString(2);
                int fYear = rs.getInt(3);
                String fLang = rs.getString(4);
                int fRating = rs.getInt(5);

                Film film = new Film(fName,fYear,fLang,fRating);
                film.setFilmId(rs.getInt(1));
                moiveAll.add(film);
            }

        } catch (SQLException e) {
            System.out.println("UNABLE TO DISPLAY DATA");
        }
        return moiveAll;
    }

    @Override
    public List<Film> top5Film() {
        String displayAll = "SELECT * FROM MOIVE_INFO ORDER BY fRating desc limit 5";
        List<Film> moiveAll = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(displayAll);

            while (rs.next())
            {

                String fName = rs.getString(2);
                int fYear = rs.getInt(3);
                String fLang = rs.getString(4);
                int fRating = rs.getInt(5);

                Film film = new Film(fName,fYear,fLang,fRating);
                film.setFilmId(rs.getInt(1));
                moiveAll.add(film);
            }

        } catch (SQLException e) {
            System.out.println("UNABLE TO DISPLAY DATA");
        }
        return moiveAll;

    }
}
