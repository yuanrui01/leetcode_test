package org2.example;

import org2.annotation.UseCase;

import java.util.*;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/3-23:33
 */
public class Test01 {

    private static final int CONST_INT = 32;

    public static int div(int a, int b){
        try{
            return a/ b;
        }catch (Exception e){
            System.out.println("Exception");
        }
        //编译错误！！！！！
/*        catch (NullPointerException e){
            System.out.println("NullPointerException");
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException");
        }*/
        finally {
            System.out.println("finally");
        }
        return 0;
    }

    @UseCase(id = CONST_INT)
    public static void main(String[] args) {
        //List<String> sl = Arrays.asList("1", "2", "3", "4", "5");
        List<String> mutableList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

        Iterator<String> iterator = mutableList.iterator();
        ListIterator<String> stringListIterator = mutableList.listIterator();
/*
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.remove();
*/
        while (iterator.hasNext()) {
            System.out.println("======iter begin======");
            String next = iterator.next();
            System.out.println(next);
            iterator.remove();
            System.out.println("======iter end======");
        }

        stringListIterator.add("8");
        stringListIterator.add("9");
        stringListIterator.add("10");
        stringListIterator.add("11");

        System.out.println(mutableList.isEmpty());

        Collections.nCopies(3,"232");
    }
}
