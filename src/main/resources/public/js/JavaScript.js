var friendimg = {detail:[ 
    {"friendName":"Ivy", "img":"image/f1.jpg"},
    {"friendName":"Allen","img":"image/f2.jpg"},
    {"friendName":"Jack", "img":"image/f3.jpg"},
    {"friendName":"Bob", "img":"image/f4.jpg"},
    {"friendName":"Edson", "img":"image/f5.jpg"},
    {"friendName":"Maria", "img":"image/f6.jpg"},
    {"friendName":"Rose", "img":"image/f7.jpg"}
]};

window.onload = function() {
  showFriend();
};

function showFriend() {
    var out = "";
    var i;
    for(i = 0; i < friendimg.detail.length; i++) {
        out += '<div class="showStyle"><img src="' + friendimg.detail[i].img + '"/></br>' + 
        friendimg.detail[i].friendName + '</br><button value="' +friendimg.detail[i].friendName +'"' + 'onclick="CheckAndDeleteFriend(this.value)">Unfollow</botton></div>';
    }
    document.getElementById("showFriendList").innerHTML = out;
}

function CheckAndDeleteFriend(value){
     response = confirm("Are you sure you want to delete "+value+"?");
     if (response === true){
         for(i=0;i<=friendimg.detail.length;i++){
             if(friendimg.detail[i].friendName === value){
                 friendimg.detail.splice(i, 1);
                 showFriend();    
                 alert(value+" is no longer your friend:/");
             }
         }
     }  
}


