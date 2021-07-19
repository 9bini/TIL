# 필드 올리기

## 전

```java
class Employee{}
class SalePerson extends Employee {
    private String name;
}
class Enginner extends Employee {
    private String name;
}
```

## 후

```java
class Employee{
     private String name;
}
class SalePerson extends Employee {}
class Enginner extends Employee {}
```

## 배경

- 변수 명이 동일할 수도 있도 아닐수도 있다.
  - 그래서 필드를 올리만한 변수인지 분석할 필요가 있다.
