package kroryi.board;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import kroryi.board.dto.Board;
import kroryi.board.service.BoardService;
import kroryi.board.service.BoardServiceImpl;
import org.jfree.chart.title.Title;

public class BoardApp {
    static BoardService boardService = new BoardServiceImpl();

    public static void main(String[] args) {
        //목록보기
//        for (Board board : boardService.list()) {
//            System.out.println(board.getNo() + " " + board.getTitle() + "" + board.getWriter()+ "" + board.getRegDate());
//
//        }
        //게시글등록
//        Board board = new Board();
//        board.setTitle("세로운 세상!!");
//        board.setWriter("홍길동");
//        board.setContent("날씨 더워요");
//        boardService.insert(board);
        Board boardSelect = boardService.select(24);
        System.out.println("게시판 상세보기");
        System.out.print("글번호:");
        System.out.println(boardSelect.getNo());
        System.out.print("제목:");
        System.out.println(boardSelect.getTitle());
        System.out.print("글쓴이:");
        System.out.println(boardSelect.getWriter());
        System.out.print("등록날짜:");
        System.out.print(boardSelect.getRegDate());
        System.out.print("업데이트날짜:");
        System.out.println(boardSelect.getUpdDate());

        System.out.println("게시판 수정하기");
        boardSelect.setTitle("멍청이");
        boardSelect.setWriter("김판허");
        boardService.update(boardSelect);

        Board boardSelect2 = boardService.select(24);
        System.out.print("글번호:");
        System.out.println(boardSelect.getNo());
        System.out.print("제목:");
        System.out.println(boardSelect.getTitle());
        System.out.print("글쓴이:");
        System.out.println(boardSelect.getWriter());
        System.out.print("등록날짜:");
        System.out.print(boardSelect.getRegDate());
        System.out.print("업데이트날짜:");
        System.out.println(boardSelect.getUpdDate());

        boardService.delete(24);



    }
}