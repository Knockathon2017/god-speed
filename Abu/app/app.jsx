var React = require('react');
var ReactDOM = require('react-dom');
var {Route, Router, IndexRoute, hashHistory} = require('react-router');

var Login = require('Login');

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path='/' component={Login}>
        </Route>
    </Router>, 
    document.getElementById("app")
);