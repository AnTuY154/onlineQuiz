/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
//
//var x = document.getElementById("AddressDelete").value;
//if (x !== null) {
//    var button = document.getElementById("xdelete"+x);
//}

//var button=document.getElementsByName("xdelete");
//button.onclick = function ()
//{
//    testing = 1;
//};

function change(){
    testing=1;
}
this.testing = 0;
window.onbeforeunload = function () {
    if (testing !== 0) {
        testing = 0;
        return false;
    }
};
