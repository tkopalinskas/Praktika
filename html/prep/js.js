var air = document.getElementById("date")
console.log("helo");


    var xhr = new XMLHttpRequest;
    xhr.open('POST', 'http://api.openweathermap.org/data/2.5/weather?q=Vilnius&APPID=8951ac77181eabc7211f83c9bf7bb79c', true)
    xhr.addEventListener('readystatechanged', function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        var obj = JSON.parse(xhr.responseText)
        air.innerHTML = obj.main.temp;

        console.log("helo");
    }
},false)

xhr.send();
