var skillapp = angular.module("skillservice", []);
skillapp.controller("ctrl", ['$scope', '$http', function($scope, $http) {
$scope.err_state = false; // Set the default error message state
var fetch_usr_app_url = 'http://localhost:8080/skills/viewall'; // Set the application url to fetch the user details
// Fetches the data from the Spring controller
	$scope.getData = function() {
                    $http({
                        method: "GET",
                        url: fetch_usr_app_url,
                    }).then(function(response) {
                        $scope.skill = response.data.records;
                        console.log("Success");
                    }, function(response) {
                        $scope.err_state = true;
                        console.log("Failure");
                    });
                };
            }]);
