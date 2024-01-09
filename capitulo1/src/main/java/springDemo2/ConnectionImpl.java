package springDemo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component // marcamos como bean para el context de spring
@Qualifier("database")
public class ConnectionImpl implements Connection {
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