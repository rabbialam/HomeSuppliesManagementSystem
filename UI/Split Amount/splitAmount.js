var app =angular.module('listApp',[]);
app.controller('splitAmountController',['$scope','$http',function($scope,$http){
var group = $http.get("http://localhost:9080/api/getUserGroup")
console.log(group)
$scope.groupId=1;
$scope.paidBy=1;
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

var amount = $scope.itemPrice;
var obj = new Object();
   obj.groupId = 1;
   obj.amount  = amount;
   obj.paidBy = 1;
   var jsonString= JSON.stringify(obj);
 $http({
        url: "http://localhost:9080/api/enterAmount",
        method: "POST",
        headers: {'Content-Type':'application/json'},
        data: jsonString
    })
    .then(function(response) {
            // success
          ;
    },
    function(response) { // optional
            // failed
            ;
    });


}
}]);