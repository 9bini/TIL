class Student {
  constructor() {
    this._courses = []; // 수업
    this._grade = 0; // 졸업 평점
    this._weights = 0; // 가중치
  }

  addCourse(course) {
    this._courses.push(course);
  }
  get grade() {
    const result = this._courses.reduce((pre, course) => {
      return {
        weight: pre.weight + course.weight,
        grade:
          pre.grade +
          (course.grade * course.weight) / (pre.weight + course.weight),
      };
    });
    return result.grade;
  }
}

/////////// 여기까지 과제2 문제 영역

let student = new Student();
student.addCourse({ grade: 4.0, weight: 1.0 });
student.addCourse({ grade: 3.7, weight: 0.5 });
student.addCourse({ grade: 3.0, weight: 1.0 });
student.addCourse({ grade: 4.0, weight: 0.5 });

console.log(`졸업 평점은 ${student.grade} 입니다`);
