# JavaLearning 

> 此项目为记录学习黑马 Java 视频的笔记，包含最全面的 Java 基础知识，每个模块都有对应的代码示例

**代码实现 Java 版本 21.0.5**

**JDK11 中文 API 文档下载链接**
链接：https://pan.quark.cn/s/87be635b67bf
提取码：AQkt

[TOC]

## 一、idea 新建项目

- 前提：本地配置好 Java 开发环境，安装好 idea
- new empty project -> module -> package -> class

## 二、基础知识及语法

### 注释方式

> 遵循 Alibaba 规范，可装插件 Alibaba Java Coding Guidelines 进行检测提示

- 单行注释

  ```java
  // 单行注释
  ```

- 多行注释 

  ```java
  /*
  	注释内容1
  	注释内容2
  */
  ```

- 文档注释

  ```java
  /**
  * 横向比较
  * @param str1 前一个字符串
  * @param str2 后一个字符串
  * @return 返回两字符公共部分
  */
  ```

------

### 二进制

> 计算机中表示数据的最小单元 

数据在计算机中的最小储存单元：字节（byte，简称 B），一个字节占 8 个比特位（bit，简称 b）

```java
1B = 8b
1KB = 1024B
1MB = 1024KB
1GB = 1024MB
1TB = 1024GB
```

字符数据、图片和音视频等文件的数据也是采用二进制进行存储的

字符存的是ascii码表中对应的数字的二进制形式

- 字符 'A' 对应的数字是 65
- 字符 'a' 对应的数字是 97
- 字符 '0' 对应的数字是 48

> 二进制、八进制、十六进制

**八进制**：最小数 0，最大数 7，每 3 位二进制作为一个单元

**十六进制：**最小数 0，最大数 15，每 4 位二进制作为一个单元

------

### 基本数据类型

> 4 大类8种

- 整型
  - byte	1 字节	-128-127
  - short   2 字节   -32768-32767  
  - int        4 字节
  - long     8 字节 
- 浮点型
  - float     4 字节
  - double   8 字节
- 字符型
  - char   2 字节
- 布尔型
  - boolean   1 字节

------

### 类型转换

> 类型范围小的变量，可以直接赋值给类型范围大的变量

**byte -> short(char) -> int -> long -> float -> double**

> 类型范围大的变量，不可以直接赋值给类型范围小的变量，会报错，需要强制类型转换过去

- 强制类型转换可能造成数据（丢失）溢出；浮点型强转成整型，直接丢掉小数部分，保留整数部分返回
- 表达式的最终结果类型由表达式种的最高类型决定
- 在表达式中，byte、short、char 是之直接转换成 int 类型参与运算的

------

### 输入输出

- 输出：System.out.println("hello world");
- 输入：Scanner (java.util.Scannner)

------

### 运算符

#### 基本的算术运算符

- **+、-、*、/、%**

#### 自增自减运算符

- **++、--**
- 只能操作变量，不能操作字面量
- 注意在表达式情况下变量在前在后的区别；在变量前，先加再用，在变量后，先用再加

#### 赋值运算符

- **=**

#### 关系运算符、三元运算符

- **>** **、>= 、<、<=、==、！=**

- ```java
  boolean flag = true;
  int res = flag ? 0 : 1;
  ```

#### 逻辑运算符

- **&、|、！、^、&&、||**
- &、| 判断结果与 &&、|| 一样，但过程不同，前者无论左边是 false 还是 true，右边都要执行（由于 && 、|| 执行效率高，开发中更常用）
- **^ :** 逻辑异或，前后条件的结果相同，就直接返回 false，前后条件的结果不同，才返回 true

------

### 方法重载和方法重写

- **方法重载：**
  - 方法名相同，参数列表不同
  - 在一个类里面
  - 常用的地方是构造器的重载
- **方法重写：**
  - 方法名相同，参数列表不同
  - 子类对父类允许访问的方法的实现过程进行重写
  - 当需要在子类中调用父类的被重写方法时，使用 super 关键字

------

### 程序流程控制

#### 分支结构

- **if、switch语句** 
  - switch 的表达式只能是 byte、short、int、char类型，JDK7开始支持 String，其他类型不支持
  - case 给出的值不允许重复，且只能是字面量，不能是变量
  - 正常使用时，需要写 break，否则会出现穿透现象 
- if 适合做条件是区间判断的情况
- switch 适合做比较值的情况、代码优雅、性能较好

#### 循环结构

- for
- while
- do-while
- 死循环
- 循环嵌套

#### break、continue

- break：跳出并结束当前所在循环的执行
- continue：用于跳出当前循环的当次执行，直接进入循环的下一次执行

------

### random 生成随机数

> `java.util.Random` 和 `java.lang.Math.random` 都可以用于生成随机数，但在使用方式、性能和功能上有一些区别

#### 1. 使用方式

##### `java.util.Random`

- **实例化**：需要创建 `Random` 类的实例
- **方法调用**：通过实例调用 `nextInt`、`nextDouble` 等方法生成随机数

**示例**：

```java
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        int randomInt = random.nextInt(10); // 生成 0 到 9 之间的随机整数
        double randomDouble = random.nextDouble(); // 生成 0.0 到 1.0 之间的随机双精度浮点数
        System.out.println("随机整数: " + randomInt);
        System.out.println("随机双精度浮点数: " + randomDouble);
    }
}
```

##### `java.lang.Math.random`

- **静态方法**：直接调用 `Math.random` 方法，无需实例化
- **返回值**：返回一个在 `[0.0, 1.0)` 范围内的随机双精度浮点数

**示例**：

```java
public class MathRandomExample {
    public static void main(String[] args) {
        double randomDouble = Math.random(); // 生成 0.0 到 1.0 之间的随机双精度浮点数
        System.out.println("随机双精度浮点数: " + randomDouble);
    }
}
```

#### 2. 性能

- **java.util.Random**：创建 `Random` 实例时会有一些开销，但一旦创建，生成随机数的性能较高
- **java.lang.Math.random**：每次调用 `Math.random` 都会创建一个新的 `Random` 实例，这会导致一定的性能开销。因此，如果需要频繁生成随机数，使用 `Random` 实例会更高效

#### 3. 功能

- **java.util.Random**：提供了多种生成随机数的方法，如 `nextInt`、`nextLong`、`nextDouble`、`nextFloat`、`nextBoolean` 等，可以生成不同类型的随机数，并且可以指定范围
- **java.lang.Math.random**：只能生成 `[0.0, 1.0)` 范围内的随机双精度浮点数，功能较为单一

#### 4. 线程安全性

- **java.util.Random**：`Random` 类是线程安全的，但多个线程共享同一个 `Random` 实例时，性能可能会受到影响。如果需要在多线程环境中使用，建议每个线程使用自己的 `Random` 实例
- **java.lang.Math.random**：`Math.random` 方法在内部使用了一个线程安全的 `Random` 实例，因此在多线程环境中可以安全使用，但性能可能会受到影响

#### 5. 伪随机数生成器

- **java.util.Random**：使用线性同余生成器（Linear Congruential Generator, LCG），生成的随机数序列是伪随机的，但具有良好的统计特性。
- **java.lang.Math.random**：实际上也是使用 `Random` 类的实例，因此生成的随机数也是伪随机的。

#### 总结

- **java.util.Random**：适用于需要生成多种类型随机数的场景，性能更高，功能更丰富
- **java.lang.Math.random**：适用于简单的随机数生成需求，使用方便，但性能较低

------

### 程序的数据存储

#### 数组

> 数组是一个存储相同类型数据的容器。它在内存中是连续分布的，可以通过索引访问其中的每个元素

##### 一维数组

###### 1. 声明与定义

- 声明数组：`数据类型[] 数组名;` 或 `数据类型 数组名[];`
- 分配空间：`数组名 = new 数据类型[大小];`
- 声明并分配空间：`数据类型[] 数组名 = new 数据类型[大小];`
- 声明并初始化：`数据类型[] 数组名 = {值1, 值2, 值3, ...};`

###### 2. 初始化

数组元素默认值根据数据类型而定：

- 数值类型：`0`
- 布尔类型：`false`
- 引用类型：`null`

###### 3. 数组长度

通过 `数组名.length` 获取数组的长度。

###### 4. 遍历方式

- 使用 `for` 循环
- 使用增强型 `for-each` 循环

------

##### 二维数组

###### 1. 声明与定义

- 声明数组：`数据类型[][] 数组名;` 或 `数据类型 数组名[][];`
- 分配空间：`数组名 = new 数据类型[行数][列数];`
- 声明并分配空间：`数据类型[][] 数组名 = new 数据类型[行数][列数];`
- 声明并初始化：`数据类型[][] 数组名 = {{值1, 值2}, {值3, 值4}};`

###### 2. 初始化

二维数组的元素默认值与一维数组相同。

###### 3. 数组长度

- 行数：`数组名.length`
- 每行的列数：`数组名[行索引].length`

###### 4. 遍历方式

- 嵌套 `for` 循环
- 使用增强型 `for-each` 循环

------

### 面向对象

> Java 是一种面向对象的编程语言，其核心思想是通过 **对象** 和 **类** 来组织代码和解决问题。面向对象编程的三个基本特性是：封装、继承、多态

#### 封装

- 将数据和操作数据的方法绑定在一起，隐藏对象的内部细节，对外只暴露必要的接口
- 优势：提高代码的安全性和可维护性
- 实现：通过访问修饰符（`private`、`protected`、`public`）实现数据的隐藏

##### 构造器

> 构造器（Constructor）是 Java 类的一种特殊方法，用于在创建对象时初始化对象的状态（即成员变量）。构造器的名字必须与类名相同，并且没有返回值（连 `void` 都不能写）

**构造器的作用**

1. **初始化对象**：在创建对象时为对象的属性赋初始值
2. **简化对象创建过程**：通过参数化构造器，可以在创建对象时直接指定属性值
3. **保证对象的一致性**：通过构造器可以确保对象在创建时满足某些约束

**构造器的特点**

1. 构造器的名字必须与类名相同
2. 构造器没有返回值
3. 每个类至少有一个构造器。如果没有显式定义构造器，Java 会提供一个默认的无参构造器
4. 构造器可以被重载（即同名但参数列表不同）

##### 构造器的类型

###### 1. **无参构造器**

- 不接受参数，通常用于创建默认对象。
- 如果类中没有定义任何构造器，Java 会自动生成一个无参构造器。

```java
class Person {
    String name;
    int age;

    // 无参构造器
    public Person() {
        name = "未命名";
        age = 0;
    }
}
```

###### 2. **有参构造器**

- 接受参数，用于在创建对象时为属性赋值。

```java
class Person {
    String name;
    int age;

    // 有参构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

###### 3. **默认构造器**

- 如果类中没有显式定义任何构造器，Java 会自动提供一个默认无参构造器。
- 一旦显式定义了构造器，默认构造器将不再自动生成。

```java
class Person {
    String name;
    int age;
}
```

------

##### this 关键字

- 用于区分成员变量和局部变量
- 在构造器中可以调用当前类的其他构造器（通过 `this(...)`）
- **构造器不能被继承**：构造器是与类绑定的，子类不能继承父类的构造器，但可以通过 super(...) 调用父类的构造器

------

##### 实体类（JavaBean）

- 成员变量必须私有，且要为他们提供get、set方法；必须有无参数构造器 
- 仅仅只是一个用来保存数据的java类，可以用它创建对象，保存某个事物的数据
- 应用场景：实体类对应的是软件开发里现在比较流行的开发方式，数据和数据的业务处理相分离

------

##### static 关键字

> `static` 用于修饰类的成员（变量和方法）或块，表示这些成员属于类本身，而不是某个具体的对象

###### static 的特点

1. **类级别成员**：
   被 `static` 修饰的变量或方法属于类，而不是某个对象
2. **共享性**：
   所有对象共享同一个 `static` 成员，`static` 变量在内存中只有一份
3. **生命周期**：
   `static` 成员在类加载时初始化，并在类卸载时销毁
4. **直接通过类名访问**：
   无需创建对象，可以通过 `类名.成员名` 直接访问

###### static 的使用

###### 1. static 变量

- 也称为 **类变量**。
- 用于存储类的共享数据。

```java
class Counter {
    static int count = 0; // 静态变量

    Counter() {
        count++;
    }

    static void displayCount() {
        System.out.println("当前计数: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // 通过类名访问静态变量
        Counter.displayCount(); // 输出: 当前计数: 3
    }
}
```

###### 2. static 方法

- 也称为 **类方法**。
- 无需创建对象，可以直接通过类名调用。
- 不能直接访问非静态成员（因为非静态成员依赖于对象，而静态方法不依赖对象）。

```java
class MathUtils {
    // 静态方法
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        // 调用静态方法
        int result = MathUtils.add(10, 20);
        System.out.println("结果: " + result); // 输出: 结果: 30
    }
}
```

###### 3. static 块

- 用于初始化类的静态变量。
- 在类加载时执行，且只执行一次。

```java
class StaticBlockExample {
    static int value;

    // 静态块
    static {
        value = 42;
        System.out.println("静态块执行，value 初始化为: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        // 静态块在类加载时已执行
        System.out.println("value 的值是: " + StaticBlockExample.value);
    }
}
```

###### 4. static 内部类

- 可以在类中定义静态内部类，静态内部类不依赖于外部类的实例。
- 静态内部类可以直接访问外部类的静态成员。

```java
class Outer {
    static String outerStatic = "外部类静态变量";

    // 静态内部类
    static class Inner {
        void display() {
            System.out.println("访问: " + outerStatic);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建静态内部类对象
        Outer.Inner inner = new Outer.Inner();
        inner.display(); // 输出: 访问: 外部类静态变量
    }
}
```

###### static 的注意事项

1. 静态方法不能直接访问非静态成员（因为静态方法不依赖对象，而非静态成员依赖对象）

   ```java
   class Example {
       int nonStaticVar = 10;
       static int staticVar = 20;
   
