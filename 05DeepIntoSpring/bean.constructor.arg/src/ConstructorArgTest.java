public class ConstructorArgTest {
    private int age;
    private String name;

    public ConstructorArgTest() {

    }

    public ConstructorArgTest(int age) {
        this.age = age;
    }

    public ConstructorArgTest(String name) {
        this.name = name;
    }

    public ConstructorArgTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name+":"+age;
    }
}
