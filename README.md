# study-java
学习java

## 函数式编程概念

## 什么是编程概念

### 比较

## 为什么要使用函数式编程

lambda表达式返回了一个指定接口的对象实例

接口只有一个方法要实现


@FunctionalInterface 编译器校验 生命该接口为函数接口->单一责任制
要实现的方法接口里只有一个，而不是接口只有一个方法，因为java8中最大升级->默认接口方法
list接口 使用default

## JDK8接口新特性
## 函数接口

## Stream流
### 外部迭代
### 内部迭代
#### 中间操作
##### 无状态操作
map/mapToXxx 
flatMap/flatMapToXxx
filter 过滤
peek 
unordered 
##### 有状态操作
distinct 去重
sorted 排序
limit 限流
skip 跳过
#### 终止操作
##### 非短路操作
forEach
forEachOrdered
collect/toArray
reduce
min/max/count
##### 短路操作 （不需要等到流全部结束）

#### 惰性求值