       static void staticMethod() {
           // System.out.println(nonStaticVar); // 错误，不能访问非静态变量
           System.out.println(staticVar); // 正确
       }
   }
   ```

2. 静态块只能初始化静态变量，不能初始化实例变量

3. `static` 方法中不能使用 `this` 或 `super` 关键字

###### 总结

- **static 变量**：共享数据，类加载时初始化
- **static 方法**：无需创建对象，通过类名直接调用
- **static 块**：用于静态变量的初始化，类加载时执行一次
- **static 内部类**：独立于外部类的实例，可直接访问外部类的静态成员

------

#### 继承

> 允许一个类（子类）通过继承另一个类（父类）的属性和方法，从而实现代码的重用和扩展

##### 继承的特点

1. 单继承
   Java 中一个类只能继承一个直接父类，但可以通过实现多个接口来实现多继承的效果
2. 继承关系
   - 使用 `extends` 关键字表示继承关系。
   - 例如：`class 子类 extends 父类 { }`
3. 父类的成员
   - 子类可以继承父类的所有非私有成员（包括属性和方法）
   - 子类不能直接访问父类的私有成员，但可以通过 **getter/setter** 或 **protected** 修饰符间接访问。
4. 构造器与继承
   - 子类不能继承父类的构造器，但可以通过 `super` 关键字调用父类构造器
   - 如果子类的构造器没有显式调用父类构造器，Java 会默认调用父类的无参构造器
5. 方法重写（Overrride）
   - 子类可以重写父类的方法，以提供自己的实现
   - 重写的方法必须具有相同的方法签名，且不能缩小访问权限

##### 继承的优点

1. **代码复用**：子类可以直接使用父类的属性和方法，避免重复编写代码
2. **扩展功能**：子类可以在继承的基础上扩展新的功能
3. **多态性**：通过父类引用指向子类对象，实现动态绑定

##### 代码示例

```java
// 父类
class Animal {
    String name;

    // 父类构造器
    public Animal(String name) {
        this.name = name;
    }

    // 父类方法
    public void eat() {
        System.out.println(name + " 正在吃东西");
    }
}

// 子类
class Dog extends Animal {
    String breed;

    // 子类构造器
    public Dog(String name, String breed) {
        super(name); // 调用父类构造器
        this.breed = breed;
    }

    // 子类方法
    public void bark() {
        System.out.println(name + " 正在汪汪叫");
    }

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println(name + " 正在吃狗粮");
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建子类对象
        Dog dog = new Dog("小黑", "拉布拉多");
        
        // 调用父类方法
        dog.eat(); // 输出: 小黑 正在吃狗粮

        // 调用子类方法
        dog.bark(); // 输出: 小黑 正在汪汪叫
    }
}
```

##### super 关键字

- **调用父类构造器**：必须是子类构造器的第一行
- **访问父类成员**：在子类中可以使用 `super.成员名` 访问父类的属性或方法

```java
class Parent {
    public void display() {
        System.out.println("父类方法");
    }
}

class Child extends Parent {
    public void display() {
        super.display(); // 调用父类方法
        System.out.println("子类方法");
    }
}
```

##### final 关键字

- 修饰类：类不能被继承。
- 修饰方法：方法不能被重写
- 修饰变量：该变量有且仅能被赋值一次
- 修饰基本类型的变量，变量存储的数据不能被改变
- 修饰引用类型的变量，变量存储的地址不能被改变，但地址所指向对象的内容是可以被改变的

------

#### 多态

> 同一个方法在不同对象上表现出不同的行为。多态可以提高代码的灵活性和可扩展性

##### 多态的类型

###### 1. 编译时多态（静态多态）

- 通过 **方法重载（Overloading）** 实现
- 在编译时决定调用哪个方法

###### 2. 运行时多态（动态多态）

- 通过 **方法重写（Overriding）** 和 **父类引用指向子类对象** 实现
- 在运行时决定调用哪个方法（动态绑定）

##### 多态的实现条件

1. 存在继承或实现关系
2. 子类重写父类的方法
3. 父类引用指向子类对象（`Parent obj = new Child();`）

##### 多态的优点

1. **代码的灵活性**：可以通过父类引用操作不同子类对象
2. **代码的可扩展性**：新增子类时无需修改现有代码
3. **实现动态绑定**：在运行时根据实际对象调用对应的方法

##### 多态的注意事项

1. **运行时多态的局限性**
   父类引用只能访问父类中定义的成员，不能直接访问子类的特有成员。

   ```java
   Animal animal = new Dog();
   animal.sound(); // 可以调用
   // animal.bark(); // 错误，父类引用不能访问子类特有方法
   ```

2. **强制类型转换**
   如果需要调用子类的特有方法，可以进行强制类型转换。

   ```java
   Dog dog = (Dog) animal;
   dog.bark(); // 正确
   ```

##### 多态的实际应用

1. 接口和多态

   多态常用于接口编程，通过接口引用操作不同实现类对象

   ```java
   interface Shape {
       void draw();
   }
   
   class Circle implements Shape {
       @Override
       public void draw() {
           System.out.println("画一个圆");
       }
   }
   
   class Rectangle implements Shape {
       @Override
       public void draw() {
           System.out.println("画一个矩形");
       }
   }
   
   public class Main {
       public static void main(String[] args) {
           Shape shape1 = new Circle();
           Shape shape2 = new Rectangle();
   
           shape1.draw(); // 输出: 画一个圆
           shape2.draw(); // 输出: 画一个矩形
       }
   }
   ```

2. 集合中的多态

   Java 的集合框架广泛使用多态，例如 `List` 接口的不同实现类

   ```java
   import java.util.*;
   
   public class Main {
       public static void main(String[] args) {
           List<String> list = new ArrayList<>(); // 多态
           list.add("Java");
           list.add("Python");
   
           for (String lang : list) {
               System.out.println(lang);
           }
       }
   }
   ```

------

#### Lombok 

> Lombok 是一个 Java 的库，通过注解的方式简化代码开发，尤其是针对常见的样板代码（如 `getter`、`setter`、`toString` 等）的生成，减少手动编写的重复代码，提升开发效率

##### Lombok 的优点

1. **减少样板代码**：自动生成常见的代码，如 `getter`、`setter`、`toString`、构造器等
2. **提高可读性**：代码更简洁，关注点集中在业务逻辑
3. **轻量级**：只需引入一个依赖，无需额外配置

##### Lombok 常用注解

- `@Getter` 和 `@Setter`

- `@ToString`

- `@EqualsAndHashCode`

- `@NoArgsConstructor`、`@AllArgsConstructor` 和 `@RequiredArgsConstructor`

  - `@RequiredArgsConstructor`：生成包含 `final` 字段和 `@NonNull` 注解字段的构造器

- `@Data`

  - 综合注解，包含 `@Getter`、`@Setter`、`@ToString`、`@EqualsAndHashCode` 和 `@RequiredArgsConstructor`

- `@Builder`

  - 提供构建者模式

  ```java
  import lombok.Builder;
  
  @Builder
  public class User {
      private String name;
      private int age;
  }
  
  public class Main {
      public static void main(String[] args) {
          User user = User.builder()
                          .name("John")
                          .age(25)
                          .build();
          System.out.println(user);
      }
  }
  ```

#### 枚举类

> **枚举（Enumeration）** 是一种特殊的类，用于表示一组固定的常量；枚举在 Java 中是一个类型安全的集合，常用于定义具有有限个值的集合，例如星期、颜色、方向等；枚举类在 Java 中由 `enum` 关键字定义

##### 枚举的特点

1. **枚举是类**：枚举类型是继承自 `java.lang.Enum` 的特殊类；因此只能实现，不能继承
2. **固定值**：枚举的值在定义时固定，不可更改
3. **类型安全**：枚举类型的变量只能取枚举定义的值，避免非法值的出现
4. **支持方法和字段**：枚举可以包含字段、方法和构造器
5. **单例模式**：每个枚举值在内存中只有一个实例

##### 枚举的常用方法

Java 枚举继承自 `java.lang.Enum`，提供了一些常用方法：

| 方法              | 描述                                   |
| ----------------- | -------------------------------------- |
| `values()`        | 返回包含所有枚举常量的数组。           |
| `valueOf(String)` | 将字符串转换为对应的枚举常量。         |
| `name()`          | 返回枚举常量的名称（定义时的字符串）。 |
| `ordinal()`       | 返回枚举常量的序号（从 0 开始）。      |

```java
// 定义枚举类
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// 使用枚举
public class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today); // 输出: Today is: MONDAY
    }
}

public class Main {
    public static void main(String[] args) {
        // 遍历所有枚举值
        for (Day day : Day.values()) {
            System.out.println(day + " ordinal: " + day.ordinal());
        }

        // 使用 valueOf 方法
        Day day = Day.valueOf("FRIDAY");
        System.out.println("Selected day: " + day); // 输出: Selected day: FRIDAY
    }
}
```

------

#### 抽象类

> 抽象类是用 `abstract` 关键字修饰的类，表示它是一个不能直接实例化的类。
>
> 抽象类是面向对象编程中实现 **继承** 和 **多态** 的重要工具，主要用于定义子类的通用行为和规范

##### 抽象类的特点

1. **不能直接实例化**：抽象类只能被继承，不能用 `new` 创建对象
2. **可以包含抽象方法**：抽象方法没有方法体，必须由子类实现
3. **可以包含普通方法**：抽象类可以有具体实现的方法，子类可以直接继承或重写
4. **可以有字段**：抽象类可以定义字段，供子类使用
5. **构造器**：抽象类可以有构造器，但只能被子类调用

##### 抽象类的应用场景

1. **作为模板类**：定义通用行为，让子类实现具体细节
2. **统一接口**：抽象类可以作为一组相关类的公共父类，提供统一的接口
3. **避免重复代码**：将通用逻辑写在抽象类中，减少子类的重复代码

#### 接口

> **接口（Interface）** 是一种引用类型，类似于类，但只能包含抽象方法的定义和常量的声
>
> 接口是 Java 实现多态和多继承的核心工具
>
> 接口通过 `interface` 关键字定义，所有方法默认是 `public abstract`，所有字段默认是 `public static final`

##### 接口的特点

1. **抽象方法**：接口中的方法没有方法体（从 Java 8 开始，接口可以有默认方法和静态方法）
2. **常量**：接口中的字段默认是 `public static final`，必须初始化
3. **多继承**：一个类可以实现多个接口，接口可以继承多个接口
4. **实现约束**：实现接口的类必须提供接口中所有抽象方法的具体实现
5. **类型多态**：接口可以用作引用类型，支持多态调用

##### 接口的常用特性

###### 1. 多继承

一个接口可以继承多个接口，形成一个更大的接口。

```java
public interface LandAnimal {
    void walk();
}

public interface WaterAnimal {
    void swim();
}

// 多继承接口
public interface Amphibian extends LandAnimal, WaterAnimal {
    void liveOnLandAndWater();
}
```

###### 2. 多实现

一个类可以实现多个接口，解决单继承的局限性。

```java
public class Frog implements LandAnimal, WaterAnimal {
    @Override
    public void walk() {
        System.out.println("Frog is walking on land.");
    }

    @Override
    public void swim() {
        System.out.println("Frog is swimming in water.");
    }
}
```

##### 接口的高级用法

###### 1. 默认方法

- **用途**：为接口添加新方法时，避免影响已有实现类。
- **特点**：子类可以直接使用或重写默认方法。

```java
public interface Animal {
    void makeSound();

    default void sleep() {
        System.out.println("Default sleeping...");
    }
}

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }
}
```

###### 2. 静态方法

- **用途**：提供工具方法，与接口本身相关。
- **特点**：只能通过接口名调用，不能通过实现类或对象调用。

```java
public interface Utils {
    static void printMessage(String message) {
        System.out.println("Message: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Utils.printMessage("Hello, World!"); // 输出: Message: Hello, World!
    }
}
```

###### 3. 私有方法 (Java 9+)

- **用途**：简化默认方法或静态方法中的重复逻辑。
- **特点**：只能在接口内部使用。

```java
public interface Calculator {
    default int add(int a, int b) {
        return calculate(a, b);
    }

    default int subtract(int a, int b) {
        return calculate(a, -b);
    }

    // 私有方法
    private int calculate(int a, int b) {
        return a + b;
    }
}
```

##### 接口的实际应用

###### 1. 定义规范

接口常用于定义一组类必须遵守的行为规范。

```java
public interface Payment {
    void pay(double amount);
}

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
```

###### 2. 类型多态

接口可以用作引用类型，支持多态调用。

```java
public class Main {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.pay(100.0); // 输出: Paid 100.0 using Credit Card.

        payment = new PayPalPayment();
        payment.pay(200.0); // 输出: Paid 200.0 using PayPal.
    }
}
```

###### 3. 回调机制

接口常用于回调机制，例如事件监听器。

```java
public interface OnClickListener {
    void onClick();
}

public class Button {
    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        if (listener != null) {
            listener.onClick();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(() -> System.out.println("Button clicked!"));
        button.click(); // 输出: Button clicked!
    }
}
```

#### 抽象类和接口的区别

| 特性         | 抽象类                     | 接口                                               |
| ------------ | -------------------------- | -------------------------------------------------- |
| **关键字**   | `abstract`                 | `interface`                                        |
| **方法实现** | 可以包含具体方法和抽象方法 | 只能包含抽象方法（Java 8+ 可有默认方法和静态方法） |
| **字段**     | 可以有字段                 | 只能有常量（`public static final`）                |
| **继承**     | 一个类只能继承一个抽象类   | 一个类可以实现多个接口                             |
| **适用场景** | 表示“是什么”的关系         | 表示“能做什么”的关系                               |

------

#### 代码块

> 代码块是一组用 `{}` 包裹的代码，用于组织和控制代码的执行逻辑

##### 1. 普通代码块

**概念**

- 普通代码块是最基本的代码块，出现在方法中，用于组织逻辑代码

**特点**

- 按顺序执行
- 作用域仅限于代码块内部

**示例**

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        {
            int y = 20; // y 的作用域仅限于这个代码块
            System.out.println("x: " + x + ", y: " + y); // 输出: x: 10, y: 20
        }
        // System.out.println(y); // 编译错误，y 在此不可用
    }
}
```

