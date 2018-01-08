var date = new Date();
var months = ["Sausio", "Vasario", "Kovo", "Balandžio", "Gegužės",
"Birželio", "Liepos", "Rugpjutčio", "Rugsejo", "Spalio", "Lapkričio", "Gruodžio"]
var week = ["Sekmadienis", "Pirmadienis", "Antradienis", "Trečiadienis", "Ketvirtadienis",
 "Penktadienis", "Šeštadienis"]
var i = months[parseInt(date.getMonth())] + " "
var day = week[parseInt(date.getDay())] + " "
document.getElementById("p1").innerHTML=date.getFullYear() + " metų " + i + 
date.getDate() +" Diena , " + day
//formatas 2017 metu spalio 10 diena, penktadenis

//DOM
var lenta = document.getElementById("TableContainer");
var x = document.createElement('TABLE');
var t = document.createElement("TH")
var head = ["State", "Capital", "Abbr", ]
var row1 = ["Arizona","Phoenix","AZ"]
var row2 = ["California", "Sacramento", "CA"]
var row3 = ["Mane", "Augusta", "ME"]
var row4 = ["Monana", "Helena", "MT"]
var row5 = ["New York", "Albany", "NY"]
x.style.background = "green";

for(var i = 0; i < 6; i++){
    var tr = x.insertRow();
    for(var j = 0; j < 3; j++){
        var td = tr.insertCell();
        newFunction();
            
            
            }
        }
    

lenta.appendChild(x, t)



function newFunction() {
    if(i == 0) {
        td.appendChild(document.createTextNode(head[j]));
        td.style.fontWeight = "900";
}
    if(i == 1) {
        td.appendChild(document.createTextNode(row1[j]));
        td.style.background = "gold";
}
    if ( i == 2){
        td.appendChild(document.createTextNode(row2[j]));
        td.style.background = "gold";
}
    if ( i == 3){
        td.appendChild(document.createTextNode(row3[j]));
        td.style.background = "gold";
}
    if ( i == 4){
        td.appendChild(document.createTextNode(row4[j]));
        td.style.background = "gold";
}
    if ( i == 5){
        td.appendChild(document.createTextNode(row5[j]));
        td.style.background = "gold";
}
}

//Knyga


function Book (title, author, publisher) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.pageNumber = 0;
    this.pgUp = nextPage();
    this.pgDown = previousPage();

}

function nextPage (){
    this.pageNumber++;
    document.getElementById("page").innerHTML= this.pageNumber;

}
function previousPage (){
    this.pageNumber--;
    document.getElementById("page").innerHTML= this.pageNumber;

}


var newBook = new Book ("A Dark Lure", "Loreth Anne White", "What ever")

document.getElementById("book_info").innerHTML = "<b>"+ newBook.title + "<br>" + newBook.author + "<br>" + newBook.publisher

document.getElementById("page").innerHTML= newBook.pageNumber;

//rectangle
function rectangle (width, lenght){
    this.length = lenght
    this.width = width
    document.getElementById("space").innerHTML=rectangle.print();

}
var rectangle = parseInt(document.getElementById('length').value);
parseInt(document.getElementById("width").value);

rectangle.prototype.prints = function(){
return "perimeter is: " + this.perimeter + " " + "Space is: " + this.space;
}


    



