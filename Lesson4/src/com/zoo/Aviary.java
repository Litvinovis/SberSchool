package com.zoo;

import com.zoo.animal.Animal;
import com.zoo.exception.AviaryException;
import java.util.ArrayList;

public class Aviary {
    protected int size;
    protected String name;
    protected ArrayList<Animal> inside = new ArrayList<Animal>();

    public Aviary() {
        this.name = "Unnamed";
        this.size = 5;
    }

    public Aviary(String Name, int Size) {
        this.name = Name;
        this.size = Size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void animalAdd(Animal obj) throws AviaryException {
        int i = 0;
        if (inside.contains(obj)) {
            throw new AviaryException(obj.getName() + " already lives this aviary");
        }
        if (inside.size() >= size) {
            throw new AviaryException("Aviary is full");
        }
        while (i < inside.size() && inside.size() != 0) {
            if (inside.get(i).getClass() == obj.getClass()) {
                throw new AviaryException("You can't add one more " + obj.getClass() + " in this aviary");
            }
            i++;
        }
        inside.add(obj);
    }

    public void animalRemove(Animal obj) throws AviaryException {
        if (!inside.contains(obj)) {
            throw new AviaryException(obj.getName() + " doesn't live at this aviary");
        }
        inside.remove(obj);
    }
}