##### 2. 静态代码块

**概念**

- 静态代码块使用 `static` 修饰，用于在类加载时执行初始化操作
- 静态代码块只执行一次

**特点**

- 只能访问静态变量和方法
- 通常用于初始化静态资源

**示例**

```java
public class Main {
    static int x;

    // 静态代码块
    static {
        x = 100; // 初始化静态变量
        System.out.println("Static block executed. x = " + x);
    }

    public static void main(String[] args) {
        System.out.println("Main method executed. x = " + x);
    }
}
```

**输出**

```scss
Static block executed. x = 100
Main method executed. x = 100
```

##### 3. 实例代码块

**概念**

- 实例代码块没有任何修饰符，用于初始化实例变量
- 每次创建对象时都会执行

**特点**

- 在构造方法之前执行
- 可以用于多构造器中共享的初始化逻辑

**示例**

```java
public class Main {
    int x;

    // 实例代码块
    {
        x = 50; // 初始化实例变量
        System.out.println("Instance block executed. x = " + x);
    }

    public Main() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        Main obj1 = new Main();
        Main obj2 = new Main();
    }
}
```

**输出**

```scss
Instance block executed. x = 50
Constructor executed.
Instance block executed. x = 50
Constructor executed.
```

##### 4. 同步代码块

**概念**

- 同步代码块使用 `synchronized` 关键字，用于实现线程安全。
- 只能由一个线程访问代码块，其他线程需要等待。

**特点**

- 用于保护共享资源。
- 锁对象通常是 `this` 或某个类的类对象。

**示例**

```java
public class Main {
    public void printNumbers() {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();

        Thread t1 = new Thread(() -> obj.printNumbers(), "Thread 1");
        Thread t2 = new Thread(() -> obj.printNumbers(), "Thread 2");

        t1.start();
        t2.start();
    }
}
```

**输出（顺序可能不同，但线程安全）**

```scss
mathematica复制编辑Thread 1 - 1
Thread 1 - 2
Thread 1 - 3
Thread 1 - 4
Thread 1 - 5
Thread 2 - 1
Thread 2 - 2
Thread 2 - 3
Thread 2 - 4
Thread 2 - 5
```

##### 5. 静态和实例代码块的执行顺序

**执行顺序**

1. 静态代码块（类加载时执行，且仅执行一次）。
2. 实例代码块（每次创建对象时执行）。
3. 构造方法（实例代码块执行完后立即执行）。

**示例**

```java
public class Main {
    static {
        System.out.println("Static block executed.");
    }

    {
        System.out.println("Instance block executed.");
    }

    public Main() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        new Main();
        new Main();
    }
}
```

**输出**

```scss
Static block executed.
Instance block executed.
Constructor executed.
Instance block executed.
Constructor executed.
```

##### 总结对比

| 代码块类型 | 修饰符         | 执行时机                             | 特点                             |
| ---------- | -------------- | ------------------------------------ | -------------------------------- |
| 普通代码块 | 无             | 方法执行时                           | 逻辑分组，作用域仅限代码块内部。 |
| 静态代码块 | `static`       | 类加载时，只执行一次                 | 初始化静态资源。                 |
| 实例代码块 | 无             | 每次创建对象时，构造方法之前执行     | 初始化实例变量，共享初始化逻辑。 |
| 同步代码块 | `synchronized` | 多线程访问时，根据锁对象控制执行顺序 | 实现线程安全。                   |

#### 内部类

> 内部类 是定义在另一个类内部的类
>
> 内部类可以更好地组织代码，表示与外部类有紧密关联的逻辑
>
> 内部类可以访问外部类的成员（包括私有成员），但外部类需要通过内部类对象访问内部类的成员

##### 成员内部类

**特点**

- 定义在外部类中，与外部类的实例绑定
- 可以访问外部类的所有成员（包括私有成员）
- 必须通过外部类的实例来创建内部类对象

**代码示例**

```java
public class Outer {
    private String message = "Hello from Outer class";

    // 成员内部类
    public class Inner {
        public void display() {
            System.out.println(message); // 访问外部类的私有成员
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // 创建内部类对象
        inner.display(); // 输出: Hello from Outer class
    }
}
```

##### 静态内部类

**特点**

- 使用 `static` 修饰，与外部类的实例无关
- 只能访问外部类的静态成员
- 可以直接通过外部类名创建静态内部类的对象

**代码示例**

```java
public class Outer {
    private static String message = "Hello from Outer class";

    // 静态内部类
    public static class Inner {
        public void display() {
            System.out.println(message); // 访问外部类的静态成员
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner(); // 创建静态内部类对象
        inner.display(); // 输出: Hello from Outer class
    }
}
```

##### 局部内部类

**特点**

- 定义在方法或代码块内部，作用域仅限于所在的方法或代码块
- 可以访问外部类的成员和所在方法的局部变量（但局部变量必须是 `final` 或有效 `final`）
- 通常用于封装仅在方法内部使用的逻辑

**代码示例**

```java
public class Outer {
    public void showMessage() {
        String localMessage = "Hello from Local Inner Class";

        // 局部内部类
        class Inner {
            public void display() {
                System.out.println(localMessage); // 访问局部变量
            }
        }

        Inner inner = new Inner();
        inner.display(); // 输出: Hello from Local Inner Class
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.showMessage();
    }
}
```

##### 匿名内部类

**特点**

- 没有名字的内部类，通常用于实现接口或继承类
- 适合创建只需要一次的对象
- 必须在定义时同时创建对象

**代码示例**

```java
public class Outer {
    public void greet() {
        // 匿名内部类实现接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Anonymous Inner Class");
            }
        };

        // 使用匿名内部类对象
        runnable.run();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.greet(); // 输出: Hello from Anonymous Inner Class
    }
}
```

##### **内部类的用途**

1. **逻辑分组**：将逻辑相关的类组织在一起，增加代码可读性
2. **封装**：隐藏不需要暴露给外部的实现细节
3. **访问外部类成员**：特别是外部类的私有成员
4. **简化代码**：通过匿名内部类快速实现接口或继承类

##### **总结：内部类的对比**

| 类型       | 定义位置                        | 是否与外部类实例绑定 | 访问外部类成员                  | 主要用途                       |
| ---------- | ------------------------------- | -------------------- | ------------------------------- | ------------------------------ |
| 成员内部类 | 外部类的成员位置                | 是                   | 可以访问所有成员                | 表示与外部类密切相关的类       |
| 静态内部类 | 外部类的成员位置，`static` 修饰 | 否                   | 只能访问静态成员                | 表示与外部类逻辑相关但独立的类 |
| 局部内部类 | 方法或代码块内                  | 是                   | 可以访问有效 `final` 的局部变量 | 封装仅在方法内部使用的逻辑     |
| 匿名内部类 | 方法或代码块内                  | 是                   | 可以访问有效 `final` 的局部变量 | 快速实现接口或继承类           |

#### 函数式编程

> 自 **Java 8** 开始引入了函数式编程的特性，为开发者提供了更简洁和声明式的代码风格

##### Lambda 表达式

- Lambda 表达式是函数式编程的核心，用于简化匿名内部类的语法。

- 语法

  ```java
  (参数列表) -> { 方法体 }
  ```

- 特点

  - 没有方法名
  - 可以省略参数类型和大括号（单行代码）

**示例：Lambda 表达式**

```java
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hello, Lambda!"); // 输出: Hello, Lambda!
    }
}
```

##### 方法引用

- 方法引用是 Lambda 表达式的简写形式，表示对现有方法的引用
- 语法
  - 静态方法引用：`ClassName::staticMethod`
  - 实例方法引用：`instance::instanceMethod`
  - 构造方法引用：`ClassName::new`

**示例：方法引用**

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        Arrays.sort(names, String::compareToIgnoreCase); // 使用方法引用
        Arrays.stream(names).forEach(System.out::println);
    }
}
```

##### Stream API

- **Stream API** 是 Java 提供的声明式数据处理工具，支持链式操作
- 常用操作
  - **中间操作**：`filter`、`map`、`sorted` 等
  - **终端操作**：`forEach`、`collect`、`reduce` 等

**示例：Stream API**

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 使用 Stream API 处理数据
        names.stream()
             .filter(name -> name.startsWith("A")) // 过滤以 A 开头的名字
             .map(String::toUpperCase) // 转换为大写
             .sorted() // 排序
             .forEach(System.out::println); // 输出: ALICE
    }
}
```

##### 函数式接口

- **定义**：仅包含一个抽象方法的接口，通常用于 Lambda 表达式
- **注解**：`@FunctionalInterface`（可选，但建议加上以防止误用）
- 常见函数式接口
  - `Function<T, R>`：接受一个参数，返回一个结果
  - `Consumer<T>`：接受一个参数，无返回值
  - `Supplier<T>`：无参数，返回一个结果
  - `Predicate<T>`：接受一个参数，返回布尔值
  - `BiFunction<T, U, R>`：接受两个参数，返回一个结果

**示例：自定义函数式接口**

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b; // Lambda 实现
        System.out.println(add.calculate(5, 3)); // 输出: 8
    }
}
```

##### 函数式接口详解

| 函数式接口            | 抽象方法            | 描述                         | 示例                           |
| --------------------- | ------------------- | ---------------------------- | ------------------------------ |
| `Function<T, R>`      | `R apply(T t)`      | 接受一个参数，返回一个结果。 | 转换数据类型，如字符串转整数。 |
| `Consumer<T>`         | `void accept(T t)`  | 接受一个参数，无返回值。     | 打印或保存数据。               |
| `Supplier<T>`         | `T get()`           | 无参数，返回一个结果。       | 提供默认值或生成数据。         |
| `Predicate<T>`        | `boolean test(T t)` | 接受一个参数，返回布尔值。   | 用于条件判断，如过滤数据。     |
| `BiFunction<T, U, R>` | `R apply(T t, U u)` | 接受两个参数，返回一个结果。 | 两个输入合并为一个输出         |

##### **优势和适用场景**

###### 优势

1. **简化代码**：减少样板代码，提高开发效率
2. **声明式编程**：专注于“做什么”，而非“怎么做”
3. **高性能**：Stream API 支持延迟执行和并行化处理
4. **可组合性**：通过高阶函数实现逻辑复用

###### 适用场景

- 数据流处理（过滤、转换、聚合）
- 条件判断（如筛选、验证）
- 并行计算（如大数据处理）

------

### String 引用类型

#### 基本概念

> - **String 是 Java 中的引用类型**，用于表示一组字符序列；
> - 它是 **不可变的**（immutable）：一旦创建，字符串的内容就无法更改
> - **String 是一个类**，位于 `java.lang` 包中，提供了许多方法来操作字符串
> - Java 中的字符串存储在 **字符串池** 中，可以提高性能并节省内存

#### 创建字符串

1. 通过字面量：

   ```java
   String str1 = "Hello";
   ```

   - 字符串常量存储在字符串池中

2. 通过构造器：

   ```java
   String str2 = new String("Hello");
   ```

   - 显式创建一个新的字符串对象

#### 常用方法总结

| 方法                                                     | 描述                                                   | 示例                                         |
| -------------------------------------------------------- | ------------------------------------------------------ | -------------------------------------------- |
| `length()`                                               | 返回字符串的长度。                                     | `"Hello".length()` → 5                       |
| `charAt(int index)`                                      | 返回指定索引处的字符。                                 | `"Hello".charAt(1)` → 'e'                    |
| `substring(int beginIndex)`                              | 返回从指定索引开始的子字符串。                         | `"Hello".substring(1)` → "ello"              |
| `substring(int begin, int end)`                          | 返回从开始索引到结束索引的子字符串（不包含结束索引）。 | `"Hello".substring(1, 4)` → "ell"            |
| `indexOf(String str)`                                    | 返回字符串首次出现的位置，找不到返回 -1。              | `"Hello".indexOf("l")` → 2                   |
| `lastIndexOf(String str)`                                | 返回字符串最后一次出现的位置。                         | `"Hello".lastIndexOf("l")` → 3               |
| `toLowerCase()`                                          | 转换为小写字母。                                       | `"Hello".toLowerCase()` → "hello"            |
| `toUpperCase()`                                          | 转换为大写字母。                                       | `"Hello".toUpperCase()` → "HELLO"            |
| `trim()`                                                 | 去除字符串两端的空格。                                 | `" Hello ".trim()` → "Hello"                 |
| `equals(Object obj)`                                     | 比较字符串内容是否相同。                               | `"Hello".equals("hello")` → false            |
| `equalsIgnoreCase(String)`                               | 忽略大小写比较字符串内容是否相同。                     | `"Hello".equalsIgnoreCase("hello")` → true   |
| `startsWith(String prefix)`                              | 检查字符串是否以指定前缀开头。                         | `"Hello".startsWith("He")` → true            |
| `endsWith(String suffix)`                                | 检查字符串是否以指定后缀结尾。                         | `"Hello".endsWith("lo")` → true              |
| `replace(char oldChar, char newChar)`                    | 替换所有指定字符。                                     | `"Hello".replace('l', 'x')` → "Hexxo"        |
| `replaceAll(String regex, String replacement)`           | 使用正则表达式替换所有匹配的子字符串。                 | `"abc123".replaceAll("\\d", "#")` → "abc###" |
| `split(String regex)`                                    | 按正则表达式分割字符串，返回数组。                     | `"a,b,c".split(",")` → ["a", "b", "c"]       |
| `contains(CharSequence cs)`                              | 检查字符串是否包含指定的字符序列。                     | `"Hello".contains("ll")` → true              |
| `isEmpty()`                                              | 检查字符串是否为空（长度为 0）。                       | `"".isEmpty()` → true                        |
| `join(CharSequence delimiter, CharSequence... elements)` | 使用分隔符拼接多个字符串。                             | `String.join("-", "a", "b", "c")` → "a-b-c"  |
| `matches(String regex)`                                  | 检查字符串是否匹配正则表达式。                         | `"12345".matches("\\d+")` → true             |

### GUI（了解即可）

> Java 的 GUI（Graphical User Interface）编程用于开发桌面应用程序。Java 提供了多种框架和工具来实现图形用户界面，其中最常用的是 **AWT** 和 **Swing**

#### Java GUI 编程的核心框架

##### 1、AWT（Abstract Window Toolkit）

- Java 最早的 GUI 框架，提供了一组基本的组件（如按钮、文本框等）
- 依赖于本地系统的 GUI 实现，具有平台相关性
- 组件较为基础，功能有限，不推荐用于现代开发

##### 2、Swing

- 基于 AWT 的增强版，是 Java 中最常用的 GUI 框架
- 提供更丰富的组件（如表格、树、选项卡等）
- **跨平台**：完全由 Java 实现，与操作系统无关
- 支持更灵活的外观和样式

------

## 三、异常处理

> 异常（Exception）是程序运行过程中出现的错误或意外情况。Java 提供了异常处理机制来捕获和处理这些错误，从而使程序能够继续运行或安全退出

### 异常的分类

Java 的异常分为两大类：

1. **检查异常（Checked Exception）**

   - 在编译时被检查，必须显式地处理（通过 `try-catch` 或 `throws` 声明）
   - 例如：`IOException`、`SQLException`
   - 适用于可以预见的异常

   ```java
   import java.io.*;
   
   public class CheckedExceptionExample {
       public static void main(String[] args) {
           try {
               // 可能抛出 IOException
               BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
               String line = reader.readLine();
               System.out.println(line);
               reader.close();
           } catch (IOException e) {
               // 捕获并处理 IOException
               System.out.println("File not found or error reading file: " + e.getMessage());
           } finally {
               System.out.println("Execution completed.");
           }
       }
   }
   ```

2. **运行时异常（Unchecked Exception）**

   - 在运行时抛出，不强制要求处理
   - 继承自 `RuntimeException`
   - 例如：`NullPointerException`、`ArrayIndexOutOfBoundsException`
   - 通常是由于编程错误导致的

   ```java
   public class RuntimeExceptionExample {
       public static void main(String[] args) {
           int[] numbers = {1, 2, 3};
           try {
               // 可能抛出 ArrayIndexOutOfBoundsException
               System.out.println(numbers[5]);
           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Array index out of bounds: " + e.getMessage());
           }
       }
   }
   ```

3. **错误（Error）**：

   - 严重错误，通常是 JVM 无法恢复的情况
   - 继承自 `Error` 类
   - 例如：`OutOfMemoryError`、`StackOverflowError`

### 异常对比

| **类别**       | **继承自**         | **处理要求**                            | **常见示例**                                                 | **适用场景**                                           |
| -------------- | ------------------ | --------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------ |
| **检查异常**   | `Exception`        | 必须显式处理（`try-catch` 或 `throws`） | `IOException`, `SQLException`, `FileNotFoundException`       | 可预见的异常，通常与外部资源交互相关（如文件、数据库） |
| **运行时异常** | `RuntimeException` | 可选处理，不强制要求                    | `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException` | 编程错误或逻辑错误导致的异常                           |
| **错误**       | `Error`            | 无法处理或恢复                          | `OutOfMemoryError`, `StackOverflowError`, `VirtualMachineError` | 系统级问题或 JVM 层面问题                              |

### 自定以异常

```java
// 自定义异常类
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
        System.out.println("Age is valid.");
    }
}

