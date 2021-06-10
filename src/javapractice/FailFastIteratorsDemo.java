package javapractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIteratorsDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /*******Does not throw ConcurrentModificationException *****/
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove();
            }
        }
        System.out.println(list);

        /****Does throw ConcurrentModificationException ***/
        int index = 0;
        it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 3) {
                list.remove(index);
            }
            index++;
        }
        System.out.println(list);
    }
}
