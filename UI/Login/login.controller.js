
angular.module('app').controller('loginController',['$scope',function($scope){
debugger;
$scope.username="";
$scope.password="";
$scope.isInvalidLogin=false;
$scope.systemUser=[{
    username: "aditiro",
    password: "aditiro"
},
{
    username: "shwetana",
    password: "shwetana"
}];
$scope.validateUser=function(){
var keys=[];
var usernames=[];
for(var i=0;i<$scope.systemUser.length;i++){
    //keys.push($scope.systemUser.key);
    usernames.push($scope.systemUser[i].username);
}
var counter=-1;
var userKey=-1;
for(var user in usernames){
    if($scope.username == usernames[user]){
            userKey = counter+1;
        break;
    }
    else{
        counter++;
    }
}
    if(userKey!=-1){
        var password = $scope.systemUser[userKey].password;
        if(password != $scope.password){
            //error condition password
            $scope.isInvalidLogin = true;
            $scope.username="";
            $scope.password="";
        }
        else {
            //goto next page
            $scope.isInvalidLogin = false;
            location.href = "#!/list";
        }
    }
    else {
        //error condition for user 
        $scope.isInvalidLogin = true;
        $scope.username="";
        $scope.password="";
    }


}
}]);