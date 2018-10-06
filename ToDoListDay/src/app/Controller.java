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
import java.util.ArrayList;
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
        Tarefa tarefa = new Tarefa();
        TarefaDAO tarefaDAO = new TarefaDAO();
        /*Adicionar itens na lista*/
        /*só deixa inserir na lista, se o campo for diferente de branco*/
        if (!txtAdd.getText().equals("")){
            tarefa.setTarefa(txtAdd.getText());
            tarefaDAO.novaTarefa(tarefa);

            atividadesDaLista.add(txtAdd.getText());


            txtAdd.setText("");
        }
    }


    @FXML
    private void removeItem(ActionEvent action)
        /*
        int itemRemover = listaDeAtividades.getSelectionModel().getSelectedIndex();
        if (itemRemover >= 0) {
            atividadesDaLista.remove(listaDeAtividades.getSelectionModel().getSelectedIndex());
        }
        */
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        listaDeAtividades.setItems(atividadesDaLista);






    }
}
