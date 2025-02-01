

public class Main {
    public static void main(String[] args) {

        Task_Manager TM = new Task_Manager();
        if(args[0].equals("list") && args.length == 1)
        {
            TM.list_view();
        }
        else if(args[0].equals("add") && args.length == 2)
        {
            TM.add(args[1]);
        }
        else if(args[0].equals("update") && args.length == 3)
        {
            try {
                int id = Integer.parseInt(args[1]);
                TM.update(id,args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument '" + args[1] + "' is not a valid number.");
            }
        }
        else if(args[0].equals("delete") && args.length == 2)
        {
            try {
                int id = Integer.parseInt(args[1]);
                TM.delete(id);
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument '" + args[1] + "' is not a valid number.");
            }
        }
        else if(args[0].equals("mark-in-progress") && args.length == 2)
        {
            try {
                int id = Integer.parseInt(args[1]);
                TM.mark_in_progress(id);
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument '" + args[1] + "' is not a valid number.");
            }
        }
        else if(args[0].equals("mark-done") && args.length == 2)
        {
            try {
                int id = Integer.parseInt(args[1]);
                TM.mark_done(id);
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument '" + args[1] + "' is not a valid number.");
            }
        }
        else if(args[0].equals("list") && args.length == 2)
        {
            switch (args[1]) {
                case "done" -> TM.list_view_condition(Status.DONE);
                case "todo" -> TM.list_view_condition(Status.TODO);
                case "in-progress" -> TM.list_view_condition(Status.IN_PROGRESS);
                default -> System.out.println("Error: Invalid status '" + args[1] + "'. Please use 'done', 'todo', or 'in-progress'.");
            }
        }
        else System.out.println("Error!!! Please enter a valid command");
        TM.storeTasks();
    }
}