class Person {
  /**
   * constructor와 setter일부는 생략
   */
  get name() {
    return this._name;
  }
}
/**
 * Person 클래스에서 이름을 빼면 Medical 클래스라서 7.5 클래스 출함
 */
class Medical {
  get treatments() {
    return this._treatments;
  }

  get vaccinationRecord() {
    return this._vaccinationRecord;
  }

  // 투약 준비 확인
  isReadyForDose() {
    // 최근 2주간의 medical record를 찾아 백신을 맞을 준비가 되었는지 확인
    let records = this.getLast2WeeksMedicalRecord();
    /* medical.treatments의 record 하나를 검사하여 백신 결격사유가 있는지 확인하는 함수*/
    for (let record of records) if (cannotJab(record)) return false;
    return true;
  }

  // 2주간 의료 기록 조회
  getLast2WeeksMedicalRecord() {
    // Medical을 걸처서 동작하는 게 없어져서 7.8 중개자 제거하기에 포함이 된나??
    let records = this._treatments();
    let date2wAgo = dateTwoWeeksAgo(); // 2주전의 Date를 리턴하는 함수
    return records.filter((record) => record.date >= date2wAgo);
  }
}

/**
 * 예방접종 기록
 */
class VaccinationRecord {
  /**
   * 첫번재 복용량 추가
   */
  get dateFirstDose() {
    return this._dateFirstDose;
  }
  /**
   * 두번째 복용량 추가
   */
  get dateSecondDose() {
    return this._dateSecondDose;
  }
  /**
   * 복용량 추가
   */
  set addDose(date) {
    this._dateSecondDose = date;
  }
  /**
   * 면역성 확인
   */
  get isImmune() {
    return this._dateFirstDose != null && this._dateSecondDose != null;
  }
}

function main(person) {
  const medical = person.medical;
  if (medical.isReadyForDose()) {
    let vRecord = medical.vaccinationRecord();
    vRecord.addDose(new Date());
  }

  console.log(
    `${person.name()} 씨는 면역을 획득${
      vRecord.isImmune() ? "하였" : "하지않았"
    }습니다`
  );
}
