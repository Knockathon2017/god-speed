var React = require('react');
var SearchService = require('SearchService');
var AddService = require('AddService');

var Header = React.createClass({
    getInitialState: function () {
        return {

        };
    },
    handlerAddServiceClick: function(evt){
        this.props.onAddServiceClick();
    },
    handlerAddService: function(evt){
        console.log("eshu")
        this.props.onAddServiceSuccessClick();
    },
    render: function () {

        return (
            <div className="nav-patch">
                <nav className="navbar navbar-default no-radius remove-border border-bottom-black">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span className="sr-only">Toggle navigation</span>
                                <span className="icon-bar"></span>
                                <span className="icon-bar"></span>
                                <span className="icon-bar"></span>
                            </button>
                            <a className="navbar-brand" href="#">
                                <img id="team-logo" className="img img-responsive" src="../img/spss-logo.png" alt="Team Logo"/>
                            </a>
                        </div>
                        <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <SearchService/>
                            <ul className="nav navbar-nav navbar-right">
                               	<li><AddService onHandleClick={this.handlerAddServiceClick} onAddingService={this.handlerAddService}/></li>
                                <li className="dropdown">
                                    <a href="#" className="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dhruv Pal <span className="caret"></span></a>
                                    <ul className="dropdown-menu">
                                        <li><a href="#">Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        
                    </div>
                </nav>
            </div>
        );
    }
});

module.exports = Header;