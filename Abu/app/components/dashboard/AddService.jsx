var React = require('react');
var AddServiceForm = require('AddServiceForm');
var AddService = React.createClass({
    getInitialState: function () {
        return {

        };
    },
    onAddClick: function(evt){
        this.props.onHandleClick(evt);
    },
    render: function () {

        return (
            <div>
                <button type="button" className="btn btn-default" data-toggle="modal" data-target="#myModal" onClick={this.onAddClick}>Add Service</button>
                <div className="modal fade" id="myModal" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 className="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <div className="modal-body">
                                <AddServiceForm />
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" className="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

module.exports = AddService;