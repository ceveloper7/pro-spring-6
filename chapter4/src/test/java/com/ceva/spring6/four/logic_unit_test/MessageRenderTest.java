package com.ceva.spring6.four.logic_unit_test;


import com.ceva.spring6.four.advancedconfig.MessageProvider;
import com.ceva.spring6.four.advancedconfig.MessageRenderer;
import com.ceva.spring6.four.advancedconfig.StandardOutMessageRenderer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/*
 * Verificamos el comportamiento de la implementacion del bean StandardOutMessageRenderer.
 */
public class MessageRenderTest {
    @Test
    void testStandardOutMessageRenderer(){
        MessageProvider mockProvider = mock(MessageProvider.class);
        // configuramos el comportamiento, el valor string que se devolvera cuando se llame al metodo getMessage()
        when(mockProvider.getMessage()).thenReturn("test message");

        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(mockProvider);

        messageRenderer.render();
        verify(mockProvider, times(1)).getMessage();
    }
}
