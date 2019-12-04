var app =angular.module('myApp',[]);
app.controller('ItemsController',['$scope',function($scope){
    $scope.newItemName="";
    $scope.items=[];
    $scope.itemIndex=-1;
    $scope.isUpdateModal=false;
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