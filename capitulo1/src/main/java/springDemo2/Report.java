package springDemo2;

import java.io.OutputStream;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // marcamos como bean para el contexto de spring
public class Report {
    private Connection connection;
    private OutputStream out;

    // anotacion que nos permite resolver las dependencas del componente Report
    @Autowired
    public Report(@Qualifier("database") Connection connection, OutputStream out) {
        this.connection = connection;
        this.out = out;
    }

    public void make() {
        PrintWriter pr = new PrintWriter(out);
        pr.println("Reporte:");
        pr.println("-------------");
        String[] data = connection.getData();
        int maxLen = 0;
        for (String str : data)
            if (str.length() > maxLen)
                maxLen = str.length();
        maxLen += 2;
        StringBuilder sb = new StringBuilder(maxLen);

        for (String str : data) {
            pr.print("    " + str);
            for (int n=str.length(); n<maxLen; n++) {
                pr.print(' ');
            }
            pr.print('|');
            int i = (int) (Math.random() * 16) + 1;
            for (int n=0; n<i; n++)
                pr.print('-');
            pr.println();
        }
        pr.println();
        pr.println("---- END ----");
        pr.flush();
    }
}
