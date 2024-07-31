package kroryi.board.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kroryi.board.dto.Board;
import kroryi.board.service.BoardService;
import kroryi.board.service.BoardServiceImpl;
import kroryi.board.util.SceneUtil;

import java.io.IOException;

public class UpdateController {
    @FXML
    public TextField tfTitle;
    @FXML
    public TextField tfWriter;
    @FXML
    public TextField tfDate;
    @FXML
    public TextArea taContent;

    int boardNo;
    private BoardService boardService = new BoardServiceImpl();

    public void read(int boardNo){
        this.boardNo = boardNo;
        Board board = boardService.select(boardNo);
        System.out.println(board.getTitle());
        tfTitle.setText(board.getTitle());
        tfWriter.setText(board.getWriter());
        taContent.setText(board.getContent());
        tfDate.setText(board.getRegDate());

    }

    public void movetoPrev(ActionEvent event) {
    }

    public void movetoUpdate(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText());
        board.setNo(boardNo);
        int result = boardService.update(board);
        if (result > 0 ) {
            System.out.println("글 수정 완료");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getpath());
        }
    }

    public void movetoList(ActionEvent event) {
    }

    public void movetoNext(ActionEvent event) {
    }

    public void movetoDelete(ActionEvent event) throws IOException {

        showAlert(event);
    }

    private void showAlert(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("게시글 삭제");
        alert.setHeaderText("게시글을 정말 삭제 하시나요?(글번호:" + boardNo +")");
        alert.setContentText("삭제 후 되돌릴 수 없습니다");
        int result = 0;
        if(alert.showAndWait().get() == ButtonType.OK){
            result = boardService.delete(boardNo);
        }
        if(result > 0){
            System.out.println("글삭제 잘됨");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getpath());
        }
    }
}
