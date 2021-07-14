// 전

function score(candidate, medicalExam, scoringGuide) {
    let result = 0;
    let healthLevel = 0;
}

// 후

class Score {

    constructor(candidate, medicalExam, scoringGuide) {
        this._candidate = candidate;
        this._medicalExam = medicalExam;
        this._scoringGuide = scoringGuide;
    }

    execute() {
        this._result = 0;
        this._healtLevel = 0;
    }
}

// 일급함수 보다 더 간단한 방식으로는 얻을 수 없는 기능이 필요할 떄
// 일급함수를 지원하지 않는 언어들이 일급함수 기능이 필요할 떄
//  - 복함한 함수를 잘게 쪼개서 이해하거나 수정하기 쉽게 만들고자 할 때가 있다.

// 예시

function score(candidate, medicalExam, scoringGuide) {
    let result = 0;
    let healthLevel = 0;
    let highMedicalRiskFlag = false;

    if (medicalExam.isSmoker) {
        healthLevel += 10;
        highMedicalRiskFlag = true;
    }

    let certificationGrade = "regular";
    if (scoringGuide.stateWithLowCertification(candidate.originState)) {
        certificationGrade = "low";
        result -= 5;
    }

    result -= Math.max(healthLevel - 5, 0);
    return result;
}

// 1. 빈 클래스를 만들고 2. 이 함수를 그 클래스로 옮기기

class Score {
    execute(candidate, medicalExam, scoringGuide) {
        let result = 0;
        let healthLevel = 0;
        let highMedicalRiskFlag = false;

        if (medicalExam.isSmoker) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }

        let certificationGrade = "regular";
        if (scoringGuide.stateWithLowCertification(candidate.originState)) {
            certificationGrade = "low";
            result -= 5;
        }

        result -= Math.max(healthLevel - 5, 0);
        return result;
    }
}

// 필자는 명령 execute함수에 매개변수를 사용하는 걸 권장하지 않는다.
// 명령의 수명주기나 사용자 정의 기능등을 지원해야 해서 매개변수가 복잡할 때는 아주 편리하다.
class Score {
    constructor(candidate, medicalExam, scoringGuide) {
        this._candidate = candidate;
        this._medicalExam = medicalExam;
        this._scoringGuide = scoringGuide;
    }

    execute() {
        let result = 0;
        let healthLevel = 0;
        let highMedicalRiskFlag = false;

        if (this._medicalExam.isSmoker) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }

        let certificationGrade = "regular";
        if (this._scoringGuide.stateWithLowCertification(this._candidate.originState)) {
            certificationGrade = "low";
            result -= 5;
        }

        result -= Math.max(healthLevel - 5, 0);
        return result;
    }
}


// 더 가다듬기 | 복잡한 함수를 좀더 잘게 나누는 것
// 모든 지역 변수를 필드로 변경

class Score {
    constructor(candidate, medicalExam, scoringGuide) {
        this._candidate = candidate;
        this._medicalExam = medicalExam;
        this._scoringGuide = scoringGuide;
    }

    execute() {
        this._result = 0;
        this._healthLevel = 0;
        this._highMedicalRiskFlag = false;

        if (this._medicalExam.isSmoker) {
            this._healthLevel += 10;
            this._highMedicalRiskFlag = true;
        }

        this._certificationGrade = "regular";
        if (this._scoringGuide.stateWithLowCertification(this._candidate.originState)) {
            this._certificationGrade = "low";
            this._result -= 5;
        }

        this._result -= Math.max(this._healthLevel - 5, 0);
        return this._result;
    }
}

// 함수 추출하기
//  명령을 중첩 함수처럼 다룰 수 있다.
// JS라면 중첩 함수는 명령의 합리적인 대안이 될수있다.
// 필자는 명령을 더 선호 한다. 테스트와 디버깅에 활용

class Score {
    constructor(candidate, medicalExam, scoringGuide) {
        this._candidate = candidate;
        this._medicalExam = medicalExam;
        this._scoringGuide = scoringGuide;
    }

    execute() {
        this._result = 0;
        this._healthLevel = 0;
        this._highMedicalRiskFlag = false;

        this.scoreSmoking();
        this._certificationGrade = "regular";

        if (this._scoringGuide.stateWithLowCertification(this._candidate.originState)) {
            this._certificationGrade = "low";
            this._result -= 5;
        }

        this._result -= Math.max(this._healthLevel - 5, 0);
        return this._result;
    }

    scoreSmoking() {
        if (this._medicalExam.isSmoker) {
            this._healthLevel += 10;
            this._highMedicalRiskFlag = true;
        }
    }
}

