/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

this.testing = 1;
window.onbeforeunload = function () {
    if (testing !== 0)
       return false;
};
var button = document.getElementById("makeQuizButton");
button.onclick = function ()
{ 
 
   testing=0;
   document.getElementById("makeQues").submit();
};
