import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldMatches() {
//        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
//
//        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
//        Epic epic = new Epic(55, subtasks);
//
//        Meeting meeting = new Meeting(
//                555,
//                "Выкатка 3й версии приложения",
//                "Приложение НетоБанка",
//                "Во вторник после обеда"
//        );
//
//        Todos todos = new Todos();
//
//        todos.add(simpleTask);
//        todos.add(epic);
//        todos.add(meeting);
//
//        todos.search(simpleTask.title);
////        todos.search(epic.subtasks);
//// не могу передать параметр  в todos.search(epic.subtasks);
////        todos.search(meeting.topic);
//
//
//        Task[] expected = {simpleTask};
//        Task[] actual = todos.search(simpleTask.title);
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldSimpleNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void shouldEpicTaskMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Чебурек");

        Assertions.assertFalse(actual);

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void shouldMeetingTopicTaskMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.topic.matches("Выкатка 3й версии приложения");
        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldMeetingProjectTaskMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.project.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);

    }


    @Test
    public void shouldMeetingNotMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.project.matches("Чебурек");

        Assertions.assertFalse(actual);

    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testWhenFewTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("Хлеб");
        Task[] expected = {simpleTask, epic};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenZeroTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("Позвонить");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOneTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("Приложение");
        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, actual);
    }


}