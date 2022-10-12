var selectedRow = null

function onFormSubmit(e) {
    event.preventDefault();
    var formData = readFormData();
    if (selectedRow == null){
        insertNewRecord(formData);
    }
    else{
        updateRecord(formData);
    }
    resetForm();
}

//list data
function readFormData() {
    var formData = {};
    formData["id"] = document.getElementById("id").value;
    formData["location"] = document.getElementById("location").value;
    formData["guest"] = document.getElementById("guest").value;
    formData["tourism"] = document.getElementById("tourism").checked;
    formData["transport"] = document.getElementById("transport").checked;
    formData["checkin"] = document.getElementById("checkin").value;
    formData["checkout"] = document.getElementById("checkout").value;
    formData["price"] = document.getElementById("price").value;
    return formData;
}

//insert(admin)
function insertNewRecord(data) {
    var table = document.getElementById("storeList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);

    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.id;

    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.location;

    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.guest;

    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.tourism;

    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.transport;

    cell6 = newRow.insertCell(5);
    cell6.innerHTML = data.checkin;

    cell7 = newRow.insertCell(6);
    cell7.innerHTML = data.checkout;

    cell8 = newRow.insertCell(7);
    cell8.innerHTML = data.price;

    cell9 = newRow.insertCell(8);
    cell9.innerHTML = `<button onClick="onEdit(this)">Modificar acompañantes</button> <button type="cancel" onClick="onDelete(this)">Cancelar reserva</button> <button type="pay" onClick="">$</button>`;
}

//edit(admin)
function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("id").value = selectedRow.cells[0].innerHTML;
    document.getElementById("location").value = selectedRow.cells[1].innerHTML;
    document.getElementById("guest").value = selectedRow.cells[2].innerHTML;
    document.getElementById("tourism").value = selectedRow.cells[3].innerHTML;
    document.getElementById("transport").value = selectedRow.cells[4].innerHTML;
    document.getElementById("checkin").value = selectedRow.cells[5].innerHTML;
    document.getElementById("checkout").value = selectedRow.cells[6].innerHTML;
    document.getElementById("price").value = selectedRow.cells[7].innerHTML;
}
function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.id;
    selectedRow.cells[1].innerHTML = formData.location;
    selectedRow.cells[2].innerHTML = formData.location;
    selectedRow.cells[3].innerHTML = formData.tourism;
    selectedRow.cells[4].innerHTML = formData.transport;
    selectedRow.cells[5].innerHTML = formData.checkin;
    selectedRow.cells[6].innerHTML = formData.checkout;
    selectedRow.cells[7].innerHTML = formData.price;
}

//cancel booking
function onDelete(td) {
    if (confirm('¿Estás seguro de que quieres cancelar la reserva?')) {
        row = td.parentElement.parentElement;
        document.getElementById('storeList').deleteRow(row.rowIndex);
        resetForm();
    }
}

//reset data
function resetForm() {
    document.getElementById("id").value = '';
    document.getElementById("location").value = '';
    document.getElementById("guest").value = '';
    document.getElementById("tourism").checked = 'FALSE';
    document.getElementById("transport").checked = 'FALSE';
    document.getElementById("checkin").value = '';
    document.getElementById("checkout").value = '';
    document.getElementById("price").value = '';
    selectedRow = null;
}
