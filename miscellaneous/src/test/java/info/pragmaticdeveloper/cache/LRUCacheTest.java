package info.pragmaticdeveloper.cache;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class LRUCacheTest {

    @Test
    void testReplaceOperation() {
        LRUCache<String, String> lruCache = new LRUCache<>(1);
        lruCache.put("name", "Devender");
        //when
        var retrievedName = lruCache.get("name");
        var size = lruCache.getSize();
        assertThat(retrievedName, equalTo("Devender"));
        assertThat(size, is(1));
        //when
        lruCache.put("name", "Astha");
        retrievedName = lruCache.get("name");
        assertThat(retrievedName, equalTo("Astha"));
        assertThat(size, is(1));
    }

    @Test
    void testCacheCapacityReached() {
        LRUCache<String, String> lruCache = new LRUCache<>(1);
        lruCache.put("name", "Devender");
        //when
        var retrievedName = lruCache.get("name");
        var size = lruCache.getSize();
        assertThat(retrievedName, equalTo("Devender"));
        assertThat(size, is(1));
        //when
        lruCache.put("Title", "Tech Lead");
        retrievedName = lruCache.get("Title");
        assertThat(retrievedName, equalTo("Tech Lead"));
        assertThat(size, is(1));

        retrievedName = lruCache.get("name");
        assertThat(retrievedName, nullValue());
    }
}