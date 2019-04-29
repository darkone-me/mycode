package test;

public class RandomCoding {

    //一百以内的质数 1不是质数
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        outer:
        for (int i = 2; i < 101; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            sum += i;
            count++;
            System.out.println(i);

        }
        System.out.println(sum);
        System.out.println(count);
    }
}
