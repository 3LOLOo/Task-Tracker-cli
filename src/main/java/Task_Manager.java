import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Task_Manager {
    ArrayList<Task> tasks ;

    Task_Manager(){
        this.tasks = loadTasks();
    }

    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    File file = new File("tasks.json");

    public ArrayList<Task> loadTasks() {
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(file, new TypeReference<ArrayList<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void storeTasks() {
        try {
            mapper.writeValue(file, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int get_idx(int ID){
        for(int i = 0 ; i < tasks.size() ; i++){
            if(ID == tasks.get(i).getId())return i;
        }
        return -1;
    }
    void add(String desc){
        Task task = new Task(desc);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + task.getId() + ")");
    }
    void update(int id, String desc){
        int idx = get_idx(id);
        if(idx == -1)
        {
            System.out.println("Error: Invalid ID");
            return;
        }
        tasks.get(idx).update_description(desc);
        System.out.println("Task updated successfully (ID: " + tasks.get(idx).getId() + ")");
    }
    void delete(int id){
        int idx = get_idx(id);
        if(idx == -1)
        {
            System.out.println("Error: Invalid ID");
            return;
        }
        tasks.remove(idx);
    }
    void mark_in_progress(int id){
        int idx = get_idx(id);
        if(idx == -1)
        {
            System.out.println("Error: Invalid ID");
            return;
        }
        tasks.get(idx).mark_in_progress();
        System.out.println("Task " + tasks.get(idx).getId() + " marked-in-progress");
    }
    void mark_done(int id){
        int idx = get_idx(id);
        if(idx == -1)
        {
            System.out.println("Error: Invalid ID");
            return;
        }
        tasks.get(idx).mark_done();
        System.out.println("Task " + tasks.get(idx).getId() + " marked-done");
    }
    void list_view(){
        System.out.println("-----------------------TASKS LIST----------------------");

        for (Task T : tasks) {
            T.printTask();
            System.out.println("------------------------------------------------");
        }
    }
    void list_view_condition(Status st){
        System.out.println("---------------------TASKS "+ st +" LIST---------------------");
        for (Task T : tasks) {
            if(st!=T.getStatus())continue;
            T.printTask();
            System.out.println("------------------------------------------------");
        }
    }
}
