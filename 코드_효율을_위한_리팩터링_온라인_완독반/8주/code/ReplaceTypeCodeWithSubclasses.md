# 12.6 타입코드를 서브클래스로 바꾸기

## 전

```javascript
function createEmployee(name, type) {
  return new Employee(name, type);
}
```

## 후

```javascript
function createEmployee(name, type) {
  switch (type) {
    case "engineer":
      return new Employee(name);
    case "salesperson":
      return new Salesperson(name);
    case "manager":
      return new Manager(name);
  }
}
```

## 배경

타입 코드 이상이 필요할 때 서브클래스를 사용
서브클래스 장점

- 조건에 따라 다르게 동작하도록 해주는 다형성을 제공한다.
- 특정 타입에서만 의미가 있는 값을 사용하는 필드나 메서드가 있을 때 발현된다.
- 서브클래스 방식이 관계를 더 명확히 드러내준다.

대상 클래스 or 타입 클래스

## 예시: 직접 상속할 때

```javascript
class Employee {
  constructor(name, type) {
    this.validateType(type);
    this._name = name;
    this._type = type;
  }
  validateType(arg) {
    if (!["engineer", "manager", "salesperson"].includes(arg)) {
      throw new Error(`${arg}라는 직원 유형은 없습니다.`);
    }
  }
  toString() {
    return `${this._name} (${this._type})`;
  }
}
```

### 타입 코드 캡슐화

```javascript
class Employee {
  constructor(name, type) {
    this.validateType(type);
    this._name = name;
    this._type = type;
  }
  validateType(arg) {
    if (!["engineer", "manager", "salesperson"].includes(arg)) {
      throw new Error(`${arg}라는 직원 유형은 없습니다.`);
    }
  }
  get type() {
    return this._type;
  }
  toString() {
    // this._type => this.type
    return `${this._name} (${this.type})`;
  }
}
```

### 직접 상속 방식 - 타입 코드 게터를 오버라이드하여 적절한 리터럴 값을 반환

```javascript
class Enginner extends Employee {
  get type() {
    return "engineer";
  }
}
```

### 생성자를 팩토리 메소드 함수로 바꿔서 선택 로직을 담을 별도 장소를 마련한다.

JS 생성자는 객체를 반환할 수 있지만 선택 로직을 생성자에 넣으려 하면 필드 초기화와 로직이 꼬인다.

```javascript
function createEmployee(name, type) {
  return new Employee(name, type);
}
```

### 선택 로직을 팩토리에 추가한다.

```javascript
function createEmployee(name, type) {
  switch (type) {
    case "engineer":
      return new Enginner(name, type);
  }
  return new Employee(name, type);
}
```

### 타입 코드 필드와 슈퍼클래스의 게터(서브클래스에서 재정의한 메서드)를 제거

```javascript
class Employee {
  constructor(name) {
    this._name = name;
  }
}
```
