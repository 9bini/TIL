// 클래스로 묶기
class Trable {
  constructor(travelName, cost, date) {
    this.travelName = travelName;
    this.cost = cost;
    this.date = date;
  }
  // 함수 추출
  showInfo() {
    console.log("=============");
    console.log(
      `You had a travel ${this.travelName} at ${this.date} at a cost of ${this.cost}`
    );
    console.log("=============");
  }
  // 함수 추출
  reimbursement() {
    return this.cost > 100 ? 100 : this.cost;
  }
}

// 클래스로 묶기
class Accommodation {
  constructor(site, cost, date) {
    this.site = site;
    this.cost = cost;
    this.date = date;
  }
  // 함수 추출
  showInfo() {
    console.log("=============");
    console.log(
      `You had a sleep in ${this.site} at ${this.date} at a cost of ${this.cost}`
    );
    console.log("=============");
  }
  // 함수 추출
  reimbursement() {
    return this.cost > 150 ? 150 : this.cost;
  }
}

const travels = [
  new Trable("Flight from ICN to LHR", 500, new Date("2020-03-11")),
  new Trable(
    "Train from LHR airport to Liverpool Street Station",
    30,
    new Date("2020-03-11")
  ),
];

const accommodations = [
  new Accommodation("Goryo Hotel Bucheon", 95, new Date("2020-03-11")),
  new Accommodation("APoint LiverpoolStreet", 100, new Date("2020-03-11")),
];

// 여러 함수를 클래스로 묶기
class Trip {
  constructor(travels, accommodations) {
    this.travels = travels;
    this.accommodations = accommodations;
  }

  tripReimbursement() {
    this.showTripInfo();

    return this.totalReimbursement();
  }
  // 시그니처 변경
  // 변수 인라인
  totalReimbursement() {
    return this.travelsReimbursement() + this.accomodationsReimbursement();
  }

  // 함수 추출
  accomodationsReimbursement() {
    let accomodationsReimbursement = 0;
    accommodations.forEach((accom) => {
      accomodationsReimbursement += accom.reimbursement();
    });
    return accomodationsReimbursement;
  }
  // 함수 추출
  travelsReimbursement() {
    let travelsReimbursement = 0;
    travels.forEach((travel) => {
      travelsReimbursement += travel.reimbursement();
    });
    return travelsReimbursement;
  }
  // 함수 추출
  showTripInfo() {
    this.showTravelsInfo();
    this.showAccommodationsInfo();
  }
  // 함수 추출
  showAccommodationsInfo() {
    this.accommodations.forEach((accom) => {
      accom.showInfo();
    });
  }
  // 함수 추출
  showTravelsInfo() {
    this.travels.forEach((travel) => {
      travel.showInfo();
    });
  }
}
/**
 * 교통수단과 숙박을 출력하고 한도 내에서 환불액을 계산하는 함수
 */

const trip = new Trip(travels, accommodations);
console.log(trip.tripReimbursement());
