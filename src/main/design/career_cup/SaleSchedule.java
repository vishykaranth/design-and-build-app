package career_cup;

import java.io.*;
import java.util.*;

class SalePeriod {
    public int startDay;
    public int endDay;
    public double price;

    public SalePeriod(int startDay, int endDay, double price) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + startDay + ", " + endDay + ", $" + price + ")";
    }
}

/*

5
1 5 20
3 6 15
2 8 25
7 12 18
1 31 22


 */

class SaleSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        SalePeriod[] sales = new SalePeriod[t];

        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            double price = Integer.parseInt(s[2]);

            minStart = Math.min(minStart, start);
            maxEnd = Math.max(maxEnd, end);

            sales[i] = new SalePeriod(start, end, price);
        }

        List<SalePeriod> nonConflictingSchedule = getNonConflictingSchedule(sales, minStart, maxEnd);

        nonConflictingSchedule.forEach(System.out::println);
    }

    public static List<SalePeriod> getNonConflictingSchedule(SalePeriod[] sales, int minStart, int maxEnd) {
        // This will contain the minimum price on the ith day at the ith index
        double[] prices = new double[maxEnd + 1];

        for (int i = 0; i <= maxEnd; i++) {
            prices[i] = Integer.MAX_VALUE;
        }

        for (SalePeriod sp : sales) {
            for (int i = sp.startDay; i <= sp.endDay; i++) {
                prices[i] = Math.min(sp.price, prices[i]);
            }
        }

        List<SalePeriod> nonConflictingSchedule = new ArrayList<>();

        int i = minStart;
        while(i <= maxEnd) {
            int start = i;

            while (i <= maxEnd - 1 && prices[i + 1] == prices[i]) {
                i += 1;
            }

            int end = i;
            i += 1;

            nonConflictingSchedule.add(new SalePeriod(start, end, prices[i - 1]));
        }

        return nonConflictingSchedule;
    }
}