$(document).ready(function () {
    $("#qnt1").change(function () {
        $("#btn").click();
    });

    $("#qnt2").change(function () {
        $("#btn").click();
    });

    $("#qnt3").change(function () {
        $("#btn").click();
    });

});

function calc() {
    var fm = document.getElementById('form1');
    var qn1 = parseInt(fm.q1.value);
    var qn2 = parseInt(fm.q2.value);
    var qn3 = parseInt(fm.q3.value);

    let ttl = qn1 * 100 + qn2 * 40 + qn3 * 25;

    console.log(ttl);
    console.log(typeof (ttl));
    document.getElementById("total").value = ttl.toString();
}	
