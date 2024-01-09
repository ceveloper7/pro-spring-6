package springDemo1;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Report {
    private Connection connection; // coneccion a la BD
    private OutputStream out; // salida del reporte

    public Report(Connection connection, OutputStream out) {
        this.connection = connection;
        this.out = out;
    }

    /**
     * Listamos los elementos obteneidos de la coleccion data
     */
    public void make() {
        PrintWriter pr = new PrintWriter(out);
        pr.println("Reporte:");
        pr.println("-------------");
        String[] data = connection.getData();
        int maxLen = 0; // longitud de la cadena
        for (String str : data)
            if (str.length() > maxLen)
                maxLen = str.length();
        maxLen += 2;

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
