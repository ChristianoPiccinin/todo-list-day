package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button BtAdd;

    @FXML
    private TextField txtAdd;

    @FXML
    private ListView<String> listBoxMain;


    final ObservableList<String> listItems = FXCollections.observableArrayList();

    @FXML
    private void addAction(ActionEvent action) {

        // se o campo for preenchido
        if (!txtAdd.getText().equals("")){
            listItems.add(txtAdd.getText());
            System.out.println(listItems);

            txtAdd.setText("");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //listBoxMain.setItems(listItems);

    }
}
