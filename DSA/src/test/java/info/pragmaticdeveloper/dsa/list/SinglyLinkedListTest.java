package info.pragmaticdeveloper.dsa.list;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class SinglyLinkedListTest {

    @Test
    void deleteByValue() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertFirst(1);
        assertThat(list.getSize(), is(5));
        list.deleteByValue(5);
        assertThat(list.getSize(), is(4));
        assertThat(list.getElements(), contains(1, 2, 3, 4));
    }
}