```

### 多个异常处理

```java
public class MultipleExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // ArithmeticException
            int[] arr = new int[2];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        } finally {
            System.out.println("End of program.");
        }
    }
}
```

### finally 用法

资源释放场景：

```java
import java.io.*;

public class FinallyExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("Reader closed.");
                }
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}
```

### 异常处理的注意事项

1. 不要滥用异常
   - 异常应该用于处理意外情况，而不是控制正常的程序流程
2. 优先捕获具体异常
   - 捕获异常时，优先从具体到通用（`Exception` 是最通用的异常类型）
3. 善用 `finally`
   - 用于释放资源（如关闭文件、网络连接等）
4. 日志记录
   - 捕获异常时，建议记录日志以便于调试和维护

------

## 四、泛型

### 1.基本概念

> Java 泛型（Generics）是一种语言特性，允许在类、接口和方法中定义类型参数，使代码更具 **类型安全性** 和 **可读性**。泛型通过在编译时检查类型，避免了运行时的类型转换错误

### 2.泛型的优点

1. **类型安全**：在编译时检查类型错误
2. **消除强制类型转换**：减少类型转换的代码
3. **提高代码复用性**：可以定义适用于多种类型的类和方法

### 3. 泛型的使用

#### 泛型类

定义和使用带类型参数的类

**语法：**

```java
class ClassName<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
```

**示例：**

```java
class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

public class GenericClassExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello, Generics!");
        System.out.println(stringBox.getContent());

        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(123);
        System.out.println(integerBox.getContent());
    }
}
```

#### 泛型方法

定义和使用带类型参数的方法。

**语法：**

```java
class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

**示例：**

```java
public class GenericMethodExample {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Generics", "Example"};

        printArray(intArray);  // 输出: 1 2 3 4 5
        printArray(strArray);  // 输出: Java Generics Example
    }
}
```

#### 泛型接口

定义和实现带类型参数的接口。

**语法：**

```java
interface Pair<K, V> {
    K getKey();
    V getValue();
}
```

**示例：**

```java
class KeyValuePair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new KeyValuePair<>("Age", 25);
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
    }
}
```

#### 通配符（Wildcard）

使用 `?` 表示不确定的类型，分为以下三种：

1. **无界通配符**：`?`，表示任意类型
2. **上界通配符**：`? extends Type`，表示某个类型的子类
3. **下界通配符**：`? super Type`，表示某个类型的父类

**示例：**

```java
import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<String> strList = List.of("Java", "Generics");

        printList(intList);  // 输出: 1 2 3
        printList(strList);  // 输出: Java Generics
    }
}
```

### 4. 泛型的限制

1. 类型擦除
   - Java 的泛型在运行时会被擦除，实际类型信息不会保留
   - 例如，`List<String>` 和 `List<Integer>` 在运行时都是 `List`
2. 不能使用基本类型
   - 泛型类型参数只能使用引用类型，不能使用基本类型（如 `int`）
   - 可通过包装类（如 `Integer`）解决
3. 不能创建泛型数组
   - 例如：`T[] array = new T[10];` 会报错

### 5. 总结

- **泛型类**：为类定义类型参数，支持多种类型的实例化
- **泛型方法**：为方法定义类型参数，支持不同类型的操作
- **泛型接口**：为接口定义类型参数，支持多种实现
- **通配符**：灵活处理不确定类型

------

## 五、集合框架

> Java 集合框架（Java Collections Framework, JCF）是一个提供常用数据结构和算法的标准库。它包含了一组接口和实现类，用于存储和操作数据。集合框架使得开发者能够轻松处理动态大小的数据集合，如列表、集合、映射等

### 分类

Java 集合框架主要分为三大类：

1. List（列表）
   - 有序集合，允许重复元素
   - 实现类：`ArrayList`、`LinkedList`、`Vector`
2. Set（集合）
   - 无序集合，不允许重复元素
   - 实现类：`HashSet`、`LinkedHashSet`、`TreeSet`
3. Map（映射）
   - 键值对集合，键唯一，值可以重复
   - 实现类：`HashMap`、`LinkedHashMap`、`TreeMap`、`Hashtable`

此外，还有 **Queue（队列）** 和 **Deque（双端队列）**，用于特殊的队列操作

图片来源：https://oss.javaguide.cn/github/javaguide/java/collection/java-collection-hierarchy.png

![Java 集合框架概览](https://oss.javaguide.cn/github/javaguide/java/collection/java-collection-hierarchy.png)

### 不同集合的特点

| **集合类型** | **实现类**      | **特点**                                                   |
| ------------ | --------------- | ---------------------------------------------------------- |
| **List**     | `ArrayList`     | 动态数组，有序，允许重复元素，查询性能高，增删性能低       |
|              | `LinkedList`    | 双向链表，有序，允许重复元素，增删性能高，查询性能低       |
|              | `Vector`        | 线程安全的动态数组，性能较低，较少使用                     |
| **Set**      | `HashSet`       | 基于哈希表，无序，不允许重复元素，性能高                   |
|              | `LinkedHashSet` | 基于哈希表，有序，不允许重复元素，插入顺序保留             |
|              | `TreeSet`       | 基于红黑树，有序（按自然顺序或比较器排序），不允许重复元素 |
| **Map**      | `HashMap`       | 基于哈希表，无序，键唯一，允许一个键对应 `null` 值         |
|              | `LinkedHashMap` | 基于哈希表，有序（插入顺序），键唯一                       |
|              | `TreeMap`       | 基于红黑树，有序（按键的自然顺序或比较器排序），键唯一     |
|              | `Hashtable`     | 线程安全的哈希表，不允许键或值为 `null`，性能较低          |
| **Queue**    | `PriorityQueue` | 基于堆的优先队列，元素按优先级排序                         |
|              | `LinkedList`    | 可作为队列使用，按插入顺序存储元素                         |
| **Deque**    | `ArrayDeque`    | 双端队列，允许在两端插入和删除元素，性能高                 |

### 遍历方式

> 可以使用多种方式遍历集合，主要包括 **for-each 循环、普通 for 循环、Iterator 迭代器、Stream API、forEach 方法** 等

#### **1. 使用 for-each 遍历（增强 for 循环）**

**适用于：** `List`、`Set`、`Map`（使用 `entrySet()`）

**优点：** 代码简洁，可读性好
**缺点：** 无法修改集合（不能删除元素）

**示例：**

```java
import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        for (String lang : list) {
            System.out.println(lang);
        }
    }
}
```

#### **2. 使用普通 for 循环（仅适用于 List）**

**适用于：** `List`（基于索引访问）

**优点：** 适用于 `List`，可以修改元素
**缺点：** 不适用于 `Set` 和 `Map`，`LinkedList` 访问效率较低

**示例：**

```java
import java.util.ArrayList;
import java.util.List;

public class ForLoopExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
```

#### **3. 使用 Iterator 迭代器遍历**

**适用于：** `List`、`Set`、`Map`（使用 `entrySet().iterator()`）

**优点：** 可安全删除元素，不会抛出 `ConcurrentModificationException`
**缺点：** 代码稍显复杂

**示例：**

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String lang = iterator.next();
            System.out.println(lang);
        }
    }
}
```

#### **4. 使用 ListIterator（双向迭代器，仅适用于 List）**

**适用于：** `List`（支持向前向后遍历）

**优点：** 可修改元素，支持双向遍历
**缺点：** 仅适用于 `List`，不能用于 `Set` 和 `Map`

**示例（正向遍历）：**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
```

**示例（反向遍历）：**

```java
while (listIterator.hasPrevious()) {
    System.out.println(listIterator.previous());
}
```

#### **5. 使用 forEach() 方法（Java 8+）**

**适用于：** `List`、`Set`、`Map`（使用 `forEach((k,v) -> {...})`）

**优点：** 代码简洁，推荐使用
**缺点：** 不能修改元素（但 `Map.forEach` 可以操作键值对）

**示例（遍历 List）：**

```java
import java.util.ArrayList;
import java.util.List;

public class ForEachMethodExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        list.forEach(System.out::println);
    }
}
```

**示例（遍历 Map）：**

```java
import java.util.HashMap;
import java.util.Map;

public class MapForEachExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 90);
        map.put("Python", 85);
        map.put("C++", 95);

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
```

------

#### **6. 使用 Stream API（Java 8+）**

**适用于：** `List`、`Set`、`Map`（使用 `entrySet().stream()`）

**优点：** 可并行处理，支持流式计算
**缺点：** 仅用于遍历，不适用于删除操作

**示例（遍历 List）：**

```java
import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        list.stream().forEach(System.out::println);
    }
}
```

**示例（遍历 Map）：**

```java
import java.util.HashMap;
import java.util.Map;

public class MapStreamExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 90);
        map.put("Python", 85);
        map.put("C++", 95);

        map.entrySet().stream().forEach(entry ->
            System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
```

#### **7. 遍历 Map 的方式总结**

| **方式**                     | **代码示例**                                                 |
| ---------------------------- | ------------------------------------------------------------ |
| `for-each` 遍历 `keySet()`   | `for (String key : map.keySet()) {}`                         |
| `for-each` 遍历 `entrySet()` | `for (Map.Entry<K, V> entry : map.entrySet()) {}`            |
| `forEach()` 方法（Java 8+）  | `map.forEach((k, v) -> {...})`                               |
| `Iterator` 迭代器遍历        | `Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();` |
| `Stream API` 遍历（Java 8+） | `map.entrySet().stream().forEach(entry -> {...})`            |

------

#### **总结**

| **遍历方式**     | **适用集合**         | **优点**                | **缺点**                   |
| ---------------- | -------------------- | ----------------------- | -------------------------- |
| **for-each**     | `List`, `Set`        | 简洁直观                | 不能删除元素               |
| **普通 for**     | `List`               | 适用于索引访问          | 只适用于 `List`            |
| **Iterator**     | `List`, `Set`        | 可安全删除元素          | 代码较复杂                 |
| **ListIterator** | `List`               | 支持双向遍历            | 仅适用于 `List`            |
| **forEach()**    | `List`, `Set`, `Map` | 代码简洁（Java 8+）     | 不能删除元素               |
| **Stream API**   | `List`, `Set`, `Map` | 支持并行计算（Java 8+） | 只用于遍历，不适合删除操作 |

在实际开发中，推荐使用 **forEach()** 或 **Stream API** 来遍历集合，除非需要删除元素，否则不建议使用 `Iterator`

------

## 六、File-IO 流

