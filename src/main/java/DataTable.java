import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DataTable {

    private final ArrayList<String> data = new ArrayList<>();

    public DataTable() {
    }

    public void initDataTable(String file) {

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] line;

            while ((line = reader.readNext()) != null) {
                data.addAll(Collections.singletonList(Arrays.toString(line) + " \n"));
            }

        } catch (Error | IOException err) {
            System.out.println("err" + err);
        }
    }

    public void printAllTable() {
        System.out.println(data);
    }

    public void findRows(String patternWord) {
        Collection<String> filtered = Collections2.filter(data, Predicates.containsPattern(patternWord));
        if (filtered.size() != 0) {
            System.out.println(filtered);
        }else {
            System.out.println("Слово " + patternWord + " не найдено ни в одной строке");
        }
    }

}
