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
    private Button BtRemove;

    @FXML
    private TextField txtAdd;

    @FXML
    private ListView<String> listaDeAtividades;


    final ObservableList<String> atividadesDaLista = FXCollections.observableArrayList();


    @FXML
    private void adicionaItem(ActionEvent action) {
        /*Adicionar itens na lista*/

        /*só deixa inserir na lista, se o campo for diferente de branco*/
        if (!txtAdd.getText().equals("")){
            atividadesDaLista.add(txtAdd.getText());
            System.out.println(atividadesDaLista);

            txtAdd.setText("");
        }
    }

    @FXML
    private void removeItem(ActionEvent action) {
        /*remover itens da lista*/
        int itemRemover = listaDeAtividades.getSelectionModel().getSelectedIndex();
        if (itemRemover >= 0) {
            atividadesDaLista.remove(listaDeAtividades.getSelectionModel().getSelectedIndex());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDeAtividades.setItems(atividadesDaLista);

    }
}
