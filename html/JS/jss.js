//1
document.write("trans"+"por"+"tation");
//2
document.getElementById('p1').innerHTML="pls";
document.getElementById('p1').style.color="red";
document.getElementById('p1').style.fontFamily="sans";
document.getElementById('p1').style.fontSize="30px";
//3
function myFunction(){
var person = prompt("please enter your name");

    if(person !=null){
        document.getElementById("vardas").innerHTML = "hello " + person
        + " how are you today?";
        document.getElementById("vardas").style.color="gold";
        document.getElementById("vardas").style.fontSize="20px";
    }
}
//4
function ageFunc(){
    var young = prompt("pease enter your age");

    if (young > 20){
        document.write("Old man")
    } else if (young < 12) {
        document.write("so young")
    } else{
        document.write("Tenagers Rock!")
    }
}
//5
function dissCount(){
    var old = prompt("pease enter your age");
    var price = prompt("pease enter the price");

    if (old > 60){
    price =price * 0.85;
    document.write("Kaina yra: ", price)
    } else {
        document.write("kaina yra: ", price)
    }
}
//6
function age(){
    var age = prompt("pease enter your age");
    var age2 = parseInt(age)
    document.write("after 30 years you will be: ", age2 + 30)
}
//7 HTML VIDUJE
//8
function color(){
    document.getElementById("8").style.backgroundColor="yellow";
    document.getElementById("8").style.color="blue"
}
//8.1
function custom(){
    var txtColor = prompt("please enter color")
    var back = prompt ("please enter background color")
    document.getElementById("8").style.color=txtColor;
    document.getElementById("8").style.backgroundColor=back;
}
//9

var img = document.getElementById("imgm")

function on(sun){
    sun.src="sun2.jpg";
    
    
}
function off(sun){
    sun.src="sun1.jpg";
}
