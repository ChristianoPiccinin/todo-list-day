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
            System.out.println("----");
            System.out.println(tarefa.getTarefa());
            stmt.execute();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public void deletarTarefa(int tarefa){
        try{

            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement stmt = connection.prepareStatement("delete from lista_tarefas where id = ?");
            stmt.setInt(1, tarefa);
            stmt.execute();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public ArrayList<Tarefa> getTarefa(){
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

        try{

            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement stmt = connection.prepareStatement("select id, descricao from lista_tarefas");

            ResultSet resultSet = stmt.executeQuery();


            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setIdTarefa(resultSet.getInt(1));
                tarefa.setTarefa(resultSet.getString(1));

                tarefas.add(tarefa);

            }


        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return tarefas;
    }




}



