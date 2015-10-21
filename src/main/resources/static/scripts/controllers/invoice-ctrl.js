app.controller('invoice-ctrl', function ($scope, $http, $filter, $modal, ngTableParams, appServices) {

    $scope.searchKeyword = "";
    $scope.getList = function (callback) {

        $http({
            method: 'GET',
            url: '/invoices'
        }).then(function (response) {
            if (typeof response.data._embedded != 'undefined') {

                $scope.invoices = response.data._embedded.invoices;
            }
            else {
                $scope.invoices = [];
            }
            callback.call(this);
        }, function (response) {

        });
    };


    $scope.deleteItem = function (link) {
        var r = confirm("Are you sure you want to delete?")

        if (!r) {
            return
        }

        $http({
            method: 'DELETE',
            url: link
        }).then(function (response) {
            $scope.getList($scope.initTable);
        }, function (response) {

        });
    };

    $scope.initTable = function () {
        $scope.tableParams = new ngTableParams({
            page: 1,
            count: 2000,
            sorting: {
                "waybillNumber": "asc"
            }
        }, {
            counts: [],
            getData: function ($defer, params) {
                appServices.tablePagination($defer, $filter, params, $scope.invoices, $scope.searchKeyword);

            }
        });
    };


    $scope.addEdit = function (action, id) {
        $scope.action = action;
        $scope.selectedId = id;

        $scope.modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: 'pages/modal/invoice.html',
            controller: 'invoiceModalCtrl',
            size: 'md',
            backdrop: 'static',
            resolve: {
                dataToModal: function () {
                    return {
                        action: $scope.action,
                        id: $scope.selectedId,
                        stations: $scope.stations,
                        departments: $scope.departments
                    }
                }
            }
        });

        $scope.modalInstance.result.then(function (modalData) {
            $scope.submitData(modalData);
        }, function () {
            console.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.submitData = function (modalData) {
        dataToSend = modalData.submitData;
        dataToSend.fromDepartment = "departments/" + modalData.submitData.fromDepartment
        dataToSend.toDepartment = "departments/" + modalData.submitData.toDepartment
        dataToSend.fromStation = "stations/" + modalData.submitData.fromStation
        dataToSend.toStation = "stations/" + modalData.submitData.toStation

        if (modalData.action == 'add') {
            $http({
                method: 'POST',
                url: '/invoices',
                data: dataToSend
            }).then(function (response) {
                $scope.getList($scope.initTable);
            }, function (response) {

            });
        }

        else if (modalData.action == 'edit') {
            $http({
                method: 'PUT',
                url: '/invoices/' + $scope.selectedId,
                data: dataToSend
            }).then(function (response) {
                $scope.getList($scope.initTable);
            }, function (response) {

            });
        }
    };

    $scope.getAllStations = function () {
        $http({
            method: 'GET',
            url: '/stations',
            data: {
                page: 1,
                size: 2000,
                sort: 'stationName'
            }
        }).then(function (response) {
            if (typeof response.data._embedded != 'undefined') {
                $scope.stations = response.data._embedded.stations;
            }
            else {
                $scope.stations = [];
            }

        }, function (response) {

        });
    };

    $scope.getAllDepartments = function () {
        $http({
            method: 'GET',
            url: '/departments',
            data: {
                page: 1,
                size: 2000,
                sort: 'name'
            }
        }).then(function (response) {
            if (typeof response.data._embedded != 'undefined') {
                $scope.departments = response.data._embedded.departments;
            }
            else {
                $scope.departments = [];
            }

        }, function (response) {

        });
    };


    $scope.init = function () {
        $scope.getAllStations();
        $scope.getAllDepartments();
        $scope.getList($scope.initTable);
    }

    $scope.init();

});


app.controller('invoiceModalCtrl', function ($scope, $http, $modalInstance, dataToModal) {
    $scope.action = dataToModal.action;
    $scope.departments = dataToModal.departments;
    $scope.stations = dataToModal.stations;
    $scope.fromDepartment = dataToModal.fromDepartment;
    $scope.toDepartment = dataToModal.toDepartment;
    $scope.fromStation = dataToModal.fromStation;
    $scope.toStation = dataToModal.toStation;

    $scope.submitData = {};
    $scope.ok = function () {
        $modalInstance.close({
            submitData: $scope.submitData,
            action: $scope.action
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.getData = function () {
        if ($scope.action == 'edit') {
            $http({
                method: 'GET',
                url: '/invoices/' + dataToModal.id + "?projection=invoice_details"
            }).then(function (response) {
                if (response.status == '200') {
                    $scope.submitData.fare = response.data.fare;
                    $scope.submitData.fromStation = $scope.fromStation;
                    $scope.submitData.toStation = $scope.toStation;
                }

            }, function (response) {

            });
        }
    };

    $scope.init = function () {
        $scope.getData();
    };


    $scope.init();
});