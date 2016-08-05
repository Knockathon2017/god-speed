var React = require('react');
var LoginForm = require('LoginForm');

var Login = React.createClass({
    render: function(){
        return (
            <div>
                <nav className="navbar navbar-default no-radius remove-border border-bottom-black">
                    <div className="container-fluid">
                        <div className="navbar-head er">
                            <a className="navbar-brand" href="#">
                                <img id="team-logo" className="img img-responsive" src="//logo-png.com/logopng/thumbs/spss-logo.png" alt="Team Logo"/>
                            </a>
                        </div>
                    </div>
                </nav>
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
            </div>
        );
    }
});

module.exports = Login;