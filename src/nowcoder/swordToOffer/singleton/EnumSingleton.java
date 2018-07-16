package nowcoder.swordToOffer.singleton;

public enum EnumSingleton {
    uniqueInstance;

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.uniqueInstance;
        EnumSingleton singleton2 = EnumSingleton.uniqueInstance;
        System.out.print(singleton == singleton2);
    }
}
