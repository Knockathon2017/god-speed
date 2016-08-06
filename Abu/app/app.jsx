var React = require('react');
var ReactDOM = require('react-dom');
var $ = require('jquery');
var {Route, Router, IndexRoute, hashHistory} = require('react-router');

var Login = require('Login');
var Dashboard = require('Dashboard');
var LogDisplay = require('LogDisplay');

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/" component={Dashboard}>
        </Route>
    </Router>,
    document.getElementById("app")
);