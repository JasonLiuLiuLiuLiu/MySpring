public class Student {

    private String name;
    private int age;

    private Student(String name)
    {
        this.name=name;
    }

    public boolean SetAge(int age)
    {
        this.age=age;
        return true;
    }

    @Override
    public String toString() {
        return name+":"+age;
    }
}
