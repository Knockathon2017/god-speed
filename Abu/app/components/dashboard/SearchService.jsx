var React = require('react');

var SearchService = React.createClass({
    getInitialState: function () {
        return {

        };
    },
    render: function () {

        return (
            <form className="navbar-form navbar-left">
                <div className="form-group">
                    <input type="text" className="form-control" placeholder="Search"/>
                </div>
                <button type="submit" className="btn btn-default">Submit</button>
            </form>
        )
    }
});

module.exports = SearchService;