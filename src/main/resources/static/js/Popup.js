// Get the modal
var modalcreate = document.getElementById("myModal");
// var modalupdate = document.getElementById("ModalUpdate");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
// var updtbtn = document.getElementsByClassName("updtbtn");
// var updtbtn1 = document.$( "button[name*='updtbtn']" );

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// var updtspan = document.getElementsByClassName("updtclose")[0];


// When the user clicks the button, open the modal
btn.onclick = function() {
    modalcreate.style.display = "block";
};
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modalcreate.style.display = "none";
};

// updtbtn.onclick = function() {
//     modalupdate.style.display = "block";
// }
//
// updtspan.onclick = function() {
//     modalupdate.style.display = "none";
// }
//


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modalcreate) {
        modalcreate.style.display = "none";
    }
};


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


$('.updtbtn').on('click',function (event) {

    event.preventDefault();
    $(this).hide();
    $(this).closest('tr').find('.saveprod').show();
    $(this).closest('tr').find('.cancel').show();

    // var test= $(this).parents('tr').find('.idprod').val();
    // $(this).parents('tr').find('.idprod').show();

    $(this).parents('tr').find('.prodnameedit').show();
    $(this).parents('tr').find('.prodname').hide();

    $(this).parents('tr').find('.prodrayonedit').show();
    $(this).parents('tr').find('.prodrayon').hide();

    $(this).parents('tr').find('.prodperempedit').show();
    $(this).parents('tr').find('.prodperemp').hide(); //{

    $(this).parents('tr').find('.prodpriceedit').show();
    $(this).parents('tr').find('.prodprice').hide(); //

    $(this).parents('tr').find('.prodnbedit').show();
    $(this).parents('tr').find('.prodnb').hide(); //{

    // $(this).parents('tr').find('.subedit').show();
    // $(this).parents('tr').find('.sub').hide(); //{

    // alert (test);

});


$('.saveprod').on('click',function (event) {
    event.preventDefault();
    var id = $(this).parents('tr').find('.idprod').val() ;
    var prodname = $(this).parents('tr').find('.prodnameedit').val() ;
    var rayon = $(this).parents('tr').find('.prodrayonedit').val() ;
    var peremption = $(this).parents('tr').find('.prodperempedit').val() ;
    var subfk = $(this).parents('tr').find('.subedit').val() ;
    var statfk = $(this).parents('tr').find('.statedit').val() ;
    var price = $(this).parents('tr').find('.prodpriceedit').val() ;
    var quantities = $(this).parents('tr').find('.prodnbedit').val() ;


    if((prodname === "") || (rayon==="") || (peremption==="") || (subfk==="") || (statfk==="") || (price==="") || (quantities==="") ){
        alert("A Field is Empty")

    } else {
        console.log("Found it");
        $(this).hide();
        $(this).closest('tr').find('.updtbtn').show();
        $(this).closest('tr').find('.cancel').hide();


        $(this).parents('tr').find('.prodnameedit').hide();
        $(this).parents('tr').find('.prodname').show();
        $(this).parents('tr').find('.prodname').text($(this).parents('tr').find('.prodnameedit').val()) ;


        $(this).parents('tr').find('.prodrayonedit').hide();
        $(this).parents('tr').find('.prodrayon').show();
        $(this).parents('tr').find('.prodrayon').text($(this).parents('tr').find('.prodrayonedit').val()) ;


        $(this).parents('tr').find('.prodperempedit').hide();
        $(this).parents('tr').find('.prodperemp').show(); //{
        $(this).parents('tr').find('.prodperemp').text($(this).parents('tr').find('.prodperempedit').val()) ;

        $(this).parents('tr').find('.prodpriceedit').hide();
        $(this).parents('tr').find('.prodprice').show(); //{
        $(this).parents('tr').find('.prodprice').text($(this).parents('tr').find('.prodpriceedit').val()) ;

        $(this).parents('tr').find('.prodnbedit').hide();
        $(this).parents('tr').find('.prodnb').show(); //{
        $(this).parents('tr').find('.prodnb').text($(this).parents('tr').find('.prodnbedit').val()) ;


        $.ajax({
            url: 'product/update/',
            type:'post',
            data  : {
                id : id,
                productname : prodname ,
                rayon : rayon,
                peremption : peremption,
                id_subfk : subfk ,
                id_statfk : statfk,
                price : price ,
                quantities : quantities,
            },
            success:function(data){
                console.log("Updated success");
                console.log(data);
            }
        })
    }
});


$('.cancel').on('click',function (event) {
    event.preventDefault();
    $(this).hide();
    $(this).closest('tr').find('.saveprod').hide();
    $(this).closest('tr').find('.updtbtn').show();

    $(this).parents('tr').find('.prodnameedit').hide();
    $(this).parents('tr').find('.prodname').show();
    $(this).parents('tr').find('.prodnameedit').val($(this).parents('tr').find('.prodname').text()) ;

    $(this).parents('tr').find('.prodrayonedit').hide();
    $(this).parents('tr').find('.prodrayon').show();
    $(this).parents('tr').find('.prodrayonedit').val($(this).parents('tr').find('.prodrayon').text()) ;

    $(this).parents('tr').find('.prodperempedit').hide();
    $(this).parents('tr').find('.prodperemp').show(); //{
    $(this).parents('tr').find('.prodperempedit').val($(this).parents('tr').find('.prodperemp').text()) ;

    $(this).parents('tr').find('.prodpriceedit').hide();
    $(this).parents('tr').find('.prodprice').show(); //{
    $(this).parents('tr').find('.prodpriceedit').val($(this).parents('tr').find('.prodprice').text()) ;

    $(this).parents('tr').find('.prodnbedit').hide();
    $(this).parents('tr').find('.prodnb').show(); //{
    $(this).parents('tr').find('.prodnbedit').val($(this).parents('tr').find('.prodnb').text()) ;

    // $(this).parents('tr').find('.subedit').hide();
    // $(this).parents('tr').find('.sub').show(); //{

});