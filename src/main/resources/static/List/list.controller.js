var app =angular.module('myApp',[]);
app.controller('ItemsController',['$scope','$http',function($scope,$http){
    $scope.newItemName="";
    $scope.items=[];
    $scope.itemIndex=-1;
    $scope.isUpdateModal=false;
            $http({
                        url: "http://localhost:9080//getItems?userName=aditi",
                        method: "GET",
                        headers: {'Content-Type':'application/json'}
                    })
                    .then(function(response) {
                           $scope.items=response.data['OK']
                           if($scope.items == null){
                           $scope.items=[]
                           }
                            // success
                          ;
                    },
                    function(response) { // optional
                            // failed
                            $scope.items=[]
                            ;
                    });
    var modal = document.getElementById('myModal');
    $scope.addItem = function (index,titleValue) {
        if($scope.newItemName != null || $scope.newItemName != ""){
           $scope.items.push($scope.newItemName);
           var obj = new Object();
           obj.userName = "Aditi";
           obj.itemDescription  = $scope.newItemName;
           var jsonString= JSON.stringify(obj);

            modal.style.display = "none";

             $http({
                                    url: "http://localhost:9080//addItem?userName=aditi",
                                    method: "POST",
                                    headers: {'Content-Type':'application/json'},
                                    data: jsonString
                                })
                                .then(function(response) {

                                        // success
                                        $scope.newItemName="";
                                      ;
                                },
                                function(response) { // optional
                                        // failed
                                        $scope.newItemName="";
                                        ;
                                });
        }
    }

    $scope.deleteItem = function (index) {
      var obj = new Object();
               obj.userName = "Aditi";
               obj.itemDescription  = $scope.items[index];
               var jsonString= JSON.stringify(obj);

                modal.style.display = "none";

                 $http({
                                        url: "http://localhost:9080//deleteItem?userName=aditi",
                                        method: "POST",
                                        headers: {'Content-Type':'application/json'},
                                        data: jsonString
                                    })
                                    .then(function(response) {

                                            // success
                                         $scope.items.splice(index, 1);
                                    },
                                    function(response) { // optional
                                            // failed
                                            ;
                                    });

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