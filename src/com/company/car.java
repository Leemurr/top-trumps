package com.company;

public class car extends deck {

    public car(float atty1, float atty2, float atty3, float atty4, float atty5, float atty6, String nm) {
        super(atty1, atty2, atty3, atty4, atty5, atty6, nm);
    }

    public String toString() {
        return (name + "\n\n1. Top Speed: " + att1 + "\n2. 0 - 60: " + att2 + "\n3. Power: " + att3 + "\n4. Fuel Capacity: " + att4 + "\n5. Price: £" + att5 + "K" + "\n6. Co2 Emissions: " + att6);
    }
}
