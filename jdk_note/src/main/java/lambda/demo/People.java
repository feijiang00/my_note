package lambda.demo;

import lombok.Data;

/**
 * @date 2022/1/17 14:20
 */
@Data
public class People {
    private String name;
    private Integer age;
    People(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
