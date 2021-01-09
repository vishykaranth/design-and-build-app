package career_cup;

public class NestedArrayAlgo {

    public static void main(String[] args) {

        //[1, 5, 8, 9, 10, [24, 20, [39, 48], 89], 105, 99]

        Object[] arraN_1_1 = {39, 48};
        Object[] arraN_1 = {24, 20, arraN_1_1, 89};
        Object[] arraN = {1, 5, 8, 9, 10, arraN_1, 105, 99};

        printNestedArray(arraN);

    }

    public static void printNestedArray(Object[] NestArray) {

        for (int i = 0; i < NestArray.length; i++) {

            if (NestArray[i].getClass().isArray()) {
                Object[] tempArray = (Object[]) NestArray[i];
                printNestedArray(tempArray);
            } else {
                System.out.print(NestArray[i] + ",");
            }
        }
    }
}