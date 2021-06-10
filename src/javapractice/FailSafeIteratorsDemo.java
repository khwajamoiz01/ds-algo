package javapractice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIteratorsDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int index = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 3) {
                list.remove(index);
            }
            index++;
        }
        System.out.println(list);
    }
}
