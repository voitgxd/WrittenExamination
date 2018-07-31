package nowcoder.swordToOffer._02_singleton;

public class DoubleLockSingletonThreadSafe {
    // 单例类三要素:
    // 1. 私有静态变量
    // 2. 私有构造函数
    // 3. 共有静态函数

    // 加volatile关键字的原因: uniqueInstance = new DoubleLockSingletonThreadSafe(); 代码分三步执行
    // 1. 分配内存空间
    // 2. 初始化对象
    // 3. 将uniqueInstance 指向分配的内存地址
    // 由于JVM具有指令重排的特性，有可能执行顺序变为了1-》3-》2,在多线程情况下，有可能获得一个还没有被初始化的实例
    // 使用volatile可以禁止JVM的指令重排，保证在多线程环境下也能正常运行
    private volatile static DoubleLockSingletonThreadSafe uniqueInstance;

    private DoubleLockSingletonThreadSafe() {

    }

    public DoubleLockSingletonThreadSafe getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (DoubleLockSingletonThreadSafe.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new DoubleLockSingletonThreadSafe();
                }
            }
        }
        return uniqueInstance;
    }
}
