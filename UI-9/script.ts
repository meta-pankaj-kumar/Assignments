function goToRegForm() {
    document.getElementById('index').style.display = 'none';
    document.getElementById('top').style.display = 'block';
    document.getElementById('RegistrationForm').style.display = 'block';
}
function submitRegForm() {
    if (validateRegistrationForm()) {
        let regForm: any = document.getElementById('RegistrationForm');
        let val: any = (<HTMLInputElement>document.getElementById('EmployeeId')).value;
        document.getElementById('RegNo').innerHTML = val;
        document.getElementById('RegistrationForm').style.display = 'none';
        document.getElementById('VehicleForm').style.display = 'block';
    }
}
function submitVehicleForm() {
    if (validateVehicleForm()) {
        document.getElementById('VechicleId').innerHTML = (<HTMLInputElement>document.getElementById('VehicleType')).value;
        document.getElementById('RegistrationNumber').innerHTML = (<HTMLInputElement>document.getElementById('EmployeeId')).value;
        document.getElementById('VehicleForm').style.display = 'none';
        document.getElementById('PlanForm').style.display = 'block';
    }
}
function priceCalculator() {
    let category: String = (<HTMLInputElement>document.getElementById('VehicleType')).value;
    let currency: String = (<HTMLInputElement>document.getElementById('Currency')).value;
    let parkingRate: number[][] = [
        [convertToUSD(5), convertToUSD(100), convertToUSD(500)],
        [convertToUSD(10), convertToUSD(200), convertToUSD(1000)],
        [convertToUSD(20), convertToUSD(500), convertToUSD(3500)]];
    let row: number;
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
        document.getElementById('WeeklyPrice').innerHTML = (convertToYEN(parkingRate[row][0])) as unknown as string;
        document.getElementById('MonthlyPrice').innerHTML = (convertToYEN(parkingRate[row][1])) as unknown as string;
        document.getElementById('YearlyPrice').innerHTML = (convertToYEN(parkingRate[row][2])) as unknown as string;
    }
    else if (currency == "INR") {
        document.getElementById('WeeklyPrice').innerHTML = (convertToINR(parkingRate[row][0])) as unknown as string;
        document.getElementById('MonthlyPrice').innerHTML = (convertToINR(parkingRate[row][1])) as unknown as string;
        document.getElementById('YearlyPrice').innerHTML = (convertToINR(parkingRate[row][2])) as unknown as string;
    }
    else if (currency == "USD") {
        document.getElementById('WeeklyPrice').innerHTML = (parkingRate[row][0]) as unknown as string;
        document.getElementById('MonthlyPrice').innerHTML = (parkingRate[row][1]) as unknown as string;
        document.getElementById('YearlyPrice').innerHTML = (parkingRate[row][2]) as unknown as string;
    }
}
function convertToUSD(value: number): number {
    return (value / 70);
}
function convertToINR(value: number): number {
    return (value * 70);
}
function convertToYEN(value: number): number {
    return (value * 105);
}
function submitPlanForm() {
    if (validatePlanForm()) {
        document.getElementById('RegistrationNumberPreFinalForm').innerHTML = (<HTMLInputElement>document.getElementById('EmployeeId')).value;
        document.getElementById('FirstNameDisplay').innerHTML = (<HTMLInputElement>document.getElementById('FirstName')).value;
        document.getElementById('LastNameDisplay').innerHTML = (<HTMLInputElement>document.getElementById('LastName')).value;
        document.getElementById('GenderDisplay').innerHTML = getRadioButtonvalue('Gender');
        document.getElementById('EmailDisplay').innerHTML = (<HTMLInputElement>document.getElementById('EmailId')).value;
        document.getElementById('ContactNumberDisplay').innerHTML = (<HTMLInputElement>document.getElementById('ContactNumber')).value;
        document.getElementById('VehicleTypeDisplay').innerHTML = (<HTMLInputElement>document.getElementById('VehicleType')).value;
        document.getElementById('VehicleNameDisplay').innerHTML = (<HTMLInputElement>document.getElementById('VehicleName')).value;
        document.getElementById('VehicleNumberDisplay').innerHTML = (<HTMLInputElement>document.getElementById('VehicleNumber')).value;
        document.getElementById('PlanDisplay').innerHTML = getRadioButtonvalue('Plan');
        document.getElementById('CurrencyDisplay').innerHTML = (<HTMLInputElement>document.getElementById('Currency')).value;
        document.getElementById('RegistrationNumber').innerHTML = (<HTMLInputElement>document.getElementById('EmployeeId')).value;
        document.getElementById('VechicleId').innerHTML = (<HTMLInputElement>document.getElementById('VehicleType')).value;
        document.getElementById('PlanForm').style.display = 'none';
        document.getElementById('PreConfirmForm').style.display = 'block';
    }
}
function getRadioButtonvalue(divId: string): string {
    let div: any = document.getElementsByName(divId) as unknown as string;
    let divValue: string = "";
    for (let index: number = 0; index < div.length; index++) {
        if (div[index].checked) {
            divValue = div[index].value;
        }
    }
    return divValue;
}
function submitPreConfirmForm() {
    document.getElementById('RegistrationNumberFinalForm').innerHTML = (<HTMLInputElement>document.getElementById('EmployeeId')).value;
    document.getElementById('VehicleNumberFinalForm').innerHTML = (<HTMLInputElement>document.getElementById('VehicleNumber')).value;
    document.getElementById('PreConfirmForm').style.display = 'none';
    document.getElementById('ConfirmForm').style.display = 'block';
}
function cancelForm() {
    document.location.reload(true);
}
function validateRegistrationForm(): Boolean {
    if ((<HTMLInputElement>document.getElementById('FirstName')).value == "" ||
        (<HTMLInputElement>document.getElementById('LastName')).value == "" ||
        getRadioButtonvalue('Gender') == "" ||
        (<HTMLInputElement>document.getElementById('EmployeeId')).value == "" ||
        (<HTMLInputElement>document.getElementById('EmailId')).value == "" ||
        (<HTMLInputElement>document.getElementById('Password')).value == "" ||
        (<HTMLInputElement>document.getElementById('ConfirmPassword')).value == "" ||
        (<HTMLInputElement>document.getElementById('ContactNumber')).value == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    if ((<HTMLInputElement>document.getElementById('FirstName')).value.length < 2) {
        alert("First Name should contain Atleast Two Characters");
        return (false);
    }
    if (!(<HTMLInputElement>document.getElementById('FirstName')).checkValidity()) {
        alert("First Name should contain only Alphabets");
        return (false);
    }
    if ((<HTMLInputElement>document.getElementById('LastName')).value.length < 2) {
        alert("Last Name should contain Atleast Two Characters");
        return (false);
    }
    if (!(<HTMLInputElement>document.getElementById('LastName')).checkValidity()) {
        alert("Last Name should contain only Alphabets");
        return (false);
    }
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test((<HTMLInputElement>document.getElementById('EmailId')).value))) {
        alert("You have entered an invalid email address!");
        return (false);
    }
    if (!(<HTMLInputElement>document.getElementById('Password')).value.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/)) {
        alert("Invalid Password !!! Password should contain 8 - 15 characters having one Capital letter , one Small letter , one numeric digit and one Special Character");
        return (false);
    }
    if ((<HTMLInputElement>document.getElementById('Password')).value != (<HTMLInputElement>document.getElementById('ConfirmPassword')).value) {
        alert("Password Mismatch Try Again!!!!");
        return (false);
    }
    if (!(<HTMLInputElement>document.getElementById('ContactNumber')).checkValidity()) {
        alert("Contact Number Should Contain 8-10 digits");
        return (false);
    }
    return true;
}
function validateVehicleForm(): Boolean {
    if ((<HTMLInputElement>document.getElementById('VehicleName')).value == "" ||
        (<HTMLInputElement>document.getElementById('VehicleType')).value == "" ||
        (<HTMLInputElement>document.getElementById('VehicleNumber')).value == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    return true;
}
function validatePlanForm(): Boolean {
    if ((<HTMLInputElement>document.getElementById('Currency')).value == "" ||
        getRadioButtonvalue('Plan') == "") {
        alert("Mandatory Fields Cannot Be Empty");
        return false;
    }
    return true;
}
