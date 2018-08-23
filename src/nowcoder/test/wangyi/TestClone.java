package nowcoder.test.wangyi;

public class TestClone implements Cloneable {
    int age;
    String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestClone(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClone t1 = new TestClone(10, new String("test"));
        System.out.println(t1.name);
        TestClone t2 = (TestClone) t1.clone();
        t2.setAge(100);
        t2.setName(new String("hahah"));
        System.out.println(t1.name);
    }
}
