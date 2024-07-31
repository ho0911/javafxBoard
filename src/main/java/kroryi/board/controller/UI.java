package kroryi.board.controller;

public enum UI {

    LIST("/kroryi/board/boardlist-view.fxml"),
    INSERT("/kroryi/board/INSERT.fxml"),
    READ("/kroryi/board/READ.fxml"),
    UPDATE("/kroryi/board/UPDATE.fxml"),
    REGISTER("/kroryi/board/REGISTER.fxml"),
    LOGIN("/kroryi/board/LOGIN.fxml");

    private final String path;

    UI(String path) {
        this.path = path;
    }

    public String getpath() {
        return path;
    }
}
