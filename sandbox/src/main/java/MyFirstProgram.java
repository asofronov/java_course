public class MyFirstProgram {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.a +  " равна " + s.area());
        Rectangle r = new Rectangle(4,3);
        System.out.println("Площадь прямоугольника со сторонами " + r.b + " и " + r.c + " равна " + r.area());
    }
}