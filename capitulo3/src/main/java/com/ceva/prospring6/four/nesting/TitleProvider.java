package com.ceva.prospring6.four.nesting;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase que nos permite declarar el titulo de la cancion segun el contexto.
 */
public class TitleProvider {
    private String title = "Gravity";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // metodo que crear una instancia de TitleProvider con un titulo de cancion
    public static TitleProvider instance(final String title){
        var childProvider = new TitleProvider();
        if(StringUtils.isNotBlank(title)) {
            childProvider.setTitle(title);
        }
        return childProvider;
    }
}
