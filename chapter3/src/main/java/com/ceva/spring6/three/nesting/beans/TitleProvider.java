package com.ceva.spring6.three.nesting.beans;

import org.apache.commons.lang3.StringUtils;

/*
 * Se provee el titulo de la cancion segun el contexto.
 */
public class TitleProvider {
    private String title = "Gravity";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static TitleProvider instance(final String title){
        var childProvider = new TitleProvider();
        if(StringUtils.isNotBlank(title)) {
            childProvider.setTitle(title);
        }
        return childProvider;
    }
}
