/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//alert('Hello');
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
    var myDropdown = document.getElementById("myDropdown");
      if (myDropdown.classList.contains('show')) {
        myDropdown.classList.remove('show');
      }
  }
}

function openNav(){
    document.getElementById("mySidenav").style.width = "250px";
}
function closeNav(){
    document.getElementById("mySidenav").style.width = "0";
}
function popUp(){
    window.alert("I am An Alert Box!");
}