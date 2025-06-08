package Algo2_Lab_Work_Sem5;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog: " + name + ", Breed: " + breed;
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", Color: " + color;
    }
}

