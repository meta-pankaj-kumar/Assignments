function goToRegForm() {
    document.getElementById('index').style.display = 'none';
    document.getElementById('top').style.display = 'block';
    document.getElementById('RegistrationForm').style.display = 'block';
}
function submitRegForm() {
    if (validateRegistrationForm()) {
        var regForm = document.getElementById('RegistrationForm');
        var val = document.getElementById('EmployeeId').value;
        document.getElementById('RegNo').innerHTML = val;
        document.getElementById('RegistrationForm').style.display = 'none';
        document.getElementById('VehicleForm').style.display = 'block';
    }
}
function submitVehicleForm() {
    if (validateVehicleForm()) {
        document.getElementById('VechicleId').innerHTML = document.getElementById('VehicleType').value;
        document.getElementById('RegistrationNumber').innerHTML = document.getElementById('EmployeeId').value;
        document.getElementById('VehicleForm').style.display = 'none';
        document.getElementById('PlanForm').style.display = 'block';
    }
}
function priceCalculator() {
    var category = document.getElementById('VehicleType').value;
    var currency = document.getElementById('Currency').value;
    var parkingRate = [
        [convertToUSD(5), convertToUSD(100), convertToUSD(500)],
        [convertToUSD(10), convertToUSD(200), convertToUSD(1000)],
        [convertToUSD(20), convertToUSD(500), convertToUSD(3500)]
    ];
    var row;
    if (category == "Bicycle") {
        row = 0;
    }
    else if (category == "Two Wheeler") {
        row = 1;
    }
    else if (category == "Four Wheeler") {
        row = 2;
    }
    if (currency == "YEN") {
        document.getElementById('WeeklyPrice').innerHTML = (convertToYEN(parkingRate[row][0]));
        document.getElementById('MonthlyPrice').innerHTML = (convertToYEN(parkingRate[row][1]));
        document.getElementById('YearlyPrice').innerHTML = (convertToYEN(parkingRate[row][2]));
    }
    else if (currency == "INR") {
        document.getElementById('WeeklyPrice').innerHTML = (convertToINR(parkingRate[row][0]));
        document.getElementById('MonthlyPrice').innerHTML = (convertToINR(parkingRate[row][1]));
        document.getElementById('YearlyPrice').innerHTML = (convertToINR(parkingRate[row][2]));
    }
    else if (currency == "USD") {
        document.getElementById('WeeklyPrice').innerHTML = (parkingRate[row][0]);
        document.getElementById('MonthlyPrice').innerHTML = (parkingRate[row][1]);
        document.getElementById('YearlyPrice').innerHTML = (parkingRate[row][2]);
    }
}
function convertToUSD(value) {
    return (value / 70);
}
function convertToINR(value) {
    return (value * 70);
}
function convertToYEN(value) {
    return (value * 105);
}
function submitPlanForm() {
    if (validatePlanForm()) {
        document.getElementById('RegistrationNumberPreFinalForm').innerHTML = document.getElementById('EmployeeId').value;
        document.getElementById('FirstNameDisplay').innerHTML = document.getElementById('FirstName').value;
        document.getElementById('LastNameDisplay').innerHTML = document.getElementById('LastName').value;
        document.getElementById('GenderDisplay').innerHTML = getRadioButtonvalue('Gender');
        document.getElementById('EmailDisplay').innerHTML = document.getElementById('EmailId').value;
        document.getElementById('ContactNumberDisplay').innerHTML = document.getElementById('ContactNumber').value;
        document.getElementById('VehicleTypeDisplay').innerHTML = document.getElementById('VehicleType').value;
        document.getElementById('VehicleNameDisplay').innerHTML = document.getElementById('VehicleName').value;
        document.getElementById('VehicleNumberDisplay').innerHTML = document.getElementById('VehicleNumber').value;
        document.getElementById('PlanDisplay').innerHTML = getRadioButtonvalue('Plan');
        document.getElementById('CurrencyDisplay').innerHTML = document.getElementById('Currency').value;
        document.getElementById('RegistrationNumber').innerHTML = document.getElementById('EmployeeId').value;
        document.getElementById('VechicleId').innerHTML = document.getElementById('VehicleType').value;
        document.getElementById('PlanForm').style.display = 'none';
        document.getElementById('PreConfirmForm').style.display = 'block';
    }
}
function getRadioButtonvalue(divId) {
    var div = document.getElementsByName(divId);
    var divValue = "";
    for (var index = 0; index < div.length; index++) {
        if (div[index].checked) {
            divValue = div[index].value;
        }
    }
    return divValue;
}
function submitPreConfirmForm() {
    document.getElementById('RegistrationNumberFinalForm').innerHTML = document.getElementById('EmployeeId').value;
    document.getElementById('VehicleNumberFinalForm').innerHTML = document.getElementById('VehicleNumber').value;
    document.getElementById('PreConfirmForm').style.display = 'none';
    document.getElementById('ConfirmForm').style.display = 'block';
}
function cancelForm() {
    document.location.reload(true);
}
function validateRegistrationForm() {
    if (document.getElementById('FirstName').value == "" ||
        document.getElementById('LastName').value == "" ||
        getRadioButtonvalue('Gender') == "" ||
        document.getElementById('EmployeeId').value == "" ||
        document.getElementById('EmailId').value == "" ||
        document.getElementById('Password').value == "" ||
        document.getElementById('ConfirmPassword').value == "" ||
        document.getElementById('ContactNumber').value == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    if (document.getElementById('FirstName').value.length < 2) {
        alert("First Name should contain Atleast Two Characters");
        return (false);
    }
    if (!document.getElementById('FirstName').checkValidity()) {
        alert("First Name should contain only Alphabets");
        return (false);
    }
    if (document.getElementById('LastName').value.length < 2) {
        alert("Last Name should contain Atleast Two Characters");
        return (false);
    }
    if (!document.getElementById('LastName').checkValidity()) {
        alert("Last Name should contain only Alphabets");
        return (false);
    }
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.getElementById('EmailId').value))) {
        alert("You have entered an invalid email address!");
        return (false);
    }
    if (!document.getElementById('Password').value.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/)) {
        alert("Invalid Password !!! Password should contain 8 - 15 characters having one Capital letter , one Small letter , one numeric digit and one Special Character");
        return (false);
    }
    if (document.getElementById('Password').value != document.getElementById('ConfirmPassword').value) {
        alert("Password Mismatch Try Again!!!!");
        return (false);
    }
    if (!document.getElementById('ContactNumber').checkValidity()) {
        alert("Contact Number Should Contain 8-10 digits");
        return (false);
    }
    return true;
}
function validateVehicleForm() {
    if (document.getElementById('VehicleName').value == "" ||
        document.getElementById('VehicleType').value == "" ||
        document.getElementById('VehicleNumber').value == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    return true;
}
function validatePlanForm() {
    if (document.getElementById('Currency').value == "" ||
        getRadioButtonvalue('Plan') == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    return true;
}
