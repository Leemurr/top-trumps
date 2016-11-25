package com.company;

public class weapon extends deck {

    public weapon(float atty1, float atty2, float atty3, float atty4, float atty5, float atty6, String nm) {
        super(atty1, atty2, atty3, atty4, atty5, atty6, nm);
    }

    public String toString() {
        return (name + "\n\n1. Weight: " + att1 + "\n2. Damage: " + att2 + "\n3. Reload Speed: " + -att3 + "\n4. Magazine Size: " + att4 + "\n5. Accuracy: " + att5 + "\n6. Range: " + att6);
    }


}


