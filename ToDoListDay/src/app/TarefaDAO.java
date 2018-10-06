package app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TarefaDAO extends ConnectionFactory{


    public void novaTarefa(Tarefa tarefa){
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert lista_tarefas(descricao) values(?)");
            stmt.setString(1, tarefa.getTarefa());

            stmt.execute();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public void deletarTarefa(Tarefa tarefa){
        try{

            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement stmt = connection.prepareStatement("delete from lista_tarefas where idTarefa = ?");
            stmt.setInt(1, tarefa.getIdTarefa());
            stmt.execute();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}



