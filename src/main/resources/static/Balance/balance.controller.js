var app =angular.module('myApp',[]);

app.controller('balanceController',['$scope','$http',function($scope,$http){
    $scope.newItemName="";
    $scope.items=[];
    $scope.itemIndex=-1;
    $scope.isUpdateModal=false;
    $scope.transactions=[];
        $http({
                    url: "http://localhost:9080/api/getUnsettledTransactions/1",
                    method: "GET",
                    headers: {'Content-Type':'application/json'}
                })
                .then(function(response) {
                       $scope.transactions=response.data
                        // success
                      ;
                },
                function(response) { // optional
                        // failed
                        ;
                });
    /*$scope.getTransaction=function(){
     var transactions = $http.get("http://localhost:9080/api/getUnsettledTransactions/1")
     $scope.transactions=transactions;
    }*/
    $scope.groupId=1;
    $scope.settleBalance=function(){

        var obj = new Object();
        obj.groupId = 1;
        var jsonString= JSON.stringify(obj);

         $http({
                url: "http://localhost:9080/api/settleAmount",
                method: "POST",
                headers: {'Content-Type':'application/json'},
                data: jsonString
            })
            .then(function(response) {
                   $scope.itemPrice=0;
                   $scope.itemNAme='Balance added .Want to add another??'
                    // success
                  ;
            },
            function(response) { // optional
                    // failed
                    ;
            });
    }

    var modal = document.getElementById('myModal');
    $scope.addItem = function (index,titleValue) {
        if($scope.newItemName != null || $scope.newItemName != ""){
            $scope.items.push({
                id: $scope.items.length + 1,
                title: $scope.newItemName
            });
            $scope.newItemName="";
            modal.style.display = "none";
        }
    }

    $scope.deleteItem = function (index) {
        $scope.items.splice(index, 1);
    }

    $scope.openItem = function (index) {
        $scope.isUpdateModal = true;
        $scope.itemIndex = index;
        
        var key = Object.keys($scope.items)[index];
        $scope.newItemName = $scope.items[key].title;

        modal.style.display = "block";
        var span = document.getElementsByClassName("close")[1];

    span.onclick = function() {
        $scope.isUpdateModal=false;
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            $scope.isUpdateModal=false;
            modal.style.display = "none";
        }
    }
    }
    $scope.updateItem=function(){
        if($scope.newItemName != null || $scope.newItemName != ""){
            $scope.items.splice($scope.itemIndex,1,{
                id: $scope.itemIndex,
                title:$scope.newItemName
            });
            modal.style.display="none";
            $scope.isUpdateModal=false;
            $scope.newItemName="";
        }
    }

    $scope.setItemNameEmpty = function() {
        $scope.isUpdateModal=false;
        $scope.newItemName="";
    }

}]);