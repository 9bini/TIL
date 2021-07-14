// 전
function getTotalOutstandingAndSendBuill() {
  const result = customer.invoices.reduce(
    (total, each) => each.amount + total,
    0
  );
  sendBill();
  return result;
}
// 후
function totalOutstanding() {
  return customer.invoices.reduce((total, each) => each.amount + total, 0);
}

function sendBill() {
  emailGateway.send(formatBill(customer));
}

// 예시 1
function alertNotMiscreant(peple) {
  for (const p of peple) {
    if (p == "조커") {
      setOffAlarms();
      return "조커";
    }
    if (p === "사루만") {
      setOffAlarms();
      return "사루만";
    }
  }
  return "";
}

// 1. 함수 복제하고 질의 목적에 맞는 이름짓기

function findMiscreant(peple) {
  for (const p of peple) {
    if (p == "조커") {
      setOffAlarms();
      return "조커";
    }
    if (p === "사루만") {
      setOffAlarms();
      return "사루만";
    }
  }
  return "";
}

// 2. 새 질의 함수에서 부수효과 모두 제거하기에

function findMiscreant(peple) {
  for (const p of peple) {
    if (p == "조커") {
      return "조커";
    }
    if (p === "사루만") {
      return "사루만";
    }
  }
  return "";
}

// 5. 질의 관련 코드를 없앤다.
function alertNotMiscreant(peple) {
  for (const p of peple) {
    if (p == "조커") {
      setOffAlarms();
      return;
    }
    if (p === "사루만") {
      setOffAlarms();
      return;
    }
  }
  return "";
}

// 더 가다듬기
function alertNotMiscreant(peple) {
  if (findMiscreant(peple) !== "") setOffAlarms();
}
