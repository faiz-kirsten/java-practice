import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> queue = new ArrayList<>();
        PriorityQueuePrivate priorityQueue = new PriorityQueuePrivate(queue);

        priorityQueue.offer("Jill");
        priorityQueue.offer("Faiz");
        priorityQueue.offer("Pat");
        priorityQueue.offer("Sally");
        priorityQueue.offer("Kylie");

        System.out.println("============= Size of Queue =============");
        System.out.println(priorityQueue.size());

        System.out.println("============= Current Queue =============");
        priorityQueue.displayQueue();

        System.out.println("============= Removing Head Of queue for each iteration =============");
        priorityQueue.sort();
        while (priorityQueue.size() > 0) {
            priorityQueue.remove();
        }
    }
}