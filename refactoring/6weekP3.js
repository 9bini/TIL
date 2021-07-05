class Professor {
  constructor() {
    this._course = {};
  }
  setCourseCode(code) {
    this._course = {
      code: code,
      capacity: this._course.capacity,
      subclass: this._course.subclass,
    };
  }
  setCourseCapacity(capacity) {
    this._course = {
      code: this._course.code,
      capacity: capacity,
      subclass: this._course.subclass,
    };
  }
  setCourseSubclass(subclass) {
    this._course = {
      code: this._course.code,
      capacity: this._course.capacity,
      subclass: subclass,
    };
  }

  get course() {
    return this._course;
  }
  get courseCode() {
    return this._course.code;
  }
  get courseCapacity() {
    return this._course.capacity;
  }
  get courseSubclass() {
    return this._course.subclass;
  }
}

// 이하 수정 금지

let prof = new Professor();
prof.setCourseCode("CS101");
prof.setCourseSubclass("B");
prof.setCourseCapacity(40);
console.log(prof.course);
