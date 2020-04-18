/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var z = new Date();
var timeWhenStarted = new Date();
timeWhenStarted.setMonth(z.getMonth());
timeWhenStarted.setDate(z.getDate());
timeWhenStarted.setHours(z.getHours());
timeWhenStarted.setMinutes(z.getMinutes());
timeWhenStarted.setSeconds(z.getSeconds());
var countDownDate = timeWhenStarted.getTime();
var x = setInterval(function () {
    var now = new Date().getTime();
    var TotalTimeDoQuiz = parseInt(document.getElementById("time").value, 10);
    var distance = countDownDate - now + TotalTimeDoQuiz;
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
// Output the result in an element with id="demo"
    document.getElementById("demo").innerHTML = days + hours + minutes + ":" + seconds;
// If the count down is over, write some text 
    if (distance < 0) {
        document.getElementById("takeQuizSubmit").submit();
        document.getElementById("demo").innerHTML = "";
        clearInterval(x);

    }
}, 1000);

