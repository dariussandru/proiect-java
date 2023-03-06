package com.example.mergiterog.repository.dbrepo;

import com.example.mergiterog.domain.Friendship;

import java.security.PublicKey;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class FriendshipDbRepository {
    private final String url = "jdbc:postgresql://localhost:5432/socialnetworktopi";
    private final String username = "postgres";
    private final String password = "postgres";

    private  static FriendshipDbRepository instance = null;
    private FriendshipDbRepository(){}

    public static FriendshipDbRepository getInstance(){
        if (instance == null) {
            instance = new FriendshipDbRepository();
        }
        return instance;
    }

    public List<Friendship> findAll()
    {
        List<Friendship> friendships = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement statement = connection.prepareStatement("SELECT * from friendship");
            ResultSet resultSet = statement.executeQuery())
        {
            while (resultSet.next())
            {
                int id = (int) resultSet.getLong("id");
                int id_user1 = resultSet.getInt("id_user1");
                int id_user2 = resultSet.getInt("id_user2");
                String status = resultSet.getString("status");
                String date = resultSet.getString("data");

                Friendship friendship = new Friendship(id,id_user1,id_user2,status,date);
                friendship.setId(id);
                friendships.add(friendship);
            }
            return friendships;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return friendships;
    }

    public Optional<Friendship> save(Friendship endity)
    {
        String sql = "insert into friendship (id,id_user1,id_user2,status,data) values(?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1,endity.getId());
            ps.setInt(2,endity.getIdUser1());
            ps.setInt(3,endity.getIdUser2());
            ps.setString(4,endity.getStatus());
            ps.setString(5, endity.getDate());
            ps.executeUpdate();
        }

        catch (SQLException e)
        {
            return Optional.ofNullable(endity);
        }
        return Optional.empty();

    }

}
