package springDemo1;

public class ConnectionImpl implements Connection{
    @Override
    public String[] getData() {
        return new String[] {
                "uno",
                "dos",
                "tres",
                "cuatro",
                "cinco"
        };
    }
}
