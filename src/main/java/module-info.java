module kroryi.board {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    requires javafx.base;
    requires javafx.swing;
    requires jfreechart;


    opens kroryi.board to javafx.fxml, javafx.base, javafx.graphics;
    opens kroryi.board.controller to javafx.fxml, javfx.base, javafx.controls;
    opens kroryi.board.dto to javafx.base;
    opens kroryi.board.util to javafx.base, javafx.controls,javafx.fxml;
    exports kroryi.board;
}