package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

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

    @FXML
    private TextField selectFolderTextField;

    @FXML
    private Button selectFolderButton;

    @FXML
    private TextField uploadFileTextField;


    //1 - mod(CBC) and menu(file)
    //2 - mod(ECB) and menu(text)
    private int checkMenu;
    private int checkMod;
    DesCrypt dc = new DesCrypt();
    FileChooserCreaterAndSel fl = new FileChooserCreaterAndSel();
    private String urlCrypt;
    private String urlDecrypt;

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
        FileChooser fl = new FileChooser();
        File selFile = fl.showOpenDialog(null);
        this.urlDecrypt = selFile.toString();
        uploadFileTextField.setText(selFile.toString());
    }

    @FXML
    void selectFolderButtonAction(ActionEvent event) {
        DirectoryChooser file = new DirectoryChooser();
        File fl = file.showDialog(null);
        this.urlCrypt = fl.toString();
        selectFolderTextField.setText(fl.toString());
    }



    @FXML
    void fileCheckButtonOnClick(ActionEvent event) {
        textCheckButton.setSelected(false);
        checkMenu = 1;
    }

    @FXML
    void textChekButtonOnClick(ActionEvent event) {
        fileChekButton.setSelected(false);
        this.urlDecrypt = null;
        uploadFileTextField.setText(null);
        checkMenu = 2;
    }

    String text;
    String textcrypt = "hello wor";

    @FXML
    void encryptButtonClick(ActionEvent event) throws Exception {

        try{
            if(KeyTextField.getText().length() == 8){
                 if(checkMenu == 1){
                     String text = fl.readTextFile(urlDecrypt);
                     fl.creteFile(urlCrypt,dc.encrypt(KeyTextField.getText(),text,checkMod),fileName.getText());
                     JOptionPane.showMessageDialog(null,"Check your " + urlCrypt);
                 }else if(checkMenu == 2){
                     fl.creteFile(urlCrypt,dc.encrypt(KeyTextField.getText(),CriptTextArea.getText(),checkMod),fileName.getText());
                     JOptionPane.showMessageDialog(null,"Check your " + urlCrypt);
                  }else {
                     throw new Exception("Unselected Menu (File/Text)");
                 }
            }else{
                throw new Exception("The key must be 8 characters long!");
            }
      }catch (Exception exc){
          JOptionPane.showMessageDialog(null,exc.getMessage());
      }
    }

    @FXML
    void decryptButtonClick(ActionEvent event) {
        try {
            if(KeyTextField.getText().length() == 8) {
                if (checkMenu == 1) {
                    String text = fl.readTextFile(urlDecrypt);
                        fl.creteFile(urlCrypt, dc.decrypt(KeyTextField.getText(), text, checkMod), fileName.getText());
                        JOptionPane.showMessageDialog(null, "Check your " + urlCrypt);
                } else if (checkMenu == 2) {
                    fl.creteFile(urlCrypt, dc.decrypt(KeyTextField.getText(), CriptTextArea.getText(), checkMod), fileName.getText());
                    JOptionPane.showMessageDialog(null, "Check your " + urlCrypt);
                } else {
                    throw new Exception("Unselected Menu (File/Text)");
                }
            }else{
                throw new Exception("The key must be 8 characters long!");
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
}
