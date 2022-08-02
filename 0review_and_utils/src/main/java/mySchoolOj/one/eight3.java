package mySchoolOj.one;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.Comparator;

class DNA {
    String value;
    int level;
}

class DNAType implements Comparator<Object> {
    public int compare(Object arg0, Object arg1) {
        DNA obj1 = (DNA) arg0;
        DNA obj2 = (DNA) arg1;
        return obj1.level - obj2.level;
    }
}

public class eight3 {
    public static void main(String[] args) throws Exception {
        int i;
        DataInputStream cin = new DataInputStream(new BufferedInputStream(
                System.in));
        String s = new String();
        s = cin.readLine();
        String n[] = s.split(" ");
        int col = Integer.parseInt(n[0]);
        int row = Integer.parseInt(n[1]);
        DNA dna[] = new DNA[row];
        for (i = 0; i < row; ++i) {
            String line = new String();
            line = cin.readLine();
            dna[i] = new DNA();
            dna[i].value = line;
            dna[i].level = getLevel(line);
        }
        DNAType comp = new DNAType();
        Arrays.sort(dna, comp);
        for (i = 0; i < row; ++i) {
            System.out.println(dna[i].value);
        }
    }
    private static int getLevel(String line) {
        int i, j, t = 0;
        for (i = 0; i < line.length(); ++i) {
            for (j = i + 1; j < line.length(); ++j) {
                if (line.charAt(i) > line.charAt(j)) {
                    ++t;
                }
            }
        }
        return t;
    }
}
