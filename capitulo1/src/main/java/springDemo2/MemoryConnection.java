package springDemo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("memory")
public class MemoryConnection implements Connection{
    @Override
    public String[] getData() {
        return null;
    }
}
