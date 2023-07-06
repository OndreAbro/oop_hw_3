import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container implements Comparable<Container>, Iterable<Box> {

    private List<Box> boxes;
    int index;

    public Container() {
        boxes = new ArrayList<>();
        index = 0;
    }

    public int getWeight() {
        final int[] totalWeight = {0};
        for (Box box : boxes) {
            totalWeight[0] = totalWeight[0] + box.weight;
        }
        return totalWeight[0];
    }

    public void addBox(Box box) {
        if (!boxes.contains(box)) {
            boxes.add(box);
            index += 1;
        }
    }

    public int indexOf(Box box) {
        return boxes.indexOf(box);
    }

    @Override
    public int compareTo(Container container) {
        return Integer.compare(this.getWeight(), container.getWeight());
    }

    @Override
    public String toString() {
        return boxes.toString();
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }

}
