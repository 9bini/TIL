# 12.1 메소드 올리기

## 전

```javascript
class Employee {}
class SalePerson extends Employee {
  get name() {}
}
class Enginner extends Employee {
  get name() {}
}
```

## 후

```javascript
class Employee {
  get name() {}
}
class SalePerson extends Employee {}
class Enginner extends Employee {}
```

## 예시

### 두 서브클래스에서 같은 일을 수행하는 메서드를 찾기

```javascript
class Employee extends Party {
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  get totalCost() {
    return this.monthlyCost * 12;
  }
}
```

### monthlyCost는 슈퍼클래스에는 정의되어 있지 않고 두 서브클래스에 존재

- 정적 언어였다면 슈퍼클래스인 Party에 추상 메서드를 정의해야한다.

### 두 메서드의 이름이 다르므로 (6.5절) 함수 선언 아뿌기로 이름을 통일한다.

```javascript
class Employee extends Party {
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  get annualCost() {
    return this.monthlyCost * 12;
  }
}
```

### 서브 클래스 중 하나의 메서드를 복사해 슈퍼클래스에 붙여넣는다.

```javascript
class Party {
  get annualCost() {
    return this.monthlyCost * 12;
  }
}
class Employee extends Party {}
class Department extends Party {}
```
