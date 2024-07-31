package kroryi.board.dao;

import javafx.beans.property.SimpleStringProperty;
import kroryi.board.dto.Board;
import kroryi.board.service.BoardService;
import kroryi.board.service.BoardServiceImpl;

import java.sql.*;

public class JDBConnection {

    public Connection con;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javafxboard?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "edurootroot";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결 성공!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB연결 실패");
        }
    }

//    public static void main(String[] args) {
//        JDBConnection jdbc = new JDBConnection();

//        BoardDAO boardDAO = new BoardDAO();
//        boardDAO.selectList();
//        System.out.println(boardDAO.select(6).toString());
//        Board board = new Board(new SimpleStringProperty("뭐하노?333"),
//                new SimpleStringProperty("유유유333"),
//                new SimpleStringProperty("매그래3332"));
//        board.setNo(6);
//        boardDAO.update(board);
//        boardDAO.insert(board);
//        boardDAO.selectList();

//        boardDAO.delete(2);
//        BoardService boardService = new BoardServiceImpl();
//        boardService.list();
//    }


}
