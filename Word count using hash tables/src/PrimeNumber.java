public class PrimeNumber {
    //Sieve of Eratosthenes algorithm is used to generate prime numbers

    public static int[] getPrev(int number) {
        int[] S = new int[number];
        S[1] = 0;
        int k;

        for (k = 2; k <= number - 1; k++)
            S[k] = 1;

        for (k = 2; k * k <= number - 1; k++) {

            if (S[k] == 1) {

                for (int l = k * k; l <= number - 1; l += k) {
                    S[l] = 0;
                }
            }
        }
        return S;

    }

    public static int[] getNext(int number) {
        int[] S = new int[number * 3 + 1];
        S[1] = 0;
        int k;

        for (k = 2; k <= number * 3; k++)
            S[k] = 1;

        for (k = 2; k * k <= number * 3; k++) {

            if (S[k] == 1) {

                for (int l = k * k; l <= number * 3; l += k) {
                    S[l] = 0;
                }
            }
        }
        return S;
    }

}
