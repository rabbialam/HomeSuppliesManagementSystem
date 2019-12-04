let f=()=>{

var modal = document.getElementById('myModal');



var span = document.getElementsByClassName("close")[0];
 


span.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

document.getElementById("logout-button").onclick = function () {
    location.href = "../Login/login.html";
};

}

