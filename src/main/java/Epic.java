public class Epic extends Task {
    String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }


    //переопределим matches
    @Override
    public boolean matches(String query) {
        for (String foo : subtasks) {
            if (foo.contains(query)) {
                return true;
            }
        }

        return false;
    }


}
