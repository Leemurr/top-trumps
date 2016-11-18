package com.company;

public class weapon {

    public float weight;
    public int damage;
    public float reloadSpeed;
    public int magazineSize;
    public int accuracy;
    public int range;
    public String name;

    weapon(float w, int d, float rs, int m, int a, int rng, String nm) {
        weight = w;
        damage = d;
        reloadSpeed = rs;
        magazineSize = m;
        accuracy = a;
        range = rng;
        name = nm;

    }

    public String toString() {
        return (name + "\n\n1. Weight: " + weight + "\n2. Damage: " + damage + "\n3. Reload Speed: " + reloadSpeed + "\n4. Magazine Size: " + magazineSize + "\n5. Accuracy: " + accuracy + "\n6. Range: " + range);
    }
}

