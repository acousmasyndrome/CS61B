package tester;

import antlr.StringUtils;
import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.functions.StringJoin;
import org.junit.Assert;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void testArray(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        ArrayDequeSolution<String> methodsString = new ArrayDequeSolution<>();
        int testNumber=1000;
        for(int i=1;i<=testNumber;i++) {
            int randomNumber = StdRandom.uniform(0, 4);
            random_test(sad1,ads1,randomNumber,i,methodsString);
        }

    }
    public void random_test(StudentArrayDeque<Integer> sad1,
                              ArrayDequeSolution<Integer> ads1,int randomNumber,
                            int ranval,ArrayDequeSolution<String> methodsString){
            if(randomNumber == 0) {
                ads1.addFirst(ranval);
                sad1.addFirst(ranval);
                methodsString.addLast("addFirst(" + ranval + ")");
                Assert.assertEquals(ranval,ranval);

            } else if (randomNumber == 1) {
                ads1.addLast(ranval);
                sad1.addLast(ranval);
                methodsString.addLast("addLast(" + ranval + ")");
                Assert.assertEquals(ranval,ranval);

            } else if (randomNumber == 2) {
                int expected = 0;
                int actual = 0;
                if((ads1.isEmpty() || ads1.getFirst() == null) &&
                        (sad1.isEmpty() || sad1.get(sad1.size()-1) == null)) {
                     Assert.assertEquals(expected,actual);
                }else if(sad1.isEmpty() || sad1.get(sad1.size()-1) == null){
                     expected = ads1.removeFirst();
                     methodsString.addLast("removeFirst()");
                     Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }else if (ads1.isEmpty() || ads1.getFirst() == null) {
                    actual = sad1.removeFirst();
                    methodsString.addLast("removeFirst()");
                    Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }else {
                    expected = ads1.removeFirst();
                    actual = sad1.removeFirst();
                    methodsString.addLast("removeFirst()");
                    Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }

            } else {
                int expected = 0;
                int actual = 0;
                if((ads1.isEmpty() || ads1.getLast() == null)&&
                        (sad1.isEmpty() ||sad1.get(sad1.size()-1) == null)) {
                    Assert.assertEquals(expected,actual);
                }else if(sad1.isEmpty() || sad1.get(sad1.size()-1) == null){
                    expected = ads1.removeLast();
                    methodsString.addLast("removeLast()");
                    Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }else if (ads1.isEmpty() || ads1.getLast() == null) {
                    actual = sad1.removeLast();
                    methodsString.addLast("removeLast()");
                    Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }else {
                    expected = ads1.removeLast();
                    actual = sad1.removeLast();
                    methodsString.addLast("removeLast()");
                    Assert.assertEquals("\n"+String.join("\n",methodsString),expected,actual);
                }
            }
    }
}
