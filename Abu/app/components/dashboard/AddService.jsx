var React = require('react');
var AddServiceForm = require('AddServiceForm');
var AddService = React.createClass({
    componentDidMount: function(){
        $('#myModal').on('hidden.bs.modal', function () {
            $(this).find("input,textarea,select").val('').end();
        });
    },
    getInitialState: function () {
        return {

        };
    },
    onAddClick: function(evt){
        this.props.onHandleClick(evt);
    },
    onAddingService: function(evt){
        this.props.onAddingService(evt);
    },
    closePopup: function(evt){
        //$('#myModal').modal('toggle');
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
                            </div>
                            <div className="modal-body no-pad">
                                <AddServiceForm onSuccessAddingService={this.onAddingService} closePopup={this.closePopup}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

module.exports = AddService;