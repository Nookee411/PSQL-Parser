package readers;

import dao.BDPlayDAO;
import entities.BDPlay;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PlayReader {



    public static List<BDPlay> readPlays() throws SQLException{
        var result = new LinkedList<BDPlay>();
        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5432/theatre";
        Connection connection = DriverManager.getConnection(url, user, password);
        try(PreparedStatement statement = connection.prepareStatement("select * from play")){
            final var resultSet = statement.executeQuery();
            while(resultSet.next()){
             var temp = new BDPlay();
             temp.setTitle(resultSet.getString(1));
             temp.setLink(resultSet.getString(2));
             result.add(temp);
            }

        }finally {
            connection.close();
        }
        return result;
    }



}
