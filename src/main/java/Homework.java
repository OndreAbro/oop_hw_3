import java.util.ArrayList;
import java.util.List;

public class Homework {

    /**
     * Создать класс Контейнер - Container.
     * В контейнере могут быть ящики (класс Box).
     *
     * У каждого ящика есть вес.
     * У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков, которые находятся в контейнере.
     *
     * 1. Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше контейнер).
     * 2. Класс ContainerCountComparator - Comparator, который сравнивает контейнеры по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
     * 3. Класс контейнер должен быть Iterable - итерирование должно происходить по ящикам внутри контейнера.
     * <code>
     *     Container c = new Container(...);
     *     // ...
     *     for (Box box: c) {
     *         box - это контейнер
     *     }
     * </code>
     */

    public static void main(String[] args) {

        Box box1 = new Box(123);
        Box box2 = new Box(13);
        Box box3 = new Box(120);
        Box box4 = new Box(23);
        Box box5 = new Box(320);

        Container container1 = new Container();
        Container container2 = new Container();
        Container container3 = new Container();
        Container container4 = new Container();
        Container container5 = new Container();

        container1.addBox(box1);
        container1.addBox(box2);

        container2.addBox(box2);
        container2.addBox(box3);
        container2.addBox(box4);

        container3.addBox(box1);
        container3.addBox(box3);

        container5.addBox(box5);

        System.out.println(container1.getWeight());
        System.out.println(container2.getWeight());
        System.out.println(container3.getWeight());
        System.out.println(container4.getWeight());
        System.out.println(container5.getWeight());

        System.out.println(container1.compareTo(container2));
        System.out.println(container2.compareTo(container3));
        System.out.println(container3.compareTo(container4));
        System.out.println(container4.compareTo(container5));

        List<Container> storage = new ArrayList<>();
        storage.add(container1);
        storage.add(container2);
        storage.add(container3);
        storage.add(container4);
        storage.add(container5);

        System.out.println(storage);
        storage.sort(new ContainerCountComparator());
        System.out.println(storage);

        for (Box box: container2) {
            int index = container2.indexOf(box) + 1;
            System.out.println("Вес " + index + "-го ящика: " + box.weight);
        }
    }
}