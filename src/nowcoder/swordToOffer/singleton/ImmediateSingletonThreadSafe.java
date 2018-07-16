package nowcoder.swordToOffer.singleton;

public class ImmediateSingletonThreadSafe {
    // 单例类三要素:
    // 1. 私有静态变量
    // 2. 私有构造函数
    // 3. 共有静态函数
    private static ImmediateSingletonThreadSafe uniqueInstance = new ImmediateSingletonThreadSafe();

    private ImmediateSingletonThreadSafe() {

    }

    public static ImmediateSingletonThreadSafe getUniqueInstance() {
        return uniqueInstance;
    }
}
