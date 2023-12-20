
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            selectionOperations();
            String namberOperations = scanner.nextLine();
            if ("0".equals(namberOperations))
                break;

            switch (namberOperations) {
                case "1":
                    System.out.print("Введите название задачи: ");
                    String task = scanner.nextLine();
                    list.add(task);
                    System.out.println("Добавлено!\n");
                    listTasks();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    System.out.print("Введите номер для удаления: ");
                    try {
                        int namberDelete = Integer.parseInt(scanner.nextLine());
                        list.remove(namberDelete - 1);
                        System.out.println("Удалено!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Такого номера нет!\n");
                    }
                    listTasks();
                    break;
                case "4":
                    System.out.print("Введите  ключевое слово для удаления задачи: ");
                    String delete = scanner.nextLine();
                    //TODO для задачи 1
//                    List<String> list1 = new ArrayList<>();
//                    for (int i = 0; i < list.size(); i++) {
//                        if (list.get(i).contains(delete)) {
//                            String myList1 = list.get(i);
//                            list1.add(myList1);
//                        }
//                    }
//                    if (list1.isEmpty()){
//                        System.out.println("Такой задачи нет!\n");
//                        break;
//                    }
//                    list.removeAll(list1);
//                    list1.clear();
//                    System.out.println("Удалено! ");
//                    listTasks();
//                    break;
                    //TODO для задачи 2
                    Iterator<String> iter = list.iterator();
                    while (iter.hasNext()) {
                        String nextTask = iter.next();
                        if (nextTask.contains(delete)) {
                            iter.remove();
                        }
                    }
                    listTasks();
                    break;
                default:
                    System.out.println("Такой операции нет, выберите из списка");
                    break;
            }
        }
        System.out.println("Программа завершена!");
    }

    public static void selectionOperations() {
        System.out.println("\n" +
                "Выберите операцию:\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n");
    }

    public static void listTasks() {
        System.out.println("Список запланированных дел: ");
        if (list.isEmpty()) {
            System.out.println(" список пуст ");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}