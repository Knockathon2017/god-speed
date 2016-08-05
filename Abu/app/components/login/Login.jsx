var React = require('react');
var LoginForm = require('LoginForm');

var Login = React.createClass({
    render: function(){
        return (
            <div className="container">
                <div className="row">
                    <div className="col-md-4 col-md-offset-4 stan-pad login-card">
                        <LoginForm />
                    </div>
                    <div className="col-md-4 col-md-offset-4 stan-pad center">
                        <a href="#" className="white-text">Link 1</a>&nbsp;&nbsp;
                        <span className="white-text">|</span>&nbsp;&nbsp;
                        <a href="#" className="white-text">Link 2</a>&nbsp;&nbsp;
                    </div>
                </div>
            </div>
        );
    }
});

module.exports = Login;