var React = require('react');
var ServiceList = require('ServiceList');
var Header = require('Header');

var Dashboard = React.createClass({
    getInitialState: function () {
        return {
            searchText: '',
            services: [

            ]
        };
    },
    handleAddService: function () {
        console.log("eshu");
    },
    handleServiceSearch: function (searchText) {
        this.setState({
            searchText: searchText.toLowerCase()
        });
    },
    handleAddSuccessService: function (searchText) {
        debugger;
        this.refs.list.getList();
    },
    render: function () {

        return (
            <div>
                <Header onAddServiceClick={this.handleAddService} onAddServiceSuccessClick={this.handleAddSuccessService}/>
                <ServiceList ref='list' />

            </div>
        )
    }
});

module.exports = Dashboard;