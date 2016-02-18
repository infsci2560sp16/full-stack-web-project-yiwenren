var friendimg = [  "Lily","Lucy","Anna","Brain","Jack","Adam","Rose","Tom","Jerry","Elsa","Lisa" ];
function showFriend(){
                


            var index;        
            var text = "<ul>";
            for (index = 0; index <friendimg.length; index++){
                text += "<li>" + friendimg[index] + "</li>";                
            }
               text += "</ul>";
                document.getElementById("FriendsList").innerHTML = text;  
             document.getElementById("length").innerHTML  = "<mark>" + friendimg.length + "</mark>"+" friends are avaliable for now!"; 
}

function deleteFriend(){
           var index = friendimg.indexOf(document.getElementById("delete").value);
    if(index !== -1) { // Make sure the value exists
        friendimg.splice(index, 1);
        alert(document.getElementById("delete").value +" has been successfully removed!");
    }       
    
    
}