> Java 提供了 `java.io` 和 `java.nio` 两个主要的包来处理文件和输入/输出操作。其中，`File` 类用于表示文件或目录，而 `IO` 相关的类用于读写文件或流数据

### File 类

> File 是 java.io 包下的类，File类的对象可以代表文件/文件夹，并可以调用其提供的方法对文件进行操作

主要操作包含：

- 创建文件或目录
- 删除文件或目录
- 获取文件信息（路径、大小、权限等）
- 遍历目录

#### File 类的常见方法

| **方法**            | **描述**              |
| ------------------- | --------------------- |
| `createNewFile()`   | 创建新文件            |
| `mkdir()`           | 创建目录              |
| `mkdirs()`          | 创建多级目录          |
| `exists()`          | 判断文件/目录是否存在 |
| `delete()`          | 删除文件/目录         |
| `getName()`         | 获取文件名            |
| `getAbsolutePath()` | 获取绝对路径          |
| `length()`          | 获取文件大小（字节）  |
| `listFiles()`       | 列出目录下的文件      |

#### 文件操作示例

```java
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            // 不带盘符，默认直接到当前工程下的目录寻找文件
            File file = new File("example.txt");

            // 创建文件
            if (file.createNewFile()) {
                System.out.println("文件创建成功: " + file.getAbsolutePath());
            } else {
                System.out.println("文件已存在");
            }

            // 获取文件信息
            System.out.println("文件名: " + file.getName());
            System.out.println("文件大小: " + file.length() + " 字节");
            System.out.println("是否可写: " + file.canWrite());
            System.out.println("是否可读: " + file.canRead());

            // 删除文件
            if (file.delete()) {
                System.out.println("文件已删除");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### 文件遍历的方法

`File` 类提供了方法来遍历目录中的文件和子目录。主要的方法如下：

##### 1. list() 方法（返回 String[] 文件名数组）

- 适用于获取目录下的文件和子目录的名称（不包含完整路径）
- 不能区分文件和目录

```java
import java.io.File;

public class ListMethodExample {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // 指定要遍历的目录

        String[] files = dir.list(); // 获取文件和目录名
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }
    }
}
```

##### 2. listFiles() 方法（返回 File[] 对象数组）

- 适用于获取目录下的所有文件和子目录的 `File` 对象，包含完整路径
- 可以通过 `isFile()` 和 `isDirectory()` 进行区分

```java
import java.io.File;

public class ListFilesExample {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // 指定目录
        File[] files = dir.listFiles(); // 获取 `File` 数组

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("[文件] " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("[目录] " + file.getName());
                }
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }
    }
}
```

##### 3. listFiles(FilenameFilter filter) 方法（按条件筛选文件）

- 适用于 **过滤指定类型的文件**，如 `.txt` 文件。

```java
import java.io.File;
import java.io.FilenameFilter;

public class ListFilteredFilesExample {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public");

        // 仅列出 .txt 文件
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // 只返回 .txt 文件
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("目录不存在或无匹配文件");
        }
    }
}
```

##### 4. listFiles(FileFilter filter) 方法（使用 FileFilter 过滤）

- 适用于 **更灵活的过滤条件**，比如筛选文件大小、隐藏文件等

```java
import java.io.File;
import java.io.FileFilter;

public class ListFileFilterExample {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public");

        // 过滤出所有大于1KB的文件
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.length() > 1024; // 仅列出大于1KB的文件
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName() + " (" + file.length() + " bytes)");
            }
        } else {
            System.out.println("目录不存在或无匹配文件");
        }
    }
}
```

------

##### 5. 递归遍历所有文件和子目录

- 适用于 **遍历整个目录结构**，包括子目录中的文件

```java
import java.io.File;

public class RecursiveListFiles {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Public"); // 指定根目录
        listAllFiles(dir); // 调用递归方法
    }

    public static void listAllFiles(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles(); // 获取当前目录下的所有文件和子目录
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("[目录] " + file.getAbsolutePath());
                        listAllFiles(file); // 递归遍历子目录
                    } else {
                        System.out.println("[文件] " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }
    }
}
```

##### 总结

| **方法**                           | **返回值**             | **特点**                                 | **适用场景**       |
| ---------------------------------- | ---------------------- | ---------------------------------------- | ------------------ |
| `list()`                           | `String[]`             | 返回文件和目录的名称（不含完整路径）     | 仅获取名称         |
| `listFiles()`                      | `File[]`               | 返回 `File` 对象数组（可区分文件和目录） | 获取完整路径和属性 |
| `listFiles(FilenameFilter filter)` | `File[]`               | 按名称过滤，如 `.txt`                    | 按文件类型筛选     |
| `listFiles(FileFilter filter)`     | `File[]`               | 按 `File` 过滤，如文件大小               | 复杂筛选           |
| **递归遍历**                       | 递归调用 `listFiles()` | 遍历所有文件和子目录                     | 深度遍历           |

### 字符集

> 字符集（Charset）是一种 **字符映射** 方式，它定义了 **字符到字节的映射关系**，用于字符的存储和传输

Java 中 `Charset` 类（`java.nio.charset.Charset`）用于表示字符集，支持多种字符编码（如 **UTF-8、ISO-8859-1、GBK**）

常见字符集：

| **字符集**       | **简介**                                                 |
| ---------------- | -------------------------------------------------------- |
| **ASCII**        | 仅支持 128 个字符（A-Z、a-z、0-9、基本符号），1 字节表示 |
| **ISO-8859-1**   | 拉丁字母编码（1 字节），不支持中文                       |
| **GBK / GB2312** | 中文编码（兼容 ASCII，2 字节编码汉字）                   |
| **UTF-8**        | 可变长编码（ASCII 1 字节，中文 3 字节）                  |
| **UTF-16**       | 16-bit 编码（2 或 4 字节）                               |
| **UTF-32**       | 直接使用 4 字节存储（占用空间大）                        |

####  编解码（Encoding & Decoding）

**（1）字符串 → 字节数组（编码 Encoding）**

- 将 **字符串转换为字节数组**（指定字符集）

```java
import java.nio.charset.StandardCharsets;

public class EncodingExample {
    public static void main(String[] args) {
        String text = "你好，世界"; // Unicode 字符串
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8); // UTF-8 编码
        byte[] gbkBytes = text.getBytes(java.nio.charset.Charset.forName("GBK")); // GBK 编码

        System.out.println("UTF-8 编码: " + new String(utf8Bytes, StandardCharsets.UTF_8));
        System.out.println("GBK 编码: " + new String(gbkBytes, java.nio.charset.Charset.forName("GBK")));
    }
}
```

**说明：**

- `getBytes(Charset charset)` 用于 **编码字符串**
- `StandardCharsets.UTF_8` 是 **标准字符集**（避免 `UnsupportedEncodingException`）

------

**（2）字节数组 → 字符串（解码 Decoding）**

- 通过 **指定字符集** 解析字节数组

```java
import java.nio.charset.StandardCharsets;

public class DecodingExample {
    public static void main(String[] args) {
        byte[] utf8Bytes = { -28, -67, -96, -27, -91, -67 }; // "你好" 的 UTF-8 编码
        String decodedStr = new String(utf8Bytes, StandardCharsets.UTF_8);
        System.out.println("解码后字符串: " + decodedStr);
    }
}
```

### IO 流

> IO（Input/Output，输入/输出）流是 Java **处理数据读写的机制**，用于 **文件、网络、内存、控制台等** 数据的输入和输出
>
> Java IO 以 **流（Stream）** 形式操作数据，流是一组有序的数据序列，数据可以 **按字节或字符单位** 进行读取或写入

### IO 流的分类

Java 的 IO 流可以从不同角度进行分类：

| **分类**       | **描述**                                                     | **示例类**                                                   |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **按数据单位** | 处理 **字节**（binary data）或 **字符**（text data）         | **字节流**（InputStream/OutputStream） **字符流**（Reader/Writer） |
| **按流向**     | **输入流（读取数据）** / **输出流（写入数据）**              | **输入流**（FileInputStream, FileReader） **输出流**（FileOutputStream, FileWriter） |
| **按功能**     | **节点流（直接操作数据源）** / **处理流（对流进行包装和增强）** | **节点流**（FileInputStream, FileReader） **处理流**（BufferedReader, DataInputStream） |

### IO 流体系结构

Java IO 流主要由 **字节流（处理二进制数据）** 和 **字符流（处理文本数据）** 组成：

#### （1）字节流（InputStream/OutputStream）

- **按字节单位** 读写数据，适合 **图片、视频、音频、二进制文件** 处理
- 抽象基类：
  - **输入流（读取）：** `InputStream`
  - **输出流（写入）：** `OutputStream`

| **字节输入流（InputStream）** | **字节输出流（OutputStream）** | **功能**                 |
| ----------------------------- | ------------------------------ | ------------------------ |
| `FileInputStream`             | `FileOutputStream`             | **操作文件**（字节方式） |
| `ByteArrayInputStream`        | `ByteArrayOutputStream`        | **操作内存**（字节数组） |
| `DataInputStream`             | `DataOutputStream`             | **读写基本数据类型**     |
| `BufferedInputStream`         | `BufferedOutputStream`         | **带缓冲，提高性能**     |

------

#### （2）字符流（Reader/Writer）

- **按字符单位** 读写数据，适合 **文本文件（.txt, .csv, .java, .xml）** 处理
- 抽象基类：
  - **输入流（读取）：** `Reader`
  - **输出流（写入）：** `Writer`

| **字符输入流（Reader）** | **字符输出流（Writer）** | **功能**                 |
| ------------------------ | ------------------------ | ------------------------ |
| `FileReader`             | `FileWriter`             | **操作文件**（字符方式） |
| `BufferedReader`         | `BufferedWriter`         | **带缓冲，提高性能**     |
| `CharArrayReader`        | `CharArrayWriter`        | **操作字符数组**         |
| `StringReader`           | `StringWriter`           | **操作字符串**           |

------

#### **（3）处理流（包装流）**

**处理流是对节点流进行功能增强的包装流**，如 **缓存（Buffered）**、**数据类型处理（DataInputStream）** 等。

```
java复制编辑BufferedReader br = new BufferedReader(new FileReader("test.txt"));
```

| **处理流**                                     | **作用**                                         |
| ---------------------------------------------- | ------------------------------------------------ |
| `BufferedReader` / `BufferedWriter`            | **提高字符流读写性能**（带缓冲区）               |
| `BufferedInputStream` / `BufferedOutputStream` | **提高字节流读写性能**                           |
| `DataInputStream` / `DataOutputStream`         | **支持基本数据类型读写**（int、double、boolean） |
| `ObjectInputStream` / `ObjectOutputStream`     | **支持对象序列化**（保存对象到文件或网络传输）   |

------

### IO 代码示例

#### （1）使用 FileInputStream 读取文件（字节流）

```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            int data;
            while ((data = fis.read()) != -1) { // 逐字节读取
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

------

#### **（2）使用 FileReader 读取文件（字符流）**

```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("test.txt")) {
            int data;
            while ((data = fr.read()) != -1) { // 逐字符读取
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

------

#### **（3）使用 BufferedReader 读取文件（高效读取）**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // 按行读取
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

------

#### **（4）使用 FileOutputStream 写入文件**

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String text = "Hello, Java IO!";
            fos.write(text.getBytes()); // 字符串转字节写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

------

#### **（5）使用 FileWriter 写入文件**

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write("Hello, Java IO!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

------

###  NIO

**NIO（非阻塞 IO）** 是 Java 1.4 引入的新 IO 方式，基于 **Channel、Buffer、Selector** 设计，适用于 **高性能网络编程**

| **IO 方式**            | **特点**                                                     |
| ---------------------- | ------------------------------------------------------------ |
| **传统 IO（java.io）** | **面向流（Stream）**，一个线程 **只能** 处理一个连接（阻塞） |
| **NIO（java.nio）**    | **面向缓冲区（Buffer）**，一个线程 **可管理多个连接**（非阻塞） |

NIO 适用于 **高并发网络编程**（如 Netty 框架），但对于普通文件读写，传统 IO **更简单易用**

### IO 相关的第三方库

常见的有：

| **库名称**            | **功能**                                       | **适用场景**                   |
| --------------------- | ---------------------------------------------- | ------------------------------ |
| **Apache Commons IO** | 提供流操作、文件处理、文件监控等工具           | **文件 IO 处理**（高效、简洁） |
| **Google Guava IO**   | 提供 IO 工具（如 `Files`、`ByteSource` 等）    | **增强 Java 原生 IO API**      |
| **Logback / Log4j2**  | 高效日志管理（内部 IO 处理）                   | **日志写入、文件管理**         |
| **Netty**             | 高性能异步 IO 框架                             | **高并发网络编程**             |
| **Okio**              | Square 开发的高效 IO 库，适用于 Android 和 JVM | **流式处理、文件操作**         |

#### 1. Apache Commons IO

**Apache Commons IO** 是一个流行的 **IO 工具库**，提供了 **简化 IO 操作的方法**，比如：

- **读取/写入文件**
- **流处理（IOUtils）**
- **文件监控（FileAlterationMonitor）**

**示例 ：使用 FileUtils 读取文件**

```java
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommonsIoExample {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");

        // 读取文件内容
        String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println("文件内容：" + content);

        // 写入文件
        FileUtils.writeStringToFile(file, "Hello Commons IO!", StandardCharsets.UTF_8, true);
    }
}
```

✅ **优点**：比 `FileReader` 和 `BufferedReader` **更简洁**，避免了手动管理流。

------

**示例 2：使用 IOUtils 复制流**

```Java
import org.apache.commons.io.IOUtils;
import java.io.*;

