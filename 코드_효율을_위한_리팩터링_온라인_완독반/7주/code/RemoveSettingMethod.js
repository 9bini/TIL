// 전

class Person {
    get name() {
        return this._name;
    }

    set name(name) {
        this._name = name;
    }
}

// 후

class Person {
    get name() {
        return this._name;
    }
}

// 예시 1

class Person {
    get name() {
        return this._name;
    }

    set name(name) {
        this._name = name;
    }

    get id() {
        return this._id;
    }

    set id(id) {
        this._id = id;
    }
}

// 1. 함수 선언 바꾸기로 생성자에서 ID를 받도록 한다.

class Person {

    constructor(id) {
        this._id = id;
    }

    get name() {
        return this._name;
    }

    set name(name) {
        this._name = name;
    }

    get id() {
        return this._id;
    }

    set id(id) {
        this._id = id;
    }
}


// 2. 생성 스크립트가 이 생성자를 통해 ID를 설정하게끔 수정한다.

const martin = new Person("1234");
martin.name = "마틴";

// 3. 모두 수정했다면 세터 메서드를 인라인 한다.

class Person {

    constructor(id) {
        this._id = id;
    }

    get name() {
        return this._name;
    }

    set name(name) {
        this._name = name;
    }

    get id() {
        return this._id;
    }
}