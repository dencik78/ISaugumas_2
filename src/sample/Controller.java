package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    private TextArea CriptTextArea;

    @FXML
    private CheckBox ECB_Mod_checkButton;

    @FXML
    private CheckBox fileChekButton;

    @FXML
    private CheckBox textCheckButton;

    @FXML
    private CheckBox CBC_Mod_checkButton;

    @FXML
    private Button cryptButton;

    @FXML
    private Button uploadButton;

    @FXML
    private TextField fileName;

    @FXML
    private TextField KeyTextField;


    //1 - mod(CBC) and menu(file)
    //2 - mod(ECB) and menu(text)
    private int checkMenu;
    private int checkMod;

    @FXML
    void CBC_Mod_checkButtonOnClick(ActionEvent event) {
        ECB_Mod_checkButton.setSelected(false);
        checkMod = 1;
    }

    @FXML
    void ECB_Mod_checkButtonOnClick(ActionEvent event) {
        CBC_Mod_checkButton.setSelected(false);
        checkMod = 2;
    }

    @FXML
    void uploadButtonClick(ActionEvent event) {

    }

    @FXML
    void fileCheckButtonOnClick(ActionEvent event) {
        textCheckButton.setSelected(false);
        checkMenu = 1;
    }

    @FXML
    void textChekButtonOnClick(ActionEvent event) {
        fileChekButton.setSelected(false);
        checkMenu = 2;
    }


    @FXML
    void cryptButtonClick(ActionEvent event) {

    }

}
