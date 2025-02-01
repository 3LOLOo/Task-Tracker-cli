import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int ID = 0;
    private final int id;
    private String description;
    private Status status;
    private final String createdAt;
    private String updatedAt;

    DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    Task(String description){
        id = ++ID;
        this.description = description;
        status = Status.TODO;
        createdAt = LocalDateTime.now().format(FormatObj);
        updatedAt = LocalDateTime.now().format(FormatObj);
    }
    @JsonCreator
    public Task(
            @JsonProperty("id") int id,
            @JsonProperty("description") String description,
            @JsonProperty("status") Status status,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("updatedAt") String updatedAt
    ) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        ID = id;
    }

    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public Status getStatus(){
        return status;
    }
    public String getcreatedAt(){
        return createdAt;
    }
    public String getupdatedAt(){
        return updatedAt;
    }
    void update_description(String desc) {
        this.description = desc;
        this.updatedAt = LocalDateTime.now().format(FormatObj);
    }
    void mark_in_progress(){
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now().format(FormatObj);
    }
    void mark_done(){
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now().format(FormatObj);
    }
    public void printTask() {
        System.out.println("ID         : " + id);
        System.out.println("Description: " + description);
        System.out.println("Status     : " + status);
        System.out.println("Created At : " + createdAt);
        System.out.println("Updated At : " + updatedAt);
    }
}
