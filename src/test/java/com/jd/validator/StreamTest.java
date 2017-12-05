package com.jd.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 11:02
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());

        list.stream().filter(i -> i > 3).forEach(System.out::println);
    }

}
