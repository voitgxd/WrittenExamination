package nowcoder.swordToOffer.singleton;

public class LazySingletonThreadSafe {
    // 单例类三要素:
    // 1. 私有静态变量
    // 2. 私有构造函数
    // 3. 共有静态函数
    private static LazySingletonThreadSafe uniqueInstance;

    private LazySingletonThreadSafe(){

    }

    // 缺点：此方法在多线程访问的时候会阻塞，损耗性能
    public static synchronized LazySingletonThreadSafe getUniqueInstance() {
        if(uniqueInstance == null){
            uniqueInstance = new LazySingletonThreadSafe();
        }
        return uniqueInstance;
    }
}
