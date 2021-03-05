package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.File;

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

    @FXML
    private Button decryptButton;


    //1 - mod(CBC) and menu(file)
    //2 - mod(ECB) and menu(text)
    private int checkMenu;
    private int checkMod;
    DesCrypt dc = new DesCrypt();
    FileChooserCreaterAndSel fl = new FileChooserCreaterAndSel();
    private String url;

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
        DirectoryChooser file = new DirectoryChooser();
        File fl = file.showDialog(null);
        this.url = fl.toString();
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

    String text;
    String textcrypt = "hello";

    @FXML
    void encryptButtonClick(ActionEvent event) throws Exception {
      try{
        if(checkMenu == 1){

        }else if(checkMenu == 2){

            fl.creteFile(url,dc.encrypt(KeyTextField.getText(),CriptTextArea.getText(),checkMod),fileName.getText());
            System.out.println(url);
            System.out.println(dc.encrypt(KeyTextField.getText(),CriptTextArea.getText(),checkMod));
        }else{
            throw new Exception("Unselected Menu (File/Text)");
        }
      }catch (Exception exc){
          JOptionPane.showMessageDialog(null,exc.getMessage());
      }
    }

    @FXML
    void decryptButtonClick(ActionEvent event) {
        try {
            if(checkMenu == 1){

            } else if(checkMenu == 2){

            } else{
                throw new Exception("Unselected Menu (File/Text)");
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
}
