var React = require('react');
var axios = require('axios');
var config = require('Config');

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
            
        alert("send to server username="+usernameValue+"     password="+passwordValue);
        // axios.post(loginUrl,{username:usernameValue, password:passwordValue}, POST_CONFIG).then(function(res){
        //     console.log("-----success------"+res.data);
        // }, function(res){
        //     console.log("-----error------");
        // });

        axios.get(loginUrl).then(function(res){
            console.log("-----success------"+res.data);
        }, function(res){
            console.log("-----error------");
        });
    },
    render: function(){
        return (
            <form onSubmit={this.onloginButtonClick}>
                <div className="form-group">
                    <label for="exampleInputEmail1">Username</label>
                    <input type="email" className="form-control" ref="username" placeholder="Username" />
                </div>
                <div className="form-group">
                    <label for="exampleInputPassword1">Password</label>
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