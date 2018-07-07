package com.dsapps2018.testiranjeprojekta;

/**
 * Created by Daniel on 7/8/2018.
 */

public class Product {

    private String title;
    private boolean checked;

    public Product(String title, boolean checked) {
        this.title = title;
        this.checked = checked;
    }

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
