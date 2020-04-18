/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function myFunction(x) {
    if (document.getElementById("xbutton").innerHTML === "Next") {
        var b = parseFloat(x, 10) + 1;
        var xremove = document.getElementById(b);
        var xadd = document.getElementById(x);
        xadd.classList.add("hidden");
        xremove.classList.remove("hidden");
        document.getElementById("nowQues").value = b;
    } else {
        document.getElementById("takeQuizSubmit").submit();
    }
    if (document.getElementById("nowQues").value === document.getElementById("numberOfQues").value)
        document.getElementById("xbutton").innerHTML = "Submit";
}

var button = document.getElementById("xbutton");
button.onclick = function ()
{
    myFunction(document.getElementById('nowQues').value);
};

this.testing =1;
window.onbeforeunload = function () {
    if (testing !== 0)
        return "";
};