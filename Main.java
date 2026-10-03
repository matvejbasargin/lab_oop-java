class Animal {

    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // GETSET
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { if (age >= 0) this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // СОБСТВЕННЫЕ МЕТОДЫ
    public void eat() { System.out.println(name + " ест"); }
    public void sleep() { System.out.println(name + " спит"); }
    public void birthday() { age++; }

    @Override
    public String toString() {
        return "Animal: " + name + ", " + age + " лет, " + weight + " кг";
    }
}

class Cat extends Animal {

    private String color;
    private int lives;
    private boolean isIndoor;

    public Cat(String name, int age, double weight,
               String color, int lives, boolean isIndoor) {
        super(name, age, weight);
        this.color = color;
        this.lives = lives;
        this.isIndoor = isIndoor;
    }

    // GETSET
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getLives() { return lives; }
    public void setLives(int lives) { this.lives = lives; }

    public boolean isIndoor() { return isIndoor; }
    public void setIndoor(boolean isIndoor) { this.isIndoor = isIndoor; }

    // СОБСТВЕННЫЕ МЕТОДЫ
    public void meow() { System.out.println(getName() + ": мяу"); }
    public void purr() { System.out.println(getName() + " мурчит"); }
    public void catchMouse() {
        if (isIndoor) {
            System.out.println(getName() + " домашняя кошка, мышей не ловит");
        } else {
            System.out.println(getName() + " поймала мышь");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", кошка, цвет " + color;
    }
}

class PersianCat extends Cat {

    private int furLength;
    private boolean hasPedigree;
    private String eyeColor;

    public PersianCat(String name, int age, double weight,
                      String color, int lives, boolean isIndoor,
                      int furLength, boolean hasPedigree, String eyeColor) {
        super(name, age, weight, color, lives, isIndoor);
        this.furLength = furLength;
        this.hasPedigree = hasPedigree;
        this.eyeColor = eyeColor;
    }

    // GETSET
    public int getFurLength() { return furLength; }
    public void setFurLength(int furLength) { this.furLength = furLength; }

    public boolean isHasPedigree() { return hasPedigree; }
    public void setHasPedigree(boolean hasPedigree) { this.hasPedigree = hasPedigree; }

    public String getEyeColor() { return eyeColor; }
    public void setEyeColor(String eyeColor) { this.eyeColor = eyeColor; }

    // СОБСТВЕННЫЕ МЕТОДЫ
    public void groom() {
        if (furLength >= 10) {
            System.out.println(getName() + ": нужен груминг");
        } else {
            System.out.println(getName() + ": груминг не нужен");
        }
    }

    public void showOff() {
        if (hasPedigree) {
            System.out.println(getName() + " можно ходить на выставки, глаза: " + eyeColor);
        } else {
            System.out.println(getName() + " без родословной, на выставку не допущена");
        }
    }

    public int calculatePrice() {
        int price = 10000 + furLength * 500;
        if (hasPedigree) {
            price = price * 2;
        }
        if (getAge() > 10) {
            price = price / 2;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", шерсть " + furLength + " см, глаза " + eyeColor;
    }
}

public class Main {
    public static void main(String[] args) {
        PersianCat p = new PersianCat("Барсик", 3, 4.5,
                "белый", 9, true, 8, true, "голубые");

        System.out.println("--- Геттеры ---");
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.isIndoor());
        System.out.println(p.getFurLength());
        System.out.println(p.getEyeColor());
        System.out.println("--- Сеттеры ---");
        p.setName("Мурка");
        p.setColor("рыжий");
        p.setFurLength(3);
        System.out.println(p.getName() + ", " + p.getColor() + ", " + p.getFurLength());

        p.setAge(-5);
        System.out.println("Возраст после setAge(-5): " + p.getAge());  // 3

        System.out.println("--- Методы Animal ---");
        p.eat();
        p.sleep();
        p.birthday();
        System.out.println("Возраст после birthday: " + p.getAge());    // 4

        System.out.println("--- Методы Cat ---");
        p.meow();
        p.purr();
        p.catchMouse();

        System.out.println("--- Методы PersianCat ---");
        p.groom();
        p.showOff();
        System.out.println("Цена: " + p.calculatePrice());

        System.out.println("--- Наследование ---");
        System.out.println(p instanceof Cat);
        System.out.println(p instanceof Animal);
        Animal a = p;
        a.eat();

        System.out.println("--- toString ---");
        System.out.println(p);
    }
}













