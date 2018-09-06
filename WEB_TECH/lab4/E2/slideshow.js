var index = 0;
prev();
next();
function prev() {
    var x = document.getElementById("nitk");
    var y = document.getElementById("imgnum");
    var images = ["./nitk1.jpeg", "./nitk2.jpeg", "./nitk3.jpeg", "./nitk4.jpeg", "./nitk5.jpeg"];
    var len = images.length;
    if (index == 0) {
        x.src = images[len - 1];
        index = len - 1;
    }
    else {
        x.src = images[index - 1];
        index = index - 1;
    }
    var ind = index + 1;
    y.innerHTML = ind + "/5";
}

function next() {
    var x = document.getElementById("nitk");
    var y = document.getElementById("imgnum");
    var images = ["./nitk1.jpeg", "./nitk2.jpeg", "./nitk3.jpeg", "./nitk4.jpeg", "./nitk5.jpeg"];
    var len = images.length;
    if (index == len - 1) {
        x.src = images[0];
        index = 0;
    } else {
        x.src = images[index + 1];
        index = index + 1;
    }
    var ind = index + 1;
    y.innerHTML = ind + "/5";
}