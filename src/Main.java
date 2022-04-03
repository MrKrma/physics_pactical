import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("input.txt"));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("output.txt"))));

        ArrayList<Integer> arr = new ArrayList<>();

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }

        Collections.sort(arr);
        int total = 0;

        while (arr.get(arr.size() - 1) > arr.get(0) * 2) {

            int b = arr.get(arr.size() - 1);
            int a = arr.get(0);

            if (b / 2 > a && 3 * a < b) {
                arr.remove(binaryS(arr, a));
            } else {
                arr.remove(binaryS(arr, b));
            }
            total++;
        }

        br.write(total + "");
        br.flush();
        br.close();

    }

    public static int binaryS(ArrayList<Integer> arr, int goal) {
        int beg = 0;
        int end = arr.size() - 1;
        int half = (beg + end) / 2;

        while (beg <= end) {
            half = (beg + end) / 2;

            if (arr.get(half) == goal) {
                return half;
            } else if (arr.get(half) < goal) {
                beg = half + 1;
            } else if (arr.get(half) > goal) {
                end = half - 1;
            }
        }

        return -1;
    }

}
