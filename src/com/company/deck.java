package com.company;

public class deck {

    public String name;
    public float att1;
    public float att2;
    public float att3;
    public float att4;
    public float att5;
    public float att6;


    public deck(float atty1, float atty2, float atty3, float atty4, float atty5, float atty6, String nm) {
            att1 = atty1;
            att2 = atty2;
            att3 = atty3;
            att4 = atty4;
            att5 = atty5;
            att6 = atty6;
            name = nm;
    }

    public String toString() {
        return (att1 + "\n" + att2 + "\n" + att3 + "\n" + att4 + "\n" + att5 + "\n" + att6);
    }

}

