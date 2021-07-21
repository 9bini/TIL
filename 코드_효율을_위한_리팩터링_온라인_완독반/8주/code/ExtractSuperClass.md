# 12.8 슈퍼클래스 추출하기

## 전

```javascript
class Department {
  get totalAnnualCost() {}
  get name() {}
  get headCount() {}
}

class Employee {
  get annualCost() {}
  get name() {}
  get id() {}
}
```

## 후

```javascript
class Party {
  get name() {}
  get annualCost() {}
}

class Department {
  get annualCost() {}
  get headCount() {}
}

class Employee {
  get annualCost() {}
  get id() {}
}
```

## 배경

실무: 프로그램이 성장하면서 깨우쳐가게 되며, 수퍼클래스로 끌러올리고 싶은 공통 요소를 찾았을 때 수행

## 예시

```javascript
class Employee {
  constructor(name, id, monthlyCost) {
    this._name = name;
    this._id = id;
    this._monthlyCost = monthlyCost;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }

  get name() {
    return this._name;
  }
  get id() {
    return this._id;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department {
  constructor(name, staff) {
    this._name = name;
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }
  get name() {
    return this._name;
  }
  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
  }
  get headCount() {
    return this._staff.length;
  }
  get totalAnnualCost() {
    return this._monthlyCost * 12;
  }
}
```

### 빈 슈퍼클래스 생성, 두 클래스 확장

```javascript
class Party {}

class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super();
    this._name = name;
    this._id = id;
    this._monthlyCost = monthlyCost;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }

  get name() {
    return this._name;
  }
  get id() {
    return this._id;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super();
    this._name = name;
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }
  get name() {
    return this._name;
  }
  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
  }
  get headCount() {
    return this._staff.length;
  }
  get totalAnnualCost() {
    return this._monthlyCost * 12;
  }
}
```

### 이름 속성을 위로 올리기

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
  get monthlyCost() {
    return this._monthlyCost;
  }

  get name() {
    return this._name;
  }
  get id() {
    return this._id;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super(name);
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }
  get name() {
    return this._name;
  }
  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
  }
  get headCount() {
    return this._staff.length;
  }
  get totalAnnualCost() {
    return this._monthlyCost * 12;
  }
}
```

### 메소드 올리기

```javascript
class Party {
  constructor(name) {
    this._name = name;
  }
  get name() {
    return this._name;
  }
}

class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super(name);

    this._id = id;
    this._monthlyCost = monthlyCost;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }

  get id() {
    return this._id;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super(name);
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }

  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
    return this._monthlyCost;
  }
  get headCount() {
    return this._staff.length;
  }
  get totalAnnualCost() {
    return this._monthlyCost * 12;
  }
}
```

### 함수 선언 바꾸기

```javascript
class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super(name);

    this._id = id;
    this._monthlyCost = monthlyCost;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }

  get id() {
    return this._id;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super(name);
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }

  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
  }
  get headCount() {
    return this._staff.length;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }
}
```

### 메서드 올리기

```javascript
class Party {
  constructor(name) {
    this._name = name;
  }
  get name() {
    return this._name;
  }
  get annualCost() {
    return this.monthlyCost * 12;
  }
}
class Employee extends Party {
  constructor(name, id, monthlyCost) {
    super(name);

    this._id = id;
    this._monthlyCost = monthlyCost;
  }
  get monthlyCost() {
    return this._monthlyCost;
  }

  get id() {
    return this._id;
  }
}

class Department extends Party {
  constructor(name, staff) {
    super(name);
    this.staff = staff;
  }
  get staff() {
    return this._staff.slice();
  }

  get totalMothlyCost() {
    return staff.map((e) => e.monthlyCost).reduce((sum, cost) => sum + cost);
  }
  get headCount() {
    return this._staff.length;
  }

  get monthlyCost() {
    return this._monthlyCost;
  }
}
```
