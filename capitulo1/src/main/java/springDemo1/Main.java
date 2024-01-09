package springDemo1;

public class Main {
    public static void main(String[] args) {
        Connection conn = new ConnectionImpl();
        Report report = new Report(conn, System.out);
        report.make();
    }
}
