# 12.4 메서드 내리기

## 전

```javascript
class Employee {
  get quota() {}
}
class Enginner extends Employee {}
class SalePerson extends Employee {}
```

## 후

```javascript
class Employee {}
class Enginner extends Employee {}
class SalePerson extends Employee {
  get quota() {}
}
```

## 배경

주의: 해당 기능을 제공하는 서브 클래스가 정확히 무엇인지를 호출자가 알고 있을 때만 적용할 수 있다.
그렇지 못한 상황이라면 서브클래스에 따라
다르게 동작하는 슈퍼클래스의 기만적인 조건부 로직을
(10.4)다형성으로 바꿔야한다.
