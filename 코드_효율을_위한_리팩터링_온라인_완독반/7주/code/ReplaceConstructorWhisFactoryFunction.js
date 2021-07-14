// 전
let leadEngineer = new Eployee(document.leadEngineer, 'E');

// 후

leadEngineer = createEnginner(document.leadEngineer);

/*
생성자 단점
자바: 생성자는 반드시 그 생성자를 정의한 클래스의 인스턴스를 반환해야한디
서브클래스의 인스턴스나 프락시를 반환할 수는 없다.
생성자의 이름도 고정되어, 기본 이름보다 더 적절한 이름이 있어도 사용할 수 없다.
생성자를 호출하려면 특별한 연상자를 사용해야 해서 일반 함수가 오길 기대하는 자리에는 쓰기 어렵다.
 */

// 예시

class Employee {

    constructor(name, typeCode) {
        this._name = name;
        this._typeCode = typeCode;
    }


    get name() {
        return this._name;
    }

    get type() {
        return Employee.legalTypeCodes[this._typeCode];
    }

    static get legalTypeCodes() {
        return {
            E: "Enginner", M: "Manager", "S": "Salesperson"
        };
    }
}

candidate = new Employee(document.name, document.empType);

const leadEngineer = new Employee(document.leadEngineer, 'E');

// 1. 팩터리 함수 만들기, 생성자에 위임하는 방식으로 구현

function createEmployee(name, typeCode){
    return new Employee(name, typeCode);
}

// 2. 호출하는 곳을 찾아 수정한다. 하니씩


// candidate = new Employee(document.name, document.empType);
candidate = createEmployee(document.name, document.empType);

// const leadEngineer = new Employee(document.leadEngineer, 'E');
const leadEngineer = createEmployee(document.leadEngineer, 'E');

// 예시 권장 코드 스타일

function createEmployee(name){
    return new Employee(name, 'E');
}

// const leadEngineer = createEmployee(document.leadEngineer, 'E');

const leadEngineer = createEmployee(document.leadEngineer);