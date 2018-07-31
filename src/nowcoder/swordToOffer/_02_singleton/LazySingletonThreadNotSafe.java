package nowcoder.swordToOffer._02_singleton;

public class LazySingletonThreadNotSafe {
    // 单例类三要素：
    // 1. 私有静态变量
    // 2. 私有构造函数--》保证不能通过构造函数初始化实例
    // 3. 共有静态函数
    private static LazySingletonThreadNotSafe uniqueInstance;

    private LazySingletonThreadNotSafe() {

    }

    public static LazySingletonThreadNotSafe getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazySingletonThreadNotSafe();
        }
        return uniqueInstance;
    }
}
