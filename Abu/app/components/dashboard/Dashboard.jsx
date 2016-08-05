var React = require('react');
var ServiceList = require('ServiceList');
var AddService = require('AddService');
var SearchService = require('SearchService');


var Dashboard = React.createClass({
    getInitialState: function () {
        return {
            searchText: '',
            services: [

            ]
        };
    },
    handleAddService: function () {

    },
    handleServiceSearch: function (searchText) {
        this.setState({
            searchText: searchText.toLowerCase()
        });
    },
    render: function () {

        return (
            <div>
                <SearchService />
                <ServiceList />
                <AddService />
            </div>
        )
    }
});

module.exports = Dashboard;