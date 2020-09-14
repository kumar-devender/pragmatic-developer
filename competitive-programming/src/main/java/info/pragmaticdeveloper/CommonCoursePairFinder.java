package info.pragmaticdeveloper;

import java.util.*;
import java.util.stream.Collectors;

public class CommonCoursePairFinder {
    public List<StudentPairAndSharedCourses> findSharedCourses(String[][] studentCoursePairsArray) {
        List<StudentCoursePair> studentCoursePairs = getStudentCoursePairs(studentCoursePairsArray);
        List<String> studentIds = getStudentIds(studentCoursePairs);
        List<StudentPairAndSharedCourses> studentPairAndSharedCourses = new ArrayList<>();
        for (int i = 0; i < studentIds.size(); i++) {
            for (int j = i + 1; j < studentIds.size(); j++) {
                StudentPairAndSharedCourses studentPairAndSharedCourse = new StudentPairAndSharedCourses(studentIds.get(i) + "," + studentIds.get(j),
                        getCommonCourses(studentCoursePairs, studentIds.get(i), studentIds.get(j)));
                studentPairAndSharedCourses.add(studentPairAndSharedCourse);
            }
        }
        return studentPairAndSharedCourses;
    }

    private List<String> getStudentIds(List<StudentCoursePair> studentCoursePairs) {
        Set<String> studentIdSet = studentCoursePairs.stream()
                .map(StudentCoursePair::getId)
                .collect(LinkedHashSet::new, Set::add, Set::addAll);
        return new ArrayList<>(studentIdSet);
    }

    private List<StudentCoursePair> getStudentCoursePairs(String[][] studentCoursePairsArray) {
        List<StudentCoursePair> studentCoursePairs = new ArrayList<>();
        for (int i = 0; i < studentCoursePairsArray.length; i++) {
            String studentId = studentCoursePairsArray[i][0];
            String course = studentCoursePairsArray[i][1];
            studentCoursePairs.add(new StudentCoursePair(studentId, course));
        }
        return studentCoursePairs;
    }

    private List<String> getCommonCourses(List<StudentCoursePair> studentCoursePairs, String studentId1, String studentId2) {
        List<String> student1Courses = studentCoursePairs.stream()
                .filter(pair -> pair.getId().equals(studentId1))
                .map(StudentCoursePair::getCourse)
                .collect(Collectors.toList());

        List<String> student2Courses = studentCoursePairs.stream()
                .filter(pair -> pair.getId().equals(studentId2))
                .map(StudentCoursePair::getCourse)
                .collect(Collectors.toList());
        student1Courses.retainAll(student2Courses);
        return student1Courses;
    }

    public static class StudentPairAndSharedCourses {
        private String pair;
        private List<String> course;

        StudentPairAndSharedCourses(String pair, List<String> course) {
            this.pair = pair;
            this.course = course;
        }

        public String getPair() {
            return pair;
        }

        public List<String> getCourse() {
            return course;
        }
    }

    private static class StudentCoursePair {
        private String id;
        private String course;

        StudentCoursePair(String id, String course) {
            this.id = id;
            this.course = course;
        }

        String getId() {
            return id;
        }

        String getCourse() {
            return course;
        }
    }
}
