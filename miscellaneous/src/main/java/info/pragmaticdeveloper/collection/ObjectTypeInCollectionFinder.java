package info.pragmaticdeveloper.collection;

import java.util.Collection;

public class ObjectTypeInCollectionFinder {

    public static Class<?> guessElementType(Collection<?> collection) {
        return collection.stream()
                .findFirst()
                .map(Object::getClass)
                .orElse(null);
    }
}
