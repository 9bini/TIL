# 생성자 본문 올리기

## 전

```javascript
class Party {}
class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super();
    this._id = id;
    this._name = name;
    this._monthlyCost = monthlyCost;
  }
}
```

## 후

```javascript
class Party {
  constructor(name) {
}
class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super(name);
    this._id = id;
    this._monthlyCost = monthlyCost;
  }
}
```

## 배경

생성자는 할 수 있는 일과 호출 순서에 제약이 있기 때문에 조금 다른 식으로 접근 해야한다.

## 예시

```javascript
class Party {}

class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super();
    this._id = id;
    this._name = name;
    this._monthlyCost = monthlyCost;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super();
    this._name = name;
    this._staff = staff;
  }
}
```

### 대입문을 스라이드하여 super() 호출 바로 아래호 옮긴다(8.6절 문장 슬라이드)

```javascript
class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super();
    this._name = name;
    this._id = id;
    this._monthlyCost = monthlyCost;
  }
}
```

### 공통코드를 슈퍼클래스에 옮긴다.

```javascript
class Party {
  constructor(name) {
    this._name = name;
  }
}

class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super(name);
    this._id = id;
    this._monthlyCost = monthlyCost;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super(name);
    this._staff = staff;
  }
}
```

## 예시: 공통 코드가 나중에 올 떄

```javascript
class Employee {
  constructor(name) {}
  get isPrivileged() {}
  assigCar() {}
}

class Manager extends Employee {
  constructor(name, grade) {
    super(name);
    this._grade = grade;
    if (this.isPrivileged) this.assigCar();
  }
  get isPrivileged() {
    return this._grade > 4;
  }
}
```

isPrivileged()는 grade 필드에 값이 대입된 후에야 호출될 수 있고
서브 클래스만이 이 필드에 값을 대입할 수 있기 때문이다.

### 공통코드를 6.1 함수 추출

```javascript
class Manager extends Employee {
  constructor(name, grade) {
    super(name);
    this._grade = grade;
    this.finishConstruction();
  }
  get isPrivileged() {
    return this._grade > 4;
  }
  finishConstruction() {
    if (this.isPrivileged) this.assigCar();
  }
}
```

### 다음 추출한 메서드를 슈퍼클래스에 옮긴다(12.1 메서드 올리기)

```javascript
class Employee {
  constructor(name) {}
  get isPrivileged() {}
  assigCar() {}
  finishConstruction() {
    if (this.isPrivileged) this.assigCar();
  }
}

class Manager extends Employee {
  constructor(name, grade) {
    super(name);
    this._grade = grade;
    this.finishConstruction();
  }
  get isPrivileged() {
    return this._grade > 4;
  }
}
```
