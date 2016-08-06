var React = require('react');
var ReactDOM = require('react-dom');
var axios = require('axios');
var config = require('Config');
var Dashboard = require('Dashboard');

const BASE_URL = config.baseUrl;
const loginUrl = BASE_URL+""+config.loginUrl;

const POST_CONFIG = {
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    }
};

var LoginForm = React.createClass({
    getDefaultProps: function(){
        return {
            divStyle: {
                background: "#fff",
                padding: "15px",
                borderRadius: "2pt",
                marginTop: "25vh"
            }
        };
    },
    onloginButtonClick: function(evt){
        evt.preventDefault();
        var usernameTxt = this.refs.username;
        var passwordTxt = this.refs.password;
        var usernameValue = usernameTxt.value.trim();
        var passwordValue = passwordTxt.value.trim();
        if(usernameValue == '' || passwordValue == ''){
            alert("Please enter a valid username/password!!");
            return false;
        }

        axios.post(loginUrl,{username:usernameValue, password:passwordValue}, POST_CONFIG).then(function(res){
            console.log("----unmount-----");
            ReactDOM.unmountComponentAtNode(document.getElementById('app'));
            ReactDOM.render(<Dashboard />, document.getElementById('app'));
        }, function(res){
            alert("error");
        });
    },
    render: function(){
        return (
            <form onSubmit={this.onloginButtonClick}>
                <div className="form-group">
                    <label htmlFor="exampleInputEmail1">Username</label>
                    <input type="email" className="form-control" ref="username" placeholder="Username" />
                </div>
                <div className="form-group">
                    <label htmlFor="exampleInputPassword1">Password</label>
                    <input type="password" className="form-control" ref="password" placeholder="Password" />
                </div>
                <div className="checkbox">
                    <label>
                        <input type="checkbox" /> Remember Me
                    </label>
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
            </form>
        );
    }
});

module.exports = LoginForm;