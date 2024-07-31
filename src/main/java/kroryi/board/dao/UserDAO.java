package kroryi.board.dao;

import kroryi.board.dto.User;

import java.sql.SQLException;

public class UserDAO extends JDBConnection {
    public User select(String userid) {
        User user = new User();
        String sql = "select * from User where userid = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }else{
                System.out.println(userid + "사용자가 없습니다");
                userid = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("사용자 조회시 에러발생");
        }
        return user;
    }

    public int insert(User user) {
        int result= 0;
        String sql = "insert into User (userid, username, password) values(?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserid());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            result = pstmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("사용자를 DB에 등록 시 문제 발생");
            e.printStackTrace();
        }

        return result;
    }

    public int update(User user) {
        return 0;
    }
    public int delete(User user) {
        return 0;
    }

}
