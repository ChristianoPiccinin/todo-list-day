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
    private ListView<Tarefa> listaDeAtividades;

    final ObservableList<Tarefa> atividadesDaLista =  FXCollections.observableArrayList();

    @FXML
    private void adicionaItem(ActionEvent action) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        Tarefa tarefa = new Tarefa();
        if (!txtAdd.getText().equals("")){

            tarefa.setTarefa(txtAdd.getText());
            tarefaDAO.novaTarefa(tarefa);

        }
        txtAdd.setText("");
        populaLista();
    }

    @FXML
    private void removeItem(ActionEvent action){
        TarefaDAO tarefasDAO = new TarefaDAO();

        ArrayList<Tarefa> tarefas ;
        tarefas = retornaTarefas();

        if(listaDeAtividades.getSelectionModel().getSelectedIndex()   > -1 )  {
            tarefasDAO.deletarTarefa(tarefas.get(listaDeAtividades.getSelectionModel().getSelectedIndex()).getIdTarefa());
        }
        populaLista();
    }

    public void populaLista(){
        atividadesDaLista.clear();
        atividadesDaLista.addAll(retornaTarefas());
        listaDeAtividades.setItems(atividadesDaLista);
    }


    public ArrayList<Tarefa> retornaTarefas(){
        TarefaDAO tarefasDAO = new TarefaDAO();

        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        tarefas = tarefasDAO.getTarefa();
       return tarefas;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       populaLista();
    }


}