public class CopyStreamExample {
    public static void main(String[] args) throws IOException {
        try (InputStream input = new FileInputStream("input.txt");
             OutputStream output = new FileOutputStream("output.txt")) {
            
            // 复制流数据
            IOUtils.copy(input, output);
        }
    }
}
```

✅ **优点**：比 `while ((data = in.read()) != -1)` **更简洁**。

------

#### 2. Google Guava IO

`Guava IO` 提供类似 `Commons IO` 的功能，并支持更多 **流式操作**。

**示例：读取文件**

```java
import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class GuavaIoExample {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");

        // 读取文件
        String content = Files.asCharSource(file, StandardCharsets.UTF_8).read();
        System.out.println("文件内容：" + content);
    }
}
```

------

#### 3. Netty（高性能异步 IO）

Netty 是一个 **异步网络通信框架**，用于高性能 TCP/UDP 开发，适用于 **游戏服务器、RPC** 等。

**示例：Netty 服务器**

```java
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .childHandler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel ch) {
                             ch.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
                                 @Override
                                 protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
                                     System.out.println("收到消息: " + msg);
                                 }
                             });
                         }
                     });

            ChannelFuture future = bootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
```

✅ **优点**：

- 高性能（基于 **NIO**，支持 **零拷贝**）
- 事件驱动（支持 **TCP/UDP**）
- 适用于高并发 **WebSocket**、**RPC** 服务器

------

#### 总结

不同 **IO 框架** 适用于不同场景：

| **框架/库**           | **适用场景**                         | **优点**                            |
| --------------------- | ------------------------------------ | ----------------------------------- |
| **Apache Commons IO** | **文件读写、流复制**                 | 简洁、高效，避免手动管理流          |
| **Google Guava IO**   | **增强 Java IO**                     | 提供 `Files`、`ByteSource` 等工具类 |
| **Netty**             | **高性能网络通信（TCP/UDP）**        | 异步 IO，高并发、事件驱动           |
| **Okio**              | **高效数据流操作（适用于 Android）** | 内存优化、流式处理                  |

如果做的是 **本地文件处理**，推荐 **Apache Commons IO**；
如果做的是 **高并发网络通信**，推荐 **Netty**。 🚀

## 七、多线程

> **多线程（Multithreading）** 允许一个程序同时执行多个任务，提高 **CPU 利用率** 和 **程序效率**
>
> Java 的多线程基于 **Java Thread API** 和 **操作系统线程** 实现

### Java 创建线程的几种方式

| **方式**                       | **特点**                                     | **适用场景**                            |
| ------------------------------ | -------------------------------------------- | --------------------------------------- |
| **继承 Thread 类**             | 代码简单，直接重写 `run()`                   | 适用于 **小规模任务**，不需要共享资源   |
| **实现 Runnable 接口**         | 更灵活，多个线程可共享同一个 `Runnable` 实例 | **推荐使用**，避免 Java 单继承限制      |
| **实现 Callable 接口**         | `Callable` 可以有 **返回值**，支持异常抛出   | 适用于需要 **获取线程执行结果** 的情况  |
| **使用线程池 ExecutorService** | 线程复用，提高性能，减少资源开销             | **推荐使用**，适用于 **大规模线程管理** |

#### 方式 1：继承 Thread 类

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.start();
        thread2.start();
    }
}
```

✅ **优点**：简单易用
❌ **缺点**：**单继承**，限制了扩展性

------

#### 方式 2：实现 Runnable 接口

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
    }
}
```

✅ **优点**：**避免单继承限制**，可共享 `Runnable` 实例
❌ **缺点**：不能直接返回结果

------

#### 方式 3：实现 Callable 接口（带返回值）

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 10;
    }
}

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> result = executor.submit(new MyCallable());

        System.out.println("Callable 线程返回结果：" + result.get());
        executor.shutdown();
    }
}
```

✅ **优点**：可以 **返回结果**，支持异常处理
❌ **缺点**：需要 `Future.get()` **阻塞获取结果**，可能影响性能

------

#### 方式 4：使用线程池（Executor 框架）

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 创建线程池
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> System.out.println("线程 " + Thread.currentThread().getName() + " 执行任务"));
        }
        executor.shutdown(); // 关闭线程池
    }
}
```

✅ **优点**：

- **复用线程**，避免频繁创建线程导致性能下降
- **适用于大规模任务**

❌ **缺点**：

- 需要正确管理 `shutdown()`，避免 **线程池泄漏**

------

#### 总结

| **方式**                 | **优点**                           | **缺点**                               | **适用场景**                              |
| ------------------------ | ---------------------------------- | -------------------------------------- | ----------------------------------------- |
| **继承 Thread**          | 代码简单，适用于小任务             | 受 **单继承** 限制                     | 适用于 **小任务，不需要共享资源**         |
| **实现 Runnable**        | 可共享实例，避免单继承             | 无法 **返回结果**                      | 适用于 **并发任务**，多个线程共享同一对象 |
| **实现 Callable**        | **支持返回值** 和 **异常处理**     | 需要 `Future.get()` 获取结果，可能阻塞 | 适用于 **需要获取返回值的任务**           |
| **使用 Executor 线程池** | **线程复用**，适用于**大规模任务** | 需要手动 **管理线程池**                | 适用于 **高并发、大量短任务**             |

在实际开发中：

- 频繁创建线程 **会消耗大量资源**，**推荐使用** `ExecutorService` **线程池**。
- 需要返回值时，**使用 Callable + Future**。
- **简单任务** 可用 `Runnable`。

🚀 **如果是高并发场景，推荐使用线程池（ExecutorService）来管理线程！**

### 线程常用 API

`Thread` 类提供了多个常用的方法，用于控制线程的 **创建、运行、同步、休眠** 等操作

| **方法**          | **作用**         | **适用场景**         |
| ----------------- | ---------------- | -------------------- |
| `start()`         | 启动线程         | 创建并执行线程       |
| `sleep(ms)`       | 线程休眠         | 限流、定时任务       |
| `join()`          | 等待线程执行完成 | 线程依赖顺序         |
| `yield()`         | 让出 CPU         | 提高 CPU 调度效率    |
| `interrupt()`     | 中断线程         | 终止长时间运行线程   |
| `setDaemon(true)` | 设置守护线程     | 后台服务，如日志监控 |
| `currentThread()` | 获取当前线程     | 获取线程信息         |
| `isAlive()`       | 检测线程是否存活 | 线程状态检查         |
| `setPriority()`   | 设置线程优先级   | 任务调度优化         |
| `synchronized`    | 线程同步         | 共享资源互斥访问     |

### 线程同步

> 在多线程环境下，如果多个线程同时访问 **共享资源**，可能会导致**数据不一致**（竞态条件）。线程同步（Synchronization）用于 **保证数据一致性**，防止 **并发冲突**。

#### 1. synchronized 关键字

##### 🔹 方式

1. **同步方法**：作用于 **整个方法**，锁定当前对象 (`this`)
2. **同步代码块**：作用于 **特定代码块**，减少锁的粒度，提高并发效率
3. **同步静态方法**：锁定 **类对象 (Class)，所有实例共享**

##### 🔹 示例

###### （1）同步方法

```java
class SyncMethodExample {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SyncMethodExample example = new SyncMethodExample();

        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) example.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) example.increment(); });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("最终计数：" + example.getCount()); // 预期 2000
    }
}
```

###### （2）同步代码块

```java
class SyncBlockExample {
    private int count = 0;
    private final Object lock = new Object(); // 自定义锁对象

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
```

✅ **优点**：

- **保证线程安全**
- **同步代码块** 只锁定必要的代码，提高效率

❌ **缺点**：

- `synchronized` **是重量级锁**，可能影响性能

------

#### 2. ReentrantLock（可重入锁）

##### 🔹 特点

- **支持可重入**（同一线程可多次获取锁）
- **支持尝试获取锁（tryLock）**
- **支持超时获取锁**。
- **需要手动释放锁（lock.unlock()）**

##### 🔹 示例

```java
import java.util.concurrent.locks.ReentrantLock;

class LockExample {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // 获取锁
        try {
            count++;
        } finally {
            lock.unlock(); // 确保释放锁
        }
    }

    public int getCount() {
        return count;
    }
}
```

✅ **优点**：

- 比 `synchronized` **性能更好**
- 提供 **更多锁控制功能**（可重入、超时等）

❌ **缺点**：

- **需要手动释放锁**，否则可能导致死锁

------

#### 3. volatile 关键字

##### 🔹 特点

- **保证可见性**：线程对变量的修改，其他线程能立即看到
- **防止指令重排序**
- **不能保证原子性**（多个线程同时修改时仍然会发生竞争）

##### 🔹 示例

```java
class VolatileExample {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            // 执行任务
        }
        System.out.println("线程停止");
    }
}
```

✅ **优点**：

- **适用于标志位变量**（如 `while (running)`）
- **比 synchronized 开销小**

❌ **缺点**：

- **不能保证原子性**，多个线程修改变量时仍需 `synchronized` 或 `Atomic`

------

#### 4. Atomic 原子类

##### 🔹 特点

- `AtomicInteger`、`AtomicLong`、`AtomicBoolean` **提供原子操作**，避免使用锁

##### 🔹 示例

```java
import java.util.concurrent.atomic.AtomicInteger;

