package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CommonCoursePairFinderTest {
    private CommonCoursePairFinder commonCoursePairFinder;

    @BeforeEach
    public void setUp() {
        commonCoursePairFinder = new CommonCoursePairFinder();
    }

    @Test
    void findSharedCourses1() {
        String[][] studentCoursePairs = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}};
        List<CommonCoursePairFinder.StudentPairAndSharedCourses> studentPairAndSharedCourses = commonCoursePairFinder.findSharedCourses(studentCoursePairs);
        MatcherAssert.assertThat(studentPairAndSharedCourses.size(), Is.is(6));
    }

    @Test
    void findSharedCourses2() {
        String[][] studentCoursePairs = {
                {"42", "Software Design"},
                {"0", "Advanced Mechanics"},
                {"9", "Art History"}};
        List<CommonCoursePairFinder.StudentPairAndSharedCourses> studentPairAndSharedCourses = commonCoursePairFinder.findSharedCourses(studentCoursePairs);
        MatcherAssert.assertThat(studentPairAndSharedCourses.size(), Is.is(3));
    }
}