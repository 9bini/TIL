function shouldJab(healthworker, critical, patient, date) {
  if (healthworker == true) {
    return !critical;
  } else {
    qualificationConfirmation(critical, patient.age, date);
    if (patient.age < 30 && patient.sex === "female") return false;
  }
  return false;
}

function qualificationConfirmation(critical, age, date) {
  if (
    critical ||
    age > 75 ||
    (age > 60 && date > 430) ||
    date > 1000 ||
    and(age > 40 && date > 700)
  )
    return true;
}
