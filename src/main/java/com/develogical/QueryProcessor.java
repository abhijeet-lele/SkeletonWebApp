package com.develogical;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);
    String ans = "";
    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }
    if (query.contains("multiplied by")) {
        String sentence = query;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(sentence);
        List<Long> numbers = new ArrayList<>(0);
        while (matcher.find()) {
          
            numbers.add(0, Long.parseLong(matcher.group()));
          
        }
        Long val = numbers.stream().reduce(1L,(a,b)-> a*b);
        return val.toString();
    }
    if (query.contains("plus") &&  !query.contains("minus")) {
        String sentence = query;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(sentence);
        List<Long> numbers = new ArrayList<>(0);
        while (matcher.find()) {
          
            numbers.add(0, Long.parseLong(matcher.group()));
          
        }
        Long val = numbers.stream().reduce(0L,(a,b)-> a+b);
        return val.toString();
    }
    return "";
  }
}
