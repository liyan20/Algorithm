package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: xianz
 * @Date: 2020/7/21 15:01
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

    }
}

class Student2{
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return age == student2.age &&
                Objects.equals(name, student2.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