class AtomicExample {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // 原子递增
    }

    public int getCount() {
        return count.get();
    }
}
```

✅ **优点**：

- **性能高**，比 `synchronized` 和 `Lock` 轻量
- **线程安全**

❌ **缺点**：

- **只能用于单变量操作**，无法操作多个变量（如 `count1 + count2`）

------

#### 5. ThreadLocal（线程本地存储）

##### 🔹 特点

- **每个线程拥有独立变量副本**，互不干扰
- **适用于并发场景**，如 **数据库连接、Session 共享等**

##### 🔹 示例

```java
class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void set(int value) {
        threadLocal.set(value);
    }

    public int get() {
        return threadLocal.get();
    }
}
```

✅ **优点**：

- **避免锁竞争**，提升性能

❌ **缺点**：

- **占用更多内存**（每个线程维护一个副本）

------

#### 🔹 对比总结

| **方式**        | **保证线程安全** | **是否支持多变量** | **性能**       | **适用场景**               |
| --------------- | ---------------- | ------------------ | -------------- | -------------------------- |
| `synchronized`  | ✅ 是             | ✅ 是               | ⚠️ 低（锁开销） | 线程同步（适用于所有情况） |
| `ReentrantLock` | ✅ 是             | ✅ 是               | ✅ 中（可控）   | 需要**可重入**、**公平锁** |
| `volatile`      | ⚠️ 只保证可见性   | ❌ 否               | ✅ 高           | 状态标志变量               |
| `Atomic`        | ✅ 是             | ❌ 否               | ✅ 高           | **计数器、计数操作**       |
| `ThreadLocal`   | ✅ 是             | ✅ 是               | ✅ 高           | **每个线程单独变量副本**   |

------

#### 📌 结论

✅ **推荐使用场景**：

1. **同步代码/方法**：小范围同步，直接用 `synchronized`
2. **复杂并发控制**：使用 `ReentrantLock`，支持**可重入**、**公平锁**
3. **标志位变量**：使用 `volatile`，但**不适用于复合操作**（如 `count++`）
4. **计数器等单变量操作**：使用 `AtomicInteger`，性能更优
5. **每个线程独立数据**：使用 `ThreadLocal`，避免锁竞争

🚀 **高并发推荐**：

- **高性能场景**：优先 **Atomic、ThreadLocal**
- **需要复杂锁控制**：优先 **ReentrantLock**
- **普通同步代码块**：`synchronized` **最简单**

⚠️ **注意：锁使用不当会导致性能下降，推荐使用更轻量级方案！**

### 线程池

> 线程池就是一个可以复用线程的技术
>
> 创建新线程的开销是很大的，并且请求过多时，肯定会产生大量的线程出来，这样会严重影响系统的性能，通过线程池技术可以避免线程反复创建销毁，从而提高系统性能

Java 提供了 **ExecutorService** 接口来管理线程池，常见的创建线程池的方式如下：

#### 1. 使用 Executors 工具类（简单但不推荐）

`Executors` 提供了多个静态方法来创建线程池：

- `newFixedThreadPool(nThreads)` → **固定大小** 线程池
- `newCachedThreadPool()` → **动态扩展** 线程池
- `newSingleThreadExecutor()` → **单线程** 线程池
- `newScheduledThreadPool(nThreads)` → **支持定时调度** 的线程池

**示例：**

```java
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
```

✅ **优点：** 代码简洁，使用方便
❌ **缺点：** `Executors` 默认的队列策略可能导致 OOM（内存溢出），不推荐直接使用

------

#### 2. 使用 ThreadPoolExecutor（推荐）

`ThreadPoolExecutor` 允许自定义线程池参数，提高控制力：

```java
ExecutorService threadPool = new ThreadPoolExecutor(
    2, // 核心线程数
    4, // 最大线程数
    60, // 空闲线程存活时间
    TimeUnit.SECONDS, // 存活时间单位
    new LinkedBlockingQueue<>(2), // 任务队列
    Executors.defaultThreadFactory(), // 线程工厂
    new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
);
```

✅ **优点：** 高度可配置，适用于生产环境。
❌ **缺点：** 需要手动管理参数，使用复杂度较高。

------

#### 3. 使用 ForkJoinPool

用于 **并行计算** 或 **递归任务拆分** 的线程池，基于**工作窃取算法**：

```java
ForkJoinPool forkJoinPool = new ForkJoinPool();
```

适用于 `ForkJoinTask` 任务，如 **大数据处理**、**递归计算** 等

✅ **优点：** 适用于 CPU 密集型任务，能充分利用多核 CPU
❌ **缺点：** 适用于特定场景，不适合 I/O 密集型任务

------

#### 线程池任务拒绝策略

当线程池 **满载**（任务队列 + 线程数都已达到上限）时，需要决定如何处理新任务，`ThreadPoolExecutor` 提供了 **4 种拒绝策略**：

| 拒绝策略                | 说明                                                         | 适用场景                                   |
| ----------------------- | ------------------------------------------------------------ | ------------------------------------------ |
| **AbortPolicy** (默认)  | 直接抛出 `RejectedExecutionException`，任务丢失。            | **不允许丢任务时不适用**，可能导致应用崩溃 |
| **CallerRunsPolicy**    | 由 **提交任务的线程**（通常是 `main` 线程）执行任务，减缓任务提交速率。 | **适用于流量削峰**，让调用方主动承担压力   |
| **DiscardPolicy**       | **直接丢弃新任务**，不抛异常。                               | **适用于允许任务丢失** 的场景，如日志处理  |
| **DiscardOldestPolicy** | **丢弃队列中最老的任务**，然后尝试重新提交新任务。           | **适用于丢弃过时任务** 的场景，如过期请求  |

------

#### **示例：不同拒绝策略的行为**

##### 1. AbortPolicy（默认，抛异常）

```java
ExecutorService pool = new ThreadPoolExecutor(
    2, 3, 10, TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(2),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.AbortPolicy() // 默认策略
);
for (int i = 1; i <= 10; i++) {
    try {
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + " 执行任务"));
    } catch (RejectedExecutionException e) {
        System.out.println("任务被拒绝：" + e.getMessage());
    }
}
pool.shutdown();
```

🔹 **超载时抛 RejectedExecutionException**，导致任务丢失

------

##### 2. CallerRunsPolicy（让提交任务的线程执行任务）

```java
ExecutorService pool = new ThreadPoolExecutor(
    2, 3, 10, TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(2),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.CallerRunsPolicy()
);
for (int i = 1; i <= 10; i++) {
    pool.execute(() -> System.out.println(Thread.currentThread().getName() + " 执行任务"));
}
pool.shutdown();
```

🔹 当任务超载，**main 线程会执行任务**，减缓提交速率，避免过载

------

##### 3. DiscardPolicy（直接丢弃任务）

```java
ExecutorService pool = new ThreadPoolExecutor(
    2, 3, 10, TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(2),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.DiscardPolicy()
);
for (int i = 1; i <= 10; i++) {
    pool.execute(() -> System.out.println(Thread.currentThread().getName() + " 执行任务"));
}
pool.shutdown();
```

🔹 **满载时任务直接丢弃，不报错**，适用于不需要保证每个任务都执行的场景

------

##### 4. DiscardOldestPolicy（丢弃最早的任务）

```java
ExecutorService pool = new ThreadPoolExecutor(
    2, 3, 10, TimeUnit.SECONDS,
    new ArrayBlockingQueue<>(2),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.DiscardOldestPolicy()
);
for (int i = 1; i <= 10; i++) {
    pool.execute(() -> System.out.println(Thread.currentThread().getName() + " 执行任务"));
}
pool.shutdown();
```

🔹 **超载时会丢弃最老的任务**，新任务依然可以提交。适用于丢弃**过期任务**的场景（如 Web 请求）

------

#### 总结

##### 线程池创建方式对比

| 方式                 | 适用场景   | 优缺点                     |
| -------------------- | ---------- | -------------------------- |
| `Executors` 工具类   | 快速创建   | 方便但默认队列无界，易 OOM |
| `ThreadPoolExecutor` | 生产环境   | **推荐**，可完全自定义     |
| `ForkJoinPool`       | 计算密集型 | 适用于递归、大数据计算     |

##### 拒绝策略对比

| 策略                    | 处理方式             | 适用场景                   |
| ----------------------- | -------------------- | -------------------------- |
| **AbortPolicy**         | 直接抛异常           | **重要任务，不允许丢失**   |
| **CallerRunsPolicy**    | 由提交任务的线程执行 | **流量削峰，适合限流**     |
| **DiscardPolicy**       | 直接丢弃任务         | **允许丢失的场景，如日志** |
| **DiscardOldestPolicy** | 丢弃最早的任务       | **适用于丢弃过时任务**     |

------

##### 推荐方案

- **普通业务场景** → `ThreadPoolExecutor + CallerRunsPolicy`
- **任务量不可控时** → `ThreadPoolExecutor + DiscardOldestPolicy`
- **对任务可靠性要求高** → `ThreadPoolExecutor + AbortPolicy`
- **计算密集型任务** → `ForkJoinPool`

选择合适的线程池和拒绝策略可以提高 **系统稳定性** 和 **吞吐量** 🚀

------

### 进程和线程

#### 1. 进程（Process）

- **定义**：进程是操作系统中正在运行的程序，每个进程都有自己独立的 **内存空间** 和 **资源**
- 特点：
  - 进程之间**相互独立**，但可以通过 **进程间通信（IPC）** 进行数据交换（如管道、共享内存）
  - **创建和销毁进程的开销较大**，进程切换涉及大量 CPU 资源

#### 2. 线程（Thread）

- **定义**：线程是 **进程内部的执行单元**，一个进程可以包含多个线程，多个线程**共享进程的资源**（如内存、文件等）
- 特点：
  - 线程的**创建和销毁比进程轻量**，切换成本较低
  - 线程间可以**直接共享数据**（但要注意同步问题，避免竞态条件）
  - Java 中的 `Thread` 类用于表示线程，`Runnable` 接口用于定义线程任务

#### 3. 进程与线程的关系

| 维度         | 进程                   | 线程                               |
| ------------ | ---------------------- | ---------------------------------- |
| **基本概念** | 运行中的程序           | 进程内部的执行单元                 |
| **资源**     | 进程**独立**拥有资源   | 线程**共享**进程资源               |
| **开销**     | 创建/销毁成本高        | 创建/销毁成本低                    |
| **通信方式** | 需要进程间通信（IPC）  | 直接共享进程资源                   |
| **安全性**   | 进程独立运行，互不影响 | 线程共享数据，可能导致**数据竞争** |

### 并行和并发

#### 1. 并发（Concurrency）

- **定义**：并发指在 **同一时间段** 内，多个任务 **交替执行**，它们**共享 CPU 时间**，但不一定真正同时运行
- 特点：
  - 任务**并没有真正同时运行**，而是通过 CPU **快速切换** 来实现“同时”运行的效果
  - 适用于**I/O 密集型**任务（如网络请求、文件读取）
  - Java 的 `ExecutorService` 线程池和 `synchronized`、`Lock` 等机制都用于**管理并发**

🔹 **示例（单核 CPU 下的多线程）：**

```java
public class ConcurrencyExample {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("任务1 - " + i);
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("任务2 - " + i);
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
```

📌 **执行结果（并发示例，可能交错执行）**

```
任务1 - 0
任务2 - 0
任务1 - 1
任务2 - 1
...
```

CPU 只是**在两个任务之间快速切换**，并没有真正的并行执行。

------

#### 2. 并行（Parallelism）

- **定义**：并行指**多个任务真正同时运行**，通常需要**多核 CPU** 来支持多个线程/进程 **真正同时执行**。
- 特点：
  - 适用于**计算密集型**任务（如矩阵计算、大数据处理、机器学习）
  - Java 的 **Fork/Join 框架** 和 **并行流（Parallel Stream）** 可以提高并行计算性能

🔹 **示例（多核 CPU 并行计算）：**

```java
import java.util.stream.IntStream;

public class ParallelExample {
    public static void main(String[] args) {
        IntStream.range(1, 6).parallel().forEach(i -> {
            System.out.println(Thread.currentThread().getName() + " - 任务 " + i);
        });
    }
}
```

📌 **执行结果（不同线程真正并行运行）**

```scss
ForkJoinPool.commonPool-worker-1 - 任务 1
ForkJoinPool.commonPool-worker-2 - 任务 2
ForkJoinPool.commonPool-worker-3 - 任务 3
ForkJoinPool.commonPool-worker-4 - 任务 4
ForkJoinPool.commonPool-worker-5 - 任务 5
```

✅ 在多核 CPU 上，多个任务**真正并行执行**，提高 CPU 利用率

------

#### 并发 vs 并行 总结

| 维度              | 并发（Concurrency）                       | 并行（Parallelism）               |
| ----------------- | ----------------------------------------- | --------------------------------- |
| **定义**          | 任务**交替执行**                          | 任务**真正同时执行**              |
| **适用场景**      | **I/O 密集型**（如 Web 请求）             | **计算密集型**（如 AI 计算）      |
| **CPU 需求**      | **单核也可并发**                          | **需要多核 CPU**                  |
| **执行方式**      | CPU 任务切换，**多个任务共享 CPU**        | **多个 CPU 核心同时执行**         |
| **Java 相关技术** | `ThreadPoolExecutor`、`CompletableFuture` | `ForkJoinPool`、`Parallel Stream` |

------

## 八、网络编程

> Java 提供了一套强大的网络编程 API，支持基于 TCP 和 UDP 的通信。Java 网络编程主要涉及 **Socket（套接字）**，**HTTP 连接**，以及 **多线程服务器** 的开发

### 1. 计算机网络基础

在 Java 网络编程中，主要涉及以下几个基本概念：

- **IP 地址（Internet Protocol Address）**：唯一标识网络中的设备（如 `192.168.1.1`）
- **端口（Port）**：用于标识计算机上的具体进程（如 HTTP 服务器默认端口 `80`）
- 协议（Protocol）：
  - **TCP（Transmission Control Protocol）**：面向连接、可靠传输（如 HTTP、FTP）
  - **UDP（User Datagram Protocol）**：无连接、不可靠传输（如 DNS、视频流）
- **Socket（套接字）**：网络通信的基本组件，用于建立主机之间的连接

------

### 2. Java 网络编程 API

Java 提供了多种方式进行网络通信，主要包括：

1. **java.net.Socket（TCP 客户端）**
2. **java.net.ServerSocket（TCP 服务器）**
3. **java.net.DatagramSocket（UDP 通信）**
4. **java.net.URL & HttpURLConnection（HTTP 访问）**
5. **NIO（java.nio.channels）**：支持高并发的非阻塞 IO 网络编程
6. **Netty 框架**：用于高性能网络应用开发

------

### 3. Java 网络通信方式

#### 3.1 TCP 编程

TCP 是面向连接的协议，通信前需要建立连接，适用于需要可靠传输的应用

##### 🔹 TCP 服务器端示例

```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket socket = serverSocket.accept(); // 等待客户端连接
                System.out.println("客户端已连接：" + socket.getInetAddress());

                // 读取客户端发送的数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("收到客户端消息：" + message);

