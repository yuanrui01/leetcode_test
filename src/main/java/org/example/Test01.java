package org.example;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/3-23:33
 */
public class Test01 {

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

    public static void main(String[] args) {
        int res = div(9,0);

        System.out.println("商是：" + res);
    }
}
