package com.firida_diane.testrecyclerview;

public class Planete {

    private String nom;
    private String taille;
    private int img;

    Planete(String text1, String text2, int image){
        nom = text1;
        taille = text2;
        img=image;
    }

    public String getNom() {
        return nom;
    }

    public String getTaille() {
        return taille;
    }

    public int getImg() {
        return img;
    }
}
