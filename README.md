# **Task-Tracker-cli**
It's a simple command-line interface application help you to track, organize, and manage your tasks directly from the terminal. Built in Java, this CLI app lets you add, update, delete, and categorize tasks by status(TODO/IN_PROGRESS/DONE), with all data stored in a readable JSON file for persistence.
  -Solution to the backend project from [roadmap.sh]([https://google.com](https://roadmap.sh/projects/task-tracker)).

## Prerequisites
- install Java 19+ on your system.

## How to install
-Clone repo `git clone https://github.com/3LOLOo/Task-Tracker-cli.git`

## Compile
-`javac -cp "lib/*" src/main/java/*.java`

## Run & Usage
-Adding a new task : `.\task-cli add <description>`

-Update task : `.\task-cli update <id> <description>`

-Delete task : `.\task-cli delete <id>`

-Marking a task as in progress or done :
  `.\task-cli mark-in-progress <id>`
  `.\task-cli mark-done <id>`
  
-Listing all tasks `.\task-cli list`

- Listing tasks by status :
  `.\task-cli list done`
  `.\task-cli list todo`
  `.\task-cli list in-progress`

  ### Examples
  + `.\task-cli add "Buy groceries"`
  + `.\task-cli update 1 "Buy groceries and cook dinner"`
  + `.\task-cli mark-done 2`


## **JSON File Example**
```json
[
  {
    "id": 1,
    "description": "Write project documentation",
    "status": "DONE",
    "createdAt": "01-06-2024 09:15:30",
    "updatedAt": "01-06-2024 12:00:00"
  }
]
