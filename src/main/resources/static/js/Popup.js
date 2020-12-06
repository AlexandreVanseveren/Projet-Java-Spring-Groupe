// Get the modal
var modalcreate = document.getElementById("myModal");
var modalupdate = document.getElementById("ModalUpdate");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
var updtbtn = document.getElementById("updtbtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var updtspan = document.getElementsByClassName("updtclose")[0];


// When the user clicks the button, open the modal
btn.onclick = function() {
    modalcreate.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modalcreate.style.display = "none";
}

updtbtn.onclick = function() {
    modalupdate.style.display = "block";
}

updtspan.onclick = function() {
    modalupdate.style.display = "none";
}



// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modalcreate) {
        modalcreate.style.display = "none";
    }
}


function validateForm() {
    var msg= "",
        fields = document.getElementById("form_id").getElementsByTagName("input");

    for (var i=0; i<fields.length; i++){
        if (fields[i].value === "")
            msg += fields[i].name + ' is required. \n';
    }
    if(msg) {
        alert(msg);
        return false;
    }
    else
        return true;
}