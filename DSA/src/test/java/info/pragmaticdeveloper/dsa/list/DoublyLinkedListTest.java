package info.pragmaticdeveloper.dsa.list;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DoublyLinkedListTest {

    @Test
    void testInsertAtHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        assertThat(list.getSize(), is(3));
    }
}