                // 发送响应
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("服务器已收到消息：" + message);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

##### 🔹 TCP 客户端示例

```java
import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, Server!"); // 发送消息

            // 读取服务器返回的消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("服务器回复：" + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**🔹 运行步骤**

1. 先启动 `TCPServer`，监听端口 `8080`
2. 再启动 `TCPClient`，发送消息
3. 服务器收到消息后，返回响应，客户端接收后输出

------

#### 3.2 UDP 编程

UDP 适用于**实时通信**，例如音视频、游戏通信。

##### 🔹 UDP 服务器端示例

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("UDP 服务器启动，等待数据...");
            socket.receive(packet); // 接收数据

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("收到客户端消息：" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

##### 🔹 UDP 客户端示例

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello, UDP Server!";
            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(data, data.length, address, 8080);
            socket.send(packet); // 发送数据
            System.out.println("消息已发送！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

------

### 4. HTTP 访问

Java 提供 `HttpURLConnection` 进行 HTTP 请求，如 GET 和 POST。

#### 🔹 发送 HTTP GET 请求

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

------

### 5. Java NIO（非阻塞 IO）

传统 `Socket` 是 **阻塞式 IO**，适用于小规模连接。`NIO` 采用 **多路复用机制**，适用于**高并发网络编程**。

- `Selector`：监听多个通道（Channel）
- `Channel`：数据传输通道
- `Buffer`：用于数据读写

------

### 6. Java 高性能网络编程框架

1. **Netty**：基于 `NIO`，用于高性能网络编程（如 RPC、IM 服务器）
2. **Mina**：Apache 出品的 NIO 框架
3. **Spring WebFlux**：基于 `Reactor`，用于异步 HTTP 服务器

------

### 7. 关键知识点总结

| 方式                          | 适用场景     | 可靠性 | 连接方式 | 典型应用       |
| ----------------------------- | ------------ | ------ | -------- | -------------- |
| **TCP（Socket）**             | 可靠数据传输 | 高     | 需要连接 | 文件传输、聊天 |
| **UDP**                       | 实时传输     | 低     | 无连接   | 直播、语音通话 |
| **HTTP（HttpURLConnection）** | Web 请求     | 高     | 无连接   | API 调用       |
| **NIO（java.nio）**           | 高并发       | 高     | 需要连接 | 高并发服务器   |
| **Netty**                     | 互联网应用   | 高     | 需要连接 | IM、游戏服务器 |

------

### 总结

- Java 网络编程主要涉及 **TCP、UDP、HTTP**
- **Socket 适用于点对点通信**，如 TCP/UD
- **HttpURLConnection 用于 Web API 调用**
- **NIO & Netty 提供高性能并发支持**

------

## 九、单元测试

> 在 **IntelliJ IDEA** 中，单元测试主要依赖于 **JUnit** 框架

### 1. 配置 JUnit 测试环境

#### 🔹 IDEA 内置 JUnit

IntelliJ IDEA 默认支持 **JUnit**，但如果项目中没有 JUnit 依赖，需要手动添加：

#### 🔹 添加 JUnit 依赖（Maven/Gradle）

- Maven 在 pom.xml 中添加：

  ```xml
  <dependencies>
      <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-api</artifactId>
          <version>5.8.1</version>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>5.8.1</version>
      </dependency>
  </dependencies>
  ```

- Gradle在  build.gradle中添加：

  ```json
  dependencies {
      testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2'
  }
  ```

------

### 2. 创建 JUnit 测试类

#### 🔹 手动编写测试

假设有一个 **Calculator** 类：

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

#### 🔹 创建测试类

手动创建 `CalculatorTest.java`：

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 5);
        assertEquals(8, result, "3 + 5 应该等于 8");
    }
}
```

**注解说明**

| 注解          | 作用                                 |
| ------------- | ------------------------------------ |
| `@Test`       | 标记测试方法                         |
| `@BeforeEach` | 每个测试方法执行前运行               |
| `@AfterEach`  | 每个测试方法执行后运行               |
| `@BeforeAll`  | 在所有测试方法执行前运行（静态方法） |
| `@AfterAll`   | 在所有测试方法执行后运行（静态方法） |
| `@Disabled`   | 忽略测试方法                         |

------

### 3. 通过 IDEA 生成单元测试

**步骤**

1. **右键要测试的类 → 选择 Generate (Alt + Insert) → 选择 Test**
2. 选择 **JUnit5** 作为测试框架，勾选要测试的方法，点击 **OK**
3. IDEA 会自动生成 **测试类** 和 **测试方法**

------

### 4. 运行和调试测试

#### 🔹 运行单个测试

- **方法 1**：在测试方法上 **右键 → Run 'CalculatorTest.testAdd()'**
- **方法 2**：点击方法旁边的 **绿色箭头** ▶ 运行

#### 🔹 运行所有测试

- **方法 1**：右键 `CalculatorTest.java` → `Run 'CalculatorTest'`
- **方法 2**：打开 `Run` 选项卡，点击 **▶ 运行所有测试**

#### 🔹 调试测试

- 在测试方法中设置 **断点**，然后点击 **Debug**（绿色甲虫 🐞 图标）

------

### 5. 断言（Assertions）

JUnit 提供多种 **断言** 方法来检查测试结果：

```java
import static org.junit.jupiter.api.Assertions.*;

@Test
void testAssertions() {
    assertEquals(5, 2 + 3); // 检查是否相等
    assertTrue(3 > 2); // 检查是否为 true
    assertFalse(3 < 2); // 检查是否为 false
    assertNull(null); // 检查是否为 null
    assertNotNull("Hello"); // 检查不为 null
}
```

### 6. Spring Boot 单元测试

如果使用 **Spring Boot**，可以使用 `@SpringBootTest` 进行集成测试：

```java
@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAddition() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}
```

------

### 总结

| 操作                 | 方法                                 |
| -------------------- | ------------------------------------ |
| **创建测试类**       | 右键类 → `Generate Test` 或 手动创建 |
| **运行单个测试**     | 右键方法 → `Run` 或 点击绿色箭头 ▶   |
| **运行所有测试**     | 右键测试类 → `Run`                   |
| **调试测试**         | 断点调试（🐞）                        |
| **Spring Boot 测试** | `@SpringBootTest`                    |

------

## 十、反射

> **反射（Reflection）** 是 Java 语言提供的一种机制，它允许程序在运行时动态地获取类的信息（如类的名称、方法、构造器、字段等）并进行操作。通过反射，可以**在编译期不确定类信息的情况下，动态创建对象、调用方法或访问字段**

反射主要依赖于 `java.lang.reflect` 包，包含以下核心类：

- `Class<?>`：表示类的运行时信息
- `Constructor<?>`：表示类的构造方法
- `Method`：表示类的方法
- `Field`：表示类的成员变量

------

### 1. 反射的基本操作

#### 1.1 获取 Class 对象

在 Java 中，可以通过以下三种方式获取 `Class` 对象：

```java
// 1. 通过 类名.class
Class<?> clazz1 = String.class;

// 2. 通过 对象.getClass()
String str = "Hello";
Class<?> clazz2 = str.getClass();

// 3. 通过 Class.forName("全限定类名")
Class<?> clazz3 = Class.forName("java.lang.String");
```

------

#### 1.2 获取构造方法并创建对象

```java
import java.lang.reflect.Constructor;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Class.forName("Person");

        // 获取构造方法
        Constructor<?> constructor = clazz.getConstructor(String.class);

        // 创建实例
        Object person = constructor.newInstance("Alice");

        // 调用方法
        Method method = clazz.getMethod("sayHello");
        method.invoke(person); // 输出: Hello, my name is Alice
    }
}
```

------

#### 1.3 获取和操作类的字段

```java
import java.lang.reflect.Field;

class Student {
    private String name = "John Doe";
}

public class ReflectionFieldExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Student.class;

        // 获取字段对象（包括私有字段）
        Field field = clazz.getDeclaredField("name");

        // 由于是 private 访问，需要设置可访问
        field.setAccessible(true);

        // 创建对象
        Student student = new Student();

        // 获取字段值
        System.out.println("原始值: " + field.get(student));

        // 修改字段值
        field.set(student, "Alice");

        // 再次获取字段值
        System.out.println("修改后: " + field.get(student));
    }
}
```

**输出**

```scss
原始值: John Doe
修改后: Alice
```

------

#### 1.4 获取和调用方法

```java
import java.lang.reflect.Method;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

public class ReflectionMethodExample {
    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Calculator.class;

        // 获取方法对象
        Method method = clazz.getMethod("add", int.class, int.class);

        // 创建实例
        Object calculator = clazz.getDeclaredConstructor().newInstance();

        // 调用方法
        Object result = method.invoke(calculator, 5, 3);
        System.out.println("结果: " + result); // 输出: 结果: 8
    }
}
```

------

#### 1.5 访问私有方法

```java
import java.lang.reflect.Method;

class Secret {
    private void hiddenMessage() {
        System.out.println("这是一个私有方法！");
    }
}

public class ReflectionPrivateMethod {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Secret.class;
        Method method = clazz.getDeclaredMethod("hiddenMessage");

        // 允许访问私有方法
        method.setAccessible(true);

        // 调用私有方法
        Object obj = clazz.getDeclaredConstructor().newInstance();
        method.invoke(obj);
    }
}
```

**输出**

```scss
复制编辑这是一个私有方法！
```

------

### 2. 反射的应用场景

#### 2.1 动态加载类

**场景**：在插件系统、依赖注入框架（如 Spring）中，反射用于动态加载类，而无需提前硬编码

示例：

```java
Class<?> clazz = Class.forName("com.example.MyPlugin");
Object plugin = clazz.getDeclaredConstructor().newInstance();
```

------

#### 2.2 框架与ORM（对象关系映射）

**场景**：如 Spring、Hibernate、MyBatis 等框架使用反射来获取类的字段和方法，以实现自动依赖注入或数据库映射

示例（获取类的字段）：

```java
Field[] fields = clazz.getDeclaredFields();
for (Field field : fields) {
    System.out.println("字段名: " + field.getName());
}
```

#### 2.3 解析注解

**场景**：Spring 依赖反射解析 `@Autowired`、`@Service`、`@Controller` 等注解

示例：

```java
import java.lang.annotation.*;
import java.lang.reflect.Method;

// 定义自定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
}

// 使用注解
class Demo {
    @MyAnnotation("Hello, Annotation!")
    public void test() {}
}

// 解析注解
public class AnnotationReflection {
    public static void main(String[] args) throws Exception {
        Method method = Demo.class.getMethod("test");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("注解值: " + annotation.value());
        }
    }
}
```

**输出**

```scss
注解值: Hello, Annotation!
```

------

#### 2.4 代理（AOP，动态代理）

**场景**：Spring AOP（面向切面编程）和 JDK 动态代理都使用反射实现

示例：

```java
import java.lang.reflect.*;

interface Service {
    void execute();
}

// 真实类
class RealService implements Service {
    public void execute() {
        System.out.println("执行真实业务逻辑...");
    }
}

// 代理类
class DynamicProxy implements InvocationHandler {
    private final Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前...");
        Object result = method.invoke(target, args);
        System.out.println("执行后...");
        return result;
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Service realService = new RealService();
        Service proxyInstance = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                new Class[]{Service.class},
                new DynamicProxy(realService)
        );

        proxyInstance.execute();
    }
}
```

**输出**

```scss
复制编辑执行前...
执行真实业务逻辑...
执行后...
```

------

### 3. 反射的缺点

- **性能开销大**：反射比直接调用方法慢，影响系统性能
- **安全风险**：可绕过访问控制，可能引发安全问题
- **代码可读性低**：不易理解和维护

------

### 4. 总结

| **特点**           | **说明**                                     |
| ------------------ | -------------------------------------------- |
| **动态获取类信息** | 通过 `Class<?>` 获取类的方法、字段、构造器等 |
| **动态创建对象**   | 使用 `Constructor.newInstance()` 实例化对象  |
| **动态调用方法**   | 通过 `Method.invoke()` 运行方法              |
| **应用场景**       | Spring、ORM、AOP、框架开发等                 |
| **缺点**           | 影响性能，可能绕过安全限制                   |

------

## 十一、注解

> **注解（Annotation）** 是 Java 提供的一种元数据（Metadata）机制，允许在代码中添加额外的信息，供编译器、工具或运行时使用。注解不会影响程序逻辑，但可以用于代码分析、编译检查、运行时处理等

### 1.1 Java 内置注解

Java 语言提供了一些常见的内置注解：

| **注解**               | **作用**                               |
| ---------------------- | -------------------------------------- |
| `@Override`            | 用于标注方法，表明该方法重写了父类方法 |
| `@Deprecated`          | 标识方法或类已过时，不推荐使用         |
| `@SuppressWarnings`    | 用于忽略编译器警告                     |
| `@FunctionalInterface` | 用于标识一个接口为函数式接口           |
| `@SafeVarargs`         | 确保方法的可变参数不会出现类型安全问题 |

示例：

```java
class Parent {
    void show() {}
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("重写父类方法");
    }

    @Deprecated
    void oldMethod() {
        System.out.println("不推荐使用的方法");
    }
}
```

------

#### **1.3 自定义注解**

可以使用 `@interface` 关键字创建自定义注解：

```java
import java.lang.annotation.*;

// 1. 定义注解
@Retention(RetentionPolicy.RUNTIME) // 指定注解在运行时可用
@Target(ElementType.METHOD) // 指定该注解只能用于方法
@interface MyAnnotation {
    String value(); // 定义属性
}

// 2. 使用注解
class Example {
    @MyAnnotation("Hello Annotation")
    public void test() {}
}

// 3. 解析注解
public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        Method method = Example.class.getMethod("test");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("注解值: " + annotation.value());
        }
    }
}
```

**输出**

```scss
注解值: Hello Annotation
```

------

## 十二、代理

### 1.1 代理模式的概念

**代理模式（Proxy Pattern）** 是一种结构型设计模式，主要用于**在不改变目标对象的情况下，增强其功能**

Java 提供了两种代理方式：

1. **静态代理（Static Proxy）**：代理类在编译时就已确定
2. 动态代理（Dynamic Proxy）：
   - **JDK 动态代理（基于 Proxy 类和 InvocationHandler）**
   - **CGLIB 代理（基于子类继承）**

### 1.2 静态代理

静态代理需要手动编写代理类，**代理类和目标对象必须实现相同的接口**

示例：

```java
// 1. 定义接口
interface Service {
    void execute();
}

// 2. 真实类
class RealService implements Service {
    @Override
    public void execute() {
        System.out.println("执行真实业务逻辑...");
    }
}

// 3. 代理类
class StaticProxy implements Service {
    private final Service target;

    public StaticProxy(Service target) {
        this.target = target;
    }

    @Override
    public void execute() {
        System.out.println("执行前...");
        target.execute();
        System.out.println("执行后...");
    }
}

// 4. 测试
public class StaticProxyDemo {
    public static void main(String[] args) {
        Service proxy = new StaticProxy(new RealService());
        proxy.execute();
    }
}
```

**输出**

```scss
执行前...
执行真实业务逻辑...
执行后...
```

------

### 1.3 JDK 动态代理

JDK 提供 `java.lang.reflect.Proxy` 类，可以在运行时动态生成代理对象，避免手动编写代理类。JDK 动态代理**要求目标类实现接口**

示例：

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. 定义接口
interface Service {
    void execute();
}

// 2. 真实类
class RealService implements Service {
    @Override
    public void execute() {
        System.out.println("执行真实业务逻辑...");
    }
}

// 3. 动态代理处理器
class DynamicProxyHandler implements InvocationHandler {
    private final Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前...");
        Object result = method.invoke(target, args);
        System.out.println("执行后...");
        return result;
    }
}

// 4. 测试
public class JDKProxyDemo {
    public static void main(String[] args) {
        Service target = new RealService();

        // 创建代理对象
        Service proxy = (Service) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{Service.class},
                new DynamicProxyHandler(target)
        );

        proxy.execute();
    }
}
```

**输出**

```scss
执行前...
执行真实业务逻辑...
执行后...
```

------

### 1.4 CGLIB 代理（适用于没有接口的类）

JDK 动态代理要求**目标类必须实现接口**，如果没有接口，我们可以使用 **CGLIB**（基于子类继承实现代理）

CGLIB 依赖：

```xml
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>
```

示例：

```java
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

// 1. 目标类（无接口）
class RealService {
    public void execute() {
        System.out.println("执行真实业务逻辑...");
    }
}

// 2. CGLIB 代理类
class CglibProxy implements MethodInterceptor {
    private final Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("执行前...");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("执行后...");
        return result;
    }
}

// 3. 测试
public class CglibProxyDemo {
    public static void main(String[] args) {
        RealService target = new RealService();
        RealService proxy = (RealService) new CglibProxy(target).createProxy();
        proxy.execute();
    }
}
```

**输出**

```scss
执行前...
执行真实业务逻辑...
执行后...
```

------

### 1.5 代理方式对比

| **代理方式**     | **特点**                                          | **适用场景**                     |
| ---------------- | ------------------------------------------------- | -------------------------------- |
| **静态代理**     | 需要手写代理类，不够灵活                          | 适用于少量代理，增强特定类功能   |
| **JDK 动态代理** | 运行时生成代理对象，要求目标类**实现接口**        | 适用于接口代理，如 Spring AOP    |
| **CGLIB 代理**   | 生成子类代理，不需要接口，但无法代理 `final` 方法 | 适用于没有接口的类，如 Hibernate |

------

### 总结

- **注解** 主要用于标注代码，可以与**反射**结合使用，进行运行时解析
- **代理模式** 主要用于**增强方法逻辑**，常用于 AOP、日志记录、权限控制等场景
- **JDK 动态代理** 适用于**接口**代理，**CGLIB 代理** 适用于**无接口类**

