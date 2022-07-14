class Test {
    public static void main(String[] args) {
        double[] x = {3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500};
        double[] y = {2195, 2313, 2675, 2976, 3244, 3527, 3899, 4109, 4618, 4800};
        double res = getSum(x, y);
        System.out.println(res);
        System.out.println(res/8);
    }

    public static double getSum(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + Math.pow(y[i] - x[i] * 0.60300 - 266.382, 2);
        }
        return sum;
    }
}
