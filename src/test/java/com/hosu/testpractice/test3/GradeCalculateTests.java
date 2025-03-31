package com.hosu.testpractice.test3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hosu.testpractice.test3.domain.dto.test_doubles.Student;
import com.hosu.testpractice.test3.repository.StubGradeRepository;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class GradeCalculateTests {
    private StubGradeRepository stubGradeRepository;

    public GradeCalculateTests(){
        stubGradeRepository = new StubGradeRepository();
    }

    private Map<String, Integer> grades(Student s){
        return stubGradeRepository.findByName(s.getName());
    }

    @Test
    void averageGradesTests(){
        Student s = new Student("chacha", 0, new HashMap<>(), 'M', "01012341234");
        Map<String, Integer> result = grades(s);
        int total = 0;
        int expected = 8;
        for(String grade : result.keySet()){
            total += result.get(grade);
        }
        assertEquals(expected, total/result.size());
    }
}
